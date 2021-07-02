/*==============================================================*/
/* DBMS name:      ORACLE Version 11g                           */
/* Created on:     7/2/2021 9:24:57 AM                          */
/*==============================================================*/


alter table CHITIETDATPHONG
   drop constraint FK_CHITIETD_CHITIETDA_PHONG;

alter table CHITIETDATPHONG
   drop constraint FK_CHITIETD_CHITIETDA_PHIEUDAT;

alter table CHITIETTIEC
   drop constraint FK_CHITIETT_CHITIETTI_HOADONTI;

alter table CHITIETTIEC
   drop constraint FK_CHITIETT_CHITIETTI_DANHMUCM;

alter table HOADONDV
   drop constraint FK_HOADONDV_DATDVTUPH_PHONG;

alter table HOADONDV
   drop constraint FK_HOADONDV_GOMDV_DANHMUCD;

alter table HOADONDV
   drop constraint FK_HOADONDV_SUDUNGDV_PHIEUDAT;

alter table HOADONDV
   drop constraint FK_HOADONDV_THUCHIEN_NHANVIEN;

alter table HOADONTIEC
   drop constraint FK_HOADONTI_DATTIEC_KHACHHAN;

alter table HOADONTIEC
   drop constraint FK_HOADONTI_DATTIECTU_PHONG;

alter table HOADONTIEC
   drop constraint FK_HOADONTI_DUOC_THUC_NHANVIEN;

alter table HOADONTIEC
   drop constraint FK_HOADONTI_SUDUNGTIE_PHIEUDAT;

alter table PHIEUDATPHONG
   drop constraint FK_PHIEUDAT_DATPHONG_KHACHHAN;

alter table PHIEUDATPHONG
   drop constraint FK_PHIEUDAT_XACMINH_NHANVIEN;

alter table PHONG
   drop constraint FK_PHONG_THUOC_LOAIPHON;

alter table TAIKHOAN
   drop constraint FK_TAIKHOAN_CO_NHANVIEN;

alter table THANHTOAN
   drop constraint FK_THANHTOA_THUNGAN_NHANVIEN;

alter table THANHTOAN
   drop constraint FK_THANHTOA_TIENHANH_PHIEUDAT;

drop index CHITIETDATPHONG2_FK;

drop index CHITIETDATPHONG_FK;

drop table CHITIETDATPHONG cascade constraints;

drop index CHITIETTIEC2_FK;

drop index CHITIETTIEC_FK;

drop table CHITIETTIEC cascade constraints;

drop table DANHMUCDICHVU cascade constraints;

drop table DANHMUCMONAN cascade constraints;

drop index DATDVTUPHONG_FK;

drop index SUDUNGDV_FK;

drop index THUCHIEN_FK;

drop index GOMDV_FK;

drop table HOADONDV cascade constraints;

drop index DATTIECTUPHONG_FK;

drop index SUDUNGTIEC_FK;

drop index DUOC_THUC_HIEN_FK;

drop index DATTIEC_FK;

drop table HOADONTIEC cascade constraints;

drop table KHACHHANG cascade constraints;

drop table LOAIPHONG cascade constraints;

drop table NHANVIEN cascade constraints;

drop index XACMINH_FK;

drop index DATPHONG_FK;

drop table PHIEUDATPHONG cascade constraints;

drop index THUOC_FK;

drop table PHONG cascade constraints;

drop index CO_FK;

drop table TAIKHOAN cascade constraints;

drop index THUNGAN_FK;

drop index TIENHANH_FK;

drop table THANHTOAN cascade constraints;


drop sequence MAKH_SEQ;
drop sequence MADATPHONG_SEQ;
drop sequence MATIEC_SEQ;
drop sequence MAMONAN_SEQ;
drop sequence MAHDDV_SEQ;
drop sequence MADV_SEQ;
drop sequence MANV_SEQ;
drop sequence MATHANHTOAN_SEQ;




/*==============================================================*/
/* Sequence: MAKH_SEQ                        */
/*==============================================================*/
create sequence MAKH_SEQ;



/*==============================================================*/
/* Sequence: MADATPHONG_SEQ                        */
/*==============================================================*/
create sequence MADATPHONG_SEQ;



/*==============================================================*/
/* Sequence: MATIEC_SEQ                        */
/*==============================================================*/
create sequence MATIEC_SEQ;



/*==============================================================*/
/* Sequence: MAMONAN_SEQ                        */
/*==============================================================*/
create sequence MAMONAN_SEQ;



/*==============================================================*/
/* Sequence: MAHDDV_SEQ                        */
/*==============================================================*/
create sequence MAHDDV_SEQ;


/*==============================================================*/
/* Sequence: MADV_SEQ                        */
/*==============================================================*/
create sequence MADV_SEQ;



/*==============================================================*/
/* Sequence: MANV_SEQ                        */
/*==============================================================*/
create sequence MANV_SEQ;



/*==============================================================*/
/* Sequence: MATHANHTOAN_SEQ                        */
/*==============================================================*/
create sequence MATHANHTOAN_SEQ;





/*==============================================================*/
/* Table: CHITIETDATPHONG                                       */
/*==============================================================*/
create table CHITIETDATPHONG 
(
   MAPHG                VARCHAR2(8)          not null,
   MADATPHONG           NUMBER(9)            not null,
   DONGIAPHONG          NUMBER(19,0),
   constraint PK_CHITIETDATPHONG primary key (MAPHG, MADATPHONG)
);

/*==============================================================*/
/* Index: CHITIETDATPHONG_FK                                    */
/*==============================================================*/
create index CHITIETDATPHONG_FK on CHITIETDATPHONG (
   MAPHG ASC
);

/*==============================================================*/
/* Index: CHITIETDATPHONG2_FK                                   */
/*==============================================================*/
create index CHITIETDATPHONG2_FK on CHITIETDATPHONG (
   MADATPHONG ASC
);

/*==============================================================*/
/* Table: CHITIETTIEC                                           */
/*==============================================================*/
create table CHITIETTIEC 
(
   MATIEC               NUMBER(9)            not null,
   MAMONAN              NUMBER(9)            not null,
   SOLUONG              INTEGER,
   DONGIAMONAN          NUMBER(19,0),
   constraint PK_CHITIETTIEC primary key (MATIEC, MAMONAN)
);

/*==============================================================*/
/* Index: CHITIETTIEC_FK                                        */
/*==============================================================*/
create index CHITIETTIEC_FK on CHITIETTIEC (
   MATIEC ASC
);

/*==============================================================*/
/* Index: CHITIETTIEC2_FK                                       */
/*==============================================================*/
create index CHITIETTIEC2_FK on CHITIETTIEC (
   MAMONAN ASC
);

/*==============================================================*/
/* Table: DANHMUCDICHVU                                         */
/*==============================================================*/
create table DANHMUCDICHVU 
(
   MADV                 NUMBER(9)            default MADV_SEQ.NEXTVAL           not null,
   TENDV                VARCHAR2(30),
   DONGIA               NUMBER(19,0),
   DONVI                VARCHAR2(10),
   constraint PK_DANHMUCDICHVU primary key (MADV)
);

/*==============================================================*/
/* Table: DANHMUCMONAN                                          */
/*==============================================================*/
create table DANHMUCMONAN 
(
   MAMONAN              NUMBER(9)            default MAMONAN_SEQ.NEXTVAL             not null,
   TENMONAN             VARCHAR2(30),
   DONGIA               NUMBER(19,0),
   constraint PK_DANHMUCMONAN primary key (MAMONAN)
);

