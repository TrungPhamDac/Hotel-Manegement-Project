/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.User;
import View.MainJFrame;

/**
 *
 * @author TNo1
 */
public class LoginController {
    private User currentUser;
    public LoginController(User user){
        if(user.getRole() == "admin")
        {
            new MainJFrame().setVisible(true);
        }
    }
    
}
