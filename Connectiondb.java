package jan1;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
public class Connectiondb {
    public static Connection getConnection(){
        Connection con=null;
        Statement s;
        try{
            Class.forName ("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hms","root","abcd");
            s=(Statement) con.createStatement();
        }
        catch(Exception e){
            System.out.println(e);
        }
        return con;
    }
    
}