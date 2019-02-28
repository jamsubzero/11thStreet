package MainForms;

import Fields.DBUrl;
import Fields.Extras;
import Fields.TableModels;
import Methods.UserLogger;
import Reports.CheckedOut;
import Reports.CurrentReport;
import Reports.IncomeReport;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.LayoutStyle;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import org.jdesktop.swingx.JXDatePicker;

public class Report
  extends JPanel
{
  private int selr;
  
  public Report()
  {
    initComponents();
    LoadCurrentReport();
    LoadOutReport();
    LoadOutIncome();
  }
  
  SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
  SimpleDateFormat tf = new SimpleDateFormat("HH:mm");
  DecimalFormat decForm = new DecimalFormat("#0.00");
  private JLabel account;
  private JFormattedTextField adjAmount;
  private JLabel bal;
  private JLabel balance;
  private JLabel cash;
  private JLabel check;
  private JLabel credit;
  private JTable currentReportTable;
  private JSpinner days;
  private JSpinner days1;
  private JXDatePicker from;
  private JXDatePicker from1;
  private JButton jButton1;
  private JButton jButton2;
  private JButton jButton3;
  private JButton jButton4;
  private JButton jButton50;
  private JButton jButton51;
  private JLabel jLabel1;
  private JLabel jLabel10;
  private JLabel jLabel11;
  private JLabel jLabel12;
  private JLabel jLabel13;
  private JLabel jLabel14;
  private JLabel jLabel15;
  private JLabel jLabel18;
  private JLabel jLabel19;
  private JLabel jLabel2;
  private JLabel jLabel20;
  private JLabel jLabel21;
  private JLabel jLabel22;
  private JLabel jLabel3;
  private JLabel jLabel4;
  private JLabel jLabel6;
  private JLabel jLabel68;
  private JLabel jLabel69;
  private JLabel jLabel7;
  private JLabel jLabel8;
  private JLabel jLabel9;
  private JPanel jPanel1;
  private JPanel jPanel10;
  private JPanel jPanel11;
  private JPanel jPanel2;
  private JPanel jPanel3;
  private JPanel jPanel33;
  private JPanel jPanel4;
  private JPanel jPanel5;
  private JPanel jPanel6;
  private JPanel jPanel7;
  private JScrollPane jScrollPane1;
  private JScrollPane jScrollPane2;
  private JScrollPane jScrollPane3;
  private JSeparator jSeparator19;
  private JTabbedPane jTabbedPane1;
  private JTextField jTextField1;
  private JLabel noOfRec;
  private JLabel noOfRec1;
  private JLabel noOfRec2;
  private JTable outIncomeTable;
  private JTable outReportTable;
  private JLabel paid;
  private JDialog payBal;
  private JComboBox payMode;
  private JLabel room;
  private JLabel sales;
  private JXDatePicker to;
  private JXDatePicker to1;
  private JLabel total;
  private JLabel totalIncome;
  private JToggleButton viewBal;
  
  private void initComponents()
  {
    this.payBal = new JDialog();
    this.jPanel33 = new JPanel();
    this.jLabel68 = new JLabel();
    this.jLabel69 = new JLabel();
    this.adjAmount = new JFormattedTextField();
    this.jButton50 = new JButton();
    this.jSeparator19 = new JSeparator();
    this.jButton51 = new JButton();
    this.payMode = new JComboBox();
    this.jTabbedPane1 = new JTabbedPane();
    this.jPanel3 = new JPanel();
    this.jScrollPane3 = new JScrollPane();
    this.currentReportTable = new JTable();
    this.jPanel10 = new JPanel();
    this.noOfRec2 = new JLabel();
    this.jLabel18 = new JLabel();
    this.account = new JLabel();
    this.jLabel19 = new JLabel();
    this.paid = new JLabel();
    this.jLabel20 = new JLabel();
    this.jLabel21 = new JLabel();
    this.balance = new JLabel();
    this.jButton3 = new JButton();
    this.jPanel11 = new JPanel();
    this.jLabel22 = new JLabel();
    this.jTextField1 = new JTextField();
    this.jPanel6 = new JPanel();
    this.jScrollPane1 = new JScrollPane();
    this.outReportTable = new JTable();
    this.jPanel1 = new JPanel();
    this.jLabel2 = new JLabel();
    this.bal = new JLabel();
    this.noOfRec = new JLabel();
    this.jLabel6 = new JLabel();
    this.room = new JLabel();
    this.jLabel8 = new JLabel();
    this.sales = new JLabel();
    this.jLabel10 = new JLabel();
    this.jLabel11 = new JLabel();
    this.total = new JLabel();
    this.jPanel2 = new JPanel();
    this.jLabel4 = new JLabel();
    this.to = new JXDatePicker();
    this.days = new JSpinner();
    this.jLabel1 = new JLabel();
    this.from = new JXDatePicker();
    this.viewBal = new JToggleButton();
    this.jButton1 = new JButton();
    this.jButton4 = new JButton();
    this.jPanel7 = new JPanel();
    this.jScrollPane2 = new JScrollPane();
    this.outIncomeTable = new JTable();
    this.jPanel4 = new JPanel();
    this.jLabel3 = new JLabel();
    this.totalIncome = new JLabel();
    this.noOfRec1 = new JLabel();
    this.jLabel7 = new JLabel();
    this.cash = new JLabel();
    this.jLabel9 = new JLabel();
    this.credit = new JLabel();
    this.jLabel12 = new JLabel();
    this.jLabel13 = new JLabel();
    this.check = new JLabel();
    this.jPanel5 = new JPanel();
    this.jLabel14 = new JLabel();
    this.days1 = new JSpinner();
    this.jLabel15 = new JLabel();
    this.from1 = new JXDatePicker();
    this.to1 = new JXDatePicker();
    this.jButton2 = new JButton();
    
    this.payBal.setTitle("New Adjustment");
    this.payBal.setMinimumSize(new Dimension(304, 213));
    this.payBal.setModal(true);
    this.payBal.setResizable(false);
    
    this.jPanel33.setBackground(new Color(51, 0, 153));
    
    this.jLabel68.setText("Mode:");
    this.jLabel68.setForeground(new Color(255, 255, 255));
    
    this.jLabel69.setText("Amount:");
    this.jLabel69.setForeground(new Color(255, 255, 255));
    
    this.adjAmount.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));
    
    this.jButton50.setText("Pay");
    this.jButton50.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Report.this.jButton50ActionPerformed(evt);
      }
    });
    this.jButton51.setText("Cancel");
    this.jButton51.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Report.this.jButton51ActionPerformed(evt);
      }
    });
    this.payMode.setModel(new DefaultComboBoxModel(new String[] { "Cash", "Credit Card", "Check" }));
    
    GroupLayout jPanel33Layout = new GroupLayout(this.jPanel33);
    this.jPanel33.setLayout(jPanel33Layout);
    jPanel33Layout.setHorizontalGroup(jPanel33Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel33Layout.createSequentialGroup().addContainerGap().addGroup(jPanel33Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jSeparator19).addGroup(jPanel33Layout.createSequentialGroup().addGroup(jPanel33Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel69).addComponent(this.jLabel68)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel33Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.payMode, 0, -1, 32767).addComponent(this.adjAmount))).addGroup(jPanel33Layout.createSequentialGroup().addComponent(this.jButton50, -2, 101, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 62, 32767).addComponent(this.jButton51, -2, 101, -2))).addContainerGap()));
    


















    jPanel33Layout.setVerticalGroup(jPanel33Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel33Layout.createSequentialGroup().addGap(14, 14, 14).addGroup(jPanel33Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.payMode, -1, 37, 32767).addComponent(this.jLabel68, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel33Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.adjAmount, -1, 32, 32767).addComponent(this.jLabel69, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jSeparator19, -2, 10, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel33Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jButton50, -2, 31, -2).addComponent(this.jButton51, -2, 31, -2)).addContainerGap(44, 32767)));
    


















    GroupLayout payBalLayout = new GroupLayout(this.payBal.getContentPane());
    this.payBal.getContentPane().setLayout(payBalLayout);
    payBalLayout.setHorizontalGroup(payBalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(payBalLayout.createSequentialGroup().addContainerGap().addComponent(this.jPanel33, -1, -1, 32767).addContainerGap()));
    





    payBalLayout.setVerticalGroup(payBalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(payBalLayout.createSequentialGroup().addContainerGap().addComponent(this.jPanel33, -1, -1, 32767).addContainerGap()));
    






    this.jTabbedPane1.addChangeListener(new ChangeListener()
    {
      public void stateChanged(ChangeEvent evt)
      {
        Report.this.jTabbedPane1StateChanged(evt);
      }
    });
    this.jPanel3.setBorder(BorderFactory.createBevelBorder(0));
    
    this.currentReportTable.setFont(new Font("Tahoma", 0, 12));
    this.currentReportTable.setModel(new DefaultTableModel(new Object[0][], new String[] { "Room", "Guest", "Room Price", "Discount", "Extra", "Adjustments", "Sales", "Total", "Paid", "Balance", "Date In", "Date Out" })
    {
      boolean[] canEdit = { false, false, false, false, false, false, false, false, false, false, false, false };
      
      public boolean isCellEditable(int rowIndex, int columnIndex)
      {
        return this.canEdit[columnIndex];
      }
    });
    this.currentReportTable.setRowHeight(27);
    this.currentReportTable.getTableHeader().setReorderingAllowed(false);
    this.jScrollPane3.setViewportView(this.currentReportTable);
    
    this.jPanel10.setBackground(new Color(51, 0, 153));
    this.jPanel10.setBorder(BorderFactory.createTitledBorder(null, "Statistics", 0, 0, null, Color.white));
    
    this.noOfRec2.setText("0");
    this.noOfRec2.setForeground(new Color(255, 102, 102));
    
    this.jLabel18.setText("No. Of Records:");
    this.jLabel18.setForeground(new Color(255, 255, 255));
    
    this.account.setText("0");
    this.account.setForeground(new Color(255, 102, 102));
    
    this.jLabel19.setText("Accumulated Account:");
    this.jLabel19.setForeground(new Color(255, 255, 255));
    
    this.paid.setText("0");
    this.paid.setForeground(new Color(255, 102, 102));
    
    this.jLabel20.setText("Total Paid:");
    this.jLabel20.setForeground(new Color(255, 255, 255));
    
    this.jLabel21.setText("Total Balance:");
    this.jLabel21.setForeground(new Color(255, 255, 255));
    
    this.balance.setText("0");
    this.balance.setForeground(new Color(255, 102, 102));
    
    GroupLayout jPanel10Layout = new GroupLayout(this.jPanel10);
    this.jPanel10.setLayout(jPanel10Layout);
    jPanel10Layout.setHorizontalGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel18).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.noOfRec2, -2, 81, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel19).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.account, -2, 81, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel20).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.paid, -2, 81, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel21).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.balance, -2, 124, -2).addContainerGap(141, 32767)));
    



















    jPanel10Layout.setVerticalGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup().addContainerGap().addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel18, -1, 24, 32767).addComponent(this.noOfRec2, -1, -1, 32767).addComponent(this.jLabel19, -1, 24, 32767).addComponent(this.account, -1, -1, 32767).addComponent(this.jLabel20, -1, 24, 32767).addComponent(this.paid, -1, -1, 32767).addComponent(this.jLabel21, -1, 24, 32767).addComponent(this.balance, -1, -1, 32767)).addContainerGap()));
    














    this.jButton3.setText("Print Report");
    this.jButton3.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Report.this.jButton3ActionPerformed(evt);
      }
    });
    this.jPanel11.setBackground(new Color(51, 0, 153));
    this.jPanel11.setBorder(BorderFactory.createTitledBorder(null, "Filter By", 0, 0, null, Color.white));
    
    this.jLabel22.setText("Room/Guest");
    this.jLabel22.setForeground(new Color(255, 255, 255));
    
    GroupLayout jPanel11Layout = new GroupLayout(this.jPanel11);
    this.jPanel11.setLayout(jPanel11Layout);
    jPanel11Layout.setHorizontalGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel11Layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel22).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jTextField1, -2, 210, -2).addContainerGap(-1, 32767)));
    







    jPanel11Layout.setVerticalGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup().addContainerGap().addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jTextField1, -1, 25, 32767).addComponent(this.jLabel22, -1, -1, 32767)).addContainerGap()));
    








    GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
    this.jPanel3.setLayout(jPanel3Layout);
    jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.jButton3, -2, 227, -2).addGap(0, 0, 32767)).addComponent(this.jPanel10, -1, -1, 32767).addComponent(this.jScrollPane3).addComponent(this.jPanel11, GroupLayout.Alignment.TRAILING, -1, -1, 32767)).addContainerGap()));
    











    jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel11, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane3, -1, 305, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel10, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton3, -2, 34, -2).addContainerGap()));
    












    this.jTabbedPane1.addTab("Current Record", this.jPanel3);
    
    this.jPanel6.setBorder(BorderFactory.createBevelBorder(0));
    
    this.outReportTable.setFont(new Font("Tahoma", 0, 12));
    this.outReportTable.setModel(new DefaultTableModel(new Object[0][], new String[] { "Record#", "Guest", "Room", "Discount", "Room Price", "Sales", "Extra", "Adjustments", "Total", "Balance", "Date In", "Date Out" })
    {
      boolean[] canEdit = { false, false, false, false, false, false, false, false, false, false, false, false };
      
      public boolean isCellEditable(int rowIndex, int columnIndex)
      {
        return this.canEdit[columnIndex];
      }
    });
    this.outReportTable.setRowHeight(27);
    this.outReportTable.getTableHeader().setReorderingAllowed(false);
    this.jScrollPane1.setViewportView(this.outReportTable);
    
    this.jPanel1.setBackground(new Color(51, 0, 153));
    this.jPanel1.setBorder(BorderFactory.createTitledBorder(null, "Statistics", 0, 0, null, Color.white));
    
    this.jLabel2.setText("Balance");
    this.jLabel2.setForeground(new Color(255, 255, 255));
    
    this.bal.setText("0");
    this.bal.setForeground(new Color(255, 102, 102));
    
    this.noOfRec.setText("0");
    this.noOfRec.setForeground(new Color(255, 102, 102));
    
    this.jLabel6.setText("No. Of Transactions:");
    this.jLabel6.setForeground(new Color(255, 255, 255));
    
    this.room.setText("0");
    this.room.setForeground(new Color(255, 102, 102));
    
    this.jLabel8.setText("Room:");
    this.jLabel8.setForeground(new Color(255, 255, 255));
    
    this.sales.setText("0");
    this.sales.setForeground(new Color(255, 102, 102));
    
    this.jLabel10.setText("Sales:");
    this.jLabel10.setForeground(new Color(255, 255, 255));
    
    this.jLabel11.setText("Total:");
    this.jLabel11.setForeground(new Color(255, 255, 255));
    
    this.total.setText("0");
    this.total.setForeground(new Color(255, 102, 102));
    
    GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
    this.jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel6).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.noOfRec, -2, 81, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel8).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.room, -2, 81, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel10).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.sales, -2, 81, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel11).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.total, -2, 124, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.bal, -2, 122, -2).addContainerGap(-1, 32767)));
    























    jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel2, -1, -1, 32767).addComponent(this.bal, -1, -1, 32767).addComponent(this.jLabel6, -1, 24, 32767).addComponent(this.noOfRec, -1, -1, 32767).addComponent(this.jLabel8, -1, 24, 32767).addComponent(this.room, -1, -1, 32767).addComponent(this.jLabel10, -1, 24, 32767).addComponent(this.sales, -1, -1, 32767).addComponent(this.jLabel11, -1, 24, 32767).addComponent(this.total, -1, -1, 32767)).addContainerGap()));
    
















    this.jPanel2.setBackground(new Color(51, 0, 153));
    this.jPanel2.setBorder(BorderFactory.createTitledBorder(null, "Filter by", 0, 0, null, Color.white));
    
    this.jLabel4.setText("Days before date");
    this.jLabel4.setForeground(new Color(255, 255, 255));
    
    this.to.setDate(Calendar.getInstance().getTime());
    this.to.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Report.this.toActionPerformed(evt);
      }
    });
    this.days.setModel(new SpinnerNumberModel(0, 0, 30, 1));
    this.days.addChangeListener(new ChangeListener()
    {
      public void stateChanged(ChangeEvent evt)
      {
        Report.this.daysStateChanged(evt);
      }
    });
    this.jLabel1.setText("From");
    this.jLabel1.setForeground(new Color(255, 255, 255));
    
    this.from.setEnabled(false);
    
    this.viewBal.setText("View with Balance Only");
    this.viewBal.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Report.this.viewBalActionPerformed(evt);
      }
    });
    GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
    this.jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.from, -2, 162, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.days, -2, 65, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel4).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.to, -2, 174, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.viewBal).addContainerGap(-1, 32767)));
    















    jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.viewBal, -1, -1, 32767).addComponent(this.jLabel1, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addGroup(jPanel2Layout.createSequentialGroup().addGap(1, 1, 1).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel4, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.days))).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.from, -2, 28, -2).addGap(0, 0, 32767)).addComponent(this.to, -1, -1, 32767)).addContainerGap()));
    

















    this.jButton1.setText("Print Report");
    this.jButton1.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Report.this.jButton1ActionPerformed(evt);
      }
    });
    this.jButton4.setText("Settle Balance");
    this.jButton4.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Report.this.jButton4ActionPerformed(evt);
      }
    });
    GroupLayout jPanel6Layout = new GroupLayout(this.jPanel6);
    this.jPanel6.setLayout(jPanel6Layout);
    jPanel6Layout.setHorizontalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addContainerGap().addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1, -1, 876, 32767).addComponent(this.jPanel1, -1, -1, 32767).addComponent(this.jPanel2, -1, -1, 32767).addGroup(jPanel6Layout.createSequentialGroup().addComponent(this.jButton1, -2, 227, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton4, -2, 261, -2).addGap(0, 0, 32767))).addContainerGap()));
    













    jPanel6Layout.setVerticalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel2, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -1, 302, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jButton1, -1, 34, 32767).addComponent(this.jButton4, -1, -1, 32767)).addContainerGap()));
    














    this.jTabbedPane1.addTab("Checked Out Record", this.jPanel6);
    
    this.jPanel7.setBorder(BorderFactory.createBevelBorder(0));
    
    this.outIncomeTable.setFont(new Font("Tahoma", 0, 16));
    this.outIncomeTable.setModel(new DefaultTableModel(new Object[0][], new String[] { "Room", "Guest", "Amount", "Mode", "Date Paid" })
    {
      boolean[] canEdit = { false, false, false, false, false };
      
      public boolean isCellEditable(int rowIndex, int columnIndex)
      {
        return this.canEdit[columnIndex];
      }
    });
    this.outIncomeTable.setRowHeight(27);
    this.outIncomeTable.getTableHeader().setReorderingAllowed(false);
    this.jScrollPane2.setViewportView(this.outIncomeTable);
    
    this.jPanel4.setBackground(new Color(51, 0, 153));
    this.jPanel4.setBorder(BorderFactory.createTitledBorder(null, "Statistics", 0, 0, null, Color.white));
    
    this.jLabel3.setText("Total:");
    this.jLabel3.setForeground(new Color(255, 255, 255));
    
    this.totalIncome.setText("0");
    this.totalIncome.setForeground(new Color(255, 102, 102));
    
    this.noOfRec1.setText("0");
    this.noOfRec1.setForeground(new Color(255, 102, 102));
    
    this.jLabel7.setText("No. Of Records:");
    this.jLabel7.setForeground(new Color(255, 255, 255));
    
    this.cash.setText("0");
    this.cash.setForeground(new Color(255, 102, 102));
    
    this.jLabel9.setText("Cash:");
    this.jLabel9.setForeground(new Color(255, 255, 255));
    
    this.credit.setText("0");
    this.credit.setForeground(new Color(255, 102, 102));
    
    this.jLabel12.setText("Credit Card:");
    this.jLabel12.setForeground(new Color(255, 255, 255));
    
    this.jLabel13.setText("Check:");
    this.jLabel13.setForeground(new Color(255, 255, 255));
    
    this.check.setText("0");
    this.check.setForeground(new Color(255, 102, 102));
    
    GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
    this.jPanel4.setLayout(jPanel4Layout);
    jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel7).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.noOfRec1, -2, 81, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel9).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.cash, -2, 81, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel12).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.credit, -2, 81, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel13).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.check, -2, 124, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel3).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.totalIncome, -2, 122, -2).addContainerGap(-1, 32767)));
    























    jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup().addContainerGap().addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel3, -1, -1, 32767).addComponent(this.totalIncome, -1, -1, 32767).addComponent(this.jLabel7, -1, 24, 32767).addComponent(this.noOfRec1, -1, -1, 32767).addComponent(this.jLabel9, -1, 24, 32767).addComponent(this.cash, -1, -1, 32767).addComponent(this.jLabel12, -1, 24, 32767).addComponent(this.credit, -1, -1, 32767).addComponent(this.jLabel13, -1, 24, 32767).addComponent(this.check, -1, -1, 32767)).addContainerGap()));
    
















    this.jPanel5.setBackground(new Color(51, 0, 153));
    this.jPanel5.setBorder(BorderFactory.createTitledBorder(null, "Filter by", 0, 0, null, Color.white));
    
    this.jLabel14.setText("Days before date");
    this.jLabel14.setForeground(new Color(255, 255, 255));
    
    this.days1.setModel(new SpinnerNumberModel(0, 0, 30, 1));
    this.days1.addChangeListener(new ChangeListener()
    {
      public void stateChanged(ChangeEvent evt)
      {
        Report.this.days1StateChanged(evt);
      }
    });
    this.jLabel15.setText("From");
    this.jLabel15.setForeground(new Color(255, 255, 255));
    
    this.from1.setEnabled(false);
    this.from1.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Report.this.from1ActionPerformed(evt);
      }
    });
    this.to1.setDate(Calendar.getInstance().getTime());
    this.to1.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Report.this.to1ActionPerformed(evt);
      }
    });
    GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
    this.jPanel5.setLayout(jPanel5Layout);
    jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel15).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.from1, -2, 156, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.days1, -2, 65, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel14).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.to1, -2, 178, -2).addContainerGap(323, 32767)));
    













    jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup().addContainerGap().addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel15, -1, -1, 32767).addComponent(this.from1, -1, -1, 32767).addGroup(GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup().addGap(1, 1, 1).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.to1, GroupLayout.Alignment.TRAILING, -1, 27, 32767).addComponent(this.jLabel14, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.days1)))).addContainerGap()));
    














    this.jButton2.setText("Print Report");
    this.jButton2.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Report.this.jButton2ActionPerformed(evt);
      }
    });
    GroupLayout jPanel7Layout = new GroupLayout(this.jPanel7);
    this.jPanel7.setLayout(jPanel7Layout);
    jPanel7Layout.setHorizontalGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel7Layout.createSequentialGroup().addContainerGap().addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane2, -1, 876, 32767).addComponent(this.jPanel4, -1, -1, 32767).addComponent(this.jPanel5, -1, -1, 32767).addGroup(jPanel7Layout.createSequentialGroup().addComponent(this.jButton2, -2, 227, -2).addGap(0, 0, 32767))).addContainerGap()));
    











    jPanel7Layout.setVerticalGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel7Layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel5, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane2, -1, 302, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel4, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton2, -2, 34, -2).addContainerGap()));
    












    this.jTabbedPane1.addTab("Income Record", this.jPanel7);
    
    GroupLayout layout = new GroupLayout(this);
    setLayout(layout);
    layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.jTabbedPane1).addContainerGap()));
    





    layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jTabbedPane1).addContainerGap()));
  }
  
  private void daysStateChanged(ChangeEvent evt)
  {
    this.days1.setValue(Integer.valueOf(Integer.parseInt(this.days.getValue().toString())));
    LoadOutReport();
  }
  
  private void toActionPerformed(ActionEvent evt)
  {
    this.to1.setDate(this.to.getDate());
    LoadOutReport();
  }
  
  private void days1StateChanged(ChangeEvent evt)
  {
    this.days.setValue(Integer.valueOf(Integer.parseInt(this.days1.getValue().toString())));
    LoadOutIncome();
  }
  
  private void to1ActionPerformed(ActionEvent evt)
  {
    this.to.setDate(this.to1.getDate());
    LoadOutIncome();
  }
  
  private void jTabbedPane1StateChanged(ChangeEvent evt)
  {
    int sel = this.jTabbedPane1.getSelectedIndex();
    if (sel == 1) {
      LoadCurrentReport();
    }
  }
  
  private void from1ActionPerformed(ActionEvent evt) {}
  
  private void jButton2ActionPerformed(ActionEvent evt)
  {
    String date1 = this.df.format(this.from1.getDate());
    String date2 = this.df.format(this.to1.getDate());
    String incDates = date1 + "  to  " + date2;
    
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
    
    String recNo = this.noOfRec1.getText();
    
    String ca = this.cash.getText();
    String cr = this.credit.getText();
    String ch = this.check.getText();
    String t = this.totalIncome.getText();
    JFileChooser FileSytemView = new JFileChooser();
    
    DefaultTableModel reportModel = (DefaultTableModel)this.outIncomeTable.getModel();
    File Sample = FileSytemView.getFileSystemView().getDefaultDirectory();
    String Sfile = Sample.toString();
    
    String db = "\\\\";
    String filename = Sfile.replace("\\", db);
    System.out.println(filename = filename + "\\" + "\\" + rDate + time + ".pdf");
    
    System.out.print(filename);
    IncomeReport x = new IncomeReport(filename, reportModel, incDates, recNo, ca, cr, ch, t);
  }
  
  private void jButton3ActionPerformed(ActionEvent evt)
  {
    Calendar cal = Calendar.getInstance();
    String now = this.df.format(cal.getTime());
    
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
    
    String recNo = this.noOfRec.getText();
    
    String acc = this.account.getText();
    String pai = this.paid.getText();
    String bala = this.balance.getText();
    JFileChooser FileSytemView = new JFileChooser();
    
    DefaultTableModel reportModel = (DefaultTableModel)this.currentReportTable.getModel();
    
    File Sample = FileSytemView.getFileSystemView().getDefaultDirectory();
    String Sfile = Sample.toString();
    
    String db = "\\\\";
    String filename = Sfile.replace("\\", db);
    System.out.println(filename = filename + "\\" + "\\" + rDate + time + ".pdf");
    
    System.out.print(filename);
    CurrentReport x = new CurrentReport(filename, reportModel, now, recNo, acc, pai, bala);
  }
  
  private void jButton1ActionPerformed(ActionEvent evt)
  {
    String date1 = this.df.format(this.from.getDate());
    String date2 = this.df.format(this.to.getDate());
    String incDates = date1 + "  to  " + date2;
    
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
    
    String recNo = this.noOfRec.getText();
    
    String ro = this.room.getText();
    String sa = this.sales.getText();
    String tot = this.total.getText();
    String ba = this.bal.getText();
    JFileChooser FileSytemView = new JFileChooser();
    
    DefaultTableModel reportModel = (DefaultTableModel)this.outReportTable.getModel();
    File Sample = FileSytemView.getFileSystemView().getDefaultDirectory();
    String Sfile = Sample.toString();
    
    String db = "\\\\";
    String filename = Sfile.replace("\\", db);
    System.out.println(filename = filename + "\\" + "\\" + rDate + time + ".pdf");
    
    System.out.print(filename);
    CheckedOut x = new CheckedOut(filename, reportModel, incDates, recNo, ro, sa, tot, ba);
  }
  
  private void viewBalActionPerformed(ActionEvent evt)
  {
    LoadOutReport();
  }
  
  private void jButton4ActionPerformed(ActionEvent evt)
  {
    this.selr = this.outReportTable.getSelectedRow();
    if (this.selr != -1) {
      this.payBal.setVisible(true);
    } else {
      JOptionPane.showMessageDialog(this.outReportTable, "Please select record first", "No record selected", 0);
    }
  }
  
  private void jButton50ActionPerformed(ActionEvent evt)
  {
    float oldAm = Float.parseFloat(this.outReportTable.getValueAt(this.selr, 9).toString());
    String selRec = this.outReportTable.getValueAt(this.selr, 0).toString();
    String guest = this.outReportTable.getValueAt(this.selr, 1).toString();
    String am = this.adjAmount.getText();
    int selM = this.payMode.getSelectedIndex();
    String dateNow = this.df.format(Calendar.getInstance().getTime());
    String timeNow = this.tf.format(Calendar.getInstance().getTime());
    String now = dateNow + " " + timeNow;
    String mode = "";
    if (selM == 0) {
      mode = "cash";
    } else if (selM == 1) {
      mode = "credit";
    } else {
      mode = "check";
    }
    if ((am != null) && (am.length() > 0)) {
      try
      {
        float amount = Float.parseFloat(am);
        try
        {
          Class.forName("com.mysql.jdbc.Driver");
          String connectionUrl = DBUrl.dbconSales;
          Connection con = DriverManager.getConnection(connectionUrl);
          Statement stmt = con.createStatement();
          
          stmt.executeUpdate("UPDATE `reservation`.`resrecords` SET `bal` = " + (oldAm - amount) + " WHERE  `recordID`='" + selRec + "';");
          

          stmt.executeUpdate("INSERT INTO `reservation`.`paybal` (`trans`, `cust`, `amount`, `mode`, `date`)VALUES (" + selRec + ", '" + guest + "', " + amount + ", '" + mode + "', '" + dateNow + "');");
          if (selM == 1) {
            updateSalesCust(selRec, guest, amount + "", now);
          }
          JOptionPane.showMessageDialog(this.outReportTable, "Successfully saved");
          new UserLogger().insertLog(Extras.loggeduser, 4, "Paid balance for " + guest);
          this.payBal.setVisible(false);
          LoadOutReport();
        }
        catch (SQLException e)
        {
          System.out.println("SQL Exception: " + e.toString());
        }
        catch (ClassNotFoundException cE)
        {
          System.out.println("Class Not Found Exception: " + cE.toString());
        }
        System.out.println(oldAm - amount);
      }
      catch (NumberFormatException nfe)
      {
        JOptionPane.showMessageDialog(this.outReportTable, "Please enter a valid amount", "Invalid amount", 0);
      }
    }
  }
  
  private void jButton51ActionPerformed(ActionEvent evt)
  {
    System.out.println(this.payBal.getSize());
    this.payBal.setVisible(false);
  }
  
  private void LoadOutReport()
  {
    calcFromDate();
    String f = this.df.format(this.from.getDate());
    String t = this.df.format(this.to.getDate());
    int r = 0;
    String balQ = "";
    
    this.to1.setDate(this.to.getDate());
    if (this.viewBal.isSelected()) {
      balQ = " AND `bal` > 0 ";
    }
    try
    {
      Class.forName("com.mysql.jdbc.Driver");
      String connectionUrl = DBUrl.dbcon;
      Connection con = DriverManager.getConnection(connectionUrl);
      PreparedStatement stmt = null;
      ResultSet rs = null;
      String SQL = "SELECT `recordID`, `guest`, `room`, `disc`, `roomPrice`, `sales`, `extra`, `adj`, `price`, `bal`, `dateIn`, `dateOut` FROM `resrecords` WHERE '" + f + "' <= dateOut  AND '" + t + "' >= dateOut " + balQ + " ORDER BY dateOut DESC;";
      
      stmt = con.prepareStatement(SQL);
      rs = stmt.executeQuery();
      DefaultTableModel model = new TableModels().outReportModel;
      this.outReportTable.setModel(model);
      

      float totalRoom = 0.0F;
      float totalSales = 0.0F;
      float totalPrice = 0.0F;
      float totalBal = 0.0F;
      while (rs.next())
      {
        model.addRow(new Object[0]);
        model.setValueAt(rs.getString("recordID"), r, 0);
        model.setValueAt(rs.getString("guest"), r, 1);
        model.setValueAt(rs.getString("room"), r, 2);
        model.setValueAt(rs.getString("disc"), r, 3);
        totalRoom += rs.getFloat("roomPrice");
        model.setValueAt(this.decForm.format(rs.getFloat("roomPrice")), r, 4);
        
        totalSales += rs.getFloat("sales");
        model.setValueAt(this.decForm.format(rs.getFloat("sales")), r, 5);
        
        model.setValueAt(this.decForm.format(rs.getFloat("extra")), r, 6);
        model.setValueAt(this.decForm.format(rs.getFloat("adj")), r, 7);
        
        totalPrice += rs.getFloat("price");
        model.setValueAt(this.decForm.format(rs.getFloat("price")), r, 8);
        
        totalBal += rs.getFloat("bal");
        String mark = "";
        if (rs.getFloat("bal") > 0.0F) {
          mark = "*";
        }
        model.setValueAt(mark + this.decForm.format(rs.getFloat("bal")), r, 9);
        
        model.setValueAt(rs.getString("dateIn"), r, 10);
        model.setValueAt(rs.getString("dateOut"), r, 11);
        r++;
      }
      this.noOfRec.setText(this.decForm.format(r));
      this.room.setText(this.decForm.format(totalRoom));
      this.sales.setText(this.decForm.format(totalSales));
      this.total.setText(this.decForm.format(totalPrice));
      this.bal.setText(this.decForm.format(totalBal));
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
  
  private void LoadOutIncome()
  {
    calcFromDate();
    String f = this.df.format(this.from1.getDate());
    String t = this.df.format(this.to1.getDate());
    int r = 0;
    try
    {
      Class.forName("com.mysql.jdbc.Driver");
      String connectionUrl = DBUrl.dbcon;
      Connection con = DriverManager.getConnection(connectionUrl);
      PreparedStatement stmt = null;
      ResultSet rs = null;
      String SQL = "(SELECT `room`, `guest`, `amount`, `mode`, DATE(`datePaid`) AS `paid` FROM `payrecord` WHERE '" + f + "' <= DATE(datePaid)  AND '" + t + "' >= DATE(datePaid) ORDER BY `room`) " + "UNION ALL " + "(SELECT reservation.`roomID` AS `room`, reservation.`guestID` AS `guest`, `amount`, `mode`, DATE(`datePaid`) AS `paid` FROM `paycash`, `reservation` " + "WHERE  reservation.resID=paycash.resID AND '" + f + "' <= DATE(datePaid)  AND '" + t + "' >= DATE(datePaid) ORDER BY reservation.`roomID`) " + "ORDER BY `room`;";
      




      System.out.println("FIRST:" + SQL);
      stmt = con.prepareStatement(SQL);
      rs = stmt.executeQuery();
      DefaultTableModel model = new TableModels().outIncomeModel;
      float totalCash = 0.0F;
      float totalCredit = 0.0F;
      float totalCheck = 0.0F;
      
      String mode = "";
      float amount = 0.0F;
      while (rs.next())
      {
        model.addRow(new Object[0]);
        model.setValueAt(rs.getString(1), r, 0);
        model.setValueAt(rs.getString(2), r, 1);
        amount = rs.getFloat(3);
        mode = rs.getString(4);
        if (mode.equals("cash")) {
          totalCash += amount;
        } else if (mode.equals("credit")) {
          totalCredit += amount;
        } else {
          totalCheck += amount;
        }
        model.setValueAt(this.decForm.format(amount), r, 2);
        model.setValueAt(mode, r, 3);
        model.setValueAt(rs.getString(5), r, 4);
        r++;
      }
      this.noOfRec1.setText(this.decForm.format(r));
      this.cash.setText(this.decForm.format(totalCash));
      this.credit.setText(this.decForm.format(totalCredit));
      this.check.setText(this.decForm.format(totalCheck));
      this.totalIncome.setText(this.decForm.format(totalCash + totalCredit + totalCheck));
      this.outIncomeTable.setModel(model);
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
  
  private void calcFromDate()
  {
    try
    {
      Class.forName("com.mysql.jdbc.Driver");
      String connectionUrl = DBUrl.dbcon;
      Connection con = DriverManager.getConnection(connectionUrl);
      PreparedStatement stmt = null;
      ResultSet rs = null;
      int d = Integer.parseInt(this.days.getValue().toString());
      d *= -1;
      String resIn = this.df.format(this.to.getDate());
      
      stmt = con.prepareStatement("SELECT ADDDATE('" + resIn + "', ?) AS `from`;");
      stmt.setInt(1, d);
      rs = stmt.executeQuery();
      rs.next();
      this.from.setDate(rs.getDate("from"));
      this.from1.setDate(rs.getDate("from"));
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
  
  private int LoadCurrentReport()
  {
    int r = 0;
    try
    {
      Class.forName("com.mysql.jdbc.Driver");
      String connectionUrl = DBUrl.dbcon;
      Connection con = DriverManager.getConnection(connectionUrl);
      Statement stmt = null;
      ResultSet rs = null;
      DefaultTableModel model = new TableModels().currentReport;
      this.currentReportTable.setModel(model);
      

      float curRoomPrice = 0.0F;
      float curExtra = 0.0F;
      float curAdj = 0.0F;
      float curSales = 0.0F;
      float curTotal = 0.0F;
      
      float accuTotal = 0.0F;
      float totalPaid = 0.0F;
      float totalBalance = 0.0F;
      String SQL = "SELECT reservation.resID, reservation.roomID, reservation.guestID, guesttrans.room, guesttrans.disc, \n(SELECT IFNULL(SUM(extra.xtra), 0) FROM extra WHERE extra.resID=reservation.resID) AS extra,\n(SELECT IFNULL(SUM(adjustments.amount), 0) FROM adjustments WHERE adjustments.resID=reservation.resID) AS adj,\n(SELECT IFNULL(SUM(paycash.amount), 0) FROM paycash WHERE paycash.resID=reservation.resID) AS paid,\nDATE(reservation.inDate) AS `inDate`, DATE(reservation.outDate) AS `outDate`\nFROM reservation, guesttrans\nWHERE guesttrans.resID=reservation.resID AND reservation.stat='o';";
      






      System.out.println(SQL);
      
      stmt = con.createStatement();
      rs = stmt.executeQuery(SQL);
      while (rs.next())
      {
        model.addRow(new Object[0]);
        model.setValueAt(rs.getString("roomID"), r, 0);
        model.setValueAt(rs.getString("guestID"), r, 1);
        curRoomPrice = rs.getFloat("room");
        model.setValueAt(Float.valueOf(curRoomPrice), r, 2);
        model.setValueAt(rs.getString("disc"), r, 3);
        curExtra = rs.getFloat("extra");
        curAdj = rs.getFloat("adj");
        model.setValueAt(this.decForm.format(curExtra), r, 4);
        model.setValueAt(this.decForm.format(curAdj), r, 5);
        curSales = getSales(rs.getString("roomID") + "::" + rs.getString("resID"));
        model.setValueAt(this.decForm.format(curSales), r, 6);
        curTotal = curRoomPrice + curExtra + curAdj + curSales;
        accuTotal += curTotal;
        model.setValueAt(this.decForm.format(curTotal), r, 7);
        totalPaid += rs.getFloat("paid");
        model.setValueAt(this.decForm.format(rs.getFloat("paid")), r, 8);
        totalBalance += curTotal - rs.getFloat("paid");
        model.setValueAt(this.decForm.format(curTotal - rs.getFloat("paid")), r, 9);
        model.setValueAt(rs.getString("inDate"), r, 10);
        model.setValueAt(rs.getString("outDate"), r, 11);
        r++;
      }
      this.noOfRec2.setText(this.decForm.format(r));
      this.account.setText(this.decForm.format(accuTotal));
      this.paid.setText(this.decForm.format(totalPaid));
      this.balance.setText(this.decForm.format(totalBalance));
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
  
  private float getSales(String selRes)
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
      rs = stmt.executeQuery("SELECT SUM(`tenCharge`) as `total` FROM  `transaction` WHERE `transaction`.cust = '" + selRes + "';");
      
      System.out.println("SELECT SUM(`tenCharge`) as `total` FROM  `transaction` WHERE `transaction`.cust = '" + selRes + "';");
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
  
  public class CustomTableCellRenderer
    extends DefaultTableCellRenderer
  {
    public CustomTableCellRenderer() {}
    
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
    {
      Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
      
      Object amount = value;
      if (amount == null) {
        cell.setBackground(new Color(255, 255, 204));
      } else if (amount.toString().startsWith("*")) {
        cell.setBackground(Color.RED);
      }
      return cell;
    }
  }
}



/* Location:           D:\New folder\New folder\dist\11thPrototype.jar

 * Qualified Name:     MainForms.Report

 * JD-Core Version:    0.7.0.1

 */