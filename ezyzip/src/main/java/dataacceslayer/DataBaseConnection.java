
package dataacceslayer;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;


public class DataBaseConnection {
private final String connectionString="jdbc:mariadb://localhost:3307/trabajo4";
private final String user="root1";
private final String password="Ggf72686119hp";
public Connection connection= null;
public DataBaseConnection(){
   this.init();
}
private void init(){
    try{
        connection =DriverManager.getConnection(connectionString, user, password);
        
        }catch(SQLException ex){
        
          System.out.println(ex.getMessage());
    }
}
    
}