/*==============================================================*/
/* Table: HOADONDV                                              */
/*==============================================================*/
create table HOADONDV 
(
   MAHDDV               NUMBER(9)            default MAHDDV_SEQ.NEXTVAL            not null,
   MADATPHONG           NUMBER(9)            not null,
   MADV                 NUMBER(9)            not null,
   MANV                 NUMBER(9)            not null,
   MAPHG                VARCHAR2(8),
   THANHTIEN            NUMBER(19,0)        default 0,
   TINHTRANG            SMALLINT        default 0,
   THOIGIANDAT          DATE            default trunc(sysdate),
   SOLUONG              INTEGER,
   constraint PK_HOADONDV primary key (MAHDDV)
);

/*==============================================================*/
/* Index: GOMDV_FK                                              */
/*==============================================================*/
create index GOMDV_FK on HOADONDV (
   MADV ASC
);

/*==============================================================*/
/* Index: THUCHIEN_FK                                           */
/*==============================================================*/
create index THUCHIEN_FK on HOADONDV (
   MANV ASC
);

/*==============================================================*/
/* Index: SUDUNGDV_FK                                           */
/*==============================================================*/
create index SUDUNGDV_FK on HOADONDV (
   MADATPHONG ASC
);

/*==============================================================*/
/* Index: DATDVTUPHONG_FK                                       */
/*==============================================================*/
create index DATDVTUPHONG_FK on HOADONDV (
   MAPHG ASC
);

/*==============================================================*/
/* Table: HOADONTIEC                                            */
/*==============================================================*/
create table HOADONTIEC 
(
   MATIEC               NUMBER(9)           default MATIEC_SEQ.NEXTVAL            not null,
   MANV                 NUMBER(9)            not null,
   MAPHG                VARCHAR2(8),
   MAKH                 NUMBER(9)            not null,
   MADATPHONG           NUMBER(9)           not null,
   MOTA                 VARCHAR2(100),
   TINHTRANG            SMALLINT            default 0,
   THANHTIEN            NUMBER(19,0)            default 0,
   THOIGIANDAT          DATE                default sysdate,
   TIENTRATRUOC         NUMBER(19,0),
   NGAYNHANTIEC         DATE,
   SOKHACH              NUMBER,
   constraint PK_HOADONTIEC primary key (MATIEC)
);

/*==============================================================*/
/* Index: DATTIEC_FK                                            */
/*==============================================================*/
create index DATTIEC_FK on HOADONTIEC (
   MAKH ASC
);

/*==============================================================*/
/* Index: DUOC_THUC_HIEN_FK                                     */
/*==============================================================*/
create index DUOC_THUC_HIEN_FK on HOADONTIEC (
   MANV ASC
);

/*==============================================================*/
/* Index: SUDUNGTIEC_FK                                         */
/*==============================================================*/
create index SUDUNGTIEC_FK on HOADONTIEC (
   MADATPHONG ASC
);

/*==============================================================*/
/* Index: DATTIECTUPHONG_FK                                     */
/*==============================================================*/
create index DATTIECTUPHONG_FK on HOADONTIEC (
   MAPHG ASC
);

/*==============================================================*/
/* Table: KHACHHANG                                             */
/*==============================================================*/
create table KHACHHANG 
(
   MAKH                 NUMBER(9)           default MAKH_SEQ.NEXTVAL            not null,
   TENKH                VARCHAR2(80),
   CCCD                 VARCHAR2(13),
   SDT                  VARCHAR2(13),
   GIOITINH             VARCHAR2(5),
   LOAIKHACH            VARCHAR2(10),
   DOANHSO              NUMBER(19,0),
   constraint PK_KHACHHANG primary key (MAKH)
);

/*==============================================================*/
/* Table: LOAIPHONG                                             */
/*==============================================================*/
create table LOAIPHONG 
(
   MALOAIPHG            VARCHAR2(8)          not null,
   KIEUPHONG            VARCHAR2(10),
   KIEUGIUONG           INTEGER,
   MOTA                 VARCHAR2(100),
   DONGIA               NUMBER(19,0),
   constraint PK_LOAIPHONG primary key (MALOAIPHG)
);

/*==============================================================*/
/* Table: NHANVIEN                                              */
/*==============================================================*/
create table NHANVIEN 
(
   MANV                 NUMBER(9)           default MANV_SEQ.NEXTVAL            not null,
   TENNV                VARCHAR2(40),
   CCCD                 VARCHAR2(13),
   SDT                  VARCHAR2(13),
   NGAYSINH             DATE,
   GIOITINH             VARCHAR2(5),
   NGAYVL               DATE,
   CHUCVU               VARCHAR2(20),
   constraint PK_NHANVIEN primary key (MANV)
);

/*==============================================================*/
/* Table: PHIEUDATPHONG                                         */
/*==============================================================*/
create table PHIEUDATPHONG 
(
   MADATPHONG           NUMBER(9)           default MADATPHONG_SEQ.NEXTVAL            not null,
   MANV                 NUMBER(9)            not null,
   MAKH                 NUMBER(9)            not null,
   NGAYDAT              DATE            default sysdate,
   NGAYNHAN             DATE,
   NGAYTRA              DATE,
   TTNHANPHONG          SMALLINT           default 0,
   TIENPHONG                 NUMBER(19,0)           default 0,
   PHUPHI               NUMBER(19,0)           default 0,
   TIENTRATRUOC         NUMBER(19,0)           default 0,
   TIENCANTRA           NUMBER(19,0)           default 0,
   TIENDV               NUMBER(19,0)           default 0,
   TIENTIEC             NUMBER(19,0)           default 0,
   constraint PK_PHIEUDATPHONG primary key (MADATPHONG)
);

/*==============================================================*/
/* Index: DATPHONG_FK                                           */
/*==============================================================*/
create index DATPHONG_FK on PHIEUDATPHONG (
   MAKH ASC
);

/*==============================================================*/
/* Index: XACMINH_FK                                            */
/*==============================================================*/
create index XACMINH_FK on PHIEUDATPHONG (
   MANV ASC
);

/*==============================================================*/
/* Table: PHONG                                                 */
/*==============================================================*/
create table PHONG 
(
   MAPHG                VARCHAR2(8)          not null,
   MALOAIPHG            VARCHAR2(8)          not null,
   MOTA                 VARCHAR2(100),
   TINHTRANG            SMALLINT                default 0,
   constraint PK_PHONG primary key (MAPHG)
);

/*==============================================================*/
/* Index: THUOC_FK                                              */
/*==============================================================*/
create index THUOC_FK on PHONG (
   MALOAIPHG ASC
);

/*==============================================================*/
/* Table: TAIKHOAN                                              */
/*==============================================================*/
create table TAIKHOAN 
(
   TENTAIKHOAN          VARCHAR2(20)         not null,
   MANV                 NUMBER(9)            not null,
   MATKHAU              VARCHAR2(20)         not null,
   QUYEN                VARCHAR2(10)         not null,
   constraint PK_TAIKHOAN primary key (TENTAIKHOAN)
);

/*==============================================================*/
/* Index: CO_FK                                                 */
/*==============================================================*/
create index CO_FK on TAIKHOAN (
   MANV ASC
);

