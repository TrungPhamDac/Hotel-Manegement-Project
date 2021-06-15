/*==============================================================*/
/* function : get_TongTien_ThanhToan                           */
/*==============================================================*/
CREATE OR REPLACE FUNCTION get_TongTien_ThanhToan(MADATPHONG_v in PHIEUDATPHONG.MADATPHONG%TYPE)
return THANHTOAN.THANHTIEN%TYPE
AS
    tienphong_v PHIEUDATPHONG.TIENPHONG%TYPE;
    tienhddv_v HOADONDV.THANHTIEN%TYPE;
    tienhdtiec_v HOADONTIEC.THANHTIEN%TYPE;
BEGIN
    SELECT TIENPHONG+PHUPHI-TIENTRATRUOC INTO tienphong_v FROM PHIEUDATPHONG WHERE MADATPHONG = MADATPHONG_v;
    SELECT SUM(THANHTIEN) INTO tienhddv_v FROM HOADONDV WHERE MADATPHONG = MADATPHONG_v AND TINHTRANG = 0 ;
    SELECT SUM(THANHTIEN - TIENTRATRUOC) INTO tienhdtiec_v FROM HOADONTIEC WHERE MADATPHONG=MADATPHONG_v AND TINHTRANG = 0;
    return tienphong_v + tienhddv_v + tienhdtiec_v;
END get_TongTien_ThanhToan;
/



/*==============================================================*/
/* PROCEDURE: INSERT_LUUTRU                           */
/*==============================================================*/
CREATE OR REPLACE PROCEDURE INSERT_LUUTRU
    (tenkh_v in KHACHHANG.TENKH%TYPE,
    cccd_v in KHACHHANG.CCCD%TYPE,
    id_datphong in PHIEUDATPHONG.MADATPHONG%TYPE,
    maphg_v in PHONG.MAPHG%TYPE
    )
AS
    makh_v KHACHHANG.MAKH%TYPE;
    temp KHACHHANG.MAKH%TYPE;
BEGIN
    select MAKH INTO makh_v FROM KHACHHANG WHERE TENKH = tenkh_v AND CCCD = cccd_v;
    if SQL%NOTFOUND
    THEN
        LOOP
            SELECT MAKH_SEQ.NEXTVAL INTO makh_v from dual;
            SELECT MAKH INTO temp FROM KHACHHANG WHERE MAKH = makh_v;
            EXIT WHEN SQL%NOTFOUND;
        END LOOP;
        INSERT INTO KHACHHANG (MAKH, TENKH, CCCD) VALUES (makh_v, tenkh_v,cccd_v);
    END IF;
    INSERT INTO LUUTRU (MADATPHONG, MAKH, MAPHG) VALUES (id_datphong, makh_v, maphg_v);
END INSERT_LUUTRU;
/


/*==============================================================*/
/* function: getAvailableRoom()                           */
/*==============================================================*/
create or replace type room as object(
    MaPHG varchar2(8)
);
/
create or replace type room_t as table of room;
/
CREATE OR REPLACE FUNCTION getAvailableRoom
    (ngaynhan_i in date,
    ngaytra_i in date)
return room_t
as
    result room_t;
begin
    select Room(MAPHG)
    BULK COLLECT
    INTO result
    from PHONG
    WHERE MAPHG IN
        (SELECT MAPHG FROM PHONG
        MINUS
        SELECT MAPHG FROM 
                (SELECT MADATPHONG 
                    FROM PHIEUDATPHONG 
                    WHERE TRUNC(NGAYTRA) < TRUNC(SYSDATE) 
                        OR ( TRUNC(ngaynhan_i) >= TRUNC(NGAYNHAN) AND TRUNC(ngaynhan_i) <= TRUNC(NGAYTRA))
                        OR ( TRUNC(ngaytra_i) >= TRUNC(NGAYNHAN) AND TRUNC(ngaytra_i) <= TRUNC(NGAYTRA) ) 
                    ) A
                JOIN CHITIETDATPHONG B
                on A.MADATPHONG = B.MADATPHONG
        );
    RETURN result;
end getAvailableRoom;
/
/*==============================================================*/
/* function: getCurrentLuuTru()                           */
/*==============================================================*/
create or replace type ThongTinLuuTru as object (
    MaDatPhong number(9),
    MaKH number(9),
    MaPHG varchar2(8),
    TENKH   VARCHAR2(80),
   CCCD  VARCHAR2(13)
);
/
create or replace type ThongTinLuuTru_t as table of ThongTinLuuTru;
/
CREATE OR REPLACE FUNCTION getCurrentLuuTru
return ThongTinLuuTru_t
as
    result ThongTinLuuTru_t;
