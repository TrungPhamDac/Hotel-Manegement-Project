/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import DAO.ChiTietTiecDAO;
import DAO.DanhMucMonAnDAO;
import Model.ChiTietTiec;
import Model.DanhMucMonAn;
import Model.HoaDonTiec;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;


public class ChiTietTiecJrame extends javax.swing.JFrame {

    DefaultTableModel tblMonAn, tblChiTietTiec;
    private HoaDonTiec HDT = new HoaDonTiec();
    
    public ChiTietTiecJrame(int MaTiec) {
        initComponents();
        Button_Them.setEnabled(true);
        Button_Xoa.setEnabled(false);
        Button_Sua.setEnabled(false);
        Table_MonAn.setEnabled(false);
        HDT = new ChiTietTiecDAO().layThongTinTiec(MaTiec); 
        tblMonAn = (DefaultTableModel) Table_MonAn.getModel();
        tblMonAn.setColumnIdentifiers(new Object[]{"STT","Tên món ăn", "Đơn giá"});
        showTable_MonAn();
        showTenMonAn();
        showThongTinTiec();
        tblChiTietTiec = (DefaultTableModel) Table_ChiTietTiec.getModel();
        tblChiTietTiec.setColumnIdentifiers(new Object[]{"Mã món ăn", "Tên món ăn", "Số lượng", "Đơn giá", "Thành tiền"});
        showTableChiTietTiec();
        Table_ChiTietTiec.setDefaultEditor(Object.class, null);
    }
    
    public void showTable_MonAn(){
        int i = 1;
        ArrayList<DanhMucMonAn> listMonAn = new DanhMucMonAnDAO().getListMonAn();
        for(DanhMucMonAn MonAn : listMonAn){
            tblMonAn.addRow(new Object[]{i++, MonAn.getTenMonAn(), MonAn.getDonGia()});
        }
    }
    
    public void updateTable_MonAn(){
        tblMonAn.setRowCount(0);
        showTable_MonAn();
    }
    
    public void showTenMonAn(){
        ArrayList<String> TenMonAn = new DanhMucMonAnDAO().getTenMonAn();
        for(String data : TenMonAn){
            ComboBox_TenMonAn.addItem(data);
        }
    }
    
    public void showMaMonAn(String TenMonAn){
        int MaMonAn = new DanhMucMonAnDAO().getMaMonAn(TenMonAn);
        Text_MaMonAn.setText(String.valueOf(MaMonAn));
    }
    
    public void showDonGiaMonAn(String TenMonAn){
        int DonGiaMonAn = new DanhMucMonAnDAO().getDonGiaMonAn(TenMonAn);
        Text_DonGia.setText(String.valueOf(DonGiaMonAn));
    }
    
    public void showThanhTien(){
        Text_ThanhTien.setText(String.valueOf(Integer.parseInt(Spinner_SoLuong.getValue().toString())*Integer.parseInt(Text_DonGia.getText().toString())));
    }
    
    public void showThongTinTiec(){
        Text_MaTiec.setText(Integer.toString(HDT.getMaTiec()));
        Text_MaPhong.setText(HDT.getMaPhong());
        DateChooser_NgayToChuc.setDate(HDT.getNgayToChuc());
        if (HDT.getTinhTrang() == 1){
            Text_TinhTrang.setText("Đã thanh toán");
        } else Text_TinhTrang.setText("Chưa thanh toán");
        Text_TienCoc.setText(Integer.toString(HDT.getTienCoc()));
        Text_TongTien.setText(Integer.toString(HDT.getTongTien()));
        Text_GhiChu.setText(HDT.getGhiChu());
    }
    
