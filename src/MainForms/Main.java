package MainForms;

import Fields.DBUrl;
import Fields.Extras;
import Fields.TableModels;
import Methods.LoadExtras;
import Methods.LoadPayment;
import Methods.LoadReservationRecord;
import Methods.LoadReservationRecord1;
import Methods.LoadSales;
import Methods.LoadTableRecord;
import Methods.UserLogger;
import Reports.Folio;
import Reports.SalesAccReport;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.accessibility.AccessibleContext;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.LayoutStyle;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import org.jdesktop.swingx.JXDatePicker;
import org.joda.time.DateTime;
import org.joda.time.DateTime.Property;
import org.joda.time.Days;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class Main
  extends JFrame
{
  private String selRes;
  private float selExtra;
  private String selOut;
  private String selRoom;
  private String selReservation;
  private boolean isRes;
  private String selGuest;
  private float selPrice;
  private String resID;
  
  public Main()
  {
    initComponents();
    




    this.naviHome.setForeground(new Color(255, 0, 0));
    
    naviCur.setCursor(new Cursor(12));
    naviRes.setCursor(new Cursor(12));
    naviGuest.setCursor(new Cursor(12));
    naviRoom.setCursor(new Cursor(12));
    naviRec.setCursor(new Cursor(12));
    naviSet.setCursor(new Cursor(12));
    this.naviHome.setCursor(new Cursor(0));
    

    this.split.setRightComponent(new Home());
  }
  
  SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
  DateTimeFormatter jodaDF = DateTimeFormat.forPattern("yyyy-MM-dd");
  SimpleDateFormat tf = new SimpleDateFormat("HH:mm");
  DecimalFormat decForm = new DecimalFormat("#0.00");
  private JLabel accAdj;
  private JLabel accAdj1;
  private JLabel accAdj2;
  private JLabel accBal;
  private JLabel accBal1;
  private JLabel accBal2;
  private JLabel accExtra;
  private JLabel accExtra1;
  private JLabel accExtra2;
  private JComboBox accMode;
  private JComboBox accMode1;
  private JLabel accPaid;
  private JLabel accPaid1;
  private JLabel accPaid2;
  private JLabel accRoom;
  private JLabel accRoom1;
  private JLabel accRoom2;
  private JLabel accSales;
  private JLabel accSales1;
  private JLabel accSales2;
  private JFormattedTextField accTendered;
  private JFormattedTextField accTendered1;
  private JLabel accTotal;
  private JLabel accTotal1;
  private JLabel accTotal2;
  private JDialog account;
  private JDialog account1;
  private JDialog account2;
  private JTextField add;
  private JDialog addExtra;
  private JDialog addExtra1;
  private JDialog addRes;
  private JFormattedTextField adjAmount;
  private JTextField adjDesc;
  private JTable adjustTable;
  private JDialog adjustments;
  private JLabel balLabel;
  private JLabel balLabel1;
  private JLabel balLabel2;
  private JDialog balances;
  private JTable balancesTable;
  private JTextField cont;
  private JSplitPane currentSplit;
  private JCheckBox discCheck;
  private JCheckBox discCheck1;
  private JXDatePicker exCurOut;
  private JSpinner exDays;
  private JSpinner exDisc;
  private JTextField exExtra;
  private JXDatePicker exNewOut;
  private JTextField exRate;
  private JDialog extend;
  private JTextField filGuest;
  private JTextField filRem;
  private JTextField filRoom;
  private JComboBox filStat;
  private JComboBox filType;
  private JComboBox filVent;
  private JTextField fname;
  private JTextField guestID;
  private JButton jButton1;
  private JButton jButton10;
  private JButton jButton11;
  private JButton jButton12;
  private JButton jButton13;
  private JButton jButton14;
  private JButton jButton15;
  private JButton jButton16;
  private JButton jButton17;
  private JButton jButton18;
  private JButton jButton19;
  private JButton jButton2;
  private JButton jButton20;
  private JButton jButton21;
  private JButton jButton22;
  private JButton jButton23;
  private JButton jButton24;
  private JButton jButton25;
  private JButton jButton26;
  private JButton jButton27;
  private JButton jButton28;
  private JButton jButton29;
  private JButton jButton3;
  private JButton jButton30;
  private JButton jButton31;
  private JButton jButton32;
  private JButton jButton33;
  private JButton jButton34;
  private JButton jButton35;
  private JButton jButton36;
  private JButton jButton37;
  private JButton jButton38;
  private JButton jButton39;
  private JButton jButton4;
  private JButton jButton40;
  private JButton jButton41;
  private JButton jButton42;
  private JButton jButton43;
  private JButton jButton44;
  private JButton jButton45;
  private JButton jButton46;
  private JButton jButton47;
  private JButton jButton48;
  private JButton jButton49;
  private JButton jButton5;
  private JButton jButton50;
  private JButton jButton51;
  private JButton jButton52;
  private JButton jButton53;
  private JButton jButton54;
  private JButton jButton55;
  private JButton jButton56;
  private JButton jButton57;
  private JButton jButton58;
  private JButton jButton59;
  private JButton jButton6;
  private JButton jButton60;
  private JButton jButton61;
  private JButton jButton7;
  private JButton jButton8;
  private JButton jButton82;
  private JButton jButton83;
  private JButton jButton9;
  private JLabel jLabel1;
  private JLabel jLabel10;
  private JLabel jLabel11;
  private JLabel jLabel12;
  private JLabel jLabel13;
  private JLabel jLabel14;
  private JLabel jLabel15;
  private JLabel jLabel16;
  private JLabel jLabel17;
  private JLabel jLabel18;
  private JLabel jLabel19;
  private JLabel jLabel2;
  private JLabel jLabel20;
  private JLabel jLabel21;
  private JLabel jLabel22;
  private JLabel jLabel23;
  private JLabel jLabel24;
  private JLabel jLabel25;
  private JLabel jLabel26;
  private JLabel jLabel27;
  private JLabel jLabel28;
  private JLabel jLabel29;
  private JLabel jLabel3;
  private JLabel jLabel30;
  private JLabel jLabel31;
  private JLabel jLabel32;
  private JLabel jLabel33;
  private JLabel jLabel34;
  private JLabel jLabel35;
  private JLabel jLabel36;
  private JLabel jLabel37;
  private JLabel jLabel38;
  private JLabel jLabel39;
  private JLabel jLabel4;
  private JLabel jLabel40;
  private JLabel jLabel41;
  private JLabel jLabel42;
  private JLabel jLabel43;
  private JLabel jLabel44;
  private JLabel jLabel45;
  private JLabel jLabel46;
  private JLabel jLabel47;
  private JLabel jLabel48;
  private JLabel jLabel49;
  private JLabel jLabel5;
  private JLabel jLabel50;
  private JLabel jLabel51;
  private JLabel jLabel52;
  private JLabel jLabel53;
  private JLabel jLabel54;
  private JLabel jLabel55;
  private JLabel jLabel56;
  private JLabel jLabel57;
  private JLabel jLabel58;
  private JLabel jLabel59;
  private JLabel jLabel6;
  private JLabel jLabel60;
  private JLabel jLabel61;
  private JLabel jLabel62;
  private JLabel jLabel63;
  private JLabel jLabel64;
  private JLabel jLabel65;
  private JLabel jLabel66;
  private JLabel jLabel67;
  private JLabel jLabel68;
  private JLabel jLabel69;
  private JLabel jLabel7;
  private JLabel jLabel70;
  private JLabel jLabel71;
  private JLabel jLabel72;
  private JLabel jLabel73;
  private JLabel jLabel74;
  private JLabel jLabel75;
  private JLabel jLabel76;
  private JLabel jLabel77;
  private JLabel jLabel78;
  private JLabel jLabel79;
  private JLabel jLabel8;
  private JLabel jLabel80;
  private JLabel jLabel81;
  private JLabel jLabel82;
  private JLabel jLabel9;
  private JMenu jMenu1;
  private JMenu jMenu2;
  private JMenu jMenu4;
  private JMenu jMenu5;
  private JMenuBar jMenuBar1;
  private JMenuItem jMenuItem1;
  private JMenuItem jMenuItem2;
  private JMenuItem jMenuItem3;
  private JMenuItem jMenuItem4;
  private JMenuItem jMenuItem5;
  private JMenuItem jMenuItem6;
  private JMenuItem jMenuItem7;
  private JMenuItem jMenuItem8;
  private JMenuItem jMenuItem9;
  private JPanel jPanel1;
  private JPanel jPanel10;
  private JPanel jPanel11;
  private JPanel jPanel12;
  private JPanel jPanel13;
  private JPanel jPanel14;
  private JPanel jPanel15;
  private JPanel jPanel16;
  private JPanel jPanel17;
  private JPanel jPanel18;
  private JPanel jPanel19;
  private JPanel jPanel2;
  private JPanel jPanel20;
  private JPanel jPanel21;
  private JPanel jPanel22;
  private JPanel jPanel23;
  private JPanel jPanel24;
  private JPanel jPanel25;
  private JPanel jPanel26;
  private JPanel jPanel27;
  private JPanel jPanel28;
  private JPanel jPanel29;
  private JPanel jPanel3;
  private JPanel jPanel30;
  private JPanel jPanel31;
  private JPanel jPanel32;
  private JPanel jPanel33;
  private JPanel jPanel34;
  private JPanel jPanel35;
  private JPanel jPanel36;
  private JPanel jPanel37;
  private JPanel jPanel38;
  private JPanel jPanel4;
  private JPanel jPanel5;
  private JPanel jPanel6;
  private JPanel jPanel7;
  private JPanel jPanel8;
  private JPanel jPanel9;
  private JScrollPane jScrollPane1;
  private JScrollPane jScrollPane10;
  private JScrollPane jScrollPane2;
  private JScrollPane jScrollPane3;
  private JScrollPane jScrollPane4;
  private JScrollPane jScrollPane5;
  private JScrollPane jScrollPane6;
  private JScrollPane jScrollPane7;
  private JScrollPane jScrollPane8;
  private JScrollPane jScrollPane9;
  private JSeparator jSeparator1;
  private JSeparator jSeparator10;
  private JSeparator jSeparator11;
  private JSeparator jSeparator12;
  private JSeparator jSeparator13;
  private JSeparator jSeparator14;
  private JSeparator jSeparator15;
  private JSeparator jSeparator16;
  private JSeparator jSeparator17;
  private JSeparator jSeparator18;
  private JSeparator jSeparator19;
  private JSeparator jSeparator2;
  private JSeparator jSeparator22;
  private JSeparator jSeparator3;
  private JSeparator jSeparator4;
  private JSeparator jSeparator5;
  private JSeparator jSeparator6;
  private JSeparator jSeparator7;
  private JSeparator jSeparator8;
  private JSeparator jSeparator9;
  private JToolBar jToolBar1;
  private JTextField lname;
  private JPanel navi;
  public static JButton naviCal;
  public static JButton naviCur;
  public static JButton naviGuest;
  private JButton naviHome;
  public static JButton naviRec;
  public static JButton naviRes;
  public static JButton naviRoom;
  public static JButton naviSet;
  public static JButton naviVac;
  private JDialog newAdjust;
  private JXDatePicker newDateOut;
  private JDialog newGuest;
  private JLabel newRoomRate;
  private JLabel noOccu;
  private JLabel noRes;
  private JLabel noVacant;
  private JMenu notifMenu;
  private JTable notifTable;
  private JPanel occu;
  private JTable occuTable;
  private JFormattedTextField payAmount;
  private JLabel payBal;
  private JLabel payBalLabel;
  private JComboBox payMode;
  private JLabel payTotal;
  private JDialog payment;
  private JComboBox preAdj;
  private JComboBox preAdj1;
  private JButton preAdjSign;
  private JButton preAdjSign1;
  private JTextField rem;
  private JPanel res;
  private JXDatePicker resDateIn;
  private JXDatePicker resDateOut;
  private JSpinner resDays;
  private JSpinner resDays1;
  private JSpinner resDisc;
  private JSpinner resDisc1;
  private JTextField resExtra;
  private JComboBox resGuest;
  private JTextField resRate;
  private JComboBox resRoom;
  private JComboBox resRoom2;
  private JTable resTable;
  private JFormattedTextField resTime;
  private JLabel roomLabel;
  private JLabel roomLabel2;
  private JLabel roomLabel3;
  private JLabel roomLabel4;
  public static JMenuItem showNot;
  private JDialog showNotif;
  private JSplitPane split;
  private JXDatePicker sugCal;
  private JSpinner sugDays;
  private JComboBox sugRooms;
  private JDialog suggest;
  private JTable suggestTable;
  private JLabel totalAdj;
  private JTextField totalBal;
  private JDialog transRoom;
  private JPanel vacant;
  private JTable vacantTable;
  private JToggleButton viewDue;
  private JDialog viewExtra;
  private JTable viewExtraTable;
  private JLabel viewPaid1;
  private JTable viewPayTable;
  private JDialog viewPayment;
  private JTable viewSaleTable;
  private JDialog viewSales;
  private JLabel viewTotal;
  private JLabel viewTotal1;
  private JLabel viewTotal2;
  private JLabel viewTotal3;
  private JLabel viewUnpaid1;
  private JXDatePicker xDateIn;
  private JXDatePicker xDateIn1;
  private JXDatePicker xDateOut;
  private JXDatePicker xDateOut1;
  private JSpinner xDays;
  private JSpinner xDays1;
  private JTextField xPrice;
  private JTextField xPrice1;
  private JSpinner xQuan;
  private JSpinner xQuan1;
  
  
  private void initComponents()
  {
    this.vacant = new JPanel();
    this.jScrollPane2 = new JScrollPane();
    this.vacantTable = new JTable();
    this.jPanel3 = new JPanel();
    this.noVacant = new JLabel();
    this.jLabel60 = new JLabel();
    this.jSeparator2 = new JSeparator();
    this.jButton9 = new JButton();
    this.jButton10 = new JButton();
    this.res = new JPanel();
    this.jScrollPane3 = new JScrollPane();
    this.resTable = new JTable();
    this.jPanel4 = new JPanel();
    this.noRes = new JLabel();
    this.jLabel59 = new JLabel();
    this.jSeparator3 = new JSeparator();
    this.jButton11 = new JButton();
    this.jButton14 = new JButton();
    this.addRes = new JDialog();
    this.jPanel7 = new JPanel();
    this.jButton16 = new JButton();
    this.jSeparator5 = new JSeparator();
    this.jButton17 = new JButton();
    this.jPanel5 = new JPanel();
    this.jLabel13 = new JLabel();
    this.resTime = new JFormattedTextField();
    this.resDateOut = new JXDatePicker();
    this.jLabel10 = new JLabel();
    this.jLabel8 = new JLabel();
    this.resDateIn = new JXDatePicker();
    this.resDays = new JSpinner();
    this.jLabel9 = new JLabel();
    this.jPanel6 = new JPanel();
    this.jLabel12 = new JLabel();
    this.resGuest = new JComboBox();
    this.jButton18 = new JButton();
    this.jLabel4 = new JLabel();
    this.jLabel7 = new JLabel();
    this.discCheck = new JCheckBox();
    this.resRate = new JTextField();
    this.resDisc = new JSpinner();
    this.jButton22 = new JButton();
    this.resExtra = new JTextField();
    this.jLabel5 = new JLabel();
    this.jLabel77 = new JLabel();
    this.preAdjSign = new JButton();
    this.preAdj = new JComboBox();
    this.totalBal = new JTextField();
    this.jButton60 = new JButton();
    this.jLabel79 = new JLabel();
    this.payment = new JDialog();
    this.jPanel8 = new JPanel();
    this.jPanel9 = new JPanel();
    this.jLabel6 = new JLabel();
    this.payAmount = new JFormattedTextField();
    this.jLabel18 = new JLabel();
    this.payTotal = new JLabel();
    this.payBalLabel = new JLabel();
    this.payBal = new JLabel();
    this.jLabel27 = new JLabel();
    this.payMode = new JComboBox();
    this.jButton1 = new JButton();
    this.jButton13 = new JButton();
    this.jSeparator4 = new JSeparator();
    this.account = new JDialog();
    this.jPanel12 = new JPanel();
    this.jSeparator8 = new JSeparator();
    this.jButton20 = new JButton();
    this.jButton21 = new JButton();
    this.jPanel13 = new JPanel();
    this.accPaid = new JLabel();
    this.balLabel = new JLabel();
    this.jButton15 = new JButton();
    this.jButton19 = new JButton();
    this.accBal = new JLabel();
    this.accExtra = new JLabel();
    this.jLabel21 = new JLabel();
    this.accSales = new JLabel();
    this.jLabel20 = new JLabel();
    this.accTotal = new JLabel();
    this.accRoom = new JLabel();
    this.jLabel25 = new JLabel();
    this.jLabel17 = new JLabel();
    this.jSeparator7 = new JSeparator();
    this.jSeparator6 = new JSeparator();
    this.jLabel26 = new JLabel();
    this.accTendered = new JFormattedTextField();
    this.accMode = new JComboBox();
    this.jLabel29 = new JLabel();
    this.jButton45 = new JButton();
    this.jLabel61 = new JLabel();
    this.accAdj = new JLabel();
    this.jButton47 = new JButton();
    this.addExtra = new JDialog();
    this.jPanel10 = new JPanel();
    this.xDays = new JSpinner();
    this.xDateIn = new JXDatePicker();
    this.xDateOut = new JXDatePicker();
    this.jLabel11 = new JLabel();
    this.jLabel14 = new JLabel();
    this.jLabel15 = new JLabel();
    this.jButton2 = new JButton();
    this.jSeparator9 = new JSeparator();
    this.jLabel16 = new JLabel();
    this.xQuan = new JSpinner();
    this.jLabel19 = new JLabel();
    this.xPrice = new JTextField();
    this.jButton23 = new JButton();
    this.suggest = new JDialog();
    this.jPanel11 = new JPanel();
    this.jPanel14 = new JPanel();
    this.sugRooms = new JComboBox();
    this.jLabel22 = new JLabel();
    this.jLabel23 = new JLabel();
    this.jLabel24 = new JLabel();
    this.sugDays = new JSpinner();
    this.sugCal = new JXDatePicker();
    this.jButton24 = new JButton();
    this.jSeparator10 = new JSeparator();
    this.jPanel15 = new JPanel();
    this.jScrollPane4 = new JScrollPane();
    this.suggestTable = new JTable();
    this.viewPayment = new JDialog();
    this.jPanel16 = new JPanel();
    this.jScrollPane5 = new JScrollPane();
    this.viewPayTable = new JTable();
    this.jPanel17 = new JPanel();
    this.jLabel28 = new JLabel();
    this.viewTotal = new JLabel();
    this.jButton26 = new JButton();
    this.jButton12 = new JButton();
    this.account1 = new JDialog();
    this.jPanel18 = new JPanel();
    this.jSeparator11 = new JSeparator();
    this.jButton27 = new JButton();
    this.jButton28 = new JButton();
    this.jPanel19 = new JPanel();
    this.accPaid1 = new JLabel();
    this.balLabel1 = new JLabel();
    this.jButton29 = new JButton();
    this.jButton30 = new JButton();
    this.accBal1 = new JLabel();
    this.accExtra1 = new JLabel();
    this.jLabel30 = new JLabel();
    this.accSales1 = new JLabel();
    this.jLabel31 = new JLabel();
    this.accTotal1 = new JLabel();
    this.accRoom1 = new JLabel();
    this.jLabel32 = new JLabel();
    this.jLabel33 = new JLabel();
    this.jSeparator12 = new JSeparator();
    this.jSeparator13 = new JSeparator();
    this.jLabel34 = new JLabel();
    this.accTendered1 = new JFormattedTextField();
    this.accMode1 = new JComboBox();
    this.jLabel35 = new JLabel();
    this.jButton44 = new JButton();
    this.accAdj1 = new JLabel();
    this.jLabel67 = new JLabel();
    this.jButton49 = new JButton();
    this.jButton6 = new JButton();
    this.newGuest = new JDialog();
    this.jPanel22 = new JPanel();
    this.jPanel23 = new JPanel();
    this.jLabel37 = new JLabel();
    this.fname = new JTextField();
    this.lname = new JTextField();
    this.jLabel38 = new JLabel();
    this.jLabel39 = new JLabel();
    this.guestID = new JTextField();
    this.jPanel24 = new JPanel();
    this.jLabel40 = new JLabel();
    this.cont = new JTextField();
    this.add = new JTextField();
    this.jLabel41 = new JLabel();
    this.jLabel42 = new JLabel();
    this.rem = new JTextField();
    this.jSeparator14 = new JSeparator();
    this.jButton33 = new JButton();
    this.jButton34 = new JButton();
    this.viewSales = new JDialog();
    this.jPanel20 = new JPanel();
    this.jScrollPane6 = new JScrollPane();
    this.viewSaleTable = new JTable();
    this.jPanel21 = new JPanel();
    this.jLabel36 = new JLabel();
    this.viewUnpaid1 = new JLabel();
    this.viewPaid1 = new JLabel();
    this.jLabel70 = new JLabel();
    this.jLabel71 = new JLabel();
    this.viewTotal1 = new JLabel();
    this.jButton32 = new JButton();
    this.jButton35 = new JButton();
    this.extend = new JDialog();
    this.jPanel25 = new JPanel();
    this.jLabel43 = new JLabel();
    this.jLabel44 = new JLabel();
    this.exDays = new JSpinner();
    this.exCurOut = new JXDatePicker();
    this.jLabel45 = new JLabel();
    this.exNewOut = new JXDatePicker();
    this.jLabel47 = new JLabel();
    this.exDisc = new JSpinner();
    this.exExtra = new JTextField();
    this.jLabel48 = new JLabel();
    this.jButton37 = new JButton();
    this.exRate = new JTextField();
    this.jLabel49 = new JLabel();
    this.jButton38 = new JButton();
    this.jButton39 = new JButton();
    this.jSeparator15 = new JSeparator();
    this.addExtra1 = new JDialog();
    this.jPanel26 = new JPanel();
    this.xDays1 = new JSpinner();
    this.xDateIn1 = new JXDatePicker();
    this.xDateOut1 = new JXDatePicker();
    this.jLabel46 = new JLabel();
    this.jLabel50 = new JLabel();
    this.jLabel51 = new JLabel();
    this.jButton40 = new JButton();
    this.jSeparator16 = new JSeparator();
    this.jLabel52 = new JLabel();
    this.xQuan1 = new JSpinner();
    this.jLabel53 = new JLabel();
    this.xPrice1 = new JTextField();
    this.jButton41 = new JButton();
    this.viewExtra = new JDialog();
    this.jPanel27 = new JPanel();
    this.jScrollPane7 = new JScrollPane();
    this.viewExtraTable = new JTable();
    this.jPanel28 = new JPanel();
    this.jLabel54 = new JLabel();
    this.viewTotal2 = new JLabel();
    this.jButton42 = new JButton();
    this.transRoom = new JDialog();
    this.jPanel29 = new JPanel();
    this.roomLabel = new JLabel();
    this.resRoom = new JComboBox();
    this.jButton43 = new JButton();
    this.jSeparator17 = new JSeparator();
    this.jButton46 = new JButton();
    this.showNotif = new JDialog();
    this.jPanel30 = new JPanel();
    this.jButton82 = new JButton();
    this.jButton83 = new JButton();
    this.jScrollPane8 = new JScrollPane();
    this.notifTable = new JTable();
    this.jSeparator18 = new JSeparator();
    this.adjustments = new JDialog();
    this.jPanel31 = new JPanel();
    this.jScrollPane9 = new JScrollPane();
    this.adjustTable = new JTable();
    this.jPanel32 = new JPanel();
    this.jLabel62 = new JLabel();
    this.totalAdj = new JLabel();
    this.jButton5 = new JButton();
    this.jLabel63 = new JLabel();
    this.jLabel64 = new JLabel();
    this.jLabel65 = new JLabel();
    this.jLabel66 = new JLabel();
    this.jButton7 = new JButton();
    this.jButton59 = new JButton();
    this.newAdjust = new JDialog();
    this.jPanel33 = new JPanel();
    this.jLabel68 = new JLabel();
    this.adjDesc = new JTextField();
    this.jLabel69 = new JLabel();
    this.adjAmount = new JFormattedTextField();
    this.jButton50 = new JButton();
    this.jSeparator19 = new JSeparator();
    this.jButton51 = new JButton();
    this.account2 = new JDialog();
    this.jPanel34 = new JPanel();
    this.jButton25 = new JButton();
    this.jButton53 = new JButton();
    this.jPanel35 = new JPanel();
    this.accPaid2 = new JLabel();
    this.balLabel2 = new JLabel();
    this.jButton54 = new JButton();
    this.jButton55 = new JButton();
    this.accBal2 = new JLabel();
    this.accExtra2 = new JLabel();
    this.jLabel72 = new JLabel();
    this.accSales2 = new JLabel();
    this.jLabel73 = new JLabel();
    this.accTotal2 = new JLabel();
    this.accRoom2 = new JLabel();
    this.jLabel74 = new JLabel();
    this.jLabel75 = new JLabel();
    this.jSeparator22 = new JSeparator();
    this.jButton56 = new JButton();
    this.jLabel78 = new JLabel();
    this.accAdj2 = new JLabel();
    this.jButton57 = new JButton();
    this.jPanel36 = new JPanel();
    this.newDateOut = new JXDatePicker();
    this.jLabel80 = new JLabel();
    this.resRoom2 = new JComboBox();
    this.roomLabel2 = new JLabel();
    this.resDays1 = new JSpinner();
    this.jLabel81 = new JLabel();
    this.roomLabel3 = new JLabel();
    this.newRoomRate = new JLabel();
    this.resDisc1 = new JSpinner();
    this.discCheck1 = new JCheckBox();
    this.jLabel76 = new JLabel();
    this.preAdjSign1 = new JButton();
    this.preAdj1 = new JComboBox();
    this.roomLabel4 = new JLabel();
    this.balances = new JDialog();
    this.jPanel37 = new JPanel();
    this.jPanel38 = new JPanel();
    this.jLabel82 = new JLabel();
    this.viewTotal3 = new JLabel();
    this.jScrollPane10 = new JScrollPane();
    this.balancesTable = new JTable();
    this.jButton61 = new JButton();
    this.split = new JSplitPane();
    this.navi = new JPanel();
    naviCur = new JButton();
    naviRes = new JButton();
    naviRoom = new JButton();
    naviGuest = new JButton();
    this.jButton4 = new JButton();
    naviRec = new JButton();
    naviCal = new JButton();
    naviVac = new JButton();
    naviSet = new JButton();
    this.jButton52 = new JButton();
    this.naviHome = new JButton();
    this.currentSplit = new JSplitPane();
    this.occu = new JPanel();
    this.jScrollPane1 = new JScrollPane();
    this.occuTable = new JTable();
    this.jPanel2 = new JPanel();
    this.jLabel58 = new JLabel();
    this.noOccu = new JLabel();
    this.jSeparator1 = new JSeparator();
    this.jButton3 = new JButton();
    this.jButton31 = new JButton();
    this.jButton36 = new JButton();
    this.jButton48 = new JButton();
    this.jButton8 = new JButton();
    this.jButton58 = new JButton();
    this.jPanel1 = new JPanel();
    this.jLabel1 = new JLabel();
    this.filRoom = new JTextField();
    this.jLabel2 = new JLabel();
    this.filGuest = new JTextField();
    this.jLabel3 = new JLabel();
    this.filStat = new JComboBox();
    this.filType = new JComboBox();
    this.jLabel55 = new JLabel();
    this.jLabel56 = new JLabel();
    this.filVent = new JComboBox();
    this.jLabel57 = new JLabel();
    this.filRem = new JTextField();
    this.viewDue = new JToggleButton();
    this.jToolBar1 = new JToolBar();
    this.jMenuBar1 = new JMenuBar();
    this.jMenu1 = new JMenu();
    this.jMenuItem1 = new JMenuItem();
    this.jMenu2 = new JMenu();
    this.jMenuItem2 = new JMenuItem();
    this.jMenuItem3 = new JMenuItem();
    this.jMenuItem4 = new JMenuItem();
    this.jMenuItem5 = new JMenuItem();
    this.jMenuItem6 = new JMenuItem();
    this.jMenu5 = new JMenu();
    this.jMenuItem7 = new JMenuItem();
    this.jMenuItem8 = new JMenuItem();
    this.notifMenu = new JMenu();
    showNot = new JMenuItem();
    this.jMenu4 = new JMenu();
    this.jMenuItem9 = new JMenuItem();
    
    this.vacantTable.setFont(new Font("Tahoma", 0, 18));
    this.vacantTable.setModel(new DefaultTableModel(new Object[0][], new String[] { "Room ID", "Room Type", "Ventilation", "Price", "Extra", "Remarks", "Status" })
    {
      boolean[] canEdit = { false, false, false, false, false, false, false };
      
      public boolean isCellEditable(int rowIndex, int columnIndex)
      {
        return this.canEdit[columnIndex];
      }
    });
    this.vacantTable.setRowHeight(27);
    this.vacantTable.getTableHeader().setReorderingAllowed(false);
    this.jScrollPane2.setViewportView(this.vacantTable);
    
    this.jPanel3.setBorder(BorderFactory.createTitledBorder("Statistics"));
    
    this.noVacant.setForeground(new Color(255, 102, 102));
    
    this.jLabel60.setText("Number of Records:");
    
    GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
    this.jPanel3.setLayout(jPanel3Layout);
    jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel60).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.noVacant, -2, 188, -2).addContainerGap(-1, 32767)));
    







    jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.jLabel60).addGap(0, 0, 32767)).addComponent(this.noVacant, -1, -1, 32767)).addContainerGap()));
    










    this.jButton9.setText("Check In");
    this.jButton9.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Main.this.jButton9ActionPerformed(evt);
      }
    });
    this.jButton10.setText("Go to Room Management");
    this.jButton10.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Main.this.jButton10ActionPerformed(evt);
      }
    });
    GroupLayout vacantLayout = new GroupLayout(this.vacant);
    this.vacant.setLayout(vacantLayout);
    vacantLayout.setHorizontalGroup(vacantLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(vacantLayout.createSequentialGroup().addContainerGap().addGroup(vacantLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane2, -1, 960, 32767).addComponent(this.jSeparator2).addComponent(this.jPanel3, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addGroup(vacantLayout.createSequentialGroup().addComponent(this.jButton9, -2, 164, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton10, -2, 214, -2).addGap(0, 0, 32767))).addContainerGap()));
    













    vacantLayout.setVerticalGroup(vacantLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(vacantLayout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane2, -1, 379, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel3, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jSeparator2, -2, 5, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(vacantLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jButton9, -2, 38, -2).addComponent(this.jButton10, -2, 38, -2)).addContainerGap()));
    














    this.resTable.setFont(new Font("Tahoma", 0, 18));
    this.resTable.setModel(new DefaultTableModel(new Object[0][], new String[] { "Booking ID", "Room", "Guest", "Date In", "Date Out", "Remarks" })
    {
      boolean[] canEdit = { true, false, false, false, false, true };
      
      public boolean isCellEditable(int rowIndex, int columnIndex)
      {
        return this.canEdit[columnIndex];
      }
    });
    this.resTable.setRowHeight(22);
    this.resTable.getTableHeader().setReorderingAllowed(false);
    this.jScrollPane3.setViewportView(this.resTable);
    
    this.jPanel4.setBorder(BorderFactory.createTitledBorder("Statistics"));
    
    this.noRes.setForeground(new Color(255, 102, 102));
    
    this.jLabel59.setText("Number of Records:");
    
    GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
    this.jPanel4.setLayout(jPanel4Layout);
    jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel59).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.noRes, -2, 188, -2).addContainerGap(-1, 32767)));
    







    jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addComponent(this.jLabel59).addGap(0, 0, 32767)).addComponent(this.noRes, -1, -1, 32767)).addContainerGap()));
    










    this.jButton11.setText("Check In");
    this.jButton11.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Main.this.jButton11ActionPerformed(evt);
      }
    });
    this.jButton14.setText("Go to Reservation");
    this.jButton14.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Main.this.jButton14ActionPerformed(evt);
      }
    });
    GroupLayout resLayout = new GroupLayout(this.res);
    this.res.setLayout(resLayout);
    resLayout.setHorizontalGroup(resLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(resLayout.createSequentialGroup().addContainerGap().addGroup(resLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane3, -1, 960, 32767).addComponent(this.jSeparator3).addComponent(this.jPanel4, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addGroup(resLayout.createSequentialGroup().addComponent(this.jButton11, -2, 164, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton14, -2, 177, -2).addGap(0, 0, 32767))).addContainerGap()));
    













    resLayout.setVerticalGroup(resLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(resLayout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane3, -1, 379, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel4, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jSeparator3, -2, 5, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(resLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jButton14, -2, 38, -2).addComponent(this.jButton11, -2, 38, -2)).addContainerGap()));
    














    this.addRes.setTitle("New Check In");
    this.addRes.setMinimumSize(new Dimension(402, 658));
    
    this.jPanel7.setBackground(new Color(51, 0, 153));
    this.jPanel7.setBorder(BorderFactory.createBevelBorder(0));
    
    this.jButton16.setText("Cancel");
    this.jButton16.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Main.this.jButton16ActionPerformed(evt);
      }
    });
    this.jButton17.setText("Check In");
    this.jButton17.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Main.this.jButton17ActionPerformed(evt);
      }
    });
    this.jPanel5.setBackground(new Color(51, 0, 153));
    this.jPanel5.setBorder(BorderFactory.createTitledBorder(null, "Check in Details", 0, 0, null, Color.white));
    
    this.jLabel13.setForeground(new Color(255, 255, 255));
    this.jLabel13.setText("Time");
    
    this.resTime.setFormatterFactory(new DefaultFormatterFactory(new DateFormatter(new SimpleDateFormat("HH:mm"))));
    this.resTime.setText("09:00");
    this.resTime.setEnabled(false);
    this.resTime.addFocusListener(new FocusAdapter()
    {
      public void focusLost(FocusEvent evt)
      {
        Main.this.resTimeFocusLost(evt);
      }
    });
    this.resDateOut.setEnabled(false);
    
    this.jLabel10.setForeground(new Color(255, 255, 255));
    this.jLabel10.setText("Date Out");
    
    this.jLabel8.setForeground(new Color(255, 255, 255));
    this.jLabel8.setText("Date In");
    
    this.resDateIn.setEnabled(false);
    
    this.resDays.setModel(new SpinnerNumberModel(1, 1, 100, 1));
    this.resDays.addChangeListener(new ChangeListener()
    {
      public void stateChanged(ChangeEvent evt)
      {
        Main.this.resDaysStateChanged(evt);
      }
    });
    this.resDays.addFocusListener(new FocusAdapter()
    {
      public void focusLost(FocusEvent evt)
      {
        Main.this.resDaysFocusLost(evt);
      }
    });
    this.jLabel9.setForeground(new Color(255, 255, 255));
    this.jLabel9.setText("Days");
    
    GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
    this.jPanel5.setLayout(jPanel5Layout);
    jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addContainerGap().addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addGap(22, 22, 22).addComponent(this.jLabel13)).addGroup(GroupLayout.Alignment.TRAILING, jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel10).addComponent(this.jLabel9, GroupLayout.Alignment.TRAILING).addComponent(this.jLabel8, GroupLayout.Alignment.TRAILING))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.resDateIn, GroupLayout.Alignment.LEADING, -1, 258, 32767).addComponent(this.resDateOut, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.resTime, GroupLayout.Alignment.LEADING).addComponent(this.resDays, GroupLayout.Alignment.LEADING)).addContainerGap(-1, 32767)));
    


















    jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addContainerGap().addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.resDays).addComponent(this.jLabel9, -2, 31, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.resDateIn, -2, 32, -2).addComponent(this.jLabel8, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED, -1, 32767).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.resDateOut, -2, 32, -2).addComponent(this.jLabel10, -2, 32, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.resTime, -2, 32, -2).addComponent(this.jLabel13, -2, 32, -2)).addContainerGap()));
    




















    this.jPanel6.setBackground(new Color(51, 0, 153));
    this.jPanel6.setBorder(BorderFactory.createTitledBorder(null, "Account Details", 0, 0, null, Color.white));
    
    this.jLabel12.setForeground(new Color(255, 255, 255));
    this.jLabel12.setText("Guest");
    
    this.resGuest.setModel(new DefaultComboBoxModel(new String[] { "Select" }));
    this.resGuest.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Main.this.resGuestActionPerformed(evt);
      }
    });
    this.jButton18.setText("New");
    this.jButton18.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Main.this.jButton18ActionPerformed(evt);
      }
    });
    this.jLabel4.setForeground(new Color(255, 255, 255));
    this.jLabel4.setText("Rate");
    
    this.jLabel7.setForeground(new Color(255, 255, 255));
    this.jLabel7.setText("Discount");
    
    this.discCheck.setBackground(new Color(51, 0, 153));
    this.discCheck.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Main.this.discCheckActionPerformed(evt);
      }
    });
    this.resRate.setEditable(false);
    this.resRate.setBackground(new Color(51, 0, 153));
    this.resRate.setFont(new Font("Tahoma", 0, 14));
    this.resRate.setForeground(new Color(0, 204, 51));
    
    this.resDisc.setModel(new SpinnerNumberModel(Float.valueOf(15.5F), Float.valueOf(0.0F), Float.valueOf(100.0F), Float.valueOf(0.1F)));
    this.resDisc.setEnabled(false);
    this.resDisc.addChangeListener(new ChangeListener()
    {
      public void stateChanged(ChangeEvent evt)
      {
        Main.this.resDiscStateChanged(evt);
      }
    });
    this.jButton22.setText("Add");
    this.jButton22.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Main.this.jButton22ActionPerformed(evt);
      }
    });
    this.resExtra.setEditable(false);
    this.resExtra.setBackground(new Color(51, 0, 153));
    this.resExtra.setFont(new Font("Tahoma", 0, 14));
    this.resExtra.setForeground(new Color(255, 255, 255));
    this.resExtra.setText("0");
    
    this.jLabel5.setForeground(new Color(255, 255, 255));
    this.jLabel5.setText("Extra");
    
    this.jLabel77.setForeground(new Color(255, 255, 255));
    this.jLabel77.setText("Adjust");
    
    this.preAdjSign.setText("+");
    this.preAdjSign.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Main.this.preAdjSignActionPerformed(evt);
      }
    });
    this.preAdj.setModel(new DefaultComboBoxModel(new String[] { "None", "200", "230", "300" }));
    this.preAdj.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Main.this.preAdjActionPerformed(evt);
      }
    });
    this.totalBal.setEditable(false);
    this.totalBal.setBackground(new Color(51, 0, 153));
    this.totalBal.setFont(new Font("Tahoma", 0, 14));
    this.totalBal.setForeground(new Color(255, 255, 255));
    this.totalBal.setText("0");
    
    this.jButton60.setText("View");
    this.jButton60.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Main.this.jButton60ActionPerformed(evt);
      }
    });
    this.jLabel79.setForeground(new Color(255, 255, 255));
    this.jLabel79.setText("Balances");
    
    GroupLayout jPanel6Layout = new GroupLayout(this.jPanel6);
    this.jPanel6.setLayout(jPanel6Layout);
    jPanel6Layout.setHorizontalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addContainerGap().addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addGap(13, 13, 13).addComponent(this.jLabel12)).addComponent(this.jLabel79).addComponent(this.jLabel77, GroupLayout.Alignment.TRAILING)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addComponent(this.preAdjSign).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.preAdj, 0, -1, 32767)).addGroup(GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup().addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.totalBal, GroupLayout.Alignment.LEADING).addComponent(this.resGuest, 0, 199, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jButton18).addComponent(this.jButton60, GroupLayout.Alignment.TRAILING))))).addGroup(jPanel6Layout.createSequentialGroup().addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jLabel4, GroupLayout.Alignment.TRAILING).addComponent(this.jLabel7, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.jLabel5, GroupLayout.Alignment.TRAILING)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup().addComponent(this.resExtra).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton22, -2, 53, -2)).addComponent(this.resRate).addGroup(jPanel6Layout.createSequentialGroup().addComponent(this.discCheck).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.resDisc))))).addContainerGap()));
    










































    jPanel6Layout.setVerticalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addContainerGap().addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.resGuest).addComponent(this.jLabel12, -2, 28, -2).addComponent(this.jButton18, -2, 32, -2)).addGap(12, 12, 12).addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.totalBal, -2, 32, -2).addComponent(this.jButton60, -2, 32, -2).addComponent(this.jLabel79, -2, 28, -2)).addGap(18, 18, 18).addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel7, -2, 32, -2).addComponent(this.discCheck, -2, 32, -2).addComponent(this.resDisc, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jButton22, -1, 32, 32767).addComponent(this.resExtra, -2, 32, -2).addComponent(this.jLabel5, -2, 32, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel4, -2, 32, -2).addComponent(this.resRate, -2, 32, -2)).addGap(6, 6, 6).addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.preAdj, -2, 37, -2).addComponent(this.preAdjSign, -2, 38, -2).addComponent(this.jLabel77, -2, 38, -2)).addContainerGap(-1, 32767)));
    

































    jPanel6Layout.linkSize(1, new Component[] { this.discCheck, this.jLabel7, this.resDisc, this.resExtra, this.resGuest, this.resRate });
    
    GroupLayout jPanel7Layout = new GroupLayout(this.jPanel7);
    this.jPanel7.setLayout(jPanel7Layout);
    jPanel7Layout.setHorizontalGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel7Layout.createSequentialGroup().addContainerGap().addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jSeparator5).addComponent(this.jPanel5, -1, -1, 32767).addComponent(this.jPanel6, -1, -1, 32767).addGroup(jPanel7Layout.createSequentialGroup().addComponent(this.jButton17, -2, 108, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.jButton16, -2, 115, -2))).addContainerGap()));
    












    jPanel7Layout.setVerticalGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel5, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel6, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.jSeparator5, -2, 10, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jButton17, -2, 34, -2).addComponent(this.jButton16)).addContainerGap()));
    














    jPanel7Layout.linkSize(1, new Component[] { this.jButton16, this.jButton17 });
    
    GroupLayout addResLayout = new GroupLayout(this.addRes.getContentPane());
    this.addRes.getContentPane().setLayout(addResLayout);
    addResLayout.setHorizontalGroup(addResLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(addResLayout.createSequentialGroup().addContainerGap().addComponent(this.jPanel7, -2, -1, -2).addContainerGap(-1, 32767)));
    





    addResLayout.setVerticalGroup(addResLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(addResLayout.createSequentialGroup().addContainerGap().addComponent(this.jPanel7, -1, -1, 32767).addContainerGap()));
    






    this.payment.setDefaultCloseOperation(0);
    this.payment.setTitle("Payment");
    this.payment.setMinimumSize(new Dimension(312, 347));
    this.payment.setModal(true);
    this.payment.addWindowListener(new WindowAdapter()
    {
      public void windowClosing(WindowEvent evt)
      {
        Main.this.paymentWindowClosing(evt);
      }
    });
    this.jPanel8.setBackground(new Color(51, 0, 153));
    
    this.jPanel9.setBackground(new Color(51, 0, 153));
    this.jPanel9.setBorder(BorderFactory.createEtchedBorder());
    
    this.jLabel6.setFont(new Font("Tahoma", 0, 18));
    this.jLabel6.setForeground(new Color(255, 255, 255));
    this.jLabel6.setText("Mode:");
    
    this.payAmount.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("####.00"))));
    this.payAmount.setText("0.00");
    this.payAmount.addKeyListener(new KeyAdapter()
    {
      public void keyPressed(KeyEvent evt)
      {
        Main.this.payAmountKeyPressed(evt);
      }
      
      public void keyReleased(KeyEvent evt)
      {
        Main.this.payAmountKeyReleased(evt);
      }
      
      public void keyTyped(KeyEvent evt)
      {
        Main.this.payAmountKeyTyped(evt);
      }
    });
    this.jLabel18.setFont(new Font("Tahoma", 0, 18));
    this.jLabel18.setForeground(new Color(255, 255, 255));
    this.jLabel18.setText("Total Price:");
    
    this.payTotal.setFont(new Font("Tahoma", 0, 18));
    this.payTotal.setForeground(new Color(0, 204, 51));
    
    this.payBalLabel.setFont(new Font("Tahoma", 0, 18));
    this.payBalLabel.setForeground(new Color(255, 102, 102));
    this.payBalLabel.setText("Balance:");
    
    this.payBal.setFont(new Font("Tahoma", 0, 18));
    this.payBal.setForeground(new Color(255, 102, 102));
    
    this.jLabel27.setFont(new Font("Tahoma", 0, 18));
    this.jLabel27.setForeground(new Color(255, 255, 255));
    this.jLabel27.setText("Amount:");
    
    this.payMode.setModel(new DefaultComboBoxModel(new String[] { "Select", "Cash", "Credit Card", "Check" }));
    
    GroupLayout jPanel9Layout = new GroupLayout(this.jPanel9);
    this.jPanel9.setLayout(jPanel9Layout);
    jPanel9Layout.setHorizontalGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel9Layout.createSequentialGroup().addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel9Layout.createSequentialGroup().addGap(31, 31, 31).addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.payBalLabel).addComponent(this.jLabel6).addComponent(this.jLabel27))).addGroup(jPanel9Layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel18))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.payTotal, -1, -1, 32767).addComponent(this.payBal, -1, -1, 32767).addComponent(this.payMode, 0, -1, 32767).addComponent(this.payAmount)).addContainerGap()));
    



















    jPanel9Layout.setVerticalGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel9Layout.createSequentialGroup().addContainerGap().addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.payTotal, -1, 26, 32767).addComponent(this.jLabel18, -1, -1, 32767)).addGap(18, 18, 18).addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel6, -1, -1, 32767).addGroup(jPanel9Layout.createSequentialGroup().addComponent(this.payMode, -2, 29, -2).addGap(4, 4, 4))).addGap(18, 18, 18).addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel27, -1, -1, 32767).addComponent(this.payAmount, GroupLayout.Alignment.TRAILING, -2, 33, -2)).addGap(18, 18, 18).addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.payBal, -1, 22, 32767).addComponent(this.payBalLabel, -1, -1, 32767)).addGap(20, 20, 20)));
    






















    jPanel9Layout.linkSize(1, new Component[] { this.payAmount, this.payBal, this.payMode, this.payTotal });
    
    this.jButton1.setText("Continue");
    this.jButton1.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Main.this.jButton1ActionPerformed(evt);
      }
    });
    this.jButton13.setText("Cancel");
    this.jButton13.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Main.this.jButton13ActionPerformed(evt);
      }
    });
    GroupLayout jPanel8Layout = new GroupLayout(this.jPanel8);
    this.jPanel8.setLayout(jPanel8Layout);
    jPanel8Layout.setHorizontalGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel8Layout.createSequentialGroup().addContainerGap().addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jSeparator4).addComponent(this.jPanel9, -1, -1, 32767).addGroup(jPanel8Layout.createSequentialGroup().addComponent(this.jButton1, -2, 113, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 73, 32767).addComponent(this.jButton13, -2, 105, -2))).addContainerGap()));
    











    jPanel8Layout.setVerticalGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel8Layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel9, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jSeparator4, -2, 10, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jButton1).addComponent(this.jButton13)).addContainerGap(-1, 32767)));
    












    GroupLayout paymentLayout = new GroupLayout(this.payment.getContentPane());
    this.payment.getContentPane().setLayout(paymentLayout);
    paymentLayout.setHorizontalGroup(paymentLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(paymentLayout.createSequentialGroup().addContainerGap().addComponent(this.jPanel8, -1, -1, 32767).addContainerGap()));
    





    paymentLayout.setVerticalGroup(paymentLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(paymentLayout.createSequentialGroup().addContainerGap().addComponent(this.jPanel8, -1, -1, 32767).addContainerGap()));
    






    this.payment.getAccessibleContext().setAccessibleParent(this.addRes);
    
    this.account.setTitle("Guest's Account");
    this.account.setMinimumSize(new Dimension(409, 575));
    this.account.setModal(true);
    
    this.jPanel12.setBackground(new Color(51, 0, 153));
    this.jPanel12.setBorder(BorderFactory.createBevelBorder(0));
    
    this.jButton20.setText("Check Out");
    this.jButton20.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Main.this.jButton20ActionPerformed(evt);
      }
    });
    this.jButton21.setText("Cancel");
    this.jButton21.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Main.this.jButton21ActionPerformed(evt);
      }
    });
    this.jPanel13.setBackground(new Color(51, 0, 153));
    this.jPanel13.setBorder(BorderFactory.createTitledBorder(null, "Guest's Account", 0, 0, null, Color.white));
    
    this.accPaid.setFont(new Font("Tahoma", 0, 18));
    this.accPaid.setForeground(new Color(255, 255, 255));
    
    this.balLabel.setFont(new Font("Tahoma", 0, 18));
    this.balLabel.setForeground(new Color(255, 102, 102));
    this.balLabel.setText("Balance:");
    
    this.jButton15.setText("View");
    this.jButton15.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Main.this.jButton15ActionPerformed(evt);
      }
    });
    this.jButton19.setText("View");
    this.jButton19.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Main.this.jButton19ActionPerformed(evt);
      }
    });
    this.accBal.setFont(new Font("Tahoma", 0, 18));
    this.accBal.setForeground(new Color(255, 102, 102));
    
    this.accExtra.setFont(new Font("Tahoma", 0, 18));
    this.accExtra.setForeground(new Color(255, 255, 255));
    
    this.jLabel21.setFont(new Font("Tahoma", 0, 18));
    this.jLabel21.setForeground(new Color(255, 255, 255));
    this.jLabel21.setText("Sales Account:");
    
    this.accSales.setFont(new Font("Tahoma", 0, 18));
    this.accSales.setForeground(new Color(255, 255, 255));
    this.accSales.setText("0.0");
    this.accSales.setToolTipText("");
    
    this.jLabel20.setFont(new Font("Tahoma", 0, 18));
    this.jLabel20.setForeground(new Color(255, 255, 255));
    this.jLabel20.setText("Extra:");
    
    this.accTotal.setFont(new Font("Tahoma", 0, 18));
    this.accTotal.setForeground(new Color(0, 153, 0));
    
    this.accRoom.setFont(new Font("Tahoma", 0, 18));
    this.accRoom.setForeground(new Color(255, 255, 255));
    
    this.jLabel25.setFont(new Font("Tahoma", 0, 18));
    this.jLabel25.setForeground(new Color(255, 255, 255));
    this.jLabel25.setText("Paid:");
    
    this.jLabel17.setFont(new Font("Tahoma", 0, 18));
    this.jLabel17.setForeground(new Color(255, 255, 255));
    this.jLabel17.setText("Room Price:");
    
    this.jLabel26.setFont(new Font("Tahoma", 0, 18));
    this.jLabel26.setForeground(new Color(255, 255, 255));
    this.jLabel26.setText("Tendered:");
    
    this.accTendered.addKeyListener(new KeyAdapter()
    {
      public void keyPressed(KeyEvent evt)
      {
        Main.this.accTenderedKeyPressed(evt);
      }
      
      public void keyReleased(KeyEvent evt)
      {
        Main.this.accTenderedKeyReleased(evt);
      }
      
      public void keyTyped(KeyEvent evt)
      {
        Main.this.accTenderedKeyTyped(evt);
      }
    });
    this.accMode.setModel(new DefaultComboBoxModel(new String[] { "Cash", "Credit Card", "Check" }));
    
    this.jLabel29.setFont(new Font("Tahoma", 0, 18));
    this.jLabel29.setForeground(new Color(255, 255, 255));
    this.jLabel29.setText("Mode:");
    
    this.jButton45.setText("View");
    this.jButton45.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Main.this.jButton45ActionPerformed(evt);
      }
    });
    this.jLabel61.setFont(new Font("Tahoma", 0, 18));
    this.jLabel61.setForeground(new Color(255, 255, 255));
    this.jLabel61.setText("Adjustments:");
    
    this.accAdj.setFont(new Font("Tahoma", 0, 18));
    this.accAdj.setForeground(new Color(255, 255, 255));
    
    this.jButton47.setText("View");
    this.jButton47.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Main.this.jButton47ActionPerformed(evt);
      }
    });
    GroupLayout jPanel13Layout = new GroupLayout(this.jPanel13);
    this.jPanel13.setLayout(jPanel13Layout);
    jPanel13Layout.setHorizontalGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel13Layout.createSequentialGroup().addContainerGap().addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup().addGap(0, 0, 32767).addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.balLabel, GroupLayout.Alignment.TRAILING).addComponent(this.jLabel26, GroupLayout.Alignment.TRAILING)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.accTendered).addComponent(this.accBal, -1, 197, 32767))).addGroup(jPanel13Layout.createSequentialGroup().addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel21).addComponent(this.jLabel17).addComponent(this.jLabel20).addComponent(this.jLabel25).addComponent(this.jLabel29).addComponent(this.jLabel61)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jSeparator7).addGroup(jPanel13Layout.createSequentialGroup().addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jPanel13Layout.createSequentialGroup().addComponent(this.accPaid, -2, 130, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jButton19)).addComponent(this.accTotal, -1, -1, 32767).addComponent(this.jSeparator6).addComponent(this.accRoom, -1, -1, 32767).addGroup(jPanel13Layout.createSequentialGroup().addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.accExtra, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.accSales, GroupLayout.Alignment.LEADING, -1, 133, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jButton15).addComponent(this.jButton45))).addGroup(jPanel13Layout.createSequentialGroup().addComponent(this.accAdj, -2, 130, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jButton47))).addGap(0, 0, 32767)).addComponent(this.accMode, 0, -1, 32767)))).addContainerGap()));
    

















































    jPanel13Layout.linkSize(0, new Component[] { this.jButton15, this.jButton19 });
    
    jPanel13Layout.setVerticalGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel13Layout.createSequentialGroup().addContainerGap().addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.accRoom, -1, 29, 32767).addComponent(this.jLabel17, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jLabel20, -1, -1, 32767).addComponent(this.accExtra, -1, -1, 32767)).addComponent(this.jButton45, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.accSales, -1, -1, 32767).addComponent(this.jButton15, -1, -1, 32767).addComponent(this.jLabel21, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jSeparator6, -2, 10, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.accTotal, -2, 23, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.accPaid, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.jButton19, -1, -1, 32767).addComponent(this.jLabel25, GroupLayout.Alignment.TRAILING, -2, 29, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.accAdj, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.jButton47, -1, -1, 32767).addComponent(this.jLabel61, GroupLayout.Alignment.TRAILING, -2, 29, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jSeparator7, -2, 10, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.accMode, -2, 33, -2).addComponent(this.jLabel29, -2, 29, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED, -1, 32767).addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.accTendered, -2, 31, -2).addComponent(this.jLabel26, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.balLabel, -1, -1, 32767).addComponent(this.accBal, -1, -1, 32767)).addContainerGap()));
    















































    jPanel13Layout.linkSize(1, new Component[] { this.accExtra, this.accPaid, this.accRoom, this.accSales });
    
    jPanel13Layout.linkSize(1, new Component[] { this.accBal, this.accMode, this.accTendered, this.jLabel29 });
    
    GroupLayout jPanel12Layout = new GroupLayout(this.jPanel12);
    this.jPanel12.setLayout(jPanel12Layout);
    jPanel12Layout.setHorizontalGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel12Layout.createSequentialGroup().addContainerGap().addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jPanel12Layout.createSequentialGroup().addComponent(this.jButton20, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.jButton21, -2, 121, -2)).addComponent(this.jSeparator8).addComponent(this.jPanel13, -1, -1, 32767)).addContainerGap(-1, 32767)));
    











    jPanel12Layout.setVerticalGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel12Layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel13, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jSeparator8, -2, 10, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jButton20, -2, 31, -2).addComponent(this.jButton21, -2, 31, -2)).addContainerGap()));
    












    GroupLayout accountLayout = new GroupLayout(this.account.getContentPane());
    this.account.getContentPane().setLayout(accountLayout);
    accountLayout.setHorizontalGroup(accountLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(accountLayout.createSequentialGroup().addContainerGap().addComponent(this.jPanel12, -1, -1, 32767).addContainerGap()));
    





    accountLayout.setVerticalGroup(accountLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(accountLayout.createSequentialGroup().addContainerGap().addComponent(this.jPanel12, -1, -1, 32767).addContainerGap()));
    






    this.addExtra.setTitle("Add Extra");
    this.addExtra.setMinimumSize(new Dimension(291, 337));
    this.addExtra.setModal(true);
    
    this.jPanel10.setBackground(new Color(51, 0, 153));
    
    this.xDays.setModel(new SpinnerNumberModel(1, 1, 100, 1));
    this.xDays.addChangeListener(new ChangeListener()
    {
      public void stateChanged(ChangeEvent evt)
      {
        Main.this.xDaysStateChanged(evt);
      }
    });
    this.xDays.addFocusListener(new FocusAdapter()
    {
      public void focusLost(FocusEvent evt)
      {
        Main.this.xDaysFocusLost(evt);
      }
    });
    this.xDateIn.setDate(Calendar.getInstance().getTime());
    this.xDateIn.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Main.this.xDateInActionPerformed(evt);
      }
    });
    this.xDateOut.setDate(Calendar.getInstance().getTime());
    this.xDateOut.setEnabled(false);
    
    this.jLabel11.setForeground(new Color(255, 255, 255));
    this.jLabel11.setText("Date Out");
    
    this.jLabel14.setForeground(new Color(255, 255, 255));
    this.jLabel14.setText("Date In");
    
    this.jLabel15.setForeground(new Color(255, 255, 255));
    this.jLabel15.setText("Days");
    
    this.jButton2.setText("Add");
    this.jButton2.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Main.this.jButton2ActionPerformed(evt);
      }
    });
    this.jLabel16.setForeground(new Color(255, 255, 255));
    this.jLabel16.setText("Quantity");
    
    this.xQuan.setModel(new SpinnerNumberModel(1, 1, 10, 1));
    this.xQuan.addChangeListener(new ChangeListener()
    {
      public void stateChanged(ChangeEvent evt)
      {
        Main.this.xQuanStateChanged(evt);
      }
    });
    this.xQuan.addFocusListener(new FocusAdapter()
    {
      public void focusLost(FocusEvent evt)
      {
        Main.this.xQuanFocusLost(evt);
      }
    });
    this.jLabel19.setForeground(new Color(255, 255, 255));
    this.jLabel19.setText("Price");
    
    this.xPrice.setEditable(false);
    this.xPrice.setBackground(new Color(51, 0, 153));
    this.xPrice.setForeground(new Color(0, 204, 51));
    
    this.jButton23.setText("Cancel");
    this.jButton23.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Main.this.jButton23ActionPerformed(evt);
      }
    });
    GroupLayout jPanel10Layout = new GroupLayout(this.jPanel10);
    this.jPanel10.setLayout(jPanel10Layout);
    jPanel10Layout.setHorizontalGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel10Layout.createSequentialGroup().addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel10Layout.createSequentialGroup().addContainerGap().addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jSeparator9, GroupLayout.Alignment.TRAILING).addGroup(jPanel10Layout.createSequentialGroup().addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel19).addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel10Layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 8, -2).addComponent(this.jLabel14)).addComponent(this.jLabel11))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.xDateOut, -1, -1, 32767).addComponent(this.xDateIn, -1, -1, 32767).addComponent(this.xPrice))))).addGroup(jPanel10Layout.createSequentialGroup().addGap(12, 12, 12).addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel15).addComponent(this.jLabel16)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.xDays).addComponent(this.xQuan))).addGroup(jPanel10Layout.createSequentialGroup().addContainerGap().addComponent(this.jButton2, -2, 92, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 63, 32767).addComponent(this.jButton23, -2, 92, -2))).addGap(10, 10, 10)));
    



































    jPanel10Layout.setVerticalGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel10Layout.createSequentialGroup().addGap(12, 12, 12).addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.xQuan).addComponent(this.jLabel16, -2, 31, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.xDays, -2, 31, -2).addComponent(this.jLabel15, -2, 31, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jLabel14, -1, -1, 32767).addComponent(this.xDateIn, -2, 32, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.xDateOut, -2, 32, -2).addComponent(this.jLabel11, -2, 32, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jLabel19, -1, 32, 32767).addComponent(this.xPrice)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED, -1, 32767).addComponent(this.jSeparator9, -2, 10, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jButton2).addComponent(this.jButton23)).addContainerGap()));
    






























    GroupLayout addExtraLayout = new GroupLayout(this.addExtra.getContentPane());
    this.addExtra.getContentPane().setLayout(addExtraLayout);
    addExtraLayout.setHorizontalGroup(addExtraLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(addExtraLayout.createSequentialGroup().addContainerGap().addComponent(this.jPanel10, -2, -1, -2).addContainerGap(12, 32767)));
    





    addExtraLayout.setVerticalGroup(addExtraLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(addExtraLayout.createSequentialGroup().addContainerGap().addComponent(this.jPanel10, -1, -1, 32767).addContainerGap()));
    






    this.addExtra.getAccessibleContext().setAccessibleParent(this.addRes);
    
    this.suggest.setTitle("Vacancy Suggestions");
    this.suggest.setAlwaysOnTop(true);
    this.suggest.setMinimumSize(new Dimension(363, 559));
    
    this.jPanel11.setBackground(new Color(51, 0, 153));
    
    this.jPanel14.setBackground(new Color(51, 0, 153));
    this.jPanel14.setBorder(BorderFactory.createTitledBorder(null, "Filter By", 2, 0, null, Color.white));
    
    this.sugRooms.setModel(new DefaultComboBoxModel(new String[] { "All" }));
    this.sugRooms.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Main.this.sugRoomsActionPerformed(evt);
      }
    });
    this.jLabel22.setForeground(new Color(255, 255, 255));
    this.jLabel22.setText("Room");
    
    this.jLabel23.setForeground(new Color(255, 255, 255));
    this.jLabel23.setText("Date");
    
    this.jLabel24.setForeground(new Color(255, 255, 255));
    this.jLabel24.setText("Days");
    
    this.sugDays.setModel(new SpinnerNumberModel(2, 2, 20, 1));
    this.sugDays.addChangeListener(new ChangeListener()
    {
      public void stateChanged(ChangeEvent evt)
      {
        Main.this.sugDaysStateChanged(evt);
      }
    });
    this.sugCal.setDate(Calendar.getInstance().getTime());
    this.sugCal.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Main.this.sugCalActionPerformed(evt);
      }
    });
    GroupLayout jPanel14Layout = new GroupLayout(this.jPanel14);
    this.jPanel14.setLayout(jPanel14Layout);
    jPanel14Layout.setHorizontalGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel14Layout.createSequentialGroup().addContainerGap().addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel14Layout.createSequentialGroup().addGap(0, 1, 32767).addComponent(this.jLabel22).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.sugRooms, -2, 143, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel24).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.sugDays, -2, 57, -2)).addGroup(jPanel14Layout.createSequentialGroup().addComponent(this.jLabel23).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.sugCal, -1, -1, 32767))).addContainerGap()));
    


















    jPanel14Layout.setVerticalGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup().addContainerGap().addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.sugRooms, -1, 31, 32767).addComponent(this.jLabel22, -1, -1, 32767).addComponent(this.jLabel24, -1, -1, 32767).addComponent(this.sugDays)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel14Layout.createSequentialGroup().addComponent(this.jLabel23, -1, 16, 32767).addContainerGap()).addComponent(this.sugCal, -1, -1, 32767))));
    















    this.jButton24.setText("Close");
    this.jButton24.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Main.this.jButton24ActionPerformed(evt);
      }
    });
    this.jPanel15.setBackground(new Color(51, 0, 153));
    this.jPanel15.setBorder(BorderFactory.createTitledBorder(null, "Vacant Dates", 2, 0, null, Color.white));
    
    this.suggestTable.setFont(new Font("Tahoma", 0, 16));
    this.suggestTable.setModel(new DefaultTableModel(new Object[0][], new String[] { "From", "To" })
    {
      boolean[] canEdit = { false, false };
      
      public boolean isCellEditable(int rowIndex, int columnIndex)
      {
        return this.canEdit[columnIndex];
      }
    });
    this.suggestTable.setRowHeight(20);
    this.suggestTable.getTableHeader().setResizingAllowed(false);
    this.suggestTable.getTableHeader().setReorderingAllowed(false);
    this.jScrollPane4.setViewportView(this.suggestTable);
    
    GroupLayout jPanel15Layout = new GroupLayout(this.jPanel15);
    this.jPanel15.setLayout(jPanel15Layout);
    jPanel15Layout.setHorizontalGroup(jPanel15Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel15Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane4, -2, 0, 32767).addContainerGap()));
    





    jPanel15Layout.setVerticalGroup(jPanel15Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel15Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane4, -1, 300, 32767).addContainerGap()));
    






    GroupLayout jPanel11Layout = new GroupLayout(this.jPanel11);
    this.jPanel11.setLayout(jPanel11Layout);
    jPanel11Layout.setHorizontalGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel11Layout.createSequentialGroup().addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup().addContainerGap().addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel14, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.jSeparator10, GroupLayout.Alignment.TRAILING))).addGroup(jPanel11Layout.createSequentialGroup().addGap(101, 101, 101).addComponent(this.jButton24, -2, 108, -2).addGap(0, 0, 32767)).addGroup(jPanel11Layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel15, -1, -1, 32767))).addContainerGap()));
    
















    jPanel11Layout.setVerticalGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel11Layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel14, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel15, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jSeparator10, -2, 10, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton24, -2, 28, -2).addContainerGap()));
    












    GroupLayout suggestLayout = new GroupLayout(this.suggest.getContentPane());
    this.suggest.getContentPane().setLayout(suggestLayout);
    suggestLayout.setHorizontalGroup(suggestLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(suggestLayout.createSequentialGroup().addContainerGap().addComponent(this.jPanel11, -1, -1, 32767).addContainerGap()));
    





    suggestLayout.setVerticalGroup(suggestLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(suggestLayout.createSequentialGroup().addContainerGap().addComponent(this.jPanel11, -1, -1, 32767).addContainerGap()));
    






    this.viewPayment.setTitle("View Payments");
    this.viewPayment.setMinimumSize(new Dimension(417, 352));
    this.viewPayment.setModal(true);
    
    this.jPanel16.setBackground(new Color(51, 0, 153));
    
    this.viewPayTable.setFont(new Font("Tahoma", 0, 12));
    this.viewPayTable.setModel(new DefaultTableModel(new Object[0][], new String[] { "PayID", "Mode", "Date Paid", "Amount" })
    {
      boolean[] canEdit = { false, false, false, false };
      
      public boolean isCellEditable(int rowIndex, int columnIndex)
      {
        return this.canEdit[columnIndex];
      }
    });
    this.viewPayTable.setRowHeight(20);
    this.viewPayTable.getTableHeader().setResizingAllowed(false);
    this.viewPayTable.getTableHeader().setReorderingAllowed(false);
    this.jScrollPane5.setViewportView(this.viewPayTable);
    
    this.jPanel17.setBackground(new Color(51, 0, 153));
    this.jPanel17.setBorder(BorderFactory.createTitledBorder(null, "Statistics", 0, 0, null, Color.white));
    
    this.jLabel28.setForeground(new Color(255, 255, 255));
    this.jLabel28.setText("Total:");
    
    this.viewTotal.setForeground(new Color(255, 102, 102));
    this.viewTotal.setText("0");
    
    GroupLayout jPanel17Layout = new GroupLayout(this.jPanel17);
    this.jPanel17.setLayout(jPanel17Layout);
    jPanel17Layout.setHorizontalGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel17Layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel28).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.viewTotal, -2, 169, -2).addContainerGap(-1, 32767)));
    




    



    jPanel17Layout.setVerticalGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup().addContainerGap().addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel28, -1, 19, 32767).addComponent(this.viewTotal, -1, -1, 32767)).addContainerGap()));
    








    this.jButton26.setText("Close");
    this.jButton26.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Main.this.jButton26ActionPerformed(evt);
      }
    });
    this.jButton12.setBackground(new Color(255, 0, 0));
    this.jButton12.setForeground(new Color(255, 255, 255));
    this.jButton12.setText("Delete");
    this.jButton12.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Main.this.jButton12ActionPerformed(evt);
      }
    });
    GroupLayout jPanel16Layout = new GroupLayout(this.jPanel16);
    this.jPanel16.setLayout(jPanel16Layout);
    jPanel16Layout.setHorizontalGroup(jPanel16Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel16Layout.createSequentialGroup().addContainerGap().addGroup(jPanel16Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane5, -1, 377, 32767).addComponent(this.jPanel17, -1, -1, 32767).addGroup(jPanel16Layout.createSequentialGroup().addComponent(this.jButton26, -2, 91, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.jButton12, -2, 124, -2))).addContainerGap()));
    











    jPanel16Layout.setVerticalGroup(jPanel16Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel16Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane5, -1, 237, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel17, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel16Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jButton26, -1, 31, 32767).addComponent(this.jButton12, -1, -1, 32767)).addContainerGap()));
    












    GroupLayout viewPaymentLayout = new GroupLayout(this.viewPayment.getContentPane());
    this.viewPayment.getContentPane().setLayout(viewPaymentLayout);
    viewPaymentLayout.setHorizontalGroup(viewPaymentLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(viewPaymentLayout.createSequentialGroup().addContainerGap().addComponent(this.jPanel16, -1, -1, 32767).addContainerGap()));
    





    viewPaymentLayout.setVerticalGroup(viewPaymentLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(viewPaymentLayout.createSequentialGroup().addContainerGap().addComponent(this.jPanel16, -1, -1, 32767).addContainerGap()));
    






    this.viewPayment.getAccessibleContext().setAccessibleParent(this.account);
    
    this.account1.setTitle("Guest's Account");
    this.account1.setMinimumSize(new Dimension(409, 560));
    this.account1.setModal(true);
    
    this.jPanel18.setBackground(new Color(51, 0, 153));
    this.jPanel18.setBorder(BorderFactory.createBevelBorder(0));
    
    this.jButton27.setText("Pay");
    this.jButton27.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Main.this.jButton27ActionPerformed(evt);
      }
    });
    this.jButton28.setText("Close");
    this.jButton28.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Main.this.jButton28ActionPerformed(evt);
      }
    });
    this.jPanel19.setBackground(new Color(51, 0, 153));
    this.jPanel19.setBorder(BorderFactory.createTitledBorder(null, "Guest's Account", 0, 0, null, Color.white));
    
    this.accPaid1.setFont(new Font("Tahoma", 0, 18));
    this.accPaid1.setForeground(new Color(255, 255, 255));
    
    this.balLabel1.setFont(new Font("Tahoma", 0, 18));
    this.balLabel1.setForeground(new Color(255, 102, 102));
    this.balLabel1.setText("Balance:");
    
    this.jButton29.setText("View");
    this.jButton29.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Main.this.jButton29ActionPerformed(evt);
      }
    });
    this.jButton30.setText("View");
    this.jButton30.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Main.this.jButton30ActionPerformed(evt);
      }
    });
    this.accBal1.setFont(new Font("Tahoma", 0, 18));
    this.accBal1.setForeground(new Color(255, 102, 102));
    
    this.accExtra1.setFont(new Font("Tahoma", 0, 18));
    this.accExtra1.setForeground(new Color(255, 255, 255));
    
    this.jLabel30.setFont(new Font("Tahoma", 0, 18));
    this.jLabel30.setForeground(new Color(255, 255, 255));
    this.jLabel30.setText("Sales Account:");
    
    this.accSales1.setFont(new Font("Tahoma", 0, 18));
    this.accSales1.setForeground(new Color(255, 255, 255));
    this.accSales1.setToolTipText("");
    
    this.jLabel31.setFont(new Font("Tahoma", 0, 18));
    this.jLabel31.setForeground(new Color(255, 255, 255));
    this.jLabel31.setText("Extra:");
    
    this.accTotal1.setFont(new Font("Tahoma", 0, 18));
    this.accTotal1.setForeground(new Color(0, 153, 0));
    
    this.accRoom1.setFont(new Font("Tahoma", 0, 18));
    this.accRoom1.setForeground(new Color(255, 255, 255));
    
    this.jLabel32.setFont(new Font("Tahoma", 0, 18));
    this.jLabel32.setForeground(new Color(255, 255, 255));
    this.jLabel32.setText("Paid:");
    
    this.jLabel33.setFont(new Font("Tahoma", 0, 18));
    this.jLabel33.setForeground(new Color(255, 255, 255));
    this.jLabel33.setText("Room Price:");
    
    this.jLabel34.setFont(new Font("Tahoma", 0, 18));
    this.jLabel34.setForeground(new Color(255, 255, 255));
    this.jLabel34.setText("Tendered:");
    
    this.accTendered1.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Main.this.accTendered1ActionPerformed(evt);
      }
    });
    this.accTendered1.addKeyListener(new KeyAdapter()
    {
      public void keyPressed(KeyEvent evt)
      {
        Main.this.accTendered1KeyPressed(evt);
      }
      
      public void keyReleased(KeyEvent evt)
      {
        Main.this.accTendered1KeyReleased(evt);
      }
      
      public void keyTyped(KeyEvent evt)
      {
        Main.this.accTendered1KeyTyped(evt);
      }
    });
    this.accMode1.setModel(new DefaultComboBoxModel(new String[] { "Cash", "Credit Card", "Check" }));
    
    this.jLabel35.setFont(new Font("Tahoma", 0, 18));
    this.jLabel35.setForeground(new Color(255, 255, 255));
    this.jLabel35.setText("Mode:");
    
    this.jButton44.setText("View");
    this.jButton44.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Main.this.jButton44ActionPerformed(evt);
      }
    });
    this.accAdj1.setFont(new Font("Tahoma", 0, 18));
    this.accAdj1.setForeground(new Color(255, 255, 255));
    
    this.jLabel67.setFont(new Font("Tahoma", 0, 18));
    this.jLabel67.setForeground(new Color(255, 255, 255));
    this.jLabel67.setText("Adjustments:");
    
    this.jButton49.setText("View");
    this.jButton49.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Main.this.jButton49ActionPerformed(evt);
      }
    });
    GroupLayout jPanel19Layout = new GroupLayout(this.jPanel19);
    this.jPanel19.setLayout(jPanel19Layout);
    jPanel19Layout.setHorizontalGroup(jPanel19Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel19Layout.createSequentialGroup().addContainerGap().addGroup(jPanel19Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup().addGap(0, 0, 32767).addGroup(jPanel19Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.balLabel1, GroupLayout.Alignment.TRAILING).addComponent(this.jLabel34, GroupLayout.Alignment.TRAILING)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel19Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.accTendered1).addComponent(this.accBal1, -1, 197, 32767))).addGroup(jPanel19Layout.createSequentialGroup().addGroup(jPanel19Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel30).addComponent(this.jLabel33).addComponent(this.jLabel31).addComponent(this.jLabel32).addComponent(this.jLabel35).addComponent(this.jLabel67)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel19Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jSeparator12).addGroup(jPanel19Layout.createSequentialGroup().addGroup(jPanel19Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jPanel19Layout.createSequentialGroup().addComponent(this.accPaid1, -2, 130, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jButton30)).addComponent(this.accTotal1, -1, -1, 32767).addComponent(this.jSeparator13).addComponent(this.accRoom1, -1, -1, 32767).addGroup(jPanel19Layout.createSequentialGroup().addGroup(jPanel19Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.accExtra1, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.accSales1, GroupLayout.Alignment.LEADING, -1, 133, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel19Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jButton29).addComponent(this.jButton44))).addGroup(jPanel19Layout.createSequentialGroup().addComponent(this.accAdj1, -2, 130, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jButton49))).addGap(0, 0, 32767)).addComponent(this.accMode1, 0, -1, 32767)))).addContainerGap()));
    
















































    jPanel19Layout.setVerticalGroup(jPanel19Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel19Layout.createSequentialGroup().addContainerGap().addGroup(jPanel19Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.accRoom1, -1, 29, 32767).addComponent(this.jLabel33, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel19Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jLabel31, -1, -1, 32767).addComponent(this.accExtra1, -1, -1, 32767).addComponent(this.jButton44, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel19Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.accSales1, -1, -1, 32767).addComponent(this.jButton29, -1, -1, 32767).addComponent(this.jLabel30, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jSeparator13, -2, 10, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.accTotal1, -2, 23, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel19Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.accPaid1, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.jButton30, -1, -1, 32767).addComponent(this.jLabel32, GroupLayout.Alignment.TRAILING, -2, 29, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel19Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.accAdj1, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.jButton49, -1, -1, 32767).addComponent(this.jLabel67, GroupLayout.Alignment.TRAILING, -2, 29, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jSeparator12, -2, 10, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel19Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.accMode1, -2, 33, -2).addComponent(this.jLabel35, -2, 29, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED, -1, 32767).addGroup(jPanel19Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.accTendered1, -2, 31, -2).addComponent(this.jLabel34, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel19Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.balLabel1, -1, -1, 32767).addComponent(this.accBal1, -1, -1, 32767)).addContainerGap()));
    














































    this.jButton6.setText("Print Guest Folio");
    this.jButton6.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Main.this.jButton6ActionPerformed(evt);
      }
    });
    GroupLayout jPanel18Layout = new GroupLayout(this.jPanel18);
    this.jPanel18.setLayout(jPanel18Layout);
    jPanel18Layout.setHorizontalGroup(jPanel18Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel18Layout.createSequentialGroup().addContainerGap().addGroup(jPanel18Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jPanel18Layout.createSequentialGroup().addComponent(this.jButton27, -2, 88, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton6).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.jButton28, -2, 94, -2)).addComponent(this.jSeparator11).addComponent(this.jPanel19, -1, -1, 32767)).addContainerGap(-1, 32767)));
    













    jPanel18Layout.setVerticalGroup(jPanel18Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel18Layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel19, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jSeparator11, -2, 10, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel18Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jButton6, -1, -1, 32767).addComponent(this.jButton28, -1, -1, 32767).addComponent(this.jButton27, -1, -1, 32767)).addContainerGap()));
    













    GroupLayout account1Layout = new GroupLayout(this.account1.getContentPane());
    this.account1.getContentPane().setLayout(account1Layout);
    account1Layout.setHorizontalGroup(account1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(account1Layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel18, -1, -1, 32767).addContainerGap()));
    





    account1Layout.setVerticalGroup(account1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(account1Layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel18, -1, -1, 32767).addContainerGap()));
    






    this.newGuest.setTitle("Add New Guest");
    this.newGuest.setMinimumSize(new Dimension(335, 487));
    this.newGuest.setModal(true);
    
    this.jPanel22.setBackground(new Color(51, 0, 153));
    
    this.jPanel23.setBackground(new Color(51, 0, 153));
    this.jPanel23.setBorder(BorderFactory.createTitledBorder(null, "Personal Information", 0, 0, null, Color.white));
    
    this.jLabel37.setForeground(new Color(255, 255, 255));
    this.jLabel37.setText("First Name");
    
    this.jLabel38.setForeground(new Color(255, 255, 255));
    this.jLabel38.setText("Last Name");
    
    GroupLayout jPanel23Layout = new GroupLayout(this.jPanel23);
    this.jPanel23.setLayout(jPanel23Layout);
    jPanel23Layout.setHorizontalGroup(jPanel23Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel23Layout.createSequentialGroup().addContainerGap().addGroup(jPanel23Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel23Layout.createSequentialGroup().addComponent(this.jLabel37).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.fname)).addGroup(GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup().addComponent(this.jLabel38).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.lname))).addContainerGap()));
    













    jPanel23Layout.setVerticalGroup(jPanel23Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel23Layout.createSequentialGroup().addContainerGap().addGroup(jPanel23Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel37, -2, 29, -2).addComponent(this.fname, -1, 32, 32767)).addGap(18, 18, 18).addGroup(jPanel23Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel38, -2, 29, -2).addComponent(this.lname, -1, 32, 32767)).addContainerGap()));
    












    this.jLabel39.setForeground(new Color(255, 255, 255));
    this.jLabel39.setText("GuestID");
    
    this.jPanel24.setBackground(new Color(51, 0, 153));
    this.jPanel24.setBorder(BorderFactory.createTitledBorder(null, "Contact/Address", 0, 0, null, Color.white));
    
    this.jLabel40.setForeground(new Color(255, 255, 255));
    this.jLabel40.setText("Contact #");
    
    this.jLabel41.setForeground(new Color(255, 255, 255));
    this.jLabel41.setText("Address");
    
    GroupLayout jPanel24Layout = new GroupLayout(this.jPanel24);
    this.jPanel24.setLayout(jPanel24Layout);
    jPanel24Layout.setHorizontalGroup(jPanel24Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel24Layout.createSequentialGroup().addContainerGap().addGroup(jPanel24Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel40).addComponent(this.jLabel41)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel24Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.add).addComponent(this.cont)).addContainerGap()));
    











    jPanel24Layout.setVerticalGroup(jPanel24Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel24Layout.createSequentialGroup().addContainerGap().addGroup(jPanel24Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel40, -2, 29, -2).addComponent(this.cont, -1, 32, 32767)).addGap(18, 18, 18).addGroup(jPanel24Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel41, -2, 29, -2).addComponent(this.add, -1, 32, 32767)).addContainerGap()));
    












    this.jLabel42.setForeground(new Color(255, 255, 255));
    this.jLabel42.setText("Remarks");
    
    this.jButton33.setText("Save");
    this.jButton33.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Main.this.jButton33ActionPerformed(evt);
      }
    });
    this.jButton34.setText("Cancel");
    this.jButton34.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Main.this.jButton34ActionPerformed(evt);
      }
    });
    GroupLayout jPanel22Layout = new GroupLayout(this.jPanel22);
    this.jPanel22.setLayout(jPanel22Layout);
    jPanel22Layout.setHorizontalGroup(jPanel22Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel22Layout.createSequentialGroup().addContainerGap().addGroup(jPanel22Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jSeparator14).addComponent(this.jPanel23, -1, -1, 32767).addComponent(this.jPanel24, -1, -1, 32767).addGroup(jPanel22Layout.createSequentialGroup().addComponent(this.jButton33, -2, 106, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.jButton34, -2, 106, -2)).addGroup(jPanel22Layout.createSequentialGroup().addGroup(jPanel22Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel22Layout.createSequentialGroup().addComponent(this.jLabel39).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.guestID, -2, 228, -2)).addGroup(jPanel22Layout.createSequentialGroup().addComponent(this.jLabel42).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.rem, -2, 228, -2))).addGap(0, 0, 32767))).addContainerGap()));
    























    jPanel22Layout.setVerticalGroup(jPanel22Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel22Layout.createSequentialGroup().addContainerGap().addGroup(jPanel22Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.guestID, -1, 32, 32767).addComponent(this.jLabel39, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel23, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel24, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel22Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.rem).addComponent(this.jLabel42, -2, 32, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jSeparator14, -2, 10, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel22Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jButton33, -2, 33, -2).addComponent(this.jButton34, -2, 33, -2)).addContainerGap(-1, 32767)));
    






















    GroupLayout newGuestLayout = new GroupLayout(this.newGuest.getContentPane());
    this.newGuest.getContentPane().setLayout(newGuestLayout);
    newGuestLayout.setHorizontalGroup(newGuestLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(newGuestLayout.createSequentialGroup().addContainerGap().addComponent(this.jPanel22, -1, -1, 32767).addContainerGap()));
    





    newGuestLayout.setVerticalGroup(newGuestLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(newGuestLayout.createSequentialGroup().addContainerGap().addComponent(this.jPanel22, -1, -1, 32767).addContainerGap()));
    






    this.newGuest.getAccessibleContext().setAccessibleParent(this.addRes);
    
    this.viewSales.setTitle("View Sales");
    this.viewSales.setMinimumSize(new Dimension(572, 352));
    this.viewSales.setModal(true);
    
    this.jPanel20.setBackground(new Color(51, 0, 153));
    
    this.viewSaleTable.setFont(new Font("Tahoma", 0, 12));
    this.viewSaleTable.setModel(new DefaultTableModel(new Object[0][], new String[] { "Date", "Item", "Quantity", "Price", "Amount" })
    {
      boolean[] canEdit = { false, false, false, false, false };
      
      public boolean isCellEditable(int rowIndex, int columnIndex)
      {
        return this.canEdit[columnIndex];
      }
    });
    this.viewSaleTable.setRowHeight(20);
    this.viewSaleTable.getTableHeader().setResizingAllowed(false);
    this.viewSaleTable.getTableHeader().setReorderingAllowed(false);
    this.jScrollPane6.setViewportView(this.viewSaleTable);
    
    this.jPanel21.setBackground(new Color(51, 0, 153));
    this.jPanel21.setBorder(BorderFactory.createTitledBorder(null, "Statistics", 0, 0, null, Color.white));
    
    this.jLabel36.setForeground(new Color(255, 255, 255));
    this.jLabel36.setText("Balance:");
    
    this.viewUnpaid1.setForeground(new Color(255, 102, 102));
    this.viewUnpaid1.setText("0");
    
    this.viewPaid1.setForeground(new Color(255, 102, 102));
    this.viewPaid1.setText("0");
    
    this.jLabel70.setForeground(new Color(255, 255, 255));
    this.jLabel70.setText("Total paid:");
    
    this.jLabel71.setForeground(new Color(255, 255, 255));
    this.jLabel71.setText("Total Amount:");
    
    this.viewTotal1.setForeground(new Color(255, 102, 102));
    this.viewTotal1.setText("0");
    
    GroupLayout jPanel21Layout = new GroupLayout(this.jPanel21);
    this.jPanel21.setLayout(jPanel21Layout);
    jPanel21Layout.setHorizontalGroup(jPanel21Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel21Layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel71).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.viewTotal1, -2, 69, -2).addGap(18, 18, 18).addComponent(this.jLabel70, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.viewPaid1, -2, 88, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jLabel36).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.viewUnpaid1, -2, 89, -2).addContainerGap()));
    















    jPanel21Layout.setVerticalGroup(jPanel21Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup().addContainerGap().addGroup(jPanel21Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel21Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.viewPaid1, -1, -1, 32767).addComponent(this.viewUnpaid1, -1, -1, 32767).addComponent(this.jLabel36, -2, 19, -2)).addGroup(jPanel21Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.viewTotal1, -1, -1, 32767).addComponent(this.jLabel71, -2, 19, -2).addComponent(this.jLabel70, -1, -1, 32767))).addContainerGap()));
    














    this.jButton32.setText("Close");
    this.jButton32.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Main.this.jButton32ActionPerformed(evt);
      }
    });
    this.jButton35.setText("Print");
    this.jButton35.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Main.this.jButton35ActionPerformed(evt);
      }
    });
    GroupLayout jPanel20Layout = new GroupLayout(this.jPanel20);
    this.jPanel20.setLayout(jPanel20Layout);
    jPanel20Layout.setHorizontalGroup(jPanel20Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel20Layout.createSequentialGroup().addContainerGap().addGroup(jPanel20Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane6, -1, 490, 32767).addComponent(this.jPanel21, -1, -1, 32767).addGroup(GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup().addComponent(this.jButton35, -2, 130, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.jButton32, -2, 130, -2))).addContainerGap()));
    











    jPanel20Layout.setVerticalGroup(jPanel20Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel20Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane6, -1, 212, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel21, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel20Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jButton32, -1, 31, 32767).addComponent(this.jButton35, -1, -1, 32767)).addContainerGap()));
    












    GroupLayout viewSalesLayout = new GroupLayout(this.viewSales.getContentPane());
    this.viewSales.getContentPane().setLayout(viewSalesLayout);
    viewSalesLayout.setHorizontalGroup(viewSalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(viewSalesLayout.createSequentialGroup().addContainerGap().addComponent(this.jPanel20, -1, -1, 32767).addContainerGap()));
    





    viewSalesLayout.setVerticalGroup(viewSalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(viewSalesLayout.createSequentialGroup().addContainerGap().addComponent(this.jPanel20, -1, -1, 32767).addContainerGap()));
    






    this.extend.setTitle("Extend");
    this.extend.setMinimumSize(new Dimension(310, 419));
    this.extend.setModal(true);
    this.extend.setResizable(false);
    
    this.jPanel25.setBackground(new Color(51, 0, 153));
    
    this.jLabel43.setForeground(new Color(255, 255, 255));
    this.jLabel43.setText("Current Check Out:");
    
    this.jLabel44.setForeground(new Color(255, 255, 255));
    this.jLabel44.setText("Days to extend:");
    
    this.exDays.setModel(new SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
    this.exDays.addChangeListener(new ChangeListener()
    {
      public void stateChanged(ChangeEvent evt)
      {
        Main.this.exDaysStateChanged(evt);
      }
    });
    this.exCurOut.setEnabled(false);
    
    this.jLabel45.setForeground(new Color(255, 255, 255));
    this.jLabel45.setText("New Check Out:");
    
    this.exNewOut.setEnabled(false);
    
    this.jLabel47.setForeground(new Color(255, 255, 255));
    this.jLabel47.setText("Discount");
    
    this.exDisc.setModel(new SpinnerNumberModel(Float.valueOf(13.5F), Float.valueOf(0.0F), Float.valueOf(100.0F), Float.valueOf(0.1F)));
    this.exDisc.setEnabled(false);
    this.exDisc.addChangeListener(new ChangeListener()
    {
      public void stateChanged(ChangeEvent evt)
      {
        Main.this.exDiscStateChanged(evt);
      }
    });
    this.exExtra.setEditable(false);
    this.exExtra.setBackground(new Color(51, 0, 153));
    this.exExtra.setFont(new Font("Tahoma", 0, 14));
    this.exExtra.setForeground(new Color(255, 255, 255));
    this.exExtra.setText("0");
    
    this.jLabel48.setForeground(new Color(255, 255, 255));
    this.jLabel48.setText("Extended Extra");
    
    this.jButton37.setText("Add");
    this.jButton37.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Main.this.jButton37ActionPerformed(evt);
      }
    });
    this.exRate.setEditable(false);
    this.exRate.setBackground(new Color(51, 0, 153));
    this.exRate.setFont(new Font("Tahoma", 0, 14));
    this.exRate.setForeground(new Color(0, 204, 51));
    
    this.jLabel49.setForeground(new Color(255, 255, 255));
    this.jLabel49.setText("Additional Rate");
    
    this.jButton38.setText("Extend");
    this.jButton38.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Main.this.jButton38ActionPerformed(evt);
      }
    });
    this.jButton39.setText("Cancel");
    this.jButton39.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Main.this.jButton39ActionPerformed(evt);
      }
    });
    GroupLayout jPanel25Layout = new GroupLayout(this.jPanel25);
    this.jPanel25.setLayout(jPanel25Layout);
    jPanel25Layout.setHorizontalGroup(jPanel25Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel25Layout.createSequentialGroup().addContainerGap().addGroup(jPanel25Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jSeparator15).addGroup(jPanel25Layout.createSequentialGroup().addGroup(jPanel25Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel25Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel25Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel44).addComponent(this.jLabel43).addComponent(this.jLabel45)).addComponent(this.jLabel48, GroupLayout.Alignment.TRAILING)).addComponent(this.jLabel49).addComponent(this.jLabel47)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel25Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.exRate).addComponent(this.exNewOut, -1, -1, 32767).addComponent(this.exCurOut, -1, -1, 32767).addComponent(this.exDays).addGroup(jPanel25Layout.createSequentialGroup().addComponent(this.exExtra, -2, 112, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton37, -2, 53, -2).addGap(0, 1, 32767)).addComponent(this.exDisc, GroupLayout.Alignment.TRAILING))).addGroup(jPanel25Layout.createSequentialGroup().addComponent(this.jButton38, -2, 118, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.jButton39, -2, 118, -2))).addContainerGap()));
    
































    jPanel25Layout.setVerticalGroup(jPanel25Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel25Layout.createSequentialGroup().addContainerGap().addGroup(jPanel25Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jLabel43, -1, -1, 32767).addComponent(this.exCurOut, -1, -1, 32767)).addGap(18, 18, 18).addGroup(jPanel25Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel44, -2, 28, -2).addComponent(this.exDays, -2, 28, -2)).addGap(18, 18, 18).addGroup(jPanel25Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.exNewOut, -2, -1, -2).addComponent(this.jLabel45, -1, -1, 32767)).addGap(18, 18, 18).addGroup(jPanel25Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.exDisc, -2, 32, -2).addComponent(this.jLabel47, -2, 32, -2)).addGap(18, 18, 18).addGroup(jPanel25Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jButton37, GroupLayout.Alignment.TRAILING, -2, 33, -2).addGroup(jPanel25Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.exExtra, -2, 32, -2).addComponent(this.jLabel48, -2, 32, -2))).addGap(18, 18, 18).addGroup(jPanel25Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.exRate, -2, 32, -2).addComponent(this.jLabel49, -2, 32, -2)).addGap(18, 18, 18).addComponent(this.jSeparator15, -2, 10, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel25Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jButton38, -2, 32, -2).addComponent(this.jButton39, -2, 32, -2)).addContainerGap()));
    




































    jPanel25Layout.linkSize(1, new Component[] { this.jLabel43, this.jLabel44 });
    
    jPanel25Layout.linkSize(1, new Component[] { this.exCurOut, this.exDays, this.exDisc, this.exNewOut });
    
    GroupLayout extendLayout = new GroupLayout(this.extend.getContentPane());
    this.extend.getContentPane().setLayout(extendLayout);
    extendLayout.setHorizontalGroup(extendLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(extendLayout.createSequentialGroup().addContainerGap().addComponent(this.jPanel25, -1, -1, 32767).addContainerGap()));
    





    extendLayout.setVerticalGroup(extendLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(extendLayout.createSequentialGroup().addContainerGap().addComponent(this.jPanel25, -1, -1, 32767).addContainerGap()));
    






    this.addExtra1.setTitle("Add Extra");
    this.addExtra1.setMinimumSize(new Dimension(291, 337));
    this.addExtra1.setModal(true);
    this.addExtra1.setResizable(false);
    
    this.jPanel26.setBackground(new Color(51, 0, 153));
    
    this.xDays1.setModel(new SpinnerNumberModel(1, 1, 100, 1));
    this.xDays1.addChangeListener(new ChangeListener()
    {
      public void stateChanged(ChangeEvent evt)
      {
        Main.this.xDays1StateChanged(evt);
      }
    });
    this.xDays1.addFocusListener(new FocusAdapter()
    {
      public void focusLost(FocusEvent evt)
      {
        Main.this.xDays1FocusLost(evt);
      }
    });
    this.xDateIn1.setDate(Calendar.getInstance().getTime());
    this.xDateIn1.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Main.this.xDateIn1ActionPerformed(evt);
      }
    });
    this.xDateOut1.setDate(Calendar.getInstance().getTime());
    this.xDateOut1.setEnabled(false);
    
    this.jLabel46.setForeground(new Color(255, 255, 255));
    this.jLabel46.setText("Date Out");
    
    this.jLabel50.setForeground(new Color(255, 255, 255));
    this.jLabel50.setText("Date In");
    
    this.jLabel51.setForeground(new Color(255, 255, 255));
    this.jLabel51.setText("Days");
    
    this.jButton40.setText("Add");
    this.jButton40.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Main.this.jButton40ActionPerformed(evt);
      }
    });
    this.jLabel52.setForeground(new Color(255, 255, 255));
    this.jLabel52.setText("Quantity");
    
    this.xQuan1.setModel(new SpinnerNumberModel(1, 1, 10, 1));
    this.xQuan1.addChangeListener(new ChangeListener()
    {
      public void stateChanged(ChangeEvent evt)
      {
        Main.this.xQuan1StateChanged(evt);
      }
    });
    this.xQuan1.addFocusListener(new FocusAdapter()
    {
      public void focusLost(FocusEvent evt)
      {
        Main.this.xQuan1FocusLost(evt);
      }
    });
    this.jLabel53.setForeground(new Color(255, 255, 255));
    this.jLabel53.setText("Price");
    
    this.xPrice1.setEditable(false);
    this.xPrice1.setBackground(new Color(51, 0, 153));
    this.xPrice1.setForeground(new Color(0, 204, 51));
    
    this.jButton41.setText("Cancel");
    this.jButton41.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Main.this.jButton41ActionPerformed(evt);
      }
    });
    GroupLayout jPanel26Layout = new GroupLayout(this.jPanel26);
    this.jPanel26.setLayout(jPanel26Layout);
    jPanel26Layout.setHorizontalGroup(jPanel26Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel26Layout.createSequentialGroup().addGroup(jPanel26Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel26Layout.createSequentialGroup().addContainerGap().addGroup(jPanel26Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jSeparator16, GroupLayout.Alignment.TRAILING).addGroup(jPanel26Layout.createSequentialGroup().addGroup(jPanel26Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel53).addGroup(jPanel26Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel26Layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 8, -2).addComponent(this.jLabel50)).addComponent(this.jLabel46))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel26Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.xDateOut1, -1, -1, 32767).addComponent(this.xDateIn1, -1, -1, 32767).addComponent(this.xPrice1))))).addGroup(jPanel26Layout.createSequentialGroup().addGap(12, 12, 12).addGroup(jPanel26Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel51).addComponent(this.jLabel52)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel26Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.xDays1).addComponent(this.xQuan1))).addGroup(jPanel26Layout.createSequentialGroup().addContainerGap().addComponent(this.jButton40, -2, 92, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 63, 32767).addComponent(this.jButton41, -2, 92, -2))).addGap(10, 10, 10)));
    



































    jPanel26Layout.setVerticalGroup(jPanel26Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel26Layout.createSequentialGroup().addGap(12, 12, 12).addGroup(jPanel26Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.xQuan1).addComponent(this.jLabel52, -2, 31, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel26Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.xDays1, -2, 31, -2).addComponent(this.jLabel51, -2, 31, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel26Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jLabel50, -1, -1, 32767).addComponent(this.xDateIn1, -2, 32, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel26Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.xDateOut1, -2, 32, -2).addComponent(this.jLabel46, -2, 32, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel26Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jLabel53, -1, 32, 32767).addComponent(this.xPrice1)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED, -1, 32767).addComponent(this.jSeparator16, -2, 10, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel26Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jButton40).addComponent(this.jButton41)).addContainerGap()));
    






























    GroupLayout addExtra1Layout = new GroupLayout(this.addExtra1.getContentPane());
    this.addExtra1.getContentPane().setLayout(addExtra1Layout);
    addExtra1Layout.setHorizontalGroup(addExtra1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(addExtra1Layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel26, -2, -1, -2).addContainerGap(12, 32767)));
    





    addExtra1Layout.setVerticalGroup(addExtra1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(addExtra1Layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel26, -1, -1, 32767).addContainerGap()));
    






    this.viewExtra.setTitle("View Exta");
    this.viewExtra.setMinimumSize(new Dimension(507, 352));
    this.viewExtra.setModal(true);
    
    this.jPanel27.setBackground(new Color(51, 0, 153));
    
    this.viewExtraTable.setFont(new Font("Tahoma", 0, 12));
    this.viewExtraTable.setModel(new DefaultTableModel(new Object[0][], new String[] { "Price", "Quantity", "Date In", "Date Out" })
    {
      boolean[] canEdit = { false, false, false, false };
      
      public boolean isCellEditable(int rowIndex, int columnIndex)
      {
        return this.canEdit[columnIndex];
      }
    });
    this.viewExtraTable.setRowHeight(20);
    this.viewExtraTable.getTableHeader().setResizingAllowed(false);
    this.viewExtraTable.getTableHeader().setReorderingAllowed(false);
    this.jScrollPane7.setViewportView(this.viewExtraTable);
    if (this.viewExtraTable.getColumnModel().getColumnCount() > 0) {
      this.viewExtraTable.getColumnModel().getColumn(3).setHeaderValue("Date Out");
    }
    this.jPanel28.setBackground(new Color(51, 0, 153));
    this.jPanel28.setBorder(BorderFactory.createTitledBorder(null, "Statistics", 0, 0, null, Color.white));
    
    this.jLabel54.setForeground(new Color(255, 255, 255));
    this.jLabel54.setText("Total:");
    
    this.viewTotal2.setForeground(new Color(255, 102, 102));
    this.viewTotal2.setText("0");
    
    GroupLayout jPanel28Layout = new GroupLayout(this.jPanel28);
    this.jPanel28.setLayout(jPanel28Layout);
    jPanel28Layout.setHorizontalGroup(jPanel28Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel28Layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel54).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.viewTotal2, -2, 169, -2).addContainerGap(-1, 32767)));
    







    jPanel28Layout.setVerticalGroup(jPanel28Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel28Layout.createSequentialGroup().addContainerGap().addGroup(jPanel28Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel54, -1, 19, 32767).addComponent(this.viewTotal2, -1, -1, 32767)).addContainerGap()));
    








    this.jButton42.setText("Close");
    this.jButton42.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Main.this.jButton42ActionPerformed(evt);
      }
    });
    GroupLayout jPanel27Layout = new GroupLayout(this.jPanel27);
    this.jPanel27.setLayout(jPanel27Layout);
    jPanel27Layout.setHorizontalGroup(jPanel27Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel27Layout.createSequentialGroup().addContainerGap().addGroup(jPanel27Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane7, -1, 467, 32767).addComponent(this.jPanel28, -1, -1, 32767)).addContainerGap()).addGroup(jPanel27Layout.createSequentialGroup().addGap(171, 171, 171).addComponent(this.jButton42, -2, 130, -2).addContainerGap(-1, 32767)));
    











    jPanel27Layout.setVerticalGroup(jPanel27Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel27Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane7, -1, 237, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel28, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton42, -2, 31, -2).addContainerGap()));
    










    GroupLayout viewExtraLayout = new GroupLayout(this.viewExtra.getContentPane());
    this.viewExtra.getContentPane().setLayout(viewExtraLayout);
    viewExtraLayout.setHorizontalGroup(viewExtraLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(viewExtraLayout.createSequentialGroup().addContainerGap().addComponent(this.jPanel27, -1, -1, 32767).addContainerGap()));
    





    viewExtraLayout.setVerticalGroup(viewExtraLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(viewExtraLayout.createSequentialGroup().addContainerGap().addComponent(this.jPanel27, -1, -1, 32767).addContainerGap()));
    






    this.transRoom.setTitle("Transfer Room");
    this.transRoom.setMinimumSize(new Dimension(350, 189));
    this.transRoom.setModal(true);
    
    this.jPanel29.setBackground(new Color(51, 0, 153));
    
    this.roomLabel.setForeground(new Color(255, 255, 255));
    this.roomLabel.setText("Transfer to Room():");
    
    this.resRoom.setModel(new DefaultComboBoxModel(new String[] { "Select" }));
    
    this.jButton43.setText("Transfer");
    this.jButton43.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Main.this.jButton43ActionPerformed(evt);
      }
    });
    this.jButton46.setText("Cancel");
    this.jButton46.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Main.this.jButton46ActionPerformed(evt);
      }
    });
    GroupLayout jPanel29Layout = new GroupLayout(this.jPanel29);
    this.jPanel29.setLayout(jPanel29Layout);
    jPanel29Layout.setHorizontalGroup(jPanel29Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel29Layout.createSequentialGroup().addContainerGap().addGroup(jPanel29Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jSeparator17).addGroup(jPanel29Layout.createSequentialGroup().addComponent(this.roomLabel).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.resRoom, 0, -1, 32767)).addGroup(jPanel29Layout.createSequentialGroup().addComponent(this.jButton43, -2, 125, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 60, 32767).addComponent(this.jButton46, -2, 125, -2))).addContainerGap()));
    















    jPanel29Layout.linkSize(0, new Component[] { this.jButton43, this.jButton46 });
    
    jPanel29Layout.setVerticalGroup(jPanel29Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel29Layout.createSequentialGroup().addGap(23, 23, 23).addGroup(jPanel29Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.roomLabel, -2, 36, -2).addComponent(this.resRoom, -2, 36, -2)).addGap(18, 18, 18).addComponent(this.jSeparator17, -2, 11, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel29Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jButton43, -1, 28, 32767).addComponent(this.jButton46, -1, -1, 32767)).addContainerGap(-1, 32767)));
    














    GroupLayout transRoomLayout = new GroupLayout(this.transRoom.getContentPane());
    this.transRoom.getContentPane().setLayout(transRoomLayout);
    transRoomLayout.setHorizontalGroup(transRoomLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(transRoomLayout.createSequentialGroup().addContainerGap().addComponent(this.jPanel29, -1, -1, 32767).addContainerGap()));
    





    transRoomLayout.setVerticalGroup(transRoomLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(transRoomLayout.createSequentialGroup().addContainerGap().addComponent(this.jPanel29, -1, -1, 32767).addContainerGap()));
    






    this.showNotif.setTitle("Notifications");
    this.showNotif.setAlwaysOnTop(true);
    this.showNotif.setMinimumSize(new Dimension(494, 487));
    
    this.jPanel30.setBackground(new Color(51, 0, 153));
    
    this.jButton82.setText("Close");
    this.jButton82.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Main.this.jButton82ActionPerformed(evt);
      }
    });
    this.jButton83.setText("Go to Occupied Section");
    this.jButton83.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Main.this.jButton83ActionPerformed(evt);
      }
    });
    this.notifTable.setFont(new Font("Tahoma", 0, 14));
    this.notifTable.setModel(new DefaultTableModel(new Object[0][], new String[] { "Room", "Guest", "Check Out Date", "Remarks" })
    {
      boolean[] canEdit = { false, false, false, false };
      
      public boolean isCellEditable(int rowIndex, int columnIndex)
      {
        return this.canEdit[columnIndex];
      }
    });
    this.notifTable.setRowHeight(24);
    this.notifTable.getTableHeader().setReorderingAllowed(false);
    this.jScrollPane8.setViewportView(this.notifTable);
    
    GroupLayout jPanel30Layout = new GroupLayout(this.jPanel30);
    this.jPanel30.setLayout(jPanel30Layout);
    jPanel30Layout.setHorizontalGroup(jPanel30Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel30Layout.createSequentialGroup().addContainerGap().addGroup(jPanel30Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel30Layout.createSequentialGroup().addGap(0, 0, 32767).addGroup(jPanel30Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel30Layout.createSequentialGroup().addComponent(this.jButton83, -2, 161, -2).addGap(18, 18, 18).addComponent(this.jButton82, -2, 132, -2).addGap(77, 77, 77)).addGroup(GroupLayout.Alignment.TRAILING, jPanel30Layout.createSequentialGroup().addComponent(this.jSeparator18, -2, 452, -2).addContainerGap()))).addGroup(jPanel30Layout.createSequentialGroup().addComponent(this.jScrollPane8, -2, -1, -2).addGap(0, 0, 32767)))));
    


















    jPanel30Layout.setVerticalGroup(jPanel30Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel30Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane8, -2, 375, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jSeparator18, -2, 10, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 8, 32767).addGroup(jPanel30Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jButton82).addComponent(this.jButton83)).addContainerGap()));
    












    GroupLayout showNotifLayout = new GroupLayout(this.showNotif.getContentPane());
    this.showNotif.getContentPane().setLayout(showNotifLayout);
    showNotifLayout.setHorizontalGroup(showNotifLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, showNotifLayout.createSequentialGroup().addContainerGap().addComponent(this.jPanel30, -1, -1, 32767).addContainerGap()));
    





    showNotifLayout.setVerticalGroup(showNotifLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, showNotifLayout.createSequentialGroup().addContainerGap().addComponent(this.jPanel30, -1, -1, 32767).addContainerGap()));
    






    this.adjustments.setTitle("Adjustments");
    this.adjustments.setMinimumSize(new Dimension(463, 390));
    this.adjustments.setModal(true);
    this.adjustments.setResizable(false);
    
    this.jPanel31.setBackground(new Color(51, 0, 153));
    
    this.adjustTable.setFont(new Font("Tahoma", 0, 12));
    this.adjustTable.setModel(new DefaultTableModel(new Object[0][], new String[] { "AdjID", "Description", "Date Issued", "Amount" })
    {
      boolean[] canEdit = { false, false, false, false };
      
      public boolean isCellEditable(int rowIndex, int columnIndex)
      {
        return this.canEdit[columnIndex];
      }
    });
    this.adjustTable.setRowHeight(20);
    this.adjustTable.getTableHeader().setResizingAllowed(false);
    this.adjustTable.getTableHeader().setReorderingAllowed(false);
    this.jScrollPane9.setViewportView(this.adjustTable);
    
    this.jPanel32.setBackground(new Color(51, 0, 153));
    this.jPanel32.setBorder(BorderFactory.createTitledBorder(null, "Statistics", 0, 0, null, Color.white));
    
    this.jLabel62.setForeground(new Color(255, 255, 255));
    this.jLabel62.setText("Total:");
    
    this.totalAdj.setForeground(new Color(255, 102, 102));
    this.totalAdj.setText("0");
    
    GroupLayout jPanel32Layout = new GroupLayout(this.jPanel32);
    this.jPanel32.setLayout(jPanel32Layout);
    jPanel32Layout.setHorizontalGroup(jPanel32Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel32Layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel62).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.totalAdj, -2, 76, -2).addContainerGap(-1, 32767)));
    







    jPanel32Layout.setVerticalGroup(jPanel32Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel32Layout.createSequentialGroup().addContainerGap().addGroup(jPanel32Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel62, -1, 19, 32767).addComponent(this.totalAdj, -1, -1, 32767)).addContainerGap()));
    








    this.jButton5.setText("Add New");
    this.jButton5.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Main.this.jButton5ActionPerformed(evt);
      }
    });
    this.jLabel63.setForeground(new Color(255, 102, 102));
    this.jLabel63.setText("*Note:");
    
    this.jLabel64.setForeground(new Color(255, 255, 255));
    this.jLabel64.setText("Negative amounts mean deductions to the ");
    
    this.jLabel65.setForeground(new Color(255, 255, 255));
    this.jLabel65.setText("total charge or simply, discounts. Positives mean ");
    
    this.jLabel66.setForeground(new Color(255, 255, 255));
    this.jLabel66.setText("additional charges.");
    
    this.jButton7.setText("Close");
    this.jButton7.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Main.this.jButton7ActionPerformed(evt);
      }
    });
    this.jButton59.setBackground(new Color(255, 0, 0));
    this.jButton59.setForeground(new Color(255, 255, 255));
    this.jButton59.setText("Delete");
    this.jButton59.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Main.this.jButton59ActionPerformed(evt);
      }
    });
    GroupLayout jPanel31Layout = new GroupLayout(this.jPanel31);
    this.jPanel31.setLayout(jPanel31Layout);
    jPanel31Layout.setHorizontalGroup(jPanel31Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel31Layout.createSequentialGroup().addContainerGap().addGroup(jPanel31Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel31Layout.createSequentialGroup().addGap(0, 0, 32767).addGroup(jPanel31Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.jButton5, -1, -1, 32767).addComponent(this.jPanel32, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel31Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel31Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.jLabel65, GroupLayout.Alignment.LEADING, -1, -1, 32767).addGroup(GroupLayout.Alignment.LEADING, jPanel31Layout.createSequentialGroup().addComponent(this.jLabel63).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel64)).addComponent(this.jLabel66, -2, 245, -2)).addGroup(jPanel31Layout.createSequentialGroup().addComponent(this.jButton7, -2, 114, -2).addGap(18, 18, 18).addComponent(this.jButton59, -2, 114, -2)))).addComponent(this.jScrollPane9, -2, 0, 32767)).addContainerGap()));
    
























    jPanel31Layout.setVerticalGroup(jPanel31Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel31Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane9, -2, 203, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel31Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel32, -2, -1, -2).addGroup(jPanel31Layout.createSequentialGroup().addGroup(jPanel31Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel63).addComponent(this.jLabel64)).addGap(2, 2, 2).addComponent(this.jLabel65).addGap(2, 2, 2).addComponent(this.jLabel66))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel31Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jButton5, -2, 30, -2).addComponent(this.jButton7, -2, 30, -2).addComponent(this.jButton59, -2, 30, -2)).addContainerGap(-1, 32767)));
    






















    GroupLayout adjustmentsLayout = new GroupLayout(this.adjustments.getContentPane());
    this.adjustments.getContentPane().setLayout(adjustmentsLayout);
    adjustmentsLayout.setHorizontalGroup(adjustmentsLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(adjustmentsLayout.createSequentialGroup().addContainerGap().addComponent(this.jPanel31, -2, -1, -2).addContainerGap(-1, 32767)));
    





    adjustmentsLayout.setVerticalGroup(adjustmentsLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(adjustmentsLayout.createSequentialGroup().addContainerGap().addComponent(this.jPanel31, -1, -1, 32767).addContainerGap()));
    






    this.newAdjust.setTitle("New Adjustment");
    this.newAdjust.setMinimumSize(new Dimension(304, 213));
    this.newAdjust.setModal(true);
    this.newAdjust.setPreferredSize(new Dimension(304, 213));
    this.newAdjust.setResizable(false);
    
    this.jPanel33.setBackground(new Color(51, 0, 153));
    
    this.jLabel68.setForeground(new Color(255, 255, 255));
    this.jLabel68.setText("Description:");
    
    this.jLabel69.setForeground(new Color(255, 255, 255));
    this.jLabel69.setText("Amount:");
    
    this.adjAmount.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));
    
    this.jButton50.setText("Add");
    this.jButton50.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Main.this.jButton50ActionPerformed(evt);
      }
    });
    this.jButton51.setText("Cancel");
    this.jButton51.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Main.this.jButton51ActionPerformed(evt);
      }
    });
    GroupLayout jPanel33Layout = new GroupLayout(this.jPanel33);
    this.jPanel33.setLayout(jPanel33Layout);
    jPanel33Layout.setHorizontalGroup(jPanel33Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel33Layout.createSequentialGroup().addContainerGap().addGroup(jPanel33Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jSeparator19).addGroup(jPanel33Layout.createSequentialGroup().addGroup(jPanel33Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel69).addComponent(this.jLabel68)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel33Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.adjDesc).addComponent(this.adjAmount, -1, 202, 32767)).addGap(0, 0, 32767)).addGroup(jPanel33Layout.createSequentialGroup().addComponent(this.jButton50, -2, 101, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.jButton51, -2, 101, -2))).addContainerGap()));
    



















    jPanel33Layout.setVerticalGroup(jPanel33Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel33Layout.createSequentialGroup().addGap(11, 11, 11).addGroup(jPanel33Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel68, -2, 24, -2).addComponent(this.adjDesc, -2, 27, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel33Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.adjAmount, -1, 32, 32767).addComponent(this.jLabel69, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jSeparator19, -2, 10, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel33Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jButton50, -2, 31, -2).addComponent(this.jButton51, -2, 31, -2)).addContainerGap(-1, 32767)));
    


















    jPanel33Layout.linkSize(1, new Component[] { this.adjAmount, this.adjDesc });
    
    GroupLayout newAdjustLayout = new GroupLayout(this.newAdjust.getContentPane());
    this.newAdjust.getContentPane().setLayout(newAdjustLayout);
    newAdjustLayout.setHorizontalGroup(newAdjustLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(newAdjustLayout.createSequentialGroup().addContainerGap().addComponent(this.jPanel33, -2, -1, -2).addContainerGap(-1, 32767)));
    





    newAdjustLayout.setVerticalGroup(newAdjustLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(newAdjustLayout.createSequentialGroup().addContainerGap().addComponent(this.jPanel33, -1, -1, 32767).addContainerGap()));
    






    this.newAdjust.getAccessibleContext().setAccessibleParent(this.adjustments);
    
    this.account2.setTitle("Guest's Account");
    this.account2.setMinimumSize(new Dimension(465, 684));
    this.account2.setModal(true);
    
    this.jPanel34.setBackground(new Color(51, 0, 153));
    this.jPanel34.setBorder(BorderFactory.createBevelBorder(0));
    
    this.jButton25.setText("Transfer Room");
    this.jButton25.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Main.this.jButton25ActionPerformed(evt);
      }
    });
    this.jButton53.setText("Cancel");
    this.jButton53.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Main.this.jButton53ActionPerformed(evt);
      }
    });
    this.jPanel35.setBackground(new Color(51, 0, 153));
    this.jPanel35.setBorder(BorderFactory.createTitledBorder(null, "Previous Room", 0, 0, null, Color.white));
    
    this.accPaid2.setFont(new Font("Tahoma", 0, 18));
    this.accPaid2.setForeground(new Color(255, 255, 255));
    
    this.balLabel2.setFont(new Font("Tahoma", 0, 18));
    this.balLabel2.setForeground(new Color(255, 102, 102));
    this.balLabel2.setText("Balance:");
    
    this.jButton54.setText("View");
    this.jButton54.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Main.this.jButton54ActionPerformed(evt);
      }
    });
    this.jButton55.setText("View");
    this.jButton55.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Main.this.jButton55ActionPerformed(evt);
      }
    });
    this.accBal2.setFont(new Font("Tahoma", 0, 18));
    this.accBal2.setForeground(new Color(255, 102, 102));
    
    this.accExtra2.setFont(new Font("Tahoma", 0, 18));
    this.accExtra2.setForeground(new Color(255, 255, 255));
    
    this.jLabel72.setFont(new Font("Tahoma", 0, 18));
    this.jLabel72.setForeground(new Color(255, 255, 255));
    this.jLabel72.setText("Sales Account:");
    
    this.accSales2.setFont(new Font("Tahoma", 0, 18));
    this.accSales2.setForeground(new Color(255, 255, 255));
    this.accSales2.setText("0.0");
    this.accSales2.setToolTipText("");
    
    this.jLabel73.setFont(new Font("Tahoma", 0, 18));
    this.jLabel73.setForeground(new Color(255, 255, 255));
    this.jLabel73.setText("Extra:");
    
    this.accTotal2.setFont(new Font("Tahoma", 0, 18));
    this.accTotal2.setForeground(new Color(0, 153, 0));
    
    this.accRoom2.setFont(new Font("Tahoma", 0, 18));
    this.accRoom2.setForeground(new Color(255, 255, 255));
    
    this.jLabel74.setFont(new Font("Tahoma", 0, 18));
    this.jLabel74.setForeground(new Color(255, 255, 255));
    this.jLabel74.setText("Paid:");
    
    this.jLabel75.setFont(new Font("Tahoma", 0, 18));
    this.jLabel75.setForeground(new Color(255, 255, 255));
    this.jLabel75.setText("Room Price:");
    
    this.jButton56.setText("View");
    this.jButton56.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Main.this.jButton56ActionPerformed(evt);
      }
    });
    this.jLabel78.setFont(new Font("Tahoma", 0, 18));
    this.jLabel78.setForeground(new Color(255, 255, 255));
    this.jLabel78.setText("Adjustments:");
    
    this.accAdj2.setFont(new Font("Tahoma", 0, 18));
    this.accAdj2.setForeground(new Color(255, 255, 255));
    
    this.jButton57.setText("View");
    this.jButton57.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Main.this.jButton57ActionPerformed(evt);
      }
    });
    GroupLayout jPanel35Layout = new GroupLayout(this.jPanel35);
    this.jPanel35.setLayout(jPanel35Layout);
    jPanel35Layout.setHorizontalGroup(jPanel35Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel35Layout.createSequentialGroup().addContainerGap().addGroup(jPanel35Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel72).addComponent(this.jLabel75).addComponent(this.jLabel73).addComponent(this.jLabel74).addComponent(this.jLabel78).addComponent(this.balLabel2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel35Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel35Layout.createSequentialGroup().addGroup(jPanel35Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.accTotal2, -1, -1, 32767).addComponent(this.jSeparator22).addComponent(this.accRoom2, -1, -1, 32767)).addGap(10, 10, 10)).addGroup(jPanel35Layout.createSequentialGroup().addGroup(jPanel35Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel35Layout.createSequentialGroup().addGroup(jPanel35Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.accPaid2, -1, -1, 32767).addComponent(this.accAdj2, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel35Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jButton57, GroupLayout.Alignment.TRAILING).addComponent(this.jButton55, GroupLayout.Alignment.TRAILING, -2, 54, -2))).addComponent(this.accBal2, -1, -1, 32767).addGroup(GroupLayout.Alignment.TRAILING, jPanel35Layout.createSequentialGroup().addGroup(jPanel35Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.accExtra2, -1, -1, 32767).addComponent(this.accSales2, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel35Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jButton54, GroupLayout.Alignment.TRAILING).addComponent(this.jButton56, GroupLayout.Alignment.TRAILING)))).addContainerGap()))));
    






































    jPanel35Layout.setVerticalGroup(jPanel35Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel35Layout.createSequentialGroup().addContainerGap().addGroup(jPanel35Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.accRoom2, -1, -1, 32767).addComponent(this.jLabel75, -1, 29, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel35Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jLabel73, -1, -1, 32767).addComponent(this.accExtra2, -1, -1, 32767).addComponent(this.jButton56, GroupLayout.Alignment.TRAILING, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(jPanel35Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jPanel35Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.accSales2, -1, 23, 32767).addComponent(this.jButton54, -1, -1, 32767)).addComponent(this.jLabel72, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jSeparator22, -2, 10, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.accTotal2, -2, 23, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel35Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel35Layout.createSequentialGroup().addGroup(jPanel35Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.accPaid2, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.jLabel74, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.jButton55, GroupLayout.Alignment.TRAILING, -1, 29, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel35Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.accAdj2, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.jButton57, -1, -1, 32767).addComponent(this.jLabel78, GroupLayout.Alignment.TRAILING, -2, 29, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.accBal2, -2, 22, -2)).addComponent(this.balLabel2)).addContainerGap()));
    






































    this.jPanel36.setBackground(new Color(51, 0, 153));
    this.jPanel36.setBorder(BorderFactory.createTitledBorder(null, "New Room", 0, 0, null, Color.white));
    
    this.newDateOut.setEnabled(false);
    
    this.jLabel80.setFont(new Font("Tahoma", 0, 18));
    this.jLabel80.setForeground(new Color(255, 255, 255));
    this.jLabel80.setText("No. of Days:");
    
    this.resRoom2.setModel(new DefaultComboBoxModel(new String[] { "Select" }));
    this.resRoom2.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Main.this.resRoom2ActionPerformed(evt);
      }
    });
    this.roomLabel2.setFont(new Font("Tahoma", 0, 18));
    this.roomLabel2.setForeground(new Color(255, 255, 255));
    this.roomLabel2.setText("Transfer to(10):");
    
    this.resDays1.setModel(new SpinnerNumberModel(20, 1, 100, 1));
    this.resDays1.addChangeListener(new ChangeListener()
    {
      public void stateChanged(ChangeEvent evt)
      {
        Main.this.resDays1StateChanged(evt);
      }
    });
    this.resDays1.addFocusListener(new FocusAdapter()
    {
      public void focusLost(FocusEvent evt)
      {
        Main.this.resDays1FocusLost(evt);
      }
    });
    this.jLabel81.setFont(new Font("Tahoma", 0, 18));
    this.jLabel81.setForeground(new Color(255, 255, 255));
    this.jLabel81.setText("Date Out:");
    
    this.roomLabel3.setFont(new Font("Tahoma", 0, 18));
    this.roomLabel3.setForeground(new Color(255, 255, 255));
    this.roomLabel3.setText("Room Rate:");
    
    this.newRoomRate.setFont(new Font("Tahoma", 0, 18));
    this.newRoomRate.setForeground(new Color(255, 255, 255));
    
    this.resDisc1.setModel(new SpinnerNumberModel(Float.valueOf(15.5F), Float.valueOf(0.0F), Float.valueOf(100.0F), Float.valueOf(0.1F)));
    this.resDisc1.setEnabled(false);
    this.resDisc1.addChangeListener(new ChangeListener()
    {
      public void stateChanged(ChangeEvent evt)
      {
        Main.this.resDisc1StateChanged(evt);
      }
    });
    this.discCheck1.setBackground(new Color(51, 0, 153));
    this.discCheck1.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Main.this.discCheck1ActionPerformed(evt);
      }
    });
    this.jLabel76.setFont(new Font("Tahoma", 0, 18));
    this.jLabel76.setForeground(new Color(255, 255, 255));
    this.jLabel76.setText("Discount:");
    
    this.preAdjSign1.setText("+");
    this.preAdjSign1.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Main.this.preAdjSign1ActionPerformed(evt);
      }
    });
    this.preAdj1.setModel(new DefaultComboBoxModel(new String[] { "None", "200", "230", "300" }));
    this.preAdj1.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Main.this.preAdj1ActionPerformed(evt);
      }
    });
    this.roomLabel4.setFont(new Font("Tahoma", 0, 18));
    this.roomLabel4.setForeground(new Color(255, 255, 255));
    this.roomLabel4.setText("Pre-Adj:");
    
    GroupLayout jPanel36Layout = new GroupLayout(this.jPanel36);
    this.jPanel36.setLayout(jPanel36Layout);
    jPanel36Layout.setHorizontalGroup(jPanel36Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel36Layout.createSequentialGroup().addContainerGap().addGroup(jPanel36Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.roomLabel3).addComponent(this.jLabel81).addComponent(this.jLabel80).addComponent(this.roomLabel2).addComponent(this.jLabel76).addComponent(this.roomLabel4)).addGap(18, 18, 18).addGroup(jPanel36Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.resRoom2, 0, -1, 32767).addComponent(this.newDateOut, -1, 236, 32767).addComponent(this.resDays1, GroupLayout.Alignment.TRAILING).addComponent(this.newRoomRate, -1, -1, 32767).addGroup(GroupLayout.Alignment.TRAILING, jPanel36Layout.createSequentialGroup().addComponent(this.discCheck1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.resDisc1)).addGroup(GroupLayout.Alignment.TRAILING, jPanel36Layout.createSequentialGroup().addComponent(this.preAdjSign1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.preAdj1, 0, -1, 32767))).addContainerGap()));
    

























    jPanel36Layout.setVerticalGroup(jPanel36Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel36Layout.createSequentialGroup().addContainerGap().addGroup(jPanel36Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel80, -2, 33, -2).addComponent(this.resDays1, -2, 29, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel36Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel81, -1, 29, 32767).addComponent(this.newDateOut, -2, 29, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel36Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.roomLabel2, -2, 29, -2).addGroup(jPanel36Layout.createSequentialGroup().addGap(4, 4, 4).addComponent(this.resRoom2, -2, 30, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel36Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.discCheck1, -2, 28, -2).addComponent(this.jLabel76, -2, 32, -2).addComponent(this.resDisc1, -2, 28, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel36Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jPanel36Layout.createSequentialGroup().addGap(6, 6, 6).addComponent(this.roomLabel3, -2, 29, -2)).addComponent(this.newRoomRate, -2, 35, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel36Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.preAdj1, -2, 31, -2).addComponent(this.roomLabel4, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.preAdjSign1, GroupLayout.Alignment.TRAILING, -1, -1, 32767)).addContainerGap()));
    


































    GroupLayout jPanel34Layout = new GroupLayout(this.jPanel34);
    this.jPanel34.setLayout(jPanel34Layout);
    jPanel34Layout.setHorizontalGroup(jPanel34Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel34Layout.createSequentialGroup().addContainerGap().addGroup(jPanel34Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel35, -1, -1, 32767).addComponent(this.jPanel36, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addGroup(GroupLayout.Alignment.TRAILING, jPanel34Layout.createSequentialGroup().addComponent(this.jButton25, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.jButton53, -2, 121, -2))).addContainerGap()));
    











    jPanel34Layout.setVerticalGroup(jPanel34Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel34Layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel35, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel36, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel34Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jButton53, -2, 31, -2).addComponent(this.jButton25, -2, 31, -2)).addContainerGap(-1, 32767)));
    












    GroupLayout account2Layout = new GroupLayout(this.account2.getContentPane());
    this.account2.getContentPane().setLayout(account2Layout);
    account2Layout.setHorizontalGroup(account2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(account2Layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel34, -2, -1, -2).addContainerGap(-1, 32767)));
    





    account2Layout.setVerticalGroup(account2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(account2Layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel34, -2, -1, -2).addContainerGap(-1, 32767)));
    






    this.balances.setTitle("Account Balances");
    this.balances.setMinimumSize(new Dimension(399, 462));
    
    this.jPanel37.setBackground(new Color(51, 0, 153));
    
    this.jPanel38.setBackground(new Color(51, 0, 153));
    this.jPanel38.setBorder(BorderFactory.createTitledBorder(null, "Statistics", 0, 0, null, Color.white));
    
    this.jLabel82.setForeground(new Color(255, 255, 255));
    this.jLabel82.setText("Total:");
    
    this.viewTotal3.setForeground(new Color(255, 102, 102));
    this.viewTotal3.setText("0");
    
    GroupLayout jPanel38Layout = new GroupLayout(this.jPanel38);
    this.jPanel38.setLayout(jPanel38Layout);
    jPanel38Layout.setHorizontalGroup(jPanel38Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel38Layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel82).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.viewTotal3, -2, 169, -2).addContainerGap(-1, 32767)));
    







    jPanel38Layout.setVerticalGroup(jPanel38Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel38Layout.createSequentialGroup().addContainerGap().addGroup(jPanel38Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel82, -1, 23, 32767).addComponent(this.viewTotal3, -1, -1, 32767)).addContainerGap()));
    








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
    this.jScrollPane10.setViewportView(this.balancesTable);
    
    this.jButton61.setText("Close");
    this.jButton61.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Main.this.jButton61ActionPerformed(evt);
      }
    });
    GroupLayout jPanel37Layout = new GroupLayout(this.jPanel37);
    this.jPanel37.setLayout(jPanel37Layout);
    jPanel37Layout.setHorizontalGroup(jPanel37Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel37Layout.createSequentialGroup().addContainerGap().addGroup(jPanel37Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane10, -1, 327, 32767).addComponent(this.jPanel38, -1, -1, 32767).addGroup(GroupLayout.Alignment.TRAILING, jPanel37Layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 121, -2).addComponent(this.jButton61, -2, 110, -2).addGap(116, 116, 116))).addContainerGap()));
    











    jPanel37Layout.setVerticalGroup(jPanel37Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel37Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane10, -2, 283, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel38, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton61).addContainerGap()));
    










    GroupLayout balancesLayout = new GroupLayout(this.balances.getContentPane());
    this.balances.getContentPane().setLayout(balancesLayout);
    balancesLayout.setHorizontalGroup(balancesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(balancesLayout.createSequentialGroup().addContainerGap().addComponent(this.jPanel37, -1, -1, 32767).addContainerGap()));
    





    balancesLayout.setVerticalGroup(balancesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(balancesLayout.createSequentialGroup().addContainerGap().addComponent(this.jPanel37, -2, -1, -2).addContainerGap(-1, 32767)));
    






    setDefaultCloseOperation(3);
    setTitle("11th Street Room Management System ");
    
    this.navi.setBackground(new Color(51, 0, 153));
    
    naviCur.setText("Current");
    naviCur.setCursor(new Cursor(0));
    naviCur.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Main.this.naviCurActionPerformed(evt);
      }
    });
    naviRes.setText("Reservation");
    naviRes.setCursor(new Cursor(12));
    naviRes.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Main.this.naviResActionPerformed(evt);
      }
    });
    naviRoom.setText("Room Management");
    naviRoom.setCursor(new Cursor(12));
    naviRoom.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Main.this.naviRoomActionPerformed(evt);
      }
    });
    naviGuest.setText("Guests Record");
    naviGuest.setCursor(new Cursor(12));
    naviGuest.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Main.this.naviGuestActionPerformed(evt);
      }
    });
    this.jButton4.setText("Exit");
    
    naviRec.setText("Transaction Records");
    naviRec.setCursor(new Cursor(12));
    naviRec.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Main.this.naviRecActionPerformed(evt);
      }
    });
    naviCal.setText("Room Calendar");
    naviCal.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Main.this.naviCalActionPerformed(evt);
      }
    });
    naviVac.setText("Vacant Days");
    naviVac.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Main.this.naviVacActionPerformed(evt);
      }
    });
    naviSet.setText("Reports & Settlements");
    naviSet.setCursor(new Cursor(12));
    naviSet.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Main.this.naviSetActionPerformed(evt);
      }
    });
    this.jButton52.setText("Log Out");
    this.jButton52.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Main.this.jButton52ActionPerformed(evt);
      }
    });
    this.naviHome.setForeground(new Color(255, 0, 0));
    this.naviHome.setText("Home");
    this.naviHome.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Main.this.naviHomeActionPerformed(evt);
      }
    });
    GroupLayout naviLayout = new GroupLayout(this.navi);
    this.navi.setLayout(naviLayout);
    naviLayout.setHorizontalGroup(naviLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(naviLayout.createSequentialGroup().addContainerGap().addGroup(naviLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(naviGuest, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(naviRoom, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(naviRes, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(naviCur, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.jButton4, -1, -1, 32767).addComponent(naviRec, -1, -1, 32767).addComponent(naviCal, -1, -1, 32767).addComponent(naviVac, -1, -1, 32767).addComponent(naviSet, -1, -1, 32767).addComponent(this.jButton52, -1, -1, 32767).addComponent(this.naviHome, -1, -1, 32767)).addContainerGap()));
    
















    naviLayout.setVerticalGroup(naviLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(naviLayout.createSequentialGroup().addContainerGap().addComponent(naviCur, -2, 36, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(naviRes, -2, 39, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(naviGuest, -2, 37, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(naviRoom, -2, 37, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(naviRec, -2, 37, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(naviSet, -2, 37, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 174, 32767).addComponent(naviCal).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(naviVac).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.naviHome).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton52).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton4).addContainerGap()));
    


























    this.split.setLeftComponent(this.navi);
    
    this.currentSplit.setOrientation(0);
    
    this.occuTable.setFont(new Font("Tahoma", 0, 18));
    this.occuTable.setModel(new DefaultTableModel(new Object[0][], new String[] { "Booking ID", "Room", "Guest", "Date In", "Date Out", "Remarks" })
    {
      boolean[] canEdit = { false, false, false, false, false, false };
      
      public boolean isCellEditable(int rowIndex, int columnIndex)
      {
        return this.canEdit[columnIndex];
      }
    });
    this.occuTable.setRowHeight(27);
    this.occuTable.getTableHeader().setReorderingAllowed(false);
    this.jScrollPane1.setViewportView(this.occuTable);
    
    this.jPanel2.setBorder(BorderFactory.createTitledBorder("Statistics"));
    
    this.jLabel58.setText("Number of Records:");
    
    this.noOccu.setForeground(new Color(255, 102, 102));
    
    GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
    this.jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel58).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.noOccu, -2, 188, -2).addContainerGap(-1, 32767)));
    







    jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.jLabel58).addGap(0, 0, 32767)).addComponent(this.noOccu, -1, -1, 32767)).addContainerGap()));
    










    this.jButton3.setText("Check Out");
    this.jButton3.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Main.this.jButton3ActionPerformed(evt);
      }
    });
    this.jButton31.setText("Account");
    this.jButton31.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Main.this.jButton31ActionPerformed(evt);
      }
    });
    this.jButton36.setText("Extend");
    this.jButton36.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Main.this.jButton36ActionPerformed(evt);
      }
    });
    this.jButton48.setText("Adjustments");
    this.jButton48.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Main.this.jButton48ActionPerformed(evt);
      }
    });
    this.jButton8.setText("Transfer");
    this.jButton8.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Main.this.jButton8ActionPerformed(evt);
      }
    });
    this.jButton58.setBackground(new Color(255, 0, 0));
    this.jButton58.setForeground(new Color(255, 255, 255));
    this.jButton58.setText("Delete");
    this.jButton58.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Main.this.jButton58ActionPerformed(evt);
      }
    });
    GroupLayout occuLayout = new GroupLayout(this.occu);
    this.occu.setLayout(occuLayout);
    occuLayout.setHorizontalGroup(occuLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(occuLayout.createSequentialGroup().addContainerGap().addGroup(occuLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1, -1, 984, 32767).addGroup(occuLayout.createSequentialGroup().addComponent(this.jButton3, -2, 164, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton31, -2, 164, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton48, -2, 164, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton36, -2, 164, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton8, -2, 160, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton58, -2, 128, -2).addGap(0, 0, 32767)).addComponent(this.jSeparator1, GroupLayout.Alignment.TRAILING).addComponent(this.jPanel2, -1, -1, 32767)).addContainerGap()));
    





















    occuLayout.setVerticalGroup(occuLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(occuLayout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane1, -1, 371, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel2, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jSeparator1, -2, 5, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(occuLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jButton36, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addGroup(occuLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jButton3, -2, 38, -2).addComponent(this.jButton31, -2, 36, -2).addComponent(this.jButton48, -2, 36, -2)).addComponent(this.jButton8, -1, -1, 32767).addComponent(this.jButton58, -1, -1, 32767)).addContainerGap()));
    



















    this.currentSplit.setRightComponent(this.occu);
    
    this.jPanel1.setBorder(BorderFactory.createTitledBorder("Filter by"));
    
    this.jLabel1.setText("RoomID");
    
    this.filRoom.addKeyListener(new KeyAdapter()
    {
      public void keyPressed(KeyEvent evt)
      {
        Main.this.filRoomKeyPressed(evt);
      }
      
      public void keyTyped(KeyEvent evt)
      {
        Main.this.filRoomKeyTyped(evt);
      }
    });
    this.jLabel2.setText("Guest ID");
    
    this.filGuest.addKeyListener(new KeyAdapter()
    {
      public void keyPressed(KeyEvent evt)
      {
        Main.this.filGuestKeyPressed(evt);
      }
      
      public void keyTyped(KeyEvent evt)
      {
        Main.this.filGuestKeyTyped(evt);
      }
    });
    this.jLabel3.setText("Status");
    
    this.filStat.setModel(new DefaultComboBoxModel(new String[] { "Occupied", "Vacant", "Reserved" }));
    this.filStat.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Main.this.filStatActionPerformed(evt);
      }
    });
    this.filType.setModel(new DefaultComboBoxModel(new String[] { "Select", "Single", "Double", "Family" }));
    this.filType.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Main.this.filTypeActionPerformed(evt);
      }
    });
    this.jLabel55.setText("Type");
    
    this.jLabel56.setText("Ventilation");
    
    this.filVent.setModel(new DefaultComboBoxModel(new String[] { "Select", "Air Conditioned", "Electric Fan" }));
    this.filVent.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Main.this.filVentActionPerformed(evt);
      }
    });
    this.jLabel57.setText("Remarks");
    
    this.filRem.addKeyListener(new KeyAdapter()
    {
      public void keyPressed(KeyEvent evt)
      {
        Main.this.filRemKeyPressed(evt);
      }
      
      public void keyTyped(KeyEvent evt)
      {
        Main.this.filRemKeyTyped(evt);
      }
    });
    this.viewDue.setText("View Due Only");
    this.viewDue.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Main.this.viewDueActionPerformed(evt);
      }
    });
    GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
    this.jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel3).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.filStat, -2, 118, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.filGuest, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.filRoom, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel55).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.filType, -2, 104, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel56).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.filVent, -2, 117, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel57).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.filRem, -2, 96, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.viewDue).addContainerGap(-1, 32767)));
    





























    jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel56, -1, -1, 32767).addComponent(this.filStat, GroupLayout.Alignment.LEADING).addComponent(this.filType, GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.filVent).addComponent(this.jLabel57).addComponent(this.filRem, -2, -1, -2).addComponent(this.viewDue)).addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel1).addComponent(this.filRoom, -2, -1, -2).addComponent(this.jLabel2).addComponent(this.filGuest, -2, -1, -2)).addGap(0, 0, 32767)).addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup().addGap(3, 3, 3).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel55, -1, -1, 32767).addComponent(this.jLabel3, -1, -1, 32767)))).addContainerGap()));
    


























    this.currentSplit.setLeftComponent(this.jPanel1);
    
    this.split.setRightComponent(this.currentSplit);
    
    this.jToolBar1.setFloatable(false);
    this.jToolBar1.setRollover(true);
    
    this.jMenu1.setText("File");
    
    this.jMenuItem1.setAccelerator(KeyStroke.getKeyStroke(81, 2));
    this.jMenuItem1.setText("Exit");
    this.jMenuItem1.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Main.this.jMenuItem1ActionPerformed(evt);
      }
    });
    this.jMenu1.add(this.jMenuItem1);
    
    this.jMenuBar1.add(this.jMenu1);
    
    this.jMenu2.setText("Navigate");
    
    this.jMenuItem2.setAccelerator(KeyStroke.getKeyStroke(112, 0));
    this.jMenuItem2.setText("Current");
    this.jMenuItem2.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Main.this.jMenuItem2ActionPerformed(evt);
      }
    });
    this.jMenu2.add(this.jMenuItem2);
    
    this.jMenuItem3.setAccelerator(KeyStroke.getKeyStroke(113, 0));
    this.jMenuItem3.setText("Reservation");
    this.jMenuItem3.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Main.this.jMenuItem3ActionPerformed(evt);
      }
    });
    this.jMenu2.add(this.jMenuItem3);
    
    this.jMenuItem4.setAccelerator(KeyStroke.getKeyStroke(114, 0));
    this.jMenuItem4.setText("Guest Record");
    this.jMenuItem4.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Main.this.jMenuItem4ActionPerformed(evt);
      }
    });
    this.jMenu2.add(this.jMenuItem4);
    
    this.jMenuItem5.setAccelerator(KeyStroke.getKeyStroke(115, 0));
    this.jMenuItem5.setText("Room Management");
    this.jMenuItem5.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Main.this.jMenuItem5ActionPerformed(evt);
      }
    });
    this.jMenu2.add(this.jMenuItem5);
    
    this.jMenuItem6.setAccelerator(KeyStroke.getKeyStroke(116, 0));
    this.jMenuItem6.setText("Records & Reports");
    this.jMenuItem6.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Main.this.jMenuItem6ActionPerformed(evt);
      }
    });
    this.jMenu2.add(this.jMenuItem6);
    
    this.jMenu5.setText("Calendar");
    
    this.jMenuItem7.setAccelerator(KeyStroke.getKeyStroke(117, 0));
    this.jMenuItem7.setText("Room Calendar");
    this.jMenuItem7.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Main.this.jMenuItem7ActionPerformed(evt);
      }
    });
    this.jMenu5.add(this.jMenuItem7);
    
    this.jMenuItem8.setAccelerator(KeyStroke.getKeyStroke(118, 0));
    this.jMenuItem8.setText("Vacant Days");
    this.jMenuItem8.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Main.this.jMenuItem8ActionPerformed(evt);
      }
    });
    this.jMenu5.add(this.jMenuItem8);
    
    this.jMenu2.add(this.jMenu5);
    
    this.jMenuBar1.add(this.jMenu2);
    
    this.notifMenu.setText("Notifications(0)");
    
    showNot.setAccelerator(KeyStroke.getKeyStroke(78, 8));
    showNot.setText("Show Notifications");
    showNot.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Main.this.showNotActionPerformed(evt);
      }
    });
    this.notifMenu.add(showNot);
    
    this.jMenuBar1.add(this.notifMenu);
    
    this.jMenu4.setText("About");
    
    this.jMenuItem9.setAccelerator(KeyStroke.getKeyStroke(65, 8));
    this.jMenuItem9.setText("About Contents");
    this.jMenu4.add(this.jMenuItem9);
    
    this.jMenuBar1.add(this.jMenu4);
    
    setJMenuBar(this.jMenuBar1);
    
    GroupLayout layout = new GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jToolBar1, -1, -1, 32767).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.split).addContainerGap()));
    






    layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.jToolBar1, -2, 25, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.split).addContainerGap()));
    







    pack();
  }
  
  private void naviResActionPerformed(ActionEvent evt)
  {
    if (Extras.isLogged)
    {
      naviCur.setForeground(new Color(0, 0, 0));
      naviRes.setForeground(new Color(255, 0, 0));
      naviGuest.setForeground(new Color(0, 0, 0));
      naviRoom.setForeground(new Color(0, 0, 0));
      naviRec.setForeground(new Color(0, 0, 0));
      naviSet.setForeground(new Color(0, 0, 0));
      this.naviHome.setForeground(new Color(0, 0, 0));
      
      naviCur.setCursor(new Cursor(12));
      naviRes.setCursor(new Cursor(0));
      naviGuest.setCursor(new Cursor(12));
      naviRoom.setCursor(new Cursor(12));
      naviRec.setCursor(new Cursor(12));
      naviSet.setCursor(new Cursor(12));
      this.naviHome.setCursor(new Cursor(12));
      this.split.setRightComponent(new Reservation());
    }
    else
    {
      JOptionPane.showMessageDialog(this.rootPane, "Please log in to gain access", "Authorization Error", 0);
    }
  }
  
  private void naviGuestActionPerformed(ActionEvent evt)
  {
    if (Extras.isLogged)
    {
      naviCur.setForeground(new Color(0, 0, 0));
      naviRes.setForeground(new Color(0, 0, 0));
      naviGuest.setForeground(new Color(255, 0, 0));
      naviRoom.setForeground(new Color(0, 0, 0));
      naviRec.setForeground(new Color(0, 0, 0));
      naviSet.setForeground(new Color(0, 0, 0));
      this.naviHome.setForeground(new Color(0, 0, 0));
      
      naviCur.setCursor(new Cursor(12));
      naviRes.setCursor(new Cursor(12));
      naviGuest.setCursor(new Cursor(0));
      naviRoom.setCursor(new Cursor(12));
      naviRec.setCursor(new Cursor(12));
      naviSet.setCursor(new Cursor(12));
      this.naviHome.setCursor(new Cursor(12));
      
      this.split.setRightComponent(new Guest());
    }
    else
    {
      JOptionPane.showMessageDialog(this.rootPane, "Please log in to gain access", "Authorization Error", 0);
    }
  }
  
  private void naviCurActionPerformed(ActionEvent evt)
  {
    if (Extras.isLogged)
    {
      naviCur.setForeground(new Color(255, 0, 0));
      naviRes.setForeground(new Color(0, 0, 0));
      naviGuest.setForeground(new Color(0, 0, 0));
      naviRoom.setForeground(new Color(0, 0, 0));
      naviRec.setForeground(new Color(0, 0, 0));
      naviSet.setForeground(new Color(0, 0, 0));
      this.naviHome.setForeground(new Color(0, 0, 0));
      
      naviCur.setCursor(new Cursor(0));
      naviRes.setCursor(new Cursor(12));
      naviGuest.setCursor(new Cursor(12));
      naviRoom.setCursor(new Cursor(12));
      naviRec.setCursor(new Cursor(12));
      naviSet.setCursor(new Cursor(12));
      this.naviHome.setCursor(new Cursor(12));
      filter();
      
      this.split.setRightComponent(this.currentSplit);
    }
    else
    {
      JOptionPane.showMessageDialog(this.rootPane, "Please log in to gain access", "Authorization Error", 0);
    }
  }
  
  private void jButton14ActionPerformed(ActionEvent evt)
  {
    naviResActionPerformed(evt);
  }
  
  private void filStatActionPerformed(ActionEvent evt)
  {
    filter();
  }
  
  private void jButton16ActionPerformed(ActionEvent evt)
  {
    System.out.println(this.addRes.getSize());
    this.addRes.setVisible(false);
  }
  
  private void jButton17ActionPerformed(ActionEvent evt)
  {
    if (this.resGuest.getSelectedIndex() != 0)
    {
      String sRoom = this.selRoom;
      
      String sGuest = this.resGuest.getSelectedItem().toString();
      
      String sDateIn = this.df.format(this.resDateIn.getDate()) + " " + this.resTime.getText();
      String sDateOut = this.df.format(this.resDateOut.getDate()) + " " + this.resTime.getText();
      int ans = JOptionPane.showConfirmDialog(this.addRes, "Settle Payments now?", "Payment confirmation", 1);
      if (ans != 2) {
        try
        {
          Class.forName("com.mysql.jdbc.Driver");
          String connectionUrl = DBUrl.dbcon;
          Connection con = DriverManager.getConnection(connectionUrl);
          PreparedStatement stmt = null;
          ResultSet rs = null;
          Statement stmtRes = con.createStatement();
          if (this.isRes) {
            stmtRes.executeUpdate("DELETE FROM `reservation`.`reservation` WHERE  `resID`=" + this.selReservation + ";");
          }
          int res = -1;
          stmt = con.prepareStatement("INSERT INTO `reservation`.`reservation` (`roomID`, `guestID`, `inDate`, `outDate`, `stat`) VALUES (?, ?, ?, ?, 'o');");
          
          stmt.setString(1, sRoom);
          stmt.setString(2, sGuest);
          stmt.setString(3, sDateIn);
          stmt.setString(4, sDateOut);
          res = stmt.executeUpdate();
          if (res != 0)
          {
            ResultSet rsAcc = stmt.executeQuery("SELECT LAST_INSERT_ID() AS resID;");
            rsAcc.next();
            this.resID = rsAcc.getString("resID");
            

            String guestID = this.resGuest.getSelectedItem().toString();
            
            String dateNow = this.df.format(Calendar.getInstance().getTime());
            String timeNow = this.tf.format(Calendar.getInstance().getTime());
            String now = dateNow + " " + timeNow;
            
            Statement stmtAcc = con.createStatement();
            
            int days = Integer.parseInt(this.resDays.getValue().toString());
            
            double room = days * this.selPrice;
            
            double disc = 0.0D;
            if (this.discCheck.isSelected())
            {
              disc = Double.parseDouble(this.resDisc.getValue().toString()) / 100.0D;
              System.out.println("discount: " + disc);
            }
            room -= room * disc;
            
            stmtAcc.executeUpdate("INSERT INTO `reservation`.`guesttrans` (`guestID`, `resID`, `room`, `disc`, `date`) VALUES ('" + guestID + "', '" + this.resID + "', " + room + ", " + disc + ", '" + now + "');");
            

            double xtra = Double.parseDouble(this.resExtra.getText());
            int quan = Integer.parseInt(this.xQuan.getValue().toString());
            if (xtra > 0.0D) {
              stmtAcc.executeUpdate("INSERT INTO `reservation`.`extra` (`guestId`, `resID`, `xtra`, `quan`, `xdateIn`, `xdateOut`) VALUES ('" + guestID + "', '" + this.resID + "', " + xtra + ", " + quan + ", '" + this.df.format(this.xDateIn.getDate()) + "', '" + this.df.format(this.xDateOut.getDate()) + "');");
            }
            if (ans == 0)
            {
              this.payTotal.setText("" + this.resRate.getText());
              resetPaymentFields();
              this.payment.setVisible(true);
            }
            float oldBal = Float.parseFloat(this.totalBal.getText());
            if (oldBal != 0.0F)
            {
              int ures = stmtAcc.executeUpdate("INSERT INTO `reservation`.`adjustments` (`guestID`, `resID`, `desc`, `amount`, `date`)  SELECT '" + guestID + "', '" + this.resID + "', `room`, `bal`, `dateOut` FROM `resrecords` WHERE `guest` = '" + guestID + "' AND `bal`!=0");
              if (ures != 0) {
                stmtAcc.executeUpdate("UPDATE `reservation`.`resrecords` SET `bal`=0 WHERE `guest` = '" + guestID + "' AND `bal`!=0");
              }
            }
            JOptionPane.showMessageDialog(this.addRes, "Successfully checked in");
            new UserLogger().insertLog(Extras.loggeduser, 0, "Checked in " + guestID + " to room " + room);
            
            this.addRes.setVisible(false);
            if (this.isRes) {
              loadRes();
            } else {
              loadAvailRooms();
            }
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
    }
    else
    {
      JOptionPane.showMessageDialog(this.addRes, "Please enter Guest.", "Input Error", 0);
    }
  }
  
  private void resTimeFocusLost(FocusEvent evt)
  {
    if (!this.resTime.isEditValid()) {
      this.resTime.setText("09:00");
    }
  }
  
  private void resDaysStateChanged(ChangeEvent evt)
  {
    this.resExtra.setText("0");
    setResOut();
    if (isNotVacant())
    {
      JOptionPane.showMessageDialog(this.addRes, "Sorry. There are reservations until this date.", "Reservation found", 2);
      int prev = Integer.parseInt(this.resDays.getValue().toString()) - 1;
      this.resDays.setValue(Integer.valueOf(prev));
    }
    else
    {
      calcPrice();
    }
  }
  
  private void resDaysFocusLost(FocusEvent evt) {}
  
  private void jButton3ActionPerformed(ActionEvent evt)
  {
    int sel = this.occuTable.getSelectedRow();
    if (sel != -1)
    {
      String selRoom = this.occuTable.getValueAt(sel, 1).toString();
      java.util.Date n = Calendar.getInstance().getTime();
      String inDate = this.occuTable.getValueAt(sel, 3).toString().substring(0, 10);
      String outDate = this.occuTable.getValueAt(sel, 4).toString().substring(0, 10);
      String nowDate = this.df.format(n);
      
      int numDays = 0;
      int diffDays = 0;
      try
      {
        numDays = calcDateDiff(this.df.parse(outDate), this.df.parse(inDate));
        diffDays = calcDateDiff(this.df.parse(outDate), this.df.parse(this.df.format(n)));
      }
      catch (ParseException ex)
      {
        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
      }
      System.out.println("DIFF: " + diffDays + "num: " + numDays);
      
      this.selRes = this.occuTable.getValueAt(sel, 0).toString();
      this.selGuest = this.occuTable.getValueAt(sel, 1).toString();
      try
      {
        Class.forName("com.mysql.jdbc.Driver");
        String connectionUrl = DBUrl.dbcon;
        Connection con = DriverManager.getConnection(connectionUrl);
        Statement stmt = null;
        ResultSet rs = null;ResultSet rsX = null;
        stmt = con.createStatement();
        Statement stmtX = con.createStatement();
        float roomTotal = 0.0F;
        float xtraTotal = 0.0F;
        
        rs = stmt.executeQuery("SELECT room FROM guesttrans WHERE resID='" + this.selRes + "'");
        if (rs.next()) {
          roomTotal = rs.getFloat("room");
        }
        rsX = stmtX.executeQuery("SELECT SUM(xtra) as xtra FROM extra WHERE resID='" + this.selRes + "'");
        if (rsX.next()) {
          xtraTotal = rsX.getFloat("xtra");
        }
        this.accSales.setText(this.decForm.format(getSales()));
        
        Statement stmt0 = null;
        ResultSet rs0 = null;
        stmt0 = con.createStatement();
        
        rs0 = stmt0.executeQuery("SELECT  extra FROM rooms WHERE roomID='" + selRoom + "'");
        float xtraPrice = 0.0F;
        if (rs0.next()) {
          xtraPrice = rs0.getFloat("extra");
        }
        if (roomTotal == roomTotal / numDays * diffDays) {
          roomTotal /= numDays;
        } else {
          roomTotal -= roomTotal / numDays * diffDays;
        }
        this.accRoom.setText(this.decForm.format(roomTotal));
        this.accExtra.setText(this.decForm.format(xtraTotal));
        






        Float sales = Float.valueOf(Float.parseFloat(this.accSales.getText()));
        
        Float total = Float.valueOf(roomTotal + xtraTotal + sales.floatValue());
        
        this.accTotal.setText(this.decForm.format(total));
        
        Statement stmt1 = null;
        ResultSet rs1 = null;
        stmt1 = con.createStatement();
        
        rs1 = stmt1.executeQuery("SELECT SUM(`amount`) AS `paid` FROM `paycash` WHERE `resID`='" + this.selRes + "'");
        
        float paid = 0.0F;
        if (rs1.next())
        {
          paid = rs1.getFloat("paid");
          this.accPaid.setText(this.decForm.format(paid));
        }
        float bal = total.floatValue() - paid;
        

        float adj = loadAdjusts();
        
        this.accAdj.setText(this.decForm.format(adj));
        
        bal += adj;
        if (bal < 0.0F)
        {
          bal = bal;
          this.accTendered.setText("");
          this.accTendered.setEnabled(false);
          this.balLabel.setText("Refund:");
        }
        else if (bal == 0.0F)
        {
          this.accTendered.setText("");
          this.accTendered.setEnabled(false);
        }
        else if (bal > 0.0F)
        {
          this.accTendered.setText("");
          this.accTendered.setEnabled(true);
          this.balLabel.setText("Balance:");
        }
        this.accBal.setText(this.decForm.format(bal));
      }
      catch (SQLException e)
      {
        System.out.println("SQL Exception: " + e.toString());
      }
      catch (ClassNotFoundException cE)
      {
        System.out.println("Class Not Found Exception: " + cE.toString());
      }
      if (diffDays == 0)
      {
        this.selOut = this.occuTable.getValueAt(sel, 4).toString().substring(0, 10);
        this.account.setVisible(true);
      }
      else if (JOptionPane.showConfirmDialog(this.occuTable, "Today is " + diffDays + " day(s) earlier.\n" + "Room price may vary. Continue anyway?", "Checkout Confirmation", 0) == 0)
      {
        this.selOut = nowDate;
        this.account.setVisible(true);
      }
    }
    else
    {
      JOptionPane.showMessageDialog(this.occuTable, "Please select room first", "No room selected", 2);
    }
  }
  
  private void jButton9ActionPerformed(ActionEvent evt)
  {
    int sel = this.vacantTable.getSelectedRow();
    if (sel != -1)
    {
      this.resDateIn.setDate(Calendar.getInstance().getTime());
      setResOut();
      this.resTime.setText(this.tf.format(Calendar.getInstance().getTime()));
      
      this.selPrice = Float.parseFloat(this.vacantTable.getValueAt(sel, 3).toString());
      this.selExtra = Float.parseFloat(this.vacantTable.getValueAt(sel, 4).toString());
      this.resExtra.setText("0");
      calcPrice();
      
      this.selRoom = this.vacantTable.getValueAt(sel, 0).toString();
      loadGuests();
      this.totalBal.setText("");
      this.isRes = false;
      this.addRes.setVisible(true);
    }
    else
    {
      JOptionPane.showMessageDialog(this.vacantTable, "Please select room first", "No room selected", 2);
    }
  }
  
  private void jButton1ActionPerformed(ActionEvent evt)
  {
    float amount = 0.0F;
    try
    {
      amount = Float.parseFloat(this.payAmount.getText());
    }
    catch (NumberFormatException e)
    {
      amount = 0.0F;
    }
    int selM = this.payMode.getSelectedIndex();
    if ((amount > 0.0F) && (selM != 0)) {
      try
      {
        Class.forName("com.mysql.jdbc.Driver");
        String connectionUrl = DBUrl.dbcon;
        Connection con = DriverManager.getConnection(connectionUrl);
        Statement stmt = null;
        ResultSet rs = null;
        String dateNow = this.df.format(Calendar.getInstance().getTime());
        String timeNow = this.tf.format(Calendar.getInstance().getTime());
        String now = dateNow + " " + timeNow;
        

        String guestID = this.resGuest.getSelectedItem().toString();
        
        String mode = "";
        if (selM == 1) {
          mode = "cash";
        } else if (selM == 2) {
          mode = "credit";
        } else if (selM == 3) {
          mode = "check";
        }
        stmt = con.createStatement();
        stmt.executeUpdate("INSERT INTO `reservation`.`paycash` (`resID`, `amount`,`mode`,`datePaid`) VALUES (" + this.resID + ", " + amount + ", '" + mode + "', '" + now + "');");
        if (selM == 1) {
          updateSalesCust(this.resID, guestID, amount + "", now);
        }
        JOptionPane.showMessageDialog(this.payment, "Payment Successfully saved");
        this.payment.setVisible(false);
      }
      catch (SQLException e)
      {
        System.out.println("SQL Exception: " + e.toString());
      }
      catch (ClassNotFoundException cE)
      {
        System.out.println("Class Not Found Exception: " + cE.toString());
      }
    } else {
      JOptionPane.showMessageDialog(this.payment, "Amount or Mode input is incorrect", "Amount Error", 0);
    }
  }
  
  private void jButton13ActionPerformed(ActionEvent evt)
  {
    if (JOptionPane.showConfirmDialog(this.payment, "Sure to cancel payment?\nNote: You can still pay in user's account area", "Cancel confirmation", 0) == 0) {
      this.payment.setVisible(false);
    }
    System.out.println(this.payment.getSize());
  }
  
  private void paymentWindowClosing(WindowEvent evt) {}
  
  private void jButton21ActionPerformed(ActionEvent evt)
  {
    System.out.println(this.account.getSize());
    this.account.setVisible(false);
  }
  
  private void jButton20ActionPerformed(ActionEvent evt)
  {
    float tendered = 0.0F;
    try
    {
      tendered = Float.parseFloat(this.accTendered.getText());
    }
    catch (NumberFormatException e)
    {
      tendered = 0.0F;
    }
    float roomPrice = Float.parseFloat(this.accRoom.getText());
    float sales = Float.parseFloat(this.accSales.getText());
    float extra = Float.parseFloat(this.accExtra.getText());
    float adj = Float.parseFloat(this.accAdj.getText());
    float total = Float.parseFloat(this.accTotal.getText()) + adj;
    float amount = tendered + Float.parseFloat(this.accPaid.getText());
    float change = total - amount;
    boolean cont = true;
    if (change <= 0.0F)
    {
      cont = true;
      System.out.println("OK     change: " + change);
    }
    else
    {
      System.out.println("ND     balance: " + change);
      if (JOptionPane.showConfirmDialog(this.account, "Account balance not settled.\nAre you sure to check out?", "Balance Remaining", 0) == 0) {
        cont = true;
      } else {
        cont = false;
      }
    }
    if (cont) {
      try
      {
        Class.forName("com.mysql.jdbc.Driver");
        String connectionUrl = DBUrl.dbcon;
        Connection con = DriverManager.getConnection(connectionUrl);
        Statement stmt = null;
        ResultSet rs = null;
        String dateNow = this.df.format(Calendar.getInstance().getTime());
        String timeNow = this.tf.format(Calendar.getInstance().getTime());
        String now = dateNow + " " + timeNow;
        
        int sel = this.occuTable.getSelectedRow();
        String selRoom = this.occuTable.getValueAt(sel, 1).toString();
        String guest = this.occuTable.getValueAt(sel, 2).toString();
        
        String inDate = this.occuTable.getValueAt(sel, 3).toString().substring(0, 10);
        String outDate = this.selOut;
        

        float bal = 0.0F;
        
        String sAmount = "";
        
        bal = change;
        sAmount = tendered + "";
        System.out.println("ten: " + tendered + " ch: " + change + "  Am: " + sAmount);
        if (tendered != 0.0F)
        {
          int selM = this.accMode.getSelectedIndex();
          String mode = "";
          if (selM == 0) {
            mode = "cash";
          } else if (selM == 1) {
            mode = "credit";
          } else {
            mode = "check";
          }
          stmt = con.createStatement();
          stmt.executeUpdate("INSERT INTO `reservation`.`paycash` (`resID`, `amount`, `mode`, `datePaid`) VALUES (" + this.selRes + ", " + sAmount + ", '" + mode + "', '" + now + "');");
          if (selM == 1) {
            updateSalesCust(this.selRes, guest, sAmount, now);
          }
        }
        Statement stmtRec = con.createStatement();
        ResultSet resRec = stmtRec.executeQuery("SELECT `disc` FROM `guesttrans` WHERE resID='" + this.selRes + "'");
        String disc = "0";
        if (resRec.next()) {
          disc = resRec.getString("disc");
        }
        stmtRec.executeUpdate("INSERT INTO `reservation`.`resrecords` (`guest`, `room`, `disc`, `roomPrice`, `sales`, `extra`, `adj`, `price`, `bal`, `dateIn`, `dateOut`) VALUES ('" + guest + "', '" + selRoom + "', " + disc + ", " + roomPrice + ", " + sales + ", " + extra + ", " + adj + ",  " + total + ", " + bal + ", '" + inDate + "', '" + outDate + "');");
        

        stmtRec.executeUpdate("INSERT INTO `reservation`.`payrecord` (`room`, `guest`, `amount`, `mode`, `datePaid`) SELECT '" + selRoom + "','" + guest + "', `amount`, `mode`, `datePaid` FROM `paycash` WHERE `paycash`.`resID` = " + this.selRes + "; ");
        

        stmtRec.addBatch("DELETE FROM extra WHERE resID = " + this.selRes + ";");
        stmtRec.addBatch("DELETE FROM paycash WHERE resID = " + this.selRes + ";");
        stmtRec.addBatch("DELETE FROM guesttrans WHERE resID = " + this.selRes + ";");
        stmtRec.addBatch("DELETE FROM adjustments WHERE resID = " + this.selRes + ";");
        stmtRec.addBatch("DELETE FROM reservation WHERE resID = " + this.selRes + ";");
        
        stmtRec.executeBatch();
        
        JOptionPane.showMessageDialog(this.account, "Successfully Checked Out");
        new UserLogger().insertLog(Extras.loggeduser, 0, "Checked out guest " + guest);
        loadOccu();
        this.account.setVisible(false);
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
    int sel = this.resTable.getSelectedRow();
    if (sel != -1) {
      try
      {
        Class.forName("com.mysql.jdbc.Driver");
        String connectionUrl = DBUrl.dbcon;
        Connection con = DriverManager.getConnection(connectionUrl);
        Statement stmt = null;
        ResultSet rs = null;
        stmt = con.createStatement();
        
        java.util.Date n = Calendar.getInstance().getTime();
        String sInDate = this.resTable.getValueAt(sel, 3).toString().substring(0, 10);
        int diff = calcDateDiff(this.df.parse(sInDate), n);
        
        this.selRoom = this.resTable.getValueAt(sel, 1).toString();
        this.selReservation = this.resTable.getValueAt(sel, 0).toString();
        if (diff == 0)
        {
          this.isRes = true;
          this.resDateIn.setDate(this.df.parse(sInDate));
          
          String sOutDate = this.resTable.getValueAt(sel, 4).toString().substring(0, 10);
          this.resDateOut.setDate(this.df.parse(sOutDate));
          
          String sTime = this.resTable.getValueAt(sel, 4).toString().substring(11, 16);
          System.out.println(sTime);
          this.resTime.setText(sTime);
          
          int d = calcDateDiff(this.df.parse(sOutDate), this.df.parse(sInDate));
          this.resDays.setValue(Integer.valueOf(d));
          
          this.selRoom = this.resTable.getValueAt(sel, 1).toString();
          rs = stmt.executeQuery("SELECT price, extra FROM rooms WHERE roomID='" + this.selRoom + "'");
          rs.next();
          this.selPrice = rs.getFloat("price");
          this.selExtra = rs.getFloat("extra");
          this.resExtra.setText("0");
          calcPrice();
          

          loadGuests();
          this.totalBal.setText("");
          String sGuest = this.resTable.getValueAt(sel, 2).toString();
          this.resGuest.setSelectedItem(sGuest);
          

          this.addRes.setVisible(true);
        }
        else if (JOptionPane.showConfirmDialog(this.resTable, "Check in date differ from reserved.\nDisregard this reservation and check in now?", "Different Check in", 0) == 0)
        {
          int res = stmt.executeUpdate("DELETE FROM `reservation`.`reservation` WHERE  `resID`=" + this.selReservation + ";");
          if (res != 0)
          {
            JOptionPane.showMessageDialog(this.resTable, "You'll be redirected to Vacant View now.");
            this.filStat.setSelectedIndex(1);
          }
        }
      }
      catch (ParseException ex)
      {
        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
      }
      catch (SQLException e)
      {
        System.out.println("SQL Exception: " + e.toString());
      }
      catch (ClassNotFoundException cE)
      {
        System.out.println("Class Not Found Exception: " + cE.toString());
      }
    } else {
      JOptionPane.showMessageDialog(this.resTable, "Please select reservation first", "No room selected", 2);
    }
  }
  
  private void jButton19ActionPerformed(ActionEvent evt)
  {
    loadPayments();
    this.viewPayment.setVisible(true);
  }
  
  private void payAmountKeyTyped(KeyEvent evt)
  {
    calcBal();
  }
  
  private void payAmountKeyPressed(KeyEvent evt)
  {
    calcBal();
  }
  
  private void payAmountKeyReleased(KeyEvent evt)
  {
    calcBal();
  }
  
  private void accTenderedKeyPressed(KeyEvent evt)
  {
    calcBalAcc();
  }
  
  private void accTenderedKeyReleased(KeyEvent evt)
  {
    calcBalAcc();
  }
  
  private void accTenderedKeyTyped(KeyEvent evt) {}
  
  private void jButton18ActionPerformed(ActionEvent evt)
  {
    this.newGuest.setVisible(true);
  }
  
  private void resGuestActionPerformed(ActionEvent evt)
  {
    if (this.resGuest.getSelectedIndex() != 0)
    {
      String selGuest = this.resGuest.getSelectedItem().toString();
      loadBalances(selGuest);
    }
  }
  
  private void jButton22ActionPerformed(ActionEvent evt)
  {
    this.xDays.setValue(Integer.valueOf(Integer.parseInt(this.resDays.getValue().toString())));
    this.xDateIn.setDate(this.resDateIn.getDate());
    this.xDateOut.setDate(this.resDateOut.getDate());
    int d = Integer.parseInt(this.xDays.getValue().toString());
    int q = Integer.parseInt(this.xQuan.getValue().toString());
    float price = d * q * this.selExtra;
    this.xPrice.setText(price + "");
    this.addExtra.setVisible(true);
  }
  
  private void discCheckActionPerformed(ActionEvent evt)
  {
    if (this.discCheck.isSelected()) {
      this.resDisc.setEnabled(true);
    } else {
      this.resDisc.setEnabled(false);
    }
    this.resDisc.setValue(Double.valueOf(15.5D));
    calcPrice();
  }
  
  private void xDaysStateChanged(ChangeEvent evt)
  {
    setXOut();
    java.util.Date resOut = this.resDateOut.getDate();
    java.util.Date xOut = this.xDateOut.getDate();
    int diff = calcDateDiff(resOut, xOut);
    if (diff < 0)
    {
      JOptionPane.showMessageDialog(this.addExtra, "Can't set on or after check out", "Date Error", 0);
      int x = Integer.parseInt(this.xDays.getPreviousValue().toString());
      this.xDays.setValue(Integer.valueOf(x));
      setXOut();
    }
    calcXPrice();
  }
  
  private void xDaysFocusLost(FocusEvent evt) {}
  
  private void xQuanStateChanged(ChangeEvent evt)
  {
    calcXPrice();
  }
  
  private void xQuanFocusLost(FocusEvent evt) {}
  
  private void jButton23ActionPerformed(ActionEvent evt)
  {
    System.out.println(this.addExtra.getSize());
    this.addExtra.setVisible(false);
  }
  
  private void xDateInActionPerformed(ActionEvent evt)
  {
    java.util.Date resIn = this.resDateIn.getDate();
    java.util.Date resOut = this.resDateOut.getDate();
    java.util.Date xtra = this.xDateIn.getDate();
    
    int diffIn = calcDateDiff(xtra, resIn);
    
    int diffOut = calcDateDiff(xtra, resOut);
    if (diffIn < 0)
    {
      JOptionPane.showMessageDialog(this.addExtra, "Can't set before check in", "Date Error", 0);
      this.xDateIn.setDate(this.resDateIn.getDate());
    }
    else if (diffOut >= 0)
    {
      JOptionPane.showMessageDialog(this.addExtra, "Can't set on or after check out", "Date Error", 0);
      this.xDateIn.setDate(this.resDateIn.getDate());
    }
    else
    {
      this.xDays.setValue(Integer.valueOf(1));
      setXOut();
    }
    calcXPrice();
  }
  
  private void sugRoomsActionPerformed(ActionEvent evt)
  {
    loadSug();
  }
  
  private void sugDaysStateChanged(ChangeEvent evt)
  {
    loadSug();
  }
  
  private void jButton24ActionPerformed(ActionEvent evt)
  {
    System.out.println(this.suggest.getSize());
    this.suggest.setVisible(false);
  }
  
  private void naviVacActionPerformed(ActionEvent evt)
  {
    loadRooms();
    loadSug();
    this.suggest.setVisible(true);
  }
  
  private void sugCalActionPerformed(ActionEvent evt)
  {
    loadSug();
  }
  
  private void jButton2ActionPerformed(ActionEvent evt)
  {
    this.resExtra.setText(this.xPrice.getText());
    calcPrice();
    this.addExtra.setVisible(false);
  }
  
  private void resDiscStateChanged(ChangeEvent evt)
  {
    calcPrice();
  }
  
  private void jButton26ActionPerformed(ActionEvent evt)
  {
    System.out.println(this.viewPayment.getSize());
    this.viewPayment.setVisible(false);
  }
  
  private void naviRoomActionPerformed(ActionEvent evt)
  {
    if (Extras.isLogged)
    {
      naviCur.setForeground(new Color(0, 0, 0));
      naviRes.setForeground(new Color(0, 0, 0));
      naviGuest.setForeground(new Color(0, 0, 0));
      naviRoom.setForeground(new Color(255, 0, 0));
      naviRec.setForeground(new Color(0, 0, 0));
      naviSet.setForeground(new Color(0, 0, 0));
      this.naviHome.setForeground(new Color(0, 0, 0));
      
      naviCur.setCursor(new Cursor(12));
      naviRes.setCursor(new Cursor(12));
      naviGuest.setCursor(new Cursor(12));
      naviRoom.setCursor(new Cursor(0));
      naviRec.setCursor(new Cursor(12));
      naviSet.setCursor(new Cursor(12));
      this.naviHome.setCursor(new Cursor(12));
      
      this.split.setRightComponent(new Room());
    }
    else
    {
      JOptionPane.showMessageDialog(this.rootPane, "Please log in to gain access", "Authorization Error", 0);
    }
  }
  
  private void naviRecActionPerformed(ActionEvent evt)
  {
    if (Extras.isLogged)
    {
      naviCur.setForeground(new Color(0, 0, 0));
      naviRes.setForeground(new Color(0, 0, 0));
      naviGuest.setForeground(new Color(0, 0, 0));
      naviRoom.setForeground(new Color(0, 0, 0));
      naviRec.setForeground(new Color(255, 0, 0));
      naviSet.setForeground(new Color(0, 0, 0));
      this.naviHome.setForeground(new Color(0, 0, 0));
      
      naviCur.setCursor(new Cursor(12));
      naviRes.setCursor(new Cursor(12));
      naviGuest.setCursor(new Cursor(12));
      naviRoom.setCursor(new Cursor(12));
      naviRec.setCursor(new Cursor(0));
      naviSet.setCursor(new Cursor(12));
      this.naviHome.setCursor(new Cursor(12));
      

      this.split.setRightComponent(new Report());
    }
    else
    {
      JOptionPane.showMessageDialog(this.rootPane, "Please log in to gain access", "Authorization Error", 0);
    }
  }
  
  private void jButton27ActionPerformed(ActionEvent evt)
  {
    float tendered = 0.0F;
    try
    {
      tendered = Float.parseFloat(this.accTendered1.getText());
    }
    catch (NumberFormatException e)
    {
      tendered = 0.0F;
    }
    if (tendered > 0.0F)
    {
      float total = Float.parseFloat(this.accTotal1.getText()) + Float.parseFloat(this.accAdj1.getText());
      float amount = tendered + Float.parseFloat(this.accPaid1.getText());
      float change = total - amount;
      try
      {
        Class.forName("com.mysql.jdbc.Driver");
        String connectionUrl = DBUrl.dbcon;
        Connection con = DriverManager.getConnection(connectionUrl);
        Statement stmt = null;
        ResultSet rs = null;
        String dateNow = this.df.format(Calendar.getInstance().getTime());
        String timeNow = this.tf.format(Calendar.getInstance().getTime());
        String now = dateNow + " " + timeNow;
        
        String sAmount = "";
        int sel = this.occuTable.getSelectedRow();
        String guest = this.occuTable.getValueAt(sel, 2).toString();
        
        sAmount = tendered + "";
        
        System.out.println("ten: " + tendered + " ch: " + change + "  Am: " + sAmount);
        String mode = "";
        if (tendered != 0.0F)
        {
          int selM = this.accMode1.getSelectedIndex();
          if (selM == 0) {
            mode = "cash";
          } else if (selM == 1) {
            mode = "credit";
          } else {
            mode = "check";
          }
          stmt = con.createStatement();
          stmt.executeUpdate("INSERT INTO `reservation`.`paycash` (`resID`, `amount`,`mode`,`datePaid`) VALUES (" + this.selRes + ", " + sAmount + ", '" + mode + "', '" + now + "');");
          if (selM == 1) {
            updateSalesCust(this.selRes, guest, sAmount, now);
          }
        }
        JOptionPane.showMessageDialog(this.account1, "Payment Successfully Saved");
        new UserLogger().insertLog(Extras.loggeduser, 0, "Guest " + guest + " paid " + sAmount + " in " + mode);
        
        this.account1.setVisible(false);
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
      JOptionPane.showMessageDialog(this.account1, "Payment amount cannot be zero", "Amount Error", 0);
    }
  }
  
  private void jButton28ActionPerformed(ActionEvent evt)
  {
    System.out.println(this.account1.getSize());
    this.account1.setVisible(false);
  }
  
  private void jButton30ActionPerformed(ActionEvent evt)
  {
    loadPayments();
    this.viewPayment.setVisible(true);
  }
  
  private void accTendered1KeyPressed(KeyEvent evt)
  {
    calcBalAcc1();
  }
  
  private void accTendered1KeyReleased(KeyEvent evt)
  {
    calcBalAcc1();
  }
  
  private void accTendered1KeyTyped(KeyEvent evt) {}
  
  private void jButton31ActionPerformed(ActionEvent evt)
  {
    int sel = this.occuTable.getSelectedRow();
    if (sel != -1)
    {
      this.selRes = this.occuTable.getValueAt(sel, 0).toString();
      this.selGuest = this.occuTable.getValueAt(sel, 1).toString();
      try
      {
        Class.forName("com.mysql.jdbc.Driver");
        String connectionUrl = DBUrl.dbcon;
        Connection con = DriverManager.getConnection(connectionUrl);
        Statement stmt = null;
        ResultSet rs = null;ResultSet rsX = null;
        stmt = con.createStatement();
        Statement stmtX = con.createStatement();
        float roomTotal = 0.0F;
        float xtraTotal = 0.0F;
        
        rs = stmt.executeQuery("SELECT room FROM guesttrans WHERE resID='" + this.selRes + "'");
        if (rs.next()) {
          roomTotal = rs.getFloat("room");
        }
        rsX = stmtX.executeQuery("SELECT SUM(xtra) as xtra FROM extra WHERE resID='" + this.selRes + "'");
        if (rsX.next()) {
          xtraTotal = rsX.getFloat("xtra");
        }
        this.accSales1.setText(this.decForm.format(getSales()));
        
        getSalesAcc();
        

        this.accRoom1.setText(this.decForm.format(roomTotal));
        this.accExtra1.setText(this.decForm.format(xtraTotal));
        


        float sales = Float.parseFloat(this.accSales1.getText());
        


        float total = roomTotal + xtraTotal + sales;
        
        this.accTotal1.setText(this.decForm.format(total));
        
        Statement stmt1 = null;
        ResultSet rs1 = null;
        stmt1 = con.createStatement();
        
        rs1 = stmt1.executeQuery("SELECT SUM(`amount`) AS `paid` FROM `paycash` WHERE `resID`='" + this.selRes + "'");
        
        float paid = 0.0F;
        if (rs1.next())
        {
          paid = rs1.getFloat("paid");
          this.accPaid1.setText(this.decForm.format(paid));
        }
        float bal = total - paid;
        
        float adj = loadAdjusts();
        
        this.accAdj1.setText(this.decForm.format(adj));
        
        bal += adj;
        if (bal < 0.0F)
        {
          bal = bal;
          this.accTendered1.setText("");
          this.accTendered1.setEnabled(false);
          this.balLabel1.setText("Refund:");
        }
        else if (bal == 0.0F)
        {
          this.accTendered1.setText("");
          this.accTendered1.setEnabled(false);
        }
        else if (bal > 0.0F)
        {
          this.accTendered1.setText("");
          this.accTendered1.setEnabled(true);
          this.balLabel1.setText("Balance:");
        }
        this.accBal1.setText(this.decForm.format(bal));
      }
      catch (SQLException e)
      {
        System.out.println("SQL Exception: " + e.toString());
      }
      catch (ClassNotFoundException cE)
      {
        System.out.println("Class Not Found Exception: " + cE.toString());
      }
      this.account1.setVisible(true);
    }
    else
    {
      JOptionPane.showMessageDialog(this.occuTable, "Please select room first", "No room selected", 2);
    }
  }
  
  private void naviCalActionPerformed(ActionEvent evt)
  {
    RoomCalendar cal = new RoomCalendar(this, false);
  }
  
  private void jButton32ActionPerformed(ActionEvent evt)
  {
    this.viewSales.setVisible(false);
    System.out.println(this.viewSales.getSize());
  }
  
  private void jButton15ActionPerformed(ActionEvent evt)
  {
    loadSales();
    this.viewSales.setVisible(true);
  }
  
  private void jButton29ActionPerformed(ActionEvent evt)
  {
    loadSales();
    this.viewSales.setVisible(true);
  }
  
  private void jButton33ActionPerformed(ActionEvent evt)
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
  
  private void jButton34ActionPerformed(ActionEvent evt)
  {
    System.out.println(this.newGuest.getSize());
    this.newGuest.setVisible(false);
  }
  
  private void jButton6ActionPerformed(ActionEvent evt)
  {
    loadExtras();
    loadSales();
    loadPayments();
    this.accTendered1.setText("0.00");
    calcBalAcc1();
    
    int sel = this.occuTable.getSelectedRow();
    this.accTendered1.setText("0");
    calcBalAcc1();
    Folio f;
    if (sel != -1)
    {
      String roomID = this.occuTable.getValueAt(sel, 1).toString();
      String guest = this.occuTable.getValueAt(sel, 2).toString();
      
      String checkIn = this.occuTable.getValueAt(sel, 3).toString().substring(0, 10);
      String checkOut = this.occuTable.getValueAt(sel, 4).toString().substring(0, 10);
      
      Calendar cal = Calendar.getInstance();
      int y = cal.get(1);
      String d = String.valueOf(cal.get(5));
      if (d.length() == 1) {
        d = "0" + d;
      }
      String m = String.valueOf(cal.get(2) + 1);
      if (m.length() == 1) {
        m = "0" + m;
      }
      String rDate = y + "-" + m + "-" + d;
      
      String ho = String.valueOf(cal.get(11));
      String mi = String.valueOf(cal.get(12));
      String se = String.valueOf(cal.get(13));
      String time = ho + "" + mi + "" + se;
      
      String roomPrice = getRoomPrice(roomID) + "";
      String extra = this.accExtra1.getText();
      String numDays = null;
      try
      {
        numDays = calcDateDiff(this.df.parse(checkOut), this.df.parse(checkIn)) + "";
      }
      catch (ParseException ex)
      {
        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
      }
      String totalSales = this.viewTotal1.getText();
      String paidSales = this.viewPaid1.getText();
      String unpaidSales = this.viewUnpaid1.getText();
      String totalPayment = this.accPaid1.getText();
      String totalAdjust = this.totalAdj.getText();
      String returnStat = this.balLabel1.getText();
      String totalBal = this.accBal1.getText();
      JFileChooser FileSytemView = new JFileChooser();
      

      DefaultTableModel salesAccModel = (DefaultTableModel)this.viewSaleTable.getModel();
      DefaultTableModel payHistModel = (DefaultTableModel)this.viewPayTable.getModel();
      DefaultTableModel adjustModel = (DefaultTableModel)this.adjustTable.getModel();
      

      File Sample = FileSytemView.getFileSystemView().getDefaultDirectory();
      String Sfile = Sample.toString();
      String db = "\\\\";
      String filename = Sfile.replace("\\", db);
      System.out.println(filename = filename + "\\" + "\\" + rDate + time + ".pdf");
      
      f = new Folio(filename, guest, roomID, checkIn, checkOut, roomPrice, extra, numDays, adjustModel, totalAdjust, salesAccModel, totalSales, paidSales, unpaidSales, payHistModel, totalPayment, returnStat, totalBal);
    }
  }
  
  private void accTendered1ActionPerformed(ActionEvent evt) {}
  
  private void jButton35ActionPerformed(ActionEvent evt)
  {
    int sel = this.occuTable.getSelectedRow();
    SalesAccReport x;
    if (sel != -1)
    {
      String room = this.occuTable.getValueAt(sel, 1).toString();
      String guest = this.occuTable.getValueAt(sel, 2).toString();
      
      Calendar cal = Calendar.getInstance();
      int y = cal.get(1);
      String d = String.valueOf(cal.get(5));
      if (d.length() == 1) {
        d = "0" + d;
      }
      String m = String.valueOf(cal.get(2) + 1);
      if (m.length() == 1) {
        m = "0" + m;
      }
      String rDate = y + "-" + m + "-" + d;
      
      DefaultTableModel reportModel = (DefaultTableModel)this.viewSaleTable.getModel();
      
      String ho = String.valueOf(cal.get(11));
      String mi = String.valueOf(cal.get(12));
      String se = String.valueOf(cal.get(13));
      String time = ho + "" + mi + "" + se;
      JFileChooser FileSytemView = new JFileChooser();
      

      String to = this.viewTotal1.getText();
      String pa = this.viewPaid1.getText();
      String un = this.viewUnpaid1.getText();
      
      File Sample = FileSytemView.getFileSystemView().getDefaultDirectory();
      String Sfile = Sample.toString();
      String db = "\\\\";
      String filename = Sfile.replace("\\", db);
      System.out.println(filename = filename + "\\" + "\\" + rDate + time + ".pdf");
      
      System.out.print(filename);
      x = new SalesAccReport(filename, reportModel, to, pa, un, room, guest);
    }
  }
  
  private void jButton36ActionPerformed(ActionEvent evt)
  {
    int sel = this.occuTable.getSelectedRow();
    if (sel != -1) {
      try
      {
        Class.forName("com.mysql.jdbc.Driver");
        String connectionUrl = DBUrl.dbcon;
        Connection con = DriverManager.getConnection(connectionUrl);
        
        this.selReservation = this.occuTable.getValueAt(sel, 0).toString();
        this.selRoom = this.occuTable.getValueAt(sel, 1).toString();
        this.selGuest = this.occuTable.getValueAt(sel, 2).toString();
        
        String sOutDate = this.occuTable.getValueAt(sel, 4).toString().substring(0, 10);
        this.exCurOut.setDate(this.df.parse(sOutDate));
        setExOut();
        
        Statement stmt0 = null;
        ResultSet rs0 = null;
        stmt0 = con.createStatement();
        
        rs0 = stmt0.executeQuery("SELECT  extra, price FROM rooms WHERE roomID='" + this.selRoom + "'");
        if (rs0.next())
        {
          this.selPrice = rs0.getFloat("price");
          this.selExtra = rs0.getFloat("extra");
        }
        Statement stmt = null;
        ResultSet rs = null;
        stmt = con.createStatement();
        
        rs = stmt.executeQuery("SELECT disc * 100 AS disc FROM guesttrans WHERE resID='" + this.selReservation + "'");
        
        float discount = 0.0F;
        if (rs.next()) {
          discount = rs.getFloat("disc");
        }
        this.exDisc.setValue(Float.valueOf(discount));
        
        this.exExtra.setText("0.00");
        calcPriceEx();
        


        this.extend.setVisible(true);
      }
      catch (SQLException e)
      {
        System.out.println("SQL Exception: " + e.toString());
      }
      catch (ClassNotFoundException cE)
      {
        System.out.println("Class Not Found Exception: " + cE.toString());
      }
      catch (ParseException ex)
      {
        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
      }
    } else {
      JOptionPane.showMessageDialog(this.occuTable, "Please select room first", "No room selected", 2);
    }
  }
  
  private void exDiscStateChanged(ChangeEvent evt)
  {
    calcPriceEx();
  }
  
  private void jButton37ActionPerformed(ActionEvent evt)
  {
    this.xDays1.setValue(Integer.valueOf(Integer.parseInt(this.exDays.getValue().toString())));
    this.xDateIn1.setDate(this.exCurOut.getDate());
    this.xDateOut1.setDate(this.exNewOut.getDate());
    int d = Integer.parseInt(this.xDays1.getValue().toString());
    int q = Integer.parseInt(this.xQuan1.getValue().toString());
    float price = d * q * this.selExtra;
    this.xPrice1.setText(price + "");
    this.addExtra1.setVisible(true);
  }
  
  private void exDaysStateChanged(ChangeEvent evt)
  {
    this.exExtra.setText("0.00");
    setExOut();
    if (isNotVacantEx())
    {
      JOptionPane.showMessageDialog(this.extend, "Sorry. There are reservations until this date.", "Reservation found", 2);
      int prev = Integer.parseInt(this.exDays.getValue().toString()) - 1;
      this.exDays.setValue(Integer.valueOf(prev));
    }
    else
    {
      calcPriceEx();
    }
  }
  
  private void jButton39ActionPerformed(ActionEvent evt)
  {
    System.out.println(this.extend.getSize());
    this.extend.setVisible(false);
  }
  
  private void xDays1StateChanged(ChangeEvent evt)
  {
    setXOut1();
    java.util.Date resOut = this.exNewOut.getDate();
    java.util.Date xOut = this.xDateOut1.getDate();
    int diff = calcDateDiff(resOut, xOut);
    if (diff < 0)
    {
      JOptionPane.showMessageDialog(this.addExtra1, "Can't set on or after check out", "Date Error", 0);
      int x = Integer.parseInt(this.xDays1.getPreviousValue().toString());
      this.xDays1.setValue(Integer.valueOf(x));
      setXOut1();
    }
    calcXPrice1();
  }
  
  private void xDays1FocusLost(FocusEvent evt) {}
  
  private void xDateIn1ActionPerformed(ActionEvent evt)
  {
    java.util.Date resIn = this.exCurOut.getDate();
    java.util.Date resOut = this.exNewOut.getDate();
    java.util.Date xtra = this.xDateIn1.getDate();
    
    int diffIn = calcDateDiff(xtra, resIn);
    
    int diffOut = calcDateDiff(xtra, resOut);
    if (diffIn < 0)
    {
      JOptionPane.showMessageDialog(this.addExtra1, "Can't set before check in", "Date Error", 0);
      this.xDateIn1.setDate(this.exCurOut.getDate());
    }
    else if (diffOut >= 0)
    {
      JOptionPane.showMessageDialog(this.addExtra1, "Can't set on or after check out", "Date Error", 0);
      this.xDateIn1.setDate(this.exCurOut.getDate());
    }
    else
    {
      this.xDays1.setValue(Integer.valueOf(1));
      setXOut1();
    }
    calcXPrice1();
  }
  
  private void jButton40ActionPerformed(ActionEvent evt)
  {
    this.exExtra.setText(this.xPrice1.getText());
    calcPriceEx();
    this.addExtra1.setVisible(false);
  }
  
  private void xQuan1StateChanged(ChangeEvent evt)
  {
    calcXPrice1();
  }
  
  private void xQuan1FocusLost(FocusEvent evt) {}
  
  private void jButton41ActionPerformed(ActionEvent evt)
  {
    System.out.println(this.addExtra1.getSize());
    this.addExtra1.setVisible(false);
  }
  
  private void jButton38ActionPerformed(ActionEvent evt)
  {
    String time = this.tf.format(Long.valueOf(Calendar.getInstance().getTimeInMillis()));
    String newOut = this.df.format(this.exNewOut.getDate()) + " " + time;
    
    int days = Integer.parseInt(this.exDays.getValue().toString());
    double price = days * this.selPrice;
    System.out.println("price:" + price);
    double disc = Double.parseDouble(this.exDisc.getValue().toString()) / 100.0D;
    price -= price * disc;
    try
    {
      Class.forName("com.mysql.jdbc.Driver");
      String connectionUrl = DBUrl.dbcon;
      Connection con = DriverManager.getConnection(connectionUrl);
      Statement stmt = null;
      ResultSet rs = null;
      
      stmt = con.createStatement();
      int ures = stmt.executeUpdate("UPDATE `reservation`.`reservation` SET `outDate`='" + newOut + "' WHERE  `resID`='" + this.selReservation + "';");
      if (ures != 0)
      {
        ures = stmt.executeUpdate("UPDATE `reservation`.`guesttrans` SET `room`=(`room` + " + price + ") WHERE `resID`='" + this.selReservation + "';");
        if (ures != 0)
        {
          double xtra = Double.parseDouble(this.exExtra.getText());
          int quan = Integer.parseInt(this.xQuan1.getValue().toString());
          Statement stmtAcc = con.createStatement();
          if (xtra > 0.0D) {
            stmtAcc.executeUpdate("INSERT INTO `reservation`.`extra` (`guestId`, `resID`, `xtra`, `quan`, `xdateIn`, `xdateOut`) VALUES ('" + this.selGuest + "', '" + this.selReservation + "', " + xtra + ", " + quan + ", '" + this.df.format(this.xDateIn1.getDate()) + "', '" + this.df.format(this.xDateOut1.getDate()) + "');");
          }
          JOptionPane.showMessageDialog(this.extend, "Account Successfully Extended");
          new UserLogger().insertLog(Extras.loggeduser, 0, "Extended guest " + this.selGuest + " by " + days + " days");
          


          this.extend.setVisible(false);
          loadOccu();
        }
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
  
  private void jButton42ActionPerformed(ActionEvent evt)
  {
    this.viewExtra.setVisible(false);
  }
  
  private void jButton44ActionPerformed(ActionEvent evt)
  {
    loadExtras();
    this.viewExtra.setVisible(true);
  }
  
  private void jButton45ActionPerformed(ActionEvent evt)
  {
    loadExtras();
    this.viewExtra.setVisible(true);
  }
  
  private void jButton46ActionPerformed(ActionEvent evt)
  {
    System.out.println(this.transRoom.getSize());
    this.transRoom.setVisible(false);
  }
  
  private void jButton43ActionPerformed(ActionEvent evt)
  {
    if (this.resRoom.getSelectedIndex() != 0)
    {
      String selNew = this.resRoom.getSelectedItem().toString();
      try
      {
        Class.forName("com.mysql.jdbc.Driver");
        String connectionUrl = DBUrl.dbcon;
        Connection con = DriverManager.getConnection(connectionUrl);
        Statement stmt = null;
        ResultSet rs = null;
        



        stmt = con.createStatement();
        int res = stmt.executeUpdate("UPDATE `reservation`.`reservation` SET `roomID`='" + selNew + "' WHERE  `resID`='" + this.selReservation + "';");
        if (res != 0)
        {
          int ures = updateSalesCust();
          


          JOptionPane.showMessageDialog(this.transRoom, "Room Successfully saved");
          new UserLogger().insertLog(Extras.loggeduser, 0, "Transfered resID " + this.selReservation + " to " + selNew);
          this.transRoom.setVisible(false);
          loadOccu();
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
  
  private void filTypeActionPerformed(ActionEvent evt)
  {
    filterCurrent();
  }
  
  private void filVentActionPerformed(ActionEvent evt)
  {
    filterCurrent();
  }
  
  private void filGuestKeyPressed(KeyEvent evt)
  {
    filterCurrent();
  }
  
  private void filGuestKeyTyped(KeyEvent evt)
  {
    filterCurrent();
  }
  
  private void filRoomKeyPressed(KeyEvent evt)
  {
    filterCurrent();
  }
  
  private void filRoomKeyTyped(KeyEvent evt)
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
  
  private void jButton10ActionPerformed(ActionEvent evt)
  {
    naviRoomActionPerformed(evt);
  }
  
  private void jMenuItem1ActionPerformed(ActionEvent evt)
  {
    System.exit(0);
  }
  
  private void jMenuItem2ActionPerformed(ActionEvent evt)
  {
    naviCurActionPerformed(evt);
  }
  
  private void jMenuItem3ActionPerformed(ActionEvent evt)
  {
    naviResActionPerformed(evt);
  }
  
  private void jMenuItem4ActionPerformed(ActionEvent evt)
  {
    naviGuestActionPerformed(evt);
  }
  
  private void jMenuItem5ActionPerformed(ActionEvent evt)
  {
    naviRoomActionPerformed(evt);
  }
  
  private void jMenuItem6ActionPerformed(ActionEvent evt)
  {
    naviRecActionPerformed(evt);
  }
  
  private void jMenuItem7ActionPerformed(ActionEvent evt)
  {
    naviCalActionPerformed(evt);
  }
  
  private void jMenuItem8ActionPerformed(ActionEvent evt)
  {
    naviVacActionPerformed(evt);
  }
  
  private void viewDueActionPerformed(ActionEvent evt)
  {
    filterOccu();
  }
  
  private void jButton82ActionPerformed(ActionEvent evt)
  {
    System.out.println(this.showNotif.getSize());
    this.showNotif.setVisible(false);
  }
  
  private void jButton83ActionPerformed(ActionEvent evt)
  {
    this.showNotif.setVisible(false);
    this.viewDue.setSelected(true);
    this.filStat.setSelectedIndex(0);
    naviCurActionPerformed(evt);
  }
  
  private void showNotActionPerformed(ActionEvent evt)
  {
    this.showNotif.setVisible(true);
  }
  
  private void jButton47ActionPerformed(ActionEvent evt)
  {
    this.adjustments.setVisible(true);
  }
  
  private void jButton48ActionPerformed(ActionEvent evt)
  {
    int sel = this.occuTable.getSelectedRow();
    if (sel != -1)
    {
      this.selRes = this.occuTable.getValueAt(sel, 0).toString();
      loadAdjusts();
      this.adjustments.setVisible(true);
    }
    else
    {
      JOptionPane.showMessageDialog(this.occuTable, "Please select room first", "No room selected", 2);
    }
  }
  
  private void jButton7ActionPerformed(ActionEvent evt)
  {
    System.out.println(this.adjustments.getSize());
    this.adjustments.setVisible(false);
  }
  
  private void jButton49ActionPerformed(ActionEvent evt)
  {
    this.adjustments.setVisible(true);
  }
  
  private void jButton50ActionPerformed(ActionEvent evt)
  {
    int r = 0;
    int sel = this.occuTable.getSelectedRow();
    String guest = this.occuTable.getValueAt(sel, 2).toString();
    String sAdjDesc = this.adjDesc.getText();
    float fAmount = Float.valueOf(this.adjAmount.getText()).floatValue();
    java.util.Date now = Calendar.getInstance().getTime();
    String date = this.df.format(now) + " " + this.tf.format(now);
    try
    {
      Class.forName("com.mysql.jdbc.Driver");
      String connectionUrl = DBUrl.dbcon;
      Connection con = DriverManager.getConnection(connectionUrl);
      PreparedStatement stmt = null;
      ResultSet rs = null;
      stmt = con.prepareStatement("INSERT INTO `reservation`.`adjustments` (`guestID`, `resID`, `desc`, `amount`, `date`) VALUES (?, ?, ?, ?, ?);");
      
      stmt.setString(1, guest);
      stmt.setString(2, this.selRes);
      stmt.setString(3, sAdjDesc);
      stmt.setFloat(4, fAmount);
      stmt.setString(5, date);
      r = stmt.executeUpdate();
    }
    catch (NumberFormatException ex) {}catch (SQLException e)
    {
      System.out.println("SQL Exception: " + e.toString());
      JOptionPane.showMessageDialog(this.newAdjust, "Please check your inputs", "Input Error", 0);
    }
    catch (ClassNotFoundException cE)
    {
      System.out.println("Class Not Found Exception: " + cE.toString());
    }
    if (r != 0)
    {
      JOptionPane.showMessageDialog(this.newAdjust, "Adjustment Successfully added");
      this.newAdjust.setVisible(false);
      loadAdjusts();
      if (this.account.isVisible())
      {
        this.accAdj.setText(this.totalAdj.getText() + "");
        calcBalAcc();
      }
      else if (this.account1.isVisible())
      {
        this.accAdj1.setText(this.totalAdj.getText() + "");
        calcBalAcc1();
      }
      else if (this.account2.isVisible())
      {
        this.accAdj2.setText(this.totalAdj.getText() + "");
        calcBalAcc2();
      }
      new UserLogger().insertLog(Extras.loggeduser, 0, "Added new adjustment for " + guest);
    }
    else
    {
      JOptionPane.showMessageDialog(this.newAdjust, "Please check your inputs", "Input Error", 0);
    }
  }
  
  private void jButton5ActionPerformed(ActionEvent evt)
  {
    this.newAdjust.setVisible(true);
  }
  
  private void jButton51ActionPerformed(ActionEvent evt)
  {
    System.out.println(this.newAdjust.getSize());
    this.newAdjust.setVisible(false);
  }
  
  private void naviSetActionPerformed(ActionEvent evt)
  {
    if (Extras.isLogged)
    {
      naviCur.setForeground(new Color(0, 0, 0));
      naviRes.setForeground(new Color(0, 0, 0));
      naviGuest.setForeground(new Color(0, 0, 0));
      naviRoom.setForeground(new Color(0, 0, 0));
      naviRec.setForeground(new Color(0, 0, 0));
      naviSet.setForeground(new Color(255, 0, 0));
      this.naviHome.setForeground(new Color(0, 0, 0));
      
      naviCur.setCursor(new Cursor(12));
      naviRes.setCursor(new Cursor(12));
      naviGuest.setCursor(new Cursor(12));
      naviRoom.setCursor(new Cursor(12));
      naviRec.setCursor(new Cursor(12));
      naviSet.setCursor(new Cursor(0));
      this.naviHome.setCursor(new Cursor(12));
      

      this.split.setRightComponent(new Settlements());
    }
    else
    {
      JOptionPane.showMessageDialog(this.rootPane, "Please log in to gain access", "Authorization Error", 0);
    }
  }
  
  private void jButton52ActionPerformed(ActionEvent evt) {}
  
  private void naviHomeActionPerformed(ActionEvent evt)
  {
    naviCur.setForeground(new Color(0, 0, 0));
    naviRes.setForeground(new Color(0, 0, 0));
    naviGuest.setForeground(new Color(0, 0, 0));
    naviRoom.setForeground(new Color(0, 0, 0));
    naviRec.setForeground(new Color(0, 0, 0));
    naviSet.setForeground(new Color(0, 0, 0));
    this.naviHome.setForeground(new Color(255, 0, 0));
    
    naviCur.setCursor(new Cursor(12));
    naviRes.setCursor(new Cursor(12));
    naviGuest.setCursor(new Cursor(12));
    naviRoom.setCursor(new Cursor(12));
    naviRec.setCursor(new Cursor(12));
    naviSet.setCursor(new Cursor(12));
    this.naviHome.setCursor(new Cursor(0));
    

    this.split.setRightComponent(new Home());
  }
  
  private void jButton25ActionPerformed(ActionEvent evt)
  {
    float roomPrice = Float.parseFloat(this.accRoom2.getText());
    float sales = Float.parseFloat(this.accSales2.getText());
    float extra = Float.parseFloat(this.accExtra2.getText());
    float adj = Float.parseFloat(this.accAdj2.getText());
    float total = Float.parseFloat(this.accTotal2.getText()) + adj;
    float amount = Float.parseFloat(this.accPaid2.getText());
    float change = total - amount;
    boolean cont = true;
    if (change <= 0.0F)
    {
      cont = true;
      System.out.println("OK     change: " + change);
    }
    else
    {
      System.out.println("ND     balance: " + change);
      if (JOptionPane.showConfirmDialog(this.account2, "Account balance not settled.\nAre you sure to check out?", "Balance Remaining", 0) == 0) {
        cont = true;
      } else {
        cont = false;
      }
    }
    if (cont) {
      try
      {
        Class.forName("com.mysql.jdbc.Driver");
        String connectionUrl = DBUrl.dbcon;
        Connection con = DriverManager.getConnection(connectionUrl);
        Statement stmt = null;
        ResultSet rs = null;
        String dateNow = this.df.format(Calendar.getInstance().getTime());
        String timeNow = this.tf.format(Calendar.getInstance().getTime());
        String now = dateNow + " " + timeNow;
        
        int sel = this.occuTable.getSelectedRow();
        String selRoom = this.occuTable.getValueAt(sel, 1).toString();
        String guest = this.occuTable.getValueAt(sel, 2).toString();
        
        String inDate = this.occuTable.getValueAt(sel, 3).toString().substring(0, 10);
        String outDate = this.selOut;
        
        float bal = 0.0F;
        
        bal = change;
        


        Statement stmtRec = con.createStatement();
        

        stmtRec.executeUpdate("INSERT INTO `reservation`.`payrecord` (`room`, `guest`, `amount`, `mode`, `datePaid`) SELECT '" + selRoom + "','" + guest + "', `amount`, `mode`, `datePaid` FROM `paycash` WHERE `paycash`.`resID` = " + this.selRes + "; ");
        

        stmtRec.addBatch("DELETE FROM extra WHERE resID = " + this.selRes + ";");
        stmtRec.addBatch("DELETE FROM paycash WHERE resID = " + this.selRes + ";");
        stmtRec.addBatch("DELETE FROM guesttrans WHERE resID = " + this.selRes + ";");
        stmtRec.addBatch("DELETE FROM adjustments WHERE resID = " + this.selRes + ";");
        stmtRec.addBatch("DELETE FROM reservation WHERE resID = " + this.selRes + ";");
        
        stmtRec.executeBatch();
        


        JOptionPane.showMessageDialog(this.account2, "Successfully Checked Out");
        
        String newRoom = this.resRoom2.getSelectedItem().toString();
        String newOut = this.df.format(this.newDateOut.getDate());
        
        PreparedStatement stmt3 = con.prepareStatement("INSERT INTO `reservation`.`reservation` (`roomID`, `guestID`, `inDate`, `outDate`, `stat`) VALUES (?, ?, ?, ?, 'o');");
        
        stmt3.setString(1, newRoom);
        stmt3.setString(2, guest);
        stmt3.setString(3, now);
        stmt3.setString(4, newOut);
        stmt3.executeUpdate();
        int days = Integer.parseInt(this.resDays1.getValue().toString());
        
        float price = getRoomPrice(newRoom);
        double room = price * days;
        
        double disc = 0.0D;
        if (this.discCheck1.isSelected())
        {
          disc = Double.parseDouble(this.resDisc1.getValue().toString()) / 100.0D;
          System.out.println("discount: " + disc);
        }
        room -= room * disc;
        
        Statement stmt4 = con.createStatement();
        ResultSet rs4 = stmt4.executeQuery("SELECT MAX(`resID`) AS `resID` FROM `reservation` ;");
        rs4.next();
        String lastID = rs4.getString("resID");
        System.out.println("inserted" + lastID);
        stmt4.executeUpdate("INSERT INTO `reservation`.`guesttrans` (`guestID`, `resID`, `room`, `disc`, `date`) VALUES ('" + guest + "', '" + lastID + "', '" + room + "', " + disc + ", '" + now + "');");
        

        PreparedStatement stmt5 = null;
        ResultSet rs5 = null;
        stmt5 = con.prepareStatement("INSERT INTO `reservation`.`adjustments` (`guestID`, `resID`, `desc`, `amount`, `date`) VALUES (?, ?, ?, ?, ?);");
        
        stmt5.setString(1, guest);
        stmt5.setString(2, lastID);
        stmt5.setString(3, "accnt from " + selRoom);
        stmt5.setFloat(4, bal);
        stmt5.setString(5, now);
        stmt5.executeUpdate();
        


        new UserLogger().insertLog(Extras.loggeduser, 0, "Checked out guest " + guest);
        loadOccu();
        this.account2.setVisible(false);
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
  
  private void jButton53ActionPerformed(ActionEvent evt)
  {
    System.out.println(this.account2.getSize());
    this.account2.setVisible(false);
  }
  
  private void jButton54ActionPerformed(ActionEvent evt)
  {
    loadSales();
    this.viewSales.setVisible(true);
  }
  
  private void jButton55ActionPerformed(ActionEvent evt)
  {
    loadPayments();
    this.viewPayment.setVisible(true);
  }
  
  private void jButton56ActionPerformed(ActionEvent evt)
  {
    loadExtras();
    this.viewExtra.setVisible(true);
  }
  
  private void jButton57ActionPerformed(ActionEvent evt)
  {
    this.adjustments.setVisible(true);
  }
  
  private void jButton8ActionPerformed(ActionEvent evt)
  {
    int sel = this.occuTable.getSelectedRow();
    if (sel != -1)
    {
      this.selReservation = this.occuTable.getValueAt(sel, 0).toString();
      this.selRoom = this.occuTable.getValueAt(sel, 1).toString();
      
      String selRoom = this.occuTable.getValueAt(sel, 1).toString();
      java.util.Date n = Calendar.getInstance().getTime();
      String inDate = this.occuTable.getValueAt(sel, 3).toString().substring(0, 10);
      String outDate = this.occuTable.getValueAt(sel, 4).toString().substring(0, 10);
      String nowDate = this.df.format(n);
      
      int numDays = 0;
      int diffDays = 0;
      try
      {
        numDays = calcDateDiff(this.df.parse(outDate), this.df.parse(inDate));
        diffDays = calcDateDiff(this.df.parse(outDate), this.df.parse(this.df.format(n)));
      }
      catch (ParseException ex)
      {
        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
      }
      System.out.println("DIFF: " + diffDays + "num: " + numDays);
      
      this.selRes = this.occuTable.getValueAt(sel, 0).toString();
      this.selGuest = this.occuTable.getValueAt(sel, 1).toString();
      try
      {
        Class.forName("com.mysql.jdbc.Driver");
        String connectionUrl = DBUrl.dbcon;
        Connection con = DriverManager.getConnection(connectionUrl);
        Statement stmt = null;
        ResultSet rs = null;ResultSet rsX = null;
        stmt = con.createStatement();
        Statement stmtX = con.createStatement();
        float roomTotal = 0.0F;
        float xtraTotal = 0.0F;
        
        rs = stmt.executeQuery("SELECT room FROM guesttrans WHERE resID='" + this.selRes + "'");
        if (rs.next()) {
          roomTotal = rs.getFloat("room");
        }
        rsX = stmtX.executeQuery("SELECT SUM(xtra) as xtra FROM extra WHERE resID='" + this.selRes + "'");
        if (rsX.next()) {
          xtraTotal = rsX.getFloat("xtra");
        }
        this.accSales2.setText(this.decForm.format(getSales()));
        
        Statement stmt0 = null;
        ResultSet rs0 = null;
        stmt0 = con.createStatement();
        
        rs0 = stmt0.executeQuery("SELECT  extra FROM rooms WHERE roomID='" + selRoom + "'");
        float xtraPrice = 0.0F;
        if (rs0.next()) {
          xtraPrice = rs0.getFloat("extra");
        }
        if (roomTotal == roomTotal / numDays * diffDays) {
          roomTotal /= numDays;
        } else {
          roomTotal -= roomTotal / numDays * diffDays;
        }
        this.accRoom2.setText(this.decForm.format(roomTotal));
        this.accExtra2.setText(this.decForm.format(xtraTotal));
        






        Float sales = Float.valueOf(Float.parseFloat(this.accSales2.getText()));
        
        Float total = Float.valueOf(roomTotal + xtraTotal + sales.floatValue());
        
        this.accTotal2.setText(this.decForm.format(total));
        
        Statement stmt1 = null;
        ResultSet rs1 = null;
        stmt1 = con.createStatement();
        
        rs1 = stmt1.executeQuery("SELECT SUM(`amount`) AS `paid` FROM `paycash` WHERE `resID`='" + this.selRes + "'");
        
        float paid = 0.0F;
        if (rs1.next())
        {
          paid = rs1.getFloat("paid");
          this.accPaid2.setText(this.decForm.format(paid));
        }
        float bal = total.floatValue() - paid;
        

        float adj = loadAdjusts();
        
        this.accAdj2.setText(this.decForm.format(adj));
        
        bal += adj;
        if (bal < 0.0F) {
          this.balLabel2.setText("Refund:");
        } else if (bal > 0.0F) {
          this.balLabel2.setText("Balance:");
        }
        this.accBal2.setText(this.decForm.format(bal));
      }
      catch (SQLException e)
      {
        System.out.println("SQL Exception: " + e.toString());
      }
      catch (ClassNotFoundException cE)
      {
        System.out.println("Class Not Found Exception: " + cE.toString());
      }
      loadAvailToTrans();
      this.resDays1.setValue(Integer.valueOf(1));
      this.discCheck1.setSelected(false);
      this.newRoomRate.setText("");
      this.preAdjSign1.setText("+");
      this.preAdj1.setSelectedIndex(0);
      if (diffDays == 0)
      {
        this.selOut = this.occuTable.getValueAt(sel, 4).toString().substring(0, 10);
        this.account2.setVisible(true);
      }
      else if (JOptionPane.showConfirmDialog(this.occuTable, "Today is " + diffDays + " day(s) earlier.\n" + "Room price may vary. Continue anyway?", "Checkout Confirmation", 0) == 0)
      {
        this.selOut = nowDate;
        this.account2.setVisible(true);
      }
    }
    else
    {
      JOptionPane.showMessageDialog(this.occuTable, "Please select room first", "No room selected", 2);
    }
  }
  
  private void resDays1StateChanged(ChangeEvent evt)
  {
    loadAvailToTrans();
  }
  
  private void resDays1FocusLost(FocusEvent evt) {}
  
  private void resRoom2ActionPerformed(ActionEvent evt)
  {
    calcPrice2();
  }
  
  private void resDisc1StateChanged(ChangeEvent evt) {}
  
  private void discCheck1ActionPerformed(ActionEvent evt)
  {
    if (this.discCheck1.isSelected()) {
      this.resDisc1.setEnabled(true);
    } else {
      this.resDisc1.setEnabled(false);
    }
    this.resDisc1.setValue(Double.valueOf(15.5D));
    calcPrice2();
  }
  
  private void jButton58ActionPerformed(ActionEvent evt)
  {
    int sel = this.occuTable.getSelectedRow();
    if (sel != -1)
    {
      this.selRes = this.occuTable.getValueAt(sel, 0).toString();
      this.selGuest = this.occuTable.getValueAt(sel, 1).toString();
      JOptionPane.showMessageDialog(this.occuTable, "You are about to delete a record.\nPlease consider not doing this too often. This is a critical action.", "Deletion Warning", 2);
      if (JOptionPane.showConfirmDialog(this.occuTable, "Sure to delete this record?", "Deletion Confirmation", 0) == 0) {
        try
        {
          Class.forName("com.mysql.jdbc.Driver");
          String connectionUrl = DBUrl.dbcon;
          Connection con = DriverManager.getConnection(connectionUrl);
          Statement stmtRec = con.createStatement();
          ResultSet rs = null;
          
          stmtRec.addBatch("DELETE FROM extra WHERE resID = " + this.selRes + ";");
          stmtRec.addBatch("DELETE FROM paycash WHERE resID = " + this.selRes + ";");
          stmtRec.addBatch("DELETE FROM guesttrans WHERE resID = " + this.selRes + ";");
          stmtRec.addBatch("DELETE FROM adjustments WHERE resID = " + this.selRes + ";");
          stmtRec.addBatch("DELETE FROM reservation WHERE resID = " + this.selRes + ";");
          
          stmtRec.executeBatch();
          

          JOptionPane.showMessageDialog(this.account, "Deletion Successfully Performed");
          
          new UserLogger().insertLog(Extras.loggeduser, 0, "Transaction Deleted " + this.selGuest);
          loadOccu();
          this.account.setVisible(false);
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
      JOptionPane.showMessageDialog(this.occuTable, "Please select room first", "No room selected", 2);
    }
  }
  
  private void preAdjActionPerformed(ActionEvent evt)
  {
    calcPrice();
  }
  
  private void preAdjSignActionPerformed(ActionEvent evt)
  {
    String sign = this.preAdjSign.getText();
    if (sign.equals("+")) {
      this.preAdjSign.setText("-");
    } else {
      this.preAdjSign.setText("+");
    }
    calcPrice();
  }
  
  private void preAdjSign1ActionPerformed(ActionEvent evt)
  {
    String sign = this.preAdjSign1.getText();
    if (sign.equals("+")) {
      this.preAdjSign1.setText("-");
    } else {
      this.preAdjSign1.setText("+");
    }
    calcPrice2();
  }
  
  private void preAdj1ActionPerformed(ActionEvent evt)
  {
    calcPrice2();
  }
  
  private void jButton12ActionPerformed(ActionEvent evt)
  {
    int sel = this.viewPayTable.getSelectedRow();
    if (sel != -1)
    {
      String selPay = this.viewPayTable.getValueAt(sel, 0).toString();
      JOptionPane.showMessageDialog(this.viewPayTable, "You are about to delete a record.\nPlease consider not doing this too often. This is a critical action.", "Deletion Warning", 2);
      if (JOptionPane.showConfirmDialog(this.viewPayTable, "Sure to delete this record?", "Deletion Confirmation", 0) == 0) {
        try
        {
          Class.forName("com.mysql.jdbc.Driver");
          String connectionUrl = DBUrl.dbcon;
          Connection con = DriverManager.getConnection(connectionUrl);
          Statement stmt = con.createStatement();
          ResultSet rs = null;
          
          stmt.executeUpdate("DELETE FROM `payCash` WHERE `payID` = '" + selPay + "';");
          
          JOptionPane.showMessageDialog(this.viewPayTable, "Deletion Successfully Performed");
          
          new UserLogger().insertLog(Extras.loggeduser, 0, "Payment Deleted " + this.selGuest);
          loadPayments();
          if (this.account.isVisible())
          {
            this.accAdj.setText(this.totalAdj.getText() + "");
            calcBalAcc();
          }
          else if (this.account1.isVisible())
          {
            this.accAdj1.setText(this.totalAdj.getText() + "");
            calcBalAcc1();
          }
          else if (this.account2.isVisible())
          {
            this.accAdj2.setText(this.totalAdj.getText() + "");
            calcBalAcc2();
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
    else
    {
      JOptionPane.showMessageDialog(this.viewPayTable, "Please select room first", "No room selected", 2);
    }
  }
  
  private void jButton59ActionPerformed(ActionEvent evt)
  {
    int sel = this.adjustTable.getSelectedRow();
    if (sel != -1)
    {
      String selAdj = this.adjustTable.getValueAt(sel, 0).toString();
      JOptionPane.showMessageDialog(this.adjustTable, "You are about to delete a record.\nPlease consider not doing this too often. This is a critical action.", "Deletion Warning", 2);
      if (JOptionPane.showConfirmDialog(this.adjustTable, "Sure to delete this record?", "Deletion Confirmation", 0) == 0) {
        try
        {
          Class.forName("com.mysql.jdbc.Driver");
          String connectionUrl = DBUrl.dbcon;
          Connection con = DriverManager.getConnection(connectionUrl);
          Statement stmt = con.createStatement();
          ResultSet rs = null;
          
          stmt.executeUpdate("DELETE FROM `adjustments` WHERE `adjID` = '" + selAdj + "';");
          
          JOptionPane.showMessageDialog(this.adjustTable, "Deletion Successfully Performed");
          
          new UserLogger().insertLog(Extras.loggeduser, 0, "Adjustment Deleted " + this.selGuest);
          loadAdjusts();
          if (this.account.isVisible())
          {
            this.accAdj.setText(this.totalAdj.getText() + "");
            calcBalAcc();
          }
          else if (this.account1.isVisible())
          {
            this.accAdj1.setText(this.totalAdj.getText() + "");
            calcBalAcc1();
          }
          else if (this.account2.isVisible())
          {
            this.accAdj2.setText(this.totalAdj.getText() + "");
            calcBalAcc2();
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
    else
    {
      JOptionPane.showMessageDialog(this.adjustTable, "Please select room first", "No room selected", 2);
    }
  }
  
  private void jButton60ActionPerformed(ActionEvent evt)
  {
    if (this.resGuest.getSelectedIndex() != 0)
    {
      String selGuest = this.resGuest.getSelectedItem().toString();
      loadBalances(selGuest);
      this.balances.setVisible(true);
    }
    else
    {
      JOptionPane.showMessageDialog(this.addRes, "Please select guest first", "No guest selected", 2);
    }
  }
  
  private void jButton61ActionPerformed(ActionEvent evt)
  {
    System.out.println(this.balances.getSize());
    this.balances.setVisible(false);
  }
  
  public static void main(String[] args)
  {
    try
    {
      for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName()))
        {
          UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    }
    catch (ClassNotFoundException ex)
    {
      Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
    }
    catch (InstantiationException ex)
    {
      Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
    }
    catch (IllegalAccessException ex)
    {
      Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
    }
    catch (UnsupportedLookAndFeelException ex)
    {
      Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
    }
    EventQueue.invokeLater(new Runnable()
    {
      public void run()
      {
        new Main().setVisible(true);
      }
    });
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
      
      String dateNow = this.df.format(Calendar.getInstance().getTime());
      java.util.Date timeNow = Calendar.getInstance().getTime();
      
      String resIn = dateNow + " " + this.tf.format(timeNow);
      String resOut = dateAdd(dateNow, 1) + " " + this.tf.format(timeNow);
      System.out.println(resIn + "   " + resOut);
      
      String q = " SELECT DISTINCT `roomID` FROM reservation WHERE  (('" + resIn + "' <= inDate AND '" + resOut + "' >= outDate) OR " + "('" + resIn + "' >= inDate AND '" + resOut + "' <= outDate) OR" + "(('" + resIn + "' >= inDate AND '" + resIn + "' < outDate) AND  '" + resOut + "' >= outDate) OR " + "    ('" + resIn + "' <= inDate AND ('" + resOut + "' <= outDate AND '" + resOut + "' > inDate))) ;";
      


      System.out.println(q);
      rs = stmt.executeQuery(q);
      



      String que = "SELECT * FROM `rooms` WHERE 1=1";
      while (rs.next()) {
        que = que + " AND `roomID` != '" + rs.getString("roomID") + "'";
      }
      System.out.println(que);
      
      int availQuan = new LoadTableRecord().LoadTableRecord(this.vacantTable, new TableModels().vacantModel, que);
      
      this.noVacant.setText(availQuan + "");
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
  
  private void filterAvailRooms()
  {
    try
    {
      Class.forName("com.mysql.jdbc.Driver");
      String connectionUrl = DBUrl.dbcon;
      Connection con = DriverManager.getConnection(connectionUrl);
      Statement stmt = null;
      ResultSet rs = null;
      stmt = con.createStatement();
      
      String dateNow = this.df.format(Calendar.getInstance().getTime());
      java.util.Date timeNow = Calendar.getInstance().getTime();
      
      String resIn = dateNow + " " + this.tf.format(timeNow);
      String resOut = dateAdd(dateNow, 1) + " " + this.tf.format(timeNow);
      System.out.println(resIn + "   " + resOut);
      
      String q = " SELECT DISTINCT `roomID` FROM reservation WHERE  (('" + resIn + "' <= inDate AND '" + resOut + "' >= outDate) OR " + "('" + resIn + "' >= inDate AND '" + resOut + "' <= outDate) OR" + "(('" + resIn + "' >= inDate AND '" + resIn + "' < outDate) AND  '" + resOut + "' >= outDate) OR " + "    ('" + resIn + "' <= inDate AND ('" + resOut + "' <= outDate AND '" + resOut + "' > inDate))) ;";
      


      System.out.println(q);
      rs = stmt.executeQuery(q);
      
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
      String fil = "rooms.roomID LIKE '%" + sRoom + "%'\n" + qType + qVent + " AND rooms.`remarks` LIKE '%" + sRem + "%' ";
      


      String que = "SELECT * FROM `rooms` WHERE " + fil;
      while (rs.next()) {
        que = que + " AND `roomID` != '" + rs.getString("roomID") + "'";
      }
      System.out.println(que);
      
      int availQuan = new LoadTableRecord().LoadTableRecord(this.vacantTable, new TableModels().vacantModel, que);
      
      this.noVacant.setText(availQuan + "");
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
  
  private void loadOccu()
  {
    String now = this.df.format(Calendar.getInstance().getTime());
    String dueq = "";
    if (this.viewDue.isSelected()) {
      dueq = " AND DATEDIFF(DATE(`outdate`), '" + now + "') <= 0 ";
    }
    int num = new LoadReservationRecord1().LoadResRecord(this.occuTable, new TableModels().occuModel, "SELECT *, DATEDIFF(DATE(`outdate`), '" + now + "') AS diff FROM reservation WHERE `stat`='o' " + dueq + " ORDER BY `inDate` DESC");
    
    this.noOccu.setText(num + "");
    loadNotif();
  }
  
  private void filterOccu()
  {
    String now = this.df.format(Calendar.getInstance().getTime());
    String dueq = "";
    if (this.viewDue.isSelected()) {
      dueq = " AND DATEDIFF(DATE(`outdate`), '" + now + "') <= 0 ";
    }
    String sGuest = this.filGuest.getText();
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
    int num = new LoadReservationRecord1().LoadResRecord(this.occuTable, new TableModels().occuModel, "SELECT reservation.*,  DATEDIFF(DATE(reservation.`outdate`), '" + now + "') AS diff FROM reservation, rooms WHERE reservation.guestID LIKE '%" + sGuest + "%' AND reservation.roomID LIKE '%" + sRoom + "%'\n" + qType + qVent + " AND rooms.`remarks` LIKE '%" + sRem + "%' " + dueq + "\n" + "AND reservation.stat = 'o' AND reservation.roomID = rooms.roomID ORDER BY `inDate` DESC");
    



    this.noOccu.setText(num + "");
  }
  
  private void loadRes()
  {
    int num = new LoadReservationRecord().LoadResRecord(this.resTable, new TableModels().resModel, "SELECT * FROM reservation WHERE `stat`='r' ORDER BY `inDate` DESC");
    
    this.noRes.setText(num + "");
  }
  
  private void filterRes()
  {
    String sGuest = this.filGuest.getText();
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
    int num = new LoadReservationRecord().LoadResRecord(this.resTable, new TableModels().resModel, "SELECT reservation.* FROM reservation, rooms WHERE reservation.guestID LIKE '%" + sGuest + "%' AND reservation.roomID LIKE '%" + sRoom + "%'\n" + qType + qVent + " AND rooms.`remarks` LIKE '%" + sRem + "%'\n" + "AND reservation.stat = 'r' AND reservation.roomID = rooms.roomID ORDER BY `inDate` DESC");
    



    this.noRes.setText(num + "");
  }
  
  private String dateAdd(String prev, int days)
  {
    String out = "";
    try
    {
      Class.forName("com.mysql.jdbc.Driver");
      String connectionUrl = DBUrl.dbcon;
      Connection con = DriverManager.getConnection(connectionUrl);
      PreparedStatement stmt = null;
      ResultSet rs = null;
      stmt = con.prepareStatement("SELECT '" + prev + "' + INTERVAL ? DAY AS outDate;");
      stmt.setInt(1, days);
      rs = stmt.executeQuery();
      rs.next();
      out = rs.getDate("outDate").toString();
    }
    catch (SQLException e)
    {
      System.out.println("SQL Exception: " + e.toString());
    }
    catch (ClassNotFoundException cE)
    {
      System.out.println("Class Not Found Exception: " + cE.toString());
    }
    return out;
  }
  
  private java.util.Date calcOutDate(int days, String resIn)
  {
    java.util.Date d = null;
    try
    {
      Class.forName("com.mysql.jdbc.Driver");
      String connectionUrl = DBUrl.dbcon;
      Connection con = DriverManager.getConnection(connectionUrl);
      PreparedStatement stmt = null;
      ResultSet rs = null;
      

      stmt = con.prepareStatement("SELECT '" + resIn + "' + INTERVAL ? DAY AS outDate;");
      stmt.setInt(1, days);
      rs = stmt.executeQuery();
      rs.next();
      
      d = rs.getDate("outDate");
    }
    catch (SQLException e)
    {
      System.out.println("SQL Exception: " + e.toString());
    }
    catch (ClassNotFoundException cE)
    {
      System.out.println("Class Not Found Exception: " + cE.toString());
    }
    return d;
  }
  
  private void setResOut()
  {
    int days = Integer.parseInt(this.resDays.getValue().toString());
    String resIn = this.df.format(this.resDateIn.getDate());
    java.util.Date out = calcOutDate(days, resIn);
    this.resDateOut.setDate(out);
  }
  
  private void setExOut()
  {
    int days = Integer.parseInt(this.exDays.getValue().toString());
    String resIn = this.df.format(this.exCurOut.getDate());
    java.util.Date out = calcOutDate(days, resIn);
    this.exNewOut.setDate(out);
  }
  
  private void setXOut()
  {
    int days = Integer.parseInt(this.xDays.getValue().toString());
    String resIn = this.df.format(this.xDateIn.getDate());
    java.util.Date out = calcOutDate(days, resIn);
    this.xDateOut.setDate(out);
  }
  
  private void setXOut1()
  {
    int days = Integer.parseInt(this.xDays1.getValue().toString());
    String resIn = this.df.format(this.xDateIn1.getDate());
    java.util.Date out = calcOutDate(days, resIn);
    this.xDateOut1.setDate(out);
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
  
  private boolean isNotVacant()
  {
    boolean res = false;
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
      
      String resQ = "";
      if (this.isRes) {
        resQ = " AND `resID` != '" + this.selReservation + "' ";
      }
      String q = " SELECT DISTINCT `roomID` FROM reservation WHERE (roomID ='" + this.selRoom + "' AND (('" + resIn + "' <= inDate AND '" + resOut + "' >= outDate) OR " + "('" + resIn + "' >= inDate AND '" + resOut + "' <= outDate) OR" + "(('" + resIn + "' >= inDate AND '" + resIn + "' < outDate) AND  '" + resOut + "' >= outDate) OR " + "    ('" + resIn + "' <= inDate AND ('" + resOut + "' <= outDate AND '" + resOut + "' > inDate)))) " + resQ + ";";
      




      System.out.println(q);
      rs = stmt.executeQuery(q);
      
      res = rs.next();
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
  
  private boolean isNotVacantEx()
  {
    boolean res = false;
    try
    {
      Class.forName("com.mysql.jdbc.Driver");
      String connectionUrl = DBUrl.dbcon;
      Connection con = DriverManager.getConnection(connectionUrl);
      Statement stmt = null;
      ResultSet rs = null;
      stmt = con.createStatement();
      
      String resIn = this.df.format(this.exCurOut.getDate());
      String resOut = this.df.format(this.exNewOut.getDate());
      
      System.out.println(resIn + "   " + resOut);
      
      String resQ = "";
      
      resQ = " AND `resID` != '" + this.selReservation + "' ";
      

      String q = " SELECT DISTINCT `roomID` FROM reservation WHERE (roomID ='" + this.selRoom + "' AND (('" + resIn + "' <= inDate AND '" + resOut + "' >= outDate) OR " + "('" + resIn + "' >= inDate AND '" + resOut + "' <= outDate) OR" + "(('" + resIn + "' >= inDate AND '" + resIn + "' < outDate) AND  '" + resOut + "' >= outDate) OR " + "    ('" + resIn + "' <= inDate AND ('" + resOut + "' <= outDate AND '" + resOut + "' > inDate)))) " + resQ + ";";
      




      System.out.println(q);
      rs = stmt.executeQuery(q);
      
      res = rs.next();
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
  
  private void filter()
  {
    int sel = this.filStat.getSelectedIndex();
    resetFilters();
    if (sel == 0)
    {
      this.filGuest.setEnabled(true);
      loadOccu();
      this.currentSplit.setRightComponent(this.occu);
    }
    else if (sel == 1)
    {
      this.filGuest.setEnabled(false);
      loadAvailRooms();
      this.currentSplit.setRightComponent(this.vacant);
    }
    else
    {
      this.filGuest.setEnabled(true);
      loadRes();
      this.currentSplit.setRightComponent(this.res);
    }
  }
  
  void calcBal()
  {
    String sAm = this.payAmount.getText();
    if (sAm.length() == 0) {
      sAm = "0";
    }
    try
    {
      float total = Float.parseFloat(this.payTotal.getText());
      float amount = Float.parseFloat(sAm);
      float change = total - amount;
      if (change < 0.0F)
      {
        change = change;
        this.payBalLabel.setText("Refund:");
      }
      else
      {
        this.payBalLabel.setText("Balance:");
      }
      this.payBal.setText(change + "");
    }
    catch (Exception e)
    {
      this.payAmount.setText(sAm.substring(0, sAm.length() - 1));
    }
  }
  
  void calcBalAcc()
  {
    String sAm = this.accTendered.getText();
    if (sAm.length() == 0) {
      sAm = "0";
    }
    try
    {
      float total = Float.parseFloat(this.accTotal.getText());
      float amount = Float.parseFloat(sAm) + Float.parseFloat(this.accPaid.getText());
      float change = total - amount;
      

      float adj = loadAdjusts();
      
      this.accAdj.setText(this.decForm.format(adj));
      
      change += adj;
      if (change < 0.0F)
      {
        change = change;
        this.balLabel.setText("Change:");
      }
      else
      {
        this.balLabel.setText("Balance:");
      }
      this.accBal.setText(this.decForm.format(change));
    }
    catch (Exception e)
    {
      this.accTendered.setText(sAm.substring(0, sAm.length() - 1));
    }
  }
  
  void calcBalAcc1()
  {
    String sAm = this.accTendered1.getText();
    if (sAm.length() == 0) {
      sAm = "0";
    }
    try
    {
      float total = Float.parseFloat(this.accTotal1.getText());
      float amount = Float.parseFloat(sAm) + Float.parseFloat(this.accPaid1.getText());
      float change = total - amount;
      
      float adj = loadAdjusts();
      
      this.accAdj1.setText(this.decForm.format(adj));
      
      change += adj;
      if (change < 0.0F)
      {
        change = change;
        this.balLabel1.setText("Change:");
      }
      else
      {
        this.balLabel1.setText("Balance:");
      }
      this.accBal1.setText(this.decForm.format(change));
    }
    catch (Exception e)
    {
      this.accTendered1.setText(sAm.substring(0, sAm.length() - 1));
    }
  }
  
  void calcBalAcc2()
  {
    try
    {
      float total = Float.parseFloat(this.accTotal2.getText());
      float amount = Float.parseFloat(this.accPaid2.getText());
      float change = total - amount;
      
      float adj = loadAdjusts();
      
      this.accAdj2.setText(this.decForm.format(adj));
      
      change += adj;
      if (change < 0.0F)
      {
        change = change;
        this.balLabel2.setText("Change:");
      }
      else
      {
        this.balLabel2.setText("Balance:");
      }
      this.accBal2.setText(this.decForm.format(change));
    }
    catch (Exception e) {}
  }
  
  private int calcDateDiff(java.util.Date end, java.util.Date start)
  {
    int res = -1;
    DateTime startDate = new DateTime(start);
    DateTime endDate = new DateTime(end);
    Days d = Days.daysBetween(startDate, endDate);
    System.out.println(startDate + "-" + endDate + "=" + d.getDays());
    res = d.getDays();
    return res;
  }
  
  private void calcPrice()
  {
    int days = Integer.parseInt(this.resDays.getValue().toString());
    double xtra = Double.parseDouble(this.resExtra.getText());
    
    double price = days * this.selPrice;
    System.out.println("price:" + price);
    double disc = 0.0D;
    if (this.discCheck.isSelected())
    {
      disc = Double.parseDouble(this.resDisc.getValue().toString()) / 100.0D;
      System.out.println("discount: " + disc);
    }
    price -= price * disc;
    System.out.println("final: " + price);
    double finPrice = price + xtra;
    if (this.preAdj.getSelectedIndex() != 0)
    {
      double adj = Double.parseDouble(this.preAdjSign.getText() + this.preAdj.getSelectedItem().toString());
      System.out.println("Pre-adj:" + adj);
      finPrice += adj;
    }
    this.resRate.setText(finPrice + "");
  }
  
  private void calcPrice2()
  {
    if (this.resRoom2.getSelectedIndex() != 0)
    {
      int days = Integer.parseInt(this.resDays1.getValue().toString());
      String selRoom = this.resRoom2.getSelectedItem().toString();
      float roomPrice = getRoomPrice(selRoom);
      double price = days * roomPrice;
      System.out.println("price:" + price);
      double disc = 0.0D;
      if (this.discCheck1.isSelected())
      {
        disc = Double.parseDouble(this.resDisc1.getValue().toString()) / 100.0D;
        System.out.println("discount: " + disc);
      }
      price -= price * disc;
      System.out.println("final: " + price);
      double finPrice = price;
      if (this.preAdj1.getSelectedIndex() != 0)
      {
        double adj = Double.parseDouble(this.preAdjSign1.getText() + this.preAdj1.getSelectedItem().toString());
        System.out.println("Pre-adj:" + adj);
        finPrice += adj;
      }
      this.newRoomRate.setText(finPrice + "");
    }
    else
    {
      this.newRoomRate.setText("");
    }
  }
  
  private void calcPriceEx()
  {
    int days = Integer.parseInt(this.exDays.getValue().toString());
    double xtra = Double.parseDouble(this.exExtra.getText());
    
    double price = days * this.selPrice;
    System.out.println("price:" + price);
    double disc = 0.0D;
    
    disc = Double.parseDouble(this.exDisc.getValue().toString()) / 100.0D;
    System.out.println("discount: " + disc);
    
    price -= price * disc;
    System.out.println("final: " + price);
    this.exRate.setText(price + xtra + "");
  }
  
  private void filSugRoom()
  {
    DateTime dt = new DateTime(this.sugCal.getDate());
    int m = dt.getMonthOfYear();
    int y = dt.getYear();
    int dblines = Integer.parseInt(this.sugDays.getValue().toString());
    String roomQ = "";
    
    roomQ = " AND `roomID`='" + this.sugRooms.getSelectedItem().toString() + "'";
    


    System.out.println("db lines: " + dblines);
    DefaultTableModel model = new TableModels().suggestModel;
    try
    {
      Class.forName("com.mysql.jdbc.Driver");
      String connectionUrl = DBUrl.dbcon;
      Connection con = DriverManager.getConnection(connectionUrl);
      


      Statement stmt = con.createStatement();Statement stmt0 = con.createStatement();
      String SQL0 = "SELECT DATE(`reservation`.`outDate`) AS outDate, DATE(`reservation`.`inDate`) AS inDate FROM `reservation` WHERE ((MONTH(`inDate`)= " + m + " AND YEAR(`inDate`) = " + y + ") OR (MONTH(`outDate`)= " + m + " AND YEAR(`outDate`) = " + y + "))" + roomQ;
      
      System.out.println(SQL0);
      ResultSet rs0 = stmt0.executeQuery(SQL0);
      String q = "SELECT  DISTINCT `dates`.* FROM `dates` WHERE 1=1 ";
      while (rs0.next()) {
        q = q + " AND ((`dates`.`inDate` >= '" + rs0.getString("outDate") + "')" + " OR (`dates`.`outDate` <= '" + rs0.getString("inDate") + "'))";
      }
      System.out.println(q);
      ResultSet rs = stmt.executeQuery(q);
      

      int i1 = 0;
      boolean isBreak = true;
      rs.next();
      int i = rs.getInt(1);
      rs.next();
      int i2 = rs.getInt(1);
      if (i + 1 == i2)
      {
        i1++;
        isBreak = false;
      }
      else
      {
        isBreak = true;
      }
      rs.previous();
      System.out.println("Index" + rs.getInt(1) + "-->" + (i + 1) + "--" + i);
      
      int r = 0;
      while (rs.next())
      {
        System.out.println("currIndex" + rs.getInt(1) + "-->" + (i + 1) + "--" + rs.getInt(1));
        if (i + 1 == rs.getInt(1))
        {
          if (isBreak) {
            i1 += 2;
          } else {
            i1++;
          }
          isBreak = false;
          System.out.println("i1--" + i1);
          if (i1 == dblines)
          {
            String e = rs.getString("outDate");
            for (int c = 0; c < dblines - 1; c++) {
              rs.previous();
            }
            String s = rs.getString("inDate");
            for (int c = 0; c < dblines - 1; c++) {
              rs.next();
            }
            System.out.println(s + "-" + e);
            model.addRow(new Object[0]);
            model.setValueAt(s, r, 0);
            model.setValueAt(e, r, 1);
            r++;
            i1 = 0;
          }
        }
        else
        {
          i1 = 0;
          isBreak = true;
        }
        i = rs.getInt(1);
      }
      this.suggestTable.setModel(model);
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
  
  private void filSugDate()
  {
    java.util.Date selDate = this.sugCal.getDate();
    
    DateTime dt = new DateTime(selDate);
    int i = dt.getMonthOfYear();
    
    int selM = i;
    try
    {
      Class.forName("com.mysql.jdbc.Driver");
      String connectionUrl = DBUrl.dbcon;
      Connection con = DriverManager.getConnection(connectionUrl);
      Statement stmt = null;
      ResultSet rs = null;
      stmt = con.createStatement();
      
      stmt.executeUpdate("DELETE FROM `dates`");
      
      String query = "INSERT INTO `reservation`.`dates` (`dateID`, `inDate`, `outDate`) VALUES";
      int counter = 1;
      String in = null;
      String out = null;
      DateTime local = dt.dayOfMonth().withMaximumValue();
      int max = local.getDayOfMonth();
      
      System.out.println("max: " + max);
      while ((i == selM) && (dt.getDayOfMonth() < max))
      {
        i = dt.getMonthOfYear();
        query = query + " (" + counter + ", ";
        in = dt.toString(this.jodaDF);
        query = query + "'" + in + "', ";
        dt = dt.plusDays(1);
        out = dt.toString(this.jodaDF);
        query = query + "'" + out + "'),";
        

        counter++;
        
        System.out.println(in);
      }
      query = query.substring(0, query.length() - 1);
      System.out.println(query);
      
      stmt.executeUpdate(query);
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
  
  private void calcXPrice()
  {
    int d = Integer.parseInt(this.xDays.getValue().toString());
    int q = Integer.parseInt(this.xQuan.getValue().toString());
    float price = d * q * this.selExtra;
    this.xPrice.setText(price + "");
  }
  
  private void calcXPrice1()
  {
    int d = Integer.parseInt(this.xDays1.getValue().toString());
    int q = Integer.parseInt(this.xQuan1.getValue().toString());
    float price = d * q * this.selExtra;
    this.xPrice1.setText(price + "");
  }
  
  private void loadSug()
  {
    filSugDate();
    filSugRoom();
  }
  
  private void loadRooms()
  {
    try
    {
      Class.forName("com.mysql.jdbc.Driver");
      String connectionUrl = DBUrl.dbcon;
      Connection con = DriverManager.getConnection(connectionUrl);
      Statement stmt = null;
      ResultSet rs = null;
      
      stmt = con.createStatement();
      rs = stmt.executeQuery("SELECT `roomID` FROM `rooms`");
      rs.next();
      this.sugRooms.setModel(new DefaultComboBoxModel(new String[] { rs.getString("roomID") }));
      while (rs.next()) {
        this.sugRooms.addItem(rs.getString("roomID"));
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
  
  private void loadPayments()
  {
    float total = new LoadPayment().LoadPayment(this.viewPayTable, new TableModels().viewPayModel, "SELECT `payID`, IF(mode = 'credit', 'Credit Card', IF(mode='cash', 'Cash', 'Check')) AS `mode`, DATE(`datePaid`), amount FROM paycash WHERE resID = '" + this.selRes + "' ORDER BY `payID` DESC;", 3);
    

    this.viewTotal.setText(this.decForm.format(total));
    this.accPaid.setText(this.decForm.format(total));
    this.accPaid1.setText(this.decForm.format(total));
  }
  
  private void loadSales()
  {
    new LoadSales().LoadSales(this.viewSaleTable, new TableModels().viewSaleModel, "SELECT `transaction`.`date`, `sale`.productName,  `sale`.`quan`, `sale`.`price`, `sale`.`amount` FROM `sale`, `transaction` \nWHERE `sale`.transID = `transaction`.transID AND `transaction`.cust = '" + this.selGuest + "::" + this.selRes + "';", 2);
    

    getSalesAcc();
  }
  
  private void loadExtras()
  {
    float total = new LoadExtras().LoadExtras(this.viewExtraTable, new TableModels().viewExtraModel, "SELECT `xtra`, `quan`, `xDateIn`, `xDateOut` FROM extra WHERE resID = '" + this.selRes + "' ORDER BY `xID` DESC;", 0);
    
    this.viewTotal2.setText(this.decForm.format(total));
  }
  
  private float getSales()
  {
    float total = 0.0F;
    try
    {
      Class.forName("com.mysql.jdbc.Driver");
      String connectionUrl = DBUrl.dbconSales;
      Connection con = DriverManager.getConnection(connectionUrl);
      Statement stmt = null;
      ResultSet rs = null;
      
      stmt = con.createStatement();
      rs = stmt.executeQuery("SELECT SUM(`tenCharge`) as `total` FROM  `transaction` WHERE `transaction`.cust = '" + this.selGuest + "::" + this.selRes + "';");
      
      System.out.println("SELECT SUM(`tenCharge`) as `total` FROM  `transaction` WHERE `transaction`.cust = '" + this.selGuest + "::" + this.selRes + "';");
      if (rs.next()) {
        total = rs.getFloat("total");
      }
      System.out.println("total Sales:" + total);
    }
    catch (SQLException e)
    {
      System.out.println("SQL Exception: " + e.toString());
    }
    catch (ClassNotFoundException cE)
    {
      System.out.println("Class Not Found Exception: " + cE.toString());
    }
    return total;
  }
  
  private int updateSalesCust()
  {
    int res = 0;
    String selNew = this.resRoom.getSelectedItem().toString();
    try
    {
      Class.forName("com.mysql.jdbc.Driver");
      String connectionUrl = DBUrl.dbcon;
      Connection con = DriverManager.getConnection(connectionUrl);
      Statement stmt = null;
      ResultSet rs = null;
      
      stmt = con.createStatement();
      res = stmt.executeUpdate("UPDATE `database`.`transaction` SET `cust`='" + selNew + "::" + this.selReservation + "' WHERE  `cust`='" + this.selRoom + "::" + this.selReservation + "';");
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
  
  private void filterCurrent()
  {
    int sel = this.filStat.getSelectedIndex();
    if (sel == 0) {
      filterOccu();
    } else if (sel == 1) {
      filterAvailRooms();
    } else {
      filterRes();
    }
  }
  
  private void resetFilters()
  {
    this.filGuest.setText("");
    this.filRoom.setText("");
    this.filType.setSelectedIndex(0);
    this.filVent.setSelectedIndex(0);
    this.filRem.setText("");
  }
  
  private void loadNotif()
  {
    try
    {
      Class.forName("com.mysql.jdbc.Driver");
      String connectionUrl = DBUrl.dbcon;
      Connection con = DriverManager.getConnection(connectionUrl);
      
      Statement stmt = null;
      ResultSet rs = null;
      stmt = con.createStatement();
      
      String now = this.df.format(Calendar.getInstance().getTime());
      
      rs = stmt.executeQuery("SELECT roomID, guestID, DATE(outDate) AS outDate, 'Occupation Due' AS rem FROM reservation WHERE `stat`='o' AND DATEDIFF(DATE(`outdate`), '" + now + "') <= 0  ORDER BY `inDate` DESC");
      

      int r = 0;
      DefaultTableModel model = new TableModels().notifModel;
      if (rs.next())
      {
        rs.beforeFirst();
        while (rs.next())
        {
          model.addRow(new Object[] { "" });
          model.setValueAt(rs.getString("roomID"), r, 0);
          model.setValueAt(rs.getString("guestID"), r, 1);
          model.setValueAt(rs.getString("outDate"), r, 2);
          model.setValueAt(rs.getString("rem"), r, 3);
          
          r++;
        }
        this.notifTable.setModel(model);
        this.notifMenu.setText("Notifications(" + r + ")");
        
        this.notifMenu.setForeground(new Color(255, 0, 0));
      }
      else
      {
        this.notifMenu.setText("Notifications(" + r + ")");
        this.notifMenu.setForeground(new Color(0, 0, 0));
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
  
  private float loadAdjusts()
  {
    float total = new LoadPayment().LoadPayment(this.adjustTable, new TableModels().adjustModel, "SELECT `adjID`, `desc`, DATE(`date`), `amount` FROM adjustments WHERE `resID`='" + this.selRes + "';", 3);
    
    this.totalAdj.setText(this.decForm.format(total));
    
    return total;
  }
  
  private void updateSalesCust(String trans, String creditCust, String purCredit, String purDate)
  {
    try
    {
      Class.forName("com.mysql.jdbc.Driver");
      String connectionUrl = DBUrl.dbconSales;
      Connection con = DriverManager.getConnection(connectionUrl);
      Statement stmt = con.createStatement();
      stmt.executeUpdate("INSERT INTO `credit` (`transID`, `cust`, `amount`, `transDate`, `stat`) VALUES ('" + trans + "', '" + creditCust + "', " + purCredit + ", '" + purDate + "', " + 1 + ");");
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
  
  private float getSalesAcc()
  {
    float total = 0.0F;
    float unpaid = 0.0F;
    float paid = 0.0F;
    try
    {
      Class.forName("com.mysql.jdbc.Driver");
      String connectionUrl = DBUrl.dbconSales;
      Connection con = DriverManager.getConnection(connectionUrl);
      Statement stmt = null;
      ResultSet rs = null;
      
      stmt = con.createStatement();
      rs = stmt.executeQuery("SELECT SUM(`tenCharge`) as `total`, IFNULL(SUM(`tenCash`), 0) + IFNULL(SUM(`tenCheck`), 0) + IFNULL(SUM(`tenCredit`), 0) AS `paid`FROM  `transaction` WHERE `transaction`.cust = '" + this.selGuest + "::" + this.selRes + "';");
      


      System.out.println("SELECT SUM(`tenCharge`) as `total`, IFNULL(SUM(`tenCash`), 0) + IFNULL(SUM(`tenCheck`), 0) + IFNULL(SUM(`tenCredit`), 0) AS `paid`FROM  `transaction` WHERE `transaction`.cust = '" + this.selGuest + "::" + this.selRes + "';");
      if (rs.next())
      {
        unpaid = rs.getFloat("total");
        paid = rs.getFloat("paid");
        total = unpaid + paid;
      }
      System.out.println("charge Sales:" + unpaid);
      System.out.println("paid Sales:" + paid);
      this.viewTotal1.setText(this.decForm.format(total));
      this.viewUnpaid1.setText(this.decForm.format(unpaid));
      this.viewPaid1.setText(this.decForm.format(paid));
    }
    catch (SQLException e)
    {
      System.out.println("SQL Exception: " + e.toString());
    }
    catch (ClassNotFoundException cE)
    {
      System.out.println("Class Not Found Exception: " + cE.toString());
    }
    return unpaid;
  }
  
  private float getRoomPrice(String roomID)
  {
    float price = 0.0F;
    try
    {
      Class.forName("com.mysql.jdbc.Driver");
      String connectionUrl = DBUrl.dbcon;
      Connection con = DriverManager.getConnection(connectionUrl);
      Statement stmt0 = null;
      ResultSet rs0 = null;
      stmt0 = con.createStatement();
      
      rs0 = stmt0.executeQuery("SELECT price FROM rooms WHERE roomID='" + roomID + "'");
      if (rs0.next()) {
        price = rs0.getFloat("price");
      }
      System.out.println(roomID + "--------->>" + price);
    }
    catch (SQLException e)
    {
      System.out.println("SQL Exception: " + e.toString());
    }
    catch (ClassNotFoundException cE)
    {
      System.out.println("Class Not Found Exception: " + cE.toString());
    }
    return price;
  }
  
  private void resetPaymentFields()
  {
    this.payMode.setSelectedIndex(0);
    this.payAmount.setText("");
  }
  
  private void resetAddresFields()
  {
    this.resDays.setValue(Integer.valueOf(1));
    this.resGuest.setSelectedIndex(0);
    this.discCheck.setSelected(false);
    this.resDisc.setValue(Double.valueOf(15.5D));
  }
  
  private void loadAvailToTrans()
  {
    int sel = this.occuTable.getSelectedRow();
    if (sel != -1)
    {
      this.selReservation = this.occuTable.getValueAt(sel, 0).toString();
      this.selRoom = this.occuTable.getValueAt(sel, 1).toString();
      try
      {
        Class.forName("com.mysql.jdbc.Driver");
        String connectionUrl = DBUrl.dbcon;
        Connection con = DriverManager.getConnection(connectionUrl);
        Statement stmt = null;
        ResultSet rs = null;
        stmt = con.createStatement();
        
        Statement stmt1 = null;
        ResultSet rs1 = null;
        stmt1 = con.createStatement();
        rs1 = stmt1.executeQuery("SELECT type, vent FROM rooms WHERE roomID='" + this.selRoom + "'");
        rs1.next();
        java.util.Date now = Calendar.getInstance().getTime();
        String resIn = this.df.format(now) + " " + this.tf.format(now);
        int numOfDays = Integer.parseInt(this.resDays1.getValue().toString());
        java.util.Date newOut = calcOutDate(numOfDays, resIn);
        this.newDateOut.setDate(newOut);
        
        String resOut = this.df.format(newOut);
        System.out.println(resIn + "   " + resOut);
        
        String updateQ = "";
        

        updateQ = " AND `resID` != '" + this.selReservation + "' ";
        

        String q = " SELECT DISTINCT `roomID` FROM reservation WHERE  (('" + resIn + "' <= inDate AND '" + resOut + "' >= outDate) OR " + "('" + resIn + "' >= inDate AND '" + resOut + "' <= outDate) OR" + "(('" + resIn + "' >= inDate AND '" + resIn + "' < outDate) AND  '" + resOut + "' >= outDate) OR " + "    ('" + resIn + "' <= inDate AND ('" + resOut + "' <= outDate AND '" + resOut + "' > inDate))) " + updateQ + ";";
        


        System.out.println(q);
        rs = stmt.executeQuery(q);
        
        this.resRoom2.setModel(new DefaultComboBoxModel(new String[] { "Select" }));
        
        String roomFil = "";
        






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
          this.resRoom2.addItem(rs0.getString("roomID"));
        }
        this.resRoom2.removeItem(this.selRoom);
        availQuan = this.resRoom2.getItemCount() - 1;
        if (availQuan > 0)
        {
          this.roomLabel2.setText("Transfer to(" + availQuan + "):");
          this.resRoom2.setEnabled(true);
          this.roomLabel2.setForeground(new Color(255, 255, 255));
        }
        else
        {
          this.roomLabel2.setText("Transfer to(" + availQuan + "):");
          this.resRoom2.setEnabled(false);
          this.roomLabel2.setForeground(new Color(255, 102, 102));
          JOptionPane.showMessageDialog(this.transRoom, "Sorry. No available room.", "Reservation Full", 2);
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
      JOptionPane.showMessageDialog(this.occuTable, "Please select room first", "No room selected", 2);
    }
  }
  
  private void loadBalances(String selGuest)
  {
    float total = new LoadPayment().LoadPayment(this.balancesTable, new TableModels().balancesModel, "SELECT `bal`, `dateOut`, `room`  FROM `resrecords` WHERE `guest` = '" + selGuest + "' AND `bal`!=0", 0);
    
    this.viewTotal.setText(this.decForm.format(total));
    this.totalBal.setText(this.decForm.format(total));
  }
}



/* Location:           D:\New folder\New folder\dist\11thPrototype.jar

 * Qualified Name:     MainForms.Main

 * JD-Core Version:    0.7.0.1

 */