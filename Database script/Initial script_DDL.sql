/*==============================================================*/
/* DBMS name:      ORACLE Version 11g                           */
/* Created on:     5/30/2021 9:29:57 PM                         */
/*==============================================================*/


alter table CHITIETDATPHONG
   drop constraint FK_CHITIETD_CHITIETDA_PHONG;

alter table CHITIETDATPHONG
   drop constraint FK_CHITIETD_CHITIETDA_PHIEUDAT;

alter table CHITIETDONDV
   drop constraint FK_CHITIETD_CHITIETDO_HOADONDV;

alter table CHITIETDONDV
   drop constraint FK_CHITIETD_CHITIETDO_DANHMUCD;

alter table CHITIETTIEC
   drop constraint FK_CHITIETT_CHITIETTI_HOADONTI;

alter table CHITIETTIEC
   drop constraint FK_CHITIETT_CHITIETTI_DANHMUCM;

alter table HOADONDV
   drop constraint FK_HOADONDV_DATDV_KHACHHAN;

alter table HOADONDV
   drop constraint FK_HOADONDV_DATDVTUPH_PHONG;

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

alter table luutru
   drop constraint FK_luutru_luutru_KHACHHAN;

alter table luutru
   drop constraint FK_luutru_luutru2_PHONG;

alter table luutru
   drop constraint FK_luutru_luutru3_PHIEUDAT;

alter table PHIEUDATPHONG
   drop constraint FK_PHIEUDAT_DATPHONG_KHACHHAN;

alter table PHIEUDATPHONG
   drop constraint FK_PHIEUDAT_XACMINH_NHANVIEN;

alter table PHONG
   drop constraint FK_PHONG_THUOC_LOAIPHON;

alter table THANHTOAN
   drop constraint FK_THANHTOA_THUNGAN_NHANVIEN;

alter table THANHTOAN
   drop constraint FK_THANHTOA_TIENHANH_PHIEUDAT;

drop index CHITIETDATPHONG2_FK;

drop index CHITIETDATPHONG_FK;

drop table CHITIETDATPHONG cascade constraints;

drop index CHITIETDONDV2_FK;

drop index CHITIETDONDV_FK;

drop table CHITIETDONDV cascade constraints;

drop index CHITIETTIEC2_FK;

drop index CHITIETTIEC_FK;

drop table CHITIETTIEC cascade constraints;

drop table DANHMUCDICHVU cascade constraints;

drop table DANHMUCMONAN cascade constraints;

drop index DATDVTUPHONG_FK;

drop index THANHTOANDV_FK;

drop index THUCHIEN_FK;

drop index DATDV_FK;

drop table HOADONDV cascade constraints;

drop index DATTIECTUPHONG_FK;

drop index THANHTOANTIEC_FK;

drop index DUOC_THUC_HIEN_FK;

drop index DATTIEC_FK;

drop table HOADONTIEC cascade constraints;

drop table KHACHHANG cascade constraints;

drop table LOAIPHONG cascade constraints;

drop index luutru3_FK;

drop index luutru2_FK;

drop index luutru_FK;

drop table luutru cascade constraints;

drop table NHANVIEN cascade constraints;

drop index XACMINH_FK;

drop index DATPHONG_FK;

drop table PHIEUDATPHONG cascade constraints;

drop index THUOC_FK;

drop table PHONG cascade constraints;

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
   TINHTRANG            SMALLINT,
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
/* Table: CHITIETDONDV                                          */
/*==============================================================*/
create table CHITIETDONDV 
(
   MAHDDV               NUMBER(9)            not null,
   MADV                 NUMBER(9)            not null,
   SOLUONG              INTEGER,
   DONGIADV          NUMBER(19,0),
   constraint PK_CHITIETDONDV primary key (MAHDDV, MADV)
);

/*==============================================================*/
/* Index: CHITIETDONDV_FK                                       */
/*==============================================================*/
create index CHITIETDONDV_FK on CHITIETDONDV (
   MAHDDV ASC
);

/*==============================================================*/
/* Index: CHITIETDONDV2_FK                                      */
/*==============================================================*/
create index CHITIETDONDV2_FK on CHITIETDONDV (
   MADV ASC
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
   MADV                 NUMBER(9)           default MADV_SEQ.NEXTVAL            not null,
   TENDV                VARCHAR2(20),
   DONGIA               NUMBER(19,0),
   DONVI                VARCHAR2(10),
   GIANHAP              NUMBER(19,0),
   constraint PK_DANHMUCDICHVU primary key (MADV)
);