begin
    select ThongTinLuuTru ( lt.MaDatPhong, k.MaKH, lt.MaPHG, TenKH, CCCD)
    bulk collect
    into result
    from LUUTRU lt,  PHIEUDATPHONG p, KHACHHANG k
    where k.MaKH = lt.MaKH
    and p.MaDatPhong = lt.MaDatPhong
    and p.NgayTra >= trunc(sysdate);
    return result;
end getCurrentLuuTru;
/
--
--CREATE OR REPLACE PROCEDURE UPDATE_DONGIAPHONG_IN_DAY(maloaiphg_i LOAIPHONG.MALOAIPHG%TYPE, dongia_i CHITIETDATPHONG.DONGIA%TYPE)
--AS
--    cursor madatphong_cur as select madatphong from phieudatphong where trunc(ngaydat) = trunc(sysdate)
--BEGIN
--    open madatphong_cur;
--    loop
--        UPDATE CHITIETPHONG SET DONGIAPHONG = dongia_i
--        WHERE MAPHG = 
--END UPDATE_DONGIAPHONG;
--/
    
    
CREATE OR REPLACE PROCEDURE INSERT_DON_DV(maphg_i IN PHONG.MAPHG%TYPE, madv_i IN DANHMUCDICHVU.MADV%TYPE, soluong_i IN HOADONDV.SOLUONG%TYPE, manv_i NHANVIEN.MANV%TYPE )
AS
    madatphong_v PHIEUDATPHONG.MADATPHONG%TYPE;
BEGIN
    SELECT b.MADATPHONG INTO madatphong_v FROM PHIEUDATPHONG 
    JOIN ( SELECT MADATPHONG, MAPHG FROM CHITIETDATPHONG WHERE MAPHG = maphg_i)  b
    on PHIEUDATPHONG.MADATPHONG = b.MADATPHONG
    WHERE TRUNC(SYSDATE) <= TRUNC(NGAYTRA) AND TTNHANPHONG = 1;
    IF SQL%NOTFOUND
    THEN
        DBMS_OUTPUT.PUT_LINE('MA PHONG HIEN KHONG DUOC THUE ');
    ELSE
        INSERT INTO HOADONDV (MADATPHONG, MAPHG, MANV, MADV, SOLUONG) VALUES (madatphong_v, maphg_i, manv_i, madv_i, soluong_i);
        COMMIT;
    END IF;
END INSERT_DON_DV;
/    


CREATE OR REPLACE PROCEDURE XacNhanNhanPhong(madatphong_i in PHIEUDATPHONG.MADATPHONG%TYPE)
AS
    CURSOR phongdat_cur IS SELECT MAPHG FROM CHITIETDATPHONG WHERE MADATPHONG = madatphong_i;
    maphg_v PHONG.MAPHG%TYPE;
BEGIN
    OPEN phongdat_cur;
    LOOP
        FETCH phongdat_cur into maphg_v;
        EXIT WHEN phongdat_cur%notfound;
        if (phongdat_cur%found)
        then 
            UPDATE PHONG
            SET TINHTRANG = 1
            WHERE MAPHG = maphg_v;
        end if;
    END LOOP;
    UPDATE PHIEUDATPHONG SET TTNHANPHONG = 1 WHERE MADATPHONG = madatphong_i;
    COMMIT;
    EXCEPTION 
        WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('MADATPHONG NOT FOUNDED');
END;
/


CREATE OR REPLACE PROCEDURE HuyPhieuDatPhong(madatphong_i IN PHIEUDATPHONG.MADATPHONG%TYPE)
as
    ttNhanPhong_v PHIEUDATPHONG.TTNHANPHONG%TYPE;
BEGIN
    SELECT TTNHANPHONG INTO ttNhanPhong_v FROM PHIEUDATPHONG WHERE MADATPHONG = madatphong_i;
    IF ttNhanPhong_v = 1
    THEN
        DBMS_OUTPUT.PUT_LINE('PHIEU DAT PHONG DA NHAN PHONG, KHONG THE HUY');
    ELSE
        DELETE FROM CHITIETDATPHONG WHERE MADATPHONG = madatphong_i;
        UPDATE PHIEUDATPHONG SET TTNHANPHONG = -1 WHERE MADATPHONG = madatphong_i;
        COMMIT;
    END IF;
END;
/


CREATE OR REPLACE PROCEDURE XacNhanThanhToan(madatphong_i IN PHIEUDATPHONG.MADATPHONG%TYPE)
AS
BEGIN
    
END;
/