/*==============================================================*/
/* Table: THANHTOAN                                             */
/*==============================================================*/
create table THANHTOAN 
(
   MATHANHTOAN          NUMBER(9)           default MATHANHTOAN_SEQ.NEXTVAL            not null,
   MADATPHONG           NUMBER(9)            not null,
   MANV                 NUMBER(9)            not null,
   THANHTIEN            NUMBER(19,0)            default 0,
   HINHTHUCTHANHTOAN    VARCHAR2(30),
   NGAYLAP              DATE            DEFAULT Trunc(sysdate),
   TIENKHACHDUA         NUMBER(19)            default 0,
   constraint PK_THANHTOAN primary key (MATHANHTOAN)
);

/*==============================================================*/
/* Index: TIENHANH_FK                                           */
/*==============================================================*/
create index TIENHANH_FK on THANHTOAN (
   MADATPHONG ASC
);

/*==============================================================*/
/* Index: THUNGAN_FK                                            */
/*==============================================================*/
create index THUNGAN_FK on THANHTOAN (
   MANV ASC
);

alter table CHITIETDATPHONG
   add constraint FK_CHITIETD_CHITIETDA_PHONG foreign key (MAPHG)
      references PHONG (MAPHG);

alter table CHITIETDATPHONG
   add constraint FK_CHITIETD_CHITIETDA_PHIEUDAT foreign key (MADATPHONG)
      references PHIEUDATPHONG (MADATPHONG);

alter table CHITIETTIEC
   add constraint FK_CHITIETT_CHITIETTI_HOADONTI foreign key (MATIEC)
      references HOADONTIEC (MATIEC);

alter table CHITIETTIEC
   add constraint FK_CHITIETT_CHITIETTI_DANHMUCM foreign key (MAMONAN)
      references DANHMUCMONAN (MAMONAN);

alter table HOADONDV
   add constraint FK_HOADONDV_DATDVTUPH_PHONG foreign key (MAPHG)
      references PHONG (MAPHG);

alter table HOADONDV
   add constraint FK_HOADONDV_GOMDV_DANHMUCD foreign key (MADV)
      references DANHMUCDICHVU (MADV);

alter table HOADONDV
   add constraint FK_HOADONDV_SUDUNGDV_PHIEUDAT foreign key (MADATPHONG)
      references PHIEUDATPHONG (MADATPHONG);

alter table HOADONDV
   add constraint FK_HOADONDV_THUCHIEN_NHANVIEN foreign key (MANV)
      references NHANVIEN (MANV);

alter table HOADONTIEC
   add constraint FK_HOADONTI_DATTIEC_KHACHHAN foreign key (MAKH)
      references KHACHHANG (MAKH);

alter table HOADONTIEC
   add constraint FK_HOADONTI_DATTIECTU_PHONG foreign key (MAPHG)
      references PHONG (MAPHG);

alter table HOADONTIEC
   add constraint FK_HOADONTI_DUOC_THUC_NHANVIEN foreign key (MANV)
      references NHANVIEN (MANV);

alter table HOADONTIEC
   add constraint FK_HOADONTI_SUDUNGTIE_PHIEUDAT foreign key (MADATPHONG)
      references PHIEUDATPHONG (MADATPHONG);

alter table PHIEUDATPHONG
   add constraint FK_PHIEUDAT_DATPHONG_KHACHHAN foreign key (MAKH)
      references KHACHHANG (MAKH);

alter table PHIEUDATPHONG
   add constraint FK_PHIEUDAT_XACMINH_NHANVIEN foreign key (MANV)
      references NHANVIEN (MANV);

alter table PHONG
   add constraint FK_PHONG_THUOC_LOAIPHON foreign key (MALOAIPHG)
      references LOAIPHONG (MALOAIPHG);

alter table TAIKHOAN
   add constraint FK_TAIKHOAN_CO_NHANVIEN foreign key (MANV)
      references NHANVIEN (MANV);

alter table THANHTOAN
   add constraint FK_THANHTOA_THUNGAN_NHANVIEN foreign key (MANV)
      references NHANVIEN (MANV);

alter table THANHTOAN
   add constraint FK_THANHTOA_TIENHANH_PHIEUDAT foreign key (MADATPHONG)
      references PHIEUDATPHONG (MADATPHONG);





/*==============================================================*/
/* Data define constraint                                           */
/*==============================================================*/

alter table HOADONDV
    add constraint CHK_HOADONDV_VALIDATE_SOLUONG check (SOLUONG >= 0);

alter table CHITIETTIEC
    add constraint CHK_CHITIETTIEC_VALIDATE_SOLUONG check (SOLUONG >= 0);

alter table DANHMUCDICHVU
    add constraint CHK_DANHMUCDICHVU_VALIDATE_DONGIA check (DONGIA >= 0);

alter table DANHMUCMONAN
    add constraint CHK_DANHMUCMONAN_VALIDATE_DONGIA check (DONGIA > 0);

alter table HOADONDV
    add constraint CHK_HOADONDV_VALIDATE_THANHTIEN CHECK (THANHTIEN >= 0);
    
alter table HOADONTIEC
    add constraint CHK_HOADONTIEC_VALIDATE_THANHTIEN CHECK (THANHTIEN >=0);

--alter table KHACHHANG
--    add constraint CHK_KHACHHANG_GIOITINH check (GIOITINH in ('Nam', ' nam', 'Nu','nu', 'N?', 'n?','Khác','Khác' ));

alter table LOAIPHONG
    add constraint CHK_PHONG_VALIDATE_DONGIA check (DONGIA >= 0);

--alter table NHANVIEN
--    add constraint CHK_NHANVIEN_VALIDATE_GIOITINH check( GIOITINH in ('Nam', 'Nu', 'nam', 'nu', 'n?', 'N?','Khac','Khác'));
--alter table PHIEUDATPHONG
--    add constraint CHK_PHIEUDATPHONG_VALIDATE_NGAYDAT_NGAYNHAN_NGAYTRA check (NGAYDAT - NGAYNHAN < 1 AND NGAYNHAN - NGAYTRA < 1);

alter table THANHTOAN
    add constraint CHK_THANHTOAN_VALIDATE_THANHTIEN CHECK (THANHTIEN >= 0);



/* END OF DDL                           */















/* START OF TRIGGER                           */





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
    ngaynhan_v PHIEUDATPHONG.NGAYNHAN%TYPE;
    ngaytra_v PHIEUDATPHONG.NGAYTRA%TYPE;
BEGIN
    SELECT LOAIPHONG.DONGIA INTO dongia_v 
    FROM (SELECT MALOAIPHG FROM PHONG WHERE MAPHG = :NEW.MAPHG) A
    JOIN LOAIPHONG ON A.MALOAIPHG = LOAIPHONG.MALOAIPHG; 
    :NEW.DONGIAPHONG := dongia_v;
    SELECT TIENPHONG,NGAYNHAN, NGAYTRA into tongtien_v,ngaynhan_v, ngaytra_v from PHIEUDATPHONG where MADATPHONG = :new.MADATPHONG;
    songayluutru_v := GET_NGAYLUUTRU(ngaynhan_v,ngaytra_v);
    
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
/* Trigger:   TRG_CHITIETTIEC_DONGIAMONAN_ON_INSERT                                   */
/*==============================================================*/
create or replace trigger TRG_CHITIETDONTIEC_ON_INSERT
before insert on CHITIETTIEC
referencing old as old new as new
for each row
declare
    dongia_v DANHMUCMONAN.DONGIA%TYPE;
    tongtien_v HOADONTIEC.THANHTIEN%TYPE;
