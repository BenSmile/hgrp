package login.dao;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import jpa.Users;
 
import login.util.DataConnect;
 
public class LoginDAO {
    
    public static Users userConnected;
 
    public static boolean validate(String user, String password) {
        Connection con = null;
        PreparedStatement ps = null;
 
        try {
            con = DataConnect.getConnection();
            ps = con.prepareStatement("Select * from users where uname = ? and password = ?");
            ps.setString(1, user);
            ps.setString(2, password);
 
            ResultSet rs = ps.executeQuery();
 
            if (rs.next()) {
                //result found, means valid inputs
                 userConnected = new Users(rs.getString("uname"), rs.getString("password"), rs.getString("nom"), rs.getString("post_nom"), rs.getString("prenom"), rs.getString("role"));
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Login error -->" + ex.getMessage());
            return false;
        } finally {
            DataConnect.close(con);
        }
        return false;
    }
}