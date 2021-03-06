package View;

import Controller.DoAnController;
import DAO.DanhMucMonAnDAO;
import Model.DanhMucMonAn;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author asus
 */
public class QuanLiDoAn extends javax.swing.JFrame {
    private ArrayList<DanhMucMonAn> listMonAn;
    DefaultTableModel tblMonAn;
    public QuanLiDoAn() {
        initComponents();
        JFrameCenterOfScreen();
        listMonAn = new DanhMucMonAnDAO().getListMonAn();
        tblMonAn = (DefaultTableModel) Table_MonAn.getModel();
        tblMonAn.setColumnIdentifiers(new Object[]{"Mã món ăn", "Tên món ăn", "Đơn giá"});
        showTable();
        ButtonSetEnabaled(true);
        Table_MonAn.setDefaultEditor(Object.class, null);
    }
    
    public void showTable(){
        listMonAn = new DanhMucMonAnDAO().getListMonAn();
         for(DanhMucMonAn MonAn : listMonAn){
            tblMonAn.addRow(new Object[]{MonAn.getMaMonAn(), MonAn.getTenMonAn(), MonAn.getDonGia()});
        }
    }
    
    public void updateTable(){
        tblMonAn.setRowCount(0);
        this.showTable();
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table_MonAn = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Text_MaMonAn = new javax.swing.JTextField();
        Text_TenMonAn = new javax.swing.JTextField();
        Text_DonGia = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        Button_ThemMonAn = new javax.swing.JButton();
        Button_LamMoi = new javax.swing.JButton();
        Button_SuaMonAn = new javax.swing.JButton();
        Button_XoaMonAn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Quản lí đồ ăn");

        Table_MonAn.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã đồ ăn", "Tên đồ ăn", "Đơn giá"
            }
        ));
        Table_MonAn.setShowHorizontalLines(true);
        Table_MonAn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table_MonAnMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Table_MonAn);

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(153, 153, 153), null, null));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Mã đồ ăn");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Tên đồ ăn");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Đơn giá");

        Text_MaMonAn.setEditable(false);
        Text_MaMonAn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        Text_TenMonAn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        Text_DonGia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        Button_ThemMonAn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Button_ThemMonAn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagine/Add_Icon.png"))); // NOI18N
        Button_ThemMonAn.setText("Thêm");
        Button_ThemMonAn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_ThemMonAnActionPerformed(evt);
            }
        });

        Button_LamMoi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Button_LamMoi.setText("Làm mới");
        Button_LamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_LamMoiActionPerformed(evt);
            }
        });

        Button_SuaMonAn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Button_SuaMonAn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagine/Fix_Icon.png"))); // NOI18N
        Button_SuaMonAn.setText("Sửa");
        Button_SuaMonAn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_SuaMonAnActionPerformed(evt);
            }
        });

        Button_XoaMonAn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Button_XoaMonAn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagine/Delete_Icon.png"))); // NOI18N
        Button_XoaMonAn.setText("Xóa");
        Button_XoaMonAn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_XoaMonAnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Button_SuaMonAn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Button_ThemMonAn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Button_LamMoi, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                    .addComponent(Button_XoaMonAn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Button_ThemMonAn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Button_LamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Button_SuaMonAn, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(Button_XoaMonAn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Text_TenMonAn, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Text_DonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Text_MaMonAn, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(Text_MaMonAn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(Text_TenMonAn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(Text_DonGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Button_ThemMonAnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_ThemMonAnActionPerformed
        if(new DoAnController().KtraJTextDoAn(Text_TenMonAn, Text_DonGia)){
            DanhMucMonAn MonAn = new DanhMucMonAn();
            //MonAn.setMaMonAn(Integer.parseInt(Text_MaMonAn.getText()));
            MonAn.setTenMonAn(Text_TenMonAn.getText());
            MonAn.setDonGia(Integer.parseInt(Text_DonGia.getText()));
            if(new DanhMucMonAnDAO().ThemMonAn(MonAn)){
                JOptionPane.showMessageDialog(rootPane, "Thêm thành công.");
                listMonAn.add(MonAn);
                clearJTextMonAn();
                updateTable();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Thêm thất bại.");
            }
        }
    }//GEN-LAST:event_Button_ThemMonAnActionPerformed

    public DanhMucMonAn returnMonAn(int index){        
        int MaMonAn = (int) tblMonAn.getValueAt(index, 0);
        String TenMonAn = tblMonAn.getValueAt(index, 1).toString();
        int DonGia = Integer.parseInt(tblMonAn.getValueAt(index, 2).toString());
        
        return new DanhMucMonAn(MaMonAn,TenMonAn,DonGia);
    }
    
    private void Button_XoaMonAnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_XoaMonAnActionPerformed
        int indexTB = Table_MonAn.getSelectedRow();
        
        DanhMucMonAn MonAn = returnMonAn(indexTB);
        
        int ret = JOptionPane.showConfirmDialog(null,"Bạn có muốn xóa dữ liệu?", "Xóa dữ liệu", JOptionPane.YES_NO_OPTION);
        if(ret == JOptionPane.YES_OPTION){
            if(indexTB < tblMonAn.getRowCount() && indexTB >= 0){
                if(new DanhMucMonAnDAO().XoaMonAn(MonAn)){               
                    JOptionPane.showMessageDialog(this, "Xóa thành công.");
                    tblMonAn.removeRow((indexTB));
                    clearJTextMonAn();
            } else {
                JOptionPane.showMessageDialog(this, "Xóa thất bại.");
                }
            }         
        }
    }//GEN-LAST:event_Button_XoaMonAnActionPerformed

    private void Button_SuaMonAnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_SuaMonAnActionPerformed
        if(new DoAnController().KtraJTextDoAn(Text_TenMonAn, Text_DonGia)){
            int indexTB = Table_MonAn.getSelectedRow();
            int MaMonAn = Integer.parseInt(Text_MaMonAn.getText());
            String TenMonAn = Text_TenMonAn.getText();
            int DonGia = Integer.parseInt(Text_DonGia.getText());
            DanhMucMonAn MonAn = new DanhMucMonAn(MaMonAn, TenMonAn, DonGia);
            int ret = JOptionPane.showConfirmDialog(null, "Bạn có muốn sửa dữ liệu?","Sửa dữ liệu",JOptionPane.YES_NO_OPTION);
            if(ret == JOptionPane.YES_OPTION){
                if(new DanhMucMonAnDAO().SuaMonAn(MonAn)){
                    if(indexTB < tblMonAn.getRowCount() && indexTB >= 0){
                        tblMonAn.setValueAt(Text_TenMonAn.getText(), indexTB, 1);
                        tblMonAn.setValueAt(Text_DonGia.getText(), indexTB, 2);
                        JOptionPane.showMessageDialog(this, "Sửa thành công.");                  
                        clearJTextMonAn();
                    } else {
                        JOptionPane.showMessageDialog(this, "Sửa thất bại.");
                    }
                }
            }
        }
    }//GEN-LAST:event_Button_SuaMonAnActionPerformed

    private void Table_MonAnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table_MonAnMouseClicked
        ListSelectionModel listTable_MonAn = Table_MonAn.getSelectionModel();
        listTable_MonAn.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        ButtonSetEnabaled(false);
        int indexTB = Table_MonAn.getSelectedRow();
        if (indexTB < tblMonAn.getRowCount() && indexTB >= 0){
            Text_MaMonAn.setText(tblMonAn.getValueAt(indexTB, 0).toString());
            Text_TenMonAn.setText(tblMonAn.getValueAt(indexTB, 1).toString());
            Text_DonGia.setText(tblMonAn.getValueAt(indexTB, 2).toString());
        }
    }//GEN-LAST:event_Table_MonAnMouseClicked

    private void Button_LamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_LamMoiActionPerformed
        ButtonSetEnabaled(true);
        clearJTextMonAn();
    }//GEN-LAST:event_Button_LamMoiActionPerformed

    public void ButtonSetEnabaled(boolean bl){
        if(bl == true){
            Button_ThemMonAn.setEnabled(true);
            Button_XoaMonAn.setEnabled(false);
            Button_SuaMonAn.setEnabled(false);
        } else {
            Button_ThemMonAn.setEnabled(false);
            Button_XoaMonAn.setEnabled(true);
            Button_SuaMonAn.setEnabled(true);
        }
    }
    
    public void clearJTextMonAn(){
        Text_MaMonAn.setText("");
        Text_TenMonAn.setText("");
        Text_DonGia.setText("");
    }
    
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
//            java.util.logging.Logger.getLogger(QuanLiDoAn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(QuanLiDoAn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(QuanLiDoAn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(QuanLiDoAn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new QuanLiDoAn().setVisible(true);            
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_LamMoi;
    private javax.swing.JButton Button_SuaMonAn;
    private javax.swing.JButton Button_ThemMonAn;
    private javax.swing.JButton Button_XoaMonAn;
    private javax.swing.JTable Table_MonAn;
    private javax.swing.JTextField Text_DonGia;
    private javax.swing.JTextField Text_MaMonAn;
    private javax.swing.JTextField Text_TenMonAn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