    public void showTableChiTietTiec(){
        ArrayList<ChiTietTiec> listCTT = new ChiTietTiecDAO().layDSChiTietTiec(HDT.getMaTiec());
        for(ChiTietTiec ctt : listCTT){
            tblChiTietTiec.addRow(new Object[]{ctt.getMamonan(), ctt.getTenmonan(), ctt.getSoluong(), ctt.getDongia(), ctt.getThanhtien()});
        }
    } 
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table_MonAn = new javax.swing.JTable();
        ScrollPane_ChiTietTiec = new javax.swing.JScrollPane();
        Table_ChiTietTiec = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        Text_MaMonAn = new javax.swing.JTextField();
        ComboBox_TenMonAn = new javax.swing.JComboBox<>();
        Text_DonGia = new javax.swing.JTextField();
        Text_ThanhTien = new javax.swing.JTextField();
        Button_QuanLiDoAn = new javax.swing.JButton();
        Button_Them = new javax.swing.JButton();
        Button_Xoa = new javax.swing.JButton();
        Button_Sua = new javax.swing.JButton();
        Button_Luu = new javax.swing.JButton();
        Spinner_SoLuong = new javax.swing.JSpinner();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        Text_MaTiec = new javax.swing.JTextField();
        Text_MaPhong = new javax.swing.JTextField();
        Text_TinhTrang = new javax.swing.JTextField();
        Text_TienCoc = new javax.swing.JTextField();
        Text_TongTien = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        Text_GhiChu = new javax.swing.JTextArea();
        DateChooser_NgayToChuc = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        Table_MonAn.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Tên món ăn", "Đơn giá"
            }
        ));
        Table_MonAn.setShowHorizontalLines(true);
        jScrollPane1.setViewportView(Table_MonAn);

        Table_ChiTietTiec.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã món ăn", "Tên món ăn", "Số lượng", "Đơn giá", "Thành tiền"
            }
        ));
        Table_ChiTietTiec.setShowHorizontalLines(true);
        Table_ChiTietTiec.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table_ChiTietTiecMouseClicked(evt);
            }
        });
        ScrollPane_ChiTietTiec.setViewportView(Table_ChiTietTiec);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Mã món ăn");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Tên món ăn");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Số lượng");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Đơn giá");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Thành tiền");

        Text_MaMonAn.setEditable(false);
        Text_MaMonAn.setPreferredSize(new java.awt.Dimension(60, 28));

        ComboBox_TenMonAn.setPreferredSize(new java.awt.Dimension(57, 28));
        ComboBox_TenMonAn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBox_TenMonAnActionPerformed(evt);
            }
        });

        Text_DonGia.setEditable(false);
        Text_DonGia.setPreferredSize(new java.awt.Dimension(60, 28));

        Text_ThanhTien.setEditable(false);
        Text_ThanhTien.setPreferredSize(new java.awt.Dimension(60, 28));

        Button_QuanLiDoAn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Button_QuanLiDoAn.setText("Quản lí món ăn");
        Button_QuanLiDoAn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_QuanLiDoAnActionPerformed(evt);
            }
        });

        Button_Them.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Button_Them.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagine/Add_Icon.png"))); // NOI18N
        Button_Them.setText("Thêm");
        Button_Them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_ThemActionPerformed(evt);
            }
        });

        Button_Xoa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Button_Xoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagine/Delete_Icon.png"))); // NOI18N
        Button_Xoa.setText("Xóa");
        Button_Xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_XoaActionPerformed(evt);
            }
        });

        Button_Sua.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Button_Sua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagine/Fix_Icon.png"))); // NOI18N
        Button_Sua.setText("Sửa");
        Button_Sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_SuaActionPerformed(evt);
            }
        });

        Button_Luu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Button_Luu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagine/Save_Icon.png"))); // NOI18N
        Button_Luu.setText("Lưu");
        Button_Luu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_LuuActionPerformed(evt);
            }
        });

        Spinner_SoLuong.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Spinner_SoLuong.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        Spinner_SoLuong.setToolTipText("");
        Spinner_SoLuong.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Spinner_SoLuong.setName(""); // NOI18N
        Spinner_SoLuong.setPreferredSize(new java.awt.Dimension(30, 28));
        Spinner_SoLuong.setVerifyInputWhenFocusTarget(false);
        Spinner_SoLuong.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                Spinner_SoLuongStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ScrollPane_ChiTietTiec)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(Button_Them, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Button_Xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Button_Sua, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Button_Luu, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Button_QuanLiDoAn, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 2, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Text_MaMonAn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Text_ThanhTien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Text_DonGia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ComboBox_TenMonAn, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Spinner_SoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Text_MaMonAn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ComboBox_TenMonAn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Spinner_SoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Text_DonGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Text_ThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Button_QuanLiDoAn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Button_Them, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(Button_Xoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Button_Sua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Button_Luu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(ScrollPane_ChiTietTiec, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Mã tiệc");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Mã Phòng");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Ngày tổ chức");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Tình trạng");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Tiền cọc");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Tổng tiền");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Ghi chú");

        Text_MaTiec.setEditable(false);
        Text_MaTiec.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        Text_MaPhong.setEditable(false);
        Text_MaPhong.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Text_MaPhong.setPreferredSize(new java.awt.Dimension(60, 28));

        Text_TinhTrang.setEditable(false);
        Text_TinhTrang.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Text_TinhTrang.setPreferredSize(new java.awt.Dimension(60, 28));

        Text_TienCoc.setEditable(false);
        Text_TienCoc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Text_TienCoc.setPreferredSize(new java.awt.Dimension(60, 28));

        Text_TongTien.setEditable(false);
        Text_TongTien.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Text_TongTien.setPreferredSize(new java.awt.Dimension(60, 28));
        Text_TongTien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Text_TongTienActionPerformed(evt);
            }
        });

        Text_GhiChu.setEditable(false);
        Text_GhiChu.setColumns(20);
        Text_GhiChu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Text_GhiChu.setRows(5);
        jScrollPane2.setViewportView(Text_GhiChu);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Text_MaTiec)
                    .addComponent(Text_MaPhong, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                    .addComponent(Text_TinhTrang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Text_TienCoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Text_TongTien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(DateChooser_NgayToChuc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Text_MaTiec)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Text_MaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(DateChooser_NgayToChuc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Text_TinhTrang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Text_TienCoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(Text_TongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Chi tiết tiệc");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Thông tin tiệc");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 11, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Button_QuanLiDoAnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_QuanLiDoAnActionPerformed
        QuanLiDoAn DoAn = new QuanLiDoAn();
        DoAn.setVisible(true);
        DoAn.addWindowListener(new WindowAdapter() {
            public void windowClosed(WindowEvent e){
                updateTable_MonAn();
            }
        });
    }//GEN-LAST:event_Button_QuanLiDoAnActionPerformed

    private void ComboBox_TenMonAnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBox_TenMonAnActionPerformed
        Spinner_SoLuong.setValue(1);
        showMaMonAn(ComboBox_TenMonAn.getSelectedItem().toString());
        showDonGiaMonAn(ComboBox_TenMonAn.getSelectedItem().toString());
        showThanhTien();
    }//GEN-LAST:event_ComboBox_TenMonAnActionPerformed

    private void Spinner_SoLuongStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_Spinner_SoLuongStateChanged
        showThanhTien();
    }//GEN-LAST:event_Spinner_SoLuongStateChanged

    private void Button_ThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_ThemActionPerformed
        ArrayList<ChiTietTiec> listCTT = new ChiTietTiecDAO().layDSChiTietTiec(HDT.getMaTiec());
        for(ChiTietTiec ctt : listCTT){
            if (ctt.getMamonan() == Integer.parseInt(Text_MaMonAn.getText())){
                JOptionPane.showMessageDialog(this, "Món ặn đã được chọn.");
                return;
            }
        }
        ChiTietTiec CTT = new ChiTietTiec();
        CTT.setMatiec(HDT.getMaTiec());
        CTT.setMamonan(Integer.parseInt(Text_MaMonAn.getText()));
        CTT.setTenmonan(ComboBox_TenMonAn.getSelectedItem().toString());
        CTT.setDongia(Integer.parseInt(Text_DonGia.getText()));
        CTT.setSoluong((int) Spinner_SoLuong.getValue());
        if (new ChiTietTiecDAO().ThemChiTietTiec(CTT)){
                JOptionPane.showMessageDialog(this, "Thêm thành công.");
                resetChiTietTiec();
                updateTable_ChiTietTiec();
            } else {
                JOptionPane.showMessageDialog(this, "Thêm thất bại.");
            }
    }//GEN-LAST:event_Button_ThemActionPerformed

    private void Button_LuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_LuuActionPerformed
        Button_Them.setEnabled(true);
        Button_Xoa.setEnabled(false);
        Button_Sua.setEnabled(false);
        ComboBox_TenMonAn.setEnabled(true);
        resetChiTietTiec();
        int MaTiec = HDT.getMaTiec();
        HDT = new ChiTietTiecDAO().layThongTinTiec(MaTiec); 
        showThongTinTiec();
    }//GEN-LAST:event_Button_LuuActionPerformed

    private void Button_SuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_SuaActionPerformed
        ChiTietTiec CTT = new ChiTietTiec();
        CTT.setMatiec(HDT.getMaTiec());
        CTT.setMamonan(Integer.parseInt(Text_MaMonAn.getText()));
        CTT.setSoluong((int) Spinner_SoLuong.getValue());
        int ret = JOptionPane.showConfirmDialog(null, "Bạn có muốn sửa dữ liệu?", "Sửa dữ liệu", JOptionPane.YES_NO_OPTION);
        if(ret == JOptionPane.YES_OPTION){
             if (new ChiTietTiecDAO().SuaChiTietTiec(CTT)){
                JOptionPane.showMessageDialog(this, "Sửa thành công.");
                resetChiTietTiec();
                updateTable_ChiTietTiec();
             } else {
                JOptionPane.showMessageDialog(this, "Sửa thất bại.");
             }
         }
    }//GEN-LAST:event_Button_SuaActionPerformed

    private void Button_XoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_XoaActionPerformed
        ChiTietTiec CTT = new ChiTietTiec();
        CTT.setMatiec(HDT.getMaTiec());
        CTT.setMamonan(Integer.parseInt(Text_MaMonAn.getText()));
        int ret = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa dữ liệu?", "Xoá dữ liệu", JOptionPane.YES_NO_OPTION);
         if(ret == JOptionPane.YES_OPTION){
             if (new ChiTietTiecDAO().XoaChiTietTiec(CTT)){
                JOptionPane.showMessageDialog(this, "Xóa thành công.");
                resetChiTietTiec();
                updateTable_ChiTietTiec();
             } else {
                JOptionPane.showMessageDialog(this, "Xóa thất bại.");
             }
         }
    }//GEN-LAST:event_Button_XoaActionPerformed

    private void Table_ChiTietTiecMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table_ChiTietTiecMouseClicked
        Button_Them.setEnabled(false);
        Button_Xoa.setEnabled(true);
        Button_Sua.setEnabled(true);
        ListSelectionModel listTable_ChiTietTiec = Table_ChiTietTiec.getSelectionModel();
        listTable_ChiTietTiec.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        int indexTB = Table_ChiTietTiec.getSelectedRow();
        if (indexTB < tblChiTietTiec.getRowCount() && indexTB >= 0){
            Text_MaMonAn.setText(tblChiTietTiec.getValueAt(indexTB, 0).toString());
            ComboBox_TenMonAn.setSelectedItem(tblChiTietTiec.getValueAt(indexTB, 1).toString());
            Spinner_SoLuong.setValue(tblChiTietTiec.getValueAt(indexTB, 2));
            Text_DonGia.setText(tblChiTietTiec.getValueAt(indexTB, 3).toString());
            Text_ThanhTien.setText(tblChiTietTiec.getValueAt(indexTB, 4).toString());
        }
        ComboBox_TenMonAn.setEnabled(false);
    }//GEN-LAST:event_Table_ChiTietTiecMouseClicked

    private void Text_TongTienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Text_TongTienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Text_TongTienActionPerformed

    public void resetChiTietTiec(){
        Text_MaMonAn.setText("");
        ComboBox_TenMonAn.setSelectedIndex(0);
        Spinner_SoLuong.setValue(1);
        Text_DonGia.setText("");
        Text_ThanhTien.setText("");
    }

    public void updateTable_ChiTietTiec(){
        tblChiTietTiec.setRowCount(0);
        showTableChiTietTiec();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_Luu;
    private javax.swing.JButton Button_QuanLiDoAn;
    private javax.swing.JButton Button_Sua;
    private javax.swing.JButton Button_Them;
    private javax.swing.JButton Button_Xoa;
    private javax.swing.JComboBox<String> ComboBox_TenMonAn;
    private com.toedter.calendar.JDateChooser DateChooser_NgayToChuc;
    private javax.swing.JScrollPane ScrollPane_ChiTietTiec;
    private javax.swing.JSpinner Spinner_SoLuong;
    private javax.swing.JTable Table_ChiTietTiec;
    private javax.swing.JTable Table_MonAn;
    private javax.swing.JTextField Text_DonGia;
    private javax.swing.JTextArea Text_GhiChu;
    private javax.swing.JTextField Text_MaMonAn;
    private javax.swing.JTextField Text_MaPhong;
    private javax.swing.JTextField Text_MaTiec;
    private javax.swing.JTextField Text_ThanhTien;
    private javax.swing.JTextField Text_TienCoc;
    private javax.swing.JTextField Text_TinhTrang;
    private javax.swing.JTextField Text_TongTien;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
