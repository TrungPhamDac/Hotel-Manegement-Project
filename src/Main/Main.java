package Main;

import View.LoginForm;
import View.MainJFrame;
import javax.swing.JFrame;
import javax.swing.UIManager;

/**
 *
 * @author asus
 */
public class Main {
    public static void main(String[] args){
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

       new MainJFrame().setVisible(true);
//        LoginForm lgform = new LoginForm();
//        lgform.setVisible(true);

    }
}
