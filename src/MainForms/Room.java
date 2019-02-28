package MainForms;

import Fields.DBUrl;
import Fields.Extras;
import Fields.TableModels;
import Methods.LoadTableRecord;
import Methods.UserLogger;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

public class Room
  extends JPanel
{
  private JLabel Status;
  private JFormattedTextField extra;
  private JTextField filRem;
  private JTextField filRoom;
  private JComboBox filType;
  private JComboBox filVent;
  private JButton jButton1;
  private JButton jButton3;
  private JButton jButton5;
  private JButton jButton6;
  private JLabel jLabel1;
  private JLabel jLabel2;
  private JLabel jLabel3;
  private JLabel jLabel4;
  private JLabel jLabel55;
  private JLabel jLabel56;
  private JLabel jLabel57;
  private JLabel jLabel6;
  private JLabel jLabel7;
  private JLabel jLabel8;
  private JLabel jLabel9;
  private JPanel jPanel1;
  private JPanel jPanel2;
  private JPanel jPanel3;
  private JPanel jPanel4;
  private JPanel jPanel5;
  private JScrollPane jScrollPane1;
  private JSeparator jSeparator1;
  private JSeparator jSeparator2;
  private JDialog newRoom;
  private JLabel noOfRooms;
  private JFormattedTextField price;
  private JTextField rem;
  private JTextField roomID;
  private JTable roomTable;
  private JComboBox stat;
  private JComboBox type;
  private JComboBox vent;
  
  public Room()
  {
    initComponents();
    loadRoom();
  }
  
  private void initComponents()
  {
    this.newRoom = new JDialog();
    this.jPanel3 = new JPanel();
    this.jPanel4 = new JPanel();
    this.jLabel3 = new JLabel();
    this.jLabel6 = new JLabel();
    this.type = new JComboBox();
    this.vent = new JComboBox();
    this.jLabel2 = new JLabel();
    this.roomID = new JTextField();
    this.jPanel5 = new JPanel();
    this.jLabel7 = new JLabel();
    this.jLabel8 = new JLabel();
    this.price = new JFormattedTextField();
    this.extra = new JFormattedTextField();
    this.jLabel9 = new JLabel();
    this.rem = new JTextField();
    this.jSeparator2 = new JSeparator();
    this.jButton5 = new JButton();
    this.jButton6 = new JButton();
    this.Status = new JLabel();
    this.stat = new JComboBox();
    this.jPanel1 = new JPanel();
    this.jLabel1 = new JLabel();
    this.filRoom = new JTextField();
    this.jLabel55 = new JLabel();
    this.filType = new JComboBox();
    this.jLabel56 = new JLabel();
    this.filVent = new JComboBox();
    this.jLabel57 = new JLabel();
    this.filRem = new JTextField();
    this.jScrollPane1 = new JScrollPane();
    this.roomTable = new JTable();
    this.jPanel2 = new JPanel();
    this.jLabel4 = new JLabel();
    this.noOfRooms = new JLabel();
    this.jButton1 = new JButton();
    this.jSeparator1 = new JSeparator();
    this.jButton3 = new JButton();
    
    this.newRoom.setTitle("Add New Guest");
    this.newRoom.setMinimumSize(new Dimension(322, 514));
    
    this.jPanel3.setBackground(new Color(51, 0, 153));
    
    this.jPanel4.setBackground(new Color(51, 0, 153));
    this.jPanel4.setBorder(BorderFactory.createTitledBorder(null, "Room Type", 0, 0, null, Color.white));
    
    this.jLabel3.setForeground(new Color(255, 255, 255));
    this.jLabel3.setText("Type");
    
    this.jLabel6.setForeground(new Color(255, 255, 255));
    this.jLabel6.setText("Ventilation");
    
    this.type.setModel(new DefaultComboBoxModel(new String[] { "Single", "Double", "Family" }));
    
    this.vent.setModel(new DefaultComboBoxModel(new String[] { "Air Conditioned", "Electric Fan" }));
    
    GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
    this.jPanel4.setLayout(jPanel4Layout);
    jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel6).addComponent(this.jLabel3)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.type, 0, -1, 32767).addComponent(this.vent, 0, -1, 32767)).addContainerGap()));
    











    jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.type, -2, 34, -2).addComponent(this.jLabel3, -2, 29, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jLabel6, -1, -1, 32767).addComponent(this.vent)).addContainerGap()));
    











    jPanel4Layout.linkSize(1, new Component[] { this.type, this.vent });
    
    this.jLabel2.setForeground(new Color(255, 255, 255));
    this.jLabel2.setText("Room ID");
    
    this.jPanel5.setBackground(new Color(51, 0, 153));
    this.jPanel5.setBorder(BorderFactory.createTitledBorder(null, "Room Rate", 0, 0, null, Color.white));
    
    this.jLabel7.setForeground(new Color(255, 255, 255));
    this.jLabel7.setText("Price/Night");
    
    this.jLabel8.setForeground(new Color(255, 255, 255));
    this.jLabel8.setText("Extra");
    
    this.price.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));
    this.price.setText("0");
    
    this.extra.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));
    this.extra.setText("0");
    
    GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
    this.jPanel5.setLayout(jPanel5Layout);
    jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addContainerGap().addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel7).addComponent(this.jLabel8)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.price).addComponent(this.extra, GroupLayout.Alignment.TRAILING)).addContainerGap()));
    











    jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addContainerGap().addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.price, -2, 34, -2).addComponent(this.jLabel7, -2, 29, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.extra, -2, 29, -2).addComponent(this.jLabel8, -2, 29, -2)).addContainerGap()));
    












    jPanel5Layout.linkSize(1, new Component[] { this.extra, this.price });
    
    this.jLabel9.setForeground(new Color(255, 255, 255));
    this.jLabel9.setText("Remarks");
    
    this.jButton5.setText("Save");
    this.jButton5.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Room.this.jButton5ActionPerformed(evt);
      }
    });
    this.jButton6.setText("Cancel");
    this.jButton6.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Room.this.jButton6ActionPerformed(evt);
      }
    });
    this.Status.setForeground(new Color(255, 255, 255));
    this.Status.setText("Status");
    
    this.stat.setModel(new DefaultComboBoxModel(new String[] { "Available", "Unavailable" }));
    this.stat.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Room.this.statActionPerformed(evt);
      }
    });
    GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
    this.jPanel3.setLayout(jPanel3Layout);
    jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.jLabel2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.roomID)).addComponent(this.jSeparator2).addComponent(this.jPanel4, -1, -1, 32767).addComponent(this.jPanel5, -1, -1, 32767).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.jButton5, -2, 106, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 48, 32767).addComponent(this.jButton6, -2, 106, -2)).addGroup(jPanel3Layout.createSequentialGroup().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel9).addComponent(this.Status)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.stat, 0, -1, 32767).addComponent(this.rem)))).addContainerGap()));
    
























    jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.roomID, -1, 32, 32767).addComponent(this.jLabel2, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel4, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel5, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.rem).addComponent(this.jLabel9, -2, 32, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.Status, -2, 32, -2).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.stat, -2, 32, -2).addGap(1, 1, 1))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jSeparator2, -2, 10, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jButton5, -2, 33, -2).addComponent(this.jButton6, -2, 33, -2)).addContainerGap(18, 32767)));
    




























    GroupLayout newRoomLayout = new GroupLayout(this.newRoom.getContentPane());
    this.newRoom.getContentPane().setLayout(newRoomLayout);
    newRoomLayout.setHorizontalGroup(newRoomLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(newRoomLayout.createSequentialGroup().addContainerGap().addComponent(this.jPanel3, -1, -1, 32767).addContainerGap()));
    





    newRoomLayout.setVerticalGroup(newRoomLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(newRoomLayout.createSequentialGroup().addContainerGap().addComponent(this.jPanel3, -1, -1, 32767).addContainerGap()));
    






    this.jPanel1.setBorder(BorderFactory.createTitledBorder("Filter by"));
    
    this.jLabel1.setText("RoomID");
    
    this.filRoom.addKeyListener(new KeyAdapter()
    {
      public void keyPressed(KeyEvent evt)
      {
        Room.this.filRoomKeyPressed(evt);
      }
      
      public void keyTyped(KeyEvent evt)
      {
        Room.this.filRoomKeyTyped(evt);
      }
    });
    this.jLabel55.setText("Type");
    
    this.filType.setModel(new DefaultComboBoxModel(new String[] { "Select", "Single", "Double", "Family" }));
    this.filType.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Room.this.filTypeActionPerformed(evt);
      }
    });
    this.jLabel56.setText("Ventilation");
    
    this.filVent.setModel(new DefaultComboBoxModel(new String[] { "Select", "Air Conditioned", "Electric Fan" }));
    this.filVent.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Room.this.filVentActionPerformed(evt);
      }
    });
    this.jLabel57.setText("Remarks");
    
    this.filRem.addKeyListener(new KeyAdapter()
    {
      public void keyPressed(KeyEvent evt)
      {
        Room.this.filRemKeyPressed(evt);
      }
      
      public void keyTyped(KeyEvent evt)
      {
        Room.this.filRemKeyTyped(evt);
      }
    });
    GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
    this.jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.filRoom, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel55).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.filType, -2, 104, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel56).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.filVent, -2, 117, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel57).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.filRem, -2, 151, -2).addContainerGap(-1, 32767)));
    



















    jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addGap(8, 8, 8).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel56, -1, -1, 32767).addComponent(this.filType, GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.filVent).addComponent(this.jLabel57).addComponent(this.filRem, -2, -1, -2)).addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel1).addComponent(this.filRoom, -2, -1, -2)).addGap(0, 0, 32767)).addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup().addGap(3, 3, 3).addComponent(this.jLabel55, -1, -1, 32767))).addContainerGap()));
    




















    this.roomTable.setFont(new Font("Tahoma", 0, 18));
    this.roomTable.setModel(new DefaultTableModel(new Object[0][], new String[] { "Room Name", "Type", "Ventilation", "Price", "Extra", "Remarks", "Status" })
    {
      boolean[] canEdit = { false, false, false, false, false, true, false };
      
      public boolean isCellEditable(int rowIndex, int columnIndex)
      {
        return this.canEdit[columnIndex];
      }
    });
    this.roomTable.setRowHeight(27);
    this.roomTable.getTableHeader().setReorderingAllowed(false);
    this.jScrollPane1.setViewportView(this.roomTable);
    
    this.jPanel2.setBorder(BorderFactory.createTitledBorder("Statistics"));
    
    this.jLabel4.setText("Number of Records:");
    
    this.noOfRooms.setForeground(new Color(255, 102, 102));
    this.noOfRooms.setText("0");
    
    GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
    this.jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel4, -2, 117, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.noOfRooms, -2, 124, -2).addContainerGap(623, 32767)));
    







    jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.noOfRooms).addGap(0, 0, 32767)).addComponent(this.jLabel4, -1, -1, 32767)).addContainerGap()));
    










    this.jButton1.setText("Add New");
    this.jButton1.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Room.this.jButton1ActionPerformed(evt);
      }
    });
    this.jButton3.setText("Remove");
    this.jButton3.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Room.this.jButton3ActionPerformed(evt);
      }
    });
    GroupLayout layout = new GroupLayout(this);
    setLayout(layout);
    layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jSeparator1).addComponent(this.jPanel1, -1, -1, 32767).addComponent(this.jScrollPane1, GroupLayout.Alignment.TRAILING, -1, 892, 32767).addComponent(this.jPanel2, -1, -1, 32767).addGroup(layout.createSequentialGroup().addComponent(this.jButton1, -2, 143, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton3, -2, 117, -2).addGap(0, 0, 32767))).addContainerGap()));
    















    layout.linkSize(0, new Component[] { this.jButton1, this.jButton3 });
    
    layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(6, 6, 6).addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -1, 334, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jPanel2, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jSeparator1, -2, 5, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jButton1, -2, 38, -2).addComponent(this.jButton3, -2, 38, -2)).addContainerGap()));
    
















    layout.linkSize(1, new Component[] { this.jButton1, this.jButton3 });
  }
  
  private void jButton6ActionPerformed(ActionEvent evt)
  {
    System.out.println(this.newRoom.getSize());
    this.newRoom.setVisible(false);
  }
  
  private void jButton1ActionPerformed(ActionEvent evt)
  {
    this.newRoom.setVisible(true);
  }
  
  private void jButton5ActionPerformed(ActionEvent evt)
  {
    String sRoomID = this.roomID.getText();
    String sType = this.type.getSelectedItem().toString();
    String sVent = this.vent.getSelectedItem().toString();
    float fPrice = 0.0F;
    float fExtra = 0.0F;
    try
    {
      fPrice = Float.parseFloat(this.price.getText());
      fExtra = Float.parseFloat(this.extra.getText());
    }
    catch (NumberFormatException e)
    {
      fPrice = 0.0F;
      fExtra = 0.0F;
    }
    String sRem = this.rem.getText();
    String sStat = this.stat.getSelectedItem().toString();
    if ((sRoomID.isEmpty()) || (fExtra <= 0.0F) || (fPrice <= 0.0F) || (sRem.isEmpty())) {
      JOptionPane.showMessageDialog(this.newRoom, "Please Fill up all feilds", "Input Error", 0);
    } else {
      try
      {
        Class.forName("com.mysql.jdbc.Driver");
        String connectionUrl = DBUrl.dbcon;
        Connection con = DriverManager.getConnection(connectionUrl);
        PreparedStatement stmt = null;
        
        stmt = con.prepareStatement("INSERT INTO `reservation`.`rooms` (`roomID`, `type`, `vent`, `price`, `extra`, `remarks`, `status`) VALUES (?, ?, ?, ?, ?, ?, ?);");
        
        stmt.setString(1, sRoomID);
        stmt.setString(2, sType);
        stmt.setString(3, sVent);
        stmt.setFloat(4, fPrice);
        stmt.setFloat(5, fExtra);
        stmt.setString(6, sRem);
        stmt.setString(7, sStat);
        int res = stmt.executeUpdate();
        if (res != 0)
        {
          JOptionPane.showMessageDialog(this.newRoom, "Data Successfully Saved");
          new UserLogger().insertLog(Extras.loggeduser, 3, "Added new room " + sRoomID);
          
          this.newRoom.setVisible(false);
          loadRoom();
        }
      }
      catch (MySQLIntegrityConstraintViolationException ec)
      {
        JOptionPane.showMessageDialog(this.newRoom, "Guest ID already exists", "Duplicate Entry", 0);
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
  
  private void statActionPerformed(ActionEvent evt) {}
  
  private void jButton3ActionPerformed(ActionEvent evt)
  {
    int selr = this.roomTable.getSelectedRow();
    if (selr != -1)
    {
      String selGuest = this.roomTable.getValueAt(selr, 0).toString();
      if (JOptionPane.showConfirmDialog(this.roomTable, "Sure to remove this room?\nWarning: This cannot be undone", "Removal Confirmation", 0) == 0) {
        try
        {
          Class.forName("com.mysql.jdbc.Driver");
          String connectionUrl = DBUrl.dbcon;
          Connection con = DriverManager.getConnection(connectionUrl);
          Statement stmt = con.createStatement();
          
          int res = stmt.executeUpdate("DELETE FROM `reservation`.`rooms` WHERE  `roomID`='" + selGuest + "';");
          if (res != 0)
          {
            JOptionPane.showMessageDialog(this.roomTable, "Data Successfully Saved");
            new UserLogger().insertLog(Extras.loggeduser, 3, "Removed room " + selGuest);
            loadRoom();
          }
          else
          {
            JOptionPane.showMessageDialog(this.roomTable, "There are records currently associated with this room.", "Removal Error", 0);
          }
        }
        catch (MySQLIntegrityConstraintViolationException ex)
        {
          JOptionPane.showMessageDialog(this.roomTable, "There are current records associated with this room.", "Removal Error", 0);
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
    else
    {
      JOptionPane.showMessageDialog(this.roomTable, "No selected room.", "Selection Error", 0);
    }
  }
  
  private void filRoomKeyPressed(KeyEvent evt)
  {
    filterCurrent();
  }
  
  private void filRoomKeyTyped(KeyEvent evt)
  {
    filterCurrent();
  }
  
  private void filTypeActionPerformed(ActionEvent evt)
  {
    filterCurrent();
  }
  
  private void filVentActionPerformed(ActionEvent evt)
  {
    filterCurrent();
  }
  
  private void filRemKeyPressed(KeyEvent evt)
  {
    filterCurrent();
  }
  
  private void filRemKeyTyped(KeyEvent evt)
  {
    filterCurrent();
  }
  
  void loadRoom()
  {
    int availQuan = new LoadTableRecord().LoadTableRecord(this.roomTable, new TableModels().roomModel, "SELECT * FROM `rooms` ORDER BY `roomID`");
    this.noOfRooms.setText(availQuan + "");
  }
  
  private void filterCurrent()
  {
    String sRoom = this.filRoom.getText();
    String sRem = this.filRem.getText();
    String qType = "";
    if (this.filType.getSelectedIndex() != 0) {
      qType = " AND rooms.`type` = '" + this.filType.getSelectedItem().toString() + "' ";
    }
    String qVent = "";
    if (this.filVent.getSelectedIndex() != 0) {
      qVent = " AND rooms.`vent` = '" + this.filVent.getSelectedItem().toString() + "' ";
    }
    String fil = "WHERE rooms.roomID LIKE '%" + sRoom + "%'\n" + qType + qVent + " AND rooms.`remarks` LIKE '%" + sRem + "%' ";
    

    int availQuan = new LoadTableRecord().LoadTableRecord(this.roomTable, new TableModels().roomModel, "SELECT * FROM `rooms` " + fil + " ORDER BY `roomID`");
    

    this.noOfRooms.setText(availQuan + "");
  }
}



/* Location:           D:\New folder\New folder\dist\11thPrototype.jar

 * Qualified Name:     MainForms.Room

 * JD-Core Version:    0.7.0.1

 */