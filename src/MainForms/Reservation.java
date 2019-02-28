package MainForms;

import Fields.DBUrl;
import Fields.Extras;
import Fields.TableModels;
import Methods.LoadReservationRecord;
import Methods.UserLogger;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;
import org.jdesktop.swingx.JXDatePicker;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class Reservation
  extends JPanel
{
  public Reservation()
  {
    initComponents();
    loadRes();
  }
  
  public Reservation(int x)
  {
    initComponents();
  }
  
  SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
  DateTimeFormatter jodaDF = DateTimeFormat.forPattern("yyyy-MM-dd");
  boolean isAdd = true;
  String selID = "";
  private JTextField add;
  private JDialog addRes;
  private JTextField cont;
  private JTextField filGuest;
  private JTextField fname;
  private JTextField guestID;
  private JButton jButton1;
  private JButton jButton10;
  private JButton jButton11;
  private JButton jButton2;
  private JButton jButton3;
  private JButton jButton4;
  private JButton jButton5;
  private JButton jButton6;
  private JButton jButton8;
  private JButton jButton9;
  private JLabel jLabel1;
  private JLabel jLabel10;
  private JLabel jLabel12;
  private JLabel jLabel13;
  private JLabel jLabel16;
  private JLabel jLabel17;
  private JLabel jLabel18;
  private JLabel jLabel19;
  private JLabel jLabel2;
  private JLabel jLabel20;
  private JLabel jLabel21;
  private JLabel jLabel3;
  private JLabel jLabel4;
  private JLabel jLabel8;
  private JLabel jLabel9;
  private JPanel jPanel1;
  private JPanel jPanel2;
  private JPanel jPanel3;
  private JPanel jPanel5;
  private JPanel jPanel6;
  private JPanel jPanel7;
  private JScrollPane jScrollPane1;
  private JSeparator jSeparator1;
  private JSeparator jSeparator2;
  private JSeparator jSeparator5;
  private JTextField lname;
  private JDialog newGuest;
  private JLabel noOfRes;
  private JTextField rem;
  private JXDatePicker resDateIn;
  private JXDatePicker resDateOut;
  private JSpinner resDays;
  private JComboBox resGuest;
  private JComboBox resRoom;
  public static JTable resTable;
  private JFormattedTextField resTime;
  private JComboBox resType;
  private JComboBox resVent;
  private JLabel roomLabel;
  
  private void initComponents()
  {
    this.addRes = new JDialog();
    this.jPanel3 = new JPanel();
    this.jButton9 = new JButton();
    this.resDateOut = new JXDatePicker();
    this.resRoom = new JComboBox();
    this.jLabel12 = new JLabel();
    this.resVent = new JComboBox();
    this.jLabel2 = new JLabel();
    this.jLabel3 = new JLabel();
    this.jSeparator5 = new JSeparator();
    this.resDateIn = new JXDatePicker();
    this.roomLabel = new JLabel();
    this.jLabel8 = new JLabel();
    this.jButton8 = new JButton();
    this.resType = new JComboBox();
    this.jButton6 = new JButton();
    this.resGuest = new JComboBox();
    this.jLabel10 = new JLabel();
    this.resTime = new JFormattedTextField();
    this.jLabel13 = new JLabel();
    this.jLabel9 = new JLabel();
    this.resDays = new JSpinner();
    this.jButton5 = new JButton();
    this.newGuest = new JDialog();
    this.jPanel6 = new JPanel();
    this.jPanel7 = new JPanel();
    this.jLabel16 = new JLabel();
    this.fname = new JTextField();
    this.lname = new JTextField();
    this.jLabel17 = new JLabel();
    this.jLabel18 = new JLabel();
    this.guestID = new JTextField();
    this.jPanel5 = new JPanel();
    this.jLabel19 = new JLabel();
    this.cont = new JTextField();
    this.add = new JTextField();
    this.jLabel20 = new JLabel();
    this.jLabel21 = new JLabel();
    this.rem = new JTextField();
    this.jSeparator2 = new JSeparator();
    this.jButton10 = new JButton();
    this.jButton11 = new JButton();
    this.jPanel1 = new JPanel();
    this.jLabel1 = new JLabel();
    this.filGuest = new JTextField();
    this.jScrollPane1 = new JScrollPane();
    resTable = new JTable();
    this.jPanel2 = new JPanel();
    this.jLabel4 = new JLabel();
    this.noOfRes = new JLabel();
    this.jButton1 = new JButton();
    this.jSeparator1 = new JSeparator();
    this.jButton2 = new JButton();
    this.jButton3 = new JButton();
    this.jButton4 = new JButton();
    
    this.addRes.setTitle("Add New Reservation");
    this.addRes.setMinimumSize(new Dimension(386, 548));
    
    this.jPanel3.setBackground(new Color(51, 0, 153));
    this.jPanel3.setBorder(BorderFactory.createTitledBorder(null, "Reservation Info", 0, 0, null, Color.white));
    
    this.jButton9.setText("Close");
    this.jButton9.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Reservation.this.jButton9ActionPerformed(evt);
      }
    });
    this.resDateOut.setEditable(false);
    this.resDateOut.setEnabled(false);
    this.resDateOut.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Reservation.this.resDateOutActionPerformed(evt);
      }
    });
    this.resRoom.setModel(new DefaultComboBoxModel(new String[] { "Select" }));
    this.resRoom.setEnabled(false);
    
    this.jLabel12.setForeground(new Color(255, 255, 255));
    this.jLabel12.setText("Guest");
    
    this.resVent.setModel(new DefaultComboBoxModel(new String[] { "Select", "Air Conditioned", "Electric Fan" }));
    this.resVent.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Reservation.this.resVentActionPerformed(evt);
      }
    });
    this.jLabel2.setForeground(new Color(255, 255, 255));
    this.jLabel2.setText("Room Type");
    
    this.jLabel3.setForeground(new Color(255, 255, 255));
    this.jLabel3.setText("Ventilation");
    
    this.resDateIn.setDate(Calendar.getInstance().getTime());
    this.resDateIn.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Reservation.this.resDateInActionPerformed(evt);
      }
    });
    this.roomLabel.setForeground(new Color(255, 102, 102));
    this.roomLabel.setText("Room(0)");
    
    this.jLabel8.setForeground(new Color(255, 255, 255));
    this.jLabel8.setText("Date In");
    
    this.jButton8.setText("Reserve");
    this.jButton8.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Reservation.this.jButton8ActionPerformed(evt);
      }
    });
    this.resType.setModel(new DefaultComboBoxModel(new String[] { "Select", "Single", "Double", "Family" }));
    this.resType.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Reservation.this.resTypeActionPerformed(evt);
      }
    });
    this.jButton6.setText("New");
    this.jButton6.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Reservation.this.jButton6ActionPerformed(evt);
      }
    });
    this.resGuest.setModel(new DefaultComboBoxModel(new String[] { "Select" }));
    
    this.jLabel10.setForeground(new Color(255, 255, 255));
    this.jLabel10.setText("Date Out");
    
    this.resTime.setFormatterFactory(new DefaultFormatterFactory(new DateFormatter(new SimpleDateFormat("HH:mm"))));
    this.resTime.setText("11:00");
    this.resTime.addFocusListener(new FocusAdapter()
    {
      public void focusLost(FocusEvent evt)
      {
        Reservation.this.resTimeFocusLost(evt);
      }
    });
    this.jLabel13.setForeground(new Color(255, 255, 255));
    this.jLabel13.setText("Time");
    
    this.jLabel9.setForeground(new Color(255, 255, 255));
    this.jLabel9.setText("Days");
    
    this.resDays.setModel(new SpinnerNumberModel(1, 1, 100, 1));
    this.resDays.addChangeListener(new ChangeListener()
    {
      public void stateChanged(ChangeEvent evt)
      {
        Reservation.this.resDaysStateChanged(evt);
      }
    });
    this.resDays.addFocusListener(new FocusAdapter()
    {
      public void focusLost(FocusEvent evt)
      {
        Reservation.this.resDaysFocusLost(evt);
      }
    });
    this.jButton5.setText("Check");
    this.jButton5.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Reservation.this.jButton5ActionPerformed(evt);
      }
    });
    GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
    this.jPanel3.setLayout(jPanel3Layout);
    jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jSeparator5).addGroup(jPanel3Layout.createSequentialGroup().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel2).addComponent(this.jLabel3).addComponent(this.jLabel8)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.resDateIn, -1, -1, 32767).addComponent(this.resVent, 0, -1, 32767).addComponent(this.resType, 0, -1, 32767))).addGroup(jPanel3Layout.createSequentialGroup().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel9).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addGap(12, 12, 12).addComponent(this.jLabel10)).addComponent(this.roomLabel, GroupLayout.Alignment.TRAILING).addComponent(this.jLabel12, GroupLayout.Alignment.TRAILING).addComponent(this.jLabel13, GroupLayout.Alignment.TRAILING))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup().addComponent(this.resGuest, 0, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton6)).addComponent(this.resDateOut, -1, -1, 32767).addComponent(this.resRoom, 0, -1, 32767).addComponent(this.resDays).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.resTime, -2, 158, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton5, -1, -1, 32767)))).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.jButton8, -2, 108, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 84, 32767).addComponent(this.jButton9, -2, 115, -2))).addContainerGap()));
    











































    jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup().addContainerGap().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.resType, -1, 32, 32767).addComponent(this.jLabel2, -1, -1, 32767)).addGap(18, 18, 18).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel3).addComponent(this.resVent, -2, -1, -2)).addGap(18, 18, 18).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.resDateIn, -1, -1, 32767).addComponent(this.jLabel8, -2, 32, -2)).addGap(18, 18, 18).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jLabel9, -1, -1, 32767).addComponent(this.resDays)).addGap(18, 18, 32767).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.resDateOut, -1, -1, 32767).addComponent(this.jLabel10, -2, 32, -2)).addGap(18, 18, 18).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.resTime, -2, -1, -2).addComponent(this.jLabel13, -2, 32, -2)).addComponent(this.jButton5, -1, -1, 32767)).addGap(18, 18, 18).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.resRoom).addComponent(this.roomLabel, -1, -1, 32767)).addGap(18, 18, 18).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel12, -2, 28, -2).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.resGuest, -2, -1, -2).addComponent(this.jButton6))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jSeparator5, -2, 10, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jButton8).addComponent(this.jButton9)).addContainerGap()));
    














































    jPanel3Layout.linkSize(1, new Component[] { this.jLabel12, this.jLabel2, this.jLabel3 });
    
    jPanel3Layout.linkSize(1, new Component[] { this.jButton6, this.resDateIn, this.resDateOut, this.resDays, this.resGuest, this.resRoom, this.resTime, this.resType, this.resVent });
    
    GroupLayout addResLayout = new GroupLayout(this.addRes.getContentPane());
    this.addRes.getContentPane().setLayout(addResLayout);
    addResLayout.setHorizontalGroup(addResLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(addResLayout.createSequentialGroup().addContainerGap().addComponent(this.jPanel3, -1, -1, 32767).addContainerGap()));
    





    addResLayout.setVerticalGroup(addResLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(addResLayout.createSequentialGroup().addContainerGap().addComponent(this.jPanel3, -1, -1, 32767).addContainerGap()));
    






    this.newGuest.setTitle("Add New Guest");
    this.newGuest.setMinimumSize(new Dimension(335, 487));
    this.newGuest.setModal(true);
    
    this.jPanel6.setBackground(new Color(51, 0, 153));
    
    this.jPanel7.setBackground(new Color(51, 0, 153));
    this.jPanel7.setBorder(BorderFactory.createTitledBorder(null, "Personal Information", 0, 0, null, Color.white));
    
    this.jLabel16.setForeground(new Color(255, 255, 255));
    this.jLabel16.setText("First Name");
    
    this.jLabel17.setForeground(new Color(255, 255, 255));
    this.jLabel17.setText("Last Name");
    
    GroupLayout jPanel7Layout = new GroupLayout(this.jPanel7);
    this.jPanel7.setLayout(jPanel7Layout);
    jPanel7Layout.setHorizontalGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel7Layout.createSequentialGroup().addContainerGap().addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel7Layout.createSequentialGroup().addComponent(this.jLabel16).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.fname)).addGroup(GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup().addComponent(this.jLabel17).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.lname))).addContainerGap()));
    













    jPanel7Layout.setVerticalGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel7Layout.createSequentialGroup().addContainerGap().addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel16, -2, 29, -2).addComponent(this.fname, -1, 32, 32767)).addGap(18, 18, 18).addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel17, -2, 29, -2).addComponent(this.lname, -1, 32, 32767)).addContainerGap()));
    












    this.jLabel18.setForeground(new Color(255, 255, 255));
    this.jLabel18.setText("GuestID");
    
    this.jPanel5.setBackground(new Color(51, 0, 153));
    this.jPanel5.setBorder(BorderFactory.createTitledBorder(null, "Contact/Address", 0, 0, null, Color.white));
    
    this.jLabel19.setForeground(new Color(255, 255, 255));
    this.jLabel19.setText("Contact #");
    
    this.jLabel20.setForeground(new Color(255, 255, 255));
    this.jLabel20.setText("Address");
    
    GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
    this.jPanel5.setLayout(jPanel5Layout);
    jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addContainerGap().addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel19).addComponent(this.jLabel20)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.add).addComponent(this.cont)).addContainerGap()));
    











    jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addContainerGap().addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel19, -2, 29, -2).addComponent(this.cont, -1, 32, 32767)).addGap(18, 18, 18).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel20, -2, 29, -2).addComponent(this.add, -1, 32, 32767)).addContainerGap()));
    












    this.jLabel21.setForeground(new Color(255, 255, 255));
    this.jLabel21.setText("Remarks");
    
    this.jButton10.setText("Save");
    this.jButton10.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Reservation.this.jButton10ActionPerformed(evt);
      }
    });
    this.jButton11.setText("Cancel");
    this.jButton11.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Reservation.this.jButton11ActionPerformed(evt);
      }
    });
    GroupLayout jPanel6Layout = new GroupLayout(this.jPanel6);
    this.jPanel6.setLayout(jPanel6Layout);
    jPanel6Layout.setHorizontalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addContainerGap().addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jSeparator2).addComponent(this.jPanel7, -1, -1, 32767).addComponent(this.jPanel5, -1, -1, 32767).addGroup(jPanel6Layout.createSequentialGroup().addComponent(this.jButton10, -2, 106, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.jButton11, -2, 106, -2)).addGroup(jPanel6Layout.createSequentialGroup().addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addComponent(this.jLabel18).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.guestID, -2, 228, -2)).addGroup(jPanel6Layout.createSequentialGroup().addComponent(this.jLabel21).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.rem, -2, 228, -2))).addGap(0, 0, 32767))).addContainerGap()));
    























    jPanel6Layout.setVerticalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addContainerGap().addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.guestID, -1, 32, 32767).addComponent(this.jLabel18, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel7, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel5, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.rem).addComponent(this.jLabel21, -2, 32, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jSeparator2, -2, 10, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jButton10, -2, 33, -2).addComponent(this.jButton11, -2, 33, -2)).addContainerGap(-1, 32767)));
    






















    GroupLayout newGuestLayout = new GroupLayout(this.newGuest.getContentPane());
    this.newGuest.getContentPane().setLayout(newGuestLayout);
    newGuestLayout.setHorizontalGroup(newGuestLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(newGuestLayout.createSequentialGroup().addContainerGap().addComponent(this.jPanel6, -1, -1, 32767).addContainerGap()));
    





    newGuestLayout.setVerticalGroup(newGuestLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(newGuestLayout.createSequentialGroup().addContainerGap().addComponent(this.jPanel6, -1, -1, 32767).addContainerGap()));
    






    this.jPanel1.setBorder(BorderFactory.createTitledBorder("Filter by"));
    
    this.jLabel1.setText("Guest Name");
    
    this.filGuest.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Reservation.this.filGuestActionPerformed(evt);
      }
    });
    this.filGuest.addKeyListener(new KeyAdapter()
    {
      public void keyPressed(KeyEvent evt)
      {
        Reservation.this.filGuestKeyPressed(evt);
      }
      
      public void keyTyped(KeyEvent evt)
      {
        Reservation.this.filGuestKeyTyped(evt);
      }
    });
    GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
    this.jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.filGuest, -2, 148, -2).addContainerGap(-1, 32767)));
    







    jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel1).addComponent(this.filGuest, -2, -1, -2)).addContainerGap(13, 32767)));
    








    resTable.setFont(new Font("Tahoma", 0, 18));
    resTable.setModel(new DefaultTableModel(new Object[0][], new String[] { "Reservation ID", "Room", "Guest", "Date In", "Date Out", "Remarks" })
    {
      boolean[] canEdit = { false, false, false, false, false, false };
      
      public boolean isCellEditable(int rowIndex, int columnIndex)
      {
        return this.canEdit[columnIndex];
      }
    });
    resTable.setRowHeight(27);
    resTable.getTableHeader().setReorderingAllowed(false);
    this.jScrollPane1.setViewportView(resTable);
    
    this.jPanel2.setBorder(BorderFactory.createTitledBorder("Statistics"));
    
    this.jLabel4.setText("Number of Records:");
    
    this.noOfRes.setForeground(new Color(255, 102, 102));
    this.noOfRes.setText("0");
    
    GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
    this.jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel4).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.noOfRes, -2, 124, -2).addContainerGap(-1, 32767)));
    







    jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel4, -1, -1, 32767).addComponent(this.noOfRes)).addContainerGap()));
    








    this.jButton1.setText("New Reservation");
    this.jButton1.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Reservation.this.jButton1ActionPerformed(evt);
      }
    });
    this.jButton2.setText("Edit");
    this.jButton2.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Reservation.this.jButton2ActionPerformed(evt);
      }
    });
    this.jButton3.setText("Cancel");
    this.jButton3.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Reservation.this.jButton3ActionPerformed(evt);
      }
    });
    this.jButton4.setText("Modify Remarks");
    this.jButton4.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Reservation.this.jButton4ActionPerformed(evt);
      }
    });
    GroupLayout layout = new GroupLayout(this);
    setLayout(layout);
    layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jSeparator1).addComponent(this.jPanel1, -1, -1, 32767).addComponent(this.jScrollPane1, GroupLayout.Alignment.TRAILING).addComponent(this.jPanel2, -1, -1, 32767).addGroup(layout.createSequentialGroup().addComponent(this.jButton1, -2, 143, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton2, -2, 143, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton4, -2, 143, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 308, 32767).addComponent(this.jButton3, -2, 117, -2))).addContainerGap()));
    


















    layout.linkSize(0, new Component[] { this.jButton1, this.jButton2, this.jButton3, this.jButton4 });
    
    layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(6, 6, 6).addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -1, 335, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel2, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jSeparator1, -2, 5, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jButton1, -2, 38, -2).addComponent(this.jButton3, -2, 38, -2).addComponent(this.jButton2, -2, 38, -2).addComponent(this.jButton4, -2, 38, -2)).addContainerGap()));
    


















    layout.linkSize(1, new Component[] { this.jButton1, this.jButton2, this.jButton3, this.jButton4 });
  }
  
  private void jButton6ActionPerformed(ActionEvent evt)
  {
    this.newGuest.setVisible(true);
  }
  
  private void jButton1ActionPerformed(ActionEvent evt)
  {
    this.isAdd = true;
    calcOutDate();
    loadAvailRooms();
    loadGuests();
    this.addRes.setTitle("Add New Reservation");
    this.addRes.setVisible(true);
  }
  
  private void resDateOutActionPerformed(ActionEvent evt) {}
  
  private void jButton9ActionPerformed(ActionEvent evt)
  {
    System.out.println(this.addRes.getSize());
    this.addRes.setVisible(false);
  }
  
  private void resDaysStateChanged(ChangeEvent evt)
  {
    calcOutDate();
    loadAvailRooms();
  }
  
  private void resDateInActionPerformed(ActionEvent evt)
  {
    String resIn = this.df.format(this.resDateIn.getDate());
    String now = this.df.format(Calendar.getInstance().getTime());
    
    int res = calcDateDiff(resIn, now);
    if (res < 0)
    {
      JOptionPane.showMessageDialog(this.addRes, "You can't set past dates.", "Invalide Date", 0);
      this.resDateIn.setDate(Calendar.getInstance().getTime());
    }
    else
    {
      calcOutDate();
    }
    loadAvailRooms();
  }
  
  private void jButton8ActionPerformed(ActionEvent evt)
  {
    if ((this.resRoom.getSelectedIndex() != 0) && (this.resGuest.getSelectedIndex() != 0))
    {
      String sRoom = this.resRoom.getSelectedItem().toString();
      String sGuest = this.resGuest.getSelectedItem().toString();
      
      String sDateIn = this.df.format(this.resDateIn.getDate()) + " " + this.resTime.getText();
      String sDateOut = this.df.format(this.resDateOut.getDate()) + " " + this.resTime.getText();
      try
      {
        Class.forName("com.mysql.jdbc.Driver");
        String connectionUrl = DBUrl.dbcon;
        Connection con = DriverManager.getConnection(connectionUrl);
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        int res = -1;
        Statement updateStmt = con.createStatement();
        if (!this.isAdd)
        {
          res = updateStmt.executeUpdate("DELETE FROM `reservation`.`reservation` WHERE  `resID`=" + this.selID + ";");
          if (res != 0)
          {
            stmt = con.prepareStatement("INSERT INTO `reservation`.`reservation` (`resID`, `roomID`, `guestID`, `inDate`, `outDate`, `stat`) VALUES ('" + this.selID + "', ?, ?, ?, ?, 'r');");
            
            stmt.setString(1, sRoom);
            stmt.setString(2, sGuest);
            stmt.setString(3, sDateIn);
            stmt.setString(4, sDateOut);
            res = stmt.executeUpdate();
            new UserLogger().insertLog(Extras.loggeduser, 1, "Modified reservation for guest " + sGuest);
          }
        }
        else
        {
          stmt = con.prepareStatement("INSERT INTO `reservation`.`reservation` (`roomID`, `guestID`, `inDate`, `outDate`, `stat`) VALUES (?, ?, ?, ?, 'r');");
          
          stmt.setString(1, sRoom);
          stmt.setString(2, sGuest);
          stmt.setString(3, sDateIn);
          stmt.setString(4, sDateOut);
          res = stmt.executeUpdate();
          new UserLogger().insertLog(Extras.loggeduser, 1, "Reserved " + sGuest + " to room " + sRoom);
        }
        if (res != 0)
        {
          JOptionPane.showMessageDialog(this.addRes, "Reservation successfully saved");
          
          this.addRes.setVisible(false);
          loadRes();
        }
        else
        {
          JOptionPane.showMessageDialog(this.addRes, "Invalid input.\nPlease check entered info", "Input Error", 0);
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
    }
    else
    {
      JOptionPane.showMessageDialog(this.addRes, "Please enter valid Room and Guest.", "Input Error", 0);
    }
  }
  
  private void resTimeFocusLost(FocusEvent evt)
  {
    if (!this.resTime.isEditValid()) {
      this.resTime.setText("11:00");
    }
  }
  
  private void resVentActionPerformed(ActionEvent evt) {}
  
  private void resTypeActionPerformed(ActionEvent evt) {}
  
  private void resDaysFocusLost(FocusEvent evt) {}
  
  private void jButton5ActionPerformed(ActionEvent evt)
  {
    loadAvailRooms();
  }
  
  private void jButton2ActionPerformed(ActionEvent evt)
  {
    int selr = resTable.getSelectedRow();
    if (selr != -1) {
      try
      {
        this.isAdd = false;
        this.selID = resTable.getValueAt(selr, 0).toString();
        
        String sInDate = resTable.getValueAt(selr, 3).toString().substring(0, 10);
        Date dInDate = this.df.parse(sInDate);
        this.resDateIn.setDate(dInDate);
        
        String sOutDate = resTable.getValueAt(selr, 4).toString().substring(0, 10);
        int diff = calcDateDiff(sOutDate, sInDate);
        this.resDays.setValue(Integer.valueOf(diff));
        
        String sTime = resTable.getValueAt(selr, 4).toString().substring(11, 16);
        System.out.println(sTime);
        this.resTime.setText(sTime);
        
        calcOutDate();
        loadAvailRooms();
        String sRoom = resTable.getValueAt(selr, 1).toString();
        this.resRoom.setSelectedItem(sRoom);
        
        loadGuests();
        String sGuest = resTable.getValueAt(selr, 2).toString();
        this.resGuest.setSelectedItem(sGuest);
        

        this.addRes.setTitle("Edit Reservation");
        this.addRes.setVisible(true);
      }
      catch (ParseException ex)
      {
        Logger.getLogger(Reservation.class.getName()).log(Level.SEVERE, null, ex);
      }
    } else {
      JOptionPane.showMessageDialog(resTable, "Please select reservation to edit.", "No Selcted Reservation", 0);
    }
  }
  
  private void jButton4ActionPerformed(ActionEvent evt)
  {
    int selr = resTable.getSelectedRow();
    if (selr != -1)
    {
      String selRes = resTable.getValueAt(selr, 0).toString();
      String curVal = resTable.getValueAt(selr, 5).toString();
      String newVal = JOptionPane.showInputDialog(resTable, "Modify Remarks", curVal);
      if ((newVal.length() != 0) || (newVal != null)) {
        try
        {
          Class.forName("com.mysql.jdbc.Driver");
          String connectionUrl = DBUrl.dbcon;
          Connection con = DriverManager.getConnection(connectionUrl);
          PreparedStatement stmt = null;
          ResultSet rs = null;
          
          stmt = con.prepareStatement("UPDATE `reservation`.`reservation` SET `rem`=? WHERE  `resID`=" + selRes + ";");
          stmt.setString(1, newVal);
          stmt.executeUpdate();
          JOptionPane.showMessageDialog(resTable, "Saved");
          loadRes();
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
      JOptionPane.showMessageDialog(resTable, "Please select reservation to edit.", "No Selcted Reservation", 0);
    }
  }
  
  private void jButton3ActionPerformed(ActionEvent evt)
  {
    int selr = resTable.getSelectedRow();
    if (selr != -1)
    {
      if (JOptionPane.showConfirmDialog(resTable, "Sure to cancel this reservation?\nWarning, this action cannot be undone", "Cancel Confirmation", 0) == 0)
      {
        String selID = resTable.getValueAt(selr, 0).toString();
        try
        {
          Class.forName("com.mysql.jdbc.Driver");
          String connectionUrl = DBUrl.dbcon;
          Connection con = DriverManager.getConnection(connectionUrl);
          Statement stmt = null;
          
          stmt = con.createStatement();
          
          int res = stmt.executeUpdate("DELETE FROM `reservation`.`reservation` WHERE  `resID`=" + selID + ";");
          if (res != 0)
          {
            JOptionPane.showMessageDialog(resTable, "Reservation successfully cancelled");
            loadRes();
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
      }
    }
    else {
      JOptionPane.showMessageDialog(resTable, "Please select reservation to cancel.", "No Selcted Reservation", 0);
    }
  }
  
  private void jButton10ActionPerformed(ActionEvent evt)
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
          this.newGuest.setVisible(false);
          loadGuests();
          this.resGuest.setSelectedItem(sGuestID);
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
  
  private void jButton11ActionPerformed(ActionEvent evt)
  {
    System.out.println(this.newGuest.getSize());
    this.newGuest.setVisible(false);
  }
  
  private void filGuestKeyPressed(KeyEvent evt)
  {
    filRes();
  }
  
  private void filGuestActionPerformed(ActionEvent evt)
  {
    filRes();
  }
  
  private void filGuestKeyTyped(KeyEvent evt)
  {
    filRes();
  }
  
  private void loadAvailRooms()
  {
    try
    {
      Class.forName("com.mysql.jdbc.Driver");
      String connectionUrl = DBUrl.dbcon;
      Connection con = DriverManager.getConnection(connectionUrl);
      Statement stmt = null;
      ResultSet rs = null;
      stmt = con.createStatement();
      String resIn = this.df.format(this.resDateIn.getDate()) + " " + this.resTime.getText();
      String resOut = this.df.format(this.resDateOut.getDate()) + " " + this.resTime.getText();
      System.out.println(resIn + "   " + resOut);
      
      String updateQ = "";
      if (!this.isAdd) {
        updateQ = " AND `resID` != '" + this.selID + "' ";
      }
      String q = " SELECT DISTINCT `roomID` FROM reservation WHERE  (('" + resIn + "' <= inDate AND '" + resOut + "' >= outDate) OR " + "('" + resIn + "' >= inDate AND '" + resOut + "' <= outDate) OR" + "(('" + resIn + "' >= inDate AND '" + resIn + "' < outDate) AND  '" + resOut + "' >= outDate) OR " + "    ('" + resIn + "' <= inDate AND ('" + resOut + "' <= outDate AND '" + resOut + "' > inDate))) " + updateQ + ";";
      


      System.out.println(q);
      rs = stmt.executeQuery(q);
      
      this.resRoom.setModel(new DefaultComboBoxModel(new String[] { "Select" }));
      
      String roomFil = "";
      if (this.resType.getSelectedIndex() != 0)
      {
        String sType = this.resType.getSelectedItem().toString();
        roomFil = roomFil + " AND `type` = '" + sType + "'";
      }
      if (this.resVent.getSelectedIndex() != 0)
      {
        String sVent = this.resVent.getSelectedItem().toString();
        roomFil = roomFil + " AND  `vent` = '" + sVent + "'";
      }
      String que = "SELECT  DISTINCT `roomID` FROM `rooms` WHERE 1=1" + roomFil;
      while (rs.next()) {
        que = que + " AND `roomID` != '" + rs.getString("roomID") + "'";
      }
      System.out.println(que);
      ResultSet rs0 = stmt.executeQuery(que);
      
      int availQuan = 0;
      while (rs0.next())
      {
        System.out.println(rs0.getString("roomID"));
        this.resRoom.addItem(rs0.getString("roomID"));
        availQuan++;
      }
      if (availQuan > 0)
      {
        this.roomLabel.setText("Room(" + availQuan + ")");
        this.resRoom.setEnabled(true);
        this.roomLabel.setForeground(new Color(255, 255, 255));
      }
      else
      {
        this.roomLabel.setText("Room(" + availQuan + ")");
        this.resRoom.setEnabled(false);
        this.roomLabel.setForeground(new Color(255, 102, 102));
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
  }
  
  private void calcOutDate()
  {
    try
    {
      Class.forName("com.mysql.jdbc.Driver");
      String connectionUrl = DBUrl.dbcon;
      Connection con = DriverManager.getConnection(connectionUrl);
      PreparedStatement stmt = null;
      ResultSet rs = null;
      int days = Integer.parseInt(this.resDays.getValue().toString());
      String resIn = this.df.format(this.resDateIn.getDate()) + " " + this.resTime.getText();
      
      stmt = con.prepareStatement("SELECT '" + resIn + "' + INTERVAL ? DAY AS outDate;");
      stmt.setInt(1, days);
      rs = stmt.executeQuery();
      rs.next();
      this.resDateOut.setDate(rs.getDate("outDate"));
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
  
  private int calcDateDiff(String next, String prev)
  {
    int res = -1;
    try
    {
      Class.forName("com.mysql.jdbc.Driver");
      String connectionUrl = DBUrl.dbcon;
      Connection con = DriverManager.getConnection(connectionUrl);
      Statement stmt = null;
      ResultSet rs = null;
      
      stmt = con.createStatement();
      
      rs = stmt.executeQuery("SELECT DATEDIFF('" + next + "', '" + prev + "') AS diff");
      if (rs.next()) {
        res = rs.getInt("diff");
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
    return res;
  }
  
  private void loadGuests()
  {
    try
    {
      Class.forName("com.mysql.jdbc.Driver");
      String connectionUrl = DBUrl.dbcon;
      Connection con = DriverManager.getConnection(connectionUrl);
      Statement stmt = null;
      ResultSet rs = null;
      
      stmt = con.createStatement();
      this.resGuest.setModel(new DefaultComboBoxModel(new String[] { "Select" }));
      
      rs = stmt.executeQuery("SELECT `guestID` FROM `guest`");
      while (rs.next()) {
        this.resGuest.addItem(rs.getString("guestID"));
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
  }
  
  private void loadRes()
  {
    int num = new LoadReservationRecord().LoadResRecord(resTable, new TableModels().resModel, "SELECT * FROM reservation WHERE `stat`='r' ORDER BY `inDate` DESC");
    
    this.noOfRes.setText(num + "");
  }
  
  private void filRes()
  {
    String sGuest = this.filGuest.getText();
    int num = new LoadReservationRecord().LoadResRecord(resTable, new TableModels().resModel, "SELECT * FROM reservation WHERE `guestID` LIKE '%" + sGuest + "%' AND `stat`='r' ORDER BY `inDate` DESC");
    
    this.noOfRes.setText(num + "");
  }
}



/* Location:           D:\New folder\New folder\dist\11thPrototype.jar

 * Qualified Name:     MainForms.Reservation

 * JD-Core Version:    0.7.0.1

 */