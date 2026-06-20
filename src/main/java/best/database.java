package best;

import java.sql.Connection;
import java.sql.DriverManager;

public class database {
   
  public static Connection connectdb(){
    try  {
      Class.forName("com.mysql.cj.jdbc.Driver");

      Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/payslip_db", "root", "");
        return connect;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }
}
