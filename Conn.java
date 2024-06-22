package electricity.billing.system2;
import java.sql.*;

public class Conn {
    
    Connection c;
    Statement s;
            
    Conn(){
        try{
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/electricitybillingsystem","root", "PrathamKomal2002");
            s = c.createStatement();
            
        } catch (Exception e){
            System.out.println(e);
        }
    }
}
