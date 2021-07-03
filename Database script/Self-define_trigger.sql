

/*==============================================================*/
/* Trigger:   TRG_CHITIETDATPHONG_ON_INSERT                                   */
/*==============================================================*/
create or replace trigger TRG_CHITIETDATPHONG_ON_INSERT
before insert on CHITIETDATPHONG
referencing old as old new as new
for each row
declare
    dongia_v LOAIPHONG.DONGIA%TYPE;
    tongtien_v PHIEUDATPHONG.TIENPHONG%TYPE;
    songayluutru_v number;
BEGIN
    SELECT LOAIPHONG.DONGIA INTO dongia_v 
    FROM (SELECT MALOAIPHG FROM PHONG WHERE MAPHG = :NEW.MAPHG) A
    JOIN LOAIPHONG ON A.MALOAIPHG = LOAIPHONG.MALOAIPHG; 
    :NEW.DONGIAPHONG := dongia_v;
    SELECT TIENPHONG into tongtien_v from PHIEUDATPHONG where MADATPHONG = :new.MADATPHONG;
    SELECT TRUNC(NGAYTRA) - TRUNC(NGAYNHAN) INTO songayluutru_v FROM PHIEUDATPHONG  WHERE MADATPHONG = :NEW.MADATPHONG;
    
    UPDATE PHIEUDATPHONG
    SET TIENPHONG = tongtien_v + :NEW.DONGIAPHONG * songayluutru_v
    WHERE PHIEUDATPHONG.MADATPHONG = :new.MADATPHONG;

END TRG_CHITIETDATPHONG_ON_INSERT;
/





/*==============================================================*/
/* Trigger:TRG_AUTO_UPDATE_THANHTIEN_HDDV                                  */
/*==============================================================*/
create or replace trigger TRG_AUTO_UPDATE_THANHTIEN_HDDV
before insert or delete or update of SOLUONG, THANHTIEN on HOADONDV
referencing old as old new as new
for each row
declare
    dongia_v DANHMUCDICHVU.dongia%type;
begin            
    SELECT DONGIA INTO dongia_v FROM DANHMUCDICHVU WHERE MADV = :NEW.MADV;

    CASE
        WHEN INSERTING THEN
            :NEW.THANHTIEN := :NEW.SOLUONG * dongia_v;

        WHEN UPDATING THEN
            :NEW.THANHTIEN := :OLD.THANHTIEN - (:NEW.SOLUONG - :OLD.SOLUONG) * dongia_v;
    END CASE;
    EXCEPTION 
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('NO DONGIA FOUNDED');
end TRG_AUTO_UPDATE_THANHTIEN_HDDV ;
/




/*==============================================================*/
/* Trigger: TRG_CHITIETTIEC_AUTO_UPDATE_HDTIEC_THANHTIEN                        */
/*==============================================================*/
create or replace trigger TRG_CHITIETTIEC_AUTO_UPDATE_HDTIEC_THANHTIEN
before delete or update of SoLuong, DonGiaMonAn on CHITIETTIEC
referencing old as old new as new
for each row
declare
    dongia_v DANHMUCMONAN.DONGIA%type;
    tongtien_v HOADONTIEC.THANHTIEN%type;
begin
    CASE
        WHEN INSERTING THEN
            SELECT DONGIA INTO dongia_v FROM DANHMUCMONAN WHERE MAMONAN = :NEW.MAMONAN;
            :NEW.DONGIAMONAN := dongia_v;
            SELECT THANHTIEN into tongtien_v from HOADONTIEC where MATIEC = :new.MATIEC;
            UPDATE HOADONTIEC
            SET THANHTIEN = tongtien_v + :new.SoLuong * :NEW.DONGIAMONAN
            WHERE HOADONTIEC.MATIEC = :new.MATIEC;
        WHEN UPDATING THEN
            SELECT THANHTIEN into tongtien_v from HOADONTIEC where matiec = :new.matiec;
            UPDATE HOADONTIEC
            SET THANHTIEN = tongtien_v + :new.SoLuong * :new.DonGiaMonAn - :old.SoLuong * :old.DonGiaMonAn
            where HOADONTIEC.matiec = :new.matiec;
        WHEN DELETING THEN
            SELECT THANHTIEN into tongtien_v from HOADONTIEC where matiec = :new.matiec;
            UPDATE HOADONTIEC
            SET THANHTIEN = tongtien_v - :old.SoLuong * :old.DonGiaMonAn
            WHERE HOADONTIEC.matiec = :old.matiec;
    END CASE;
