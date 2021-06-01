package DAO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author asus
 */
public class DataBaseConnection {
    public static Connection getConnection(){
        Connection con = null;
        final String url = "jdbc:oracle:thin:@localhost:1521:orcl";
        final String user = "hotelmng";
        final String password = "123456";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(url,user,password);
//            System.out.println("Connected to Database");
            return con;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
//    public static void main(String[] agrs) throws SQLException{
//        Connection c = getConnection();
//        System.out.println(c.toString());
//        c.close();
//    }
}
 