/*==============================================================*/
/* Table: DANHMUCMONAN                                          */
/*==============================================================*/
create table DANHMUCMONAN 
(
   MAMONAN              NUMBER(9)           default MAMONAN_SEQ.NEXTVAL            not null,
   TENMONAN             VARCHAR2(20),
   DONGIA               NUMBER(19,0),
   GIANHAP              NUMBER(19,0),
   constraint PK_DANHMUCMONAN primary key (MAMONAN)
);

/*==============================================================*/
/* Table: HOADONDV                                              */
/*==============================================================*/
create table HOADONDV 
(
   MAHDDV               NUMBER(9)           default MAHDDV_SEQ.NEXTVAL            not null,
   MADATPHONG           NUMBER(9),
   MANV                 NUMBER(9)            not null,
   MAPHG                VARCHAR2(8),
   MAKH                 NUMBER(9)            not null,
   TONGTIEN             NUMBER(19,0)            default 0,
   TINHTRANG            SMALLINT,
   THOIGIANDAT          DATE,
   TIENTRATRUOC         NUMBER(19,0)            default 0,
   constraint PK_HOADONDV primary key (MAHDDV)
);

/*==============================================================*/
/* Index: DATDV_FK                                              */
/*==============================================================*/
create index DATDV_FK on HOADONDV (
   MAKH ASC
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
   TONGTIEN             NUMBER(19,0)                default 0,
   TIENTRATRUOC         NUMBER(19,0)                default 0,
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
   SOPHONGTRONG         INTEGER,
   DONGIA               NUMBER(19,0),
   constraint PK_LOAIPHONG primary key (MALOAIPHG)
);

/*==============================================================*/
/* Table: luutru                                               */
/*==============================================================*/
create table luutru 
(
   MAKH                 NUMBER(9)            not null,
   MAPHG                VARCHAR2(8)          not null,
   MADATPHONG           NUMBER(9)            not null,
   constraint PK_luutru primary key (MAKH, MAPHG, MADATPHONG)
);

/*==============================================================*/
/* Index: luutru_FK                                            */
/*==============================================================*/
create index luutru_FK on luutru (
   MAKH ASC
);

/*==============================================================*/
/* Index: luutru2_FK                                           */
/*==============================================================*/
create index luutru2_FK on luutru (
   MAPHG ASC
);