end TRG_CHITIETTIEC_AUTO_UPDATE_HDTIEC_THANHTIEN;
/




/*==============================================================*/
/* Trigger: TRG__PHIEUDATPHONG_ON_UPDATE_OF_NGAYDAT_NGAYTRA                                   */
/*==============================================================*/
create or replace trigger TRG__PHIEUDATPHONG_ON_UPDATE_OF_NGAYDAT_NGAYTRA
before update of NGAYDAT, NGAYTRA on PHIEUDATPHONG
REFERENCING NEW AS NEW OLD AS OLD
FOR EACH ROW
DECLARE
    tongtien_v PHIEUDATPHONG.TIENPHONG%type;
    tongdongia_v PHIEUDATPHONG.TIENPHONG%type;
    songay_v number;
BEGIN
-- LAY TONG DON GIA CUA TAT CA CAC PHONG TRONG PHIEU DAT PHONG
    SELECT SUM(DONGIAPHONG)
    INTO tongdongia_v
    FROM CHITIETDATPHONG
    WHERE MADATPHONG = :NEW.MADATPHONG;
--    LAY SO NGAY O TRONG PHIEU NHAN PHONG
    songay_v := TRUNC(:new.NGAYTRA) - TRUNC(:NEW.NGAYNHAN) +1;
    :NEW.TIENPHONG := songay_v * tongdongia_v;
END TRG__PHIEUDATPHONG_ON_UPDATE_OF_NGAYDAT_NGAYTRA;
/



/*==============================================================*/
/* Trigger: TRG_CHITIETDATPHONG_ON_DELETE_UPDATE_OF_DONGIAPHONG              */
/*==============================================================*/
create or replace trigger TRG_CHITIETDATPHONG_ON_DELETE_UPDATE_OF_DONGIAPHONG
before delete or update of DonGiaPhong on CHITIETDATPHONG
referencing old as old new as new
for each row
declare
    tongtien_v PHIEUDATPHONG.TIENPHONG%type;
    tongdongia_v PHIEUDATPHONG.TIENPHONG%type;
    songayluutru_v number;
begin
    SELECT NGAYTRA - NGAYNHAN +1
    INTO songayluutru_v 
    FROM PHIEUDATPHONG
    WHERE MADATPHONG =:old.MADATPHONG;
    SELECT TIENPHONG into tongtien_v from PHIEUDATPHONG where MADATPHONG = :old.MADATPHONG;
    CASE
        WHEN UPDATING THEN
            UPDATE PHIEUDATPHONG
            SET TIENPHONG = tongtien_v + :new.DONGIAPHONG * songayluutru_v - :old.DONGIAPHONG * songayluutru_v
            where PHIEUDATPHONG.MADATPHONG = :new.MADATPHONG;
        WHEN DELETING THEN
            UPDATE PHIEUDATPHONG
            SET TIENPHONG = tongtien_v - :old.DONGIAPHONG * songayluutru_v
            where PHIEUDATPHONG.MADATPHONG = :old.MADATPHONG;
    END CASE;
end TRG_CHITIETDATPHONG_ON_DELETE_UPDATE_OF_DONGIAPHONG;
/


/*==============================================================*/
/* Trigger: TRG_THANHTOAN_AUTO_TONGTIEN_ON_INSERT              */
/*==============================================================*/
create or replace trigger TRG_THANHTOAN_AUTO_TONGTIEN_ON_INSERT
before insert on THANHTOAN
referencing old as old new as new
for each row
declare
begin
    :new.THANHTIEN := get_TongTien_ThanhToan(:NEW.MADATPHONG);
end TRG_THANHTOAN_AUTO_TONGTIEN_ON_INSERT;
/



