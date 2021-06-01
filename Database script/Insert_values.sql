insert into KhachHang (TenKH, CCCD, SDT) values ( 'Nguyen Van A', '000000101', '012340201');
insert into KhachHang (TenKH, CCCD, SDT) values ('Pham B', '000002002', '014342104');
insert into KhachHang (TenKH, CCCD, SDT) values ( 'Tran Nguyen C', '000001609', '048390301');
insert into KhachHang (TenKH, CCCD, SDT) values ( 'Ngo Ba K', '000003105', '083440546');
insert into KhachHang (TenKH, CCCD, SDT) values ( 'My D', '000500402', '058393261');

insert into NhanVien (TenNV, CCCD, SDT, NGAYSINH, GioiTinh, NGAYVL, ChucVu) values ( 'My Duyen', '0540041801','014380245',TO_DATE('2003/05/03', 'yyyy/mm/dd ') ,'Nu',TO_DATE('2021/05/03', 'yyyy/mm/dd '),'Ti?p tân');
insert into NhanVien (TenNV, CCCD, SDT, NGAYSINH, GioiTinh, NGAYVL, ChucVu) values ('Thanh Tuyen', '0841021350','044588292',TO_DATE('2003/05/03', 'yyyy/mm/dd '),'Nu',TO_DATE('2021/05/03', 'yyyy/mm/dd '),'Ti?p tân');
insert into NhanVien (TenNV, CCCD, SDT, NGAYSINH, GioiTinh, NGAYVL, ChucVu) values ( 'Duc Trong', '0020543899','097380284',TO_DATE('2003/05/03', 'yyyy/mm/dd '),'Nam',TO_DATE('2021/05/03', 'yyyy/mm/dd '),'Qu?n lí');
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

insert into DANHMUCDICHVU(TENDV,DONGIA) values ( 'Don phong', 20000);
insert into DANHMUCDICHVU(TENDV,DONGIA) values ('Giat ui', 30000);
insert into DANHMUCDICHVU(TENDV,DONGIA) values ( 'Trong tre', 50000);
insert into DANHMUCDICHVU(TENDV,DONGIA) values ( 'Thue xe tu lai', 200000);
insert into DANHMUCDICHVU(TENDV,DONGIA) values ( 'Cham soc thu cung', 100000);
insert into DANHMUCDICHVU(TENDV,DONGIA) values ( 'Spa', 300000);
insert into DANHMUCDICHVU(TENDV,DONGIA) values ( 'Dua don san bay', 150000);
insert into DANHMUCDICHVU(TENDV,DONGIA) values ( 'Karaoke', 100000);

insert into LOAIPHONG(MALOAIPHG, KIEUPHONG, KIEUGIUONG, MOTA, SOPHONGTRONG, DONGIA) values ('LP-STD01','Standard', 1, 'Phong tieu chuan - Giuong don', 15,300000);
insert into LOAIPHONG(MALOAIPHG, KIEUPHONG, KIEUGIUONG, MOTA, SOPHONGTRONG, DONGIA) values ('LP-STD02','Standard', 2, 'Phong tieu chuan - Giuong doi nho', 400000);
insert into LOAIPHONG(MALOAIPHG, KIEUPHONG, KIEUGIUONG, MOTA, SOPHONGTRONG, DONGIA) values ('LP-STD03','Standard', 4, 'Phong tieu chuan - Giuong doi lon', 500000);
insert into LOAIPHONG(MALOAIPHG, KIEUPHONG, KIEUGIUONG, MOTA, SOPHONGTRONG, DONGIA) values ('LP-SUP01','Superior', 1, 'Phong cao cap Superior - Giuong don', 1000000);
insert into LOAIPHONG(MALOAIPHG, KIEUPHONG, KIEUGIUONG, MOTA, SOPHONGTRONG, DONGIA) values ('LP-SUP02','Superior', 4, 'Phong cao cap Superior - Giuong doi lon', 1200000);
insert into LOAIPHONG(MALOAIPHG, KIEUPHONG, KIEUGIUONG, MOTA, SOPHONGTRONG, DONGIA) values ('LP-DLX01','Deluxe', 2, 'Phong cao cap Deluxe - Giuong don nho', 10, 1500000);
insert into LOAIPHONG(MALOAIPHG, KIEUPHONG, KIEUGIUONG, MOTA, SOPHONGTRONG, DONGIA) values ('LP-DLX02','Deluxe', 4, 'Phong cao cap Deluxe - Giuong doi lon', 5,1800000);
insert into LOAIPHONG(MALOAIPHG, KIEUPHONG, KIEUGIUONG, MOTA, SOPHONGTRONG, DONGIA) values ('LP-SUT01','Suite', 2, 'Phong cao cap Suite - Giuong don ', 2,2000000);
insert into LOAIPHONG(MALOAIPHG, KIEUPHONG, KIEUGIUONG, MOTA, SOPHONGTRONG, DONGIA) values ('LP-SUT02','Suite', 2, 'Phong cao cap Suite - Giuong don lon', 1,2500000);


insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('01-STD', 'LP-STD01', 'Phong tieu chuan - Giuong don - Tang 1', 1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('02-STD', 'LP-STD01', 'Phong tieu chuan - Giuong don - Tang 1', 1);
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

insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('16-STD', 'LP-STD02', 'Phong tieu chuan - Giuong doi nho - Tang 1', 1);
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
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('02-SUT', 'LP-DLX01', 'Phong cao cap Suite - Giuong don lon - Tang 7', 1);

insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('VIP-SUT', 'LP-DLX02', 'Phong cao cap Suite - Giuong don lon - Tang 8',1);