BEGIN
    SELECT DONGIA INTO dongia_v FROM DANHMUCMONAN WHERE MAMONAN = :NEW.MAMONAN;
    :NEW.DONGIAMONAN := dongia_v;
    SELECT THANHTIEN into tongtien_v from HOADONTIEC where MATIEC = :new.MATIEC;
    UPDATE HOADONTIEC
    SET THANHTIEN = tongtien_v + :new.SoLuong * :NEW.DONGIAMONAN
    WHERE HOADONTIEC.MATIEC = :new.MATIEC;
END TRG_CHITIETDONTIEC_ON_INSERT;
/


/*==============================================================*/
/* Trigger:   TRG_CHITIETTIEC_DONGIAMONAN_ON_UPDATE                                   */
/*==============================================================*/
create or replace trigger TRG_CHITIETDONTIEC_ON_UPDATE
before update on CHITIETTIEC
referencing old as old new as new
for each row
declare
    tongtien_v HOADONTIEC.THANHTIEN%TYPE;
BEGIN
    SELECT THANHTIEN into tongtien_v from hoadontiec where MATIEC = :new.MATIEC;
    UPDATE HOADONTIEC
    SET THANHTIEN = tongtien_v + :new.SoLuong * :new.dongiamonan - :old.SoLuong * :old.DonGiaMonAn
    where HOADONTIEC.MATIEC = :new.MATIEC;
END TRG_CHITIETDONTIEC_ON_UPDATE;
/


/*==============================================================*/
/* Trigger:   TRG_CHITIETTIEC_DONGIAMONAN_ON_DELETE                                   */
/*==============================================================*/
create or replace trigger TRG_CHITIETDONTIEC_ON_DELETE
before delete on CHITIETTIEC
referencing old as old new as new
for each row
declare
    tongtien_v HOADONTIEC.THANHTIEN%TYPE;
BEGIN
    SELECT THANHTIEN into tongtien_v from hoadontiec where MATIEC = :old.MATIEC;
    UPDATE HOADONTIEC
    SET THANHTIEN = tongtien_v - :old.SoLuong * :old.DonGiaMonAn
    where HOADONTIEC.MATIEC = :old.MATIEC;
END TRG_CHITIETDONTIEC_ON_DELETE;
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
/* Trigger: TRG_CHITIETTIEC_AUTO_UPDATE_HDTIEC_THANHTIEN                        */
/*==============================================================*/
/*create or replace trigger TRG_CHITIETTIEC_AUTO_UPDATE_HDTIEC_THANHTIEN
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
            SET THANHTIEN = tongtien_v + :new.SoLuong * :NEW.DONGIAMONAN                */
         /*   WHERE HOADONTIEC.MATIEC = :new.MATIEC;
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
    END CASE;*/
--end TRG_CHITIETTIEC_AUTO_UPDATE_HDTIEC_THANHTIEN;
--/


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
/* Trigger: TRG__PHIEUDATPHONG_ON_UPDATE_OF_NGAYNHAN_NGAYTRA                                   */
/*==============================================================*/
create or replace trigger TRG__PHIEUDATPHONG_ON_UPDATE_OF_NGAYNHAN_NGAYTRA
before update of NGAYNHAN, NGAYTRA on PHIEUDATPHONG
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
    songay_v := GET_NGAYLUUTRU(:new.NGAYTRA ,:NEW.NGAYNHAN);
    :NEW.TIENPHONG := songay_v * tongdongia_v;
END TRG__PHIEUDATPHONG_ON_UPDATE_OF_NGAYNHAN_NGAYTRA;
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
    SELECT Get_ngayluutru(NGAYTRA,NGAYNHAN)
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

/* END OF TRIGGER                           */






/*START OF PL/SQL                            */



create or replace function get_NgayLuuTru(ngaynhan_i in date, ngaytra_i in date)
return number
as
    result number;
begin
    result := trunc(ngaytra_i) - trunc(ngaynhan_i); 
    if result = 0
    then return 1;
    else if result < 0
        then return 0;
        else 
            return result;
        end if;
    end if;
end;
/


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
    SELECT SUM(THANHTIEN - TIENTRATRUOC) INTO tienhdtiec_v FROM HOADONTIEC WHERE MADATPHONG = MADATPHONG_v AND TINHTRANG = 0;
    IF (tienhddv_v IS NULL AND tienhdtiec_v IS NULL) THEN RETURN tienphong_v;
    END IF;
    IF (tienhddv_v IS NULL ) THEN RETURN tienphong_v + tienhdtiec_v;
    END IF;
    IF (tienhdtiec_v IS NULL ) THEN RETURN tienphong_v + tienhddv_v;
    END IF;
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
/* PROCEDURE: HuyPhieuDatPhong                           */
/*==============================================================*/

CREATE OR REPLACE PROCEDURE HuyPhieuDatPhong(madatphong_i IN PHIEUDATPHONG.MADATPHONG%TYPE)
as
    ttNhanPhong_v PHIEUDATPHONG.TTNHANPHONG%TYPE;
BEGIN
    SELECT TTNHANPHONG INTO ttNhanPhong_v FROM PHIEUDATPHONG WHERE MADATPHONG = madatphong_i;
    IF ttNhanPhong_v = 1 or ttNhanPhong_v = 2
    THEN
        DBMS_OUTPUT.PUT_LINE('PHIEU DAT PHONG DA NHAN PHONG, KHONG THE HUY');
    ELSE
        DELETE FROM CHITIETDATPHONG WHERE MADATPHONG = madatphong_i;
        UPDATE PHIEUDATPHONG SET TTNHANPHONG = -1 WHERE MADATPHONG = madatphong_i;
        COMMIT;
    END IF;
END;
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
                    WHERE 
--                    TRUNC(NGAYTRA) < TRUNC(SYSDATE) 
--                        OR 
                        ( TRUNC(ngaynhan_i) <= TRUNC(NGAYNHAN) AND TRUNC(NGAYNHAN) <= TRUNC(ngaytra_i))
                        OR ( TRUNC(ngaynhan_i) <= TRUNC(NGAYTRA) AND TRUNC(NGAYTRA) <= TRUNC(ngaytra_i) ) 
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

--Procedure Xoa don dv
create or replace PROCEDURE DELETE_DON_DV(maphg_i IN PHONG.MAPHG%TYPE, madv_i IN DANHMUCDICHVU.MADV%TYPE)
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
        DELETE FROM HOADONDV WHERE MADATPHONG = madatphong_v 
        and MADV = madv_i;
        COMMIT;
    END IF;
END DELETE_DON_DV;
/


--Procedure lay danh sach dv tu don dv
create or replace PROCEDURE GET_LIST_DON_DV(maphg_i IN PHONG.MAPHG%TYPE)
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
        SELECT DMDV.TENDV, HDDV.THOIGIANDAT, HDDV.SOLUONG, DMDV.DONGIA FROM HOADONDV HDDV, DANHMUCDICHVU DMDV
            WHERE DMDV.MADV = HDDV.MADV AND HDDV.MADATPHONG = madatphong_v; 
        COMMIT;
    END IF;
