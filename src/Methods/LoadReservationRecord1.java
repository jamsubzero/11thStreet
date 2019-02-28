package Methods;

import Fields.DBUrl;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.joda.time.DateTime;
import org.joda.time.Days;

public class LoadReservationRecord1
{
  public int LoadResRecord(JTable table, DefaultTableModel model, String SQL)
  {
    int r = 0;
    try
    {
      Class.forName("com.mysql.jdbc.Driver");
      String connectionUrl = DBUrl.dbcon;
      Connection con = DriverManager.getConnection(connectionUrl);
      PreparedStatement stmt = null;
      ResultSet rs = null;
      
      stmt = con.prepareStatement(SQL);
      rs = stmt.executeQuery();
      
      table.setModel(model);
      while (rs.next())
      {
        model.addRow(new Object[0]);
        model.setValueAt(rs.getString("resID"), r, 0);
        model.setValueAt(rs.getString("roomID"), r, 1);
        model.setValueAt(rs.getString("guestID"), r, 2);
        String inDate = rs.getString("inDate");
        inDate = inDate.substring(0, inDate.length() - 5);
        String outDate = rs.getString("outDate");
        outDate = outDate.substring(0, outDate.length() - 5);
        model.setValueAt(inDate, r, 3);
        model.setValueAt(outDate, r, 4);
        int diff = rs.getInt("diff");
        System.out.println(diff);
        if (diff <= 0) {
          model.setValueAt("***Due***", r, 5);
        } else {
          model.setValueAt(rs.getString("rem"), r, 5);
        }
        r++;
      }
    }
    catch (SQLException e)
    {
      System.out.println("SQL Exception: " + e.toString());
    }
    catch (ClassNotFoundException cE)
    {
      System.out.println("Class Not Found Exception: " + cE.toString());
    }
    return r;
  }
  
  private int calcDateDiff(Date end, Date start)
  {
    int res = -1;
    DateTime startDate = new DateTime(start);
    DateTime endDate = new DateTime(end);
    Days d = Days.daysBetween(startDate, endDate);
    System.out.println(startDate + "-" + endDate + "=" + d.getDays());
    res = d.getDays();
    return res;
  }
}


/* Location:           D:\New folder\New folder\dist\11thPrototype.jar
 * Qualified Name:     Methods.LoadReservationRecord1
 * JD-Core Version:    0.7.0.1
 */