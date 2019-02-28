package MainForms;

import Fields.DBUrl;
import Fields.Extras;
import Fields.TableModels;
import Methods.LoadPayment;
import Methods.LoadSales;
import Methods.UserLogger;
import Reports.DailyReport;
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
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import org.jdesktop.swingx.JXDatePicker;

public class Settlements
        extends JPanel {

    public Settlements() {
        initComponents();
    }

    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat tf = new SimpleDateFormat("HH:mm");
    DecimalFormat decForm = new DecimalFormat("#0.00");
    private JFormattedTextField adjAmount;
    private JTextField adjDesc;
    private JDialog adjustments;
    private JLabel bal;
    private JLabel bal1;
    private JLabel bal2;
    private JLabel bal3;
    private JTable dayAdjTable;
    private JLabel depNum;
    private JTable depTable;
    private JLabel depTotal;
    private JXDatePicker filDaily;
    private JXDatePicker filDate;
    private JXDatePicker filDep;
    private JCheckBox filView;
    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JButton jButton4;
    private JButton jButton5;
    private JButton jButton50;
    private JButton jButton51;
    private JButton jButton6;
    private JButton jButton7;
    private JButton jButton8;
    private JButton jButton9;
    private JCheckBox jCheckBox1;
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
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel62;
    private JLabel jLabel63;
    private JLabel jLabel64;
    private JLabel jLabel65;
    private JLabel jLabel66;
    private JLabel jLabel68;
    private JLabel jLabel69;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
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
    private JPanel jPanel3;
    private JPanel jPanel31;
    private JPanel jPanel32;
    private JPanel jPanel33;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private JPanel jPanel6;
    private JPanel jPanel7;
    private JPanel jPanel8;
    private JPanel jPanel9;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;
    private JScrollPane jScrollPane4;
    private JScrollPane jScrollPane5;
    private JScrollPane jScrollPane6;
    private JScrollPane jScrollPane9;
    private JSeparator jSeparator1;
    private JSeparator jSeparator19;
    private JSeparator jSeparator2;
    private JSeparator jSeparator3;
    private JSeparator jSeparator4;
    private JTabbedPane jTabbedPane1;
    private JLabel miscNoCred;
    private JLabel miscOccu;
    private JLabel miscOccuRate;
    private JLabel miscUnset;
    private JLabel miscVacant;
    private JDialog newAdjust;
    private JTable otherBal;
    private JTable receivablesTable;
    private JLabel reconAdj;
    private JLabel reconBal;
    private JLabel reconCredit;
    private JTable reconDepTable;
    private JLabel reconDepTotal;
    private JLabel reconRoom;
    private JLabel reconSales;
    private JLabel reconTotal;
    private JLabel remainUndep;
    private JLabel setCred;
    private JTabbedPane setTab;
    private JTable setTable;
    private JLabel setTotal;
    private JLabel totalAdj;
    private JLabel unCred;
    private JTable unSetTable;
    private JLabel unTotal;
    private JLabel undepCash;
    private JLabel undepCheck;
    private JLabel undepCredit;
    private JLabel undepTotal;

    private void initComponents() {
        this.adjustments = new JDialog();
        this.jPanel31 = new JPanel();
        this.jScrollPane9 = new JScrollPane();
        this.dayAdjTable = new JTable();
        this.jPanel32 = new JPanel();
        this.jLabel62 = new JLabel();
        this.totalAdj = new JLabel();
        this.jButton8 = new JButton();
        this.jLabel63 = new JLabel();
        this.jLabel64 = new JLabel();
        this.jLabel65 = new JLabel();
        this.jLabel66 = new JLabel();
        this.jButton9 = new JButton();
        this.newAdjust = new JDialog();
        this.jPanel33 = new JPanel();
        this.jLabel68 = new JLabel();
        this.adjDesc = new JTextField();
        this.jLabel69 = new JLabel();
        this.adjAmount = new JFormattedTextField();
        this.jButton50 = new JButton();
        this.jSeparator19 = new JSeparator();
        this.jButton51 = new JButton();
        this.setTab = new JTabbedPane();
        this.jPanel3 = new JPanel();
        this.jPanel10 = new JPanel();
        this.filDaily = new JXDatePicker();
        this.jLabel5 = new JLabel();
        this.jButton4 = new JButton();
        this.jTabbedPane1 = new JTabbedPane();
        this.jPanel13 = new JPanel();
        this.jPanel14 = new JPanel();
        this.jLabel17 = new JLabel();
        this.jLabel21 = new JLabel();
        this.reconSales = new JLabel();
        this.reconRoom = new JLabel();
        this.jLabel22 = new JLabel();
        this.reconCredit = new JLabel();
        this.jLabel24 = new JLabel();
        this.reconAdj = new JLabel();
        this.jButton5 = new JButton();
        this.jButton6 = new JButton();
        this.jLabel26 = new JLabel();
        this.jSeparator2 = new JSeparator();
        this.jLabel27 = new JLabel();
        this.jLabel28 = new JLabel();
        this.jSeparator3 = new JSeparator();
        this.jLabel29 = new JLabel();
        this.reconTotal = new JLabel();
        this.jLabel39 = new JLabel();
        this.reconBal = new JLabel();
        this.jPanel6 = new JPanel();
        this.jScrollPane4 = new JScrollPane();
        this.reconDepTable = new JTable();
        this.reconDepTotal = new JLabel();
        this.jLabel31 = new JLabel();
        this.jSeparator4 = new JSeparator();
        this.jButton7 = new JButton();
        this.jLabel32 = new JLabel();
        this.jLabel33 = new JLabel();
        this.jLabel34 = new JLabel();
        this.jLabel35 = new JLabel();
        this.jLabel36 = new JLabel();
        this.jLabel37 = new JLabel();
        this.jPanel11 = new JPanel();
        this.jPanel15 = new JPanel();
        this.jScrollPane5 = new JScrollPane();
        this.receivablesTable = new JTable();
        this.jPanel16 = new JPanel();
        this.jLabel19 = new JLabel();
        this.bal = new JLabel();
        this.jLabel20 = new JLabel();
        this.bal1 = new JLabel();
        this.jPanel17 = new JPanel();
        this.jPanel18 = new JPanel();
        this.jScrollPane6 = new JScrollPane();
        this.otherBal = new JTable();
        this.jPanel19 = new JPanel();
        this.jLabel40 = new JLabel();
        this.bal2 = new JLabel();
        this.jLabel41 = new JLabel();
        this.bal3 = new JLabel();
        this.jPanel12 = new JPanel();
        this.jLabel23 = new JLabel();
        this.miscOccu = new JLabel();
        this.jLabel25 = new JLabel();
        this.miscVacant = new JLabel();
        this.jLabel30 = new JLabel();
        this.miscUnset = new JLabel();
        this.miscNoCred = new JLabel();
        this.jLabel38 = new JLabel();
        this.miscOccuRate = new JLabel();
        this.jPanel2 = new JPanel();
        this.jPanel9 = new JPanel();
        this.jScrollPane2 = new JScrollPane();
        this.unSetTable = new JTable();
        this.jScrollPane3 = new JScrollPane();
        this.setTable = new JTable();
        this.jButton1 = new JButton();
        this.jButton2 = new JButton();
        this.jLabel7 = new JLabel();
        this.jLabel8 = new JLabel();
        this.filDate = new JXDatePicker();
        this.jPanel7 = new JPanel();
        this.unCred = new JLabel();
        this.jLabel11 = new JLabel();
        this.unTotal = new JLabel();
        this.jLabel9 = new JLabel();
        this.jPanel8 = new JPanel();
        this.setCred = new JLabel();
        this.jLabel14 = new JLabel();
        this.setTotal = new JLabel();
        this.jLabel16 = new JLabel();
        this.jLabel10 = new JLabel();
        this.jCheckBox1 = new JCheckBox();
        this.filView = new JCheckBox();
        this.jPanel1 = new JPanel();
        this.jPanel4 = new JPanel();
        this.filDep = new JXDatePicker();
        this.jLabel1 = new JLabel();
        this.jLabel2 = new JLabel();
        this.undepTotal = new JLabel();
        this.jScrollPane1 = new JScrollPane();
        this.depTable = new JTable();
        this.jPanel5 = new JPanel();
        this.jLabel4 = new JLabel();
        this.depTotal = new JLabel();
        this.depNum = new JLabel();
        this.jLabel18 = new JLabel();
        this.jLabel6 = new JLabel();
        this.jButton3 = new JButton();
        this.jLabel3 = new JLabel();
        this.undepCash = new JLabel();
        this.jLabel12 = new JLabel();
        this.undepCheck = new JLabel();
        this.jLabel13 = new JLabel();
        this.undepCredit = new JLabel();
        this.jSeparator1 = new JSeparator();
        this.jLabel15 = new JLabel();
        this.remainUndep = new JLabel();

        this.adjustments.setTitle("Adjustments");
        this.adjustments.setMinimumSize(new Dimension(463, 390));
        this.adjustments.setModal(true);
        this.adjustments.setResizable(false);

        this.jPanel31.setBackground(new Color(51, 0, 153));

        this.dayAdjTable.setFont(new Font("Tahoma", 0, 12));
        this.dayAdjTable.setModel(new DefaultTableModel(new Object[0][], new String[]{"Description", "Amount", "Date Added"}) {
            boolean[] canEdit = {false, false, false};

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        });
        this.dayAdjTable.setRowHeight(20);
        this.dayAdjTable.getTableHeader().setResizingAllowed(false);
        this.dayAdjTable.getTableHeader().setReorderingAllowed(false);
        this.jScrollPane9.setViewportView(this.dayAdjTable);

        this.jPanel32.setBackground(new Color(51, 0, 153));
        this.jPanel32.setBorder(BorderFactory.createTitledBorder(null, "Statistics", 0, 0, null, Color.white));

        this.jLabel62.setText("Total:");
        this.jLabel62.setForeground(new Color(255, 255, 255));

        this.totalAdj.setText("0");
        this.totalAdj.setForeground(new Color(255, 102, 102));

        GroupLayout jPanel32Layout = new GroupLayout(this.jPanel32);
        this.jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(jPanel32Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel32Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(this.jLabel62).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(this.totalAdj, -2, 76, -2)
                .addContainerGap(-1, 32767)));

        jPanel32Layout.setVerticalGroup(jPanel32Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel32Layout.createSequentialGroup()
                .addContainerGap().addGroup(jPanel32Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(this.jLabel62, -1, 19, 32767)
                        .addComponent(this.totalAdj, -1, -1, 32767))
                .addContainerGap()));

        this.jButton8.setText("Add New");
        this.jButton8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Settlements.this.jButton8ActionPerformed(evt);
            }
        });
        this.jLabel63.setText("*Note:");
        this.jLabel63.setForeground(new Color(255, 102, 102));

        this.jLabel64.setText("Negative amounts mean expenses spent,");
        this.jLabel64.setForeground(new Color(255, 255, 255));

        this.jLabel65.setText("deducted from the income. Positives mean any");
        this.jLabel65.setForeground(new Color(255, 255, 255));

        this.jLabel66.setText("unexpected amount added to the income.");
        this.jLabel66.setForeground(new Color(255, 255, 255));

        this.jButton9.setText("Close");
        this.jButton9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Settlements.this.jButton9ActionPerformed(evt);
            }
        });
        GroupLayout jPanel31Layout = new GroupLayout(this.jPanel31);
        this.jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(jPanel31Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel31Layout.createSequentialGroup()
                .addContainerGap().addGroup(jPanel31Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel31Layout.createSequentialGroup()
                                .addComponent(this.jScrollPane9, -2, 0, 32767)
                                .addContainerGap()).addGroup(jPanel31Layout.createSequentialGroup().addGroup(jPanel31Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(this.jButton8, -1, -1, 32767)
                                        .addComponent(this.jPanel32, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel31Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel31Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                .addComponent(this.jLabel66, -2, 245, -2).addGroup(GroupLayout.Alignment.LEADING, jPanel31Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(this.jLabel65, GroupLayout.Alignment.LEADING, -1, -1, 32767).addGroup(GroupLayout.Alignment.LEADING, jPanel31Layout.createSequentialGroup()
                                                                .addComponent(this.jLabel63).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(this.jLabel64))))
                                        .addComponent(this.jButton9, -2, 114, -2)).addGap(0, 10, 32767)))));

        jPanel31Layout.setVerticalGroup(jPanel31Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel31Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(this.jScrollPane9, -2, 203, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel31Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(this.jPanel32, -2, -1, -2).addGroup(jPanel31Layout.createSequentialGroup().addGroup(jPanel31Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(this.jLabel63)
                                        .addComponent(this.jLabel64)).addGap(2, 2, 2)
                                .addComponent(this.jLabel65).addGap(2, 2, 2)
                                .addComponent(this.jLabel66))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel31Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(this.jButton8, -2, 30, -2)
                        .addComponent(this.jButton9, -2, 30, -2))
                .addContainerGap(-1, 32767)));

        GroupLayout adjustmentsLayout = new GroupLayout(this.adjustments.getContentPane());
        this.adjustments.getContentPane().setLayout(adjustmentsLayout);
        adjustmentsLayout.setHorizontalGroup(adjustmentsLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(adjustmentsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(this.jPanel31, -1, -1, 32767)
                .addContainerGap()));

        adjustmentsLayout.setVerticalGroup(adjustmentsLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(adjustmentsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(this.jPanel31, -1, -1, 32767)
                .addContainerGap()));

        this.newAdjust.setTitle("New Adjustment");
        this.newAdjust.setMinimumSize(new Dimension(304, 213));
        this.newAdjust.setModal(true);
        this.newAdjust.setResizable(false);

        this.jPanel33.setBackground(new Color(51, 0, 153));

        this.jLabel68.setText("Description:");
        this.jLabel68.setForeground(new Color(255, 255, 255));

        this.jLabel69.setText("Amount:");
        this.jLabel69.setForeground(new Color(255, 255, 255));

        this.adjAmount.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));

        this.jButton50.setText("Add");
        this.jButton50.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Settlements.this.jButton50ActionPerformed(evt);
            }
        });
        this.jButton51.setText("Cancel");
        this.jButton51.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Settlements.this.jButton51ActionPerformed(evt);
            }
        });
        GroupLayout jPanel33Layout = new GroupLayout(this.jPanel33);
        this.jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(jPanel33Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel33Layout.createSequentialGroup()
                .addContainerGap().addGroup(jPanel33Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(this.jSeparator19).addGroup(jPanel33Layout.createSequentialGroup().addGroup(jPanel33Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(this.jLabel69)
                                        .addComponent(this.jLabel68)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel33Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(this.adjDesc)
                                        .addComponent(this.adjAmount, -1, 202, 32767)).addGap(0, 0, 32767)).addGroup(jPanel33Layout.createSequentialGroup()
                                .addComponent(this.jButton50, -2, 101, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
                                .addComponent(this.jButton51, -2, 101, -2)))
                .addContainerGap()));

        jPanel33Layout.setVerticalGroup(jPanel33Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel33Layout.createSequentialGroup().addGap(11, 11, 11).addGroup(jPanel33Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                .addComponent(this.jLabel68, -2, 24, -2)
                .addComponent(this.adjDesc, -2, 27, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel33Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(this.adjAmount, -1, 32, 32767)
                        .addComponent(this.jLabel69, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(this.jSeparator19, -2, 10, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel33Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(this.jButton50, -2, 31, -2)
                        .addComponent(this.jButton51, -2, 31, -2))
                .addContainerGap(-1, 32767)));

        GroupLayout newAdjustLayout = new GroupLayout(this.newAdjust.getContentPane());
        this.newAdjust.getContentPane().setLayout(newAdjustLayout);
        newAdjustLayout.setHorizontalGroup(newAdjustLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(newAdjustLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(this.jPanel33, -2, -1, -2)
                .addContainerGap(-1, 32767)));

        newAdjustLayout.setVerticalGroup(newAdjustLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(newAdjustLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(this.jPanel33, -1, -1, 32767)
                .addContainerGap()));

        this.setTab
                .addChangeListener(new ChangeListener() {
                    public void stateChanged(ChangeEvent evt) {
                        Settlements.this.setTabStateChanged(evt);
                    }
                });
        this.jPanel3.setBackground(new Color(51, 0, 153));

        this.jPanel10.setBackground(new Color(51, 0, 153));
        this.jPanel10.setBorder(BorderFactory.createTitledBorder(null, "Filter Daily Report", 0, 0, null, Color.white));

        this.filDaily.setDate(Calendar.getInstance().getTime());
        this.filDaily.setFont(new Font("Tahoma", 0, 18));
        this.filDaily.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Settlements.this.filDailyActionPerformed(evt);
            }
        });
        this.jLabel5.setFont(new Font("Tahoma", 0, 14));
        this.jLabel5.setText("Report date:");
        this.jLabel5.setForeground(new Color(255, 255, 255));

        this.jButton4.setText("Print report");
        this.jButton4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Settlements.this.jButton4ActionPerformed(evt);
            }
        });
        GroupLayout jPanel10Layout = new GroupLayout(this.jPanel10);
        this.jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(this.jLabel5).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(this.filDaily, -2, 329, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(this.jButton4, -2, 242, -2)
                .addContainerGap(-1, 32767)));

        jPanel10Layout.setVerticalGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap().addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(this.jLabel5, -1, -1, 32767)
                        .addComponent(this.filDaily, -1, 49, 32767)
                        .addComponent(this.jButton4, -1, -1, 32767))
                .addContainerGap()));

        this.jTabbedPane1
                .addChangeListener(new ChangeListener() {
                    public void stateChanged(ChangeEvent evt) {
                        Settlements.this.jTabbedPane1StateChanged(evt);
                    }
                });
        this.jPanel14.setBorder(BorderFactory.createTitledBorder("Income Information"));

        this.jLabel17.setFont(new Font("Tahoma", 0, 18));
        this.jLabel17.setText("Sales Receipts:");

        this.jLabel21.setFont(new Font("Tahoma", 0, 18));
        this.jLabel21.setText("Room Account Payments:");

        this.reconSales.setFont(new Font("Tahoma", 0, 18));

        this.reconRoom.setFont(new Font("Tahoma", 0, 18));

        this.jLabel22.setFont(new Font("Tahoma", 0, 18));
        this.jLabel22.setText("Credit Card Settlements:");

        this.reconCredit.setFont(new Font("Tahoma", 0, 18));

        this.jLabel24.setFont(new Font("Tahoma", 0, 18));
        this.jLabel24.setText("Cash Adjustments:");

        this.reconAdj.setFont(new Font("Tahoma", 0, 18));
        this.reconAdj.setText("0");

        this.jButton5.setText("Go to tab");
        this.jButton5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Settlements.this.jButton5ActionPerformed(evt);
            }
        });
        this.jButton6.setText("View");
        this.jButton6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Settlements.this.jButton6ActionPerformed(evt);
            }
        });
        this.jLabel26.setText("*Note:");
        this.jLabel26.setForeground(new Color(255, 0, 0));

        this.jLabel27.setText("Income information includes computations for only both CASHs and CHECKs.");

        this.jLabel28.setText("Unsettled Credit Card transactions are not included.");

        this.jLabel29.setFont(new Font("Tahoma", 0, 24));
        this.jLabel29.setText("Total:");

        this.reconTotal.setFont(new Font("Tahoma", 0, 24));

        this.jLabel39.setFont(new Font("Tahoma", 0, 18));
        this.jLabel39.setText("Settled Balances:");

        this.reconBal.setFont(new Font("Tahoma", 0, 18));

        GroupLayout jPanel14Layout = new GroupLayout(this.jPanel14);
        this.jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap().addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(this.jSeparator2).addGroup(jPanel14Layout.createSequentialGroup().addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(this.jLabel21)
                                        .addComponent(this.jLabel17)
                                        .addComponent(this.jLabel39)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel14Layout.createSequentialGroup()
                                                .addComponent(this.reconCredit, -2, 206, -2).addGap(0, 0, 32767))
                                        .addComponent(this.reconRoom, -1, -1, 32767)
                                        .addComponent(this.reconSales, -1, -1, 32767)
                                        .addComponent(this.reconBal, -1, -1, 32767))).addGroup(GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup().addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel14Layout.createSequentialGroup().addGap(55, 55, 55)
                                                .addComponent(this.jLabel24).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(this.reconAdj, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)).addGroup(GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup().addGap(0, 0, 32767)
                                                .addComponent(this.jLabel22).addGap(227, 227, 227))).addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(this.jButton6, -1, -1, 32767)
                                        .addComponent(this.jButton5, -2, 85, -2)))
                        .addComponent(this.jSeparator3).addGroup(jPanel14Layout.createSequentialGroup().addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel14Layout.createSequentialGroup()
                                                .addComponent(this.jLabel26).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(this.jLabel28)
                                                        .addComponent(this.jLabel27))).addGroup(jPanel14Layout.createSequentialGroup().addGap(139, 139, 139)
                                                .addComponent(this.jLabel29).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(this.reconTotal, -2, 305, -2))).addGap(0, 0, 32767)))
                .addContainerGap()));

        jPanel14Layout.setVerticalGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap().addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(this.jLabel17, -2, 25, -2)
                        .addComponent(this.reconSales, -2, 25, -2)).addGap(18, 18, 18).addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(this.jLabel21, -2, 25, -2)
                        .addComponent(this.reconRoom, -2, 25, -2)).addGap(18, 18, 18).addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(this.jLabel39, -2, 25, -2)
                        .addComponent(this.reconBal, -2, 25, -2)).addGap(18, 24, 32767).addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(this.jButton5, GroupLayout.Alignment.TRAILING)
                        .addComponent(this.jLabel22, -2, 25, -2)
                        .addComponent(this.reconCredit, -2, 25, -2)).addGap(18, 18, 18).addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(this.jButton6, -2, 28, -2).addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(this.jLabel24, -2, 25, -2)
                                .addComponent(this.reconAdj, -2, 25, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(this.jSeparator3, -2, 10, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(this.jLabel29, GroupLayout.Alignment.TRAILING, -2, 25, -2)
                        .addComponent(this.reconTotal, -2, 25, -2)).addGap(32, 32, 32)
                .addComponent(this.jSeparator2, -2, 10, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(this.jLabel26)
                        .addComponent(this.jLabel27)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(this.jLabel28)
                .addContainerGap()));

        jPanel14Layout.linkSize(1, new Component[]{this.jButton5, this.jButton6});

        this.jPanel6.setBorder(BorderFactory.createTitledBorder("Deposit Slips"));

        this.reconDepTable.setFont(new Font("Tahoma", 0, 12));
        this.reconDepTable.setModel(new DefaultTableModel(new Object[0][], new String[]{"Deposit Date", "Amount"}) {
            boolean[] canEdit = {false, false};

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        });
        this.reconDepTable.setRowHeight(27);
        this.reconDepTable.getTableHeader().setReorderingAllowed(false);
        this.jScrollPane4.setViewportView(this.reconDepTable);

        this.reconDepTotal.setFont(new Font("Tahoma", 0, 24));

        this.jLabel31.setFont(new Font("Tahoma", 0, 24));
        this.jLabel31.setText("Total:");

        this.jButton7.setText("Go to tab");
        this.jButton7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Settlements.this.jButton7ActionPerformed(evt);
            }
        });
        this.jLabel32.setText("*Note:");
        this.jLabel32.setForeground(new Color(255, 0, 0));

        this.jLabel33.setText("GREEN");
        this.jLabel33.setForeground(new Color(0, 153, 0));

        this.jLabel34.setText("\"Total Label\" means that the deposit slips reconciled with the");

        this.jLabel35.setText("income information, and");

        this.jLabel36.setText("RED");
        this.jLabel36.setForeground(new Color(255, 0, 0));

        this.jLabel37.setText("if it doesn't.");

        GroupLayout jPanel6Layout = new GroupLayout(this.jPanel6);
        this.jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap().addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(this.jScrollPane4, -1, 393, 32767)
                        .addComponent(this.jSeparator4).addGroup(jPanel6Layout.createSequentialGroup().addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jPanel6Layout.createSequentialGroup()
                                                .addComponent(this.jLabel31).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(this.reconDepTotal, -1, -1, 32767).addGap(79, 79, 79)).addGroup(jPanel6Layout.createSequentialGroup()
                                                .addComponent(this.jLabel32).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(this.jLabel33).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(this.jLabel34).addGroup(jPanel6Layout.createSequentialGroup().addGap(10, 10, 10)
                                                                .addComponent(this.jLabel35).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(this.jLabel36).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(this.jLabel37))))).addGap(0, 0, 32767)).addGroup(GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup().addGap(0, 0, 32767)
                                .addComponent(this.jButton7, -2, 85, -2)))
                .addContainerGap()));

        jPanel6Layout.setVerticalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(this.jScrollPane4, -2, 221, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(this.reconDepTotal, GroupLayout.Alignment.TRAILING, -1, -1, 32767)
                        .addComponent(this.jLabel31, -1, 47, 32767)
                        .addComponent(this.jButton7, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(this.jSeparator4, -2, 10, -2).addGap(3, 3, 3).addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(this.jLabel32)
                        .addComponent(this.jLabel33)
                        .addComponent(this.jLabel34)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(this.jLabel35)
                        .addComponent(this.jLabel36)
                        .addComponent(this.jLabel37))
                .addContainerGap(22, 32767)));

        GroupLayout jPanel13Layout = new GroupLayout(this.jPanel13);
        this.jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(this.jPanel14, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(this.jPanel6, -1, -1, 32767)
                .addContainerGap()));

        jPanel13Layout.setVerticalGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap().addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(this.jPanel6, -1, -1, 32767)
                        .addComponent(this.jPanel14, -1, -1, 32767))
                .addContainerGap(25, 32767)));

        this.jTabbedPane1.addTab("I. Cash Reconciliation", this.jPanel13);

        this.jPanel15.setBorder(BorderFactory.createTitledBorder("Checked Out Receivables"));

        this.receivablesTable.setFont(new Font("Tahoma", 0, 12));
        this.receivablesTable.setModel(new DefaultTableModel(new Object[0][], new String[]{"Room", "Guest", "Date Out", "Balance"}) {
            boolean[] canEdit = {false, false, false, false};

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        });
        this.receivablesTable.setRowHeight(27);
        this.receivablesTable.getTableHeader().setReorderingAllowed(false);
        this.jScrollPane5.setViewportView(this.receivablesTable);

        this.jPanel16.setBorder(BorderFactory.createTitledBorder("Statistics"));

        this.jLabel19.setFont(new Font("Tahoma", 0, 18));
        this.jLabel19.setText("Total Balance:");

        this.bal.setFont(new Font("Tahoma", 0, 18));
        this.bal.setText("0");
        this.bal.setForeground(new Color(255, 102, 102));

        this.jLabel20.setFont(new Font("Tahoma", 0, 18));
        this.jLabel20.setText("No. of Record:");

        this.bal1.setFont(new Font("Tahoma", 0, 18));
        this.bal1.setText("0");
        this.bal1.setForeground(new Color(255, 102, 102));

        GroupLayout jPanel16Layout = new GroupLayout(this.jPanel16);
        this.jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(jPanel16Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(this.jLabel19).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(this.bal, -2, 124, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(this.jLabel20).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(this.bal1, -1, -1, 32767)
                .addContainerGap()));

        jPanel16Layout.setVerticalGroup(jPanel16Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap().addGroup(jPanel16Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(this.jLabel19, -1, -1, 32767).addGroup(jPanel16Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(this.bal, -2, 26, -2)
                                .addComponent(this.jLabel20, -1, -1, 32767)
                                .addComponent(this.bal1, -2, 26, -2)))
                .addContainerGap(-1, 32767)));

        GroupLayout jPanel15Layout = new GroupLayout(this.jPanel15);
        this.jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(jPanel15Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap().addGroup(jPanel15Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(this.jScrollPane5, -1, 454, 32767).addGroup(jPanel15Layout.createSequentialGroup()
                                .addComponent(this.jPanel16, -1, -1, 32767)
                                .addContainerGap()))));

        jPanel15Layout.setVerticalGroup(jPanel15Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(this.jScrollPane5, -1, 242, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(this.jPanel16, -2, -1, -2)
                .addContainerGap()));

        GroupLayout jPanel11Layout = new GroupLayout(this.jPanel11);
        this.jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel11Layout.createSequentialGroup().addGap(216, 216, 216)
                .addComponent(this.jPanel15, -2, -1, -2)
                .addContainerGap(306, 32767)));

        jPanel11Layout.setVerticalGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel11Layout.createSequentialGroup().addGap(21, 21, 21)
                .addComponent(this.jPanel15, -2, -1, -2)
                .addContainerGap(39, 32767)));

        this.jTabbedPane1.addTab("II. Accounts Receivables", this.jPanel11);

        this.jPanel18.setBorder(BorderFactory.createTitledBorder("Other Receivables"));

        this.otherBal.setFont(new Font("Tahoma", 0, 12));
        this.otherBal.setModel(new DefaultTableModel(new Object[0][], new String[]{"Customer", "Date", "Amount", "Charged"}) {
            boolean[] canEdit = {false, false, false, false};

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        });
        this.otherBal.setRowHeight(27);
        this.otherBal.getTableHeader().setReorderingAllowed(false);
        this.jScrollPane6.setViewportView(this.otherBal);

        this.jPanel19.setBorder(BorderFactory.createTitledBorder("Statistics"));

        this.jLabel40.setFont(new Font("Tahoma", 0, 18));
        this.jLabel40.setText("Total Balance:");

        this.bal2.setFont(new Font("Tahoma", 0, 18));
        this.bal2.setForeground(new Color(255, 102, 102));
        this.bal2.setText("0");

        this.jLabel41.setFont(new Font("Tahoma", 0, 18));
        this.jLabel41.setText("No. of Record:");

        this.bal3.setFont(new Font("Tahoma", 0, 18));
        this.bal3.setForeground(new Color(255, 102, 102));
        this.bal3.setText("0");

        GroupLayout jPanel19Layout = new GroupLayout(this.jPanel19);
        this.jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(jPanel19Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(this.jLabel40).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(this.bal2, -2, 124, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(this.jLabel41).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(this.bal3, -1, -1, 32767)
                .addContainerGap()));

        jPanel19Layout.setVerticalGroup(jPanel19Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap().addGroup(jPanel19Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(this.jLabel40, -1, -1, 32767).addGroup(jPanel19Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(this.bal2, -2, 26, -2)
                                .addComponent(this.jLabel41, -1, -1, 32767)
                                .addComponent(this.bal3, -2, 26, -2)))
                .addContainerGap(-1, 32767)));

        GroupLayout jPanel18Layout = new GroupLayout(this.jPanel18);
        this.jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(jPanel18Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap().addGroup(jPanel18Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(this.jScrollPane6, -1, 454, 32767).addGroup(jPanel18Layout.createSequentialGroup()
                                .addComponent(this.jPanel19, -1, -1, 32767)
                                .addContainerGap()))));

        jPanel18Layout.setVerticalGroup(jPanel18Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(this.jScrollPane6, -1, 242, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(this.jPanel19, -2, -1, -2)
                .addContainerGap()));

        GroupLayout jPanel17Layout = new GroupLayout(this.jPanel17);
        this.jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel17Layout.createSequentialGroup().addGap(217, 217, 217)
                .addComponent(this.jPanel18, -2, -1, -2)
                .addContainerGap(305, 32767)));

        jPanel17Layout.setVerticalGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel17Layout.createSequentialGroup().addGap(20, 20, 20)
                .addComponent(this.jPanel18, -2, -1, -2)
                .addContainerGap(40, 32767)));

        this.jTabbedPane1.addTab("III. Other Receivables", this.jPanel17);

        this.jLabel23.setFont(new Font("Tahoma", 0, 24));
        this.jLabel23.setText("Occupied Rooms:");

        this.miscOccu.setFont(new Font("Tahoma", 0, 24));
        this.miscOccu.setForeground(new Color(0, 204, 0));

        this.jLabel25.setFont(new Font("Tahoma", 0, 24));
        this.jLabel25.setText("Vacant Rooms:");

        this.miscVacant.setFont(new Font("Tahoma", 0, 24));
        this.miscVacant.setForeground(new Color(0, 204, 0));

        this.jLabel30.setFont(new Font("Tahoma", 0, 24));
        this.jLabel30.setText("Unsettled CC:");

        this.miscUnset.setFont(new Font("Tahoma", 0, 24));
        this.miscUnset.setForeground(new Color(0, 204, 0));

        this.miscNoCred.setFont(new Font("Tahoma", 0, 24));
        this.miscNoCred.setForeground(new Color(0, 204, 0));

        this.jLabel38.setFont(new Font("Tahoma", 0, 24));
        this.jLabel38.setText("Occupancy Rate:");

        this.miscOccuRate.setFont(new Font("Tahoma", 0, 24));
        this.miscOccuRate.setForeground(new Color(0, 204, 0));

        GroupLayout jPanel12Layout = new GroupLayout(this.jPanel12);
        this.jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel12Layout.createSequentialGroup().addGap(201, 201, 201).addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                .addComponent(this.jLabel38)
                .addComponent(this.jLabel30)
                .addComponent(this.jLabel25)
                .addComponent(this.jLabel23)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(this.miscOccu, -1, -1, 32767)
                        .addComponent(this.miscVacant, -1, 252, 32767)
                        .addComponent(this.miscUnset, -1, -1, 32767)
                        .addComponent(this.miscNoCred, -1, -1, 32767)
                        .addComponent(this.miscOccuRate, -1, -1, 32767)).addGap(355, 355, 355)));

        jPanel12Layout.setVerticalGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel12Layout.createSequentialGroup().addGap(37, 37, 37).addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(this.jLabel23, -2, 25, -2)
                .addComponent(this.miscOccu, -2, 25, -2)).addGap(37, 37, 37).addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(this.jLabel25, -2, 25, -2)
                        .addComponent(this.miscVacant, -2, 25, -2)).addGap(37, 37, 37).addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(this.jLabel30, -2, 25, -2)
                        .addComponent(this.miscUnset, -2, 25, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(this.miscNoCred, -2, 25, -2).addGap(33, 33, 33).addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(this.jLabel38, -2, 25, -2)
                        .addComponent(this.miscOccuRate, -2, 25, -2))
                .addContainerGap(149, 32767)));

        this.jTabbedPane1.addTab("IV. Miscellaneous", this.jPanel12);

        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(this.jPanel10, -1, -1, 32767)
                        .addComponent(this.jTabbedPane1))
                .addContainerGap()));

        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(this.jPanel10, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(this.jTabbedPane1, -2, 452, -2)
                .addContainerGap()));

        this.setTab.addTab("Daily Report", this.jPanel3);

        this.jPanel2.setBackground(new Color(51, 0, 153));

        this.jPanel9.setBackground(new Color(51, 0, 153));

        this.unSetTable.setFont(new Font("Tahoma", 0, 12));
        this.unSetTable.setModel(new DefaultTableModel(new Object[0][], new String[]{"Amount", "Customer", "Trans. Date", "#"}) {
            boolean[] canEdit = {false, false, false, false};

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        });
        this.unSetTable.setRowHeight(27);
        this.unSetTable.getTableHeader().setReorderingAllowed(false);
        this.jScrollPane2.setViewportView(this.unSetTable);

        this.setTable.setFont(new Font("Tahoma", 0, 12));
        this.setTable.setModel(new DefaultTableModel(new Object[0][], new String[]{"Amount", "Customer", "Trans. Date", "Date Settled", "#"}) {
            boolean[] canEdit = {false, false, false, false, false};

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        });
        this.setTable.setRowHeight(27);
        this.setTable.getTableHeader().setReorderingAllowed(false);
        this.jScrollPane3.setViewportView(this.setTable);

        this.jButton1.setText(">>");
        this.jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Settlements.this.jButton1ActionPerformed(evt);
            }
        });
        this.jButton2.setText("<<");
        this.jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Settlements.this.jButton2ActionPerformed(evt);
            }
        });
        this.jLabel7.setFont(new Font("Tahoma", 0, 24));
        this.jLabel7.setHorizontalAlignment(0);
        this.jLabel7.setText("Unsettled Credit Cards");
        this.jLabel7.setForeground(new Color(255, 255, 255));
        this.jLabel7.setHorizontalTextPosition(0);

        this.jLabel8.setFont(new Font("Tahoma", 0, 24));
        this.jLabel8.setHorizontalAlignment(0);
        this.jLabel8.setText("Settled Credit Cards");
        this.jLabel8.setForeground(new Color(255, 255, 255));
        this.jLabel8.setHorizontalTextPosition(0);

        this.filDate.setDate(Calendar.getInstance().getTime());
        this.filDate.setFont(new Font("Tahoma", 0, 18));
        this.filDate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Settlements.this.filDateActionPerformed(evt);
            }
        });
        this.jPanel7.setBackground(new Color(51, 0, 153));
        this.jPanel7.setBorder(BorderFactory.createTitledBorder(null, "Statistics", 0, 0, null, Color.white));

        this.unCred.setFont(new Font("Tahoma", 0, 14));
        this.unCred.setForeground(new Color(255, 102, 102));

        this.jLabel11.setFont(new Font("Tahoma", 0, 14));
        this.jLabel11.setText("Total Amount:");
        this.jLabel11.setForeground(new Color(255, 255, 255));

        this.unTotal.setFont(new Font("Tahoma", 0, 14));
        this.unTotal.setForeground(new Color(255, 102, 102));

        this.jLabel9.setFont(new Font("Tahoma", 0, 14));
        this.jLabel9.setText("No. of Credit Cards:");
        this.jLabel9.setForeground(new Color(255, 255, 255));

        GroupLayout jPanel7Layout = new GroupLayout(this.jPanel7);
        this.jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(this.jLabel9).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(this.unCred, -2, 51, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(this.jLabel11).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(this.unTotal, -1, 116, 32767)
                .addContainerGap()));

        jPanel7Layout.setVerticalGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap().addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(this.jLabel9, -1, -1, 32767)
                        .addComponent(this.unCred, -1, -1, 32767)
                        .addComponent(this.jLabel11, -1, -1, 32767)
                        .addComponent(this.unTotal, -2, 23, -2))
                .addContainerGap()));

        this.jPanel8.setBackground(new Color(51, 0, 153));
        this.jPanel8.setBorder(BorderFactory.createTitledBorder(null, "Statistics", 0, 0, null, Color.white));

        this.setCred.setFont(new Font("Tahoma", 0, 14));
        this.setCred.setForeground(new Color(255, 102, 102));

        this.jLabel14.setFont(new Font("Tahoma", 0, 14));
        this.jLabel14.setText("Total Amount:");
        this.jLabel14.setForeground(new Color(255, 255, 255));

        this.setTotal.setFont(new Font("Tahoma", 0, 14));
        this.setTotal.setForeground(new Color(255, 102, 102));

        this.jLabel16.setFont(new Font("Tahoma", 0, 14));
        this.jLabel16.setText("No. of Credit Cards:");
        this.jLabel16.setForeground(new Color(255, 255, 255));

        GroupLayout jPanel8Layout = new GroupLayout(this.jPanel8);
        this.jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(this.jLabel16).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(this.setCred, -2, 62, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(this.jLabel14).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(this.setTotal, -1, -1, 32767)
                .addContainerGap()));

        jPanel8Layout.setVerticalGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap().addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(this.jLabel16, -1, -1, 32767)
                        .addComponent(this.setCred, -1, -1, 32767)
                        .addComponent(this.jLabel14, -1, -1, 32767)
                        .addComponent(this.setTotal, -2, 23, -2))
                .addContainerGap()));

        this.jLabel10.setText("Transaction Date:");
        this.jLabel10.setForeground(new Color(255, 255, 255));

        this.jCheckBox1.setSelected(true);
        this.jCheckBox1.setText("View All Unsettled Credit Cards");
        this.jCheckBox1.setBackground(new Color(51, 0, 153));
        this.jCheckBox1.setForeground(new Color(255, 255, 255));
        this.jCheckBox1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Settlements.this.jCheckBox1ActionPerformed(evt);
            }
        });
        this.filView.setText("Wiew All");
        this.filView.setBackground(new Color(51, 0, 153));
        this.filView.setForeground(new Color(255, 255, 255));
        this.filView.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Settlements.this.filViewActionPerformed(evt);
            }
        });
        GroupLayout jPanel9Layout = new GroupLayout(this.jPanel9);
        this.jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap().addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(this.jLabel7, -1, -1, 32767)
                        .addComponent(this.jCheckBox1, GroupLayout.Alignment.TRAILING, -2, 352, -2)
                        .addComponent(this.jScrollPane2, GroupLayout.Alignment.TRAILING, -2, 0, 32767)
                        .addComponent(this.jPanel7, GroupLayout.Alignment.TRAILING, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(this.jButton1, -2, 103, -2)
                        .addComponent(this.jButton2, -2, 103, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                .addComponent(this.jLabel10).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(this.filDate, -2, 213, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(this.filView, -2, 110, -2))
                        .addComponent(this.jScrollPane3, -2, 0, 32767)
                        .addComponent(this.jPanel8, -1, -1, 32767)
                        .addComponent(this.jLabel8, -2, 415, -2))
                .addContainerGap()));

        jPanel9Layout.setVerticalGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap().addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(this.jLabel7, -2, 26, -2)
                        .addComponent(this.jLabel8, -2, 26, -2)).addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel9Layout.createSequentialGroup().addGap(97, 97, 97)
                                .addComponent(this.jButton1, -2, 37, -2).addGap(68, 68, 68)
                                .addComponent(this.jButton2, -2, 36, -2)).addGroup(jPanel9Layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(this.filDate, -2, 32, -2)
                                        .addComponent(this.jCheckBox1, -1, -1, 32767)
                                        .addComponent(this.jLabel10, -1, -1, 32767)
                                        .addComponent(this.filView, -2, 32, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(this.jScrollPane2, GroupLayout.Alignment.TRAILING, -2, 0, 32767)
                                        .addComponent(this.jScrollPane3, -2, 283, -2)))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(this.jPanel7, -2, -1, -2)
                        .addComponent(this.jPanel8, -2, -1, -2))
                .addContainerGap()));

        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(37, 37, 37)
                .addComponent(this.jPanel9, -2, -1, -2)
                .addContainerGap(-1, 32767)));

        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(29, 29, 29)
                .addComponent(this.jPanel9, -2, -1, -2)
                .addContainerGap(96, 32767)));

        this.setTab.addTab("Credt Card Settlements", this.jPanel2);

        this.jPanel1.setBackground(new Color(51, 0, 153));

        this.jPanel4.setBackground(new Color(51, 0, 153));
        this.jPanel4.setBorder(BorderFactory.createTitledBorder(null, "Filter Amount to deposit", 0, 0, null, Color.white));

        this.filDep.setDate(Calendar.getInstance().getTime());
        this.filDep.setFont(new Font("Tahoma", 0, 24));
        this.filDep.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Settlements.this.filDepActionPerformed(evt);
            }
        });
        this.jLabel1.setFont(new Font("Tahoma", 0, 14));
        this.jLabel1.setText("Transaction date:");
        this.jLabel1.setForeground(new Color(255, 255, 255));

        GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
        this.jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(this.jLabel1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(this.filDep, -2, 280, -2)
                .addContainerGap(65, 32767)));

        jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap().addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(this.filDep, -1, -1, 32767)
                        .addComponent(this.jLabel1, -1, -1, 32767))
                .addContainerGap()));

        this.jLabel2.setFont(new Font("Tahoma", 0, 24));
        this.jLabel2.setText("Total Amount:");
        this.jLabel2.setForeground(new Color(255, 255, 255));

        this.undepTotal.setFont(new Font("Tahoma", 0, 24));
        this.undepTotal.setForeground(new Color(0, 153, 0));

        this.depTable.setFont(new Font("Tahoma", 0, 12));
        this.depTable.setModel(new DefaultTableModel(new Object[0][], new String[]{"Deposit Date", "Amount"}) {
            boolean[] canEdit = {false, false};

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        });
        this.depTable.setRowHeight(27);
        this.depTable.getTableHeader().setReorderingAllowed(false);
        this.jScrollPane1.setViewportView(this.depTable);

        this.jPanel5.setBackground(new Color(51, 0, 153));
        this.jPanel5.setBorder(BorderFactory.createTitledBorder(null, "Statistics", 0, 0, null, Color.white));

        this.jLabel4.setFont(new Font("Tahoma", 0, 14));
        this.jLabel4.setText("Total:");
        this.jLabel4.setForeground(new Color(255, 255, 255));

        this.depTotal.setFont(new Font("Tahoma", 0, 14));
        this.depTotal.setForeground(new Color(255, 102, 102));

        this.depNum.setFont(new Font("Tahoma", 0, 14));
        this.depNum.setForeground(new Color(255, 102, 102));

        this.jLabel18.setFont(new Font("Tahoma", 0, 14));
        this.jLabel18.setText("No. Of Slips:");
        this.jLabel18.setForeground(new Color(255, 255, 255));

        GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
        this.jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(this.jLabel4).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(this.depTotal, -2, 109, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(this.jLabel18).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(this.depNum, -2, 89, -2)
                .addContainerGap(62, 32767)));

        jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap().addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(this.jLabel4, -1, -1, 32767)
                        .addComponent(this.depTotal, -1, -1, 32767)
                        .addComponent(this.jLabel18, -1, 30, 32767)
                        .addComponent(this.depNum, -1, -1, 32767))
                .addContainerGap()));

        this.jLabel6.setFont(new Font("Tahoma", 0, 24));
        this.jLabel6.setHorizontalAlignment(0);
        this.jLabel6.setText("Deposit Slips");
        this.jLabel6.setForeground(new Color(255, 255, 255));

        this.jButton3.setText("New Deposit Slip");
        this.jButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Settlements.this.jButton3ActionPerformed(evt);
            }
        });
        this.jLabel3.setFont(new Font("Tahoma", 0, 18));
        this.jLabel3.setText("Cash:");
        this.jLabel3.setForeground(new Color(255, 255, 255));

        this.undepCash.setFont(new Font("Tahoma", 0, 18));

        this.jLabel12.setFont(new Font("Tahoma", 0, 18));
        this.jLabel12.setText("Check:");
        this.jLabel12.setForeground(new Color(255, 255, 255));

        this.undepCheck.setFont(new Font("Tahoma", 0, 18));

        this.jLabel13.setFont(new Font("Tahoma", 0, 18));
        this.jLabel13.setText("Settled CC(Check):");
        this.jLabel13.setForeground(new Color(255, 255, 255));

        this.undepCredit.setFont(new Font("Tahoma", 0, 18));

        this.jLabel15.setFont(new Font("Tahoma", 0, 24));
        this.jLabel15.setText("Undeposited Amount:");
        this.jLabel15.setForeground(new Color(255, 255, 255));

        this.remainUndep.setFont(new Font("Tahoma", 0, 24));
        this.remainUndep.setForeground(new Color(255, 102, 102));

        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                        .addComponent(this.jPanel4, GroupLayout.Alignment.LEADING, -1, -1, 32767).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(this.jLabel3)
                                        .addComponent(this.jLabel2)
                                        .addComponent(this.jLabel12)
                                        .addComponent(this.jLabel13)
                                        .addComponent(this.jLabel15)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(this.undepTotal, -1, -1, 32767)
                                        .addComponent(this.jButton3, -1, 244, 32767)
                                        .addComponent(this.undepCash, -1, -1, 32767)
                                        .addComponent(this.undepCheck, -1, -1, 32767)
                                        .addComponent(this.undepCredit, -1, -1, 32767)
                                        .addComponent(this.jSeparator1)
                                        .addComponent(this.remainUndep, -1, -1, 32767)))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(this.jLabel6, -1, 409, 32767)
                        .addComponent(this.jPanel5, -1, -1, 32767)
                        .addComponent(this.jScrollPane1, -2, 0, 32767))
                .addContainerGap(120, 32767)));

        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(57, 57, 57).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                .addComponent(this.jLabel6, -2, 40, -2)
                .addComponent(this.jPanel4, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                        .addComponent(this.jScrollPane1, -2, 260, -2).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(this.jLabel3, -1, -1, 32767)
                                        .addComponent(this.undepCash, -2, 43, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(this.jLabel12, -1, -1, 32767)
                                        .addComponent(this.undepCheck, -2, 43, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(this.jLabel13, -1, -1, 32767)
                                        .addComponent(this.undepCredit, -2, 43, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(this.jLabel2, -1, -1, 32767)
                                        .addComponent(this.undepTotal, -2, 43, -2)).addGap(5, 5, 5)
                                .addComponent(this.jSeparator1, -2, 10, -2).addGap(3, 3, 3).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(this.jLabel15, -1, 43, 32767)
                                        .addComponent(this.remainUndep, -1, -1, 32767)).addGap(11, 11, 11))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(this.jPanel5, -2, -1, -2)
                        .addComponent(this.jButton3, -2, 44, -2))
                .addContainerGap(86, 32767)));

        this.setTab.addTab("Bank Deposits", this.jPanel1);

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(this.setTab)
                .addContainerGap()));

        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(this.setTab)
                .addContainerGap()));
    }

    private void setTabStateChanged(ChangeEvent evt) {
        int sel = this.setTab.getSelectedIndex();
        if (sel == 0) {
            loadDaily();
        } else if (sel == 1) {
            loadCCSettlements();
        } else if (sel == 2) {
            loadDeposits();
        }
    }

    private void jCheckBox1ActionPerformed(ActionEvent evt) {
        this.jCheckBox1.setSelected(true);
    }

    private void jButton1ActionPerformed(ActionEvent evt) {
        int sel = this.unSetTable.getSelectedRow();
        if (sel != -1) {
            String selID = this.unSetTable.getValueAt(sel, 3).toString();
            setSettlement(selID, 2);
        } else {
            JOptionPane.showMessageDialog(this.jButton1, "No selected record.\nPlease select row in the table", "Selection Error", 0);
        }
    }

    private void jButton2ActionPerformed(ActionEvent evt) {
        int sel = this.setTable.getSelectedRow();
        if (sel != -1) {
            String selID = this.setTable.getValueAt(sel, 4).toString();
            setSettlement(selID, 1);
        } else {
            JOptionPane.showMessageDialog(this.jButton2, "No selected record.\nPlease select row in the table", "Selection Error", 0);
        }
    }

    private void filDateActionPerformed(ActionEvent evt) {
        loadCCSettlements();
    }

    private void filViewActionPerformed(ActionEvent evt) {
        if (this.filView.isSelected()) {
            this.filDate.setEnabled(false);
        } else {
            this.filDate.setEnabled(true);
        }
        loadCCSettlements();
    }

    private void jButton3ActionPerformed(ActionEvent evt) {
        String in = JOptionPane.showInputDialog(this.depTable, "Enter amount");
        try {
            if (!in.isEmpty()) {
                float amount = Float.parseFloat(in);
                float rem = Float.parseFloat(this.remainUndep.getText());

                Class.forName("com.mysql.jdbc.Driver");
                String connectionUrl = DBUrl.dbcon;
                Connection con = DriverManager.getConnection(connectionUrl);
                PreparedStatement stmt = null;
                if ((amount <= rem) && (amount > 0.0F)) {
                    java.util.Date d = Calendar.getInstance().getTime();
                    String now = this.df.format(d) + " " + this.tf.format(d);

                    java.util.Date transDate = this.filDep.getDate();
                    String trans = this.df.format(transDate);

                    stmt = con.prepareStatement("INSERT INTO `reservation`.`deposited` (`amount`, `transDate`, `depDate`) VALUES (?, '" + trans + "', '" + now + "');");

                    stmt.setString(1, in);
                    int res = stmt.executeUpdate();
                    if (res != 0) {
                        JOptionPane.showMessageDialog(this.depTable, "Successfully saved");
                        new UserLogger().insertLog(Extras.loggeduser, 5, "Created new Deposit slipt, amount: " + amount);

                        loadDeposits();
                    }
                } else {
                    JOptionPane.showMessageDialog(this.depTable, "Please enter number within the undeposited amount", "Input Error", 0);
                }
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this.depTable, "Invalid input\nPlease enter valid amount", "Input Error", 0);
        } catch (NullPointerException ex) {
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.toString());
        } catch (ClassNotFoundException cE) {
            System.out.println("Class Not Found Exception: " + cE.toString());
        }
    }

    private void filDepActionPerformed(ActionEvent evt) {
        loadDeposits();
    }

    private void jButton5ActionPerformed(ActionEvent evt) {
        this.setTab.setSelectedIndex(1);
    }

    private void jButton7ActionPerformed(ActionEvent evt) {
        this.setTab.setSelectedIndex(2);
    }

    private void jButton8ActionPerformed(ActionEvent evt) {
        this.newAdjust.setVisible(true);
    }

    private void jButton9ActionPerformed(ActionEvent evt) {
        System.out.println(this.adjustments.getSize());
        this.adjustments.setVisible(false);
    }

    private void jButton50ActionPerformed(ActionEvent evt) {
        int r = 0;
        java.util.Date selDay = this.filDaily.getDate();
        String date = this.df.format(selDay) + " " + this.tf.format(selDay);
        try {
            String sAdjDesc = this.adjDesc.getText();
            float fAmount = Float.valueOf(this.adjAmount.getText()).floatValue();

            Class.forName("com.mysql.jdbc.Driver");
            String connectionUrl = DBUrl.dbcon;
            Connection con = DriverManager.getConnection(connectionUrl);
            PreparedStatement stmt = null;
            ResultSet rs = null;
            stmt = con.prepareStatement("INSERT INTO `reservation`.`daily_adjust` (`desc`, `amount`, `date`) VALUES ( ?, ?, ?);");

            stmt.setString(1, sAdjDesc);
            stmt.setFloat(2, fAmount);
            stmt.setString(3, date);
            r = stmt.executeUpdate();
            new UserLogger().insertLog(Extras.loggeduser, 5, "Created new adjustment " + sAdjDesc + " for " + this.df.format(selDay) + ", amount: " + fAmount);
        } catch (NumberFormatException ex) {
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.toString());
            JOptionPane.showMessageDialog(this.newAdjust, "Please check your inputs", "Input Error", 0);
        } catch (ClassNotFoundException cE) {
            System.out.println("Class Not Found Exception: " + cE.toString());
        }
        if (r != 0) {
            JOptionPane.showMessageDialog(this.newAdjust, "Adjustment Successfully added");
            this.newAdjust.setVisible(false);
            loadAdjusts(this.df.format(selDay));

            this.reconAdj.setText(this.totalAdj.getText() + "");
            loadDaily();
        } else {
            JOptionPane.showMessageDialog(this.newAdjust, "Please check your inputs", "Input Error", 0);
        }
    }

    private void jButton51ActionPerformed(ActionEvent evt) {
        System.out.println(this.newAdjust.getSize());
        this.newAdjust.setVisible(false);
    }

    private void jButton6ActionPerformed(ActionEvent evt) {
        java.util.Date d = this.filDaily.getDate();
        String now = this.df.format(d);
        System.out.println(now);
        loadAdjusts(now);
        this.adjustments.setVisible(true);
    }

    private void filDailyActionPerformed(ActionEvent evt) {
        loadDailyReport();
    }

    private void jTabbedPane1StateChanged(ChangeEvent evt) {
        loadDailyReport();
    }

    private void jButton4ActionPerformed(ActionEvent evt) {
        String now = this.filDaily.getDate().toString();
        String repDay = now.substring(0, 10) + ", " + now.substring(now.length() - 4, now.length());

        String sales = this.reconSales.getText();
        String room = this.reconRoom.getText();
        String balance = this.reconBal.getText();
        String setCredit = this.reconCredit.getText();
        String cashAdj = this.reconAdj.getText();
        String total = this.reconTotal.getText();
        DefaultTableModel slipModel = (DefaultTableModel) this.reconDepTable.getModel();
        String totalSlip = this.reconDepTotal.getText();

        DefaultTableModel outRecModel = (DefaultTableModel) this.receivablesTable.getModel();
        String outTotal = this.bal.getText();

        DefaultTableModel otherRecModel = (DefaultTableModel) this.otherBal.getModel();
        String otherTotal = this.bal2.getText();

        String occu = this.miscOccu.getText();
        String vacant = this.miscVacant.getText();
        String unsetCC = this.miscUnset.getText();
        String numUnsetCC = this.miscNoCred.getText();
        String occuRate = this.miscOccuRate.getText();

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

        JFileChooser FileSytemView = new JFileChooser();

        File Sample = FileSytemView.getFileSystemView().getDefaultDirectory();
        String Sfile = Sample.toString();

        String db = "\\\\";
        String filename = Sfile.replace("\\", db);
        System.out.println(filename = filename + "\\" + "\\" + rDate + time + ".pdf");

        System.out.print(filename);

        java.util.Date d8 = this.filDaily.getDate();
        String n = this.df.format(d8);
        loadAdjusts(n);
        DefaultTableModel adjModel = (DefaultTableModel) this.dayAdjTable.getModel();
        DailyReport dr = new DailyReport(filename, repDay, sales, room, balance, setCredit, adjModel, cashAdj, total, slipModel, totalSlip, outRecModel, outTotal, otherRecModel, otherTotal, occu, vacant, unsetCC, numUnsetCC, occuRate);
    }

    private void loadCCSettlements() {
        float untotal = new LoadSales().LoadSales(this.unSetTable, new TableModels().unSetModel, "SELECT `amount`, `cust`, DATE(`transDate`), `creditNo` FROM `credit` WHERE `stat` = 1 ORDER BY `transDate` DESC;", 0);

        this.unCred.setText(this.unSetTable.getRowCount() + "");
        this.unTotal.setText(this.decForm.format(untotal));

        String filViewQ = "";
        if (!this.filView.isSelected()) {
            String date = this.df.format(this.filDate.getDate());
            filViewQ = " DATE(`setDate`) = '" + date + "' AND ";
        }
        float total = new LoadSales().LoadSales(this.setTable, new TableModels().setModel, "SELECT `amount`, `cust`, DATE(`transDate`), DATE(`setDate`), `creditNo` FROM `credit` WHERE 1=1 AND " + filViewQ + " `stat` = " + 2 + " ORDER BY `transDate` DESC;", 0);

        this.setCred.setText(this.setTable.getRowCount() + "");
        this.setTotal.setText(this.decForm.format(total));
    }

    private void setSettlement(String selID, int stat) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String connectionUrl = DBUrl.dbconSales;
            Connection con = DriverManager.getConnection(connectionUrl);
            Statement stmt = null;
            ResultSet rs = null;
            stmt = con.createStatement();

            java.util.Date d = Calendar.getInstance().getTime();

            String now = this.df.format(d) + " " + this.tf.format(d);
            String nowQ = "";
            if (stat == 2) {
                nowQ = " ,`setDate` = '" + now + "' ";
            } else {
                nowQ = " ,`setDate` = NULL ";
            }
            int res = stmt.executeUpdate("UPDATE `database`.`credit` SET `stat`=" + stat + " " + nowQ + " WHERE  `creditNo`='" + selID + "';");
            if (res != 0) {
                loadCCSettlements();
                new UserLogger().insertLog(Extras.loggeduser, 5, "Set CC status to " + stat + " for creditID " + selID);
            }
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.toString());
        } catch (ClassNotFoundException cE) {
            System.out.println("Class Not Found Exception: " + cE.toString());
        }
    }

    private void loadDeposits() {
        java.util.Date d = this.filDep.getDate();
        String now = this.df.format(d);
        System.out.println(now);

        float roomCash = getRoomCash(now);
        float roomCheck = getRoomCheck(now);

        float salesCash = getSalesCash(now);
        float salesCheck = getSalesCheck(now);

        float adj = loadAdjusts(now);

        float settledCC = getSettledCC(now);

        float settledBalCash = getSettledBalCash(now);

        float settledBalCheck = getSettledBalCheck(now);

        System.out.println("roomCash: " + roomCash + "\n" + "roomCheck: " + roomCheck + "\n" + "salesCash: " + salesCash + "\n" + "salesCheck: " + salesCheck + "\n" + "adjustments: " + adj + "\n" + "settledCC: " + settledCC);

        this.undepCash.setText(this.decForm.format(roomCash + salesCash + settledBalCash + adj));
        this.undepCheck.setText(this.decForm.format(roomCheck + salesCheck + settledBalCheck));
        this.undepCredit.setText(this.decForm.format(settledCC));
        float total = roomCash + salesCash + settledBalCash + adj + roomCheck + salesCheck + settledBalCheck + settledCC;

        this.undepTotal.setText(this.decForm.format(total));
        float deposited = loadDeposited(now);
        this.remainUndep.setText(this.decForm.format(total - deposited));
        if (total - deposited == 0.0F) {
            this.remainUndep.setForeground(new Color(0, 153, 0));
        } else {
            this.remainUndep.setForeground(new Color(255, 102, 102));
        }
    }

    private float getRoomCash(String now) {
        float total = 0.0F;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String connectionUrl = DBUrl.dbcon;
            Connection con = DriverManager.getConnection(connectionUrl);
            Statement stmt = null;
            ResultSet rs = null;
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT IFNULL(SUM(`amount`), 0) AS total  FROM `paycash` WHERE `mode` = 'cash'  AND DATE(`datePaid`) = '" + now + "';");
            if (rs.next()) {
                total += rs.getFloat("total");
            }
            Statement stmt2 = null;
            ResultSet rs2 = null;
            stmt2 = con.createStatement();
            rs2 = stmt2.executeQuery("SELECT IFNULL(SUM(`amount`), 0) AS total  FROM `payrecord` WHERE `mode` = 'cash'  AND DATE(`datePaid`) = '" + now + "';");
            if (rs2.next()) {
                total += rs2.getFloat("total");
            }
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.toString());
        } catch (ClassNotFoundException cE) {
            System.out.println("Class Not Found Exception: " + cE.toString());
        }
        return total;
    }

    private float getRoomCheck(String now) {
        float total = 0.0F;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String connectionUrl = DBUrl.dbcon;
            Connection con = DriverManager.getConnection(connectionUrl);
            Statement stmt = null;
            ResultSet rs = null;
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT IFNULL(SUM(`amount`), 0) AS total  FROM `paycash` WHERE `mode` = 'check'  AND DATE(`datePaid`) = '" + now + "';");
            if (rs.next()) {
                total += rs.getFloat("total");
            }
            Statement stmt2 = null;
            ResultSet rs2 = null;
            stmt2 = con.createStatement();
            rs2 = stmt2.executeQuery("SELECT IFNULL(SUM(`amount`), 0) AS total  FROM `payrecord` WHERE `mode` = 'check'  AND DATE(`datePaid`) = '" + now + "';");
            if (rs2.next()) {
                total += rs2.getFloat("total");
            }
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.toString());
        } catch (ClassNotFoundException cE) {
            System.out.println("Class Not Found Exception: " + cE.toString());
        }
        return total;
    }

    private float getSalesCash(String now) {
        float total = 0.0F;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String connectionUrl = DBUrl.dbconSales;
            Connection con = DriverManager.getConnection(connectionUrl);
            Statement stmt = null;
            ResultSet rs = null;
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT IFNULL(SUM(`tenCash`), 0) AS total  FROM `transaction` WHERE  `date` = '" + now + "';");
            if (rs.next()) {
                total = rs.getFloat("total");
            }
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.toString());
        } catch (ClassNotFoundException cE) {
            System.out.println("Class Not Found Exception: " + cE.toString());
        }
        return total;
    }

    private float getSalesCheck(String now) {
        float total = 0.0F;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String connectionUrl = DBUrl.dbconSales;
            Connection con = DriverManager.getConnection(connectionUrl);
            Statement stmt = null;
            ResultSet rs = null;
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT IFNULL(SUM(`tenCheck`), 0) AS total  FROM `transaction` WHERE  `date` = '" + now + "';");
            if (rs.next()) {
                total = rs.getFloat("total");
            }
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.toString());
        } catch (ClassNotFoundException cE) {
            System.out.println("Class Not Found Exception: " + cE.toString());
        }
        return total;
    }

    private float getSettledCC(String now) {
        float total = 0.0F;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String connectionUrl = DBUrl.dbconSales;
            Connection con = DriverManager.getConnection(connectionUrl);
            Statement stmt = null;
            ResultSet rs = null;
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT IFNULL(SUM(`amount`), 0) AS total  FROM `credit` WHERE `stat` = 2 AND DATE(`setDate`) = '" + now + "';");
            if (rs.next()) {
                total = rs.getFloat("total");
            }
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.toString());
        } catch (ClassNotFoundException cE) {
            System.out.println("Class Not Found Exception: " + cE.toString());
        }
        return total;
    }

    private float getSettledBalCash(String now) {
        float total = 0.0F;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String connectionUrl = DBUrl.dbcon;
            Connection con = DriverManager.getConnection(connectionUrl);
            Statement stmt = null;
            ResultSet rs = null;
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT IFNULL(SUM(`amount`), 0) AS total  FROM `paybal` WHERE `mode` = 'cash' AND `date` = '" + now + "';");
            if (rs.next()) {
                total = rs.getFloat("total");
            }
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.toString());
        } catch (ClassNotFoundException cE) {
            System.out.println("Class Not Found Exception: " + cE.toString());
        }
        return total;
    }

    private float getSettledBalCheck(String now) {
        float total = 0.0F;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String connectionUrl = DBUrl.dbcon;
            Connection con = DriverManager.getConnection(connectionUrl);
            Statement stmt = null;
            ResultSet rs = null;
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT IFNULL(SUM(`amount`), 0) AS total  FROM `paybal` WHERE `mode` = 'check' AND `date` = '" + now + "';");
            if (rs.next()) {
                total = rs.getFloat("total");
            }
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.toString());
        } catch (ClassNotFoundException cE) {
            System.out.println("Class Not Found Exception: " + cE.toString());
        }
        return total;
    }

    private float loadDeposited(String now) {
        float total = new LoadSales().LoadSales(this.depTable, new TableModels().depModel, "SELECT  DATE(`depDate`), `amount` FROM reservation.deposited WHERE DATE(`transDate`) = '" + now + "' ORDER BY `depID` DESC;", 1);

        this.depNum.setText(this.depTable.getRowCount() + "");
        this.depTotal.setText(this.decForm.format(total));
        return total;
    }

    private float loadReconDeposited(String now) {
        float total = new LoadSales().LoadSales(this.reconDepTable, new TableModels().depModel, "SELECT DATE(`depDate`), `amount` FROM reservation.deposited WHERE DATE(`transDate`) = '" + now + "' ORDER BY `depID` DESC;", 1);

        return total;
    }

    private float loadAdjusts(String now) {
        float total = new LoadPayment().LoadPayment(this.dayAdjTable, new TableModels().dayAdjModel, "SELECT `desc`, `amount`, `date` FROM daily_adjust WHERE DATE(`date`)='" + now + "';", 1);

        this.totalAdj.setText(this.decForm.format(total));

        return total;
    }

    private void loadDaily() {
        java.util.Date d = this.filDaily.getDate();
        String now = this.df.format(d);
        System.out.println(now);

        float roomCash = getRoomCash(now);
        float roomCheck = getRoomCheck(now);

        float salesCash = getSalesCash(now);
        float salesCheck = getSalesCheck(now);

        float settledBalCash = getSettledBalCash(now);

        float settledBalCheck = getSettledBalCheck(now);

        float settledCC = getSettledCC(now);

        this.reconAdj.setText(this.decForm.format(loadAdjusts(now)));

        float adj = Float.parseFloat(this.reconAdj.getText());

        this.reconSales.setText(this.decForm.format(salesCash + salesCheck));
        this.reconRoom.setText(this.decForm.format(roomCash + roomCheck));
        this.reconBal.setText(this.decForm.format(settledBalCash + settledBalCheck));
        this.reconCredit.setText(this.decForm.format(settledCC));

        float total = salesCash + salesCheck + roomCash + roomCheck + settledBalCash + settledBalCheck + settledCC + adj;

        this.reconTotal.setText(this.decForm.format(total));

        float deposited = loadReconDeposited(now);

        this.reconDepTotal.setText(this.decForm.format(deposited));
        if (total > deposited) {
            this.reconDepTotal.setForeground(new Color(255, 0, 0));
        } else {
            this.reconDepTotal.setForeground(new Color(0, 153, 0));
        }
    }

    private void LoadOutReport() {
        int r = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String connectionUrl = DBUrl.dbcon;
            Connection con = DriverManager.getConnection(connectionUrl);
            Statement stmt = null;
            ResultSet rs = null;
            String SQL = "SELECT `room`, `guest`, `dateOut`, `bal` FROM `resrecords` WHERE `bal` != 0 ORDER BY `room` DESC;";

            DefaultTableModel model = new TableModels().receivablesModel;

            float totalBal = 0.0F;

            String dateNow = this.df.format(Calendar.getInstance().getTime());
            String SQL1 = "(SELECT reservation.roomID, reservation.guestID,  \nDATEDIFF('" + dateNow + "', reservation.inDate) AS `numDay`, ((room + \n" + "(SELECT IFNULL(SUM(extra.xtra), 0) FROM extra WHERE extra.resID=reservation.resID)+\n" + "(SELECT IFNULL(SUM(adjustments.amount), 0) FROM adjustments WHERE adjustments.resID=reservation.resID))-\n" + "(SELECT IFNULL(SUM(paycash.amount), 0) FROM paycash WHERE paycash.resID=reservation.resID)) AS `bal`\n" + "FROM reservation, guesttrans\n" + "WHERE guesttrans.resID=reservation.resID AND reservation.stat='o' AND ((room + \n" + "(SELECT IFNULL(SUM(extra.xtra), 0) FROM extra WHERE extra.resID=reservation.resID)+\n" + "(SELECT IFNULL(SUM(adjustments.amount), 0) FROM adjustments WHERE adjustments.resID=reservation.resID))-\n" + "(SELECT IFNULL(SUM(paycash.amount), 0) FROM paycash WHERE paycash.resID=reservation.resID) ) != 0 ORDER BY `roomID`)\n" + "UNION\n" + "(SELECT `room`, `guest`, `dateOut`, `bal` FROM `resrecords` WHERE `bal` != 0 ORDER BY `room` DESC)\n" + "ORDER BY `roomID`;";

            System.out.println(SQL1);
            stmt = con.createStatement();
            rs = stmt.executeQuery(SQL1);
            while (rs.next()) {
                model.addRow(new Object[0]);
                model.setValueAt(rs.getString(1), r, 0);
                model.setValueAt(rs.getString(2), r, 1);
                model.setValueAt(rs.getString(3), r, 2);
                totalBal += rs.getFloat(4);
                model.setValueAt(this.decForm.format(rs.getFloat(4)), r, 3);
                r++;
            }
            this.bal.setText(this.decForm.format(totalBal));
            this.bal1.setText("" + r);
            this.receivablesTable.setModel(model);
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.toString());
        } catch (ClassNotFoundException cE) {
            System.out.println("Class Not Found Exception: " + cE.toString());
        }
    }

    private void LoadOtherBal() {
        int r = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String connectionUrl = DBUrl.dbconSales;
            Connection con = DriverManager.getConnection(connectionUrl);
            PreparedStatement stmt = null;
            ResultSet rs = null;
            String SQL = "SELECT `cust`, `date`, `totalPrice`, `tenCharge` FROM `transaction` WHERE (`cust` LIKE 'Emp::%' OR `cust` LIKE '11th::%' OR `cust` LIKE 'Other::%') AND `tenCharge` > 0 ORDER BY date DESC;";

            stmt = con.prepareStatement(SQL);
            rs = stmt.executeQuery();
            DefaultTableModel model = new TableModels().otherBalModel;

            float totalBal = 0.0F;
            while (rs.next()) {
                model.addRow(new Object[0]);
                model.setValueAt(rs.getString("cust"), r, 0);
                model.setValueAt(rs.getString("date"), r, 1);
                model.setValueAt(rs.getString("totalPrice"), r, 2);
                model.setValueAt(rs.getString("tenCharge"), r, 3);
                totalBal += rs.getFloat("tenCharge");
                r++;
            }
            this.bal2.setText(this.decForm.format(totalBal));
            this.bal3.setText(r + "");
            this.otherBal.setModel(model);
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.toString());
        } catch (ClassNotFoundException cE) {
            System.out.println("Class Not Found Exception: " + cE.toString());
        }
    }

    private void loadAvailRooms() {
        try {
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

            String que = "SELECT COUNT(`roomID`) AS total FROM `rooms` WHERE 1=1";
            while (rs.next()) {
                que = que + " AND `roomID` != '" + rs.getString("roomID") + "'";
            }
            System.out.println(que);

            Statement stmt1 = null;
            ResultSet rs1 = null;
            stmt1 = con.createStatement();

            rs1 = stmt1.executeQuery(que);
            rs1.next();

            int availQuan = rs1.getInt("total");

            this.miscVacant.setText(availQuan + "");
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.toString());
        } catch (ClassNotFoundException cE) {
            System.out.println("Class Not Found Exception: " + cE.toString());
        }
    }

    private String dateAdd(String prev, int days) {
        String out = "";
        try {
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
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.toString());
        } catch (ClassNotFoundException cE) {
            System.out.println("Class Not Found Exception: " + cE.toString());
        }
        return out;
    }

    private void getUnSettledCC() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String connectionUrl = DBUrl.dbconSales;
            Connection con = DriverManager.getConnection(connectionUrl);
            Statement stmt = null;
            ResultSet rs = null;
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT IFNULL(SUM(`amount`), 0) AS total, COUNT(`stat`) AS num FROM `credit` WHERE `stat` = 1 ORDER BY `transDate` DESC;");

            System.out.println("SELECT IFNULL(SUM(`amount`), 0) AS total, COUNT(`stat`) AS num FROM `credit` WHERE `stat` = 1 ORDER BY `transDate` DESC;");

            rs.next();
            float total = rs.getFloat("total");
            int num = rs.getInt("num");
            this.miscUnset.setText(this.decForm.format(total));
            this.miscNoCred.setText("(" + num + " Credit card transactions)");
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.toString());
        } catch (ClassNotFoundException cE) {
            System.out.println("Class Not Found Exception: " + cE.toString());
        }
    }

    private void loadDailyReport() {
        loadDaily();

        LoadOutReport();
        LoadOtherBal();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String connectionUrl = DBUrl.dbcon;
            Connection con = DriverManager.getConnection(connectionUrl);
            Statement stmt = null;
            ResultSet rs = null;
            stmt = con.createStatement();

            int nOccu = 0;
            rs = stmt.executeQuery("SELECT COUNT(`resID`) AS count FROM `reservation` WHERE `stat`='o';");
            rs.next();
            nOccu = rs.getInt("count");
            this.miscOccu.setText(nOccu + "");
            rs.close();

            loadAvailRooms();

            getUnSettledCC();

            int o = Integer.parseInt(this.miscOccu.getText());
            int v = Integer.parseInt(this.miscVacant.getText());
            if (o != 0) {
                float occuRate = 100 / ((o + v) / o);
                this.miscOccuRate.setText(occuRate + "%");
            } else {
                this.miscOccuRate.setText("0%");
            }
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.toString());
        } catch (ClassNotFoundException cE) {
            System.out.println("Class Not Found Exception: " + cE.toString());
        }
    }
}



/* Location:           D:\New folder\New folder\dist\11thPrototype.jar

 * Qualified Name:     MainForms.Settlements

 * JD-Core Version:    0.7.0.1

 */