END GET_LIST_DON_DV;
/
CREATE OR REPLACE PROCEDURE XacNhanNhanPhong(madatphong_i in PHIEUDATPHONG.MADATPHONG%TYPE)
AS
    CURSOR phongdat_cur IS SELECT MAPHG FROM CHITIETDATPHONG WHERE MADATPHONG = madatphong_i;
    maphg_v PHONG.MAPHG%TYPE;
    madatphong_v PHIEUDATPHONG.MADATPHONG%TYPE;
BEGIN
    SELECT MADATPHONG INTO madatphong_v FROM PHIEUDATPHONG WHERE MADATPHONG = madatphong_i AND TTNHANPHONG = 0;
    IF SQL%NOTFOUND
    THEN 
        RAISE_APPLICATION_ERROR(-2000,'XAC NHAN NHAN PHONG THAT BAI');
    END IF;
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



CREATE OR REPLACE PROCEDURE XacNhanThanhToan(madatphong_i IN PHIEUDATPHONG.MADATPHONG%TYPE)
IS
    tientra_v THANHTOAN.TIENKHACHDUA%TYPE;
    thanhtien_v THANHTOAN.THANHTIEN%TYPE;
BEGIN
--    SELECT TIENKHACHDUA, THANHTIEN INTO tientra_v, thanhtien_v FROM THANHTOAN WHERE MADATPHONG = madatphong_i;
--    IF thanhtien_v = GET_TONGTIEN_THANHTOAN(madatphong_i) AND tientra_v >= thanhtien_v
--        CAP NHAT TINH TRANG DA THANH TOAN CUA PHIEUDATPHONG
--    insert into thanhtoan(madatphong,manv) values (madatphong_i,1);
    UPDATE PHIEUDATPHONG SET TTNHANPHONG  = 2 WHERE MADATPHONG = madatphong_i; 
    DECLARE
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
                SET TINHTRANG = 0
                WHERE MAPHG = maphg_v;
            end if;
        END LOOP;
    END;
    UPDATE HOADONDV SET TINHTRANG = 1 WHERE MADATPHONG = madatphong_i;
    UPDATE HOADONTIEC SET TINHTRANG = 1 WHERE MADATPHONG = madatphong_i;
    COMMIT;
END;
/



CREATE OR REPLACE PROCEDURE INSERT_DON_TIEC(maphg_i IN PHONG.MAPHG%TYPE, manv_i NHANVIEN.MANV%TYPE, makh_i IN KHACHHANG.MAKH%TYPE,
mota_i IN HOADONTIEC.MOTA%TYPE, tinhtrang_i IN HOADONTIEC.TINHTRANG%TYPE, thanhtien_i IN HOADONTIEC.THANHTIEN%TYPE, thoigiandat_i IN HOADONTIEC.THOIGIANDAT%TYPE,
tientratruoc_i IN HOADONTIEC.TIENTRATRUOC%TYPE, ngaynhantiec_i IN HOADONTIEC.NGAYNHANTIEC%TYPE, sokhach_i IN HOADONTIEC.SOKHACH%TYPE)
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
        INSERT INTO HOADONTIEC (MADATPHONG, MAPHG, MANV, MAKH, SOKHACH, MOTA, TINHTRANG, THANHTIEN, THOIGIANDAT, TIENTRATRUOC, NGAYNHANTIEC)
        VALUES (madatphong_v, maphg_i, manv_i, makh_i, sokhach_i, mota_i, tinhtrang_i, thanhtien_i, thoigiandat_i, tientratruoc_i, ngaynhantiec_i);
        COMMIT;
    END IF;
END INSERT_DON_TIEC;
/    


CREATE OR REPLACE PROCEDURE UPDATE_DONTIEC(maphg_i IN PHONG.MAPHG%TYPE, manv_i IN NHANVIEN.MANV%TYPE, makh_i IN KHACHHANG.MAKH%TYPE,
mota_i IN HOADONTIEC.MOTA%TYPE, tinhtrang_i IN HOADONTIEC.TINHTRANG%TYPE, thanhtien_i IN HOADONTIEC.THANHTIEN%TYPE, tientratruoc_i IN HOADONTIEC.TIENTRATRUOC%TYPE,
ngaynhantiec_i IN HOADONTIEC.NGAYNHANTIEC%TYPE, sokhach_i IN HOADONTIEC.SOKHACH%TYPE, matiec_i IN HOADONTIEC.MATIEC%TYPE)
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
        UPDATE HOADONTIEC
        SET MADATPHONG = madatphong_v, MAPHG = maphg_i, MANV = manv_i, MAKH = makh_i, SOKHACH = sokhach_i, MOTA = mota_i,
        TINHTRANG = tinhtrang_i, THANHTIEN = thanhtien_i, TIENTRATRUOC = tientratruoc_i, NGAYNHANTIEC = ngaynhantiec_i
        WHERE MATIEC = matiec_i;
        COMMIT;
    END IF;
END UPDATE_DONTIEC;
/

    







/*END OF PL/SQL                            */








/* START OF INSERT VALUES                           */



insert into KhachHang (TenKH, CCCD, SDT, GioiTinh) values ( 'Nguyen Van A', '000000101', '012340201','Nam');
insert into KhachHang (TenKH, CCCD, SDT, GioiTinh) values ('Pham B', '000002002', '014342104','Nam');
insert into KhachHang (TenKH, CCCD, SDT, GioiTinh) values ( 'Tran Nguyen C', '000001609', '048390301','N?');
insert into KhachHang (TenKH, CCCD, SDT, GioiTinh) values ( 'Ngo Ba K', '000003105', '083440546','N?');
insert into KhachHang (TenKH, CCCD, SDT, GioiTinh) values ( 'My D', '000500402', '058393261', 'N?');

insert into NhanVien (TenNV, CCCD, SDT, NGAYSINH, GioiTinh, NGAYVL, ChucVu) values ( 'My Duyen', '0540041801','014380245',TO_DATE('2003/05/03', 'yyyy/mm/dd ') ,'N?',TO_DATE('2021/05/03', 'yyyy/mm/dd '),'Ti?p tân');
insert into NhanVien (TenNV, CCCD, SDT, NGAYSINH, GioiTinh, NGAYVL, ChucVu) values ('Thanh Tuyen', '0841021350','044588292',TO_DATE('2003/05/03', 'yyyy/mm/dd '),'N?',TO_DATE('2021/05/03', 'yyyy/mm/dd '),'Ti?p tân');
insert into NhanVien (TenNV, CCCD, SDT, NGAYSINH, GioiTinh, NGAYVL, ChucVu) values ( 'Duc Trong', '0020543899','097380284',TO_DATE('2003/05/03', 'yyyy/mm/dd '),'Nam',TO_DATE('2021/05/03', 'yyyy/mm/dd '),'Qu?n l?');
insert into NhanVien (TenNV, CCCD, SDT, NGAYSINH, GioiTinh, NGAYVL, ChucVu) values ( 'Quynh Nga', '023050002','078720655',TO_DATE('2003/05/03', 'yyyy/mm/dd '),'N?',TO_DATE('2021/05/03', 'yyyy/mm/dd '),'Nhân viên');
insert into NhanVien (TenNV, CCCD, SDT, NGAYSINH, GioiTinh, NGAYVL, ChucVu) values ( 'Chau Dat', '0250049004','091250622',TO_DATE('2003/05/03', 'yyyy/mm/dd '),'Nam',TO_DATE('2009/05/03', 'yyyy/mm/dd '),'Nhân viên');

