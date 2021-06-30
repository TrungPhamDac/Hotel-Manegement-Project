/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.KhachHangController;
import DAO.DataBaseConnection;
import Model.KhachHang;
import DAO.KhachHangDAO;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
/**
 *
 * @author asus
 */
public class QuanLiKhachHangJPane extends javax.swing.JPanel {
    private ArrayList<KhachHang> listKhachHang;
    DefaultTableModel tblKhachHang;
//    static int curr_MaKH;
    public QuanLiKhachHangJPane() {       
        initComponents();
        KhachHangDAO khDAO = new KhachHangDAO();
//        curr_MaKH =khDAO.getCurrentMaKH();
        //Text_MaKhachHang.setText(Integer.toString(curr_MaKH));
        listKhachHang = khDAO.getListKhachHang();
        tblKhachHang = (DefaultTableModel) Table_KhachHang.getModel();
        tblKhachHang.setColumnIdentifiers(new Object[]{"STT","Mã khách hàng", "Tên khách hàng", "CMND/CCCD", "Giới tính", "Số điện thoại"});
        showTable();
        Button_XoaKhachHang.setEnabled(false);
        Button_SuaTTKhachHang.setEnabled(false);
        Table_KhachHang.setDefaultEditor(Object.class, null);
    }
    
    public void showTable(){
        int i = 1;
        listKhachHang = new KhachHangDAO().getListKhachHang();
        for(KhachHang kh : listKhachHang){
            tblKhachHang.addRow(new Object[]{i++, kh.getMaKH(), kh.getTenKH(), kh.getCCCD(), kh.getGioiTinh(), kh.getSDT()});
        }
    }
    public void updateTable(){
        tblKhachHang.setRowCount(0);
        this.showTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Text_MaKhachHang = new javax.swing.JTextField();
        Text_HoTen = new javax.swing.JTextField();
        Text_CCCD = new javax.swing.JTextField();
        Text_SDT = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        Button_ThemKhachHang = new javax.swing.JButton();
        Button_TimKiem = new javax.swing.JButton();
        Button_LamMoi = new javax.swing.JButton();
        Button_XoaKhachHang = new javax.swing.JButton();
        Button_SuaTTKhachHang = new javax.swing.JButton();
        Button_InDSKH = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        ComboBox_GioiTinh = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        Table_KhachHang = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(204, 204, 204), null, null));
        jPanel2.setForeground(new java.awt.Color(153, 153, 153));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Mã khách hàng");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Họ tên");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("CMND/CCCD");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Số điện thoại");

        Text_MaKhachHang.setEditable(false);
        Text_MaKhachHang.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        Text_HoTen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        Text_CCCD.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        Text_SDT.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        Button_ThemKhachHang.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Button_ThemKhachHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagine/Add_Icon.png"))); // NOI18N
        Button_ThemKhachHang.setText("Thêm");
        Button_ThemKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_ThemKhachHangActionPerformed(evt);
            }
        });

        Button_TimKiem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Button_TimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagine/Search_Icon.png"))); // NOI18N
        Button_TimKiem.setText("Tìm kiếm");
        Button_TimKiem.setMaximumSize(new java.awt.Dimension(115, 40));
        Button_TimKiem.setMinimumSize(new java.awt.Dimension(115, 40));
        Button_TimKiem.setPreferredSize(new java.awt.Dimension(115, 40));
        Button_TimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_TimKiemActionPerformed(evt);
            }
        });

        Button_LamMoi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Button_LamMoi.setText("Làm mới");
        Button_LamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_LamMoiActionPerformed(evt);
            }
        });

        Button_XoaKhachHang.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Button_XoaKhachHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagine/Delete_Icon.png"))); // NOI18N
        Button_XoaKhachHang.setText("Xóa");
        Button_XoaKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_XoaKhachHangActionPerformed(evt);
            }
        });

        Button_SuaTTKhachHang.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Button_SuaTTKhachHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagine/Fix_Icon.png"))); // NOI18N
        Button_SuaTTKhachHang.setText("Sửa");
        Button_SuaTTKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_SuaTTKhachHangActionPerformed(evt);
            }
        });

        Button_InDSKH.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Button_InDSKH.setText("In danh sách");
        Button_InDSKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_InDSKHActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(Button_ThemKhachHang)
                        .addGap(18, 18, 18)
                        .addComponent(Button_LamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Button_TimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(Button_XoaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Button_SuaTTKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Button_InDSKH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Button_XoaKhachHang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Button_ThemKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Button_LamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Button_SuaTTKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Button_TimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Button_InDSKH, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60))
        );

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Giới tính");

        ComboBox_GioiTinh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ComboBox_GioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ", "Khác" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel5)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(Text_MaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Text_SDT, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                        .addComponent(Text_CCCD)
                        .addComponent(Text_HoTen))
                    .addComponent(ComboBox_GioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(Text_MaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(Text_HoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(ComboBox_GioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(Text_CCCD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(Text_SDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Table_KhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã khách hàng", "Họ tên", "Giới tính", "CCCD", "Số điện thoại"
            }
        ));
        Table_KhachHang.setShowHorizontalLines(true);
        Table_KhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table_KhachHangMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(Table_KhachHang);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Thông tin khách hàng");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1030, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    
    private void Button_ThemKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_ThemKhachHangActionPerformed
        if(new KhachHangController().KtraJtextKhachHang(Text_HoTen, Text_CCCD, Text_SDT)){
            KhachHang kh = new KhachHang();
            kh.setTenKH(Text_HoTen.getText());
            kh.setCCCD(Text_CCCD.getText());
            kh.setGioiTinh(ComboBox_GioiTinh.getSelectedItem().toString());
            kh.setSDT(Text_SDT.getText());
            KhachHangDAO khDAO = new KhachHangDAO();
            if(khDAO.ThemKhachHang(kh)){
                JOptionPane.showMessageDialog(this, "Thêm thành công.");
                listKhachHang = khDAO.getListKhachHang();
    //            curr_MaKH = khDAO.getCurrentMaKH();
                updateTable();
                clearJTextKhachHang();
    //            showResult();
            } else {
                JOptionPane.showMessageDialog(this, "Thêm thất bại.");
            }
        }
    }//GEN-LAST:event_Button_ThemKhachHangActionPerformed

    private void Table_KhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table_KhachHangMouseClicked
        ListSelectionModel listTable_KhachHang = Table_KhachHang.getSelectionModel();
        listTable_KhachHang.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        Button_ThemKhachHang.setEnabled(false);
        Button_SuaTTKhachHang.setEnabled(true);
        Button_XoaKhachHang.setEnabled(true);
        int indexTB = Table_KhachHang.getSelectedRow();
        if (indexTB < tblKhachHang.getRowCount() && indexTB >= 0){
            Text_MaKhachHang.setText(tblKhachHang.getValueAt(indexTB, 1).toString());
            Text_HoTen.setText(tblKhachHang.getValueAt(indexTB, 2).toString());
            Text_CCCD.setText(tblKhachHang.getValueAt(indexTB, 3).toString());
            ComboBox_GioiTinh.setSelectedItem(tblKhachHang.getValueAt(indexTB, 4));
            Text_SDT.setText(tblKhachHang.getValueAt(indexTB, 5).toString());
        }
    }//GEN-LAST:event_Table_KhachHangMouseClicked

    public KhachHang returnKhachHang(int index){       
        int MaKH = Integer.parseInt(tblKhachHang.getValueAt(index, 1).toString());
        String HoTen = tblKhachHang.getValueAt(index, 2).toString();
        String CCCD = tblKhachHang.getValueAt(index, 3).toString();
        String GioiTinh = tblKhachHang.getValueAt(index, 4).toString();
        String SDT = tblKhachHang.getValueAt(index, 5).toString();      
        return new KhachHang(MaKH,HoTen,CCCD,GioiTinh,SDT);
    }
    
    private void Button_SuaTTKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_SuaTTKhachHangActionPerformed
        if(new KhachHangController().KtraJtextKhachHang(Text_HoTen, Text_CCCD, Text_SDT)){
            int indexTB = Table_KhachHang.getSelectedRow();
            int MaKH = Integer.parseInt(Text_MaKhachHang.getText());
            String HoTen = Text_HoTen.getText();
            String GioiTinh = ComboBox_GioiTinh.getSelectedItem().toString();
            String SDT = Text_SDT.getText();
            KhachHang kh = new KhachHang(MaKH, HoTen, SDT, GioiTinh, SDT);
            int ret = JOptionPane.showConfirmDialog(null, "Bạn có muốn sửa dữ liệu?", "Sửa dữ liệu", JOptionPane.YES_NO_OPTION);
            if(ret == JOptionPane.YES_OPTION){
                if(new KhachHangDAO().SuaKhachHang(kh)){
                    if(indexTB < tblKhachHang.getRowCount() && indexTB >= 0){
                        tblKhachHang.setValueAt(Text_HoTen.getText(), indexTB, 2);
                        tblKhachHang.setValueAt(Text_CCCD.getText(), indexTB, 3);
                        tblKhachHang.setValueAt(ComboBox_GioiTinh.getSelectedItem(), indexTB, 4);
                        tblKhachHang.setValueAt(Text_SDT.getText(), indexTB, 5);
                        JOptionPane.showMessageDialog(this, "Sửa thành công.");  
                        clearJTextKhachHang();
                    } else {
                        JOptionPane.showMessageDialog(this, "Sửa thất bại.");
                    }
                }
            }
        }
    }//GEN-LAST:event_Button_SuaTTKhachHangActionPerformed

    private void Button_LamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_LamMoiActionPerformed
        Button_ThemKhachHang.setEnabled(true);
        Button_XoaKhachHang.setEnabled(false);
        Button_SuaTTKhachHang.setEnabled(false);
        clearJTextKhachHang();
        updateTable();
    }//GEN-LAST:event_Button_LamMoiActionPerformed
    
    private void Button_XoaKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_XoaKhachHangActionPerformed
        int indexTB = Table_KhachHang.getSelectedRow();        
        KhachHang kh = returnKhachHang(indexTB);       
        int ret = JOptionPane.showConfirmDialog(null,"Bạn có muốn xóa dữ liệu?", "Xóa dữ liệu", JOptionPane.YES_NO_OPTION);
        if(ret == JOptionPane.YES_OPTION){
            if(indexTB < tblKhachHang.getRowCount() && indexTB >= 0){
                if(new KhachHangDAO().XoaKhachHang(kh)){               
                    JOptionPane.showMessageDialog(this, "Xóa thành công.");
                    tblKhachHang.removeRow((indexTB));
                    clearJTextKhachHang();
            } else {
                JOptionPane.showMessageDialog(this, "Xóa thất bại.");
                }
            }         
        }
    }//GEN-LAST:event_Button_XoaKhachHangActionPerformed

    public void showResultTimKiem(KhachHang khachhangInput){
        listKhachHang = new KhachHangDAO().getFilterListKhachHang(khachhangInput);
        tblKhachHang.setRowCount(0);
        int i = 1;
        for(KhachHang kh : listKhachHang){
            tblKhachHang.addRow(new Object[]{i++, kh.getMaKH(), kh.getTenKH(), kh.getCCCD(), kh.getGioiTinh(), kh.getSDT()});
        }
        if(listKhachHang.size() <= 0)
            JOptionPane.showMessageDialog(this,"Không tìm thấy thông tin khách hàng. Vui lòng kiểm tra lại!");
    }
    
    private void Button_TimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_TimKiemActionPerformed
        KhachHang kh = new KhachHang();
        kh.setTenKH(Text_HoTen.getText());
        kh.setCCCD(Text_CCCD.getText());
        kh.setSDT(Text_SDT.getText());
        showResultTimKiem(kh);
    }//GEN-LAST:event_Button_TimKiemActionPerformed
    
    private void viewReport(String fileName, HashMap para) {
        try {
            JasperPrint jasperPrint = JasperFillManager.fillReport(fileName, para, DataBaseConnection.getConnection());
            JasperViewer jv = new JasperViewer(jasperPrint, false);
            jv.setVisible(true);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    private void Button_InDSKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_InDSKHActionPerformed
        viewReport("src\\Reports\\DanhSachKhachHang.jasper", null);
    }//GEN-LAST:event_Button_InDSKHActionPerformed
     
    public void clearJTextKhachHang(){
//        Text_MaKhachHang.setText(Integer.toString(curr_MaKH));
        Text_MaKhachHang.setText("");
        Text_HoTen.setText("");
        Text_CCCD.setText("");
        ComboBox_GioiTinh.setSelectedItem("Nam");
        Text_SDT.setText("");
    }
    public void showResult(){
        //int i = 1;
        KhachHang kh = listKhachHang.get(listKhachHang.size() - 1);
        tblKhachHang.addRow(new Object[]{ kh.getMaKH(), kh.getTenKH(), kh.getCCCD(), kh.getGioiTinh(), kh.getSDT()});
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_InDSKH;
    private javax.swing.JButton Button_LamMoi;
    private javax.swing.JButton Button_SuaTTKhachHang;
    private javax.swing.JButton Button_ThemKhachHang;
    private javax.swing.JButton Button_TimKiem;
    private javax.swing.JButton Button_XoaKhachHang;
    private javax.swing.JComboBox<String> ComboBox_GioiTinh;
    private javax.swing.JTable Table_KhachHang;
    private javax.swing.JTextField Text_CCCD;
    private javax.swing.JTextField Text_HoTen;
    private javax.swing.JTextField Text_MaKhachHang;
    private javax.swing.JTextField Text_SDT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
