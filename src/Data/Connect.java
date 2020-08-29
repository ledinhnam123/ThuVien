package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Gaara
 */
public class Connect {
    private  static Connection con;
    
    public static Connection getConnect(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ThuVien;Username=sa;Password=123");
            
        } catch (Exception e) {
            System.out.println("Kết nối không thành công");
           // e.printStackTrace();
           // System.exit(1);
        }
        return con;
    }
    public static String testConnect() {
        try{
            con = Connect.getConnect();
            return "Kết nối thành công";
        }
        catch(Exception e) {
            return "Kết nối thất bại";
        }
    } 
    
    public static void main(String[] args) {
		Connect cnConnect = new Connect();
		cnConnect.getConnect();
	}
}
