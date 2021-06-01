/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import DAO.DanhMucDichVuDAO;
import Model.DanhMucDichVu;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

/**
 *
 * @author asus
 */
public class QuanLiDichVuJPane extends javax.swing.JPanel {
    private ArrayList<DanhMucDichVu> listDichVu;
    DefaultTableModel tblDichVu;
    Date date = new Date();
    
    public QuanLiDichVuJPane() {
        initComponents();
        listDichVu = new DanhMucDichVuDAO().getListDichVu();
        tblDichVu = (DefaultTableModel) Table_DichVu.getModel();
        tblDichVu.setColumnIdentifiers(new Object[]{"Mã món ăn", "Tên món ăn", "Đơn giá"});
        showTable();
    }
    
    public void showTable(){
        for(DanhMucDichVu DichVu : listDichVu){
            tblDichVu.addRow(new Object[]{DichVu.getMaDV(), DichVu.getTenDV(), DichVu.getDonGia()});
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Text_MaDV = new javax.swing.JTextField();
        Text_TenDV = new javax.swing.JTextField();
        Text_DonGia = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table_DichVu = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        Button_ThemDichVu = new javax.swing.JButton();
        Button_XoaDichVu = new javax.swing.JButton();
        Button_SuaDichVu = new javax.swing.JButton();
        Button_LamMoi = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        Spinner_SoLuong = new javax.swing.JSpinner();
        JDateChooser_NgaySuDung = new com.toedter.calendar.JDateChooser();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        ComboBox_TenDV = new javax.swing.JComboBox<>();
        ComboBox_MaPhong = new javax.swing.JComboBox<>();
        jPanel7 = new javax.swing.JPanel();
        Button_ThemDVPhong = new javax.swing.JButton();
        Button_XoaDVPhong = new javax.swing.JButton();
        Button_SuaDVPhong = new javax.swing.JButton();
        Button_LamMoiDVPhong = new javax.swing.JButton();
        Button_TimKiem = new javax.swing.JButton();
        Button_InHoaDon = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(153, 153, 153), null, null));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Tên dịch vụ");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Mã dịch vụ");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Đơn giá");

        Text_MaDV.setEditable(false);
        Text_MaDV.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        Text_TenDV.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        Text_DonGia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        Table_DichVu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã dịch vụ", "Tên dịch vụ", "Đơn giá"
            }
        ));
        Table_DichVu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table_DichVuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Table_DichVu);

        Button_ThemDichVu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Button_ThemDichVu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagine/baseline_add_black_24dp.png"))); // NOI18N
        Button_ThemDichVu.setText("Thêm");
        Button_ThemDichVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_ThemDichVuActionPerformed(evt);
            }
        });

        Button_XoaDichVu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Button_XoaDichVu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagine/baseline_remove_black_24dp.png"))); // NOI18N
        Button_XoaDichVu.setText("Xóa");
        Button_XoaDichVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_XoaDichVuActionPerformed(evt);
            }
        });

        Button_SuaDichVu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Button_SuaDichVu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagine/baseline_build_black_24dp.png"))); // NOI18N
        Button_SuaDichVu.setText("Sửa");
        Button_SuaDichVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_SuaDichVuActionPerformed(evt);
            }
        });

        Button_LamMoi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Button_LamMoi.setText("Làm mới");
        Button_LamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_LamMoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(Button_SuaDichVu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Button_ThemDichVu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Button_XoaDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Button_LamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Button_ThemDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Button_XoaDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Button_SuaDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Button_LamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Text_MaDV)
                                    .addComponent(Text_TenDV)
                                    .addComponent(Text_DonGia, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)))
                            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(Text_MaDV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(Text_TenDV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(Text_DonGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(153, 153, 153), null, null));

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setText("Tên dịch vụ");

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setText("Số lượng");

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setText("Ngày sử dụng");

        Spinner_SoLuong.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Spinner_SoLuong.setModel(new javax.swing.SpinnerNumberModel(0, 0, 20, 1));

        JDateChooser_NgaySuDung.setDate(date);
        JDateChooser_NgaySuDung.setDateFormatString("dd/MM/yyyy\n");

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Tên DV", "Ngày SD", "Số lượng", "Đơn giá", "Thành tiền"
            }
        ));
        jScrollPane4.setViewportView(jTable4);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Mã phòng");

        ComboBox_TenDV.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ComboBox_TenDV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        ComboBox_MaPhong.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        Button_ThemDVPhong.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Button_ThemDVPhong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagine/baseline_add_black_24dp.png"))); // NOI18N
        Button_ThemDVPhong.setText("Thêm");

        Button_XoaDVPhong.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Button_XoaDVPhong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagine/baseline_remove_black_24dp.png"))); // NOI18N
        Button_XoaDVPhong.setText("Xóa");

        Button_SuaDVPhong.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Button_SuaDVPhong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagine/baseline_build_black_24dp.png"))); // NOI18N
        Button_SuaDVPhong.setText("Sửa");

        Button_LamMoiDVPhong.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Button_LamMoiDVPhong.setText("Làm mới");

        Button_TimKiem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Button_TimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagine/baseline_search_black_24dp.png"))); // NOI18N
        Button_TimKiem.setText("Tìm kiếm");
        Button_TimKiem.setMaximumSize(new java.awt.Dimension(115, 40));
        Button_TimKiem.setMinimumSize(new java.awt.Dimension(115, 40));
        Button_TimKiem.setPreferredSize(new java.awt.Dimension(115, 40));

        Button_InHoaDon.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Button_InHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagine/Bill_Icon.png"))); // NOI18N
        Button_InHoaDon.setText("In hóa đơn");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(Button_SuaDVPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Button_LamMoiDVPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(Button_ThemDVPhong)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Button_XoaDVPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Button_TimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Button_InHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Button_TimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Button_InHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Button_ThemDVPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Button_XoaDVPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Button_SuaDVPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Button_LamMoiDVPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Spinner_SoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JDateChooser_NgaySuDung, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                            .addComponent(ComboBox_TenDV, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ComboBox_MaPhong, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(ComboBox_MaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(ComboBox_TenDV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(Spinner_SoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23)
                            .addComponent(JDateChooser_NgaySuDung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Dịch vụ phòng");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Chi tiết dịch vụ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 327, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void Button_ThemDichVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_ThemDichVuActionPerformed
        DanhMucDichVu DichVu = new DanhMucDichVu();
        //DichVu.setMaDV(Integer.parseInt(Text_MaDV.getText()));
        DichVu.setTenDV(Text_TenDV.getText());
        DichVu.setDonGia(Integer.parseInt(Text_DonGia.getText()));
        if(new DanhMucDichVuDAO().ThemDichVu(DichVu)){
            JOptionPane.showMessageDialog(this, "Thêm thành công.");
            listDichVu.add(DichVu);
            clearJTextDichVu();
            showResult();
        } else {
            JOptionPane.showMessageDialog(this, "Thêm thất bại.");
        }
    }//GEN-LAST:event_Button_ThemDichVuActionPerformed

      public DanhMucDichVu returnDichVu(int index){        
        int MaDichVu = (int) tblDichVu.getValueAt(index, 0);
        String TenDichVu = tblDichVu.getValueAt(index, 1).toString();
        int DonGia = Integer.parseInt(tblDichVu.getValueAt(index, 2).toString());
        
        return new DanhMucDichVu(MaDichVu,TenDichVu,DonGia);
    }
    
    private void Button_XoaDichVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_XoaDichVuActionPerformed
         int indexTB = Table_DichVu.getSelectedRow();
        
        DanhMucDichVu DichVu = returnDichVu(indexTB);
        
        int ret = JOptionPane.showConfirmDialog(null,"Bạn có muốn xóa dữ liệu?", "Xóa dữ liệu", JOptionPane.YES_NO_OPTION);
        if(ret == JOptionPane.YES_OPTION){
            if(indexTB < tblDichVu.getRowCount() && indexTB >= 0){
                if(new DanhMucDichVuDAO().XoaDichVu(DichVu)){               
                    JOptionPane.showMessageDialog(this, "Xóa thành công.");
                    tblDichVu.removeRow((indexTB));
                    clearJTextDichVu();
            } else {
                JOptionPane.showMessageDialog(this, "Xóa thất bại.");
                }
            }         
        }
    }//GEN-LAST:event_Button_XoaDichVuActionPerformed

    private void Button_SuaDichVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_SuaDichVuActionPerformed
        int indexTB = Table_DichVu.getSelectedRow();
        DanhMucDichVu DichVu = returnDichVu(indexTB);
        int ret = JOptionPane.showConfirmDialog(null, "Bạn có muốn sửa dữ liệu?","Sửa dữ liệu",JOptionPane.YES_NO_OPTION);
        if(ret == JOptionPane.YES_OPTION){
            if(new DanhMucDichVuDAO().SuaDichVu(DichVu)){
                if(indexTB < tblDichVu.getRowCount() && indexTB >= 0){
                    tblDichVu.setValueAt(Text_TenDV.getText(), indexTB, 1);
                    tblDichVu.setValueAt(Text_DonGia.getText(), indexTB, 2);
                    JOptionPane.showMessageDialog(this, "Sửa thành công.");                  
                    clearJTextDichVu();
                } else {
                    JOptionPane.showMessageDialog(this, "Sửa thất bại.");
                }
            }
        }
    }//GEN-LAST:event_Button_SuaDichVuActionPerformed

    private void Button_LamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_LamMoiActionPerformed
        clearJTextDichVu();
    }//GEN-LAST:event_Button_LamMoiActionPerformed

    private void Table_DichVuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table_DichVuMouseClicked
        int indexTB = Table_DichVu.getSelectedRow();
        if (indexTB < tblDichVu.getRowCount() && indexTB >= 0){
            Text_MaDV.setText(tblDichVu.getValueAt(indexTB, 0).toString());
            Text_TenDV.setText(tblDichVu.getValueAt(indexTB, 1).toString());
            Text_DonGia.setText(tblDichVu.getValueAt(indexTB, 2).toString());
        }
    }//GEN-LAST:event_Table_DichVuMouseClicked
    
    public void clearJTextDichVu(){
        Text_MaDV.setText("");
        Text_TenDV.setText("");
        Text_DonGia.setText("");
    }
    public void showResult(){
        DanhMucDichVu DichVu = listDichVu.get(listDichVu.size() - 1);
        tblDichVu.addRow(new Object[]{ DichVu.getMaDV(), DichVu.getTenDV(), DichVu.getDonGia()});
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_InHoaDon;
    private javax.swing.JButton Button_LamMoi;
    private javax.swing.JButton Button_LamMoiDVPhong;
    private javax.swing.JButton Button_SuaDVPhong;
    private javax.swing.JButton Button_SuaDichVu;
    private javax.swing.JButton Button_ThemDVPhong;
    private javax.swing.JButton Button_ThemDichVu;
    private javax.swing.JButton Button_TimKiem;
    private javax.swing.JButton Button_XoaDVPhong;
    private javax.swing.JButton Button_XoaDichVu;
    private javax.swing.JComboBox<String> ComboBox_MaPhong;
    private javax.swing.JComboBox<String> ComboBox_TenDV;
    private com.toedter.calendar.JDateChooser JDateChooser_NgaySuDung;
    private javax.swing.JSpinner Spinner_SoLuong;
    private javax.swing.JTable Table_DichVu;
    private javax.swing.JTextField Text_DonGia;
    private javax.swing.JTextField Text_MaDV;
    private javax.swing.JTextField Text_TenDV;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable4;
    // End of variables declaration//GEN-END:variables
}
