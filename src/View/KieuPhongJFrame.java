/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import Controller.KieuPhongController;
import DAO.KieuPhongDAO;
import Model.KieuPhong;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author asus
 */
public class KieuPhongJFrame extends javax.swing.JFrame {
    private ArrayList<KieuPhong> listKieuPhong;
    DefaultTableModel tblKieuPhong;
    /**
     * Creates new form KieuPhongJFrame
     */
    public KieuPhongJFrame() {
        JFrameCenterOfScreen();
        initComponents();
        listKieuPhong = new KieuPhongDAO().getListKieuPhong();
        tblKieuPhong = (DefaultTableModel) Table_KieuPhong.getModel();
        tblKieuPhong.setColumnIdentifiers(new Object[]{"STT","Mã loại phòng", "Kiểu phòng", "Kiểu giường", "Giá phòng"});
        showTableChiTietDV();
        Button_SuaKieuPhong.setEnabled(false);
        Button_XoaKieuPhong.setEnabled(false);
    }
    public int getRowTableKieuPhong(){
        return Table_KieuPhong.getRowCount();
    }
    public void JFrameCenterOfScreen(){
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width/2 - getWidth()/4, size.height/4 - getHeight()/2);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        Text_KieuGiuong = new javax.swing.JTextField();
        Text_KieuPhong = new javax.swing.JTextField();
        Text_GiaPhong = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        Button_ThemKieuPhong = new javax.swing.JButton();
        Button_SuaKieuPhong = new javax.swing.JButton();
        Button_LamMoi = new javax.swing.JButton();
        Button_XoaKieuPhong = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Text_MaLoaiPhg = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        Table_KieuPhong = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(153, 153, 153), null, null));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Kiểu phòng");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Kiểu giường");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Giá phòng");

        Text_KieuGiuong.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        Text_KieuPhong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        Text_GiaPhong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        Button_ThemKieuPhong.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Button_ThemKieuPhong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagine/baseline_add_black_24dp.png"))); // NOI18N
        Button_ThemKieuPhong.setText("Thêm");
        Button_ThemKieuPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_ThemKieuPhongActionPerformed(evt);
            }
        });

        Button_SuaKieuPhong.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Button_SuaKieuPhong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagine/baseline_build_black_24dp.png"))); // NOI18N
        Button_SuaKieuPhong.setText("Sửa");
        Button_SuaKieuPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_SuaKieuPhongActionPerformed(evt);
            }
        });

        Button_LamMoi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Button_LamMoi.setText("Làm mới");
        Button_LamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_LamMoiActionPerformed(evt);
            }
        });

        Button_XoaKieuPhong.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Button_XoaKieuPhong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagine/baseline_remove_black_24dp.png"))); // NOI18N
        Button_XoaKieuPhong.setText("Xóa");
        Button_XoaKieuPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_XoaKieuPhongActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(Button_SuaKieuPhong, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Button_ThemKieuPhong, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Button_LamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Button_XoaKieuPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Button_ThemKieuPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Button_LamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Button_SuaKieuPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Button_XoaKieuPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Mã loại phòng");

        Text_MaLoaiPhg.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Text_MaLoaiPhg, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                    .addComponent(Text_KieuPhong)
                    .addComponent(Text_KieuGiuong)
                    .addComponent(Text_GiaPhong))
                .addGap(18, 18, 18)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(Text_MaLoaiPhg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(Text_KieuPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(Text_KieuGiuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(Text_GiaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Table_KieuPhong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã loại  phòng", "Kiểu phòng", "Kiểu giường", "Giá"
            }
        ));
        Table_KieuPhong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table_KieuPhongMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(Table_KieuPhong);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 528, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void showTableChiTietDV(){
        int i = 1;
        ArrayList<KieuPhong> listKieuPhong = new KieuPhongDAO().getListKieuPhong();
        for(KieuPhong KP : listKieuPhong){
            tblKieuPhong.addRow(new Object[]{i++, KP.getMaLoaiPhg(), KP.getKieuPhong(), KP.getKieuGiuong(), KP.getDonGia()});
        }
    }
    
    public void updateTable(){
        tblKieuPhong.setRowCount(0);
        this.showTableChiTietDV();
    }
    
    private void Button_ThemKieuPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_ThemKieuPhongActionPerformed
        if(new KieuPhongController().KtraJtextKieuPhong(Text_MaLoaiPhg, Text_KieuGiuong, Text_KieuPhong, Text_GiaPhong)){
            KieuPhong KP = new KieuPhong();
            KP.setMaLoaiPhg(Text_MaLoaiPhg.getText());
            KP.setKieuPhong(Text_KieuPhong.getText());
            KP.setKieuGiuong(Integer.parseInt(Text_KieuGiuong.getText()));
            KP.setDonGia(Integer.parseInt(Text_GiaPhong.getText()));
            if(new KieuPhongDAO().ThemKieuPhong(KP)){
                JOptionPane.showMessageDialog(this, "Thêm thành công");
                listKieuPhong.add(KP);
                updateTable();
                clearJTextKieuPhong();
//                new QuanLiPhongJPane().showComboBox_KieuPhong();
                new QuanLiPhongJPane().insertIntoComboBox_KieuPhong(Text_KieuPhong.getText());
            }
        }
    }//GEN-LAST:event_Button_ThemKieuPhongActionPerformed

    public KieuPhong returnTTKieuPhong(int index){
        String MaLoaiPhg = tblKieuPhong.getValueAt(index, 1).toString();
        String KieuPhong = tblKieuPhong.getValueAt(index, 2).toString();
        int KieuGiuong = (int) tblKieuPhong.getValueAt(index, 3);
        int GiaPhong = (int) tblKieuPhong.getValueAt(index, 4);
        return new KieuPhong(MaLoaiPhg,KieuPhong,KieuGiuong,GiaPhong);
    }
    
    private void Button_SuaKieuPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_SuaKieuPhongActionPerformed
        if(new KieuPhongController().KtraJtextKieuPhong(Text_MaLoaiPhg, Text_KieuGiuong, Text_KieuPhong, Text_GiaPhong)){
            int indexTB = Table_KieuPhong.getSelectedRow();
            KieuPhong KPCu = returnTTKieuPhong(indexTB);
            int ret = JOptionPane.showConfirmDialog(null,"Bạn có muốn sửa dữ liệu?", "Sữa dữ liệu", JOptionPane.YES_NO_OPTION);
            if(ret == JOptionPane.YES_OPTION){
                KieuPhong KPMoi = new KieuPhong(Text_MaLoaiPhg.getText(),Text_KieuPhong.getText(),
                                                Integer.parseInt(Text_KieuGiuong.getText().toString()),
                                                Integer.parseInt(Text_GiaPhong.getText().toString()));
                if(indexTB < tblKieuPhong.getRowCount() && indexTB >= 0){
                    if(new KieuPhongDAO().SuaKieuPhong(KPCu, KPMoi)){   
                        tblKieuPhong.setValueAt(Text_MaLoaiPhg, indexTB, 1);
                        tblKieuPhong.setValueAt(Text_KieuPhong, indexTB, 2);
                        tblKieuPhong.setValueAt(Text_KieuGiuong, indexTB, 3);
                        tblKieuPhong.setValueAt(Text_GiaPhong, indexTB, 4);
                        JOptionPane.showMessageDialog(this, "Sửa thành công.");
                        updateTable();
                        clearJTextKieuPhong();
                    } else {
                        JOptionPane.showMessageDialog(this, "Sửa thất bại.");
                    }
                }         
            }
        }
    }//GEN-LAST:event_Button_SuaKieuPhongActionPerformed

    private void Button_LamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_LamMoiActionPerformed
        Button_ThemKieuPhong.setEnabled(true);
        Button_SuaKieuPhong.setEnabled(false);
        Button_XoaKieuPhong.setEnabled(false);
        updateTable();
        clearJTextKieuPhong();
    }//GEN-LAST:event_Button_LamMoiActionPerformed

    public void clearJTextKieuPhong(){
        Text_MaLoaiPhg.setText("");
        Text_KieuPhong.setText("");
        Text_KieuGiuong.setText("");
        Text_GiaPhong.setText("");
    }
    
    private void Button_XoaKieuPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_XoaKieuPhongActionPerformed
        int indexTB = Table_KieuPhong.getSelectedRow();
        KieuPhong KP = returnTTKieuPhong(indexTB);
        int ret = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa dữ liệu?", "Xóa dữ liệu", JOptionPane.YES_NO_OPTION);
        if(ret == JOptionPane.YES_OPTION){
            if(indexTB < tblKieuPhong.getRowCount() && indexTB >= 0){
                if(new KieuPhongDAO().XoaKieuPhong(KP)){
                    JOptionPane.showMessageDialog(this, "Xóa thành công.");
                    tblKieuPhong.removeRow(indexTB);
                    clearJTextKieuPhong();
                } else { JOptionPane.showMessageDialog(this, "Xóa thất bại.");}
            }
        }
    }//GEN-LAST:event_Button_XoaKieuPhongActionPerformed

    private void Table_KieuPhongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table_KieuPhongMouseClicked
        ListSelectionModel listTable_KieuPhong = Table_KieuPhong.getSelectionModel();
        listTable_KieuPhong.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        Button_ThemKieuPhong.setEnabled(false);
        Button_XoaKieuPhong.setEnabled(true);
        Button_SuaKieuPhong.setEnabled(true);
        int indexTB = Table_KieuPhong.getSelectedRow();
        if (indexTB < tblKieuPhong.getRowCount() && indexTB >= 0){
            Text_MaLoaiPhg.setText(tblKieuPhong.getValueAt(indexTB, 1).toString());
            Text_KieuPhong.setText(tblKieuPhong.getValueAt(indexTB, 2).toString());
            Text_KieuGiuong.setText(tblKieuPhong.getValueAt(indexTB, 3).toString());
            Text_GiaPhong.setText(tblKieuPhong.getValueAt(indexTB, 4).toString());
        }
    }//GEN-LAST:event_Table_KieuPhongMouseClicked

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(KieuPhongJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(KieuPhongJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(KieuPhongJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(KieuPhongJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new KieuPhongJFrame().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_LamMoi;
    private javax.swing.JButton Button_SuaKieuPhong;
    private javax.swing.JButton Button_ThemKieuPhong;
    private javax.swing.JButton Button_XoaKieuPhong;
    private javax.swing.JTable Table_KieuPhong;
    private javax.swing.JTextField Text_GiaPhong;
    private javax.swing.JTextField Text_KieuGiuong;
    private javax.swing.JTextField Text_KieuPhong;
    private javax.swing.JTextField Text_MaLoaiPhg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