/*==============================================================*/
/* Index: luutru3_FK                                           */
/*==============================================================*/
create index luutru3_FK on luutru (
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
   TENTAIKHOAN          VARCHAR2(20),
   MATKHAU              VARCHAR2(20),
   QUYEN                VARCHAR2(10),
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
   TIENPHONG                 NUMBER(19,0)           default 0,
   PHUPHI               NUMBER(19,0)            default 0,
   TIENTRATRUOC         NUMBER(19,0)            default 0,
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
/* Table: THANHTOAN                                             */
/*==============================================================*/
create table THANHTOAN 
(
        MATHANHTOAN          NUMBER(9)           default MATHANHTOAN_SEQ.NEXTVAL            not null,
   MADATPHONG           NUMBER(9)            not null,
   MANV                 NUMBER(9)            not null,
   TONGTIEN             NUMBER(19,0),
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

alter table CHITIETDONDV
   add constraint FK_CHITIETD_CHITIETDO_HOADONDV foreign key (MAHDDV)
      references HOADONDV (MAHDDV);

alter table CHITIETDONDV
   add constraint FK_CHITIETD_CHITIETDO_DANHMUCD foreign key (MADV)
      references DANHMUCDICHVU (MADV);

alter table CHITIETTIEC
   add constraint FK_CHITIETT_CHITIETTI_HOADONTI foreign key (MATIEC)
      references HOADONTIEC (MATIEC);

alter table CHITIETTIEC
   add constraint FK_CHITIETT_CHITIETTI_DANHMUCM foreign key (MAMONAN)
      references DANHMUCMONAN (MAMONAN);

alter table HOADONDV
   add constraint FK_HOADONDV_DATDV_KHACHHAN foreign key (MAKH)
      references KHACHHANG (MAKH);

alter table HOADONDV
   add constraint FK_HOADONDV_DATDVTUPH_PHONG foreign key (MAPHG)
      references PHONG (MAPHG);

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

alter table luutru
   add constraint FK_luutru_luutru_KHACHHAN foreign key (MAKH)
      references KHACHHANG (MAKH);

alter table luutru
   add constraint FK_luutru_luutru2_PHONG foreign key (MAPHG)
      references PHONG (MAPHG);

alter table luutru
   add constraint FK_luutru_luutru3_PHIEUDAT foreign key (MADATPHONG)
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

alter table THANHTOAN
   add constraint FK_THANHTOA_THUNGAN_NHANVIEN foreign key (MANV)
      references NHANVIEN (MANV);

alter table THANHTOAN
   add constraint FK_THANHTOA_TIENHANH_PHIEUDAT foreign key (MADATPHONG)
      references PHIEUDATPHONG (MADATPHONG);

/*==============================================================*/
/* Data define constraint                                           */
/*==============================================================*/

alter table CHITIETDONDV
    add constraint CHK_CHITIETDONDV_VALIDATE_SOLUONG check (SOLUONG >0);

alter table CHITIETTIEC
    add constraint CHK_CHITIETTIEC_VALIDATE_SOLUONG check (SOLUONG > 0);

alter table DANHMUCDICHVU
    add constraint CHK_DANHMUCDICHVU_VALIDATE_DONGIA check (DONGIA >= 0);

alter table DANHMUCMONAN
    add constraint CHK_DANHMUCMONAN_VALIDATE_DONGIA check (DONGIA > 0);

alter table HOADONDV
    add constraint CHK_HOADONDV_VALIDATE_TONGTIEN CHECK (TONGTIEN >= 0);
    
alter table HOADONTIEC
    add constraint CHK_HOADONTIEC_VALIDATE_TONGTIEN CHECK (TONGTIEN >=0);

alter table KHACHHANG
    add constraint CHK_KHACHHANG_GIOITINH check (GIOITINH in ('Nam', 'Nu', ' nam', 'nu', 'khong xac dinh', 'n?', 'N?', 'Kh�ng x�c ??nh' ));
    
alter table LOAIPHONG
    add constraint CHK_PHONG_VALIDATE_DONGIA check (DONGIA > 0);

alter table NHANVIEN
    add constraint CHK_NHANVIEN_VALIDATE_GIOITINH check( GIOITINH in ('Nam', 'Nu', ' nam', 'nu', 'n?', 'N?'));
    
alter table PHIEUDATPHONG
    add constraint CHK_PHIEUDATPHONG_VALIDATE_NGAYDAT_NGAYNHAN_NGAYTRA check (NGAYDAT <= NGAYNHAN AND NGAYNHAN <= NGAYTRA);

alter table THANHTOAN
    add constraint CHK_THANHTOAN_VALIDATE_TONGTIEN CHECK (TONGTIEN >= 0);

insert into KhachHang (TenKH, CCCD, SDT) values ( 'Nguyen Van A', '000000101', '012340201');
insert into KhachHang (TenKH, CCCD, SDT) values ('Pham B', '000002002', '014342104');
insert into KhachHang (TenKH, CCCD, SDT) values ( 'Tran Nguyen C', '000001609', '048390301');
insert into KhachHang (TenKH, CCCD, SDT) values ( 'Ngo Ba K', '000003105', '083440546');
insert into KhachHang (TenKH, CCCD, SDT) values ( 'My D', '000500402', '058393261');

insert into NhanVien (TenNV, CCCD, SDT, NGAYSINH, GioiTinh, NGAYVL, ChucVu) values ( 'My Duyen', '0540041801','014380245',TO_DATE('2003/05/03', 'yyyy/mm/dd ') ,'Nu',TO_DATE('2021/05/03', 'yyyy/mm/dd '),'Ti?p t�n');
insert into NhanVien (TenNV, CCCD, SDT, NGAYSINH, GioiTinh, NGAYVL, ChucVu) values ('Thanh Tuyen', '0841021350','044588292',TO_DATE('2003/05/03', 'yyyy/mm/dd '),'Nu',TO_DATE('2021/05/03', 'yyyy/mm/dd '),'Ti?p t�n');
insert into NhanVien (TenNV, CCCD, SDT, NGAYSINH, GioiTinh, NGAYVL, ChucVu) values ( 'Duc Trong', '0020543899','097380284',TO_DATE('2003/05/03', 'yyyy/mm/dd '),'Nam',TO_DATE('2021/05/03', 'yyyy/mm/dd '),'Qu?n l�');
insert into NhanVien (TenNV, CCCD, SDT, NGAYSINH, GioiTinh, NGAYVL, ChucVu) values ( 'Quynh Nga', '023050002','078720655',TO_DATE('2003/05/03', 'yyyy/mm/dd '),'Nu',TO_DATE('2021/05/03', 'yyyy/mm/dd '),'Nhan Vien');
insert into NhanVien (TenNV, CCCD, SDT, NGAYSINH, GioiTinh, NGAYVL, ChucVu) values ( 'Chau Dat', '0250049004','091250622',TO_DATE('2003/05/03', 'yyyy/mm/dd '),'Nam',TO_DATE('2009/05/03', 'yyyy/mm/dd '),'Quan Li');

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

insert into DanhMucDichVu values ( 'Don phong', 20000);
insert into DanhMucDichVu values ('Giat ui', 30000);
insert into DanhMucDichVu values ( 'Trong tre', 50000);
insert into DanhMucDichVu values ( 'Thue xe tu lai', 200000);
insert into DanhMucDichVu values ( 'Cham soc thu cung', 100000);
insert into DanhMucDichVu values ( 'Spa', 300000);
insert into DanhMucDichVu values ( 'Dua don san bay', 150000);
insert into DanhMucDichVu values ( 'Karaoke', 100000);

insert into LoaiPhong values ('LP-STD01','Standard', 2, 'Phong tieu chuan - Giuong don', 15);
insert into LoaiPhong values ('LP-STD02','Standard', 2, 'Phong tieu chuan - Giuong doi nho', 10);
insert into LoaiPhong values ('LP-STD03','Standard', 4, 'Phong tieu chuan - Giuong doi lon', 10);
insert into LoaiPhong values ('LP-SUP01','Superior', 2, 'Phong cao cap Superior - Giuong don', 10);
insert into LoaiPhong values ('LP-SUP02','Superior', 4, 'Phong cao cap Superior - Giuong doi lon', 10);
insert into LoaiPhong values ('LP-DLX01','Deluxe', 2, 'Phong cao cap Deluxe - Giuong don lon', 5);
insert into LoaiPhong values ('LP-DLX02','Deluxe', 4, 'Phong cao cap Deluxe - Giuong doi lon', 5);
insert into LoaiPhong values ('LP-SUT01','Suite', 2, 'Phong cao cap Suite - Giuong don lon', 2);
insert into LoaiPhong values ('LP-SUT02','Suite', 2, 'Phong cao cap Suite - Giuong don lon', 1);


insert into Phong values ('01-STD', 'LP-STD01', 'Phong tieu chuan - Giuong don - Tang 1', '250000', '');
insert into Phong values ('02-STD', 'LP-STD01', 'Phong tieu chuan - Giuong don - Tang 1', '250000', '');
insert into Phong values ('03-STD', 'LP-STD01', 'Phong tieu chuan - Giuong don - Tang 1', '250000', '');
insert into Phong values ('04-STD', 'LP-STD01', 'Phong tieu chuan - Giuong don - Tang 1', '250000', '');
insert into Phong values ('05-STD', 'LP-STD01', 'Phong tieu chuan - Giuong don - Tang 1', '250000', '');
insert into Phong values ('06-STD', 'LP-STD01', 'Phong tieu chuan - Giuong don - Tang 1', '250000', '');
insert into Phong values ('07-STD', 'LP-STD01', 'Phong tieu chuan - Giuong don - Tang 1', '250000', '');
insert into Phong values ('08-STD', 'LP-STD01', 'Phong tieu chuan - Giuong don - Tang 1', '250000', '');
insert into Phong values ('09-STD', 'LP-STD01', 'Phong tieu chuan - Giuong don - Tang 1', '250000', '');
insert into Phong values ('10-STD', 'LP-STD01', 'Phong tieu chuan - Giuong don - Tang 1', '250000', '');
insert into Phong values ('11-STD', 'LP-STD01', 'Phong tieu chuan - Giuong don - Tang 1', '250000', '');
insert into Phong values ('12-STD', 'LP-STD01', 'Phong tieu chuan - Giuong don - Tang 1', '250000', '');
insert into Phong values ('13-STD', 'LP-STD01', 'Phong tieu chuan - Giuong don - Tang 1', '250000', '');
insert into Phong values ('14-STD', 'LP-STD01', 'Phong tieu chuan - Giuong don - Tang 1', '250000', '');
insert into Phong values ('15-STD', 'LP-STD01', 'Phong tieu chuan - Giuong don - Tang 1', '250000', '');

insert into Phong values ('16-STD', 'LP-STD02', 'Phong tieu chuan - Giuong doi nho - Tang 1', '250000', '');
insert into Phong values ('17-STD', 'LP-STD02', 'Phong tieu chuan - Giuong doi nho - Tang 1', '250000', '');
insert into Phong values ('18-STD', 'LP-STD02', 'Phong tieu chuan - Giuong doi nho - Tang 1', '250000', '');
insert into Phong values ('19-STD', 'LP-STD02', 'Phong tieu chuan - Giuong doi nho - Tang 1', '250000', '');
insert into Phong values ('20-STD', 'LP-STD02', 'Phong tieu chuan - Giuong doi nho - Tang 1', '250000', '');
insert into Phong values ('21-STD', 'LP-STD02', 'Phong tieu chuan - Giuong doi nho - Tang 2', '250000', '');
insert into Phong values ('22-STD', 'LP-STD02', 'Phong tieu chuan - Giuong doi nho - Tang 2', '250000', '');
insert into Phong values ('23-STD', 'LP-STD02', 'Phong tieu chuan - Giuong doi nho - Tang 2', '250000', '');
insert into Phong values ('24-STD', 'LP-STD02', 'Phong tieu chuan - Giuong doi nho - Tang 2', '250000', '');
insert into Phong values ('25-STD', 'LP-STD02', 'Phong tieu chuan - Giuong doi nho - Tang 2', '250000', '');

insert into Phong values ('26-STD', 'LP-STD03', 'Phong tieu chuan - Giuong doi lon - Tang 2', '400000', '');
insert into Phong values ('27-STD', 'LP-STD03', 'Phong tieu chuan - Giuong doi lon - Tang 2', '400000', '');
insert into Phong values ('28-STD', 'LP-STD03', 'Phong tieu chuan - Giuong doi lon - Tang 2', '400000', '');
insert into Phong values ('29-STD', 'LP-STD03', 'Phong tieu chuan - Giuong doi lon - Tang 2', '400000', '');
insert into Phong values ('30-STD', 'LP-STD03', 'Phong tieu chuan - Giuong doi lon - Tang 2', '400000', '');
insert into Phong values ('31-STD', 'LP-STD03', 'Phong tieu chuan - Giuong doi lon - Tang 2', '400000', '');
insert into Phong values ('32-STD', 'LP-STD03', 'Phong tieu chuan - Giuong doi lon - Tang 2', '400000', '');
insert into Phong values ('33-STD', 'LP-STD03', 'Phong tieu chuan - Giuong doi lon - Tang 2', '400000', '');
insert into Phong values ('34-STD', 'LP-STD03', 'Phong tieu chuan - Giuong doi lon - Tang 2', '400000', '');
insert into Phong values ('35-STD', 'LP-STD03', 'Phong tieu chuan - Giuong doi lon - Tang 2', '400000', '');

insert into Phong values ('01-SUP', 'LP-SUP01', 'Phong cao cap Superior - Giuong don - Tang 3', '450000', '');
insert into Phong values ('02-SUP', 'LP-SUP01', 'Phong cao cap Superior - Giuong don - Tang 3', '450000', '');
insert into Phong values ('03-SUP', 'LP-SUP01', 'Phong cao cap Superior - Giuong don - Tang 3', '450000', '');
insert into Phong values ('04-SUP', 'LP-SUP01', 'Phong cao cap Superior - Giuong don - Tang 3', '450000', '');
insert into Phong values ('05-SUP', 'LP-SUP01', 'Phong cao cap Superior - Giuong don - Tang 3', '450000', '');
insert into Phong values ('06-SUP', 'LP-SUP01', 'Phong cao cap Superior - Giuong don - Tang 3', '450000', '');
insert into Phong values ('07-SUP', 'LP-SUP01', 'Phong cao cap Superior - Giuong don - Tang 3', '450000', '');
insert into Phong values ('08-SUP', 'LP-SUP01', 'Phong cao cap Superior - Giuong don - Tang 3', '450000', '');
insert into Phong values ('09-SUP', 'LP-SUP01', 'Phong cao cap Superior - Giuong don - Tang 3', '450000', '');
insert into Phong values ('10-SUP', 'LP-SUP01', 'Phong cao cap Superior - Giuong don - Tang 3', '450000', '');

insert into Phong values ('11-SUP', 'LP-SUP02', 'Phong cao cap Superior - Giuong doi lon - Tang 4', '650000', '');
insert into Phong values ('12-SUP', 'LP-SUP02', 'Phong cao cap Superior - Giuong doi lon - Tang 4', '650000', '');
insert into Phong values ('13-SUP', 'LP-SUP02', 'Phong cao cap Superior - Giuong doi lon - Tang 4', '650000', '');
insert into Phong values ('14-SUP', 'LP-SUP02', 'Phong cao cap Superior - Giuong doi lon - Tang 4', '650000', '');
insert into Phong values ('15-SUP', 'LP-SUP02', 'Phong cao cap Superior - Giuong doi lon - Tang 4', '650000', '');
insert into Phong values ('16-SUP', 'LP-SUP02', 'Phong cao cap Superior - Giuong doi lon - Tang 4', '650000', '');
insert into Phong values ('17-SUP', 'LP-SUP02', 'Phong cao cap Superior - Giuong doi lon - Tang 4', '650000', '');
insert into Phong values ('18-SUP', 'LP-SUP02', 'Phong cao cap Superior - Giuong doi lon - Tang 4', '650000', '');
insert into Phong values ('19-SUP', 'LP-SUP02', 'Phong cao cap Superior - Giuong doi lon - Tang 4', '650000', '');
insert into Phong values ('20-SUP', 'LP-SUP02', 'Phong cao cap Superior - Giuong doi lon - Tang 4', '650000', '');

insert into Phong values ('01-DLX', 'LP-DLX01', 'Phong cao cap Deluxe - Giuong don lon - Tang 5', '850000', '');
insert into Phong values ('02-DLX', 'LP-DLX01', 'Phong cao cap Deluxe - Giuong don lon - Tang 5', '850000', '');
insert into Phong values ('03-DLX', 'LP-DLX01', 'Phong cao cap Deluxe - Giuong don lon - Tang 5', '850000', '');
insert into Phong values ('04-DLX', 'LP-DLX01', 'Phong cao cap Deluxe - Giuong don lon - Tang 5', '850000', '');
insert into Phong values ('05-DLX', 'LP-DLX01', 'Phong cao cap Deluxe - Giuong don lon - Tang 5', '850000', '');

insert into Phong values ('06-DLX', 'LP-DLX02', 'Phong cao cap Deluxe - Giuong doi lon - Tang 6', '1000000', '');
insert into Phong values ('07-DLX', 'LP-DLX02', 'Phong cao cap Deluxe - Giuong doi lon - Tang 6', '1000000', '');
insert into Phong values ('08-DLX', 'LP-DLX02', 'Phong cao cap Deluxe - Giuong doi lon - Tang 6', '1000000', '');
insert into Phong values ('09-DLX', 'LP-DLX02', 'Phong cao cap Deluxe - Giuong doi lon - Tang 6', '1000000', '');
insert into Phong values ('10-DLX', 'LP-DLX02', 'Phong cao cap Deluxe - Giuong doi lon - Tang 6', '1000000', '');

insert into Phong values ('01-SUT', 'LP-SUT01', 'Phong cao cap Suite - Giuong don lon - Tang 7', '2000000', '');
insert into Phong values ('02-SUT', 'LP-DLX01', 'Phong cao cap Suite - Giuong don lon - Tang 7', '2000000', '');

insert into Phong values ('VIP-SUT', 'LP-DLX02', 'Phong cao cap Suite - Giuong don lon - Tang 8', '4000000', '');


