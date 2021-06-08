/*==============================================================*/
/* Trigger:   TRG_CHITIETDONDV_DONGIADV_ON_INSERT                                   */
/*==============================================================*/
--create or replace trigger TRG_CHITIETDONDV_ON_INSERT
--before insert on CHITIETDONDV
--referencing old as old new as new
--for each row
--declare
--    dongia_v DANHMUCDICHVU.DONGIA%TYPE;
--    tongtien_v HOADONDV.TONGTIEN%TYPE;
--BEGIN
--    SELECT DONGIA INTO dongia_v FROM DANHMUCDICHVU WHERE MADV = :NEW.MADV;
--    :NEW.DONGIADV := dongia_v;
--    SELECT TONGTIEN into tongtien_v from HOADONDV where MAHDDV = :new.MAHDDV;
--    UPDATE HOADONDV
--    SET TONGTIEN = tongtien_v + :new.SoLuong * :NEW.DONGIADV
--    WHERE HOADONDV.MAHDDV = :new.MaHDDV;
--END TRG_CHITIETDONDV_ON_INSERT;
--/
--

/*==============================================================*/
/* Trigger:   TRG_CHITIETTIEC_DONGIAMONAN_ON_INSERT                                   */
/*==============================================================*/
create or replace trigger TRG_CHITIETDONTIEC_ON_INSERT
before insert on CHITIETTIEC
referencing old as old new as new
for each row
declare
    dongia_v DANHMUCMONAN.DONGIA%TYPE;
    tongtien_v HOADONTIEC.TONGTIEN%TYPE;
BEGIN
    SELECT DONGIA INTO dongia_v FROM DANHMUCMONAN WHERE MAMONAN = :NEW.MAMONAN;
    :NEW.DONGIAMONAN := dongia_v;
    SELECT TONGTIEN into tongtien_v from HOADONTIEC where MATIEC = :new.MATIEC;
    UPDATE HOADONTIEC
    SET TONGTIEN = tongtien_v + :new.SoLuong * :NEW.DONGIAMONAN
    WHERE HOADONTIEC.MATIEC = :new.MATIEC;
END TRG_CHITIETDONTIEC_ON_INSERT;
/


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
    SELECT NGAYTRA - NGAYNHAN + 1 INTO songayluutru_v FROM PHIEUDATPHONG  WHERE MADATPHONG = :NEW.MADATPHONG;
    
    UPDATE PHIEUDATPHONG
    SET TIENPHONG = tongtien_v + :NEW.DONGIAPHONG * songayluutru_v
    WHERE PHIEUDATPHONG.MADATPHONG = :new.MADATPHONG;

END TRG_CHITIETDATPHONG_ON_INSERT;
/








--/*==============================================================*/
--/* Trigger:TRG_HOADONDV_ON_UPDATE_OF_TONGTIEN                                   */
--/*==============================================================*/
--create or replace trigger TRG_HOADONDV_ON_UPDATE_OF_TONGTIEN
--before update of TongTien on HOADONDV
--REFERENCING NEW AS NEW OLD AS OLD
--FOR EACH ROW
--DECLARE
--    tongtien_v HOADONDV.TONGTIEN%type;
--BEGIN
--    SELECT SUM(SOLUONG * DONGIADV)
--    INTO tongtien_v
--    FROM CHITIETDONDV
--    WHERE MAHDDV = :NEW.MAHDDV;
--    IF :new.TONGTIEN != tongtien_v
--    THEN
--        RAISE_APPLICATION_ERROR(-2000, 'CAP NHAT TONG TIEN CUA HOA DON DICH VU KHONG HOP LE');
--    END IF;
--END TRG_HOADONDV_ON_UPDATE_OF_TONGTIEN;
--/



/*==============================================================*/
/* Trigger:TRG_CHITIETDONDV_AUTO_UPDATE_HDDV                                  */
/*==============================================================*/
create or replace trigger TRG_CHITIETDONDV_AUTO_UPDATE_HDDV
before insert or delete or update of SOLUONG, DONGIADV on CHITIETDONDV
referencing old as old new as new
for each row
declare
    dongia_v DANHMUCDICHVU.dongia%type;
    tongtien_v HOADONDV.TONGTIEN%type;