insert into DANHMUCMONAN (TENMONAN, DONGIA) values ( 'Phi le bo Kobe', 6000000);
insert into DANHMUCMONAN (TENMONAN, DONGIA) values ( 'Cua hoang de', 20000000);
insert into DANHMUCMONAN (TENMONAN, DONGIA) values ('Trung ca muoi hoang de', 20000000);
insert into DANHMUCMONAN (TENMONAN, DONGIA) values ( 'Bit tet bo Wagyu', 64000000);
insert into DANHMUCMONAN (TENMONAN, DONGIA) values ( 'Banh mi bo kho', 50000);
insert into DANHMUCMONAN (TENMONAN, DONGIA) values ( 'Cha ram', 40000);
insert into DANHMUCMONAN (TENMONAN, DONGIA) values ( 'Ga 9 cua hap muoi', 200000);
insert into DANHMUCMONAN (TENMONAN, DONGIA) values ( 'Xoi 7 mau', 30000);
insert into DANHMUCMONAN (TENMONAN, DONGIA) values ( 'Pho kho Gia Lai',35000);
insert into DANHMUCMONAN (TENMONAN, DONGIA) values ( 'Bo ne 3 ngon', 35000);

insert into DANHMUCDICHVU(TENDV,DONGIA) values ( 'Don phong', 20000);
insert into DANHMUCDICHVU(TENDV,DONGIA) values ('Giat ui', 30000);
insert into DANHMUCDICHVU(TENDV,DONGIA) values ( 'Trong tre', 50000);
insert into DANHMUCDICHVU(TENDV,DONGIA) values ( 'Thue xe tu lai', 200000);
insert into DANHMUCDICHVU(TENDV,DONGIA) values ( 'Cham soc thu cung', 100000);
insert into DANHMUCDICHVU(TENDV,DONGIA) values ( 'Spa', 300000);
insert into DANHMUCDICHVU(TENDV,DONGIA) values ( 'Dua don san bay', 150000);
insert into DANHMUCDICHVU(TENDV,DONGIA) values ( 'Karaoke', 100000);

insert into LOAIPHONG(MALOAIPHG, KIEUPHONG, KIEUGIUONG, MOTA,  DONGIA) values ('LP-STD01','Standard', 1, 'Phong tieu chuan - Giuong don', 300000);
insert into LOAIPHONG(MALOAIPHG, KIEUPHONG, KIEUGIUONG, MOTA,  DONGIA) values ('LP-STD02','Standard', 2, 'Phong tieu chuan - Giuong doi nho', 400000);
insert into LOAIPHONG(MALOAIPHG, KIEUPHONG, KIEUGIUONG, MOTA,  DONGIA) values ('LP-STD03','Standard', 4, 'Phong tieu chuan - Giuong doi lon', 500000);
insert into LOAIPHONG(MALOAIPHG, KIEUPHONG, KIEUGIUONG, MOTA,  DONGIA) values ('LP-SUP01','Superior', 1, 'Phong cao cap Superior - Giuong don', 1000000);
insert into LOAIPHONG(MALOAIPHG, KIEUPHONG, KIEUGIUONG, MOTA,  DONGIA) values ('LP-SUP02','Superior', 4, 'Phong cao cap Superior - Giuong doi lon', 1200000);
insert into LOAIPHONG(MALOAIPHG, KIEUPHONG, KIEUGIUONG, MOTA,  DONGIA) values ('LP-DLX01','Deluxe', 2, 'Phong cao cap Deluxe - Giuong don nho', 1500000);
insert into LOAIPHONG(MALOAIPHG, KIEUPHONG, KIEUGIUONG, MOTA,  DONGIA) values ('LP-DLX02','Deluxe', 4, 'Phong cao cap Deluxe - Giuong doi lon', 1800000);
insert into LOAIPHONG(MALOAIPHG, KIEUPHONG, KIEUGIUONG, MOTA,  DONGIA) values ('LP-SUT01','Suite', 1, 'Phong cao cap Suite - Giuong don lon', 2000000);
insert into LOAIPHONG(MALOAIPHG, KIEUPHONG, KIEUGIUONG, MOTA,  DONGIA) values ('LP-SUT02','Suite', 2, 'Phong cao cap Suite - Giuong doi lon', 2500000);

insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('01-STD', 'LP-STD01', 'Phong tieu chuan - Giuong don - Tang 1', 1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('02-STD', 'LP-STD01', 'Phong tieu chuan - Giuong don - Tang 1', 0);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('03-STD', 'LP-STD01', 'Phong tieu chuan - Giuong don - Tang 1', 1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('04-STD', 'LP-STD01', 'Phong tieu chuan - Giuong don - Tang 1', 1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('05-STD', 'LP-STD01', 'Phong tieu chuan - Giuong don - Tang 1', 1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('06-STD', 'LP-STD01', 'Phong tieu chuan - Giuong don - Tang 1', 1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('07-STD', 'LP-STD01', 'Phong tieu chuan - Giuong don - Tang 1', 1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('08-STD', 'LP-STD01', 'Phong tieu chuan - Giuong don - Tang 1', 1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('09-STD', 'LP-STD01', 'Phong tieu chuan - Giuong don - Tang 1', 1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('10-STD', 'LP-STD01', 'Phong tieu chuan - Giuong don - Tang 1', 1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('11-STD', 'LP-STD01', 'Phong tieu chuan - Giuong don - Tang 1', 1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('12-STD', 'LP-STD01', 'Phong tieu chuan - Giuong don - Tang 1', 1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('13-STD', 'LP-STD01', 'Phong tieu chuan - Giuong don - Tang 1', 1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('14-STD', 'LP-STD01', 'Phong tieu chuan - Giuong don - Tang 1', 1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('15-STD', 'LP-STD01', 'Phong tieu chuan - Giuong don - Tang 1', 1);

insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('16-STD', 'LP-STD02', 'Phong tieu chuan - Giuong doi nho - Tang 1', 0);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('17-STD', 'LP-STD02', 'Phong tieu chuan - Giuong doi nho - Tang 1', 1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('18-STD', 'LP-STD02', 'Phong tieu chuan - Giuong doi nho - Tang 1', 1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('19-STD', 'LP-STD02', 'Phong tieu chuan - Giuong doi nho - Tang 1', 1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('20-STD', 'LP-STD02', 'Phong tieu chuan - Giuong doi nho - Tang 1', 1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('21-STD', 'LP-STD02', 'Phong tieu chuan - Giuong doi nho - Tang 2', 1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('22-STD', 'LP-STD02', 'Phong tieu chuan - Giuong doi nho - Tang 2', 1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('23-STD', 'LP-STD02', 'Phong tieu chuan - Giuong doi nho - Tang 2', 1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('24-STD', 'LP-STD02', 'Phong tieu chuan - Giuong doi nho - Tang 2', 1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('25-STD', 'LP-STD02', 'Phong tieu chuan - Giuong doi nho - Tang 2', 1);

insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('26-STD', 'LP-STD03', 'Phong tieu chuan - Giuong doi lon - Tang 2', 1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('27-STD', 'LP-STD03', 'Phong tieu chuan - Giuong doi lon - Tang 2', 1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('28-STD', 'LP-STD03', 'Phong tieu chuan - Giuong doi lon - Tang 2', 1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('29-STD', 'LP-STD03', 'Phong tieu chuan - Giuong doi lon - Tang 2', 1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('30-STD', 'LP-STD03', 'Phong tieu chuan - Giuong doi lon - Tang 2', 1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('31-STD', 'LP-STD03', 'Phong tieu chuan - Giuong doi lon - Tang 2', 1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('32-STD', 'LP-STD03', 'Phong tieu chuan - Giuong doi lon - Tang 2', 1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('33-STD', 'LP-STD03', 'Phong tieu chuan - Giuong doi lon - Tang 2', 1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('34-STD', 'LP-STD03', 'Phong tieu chuan - Giuong doi lon - Tang 2', 1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('35-STD', 'LP-STD03', 'Phong tieu chuan - Giuong doi lon - Tang 2', 1);

insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('01-SUP', 'LP-SUP01', 'Phong cao cap Superior - Giuong don - Tang 3',1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('02-SUP', 'LP-SUP01', 'Phong cao cap Superior - Giuong don - Tang 3',1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('03-SUP', 'LP-SUP01', 'Phong cao cap Superior - Giuong don - Tang 3',1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('04-SUP', 'LP-SUP01', 'Phong cao cap Superior - Giuong don - Tang 3',1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('05-SUP', 'LP-SUP01', 'Phong cao cap Superior - Giuong don - Tang 3',1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('06-SUP', 'LP-SUP01', 'Phong cao cap Superior - Giuong don - Tang 3',1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('07-SUP', 'LP-SUP01', 'Phong cao cap Superior - Giuong don - Tang 3',1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('08-SUP', 'LP-SUP01', 'Phong cao cap Superior - Giuong don - Tang 3',1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('09-SUP', 'LP-SUP01', 'Phong cao cap Superior - Giuong don - Tang 3',1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('10-SUP', 'LP-SUP01', 'Phong cao cap Superior - Giuong don - Tang 3',1);

insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('11-SUP', 'LP-SUP02', 'Phong cao cap Superior - Giuong doi lon - Tang 4',1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('12-SUP', 'LP-SUP02', 'Phong cao cap Superior - Giuong doi lon - Tang 4',1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('13-SUP', 'LP-SUP02', 'Phong cao cap Superior - Giuong doi lon - Tang 4',1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('14-SUP', 'LP-SUP02', 'Phong cao cap Superior - Giuong doi lon - Tang 4',1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('15-SUP', 'LP-SUP02', 'Phong cao cap Superior - Giuong doi lon - Tang 4',1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('16-SUP', 'LP-SUP02', 'Phong cao cap Superior - Giuong doi lon - Tang 4',1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('17-SUP', 'LP-SUP02', 'Phong cao cap Superior - Giuong doi lon - Tang 4',1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('18-SUP', 'LP-SUP02', 'Phong cao cap Superior - Giuong doi lon - Tang 4',1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('19-SUP', 'LP-SUP02', 'Phong cao cap Superior - Giuong doi lon - Tang 4',1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('20-SUP', 'LP-SUP02', 'Phong cao cap Superior - Giuong doi lon - Tang 4',1);

insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('01-DLX', 'LP-DLX01', 'Phong cao cap Deluxe - Giuong don lon - Tang 5', 1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('02-DLX', 'LP-DLX01', 'Phong cao cap Deluxe - Giuong don lon - Tang 5', 1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('03-DLX', 'LP-DLX01', 'Phong cao cap Deluxe - Giuong don lon - Tang 5', 1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('04-DLX', 'LP-DLX01', 'Phong cao cap Deluxe - Giuong don lon - Tang 5', 1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('05-DLX', 'LP-DLX01', 'Phong cao cap Deluxe - Giuong don lon - Tang 5', 1);

insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('06-DLX', 'LP-DLX02', 'Phong cao cap Deluxe - Giuong doi lon - Tang 6',1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('07-DLX', 'LP-DLX02', 'Phong cao cap Deluxe - Giuong doi lon - Tang 6',1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('08-DLX', 'LP-DLX02', 'Phong cao cap Deluxe - Giuong doi lon - Tang 6',1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('09-DLX', 'LP-DLX02', 'Phong cao cap Deluxe - Giuong doi lon - Tang 6',1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('10-DLX', 'LP-DLX02', 'Phong cao cap Deluxe - Giuong doi lon - Tang 6',1);

insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('01-SUT', 'LP-SUT01', 'Phong cao cap Suite - Giuong don lon - Tang 7', 1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('02-SUT', 'LP-SUT01', 'Phong cao cap Suite - Giuong don lon - Tang 7', 1);

insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('VIP-SUT', 'LP-SUT02', 'Phong cao cap Suite - Giuong doi lon - Tang 8',0);

/*insert into PHIEUDATPHONG (MANV, MAKH, NGAYNHAN, NGAYTRA, TTNHANPHONG) VALUES (3,4,TO_DATE('2021/6/2', 'yyyy/mm/dd '),TO_DATE('2021/6/4', 'yyyy/mm/dd '),1);

insert into CHITIETDATPHONG(MADATPHONG,MAPHG) VALUES (1,'21-STD');
insert into CHITIETDATPHONG(MADATPHONG,MAPHG) VALUES (1,'02-SUT');
insert into CHITIETDATPHONG(MADATPHONG,MAPHG) VALUES (1,'19-SUP');
insert into CHITIETDATPHONG(MADATPHONG,MAPHG) VALUES (1,'20-STD');
SELECT * FROM PHIEUDATPHONG;
INSERT INTO HOADONDV (MADATPHONG, MAKH, MANV, MAPHG) VALUES (1,2,1,'02-SUT');
SELECT * FROM HOADONDV;
select * from chitietdondv;
SELECT * FROM DANHMUCDICHVU;
INSERT INTO CHITIETDONDV (MAHDDV, MADV, SOLUONG) VALUES (1,1,3);
/* END OF INSERT VALUES*/
--select current_date - to_date('2021/6/2', 'yyyy/mm/dd ') from dual;


--------add values----------

insert into Phieudatphong(manv, makh, ngaydat, ngaynhan, ngaytra, ttnhanphong, tienphong) 
values (2, 1, to_date('2021/06/23', 'yyyy/mm/dd'), to_date('2021/06/23', 'yyyy/mm/dd'), to_date('2021/06/27', 'yyyy/mm/dd'), 1, 0);
insert into Phieudatphong(manv, makh, ngaydat, ngaynhan, ngaytra, ttnhanphong, tienphong) 
values (4, 2, to_date('2021/06/23', 'yyyy/mm/dd'), to_date('2021/06/23', 'yyyy/mm/dd'), to_date('2021/06/30', 'yyyy/mm/dd'), 1, 0);
insert into Phieudatphong(manv, makh, ngaydat, ngaynhan, ngaytra, ttnhanphong, tienphong) 
values (5, 3, to_date('2021/06/23', 'yyyy/mm/dd'), to_date('2021/06/23', 'yyyy/mm/dd'), to_date('2021/07/01', 'yyyy/mm/dd'), 1, 0);
insert into Phieudatphong(manv, makh, ngaydat, ngaynhan, ngaytra, ttnhanphong, tienphong) 
values (1, 4, to_date('2021/06/15', 'yyyy/mm/dd'), to_date('2021/07/01', 'yyyy/mm/dd'), to_date('2021/07/03', 'yyyy/mm/dd'), 0, 0);
insert into Phieudatphong(manv, makh, ngaydat, ngaynhan, ngaytra, ttnhanphong, tienphong) 
values (4, 1, to_date('2021/06/15', 'yyyy/mm/dd'), to_date('2021/07/15', 'yyyy/mm/dd'), to_date('2021/07/18', 'yyyy/mm/dd'), 0, 0);
insert into Phieudatphong(manv, makh, ngaydat, ngaynhan, ngaytra, ttnhanphong, tienphong) 
values (3, 5, to_date('2021/06/15', 'yyyy/mm/dd'), to_date('2021/07/20', 'yyyy/mm/dd'), to_date('2021/07/22', 'yyyy/mm/dd'), 0, 0);
insert into Phieudatphong(manv, makh, ngaydat, ngaynhan, ngaytra, ttnhanphong, tienphong) 
values (4, 4, to_date('2021/06/15', 'yyyy/mm/dd'), to_date('2021/08/02', 'yyyy/mm/dd'), to_date('2021/08/03', 'yyyy/mm/dd'), 0, 0);
insert into Phieudatphong(manv, makh, ngaydat, ngaynhan, ngaytra, ttnhanphong, tienphong) 
values (1, 2, to_date('2021/06/15', 'yyyy/mm/dd'), to_date('2021/08/08', 'yyyy/mm/dd'), to_date('2021/08/09', 'yyyy/mm/dd'), 0, 0);


insert into chitietdatphong(MAPHG, MADATPHONG) values ('02-STD', 1);
insert into chitietdatphong(MAPHG, MADATPHONG) values ('16-STD', 2);
insert into chitietdatphong(MAPHG, MADATPHONG) values ('VIP-SUT', 3);
insert into chitietdatphong(MAPHG, MADATPHONG) values ('26-STD', 4);
insert into chitietdatphong(MAPHG, MADATPHONG) values ('03-STD', 5);
insert into chitietdatphong(MAPHG, MADATPHONG) values ('01-SUP', 6);
insert into chitietdatphong(MAPHG, MADATPHONG) values ('02-SUP', 7);
insert into chitietdatphong(MAPHG, MADATPHONG) values ('01-SUP', 8);
insert into chitietdatphong(MAPHG, MADATPHONG) values ('02-SUP', 8);


insert into hoadondv(madatphong, manv, maphg, madv, soluong, thanhtien, tinhtrang, thoigiandat)
values (1, 2, '02-STD', 1,2, 0, 0, to_date('2021/06/16', 'yyyy/mm/dd'));
insert into hoadondv(madatphong, manv, maphg, madv, soluong, thanhtien, tinhtrang, thoigiandat)
values (3, 5, 'VIP-SUT', 3,1, 0, 0, to_date('2021/06/20', 'yyyy/mm/dd'));
insert into hoadondv(madatphong, manv, maphg, madv, soluong, thanhtien, tinhtrang, thoigiandat)
values (7, 4, '02-SUP', 4,3, 0, 0, to_date('2021/08/02', 'yyyy/mm/dd'));


insert into hoadontiec(manv, maphg, makh, madatphong, tinhtrang, thanhtien, thoigiandat)
values (2, '02-STD', 1, 1, 0, 0, to_date('2021/06/16', 'yyyy/mm/dd'));
insert into hoadontiec(manv, maphg, makh, madatphong, tinhtrang, thanhtien, thoigiandat)
values (4, '03-STD', 1, 5, 0, 0, to_date('2021/07/17', 'yyyy/mm/dd'));
insert into hoadontiec(manv, maphg, makh, madatphong, tinhtrang, thanhtien, thoigiandat)
values (3, '01-SUP', 5, 6, 0, 0, to_date('2021/07/21', 'yyyy/mm/dd'));

insert into chitiettiec(MATIEC, MAMONAN, soluong, dongiamonan) values (1, 5, 2, 50000);
insert into chitiettiec(MATIEC, MAMONAN, soluong, dongiamonan) values (1, 6, 1, 40000);
insert into chitiettiec(MATIEC, MAMONAN, soluong, dongiamonan) values (1, 7, 1, 200000);
insert into chitiettiec(MATIEC, MAMONAN, soluong, dongiamonan) values (2, 7, 1, 200000);
insert into chitiettiec(MATIEC, MAMONAN, soluong, dongiamonan) values (2, 9, 1, 35000);
insert into chitiettiec(MATIEC, MAMONAN, soluong, dongiamonan) values (2, 10, 1, 35000);
insert into chitiettiec(MATIEC, MAMONAN, soluong, dongiamonan) values (3, 5, 2, 50000);
insert into chitiettiec(MATIEC, MAMONAN, soluong, dongiamonan) values (3, 7, 1, 200000);
insert into chitiettiec(MATIEC, MAMONAN, soluong, dongiamonan) values (3, 8, 1, 30000);
insert into chitiettiec(MATIEC, MAMONAN, soluong, dongiamonan) values (3, 9, 2, 35000);

insert into thanhtoan(madatphong, manv, thanhtien, hinhthucthanhtoan, ngaylap, tienkhachdua)
values (1, 2, GET_TONGTIEN_THANHTOAN(1), 'truc tiep', to_date('2021/06/17', 'yyyy/mm/dd'), 0);
insert into thanhtoan(madatphong, manv, thanhtien, hinhthucthanhtoan, ngaylap, tienkhachdua)
values (2, 4, GET_TONGTIEN_THANHTOAN(2), 'truc tiep', to_date('2021/06/18', 'yyyy/mm/dd'), 0);
insert into thanhtoan(madatphong, manv, thanhtien, hinhthucthanhtoan, ngaylap, tienkhachdua)
values (3, 5, GET_TONGTIEN_THANHTOAN(3), 'truc tiep', to_date('2021/06/21', 'yyyy/mm/dd'), 0);
insert into thanhtoan(madatphong, manv, thanhtien, hinhthucthanhtoan, ngaylap, tienkhachdua)
values (4, 1, GET_TONGTIEN_THANHTOAN(4), 'onl', to_date('2021/07/03', 'yyyy/mm/dd'), 0);
insert into thanhtoan(madatphong, manv, thanhtien, hinhthucthanhtoan, ngaylap, tienkhachdua)
values (5, 4, GET_TONGTIEN_THANHTOAN(5), 'onl', to_date('2021/07/18', 'yyyy/mm/dd'), 0);
insert into thanhtoan(madatphong, manv, thanhtien, hinhthucthanhtoan, ngaylap, tienkhachdua)
values (6, 3, GET_TONGTIEN_THANHTOAN(6), 'onl', to_date('2021/07/22', 'yyyy/mm/dd'), 0);
insert into thanhtoan(madatphong, manv, thanhtien, hinhthucthanhtoan, ngaylap, tienkhachdua)
values (7, 4, GET_TONGTIEN_THANHTOAN(7), 'onl', to_date('2021/08/03', 'yyyy/mm/dd'), 0);
insert into thanhtoan(madatphong, manv, thanhtien, hinhthucthanhtoan, ngaylap, tienkhachdua)
values (8, 1, GET_TONGTIEN_THANHTOAN(8), 'onl', to_date('2021/08/09', 'yyyy/mm/dd'), 0);



insert into taikhoan(tentaikhoan,manv,matkhau,quyen) values ('admin',1,'admin','admin');
insert into taikhoan(tentaikhoan,manv,matkhau,quyen) values ('user',2,'user','user');
commit;
