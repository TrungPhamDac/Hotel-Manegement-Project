/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.User;
import View.AdminJFrame;
import View.MainJFrame;
import javax.swing.JFrame;

/**
 *
 * @author TNo1
 */
public class LoginController {
    private User currentUser;
    public LoginController(User user){
        if(user.getRole().equals("admin"))
        {
//            new AdminJFrame().setVisible(true);
            MainJFrame frame = new MainJFrame();
            frame.setExtendedState( JFrame.MAXIMIZED_BOTH);
            frame.setVisible(true);
        }
    }
    
}