begin
    CASE
        WHEN INSERTING THEN
            SELECT DONGIA INTO dongia_v FROM DANHMUCDICHVU WHERE MADV = :NEW.MADV;
            :NEW.DONGIADV := dongia_v;
            SELECT TONGTIEN into tongtien_v from HOADONDV where MAHDDV = :new.MAHDDV;
            UPDATE HOADONDV
            SET TONGTIEN = tongtien_v + :new.SoLuong * :NEW.DONGIADV
            WHERE HOADONDV.MAHDDV = :new.MaHDDV;
        WHEN UPDATING THEN
            SELECT TONGTIEN into tongtien_v from hoadonDV where MAHDDV = :new.MAHDDV;
            UPDATE HOADONDV
            SET TONGTIEN = tongtien_v + :new.SoLuong * :new.DonGiaDV - :old.SoLuong * :new.DonGiaDV
            where HOADONDV.MAHDDV = :new.MaHDDV;
        WHEN DELETING THEN
            SELECT TONGTIEN into tongtien_v from hoadonDV where MAHDDV = :old.MAHDDV;
            UPDATE HOADONDV
            SET TONGTIEN = tongtien_v - :old.SoLuong * :old.DonGiaDV
            WHERE HOADONDV.MAHDDV = :old.MaHDDV;
    END CASE;
end TRG_CHITIETDONDV_AUTO_UPDATE_HDDV ;
/



--/*==============================================================*/
--/* Trigger: TRG_HOADONTIEC_ON_UPDATE_OF_TONGTIEN                                   */
--/*==============================================================*/
--create or replace trigger TRG_HOADONTIEC_ON_UPDATE_OF_TONGTIEN
--before update of TongTien on HOADONTIEC
--REFERENCING NEW AS NEW OLD AS OLD
--FOR EACH ROW
--DECLARE
--    tongtien_v HOADONTIEC.TONGTIEN%type;
--BEGIN
--    SELECT SUM(SOLUONG * DONGIAMONAN)
--    INTO tongtien_v
--    FROM CHITIETTIEC
--    WHERE MATIEC = :NEW.MATIEC;
--    IF :new.TONGTIEN != tongtien_v
--    THEN
--        RAISE_APPLICATION_ERROR(-2000, 'CAP NHAT TONG TIEN HOA DON TIEC KHONG HOP LE');
--    END IF;
--END TRG_HOADONTIEC_ON_UPDATE_OF_TONGTIEN;
--/



/*==============================================================*/
/* Trigger: TRG_CHITIETTIEC_AUTO_UPDATE_HDTIEC                        */
/*==============================================================*/
create or replace trigger TRG_CHITIETTIEC_AUTO_UPDATE_HDTIEC
before delete or update of SoLuong, DonGiaMonAn on CHITIETTIEC
referencing old as old new as new
for each row
declare
    dongia_v DANHMUCMONAN.DONGIA%type;
    tongtien_v HOADONTIEC.TONGTIEN%type;
begin
    CASE
        WHEN INSERTING THEN
            SELECT DONGIA INTO dongia_v FROM DANHMUCMONAN WHERE MAMONAN = :NEW.MAMONAN;
            :NEW.DONGIAMONAN := dongia_v;
            SELECT TONGTIEN into tongtien_v from HOADONTIEC where MATIEC = :new.MATIEC;
            UPDATE HOADONTIEC
            SET TONGTIEN = tongtien_v + :new.SoLuong * :NEW.DONGIAMONAN
            WHERE HOADONTIEC.MATIEC = :new.MATIEC;
        WHEN UPDATING THEN
            SELECT TONGTIEN into tongtien_v from HOADONTIEC where matiec = :new.matiec;
            UPDATE HOADONTIEC
            SET TONGTIEN = tongtien_v + :new.SoLuong * :new.DonGiaMonAn - :old.SoLuong * :old.DonGiaMonAn
            where HOADONTIEC.matiec = :new.matiec;
        WHEN DELETING THEN
            SELECT TONGTIEN into tongtien_v from HOADONTIEC where matiec = :new.matiec;
            UPDATE HOADONTIEC
            SET TONGTIEN = tongtien_v - :old.SoLuong * :old.DonGiaMonAn
            WHERE HOADONTIEC.matiec = :old.matiec;
    END CASE;
