package Methods;

import Fields.DBUrl;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class UserLogger
{
  private static final int CURRENT = 0;
  private static final int RESERVATION = 1;
  private static final int GUEST = 2;
  private static final int ROOm = 3;
  private static final int TRANS = 4;
  private static final int REPORTS = 5;
  SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
  
  public void insertLog(String user, int loc, String action)
  {
    String now = this.df.format(Calendar.getInstance().getTime());
    try
    {
      Class.forName("com.mysql.jdbc.Driver");
      String connectionUrl = DBUrl.dbconSales;
      Connection con = DriverManager.getConnection(connectionUrl);
      Statement stmt = con.createStatement();
      stmt.executeUpdate("INSERT INTO `database`.`userlog` (`user`, `loc`, `action`, `date`) VALUES ('" + user + "', '" + loc + "', '" + action + "', '" + now + "');");
    }
    catch (SQLException e)
    {
      System.out.println("SQL Exception: " + e.toString());
    }
    catch (ClassNotFoundException cE)
    {
      System.out.println("Class Not Found Exception: " + cE.toString());
    }
  }
}


/* Location:           D:\New folder\New folder\dist\11thPrototype.jar
 * Qualified Name:     Methods.UserLogger
 * JD-Core Version:    0.7.0.1
 */