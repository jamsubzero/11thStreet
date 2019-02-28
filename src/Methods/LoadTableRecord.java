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

public class LoadTableRecord
{
  public int LoadTableRecord(JTable table, DefaultTableModel model, String SQL)
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
        for (int c = 0; c < model.getColumnCount(); c++) {
          model.setValueAt(rs.getString(c + 1), r, c);
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
}


/* Location:           D:\New folder\New folder\dist\11thPrototype.jar
 * Qualified Name:     Methods.LoadTableRecord
 * JD-Core Version:    0.7.0.1
 */