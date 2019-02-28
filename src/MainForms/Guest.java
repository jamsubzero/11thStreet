package MainForms;

import Fields.DBUrl;
import Fields.Extras;
import Fields.TableModels;
import Methods.LoadPayment;
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
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
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

public class Guest
  extends JPanel
{
  public Guest()
  {
    initComponents();
    loadguest();
  }
  
  DecimalFormat decForm = new DecimalFormat("#0.00");
  private JTextField add;
  private JDialog balances;
  private JTable balancesTable;
  private JTextField cont;
  private JTextField filGuest;
  private JTextField fname;
  private JTextField guestID;
  private JTable guestTable;
  private JButton jButton1;
  private JButton jButton2;
  private JButton jButton3;
  private JButton jButton4;
  private JButton jButton5;
  private JButton jButton6;
  private JLabel jLabel1;
  private JLabel jLabel2;
  private JLabel jLabel28;
  private JLabel jLabel3;
  private JLabel jLabel4;
  private JLabel jLabel6;
  private JLabel jLabel7;
  private JLabel jLabel8;
  private JLabel jLabel9;
  private JPanel jPanel1;
  private JPanel jPanel17;
  private JPanel jPanel2;
  private JPanel jPanel3;
  private JPanel jPanel4;
  private JPanel jPanel5;
  private JPanel jPanel6;
  private JScrollPane jScrollPane1;
  private JScrollPane jScrollPane2;
  private JSeparator jSeparator1;
  private JSeparator jSeparator2;
  private JTextField lname;
  private JDialog newGuest;
  private JLabel noOfGuest;
  private JTextField rem;
  private JLabel viewTotal;
  
  private void initComponents()
  {
    this.newGuest = new JDialog();
    this.jPanel3 = new JPanel();
    this.jPanel4 = new JPanel();
    this.jLabel3 = new JLabel();
    this.fname = new JTextField();
    this.lname = new JTextField();
    this.jLabel6 = new JLabel();
    this.jLabel2 = new JLabel();
    this.guestID = new JTextField();
    this.jPanel5 = new JPanel();
    this.jLabel7 = new JLabel();
    this.cont = new JTextField();
    this.add = new JTextField();
    this.jLabel8 = new JLabel();
    this.jLabel9 = new JLabel();
    this.rem = new JTextField();
    this.jSeparator2 = new JSeparator();
    this.jButton5 = new JButton();
    this.jButton6 = new JButton();
    this.balances = new JDialog();
    this.jPanel6 = new JPanel();
    this.jPanel17 = new JPanel();
    this.jLabel28 = new JLabel();
    this.viewTotal = new JLabel();
    this.jScrollPane2 = new JScrollPane();
    this.balancesTable = new JTable();
    this.jButton4 = new JButton();
    this.jPanel1 = new JPanel();
    this.jLabel1 = new JLabel();
    this.filGuest = new JTextField();
    this.jScrollPane1 = new JScrollPane();
    this.guestTable = new JTable();
    this.jPanel2 = new JPanel();
    this.jLabel4 = new JLabel();
    this.noOfGuest = new JLabel();
    this.jButton1 = new JButton();
    this.jSeparator1 = new JSeparator();
    this.jButton3 = new JButton();
    this.jButton2 = new JButton();
    
    this.newGuest.setTitle("Add New Guest");
    this.newGuest.setMinimumSize(new Dimension(335, 487));
    
    this.jPanel3.setBackground(new Color(51, 0, 153));
    
    this.jPanel4.setBackground(new Color(51, 0, 153));
    this.jPanel4.setBorder(BorderFactory.createTitledBorder(null, "Personal Information", 0, 0, null, Color.white));
    
    this.jLabel3.setForeground(new Color(255, 255, 255));
    this.jLabel3.setText("First Name");
    
    this.jLabel6.setForeground(new Color(255, 255, 255));
    this.jLabel6.setText("Last Name");
    
    GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
    this.jPanel4.setLayout(jPanel4Layout);
    jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addComponent(this.jLabel3).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.fname)).addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup().addComponent(this.jLabel6).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.lname))).addContainerGap()));
    













    jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel3, -2, 29, -2).addComponent(this.fname, -1, 32, 32767)).addGap(18, 18, 18).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel6, -2, 29, -2).addComponent(this.lname, -1, 32, 32767)).addContainerGap()));
    












    this.jLabel2.setForeground(new Color(255, 255, 255));
    this.jLabel2.setText("GuestID");
    
    this.jPanel5.setBackground(new Color(51, 0, 153));
    this.jPanel5.setBorder(BorderFactory.createTitledBorder(null, "Contact/Address", 0, 0, null, Color.white));
    
    this.jLabel7.setForeground(new Color(255, 255, 255));
    this.jLabel7.setText("Contact #");
    
    this.jLabel8.setForeground(new Color(255, 255, 255));
    this.jLabel8.setText("Address");
    
    GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
    this.jPanel5.setLayout(jPanel5Layout);
    jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addContainerGap().addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel7).addComponent(this.jLabel8)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.add).addComponent(this.cont)).addContainerGap()));
    











    jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addContainerGap().addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel7, -2, 29, -2).addComponent(this.cont, -1, 32, 32767)).addGap(18, 18, 18).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel8, -2, 29, -2).addComponent(this.add, -1, 32, 32767)).addContainerGap()));
    












    this.jLabel9.setForeground(new Color(255, 255, 255));
    this.jLabel9.setText("Remarks");
    
    this.jButton5.setText("Save");
    this.jButton5.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Guest.this.jButton5ActionPerformed(evt);
      }
    });
    this.jButton6.setText("Cancel");
    this.jButton6.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Guest.this.jButton6ActionPerformed(evt);
      }
    });
    GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
    this.jPanel3.setLayout(jPanel3Layout);
    jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jSeparator2).addComponent(this.jPanel4, -1, -1, 32767).addComponent(this.jPanel5, -1, -1, 32767).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.jButton5, -2, 106, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.jButton6, -2, 106, -2)).addGroup(jPanel3Layout.createSequentialGroup().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.jLabel2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.guestID, -2, 228, -2)).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.jLabel9).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.rem, -2, 228, -2))).addGap(0, 0, 32767))).addContainerGap()));
    























    jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.guestID, -1, 32, 32767).addComponent(this.jLabel2, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel4, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel5, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.rem).addComponent(this.jLabel9, -2, 32, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jSeparator2, -2, 10, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jButton5, -2, 33, -2).addComponent(this.jButton6, -2, 33, -2)).addContainerGap(-1, 32767)));
    






















    GroupLayout newGuestLayout = new GroupLayout(this.newGuest.getContentPane());
    this.newGuest.getContentPane().setLayout(newGuestLayout);
    newGuestLayout.setHorizontalGroup(newGuestLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(newGuestLayout.createSequentialGroup().addContainerGap().addComponent(this.jPanel3, -1, -1, 32767).addContainerGap()));
    





    newGuestLayout.setVerticalGroup(newGuestLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(newGuestLayout.createSequentialGroup().addContainerGap().addComponent(this.jPanel3, -1, -1, 32767).addContainerGap()));
    






    this.balances.setTitle("Account Balances");
    this.balances.setMinimumSize(new Dimension(399, 462));
    
    this.jPanel6.setBackground(new Color(51, 0, 153));
    
    this.jPanel17.setBackground(new Color(51, 0, 153));
    this.jPanel17.setBorder(BorderFactory.createTitledBorder(null, "Statistics", 0, 0, null, Color.white));
    
    this.jLabel28.setForeground(new Color(255, 255, 255));
    this.jLabel28.setText("Total:");
    
    this.viewTotal.setForeground(new Color(255, 102, 102));
    this.viewTotal.setText("0");
    
    GroupLayout jPanel17Layout = new GroupLayout(this.jPanel17);
    this.jPanel17.setLayout(jPanel17Layout);
    jPanel17Layout.setHorizontalGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel17Layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel28).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.viewTotal, -2, 169, -2).addContainerGap(-1, 32767)));
    







    jPanel17Layout.setVerticalGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup().addContainerGap().addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel28, -1, 23, 32767).addComponent(this.viewTotal, -1, -1, 32767)).addContainerGap()));
    








    this.balancesTable.setFont(new Font("Tahoma", 0, 16));
    this.balancesTable.setModel(new DefaultTableModel(new Object[0][], new String[] { "Amount", "Date", "Room" })
    {
      boolean[] canEdit = { false, false, false };
      
      public boolean isCellEditable(int rowIndex, int columnIndex)
      {
        return this.canEdit[columnIndex];
      }
    });
    this.balancesTable.setRowHeight(27);
    this.balancesTable.getTableHeader().setReorderingAllowed(false);
    this.jScrollPane2.setViewportView(this.balancesTable);
    
    this.jButton4.setText("Close");
    this.jButton4.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Guest.this.jButton4ActionPerformed(evt);
      }
    });
    GroupLayout jPanel6Layout = new GroupLayout(this.jPanel6);
    this.jPanel6.setLayout(jPanel6Layout);
    jPanel6Layout.setHorizontalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addContainerGap().addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane2, -1, 327, 32767).addComponent(this.jPanel17, -1, -1, 32767).addGroup(GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 121, -2).addComponent(this.jButton4, -2, 110, -2).addGap(116, 116, 116))).addContainerGap()));
    











    jPanel6Layout.setVerticalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane2, -2, 283, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel17, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton4).addContainerGap()));
    










    GroupLayout balancesLayout = new GroupLayout(this.balances.getContentPane());
    this.balances.getContentPane().setLayout(balancesLayout);
    balancesLayout.setHorizontalGroup(balancesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(balancesLayout.createSequentialGroup().addContainerGap().addComponent(this.jPanel6, -1, -1, 32767).addContainerGap()));
    





    balancesLayout.setVerticalGroup(balancesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(balancesLayout.createSequentialGroup().addContainerGap().addComponent(this.jPanel6, -2, -1, -2).addContainerGap(-1, 32767)));
    






    this.jPanel1.setBorder(BorderFactory.createTitledBorder("Filter by"));
    
    this.jLabel1.setText("Guest Name");
    
    this.filGuest.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Guest.this.filGuestActionPerformed(evt);
      }
    });
    this.filGuest.addKeyListener(new KeyAdapter()
    {
      public void keyPressed(KeyEvent evt)
      {
        Guest.this.filGuestKeyPressed(evt);
      }
      
      public void keyTyped(KeyEvent evt)
      {
        Guest.this.filGuestKeyTyped(evt);
      }
    });
    GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
    this.jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.filGuest, -2, 148, -2).addContainerGap(-1, 32767)));
    







    jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel1).addComponent(this.filGuest, -2, -1, -2)).addContainerGap(-1, 32767)));
    








    this.guestTable.setFont(new Font("Tahoma", 0, 18));
    this.guestTable.setModel(new DefaultTableModel(new Object[0][], new String[] { "Guest ID", "Guest Name", "Address", "Contact #", "Remarks" })
    {
      boolean[] canEdit = { false, false, false, false, false };
      
      public boolean isCellEditable(int rowIndex, int columnIndex)
      {
        return this.canEdit[columnIndex];
      }
    });
    this.guestTable.setRowHeight(27);
    this.guestTable.getTableHeader().setReorderingAllowed(false);
    this.jScrollPane1.setViewportView(this.guestTable);
    
    this.jPanel2.setBorder(BorderFactory.createTitledBorder("Statistics"));
    
    this.jLabel4.setText("Number of Records:");
    
    this.noOfGuest.setForeground(new Color(255, 102, 102));
    this.noOfGuest.setText("0");
    
    GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
    this.jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel4).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.noOfGuest, -2, 124, -2).addContainerGap(-1, 32767)));
    







    jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel4, -1, -1, 32767).addComponent(this.noOfGuest)).addContainerGap()));
    








    this.jButton1.setText("Add New");
    this.jButton1.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Guest.this.jButton1ActionPerformed(evt);
      }
    });
    this.jButton3.setText("Remove");
    this.jButton3.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Guest.this.jButton3ActionPerformed(evt);
      }
    });
    this.jButton2.setText("View Check Out Balances");
    this.jButton2.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Guest.this.jButton2ActionPerformed(evt);
      }
    });
    GroupLayout layout = new GroupLayout(this);
    setLayout(layout);
    layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jSeparator1).addComponent(this.jPanel1, -1, -1, 32767).addComponent(this.jScrollPane1, GroupLayout.Alignment.TRAILING, -1, 892, 32767).addComponent(this.jPanel2, -1, -1, 32767).addGroup(layout.createSequentialGroup().addComponent(this.jButton1, -2, 143, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton2, -2, 165, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.jButton3, -2, 117, -2))).addContainerGap()));
    
















    layout.linkSize(0, new Component[] { this.jButton1, this.jButton3 });
    
    layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(6, 6, 6).addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -1, 333, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel2, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jSeparator1, -2, 5, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jButton1, GroupLayout.Alignment.TRAILING, -1, 38, 32767).addComponent(this.jButton3, GroupLayout.Alignment.TRAILING, -1, 38, 32767).addComponent(this.jButton2, GroupLayout.Alignment.TRAILING, -1, -1, 32767)).addContainerGap()));
    

















    layout.linkSize(1, new Component[] { this.jButton1, this.jButton3 });
  }
  
  private void jButton6ActionPerformed(ActionEvent evt)
  {
    System.out.println(this.newGuest.getSize());
    this.newGuest.setVisible(false);
  }
  
  private void jButton1ActionPerformed(ActionEvent evt)
  {
    this.newGuest.setVisible(true);
  }
  
  private void jButton5ActionPerformed(ActionEvent evt)
  {
    String sGuestID = this.guestID.getText();
    String sFname = this.fname.getText();
    String sLname = this.lname.getText();
    String sAdd = this.add.getText();
    String sCont = this.cont.getText();
    String sRem = this.rem.getText();
    if ((sGuestID.isEmpty()) || (sFname.isEmpty()) || (sLname.isEmpty()) || (sCont.isEmpty()) || (sAdd.isEmpty()) || (sRem.isEmpty())) {
      JOptionPane.showMessageDialog(this.newGuest, "Please Fill up all feilds", "Input Error", 0);
    } else {
      try
      {
        Class.forName("com.mysql.jdbc.Driver");
        String connectionUrl = DBUrl.dbcon;
        Connection con = DriverManager.getConnection(connectionUrl);
        PreparedStatement stmt = null;
        
        stmt = con.prepareStatement("INSERT INTO `reservation`.`guest` (`guestID`, `fname`, `lname`, `address`, `cont`, `rem`) VALUES (?, ?, ?, ?, ?, ?);");
        
        stmt.setString(1, sGuestID);
        stmt.setString(2, sFname);
        stmt.setString(3, sLname);
        stmt.setString(4, sAdd);
        stmt.setString(5, sCont);
        stmt.setString(6, sRem);
        

        int res = stmt.executeUpdate();
        if (res != 0)
        {
          JOptionPane.showMessageDialog(this.newGuest, "Data Successfully Saved");
          new UserLogger().insertLog(Extras.loggeduser, 2, "Added new guest " + sGuestID);
          
          this.newGuest.setVisible(false);
          loadguest();
        }
      }
      catch (MySQLIntegrityConstraintViolationException ec)
      {
        JOptionPane.showMessageDialog(this.newGuest, "Guest ID already exists", "Duplicate Entry", 0);
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
  
  private void jButton3ActionPerformed(ActionEvent evt)
  {
    int selr = this.guestTable.getSelectedRow();
    if (selr != -1)
    {
      String selGuest = this.guestTable.getValueAt(selr, 0).toString();
      if (JOptionPane.showConfirmDialog(this.guestTable, "Sure to remove this guest?\nWarning: This cannot be undone", "Removal Confirmation", 0) == 0) {
        try
        {
          Class.forName("com.mysql.jdbc.Driver");
          String connectionUrl = DBUrl.dbcon;
          Connection con = DriverManager.getConnection(connectionUrl);
          Statement stmt = con.createStatement();
          
          int res = stmt.executeUpdate("DELETE FROM `reservation`.`guest` WHERE  `guestID`='" + selGuest + "';");
          if (res != 0)
          {
            JOptionPane.showMessageDialog(this.guestTable, "Data Successfully Saved");
            
            new UserLogger().insertLog(Extras.loggeduser, 2, "Removed guest " + selGuest);
            loadguest();
          }
          else
          {
            JOptionPane.showMessageDialog(this.guestTable, "There are records currently associated with this guest.", "Removal Error", 0);
          }
        }
        catch (MySQLIntegrityConstraintViolationException ex)
        {
          JOptionPane.showMessageDialog(this.guestTable, "There are current records associated with this guest.", "Removal Error", 0);
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
      JOptionPane.showMessageDialog(this.guestTable, "No selected guest.", "Selection Error", 0);
    }
  }
  
  private void filGuestKeyPressed(KeyEvent evt)
  {
    filguest();
  }
  
  private void filGuestKeyTyped(KeyEvent evt)
  {
    filguest();
  }
  
  private void filGuestActionPerformed(ActionEvent evt)
  {
    filguest();
  }
  
  private void jButton4ActionPerformed(ActionEvent evt)
  {
    System.out.println(this.balances.getSize());
    this.balances.setVisible(false);
  }
  
  private void jButton2ActionPerformed(ActionEvent evt)
  {
    int sel = this.guestTable.getSelectedRow();
    if (sel != -1)
    {
      String selGuest = this.guestTable.getValueAt(sel, 0).toString();
      loadBalances(selGuest);
      this.balances.setVisible(true);
    }
    else
    {
      JOptionPane.showMessageDialog(this.guestTable, "Please select guest first", "No guest selected", 2);
    }
  }
  
  private void loadguest()
  {
    int availQuan = new LoadTableRecord().LoadTableRecord(this.guestTable, new TableModels().guestModel, "SELECT guestID, CONCAT(`fname`, ' ', `lname`) AS name, address, cont, rem  FROM `guest`");
    
    this.noOfGuest.setText(availQuan + "");
  }
  
  private void loadBalances(String selGuest)
  {
    float total = new LoadPayment().LoadPayment(this.balancesTable, new TableModels().balancesModel, "SELECT `bal`, `dateOut`, `room`  FROM `resrecords` WHERE `guest` = '" + selGuest + "' AND `bal`!=0", 0);
    
    this.viewTotal.setText(this.decForm.format(total));
  }
  
  private void filguest()
  {
    String sGuest = this.filGuest.getText();
    int availQuan = new LoadTableRecord().LoadTableRecord(this.guestTable, new TableModels().guestModel, "SELECT guestID, CONCAT(`fname`, ' ', `lname`) AS name, address, cont, rem  FROM `guest`WHERE guestID LIKE '%" + sGuest + "%' OR  fname LIKE '%" + sGuest + "%' OR lname LIKE '%" + sGuest + "%'");
    

    this.noOfGuest.setText(availQuan + "");
  }
}



/* Location:           D:\New folder\New folder\dist\11thPrototype.jar

 * Qualified Name:     MainForms.Guest

 * JD-Core Version:    0.7.0.1

 */