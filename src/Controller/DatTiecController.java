package Controller;

import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class DatTiecController {
    public boolean KtraJTextDatTiec(JTextField MaKH, JTextField TienCoc, JDateChooser NgayToChuc){
        if(MaKH.getText().equals("") ||TienCoc.getText().equals("") || NgayToChuc.getDate() == null){
            JOptionPane.showMessageDialog(null, "Vui lòng nhập đủ thông tin.");
            return false;
        }
        if(!isNumberOrNot(TienCoc.getText())){
            JOptionPane.showMessageDialog(null, "Tiền cọc phải là số. Vui lòng nhập lại.");
            return false;
        }
        return true;
    }
    
    private boolean isNumberOrNot(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