end TRG_CHITIETTIEC_AUTO_UPDATE_HDTIEC;
/


--/*==============================================================*/
--/* Trigger: TRG_PHIEUDATPHONG_ON_UPDATE_OF_TIENPHONG                                   */
--/*==============================================================*/
--create or replace trigger TRG_PHIEUDATPHONG_ON_UPDATE_OF_TIENPHONG
--before update of TienPhong on PHIEUDATPHONG
--REFERENCING NEW AS NEW OLD AS OLD
--FOR EACH ROW
--DECLARE
--    tongtien_v PHIEUDATPHONG.TIENPHONG%type;
--    tongdongia_v PHIEUDATPHONG.TIENPHONG%type;
--    songay_v number;
--BEGIN
---- LAY TONG DON GIA CUA TAT CA CAC PHONG TRONG PHIEU DAT PHONG
--    SELECT SUM(DONGIAPHONG)
--    INTO tongdongia_v
--    FROM CHITIETDATPHONG
--    WHERE MADATPHONG = :NEW.MADATPHONG;
----    LAY SO NGAY O TRONG PHIEU NHAN PHONG
--    SELECT NGAYTRA - NGAYNHAN +1
--    INTO songay_v
--    FROM PHIEUDATPHONG
--    WHERE MADATPHONG = :NEW.MADATPHONG;
--    
--    tongtien_v := tongdongia_v * songay_v;
--    IF :new.TIENPHONG != tongtien_v
--    THEN
--        RAISE_APPLICATION_ERROR(-2000, 'CAP NHAT TONG TIEN PHONG TRONG PHIEU KHONG HOP LE');
--    END IF;
--END TRG_PHIEUDATPHONG_ON_UPDATE_OF_TIENPHONG;
--/


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
    songay_v := :new.NGAYTRA - :NEW.NGAYNHAN +1;
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
/* Trigger: TRG_PHIEUDATPHONG_AUTO_NGAYDAT_ON_INSERT              */
/*==============================================================*/
create or replace trigger TRG_PHIEUDATPHONG_AUTO_NGAYDAT_ON_INSERT
before insert on PHIEUDATPHONG
referencing old as old new as new
for each row
declare
begin
    :new.NGAYDAT := CURRENT_DATE;
end TRG_PHIEUDATPHONG_AUTO_NGAYDAT_ON_INSERT;
/



/*==============================================================*/
/* Trigger: TRG_HOADONTIEC_AUTO_NGAYDAT_ON_INSERT              */
/*==============================================================*/
create or replace trigger TRG_HOADONTIEC_AUTO_NGAYDAT_ON_INSERT
before insert on HOADONTIEC
referencing old as old new as new
for each row
declare
begin
    :new.NGAYLAP := CURRENT_DATE;
end TRG_HOADONTIEC_AUTO_NGAYDAT_ON_INSERT;
/


/*==============================================================*/
/* Trigger: TRG_HOADONDV_AUTO_NGAYDAT_ON_INSERT              */
/*==============================================================*/
create or replace trigger TRG_HOADONDV_AUTO_THOIGIANDAT_ON_INSERT
before insert on HOADONDV
referencing old as old new as new
for each row
declare
begin
    :new.THOIGIANDAT := CURRENT_DATE;
end TRG_HOADONDV_AUTO_NGAYDAT_ON_INSERT;
/


/*==============================================================*/
/* Trigger: TRG_THANHTOAN_AUTO_NGAYDAT_TONGTIEN_ON_INSERT              */
/*==============================================================*/
create or replace trigger TRG_THANHTOAN_AUTO_NGAYDAT_TONGTIEN_ON_INSERT
before insert on THANHTOAN
referencing old as old new as new
for each row
declare
begin
    :new.NGAYLAP := CURRENT_DATE;
    :new.TONGTIEN := get_TongTien_ThanhToan(:NEW.MADATPHONG);
end TRG_THANHTOAN_AUTO_NGAYDAT_TONGTIEN_ON_INSERT;
/