package Main;

import View.AdminJFrame;
import View.LoginForm;
import View.MainJFrame;
import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.JFrame;
import javax.swing.UIManager;

/**
 *
 * @author asus
 */
public class Main {
    public static void main(String[] args){
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
//        new AdminJFrame().setVisible(true);
//        new MainJFrame().setVisible(true);
        LoginForm lgform = new LoginForm();
        lgform.setVisible(true);

    }
}
