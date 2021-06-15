/*==============================================================*/
/* DBMS name:      ORACLE Version 11g                           */
/* Created on:     6/12/2021 11:19:57 AM                        */
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
   drop constraint FK_HOADONDV_THANHTOAN_PHIEUDAT;

alter table HOADONDV
   drop constraint FK_HOADONDV_THUCHIEN_NHANVIEN;

alter table HOADONTIEC
   drop constraint FK_HOADONTI_DATTIEC_KHACHHAN;

alter table HOADONTIEC
   drop constraint FK_HOADONTI_DATTIECTU_PHONG;

alter table HOADONTIEC
   drop constraint FK_HOADONTI_DUOC_THUC_NHANVIEN;

alter table HOADONTIEC
   drop constraint FK_HOADONTI_THANHTOAN_PHIEUDAT;

alter table LUU_TRU
   drop constraint FK_LUU_TRU_LUU_TRU_KHACHHAN;

alter table LUU_TRU
   drop constraint FK_LUU_TRU_LUU_TRU2_PHONG;

alter table LUU_TRU
   drop constraint FK_LUU_TRU_LUU_TRU3_PHIEUDAT;

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

drop index THANHTOANDV_FK;

drop index THUCHIEN_FK;

drop index GOMDV_FK;

drop table HOADONDV cascade constraints;

drop index DATTIECTUPHONG_FK;

drop index THANHTOANTIEC_FK;

drop index DUOC_THUC_HIEN_FK;

drop index DATTIEC_FK;

drop table HOADONTIEC cascade constraints;

drop table KHACHHANG cascade constraints;

drop table LOAIPHONG cascade constraints;

drop index LUU_TRU3_FK;

drop index LUU_TRU2_FK;

drop index LUU_TRU_FK;

drop table LUU_TRU cascade constraints;

drop table NHANVIEN cascade constraints;

drop index XACMINH_FK;

drop index DATPHONG_FK;

drop table PHIEUDATPHONG cascade constraints;

drop index THUOC_FK;

drop table PHONG cascade constraints;

drop index CO_FK2;

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
   TENDV                VARCHAR2(20),
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
   TENMONAN             VARCHAR2(20),
   DONGIA               NUMBER(19,0),
   constraint PK_DANHMUCMONAN primary key (MAMONAN)
);

/*==============================================================*/
/* Table: HOADONDV                                              */
/*==============================================================*/
create table HOADONDV 
(
   MAHDDV               NUMBER(9)           default MAHDDV_SEQ.NEXTVAL            not null,
   MADATPHONG           NUMBER(9),
   MADV                 NUMBER(9)            not null,
   MANV                 NUMBER(9)            not null,
   MAPHG                VARCHAR2(8),
   THANHTIEN            NUMBER(19,0),
   TINHTRANG            SMALLINT,
   THOIGIANDAT          DATE,
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
/* Index: THANHTOANDV_FK                                        */
/*==============================================================*/
create index THANHTOANDV_FK on HOADONDV (
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
   MADATPHONG           NUMBER(9),
   MOTA                 VARCHAR2(100),
   TINHTRANG            SMALLINT,
   THANHTIEN            NUMBER(19,0),
   THOIGIANDAT          DATE,
   TIENTRATRUOC         NUMBER(19,0),
   NGAYNHANTIEC         DATE,
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
/* Index: THANHTOANTIEC_FK                                      */
/*==============================================================*/
create index THANHTOANTIEC_FK on HOADONTIEC (
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
/* Table: LUU_TRU                                               */
/*==============================================================*/
create table LUU_TRU 
(
   MAKH                 NUMBER(9)            not null,
   MAPHG                VARCHAR2(8)          not null,
   MADATPHONG           NUMBER(9)            not null,
   constraint PK_LUU_TRU primary key (MAKH, MAPHG, MADATPHONG)
);

/*==============================================================*/
/* Index: LUU_TRU_FK                                            */
/*==============================================================*/
create index LUU_TRU_FK on LUU_TRU (
   MAKH ASC
);

/*==============================================================*/
/* Index: LUU_TRU2_FK                                           */
/*==============================================================*/
create index LUU_TRU2_FK on LUU_TRU (
   MAPHG ASC
);

/*==============================================================*/
/* Index: LUU_TRU3_FK                                           */
/*==============================================================*/
create index LUU_TRU3_FK on LUU_TRU (
   MADATPHONG ASC
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
   NGAYDAT              DATE,
   NGAYNHAN             DATE,
   NGAYTRA              DATE,
   TTNHANPHONG          SMALLINT,
   TIEN                 NUMBER(19,0),
   PHUPHI               NUMBER(19,0),
   TIENTRATRUOC         NUMBER(19,0),
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
   TINHTRANG            SMALLINT,
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
/* Index: CO_FK2                                                */
/*==============================================================*/
create index CO_FK2 on TAIKHOAN (
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
   THANHTIEN            NUMBER(19,0),
   HINHTHUCTHANHTOAN    VARCHAR2(10),
   NGAYLAP              DATE,
   TIENKHACHDUA         CHAR(10),
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
   add constraint FK_HOADONDV_THANHTOAN_PHIEUDAT foreign key (MADATPHONG)
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
   add constraint FK_HOADONTI_THANHTOAN_PHIEUDAT foreign key (MADATPHONG)
      references PHIEUDATPHONG (MADATPHONG);

alter table LUU_TRU
   add constraint FK_LUU_TRU_LUU_TRU_KHACHHAN foreign key (MAKH)
      references KHACHHANG (MAKH);

alter table LUU_TRU
   add constraint FK_LUU_TRU_LUU_TRU2_PHONG foreign key (MAPHG)
      references PHONG (MAPHG);

alter table LUU_TRU
   add constraint FK_LUU_TRU_LUU_TRU3_PHIEUDAT foreign key (MADATPHONG)
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

