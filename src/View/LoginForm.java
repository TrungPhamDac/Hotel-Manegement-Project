/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.LoginController;
import DAO.UserDAO;
import Model.User;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author TNo1
 */
public class LoginForm extends javax.swing.JFrame {
    private User user = new User();
    /**
     * Creates new form LoginForm_v
     */
    public LoginForm() {
        initComponents();
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
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        txtUsername = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel_DangNhap = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setPreferredSize(new java.awt.Dimension(682, 350));

        jPanel2.setBackground(new java.awt.Color(63, 120, 208));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagine/hotel_building_100px.png"))); // NOI18N
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 140, 128));

        jLabel9.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel9.setText("Phần mềm quản lý khách sạn");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 260, 65));

        jPanel3.setBackground(new java.awt.Color(24, 34, 56));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtUsername.setBackground(new java.awt.Color(24, 34, 56));
        txtUsername.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtUsername.setForeground(new java.awt.Color(255, 255, 255));
        txtUsername.setText("Tên đăng nhập");
        txtUsername.setBorder(null);
        txtUsername.setPreferredSize(new java.awt.Dimension(200, 20));
        txtUsername.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtUsernameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtUsernameFocusLost(evt);
            }
        });
        txtUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsernameActionPerformed(evt);
            }
        });
        jPanel3.add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 200, 30));

        txtPassword.setBackground(new java.awt.Color(24, 34, 56));
        txtPassword.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtPassword.setForeground(new java.awt.Color(255, 255, 255));
        txtPassword.setText("Mật khẩu");
        txtPassword.setBorder(null);
        txtPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPasswordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPasswordFocusLost(evt);
            }
        });
        jPanel3.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, 200, 30));

        jSeparator1.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 200, 20));

        jSeparator2.setForeground(new java.awt.Color(204, 204, 204));
        jPanel3.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 200, 20));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagine/user_icon.png"))); // NOI18N
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 30, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagine/lock_icon.png"))); // NOI18N
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 30, 30));

        jPanel4.setBackground(new java.awt.Color(24, 34, 56));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jLabel_DangNhap.setBackground(new java.awt.Color(255, 255, 255));
        jLabel_DangNhap.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel_DangNhap.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_DangNhap.setText("     Đăng nhập");
        jLabel_DangNhap.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel_DangNhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_DangNhapMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel_DangNhap, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel_DangNhap, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, 110, 30));

        jPanel5.setBackground(new java.awt.Color(24, 34, 56));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("  Nhân viên mới");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 200, 110, 30));

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Quên mật khẩu ?");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, 110, -1));

        jLabel7.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Đăng nhập");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 140, 50));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 681, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsernameActionPerformed

    private void txtUsernameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUsernameFocusGained
        // TODO add your handling code here:
        if (txtUsername.getText().equals("Tên đăng nhập"))
            txtUsername.setText("");
    }//GEN-LAST:event_txtUsernameFocusGained

    private void txtPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPasswordFocusGained
        // TODO add your handling code here:
        if(txtPassword.getText().equals("Mật khẩu"))
                txtPassword.setText("");
    }//GEN-LAST:event_txtPasswordFocusGained

    private void txtUsernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUsernameFocusLost
        // TODO add your handling code here:
        if (txtUsername.getText().equals(""))
            txtUsername.setText("Tên đăng nhập");
    }//GEN-LAST:event_txtUsernameFocusLost

    private void txtPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPasswordFocusLost
        // TODO add your handling code here:
        if (txtPassword.getText().equals(""))
            txtPassword.setText("Mật khẩu");
    }//GEN-LAST:event_txtPasswordFocusLost

    private void jLabel_DangNhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_DangNhapMouseClicked
        // TODO add your handling code here:
        if (txtUsername.getText().toString().equals("") || txtPassword.getText().toString().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ tên đăng nhập và mật khẩu", "Thông báo", HEIGHT);
        }
        else{
            user.setUsername(txtUsername.getText());
            user.setPassword(new String(txtPassword.getPassword()));
            User result = new UserDAO().validateUser(user);
            if (result == null)
            {
                JOptionPane.showMessageDialog(this, "Tên tài khoản không tồn tại");
            }
            else
            {
                if (java.util.Arrays.equals(txtPassword.getPassword(),result.getPassword().toCharArray()))
                {
                    JOptionPane.showMessageDialog(this, "Đănh nhập thành công");
                    
                    new LoginController(result);
                    this.dispose();
                }
                else {                    
                    JOptionPane.showMessageDialog(this, "Đănh nhập thất bại");
                }
            }
            
        }
    }//GEN-LAST:event_jLabel_DangNhapMouseClicked
  
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_DangNhap;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
