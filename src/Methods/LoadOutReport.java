package Methods;

import Fields.DBUrl;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class LoadOutReport
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
      float totalRoom = 0.0F;
      float totalSales = 0.0F;
      float totalPrice = 0.0F;
      float totalBal = 0.0F;
      while (rs.next())
      {
        model.addRow(new Object[0]);
        model.setValueAt(rs.getString("guest"), r, 0);
        model.setValueAt(rs.getString("room"), r, 1);
        model.setValueAt(rs.getString("disc"), r, 2);
        totalRoom += rs.getFloat("roomPrice");
        model.setValueAt(Float.valueOf(rs.getFloat("roomPrice")), r, 3);
        
        totalSales += rs.getFloat("sales");
        model.setValueAt(Float.valueOf(rs.getFloat("sales")), r, 4);
        
        model.setValueAt(Float.valueOf(rs.getFloat("extra")), r, 5);
        
        totalPrice += rs.getFloat("price");
        model.setValueAt(Float.valueOf(rs.getFloat("price")), r, 6);
        
        totalBal += rs.getFloat("bal");
        model.setValueAt(Float.valueOf(rs.getFloat("bal")), r, 7);
        
        String inDate = rs.getString("dateIn");
        inDate = inDate.substring(0, inDate.length() - 5);
        String outDate = rs.getString("dateOut");
        outDate = outDate.substring(0, outDate.length() - 5);
        model.setValueAt(inDate, r, 8);
        model.setValueAt(outDate, r, 9);
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
}


/* Location:           D:\New folder\New folder\dist\11thPrototype.jar
 * Qualified Name:     Methods.LoadOutReport
 * JD-Core Version:    0.7.0.1
 */