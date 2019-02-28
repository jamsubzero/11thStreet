package MainForms;

import Fields.DBUrl;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import org.jdesktop.swingx.JXDatePicker;
import org.joda.time.DateTime;
import org.joda.time.DateTime.Property;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class RoomCalendar
        extends JDialog {

    public RoomCalendar(Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        displayCal();
    }

    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    DateTimeFormatter jodaDF = DateTimeFormat.forPattern("yyyy-MM-dd");
    private JXDatePicker cal;
    private JTable calTable;
    private JButton jButton10;
    private JFormattedTextField jFormattedTextField1;
    private JLabel jLabel16;
    private JPanel jPanel5;
    private JPanel jPanel6;
    private JScrollPane jScrollPane2;

    private void initComponents() {
        this.jPanel5 = new JPanel();
        this.jScrollPane2 = new JScrollPane();
        this.calTable = new JTable();
        this.jPanel6 = new JPanel();
        this.jLabel16 = new JLabel();
        this.jButton10 = new JButton();
        this.cal = new JXDatePicker();
        this.jFormattedTextField1 = new JFormattedTextField();

        setDefaultCloseOperation(2);
        setMinimumSize(new Dimension(883, 531));
        setModal(true);
        setPreferredSize(new Dimension(1083, 731));

        this.jPanel5.setBackground(new Color(51, 0, 153));

        this.calTable.setBorder(BorderFactory.createEtchedBorder());
        this.calTable.setFont(new Font("Tahoma", 1, 12));
        this.calTable.setModel(new DefaultTableModel(new Object[0][], new String[0]));

        this.calTable.setAutoResizeMode(0);
        this.calTable.setIntercellSpacing(new Dimension(5, 5));
        this.calTable.setRowHeight(27);
        this.calTable.setRowSelectionAllowed(false);
        this.calTable.getTableHeader().setReorderingAllowed(false);
        this.jScrollPane2.setViewportView(this.calTable);

        this.jPanel6.setBackground(new Color(51, 0, 153));
        this.jPanel6.setBorder(BorderFactory.createTitledBorder(null, "Filter by", 0, 0, null, Color.white));

        this.jLabel16.setForeground(new Color(255, 255, 255));
        this.jLabel16.setText("Date:");

        this.jButton10.setText("Refresh");
        this.jButton10.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                RoomCalendar.this.jButton10ActionPerformed(evt);
            }
        });
        this.cal.setDate(Calendar.getInstance().getTime());
        this.cal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                RoomCalendar.this.calActionPerformed(evt);
            }
        });
        this.jFormattedTextField1.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));

        GroupLayout jPanel6Layout = new GroupLayout(this.jPanel6);
        this.jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(this.jLabel16).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(this.cal, -2, 199, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(this.jFormattedTextField1, -2, 170, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
                .addComponent(this.jButton10, -2, 134, -2)
                .addContainerGap()));

        jPanel6Layout.setVerticalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap().addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(this.jButton10).addGap(3, 3, 3)).addGroup(GroupLayout.Alignment.LEADING, jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(this.jLabel16, -2, 27, -2)
                                .addComponent(this.cal, -2, -1, -2)
                                .addComponent(this.jFormattedTextField1, -2, -1, -2)))
                .addContainerGap(-1, 32767)));

        GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
        this.jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap().addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(this.jPanel6, -1, -1, 32767)
                        .addComponent(this.jScrollPane2, GroupLayout.Alignment.TRAILING, -1, 770, 32767))
                .addContainerGap()));

        jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(this.jPanel6, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(this.jScrollPane2, -1, 499, 32767)
                .addContainerGap()));

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(this.jPanel5, -1, -1, 32767)
                .addContainerGap()));

        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(this.jPanel5, -1, -1, 32767)
                .addContainerGap()));

        pack();
    }

    private void jButton10ActionPerformed(ActionEvent evt) {
        loadTable();
        System.out.println(getSize());
    }

    private void calActionPerformed(ActionEvent evt) {
        loadTable();
    }

    private void loadTable() {
        DateFormat[] d = this.cal.getFormats();
        DateFormat format = d[0];
        DateTime dt = new DateTime(this.cal.getDate());
        int m = dt.getMonthOfYear();
        int y = dt.getYear();
        int max = dt.dayOfMonth().withMaximumValue().getDayOfMonth();
        System.out.println(format.format(this.cal.getDate()));
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String connectionUrl = DBUrl.dbcon;
            Connection con = DriverManager.getConnection(connectionUrl);
            Statement stmt = null;
            ResultSet rs = null;
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT `roomID` FROM `rooms`");

            this.calTable = new JTable();

            this.calTable.setBorder(BorderFactory.createEtchedBorder());

            this.calTable.setFont(new Font("Tahoma", 1, 12));

            this.calTable.setModel(new DefaultTableModel(new Object[0][], new String[0]) {
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            });
            this.calTable.setAutoResizeMode(0);

            this.calTable.setIntercellSpacing(new Dimension(5, 5));

            this.calTable.setRowHeight(27);

            this.calTable.setRowSelectionAllowed(false);

            this.calTable.getTableHeader().setReorderingAllowed(false);

            this.jScrollPane2.setViewportView(this.calTable);

            DefaultTableModel model = (DefaultTableModel) this.calTable.getModel();
            System.out.println("col: " + model.getColumnCount());

            model
                    .addColumn("Room");
            String dayWord = "";
            for (int cols = 1; cols <= max; cols++) {
                dayWord = format.format(this.df.parse(y + "-" + m + "-" + cols)).substring(0, 3);
                model
                        .addColumn(cols + " " + dayWord);
                System.out.println(dayWord);
            }
            Statement stmt0 = con.createStatement();

            String q = "SELECT stat, guestID, inDate, outDate FROM reservation WHERE ((MONTH(`inDate`)= " + m + " AND YEAR(`inDate`) = " + y + ") OR " + "MONTH(`outDate`)= " + m + " AND YEAR(`outDate`) = " + y + ")";

            int r = 0;
            while (rs.next()) {
                model.addRow(new Object[0]);
                model.setValueAt(rs.getString("roomID"), r, 0);
                r++;
            }
            rs.beforeFirst();
            r = 0;
            while (rs.next()) {
                ResultSet rs0 = stmt0.executeQuery(q + " AND roomID='" + rs.getString("roomID") + "'");
                while (rs0.next()) {
                    DateTime in = new DateTime(rs0.getDate("inDate"));
                    int ind = in.getDayOfMonth();
                    if (in.getMonthOfYear() != m) {
                        ind = 1;
                    }
                    DateTime out = new DateTime(rs0.getDate("outDate"));
                    int outd = out.getDayOfMonth();
                    if (out.getMonthOfYear() != m) {
                        outd = max;
                    }
                    String stat = rs0.getString("stat").toUpperCase();
                    for (int c = ind; c <= outd; c++) {
                        if ((c == ind) && (in.getMonthOfYear() == m)) {
                            model.setValueAt(stat + " " + rs0.getString("inDate").substring(11, 16), r, c);
                        } else if ((c == outd) && (out.getMonthOfYear() == m)) {
                            model.setValueAt(stat + " " + rs0.getString("outDate").substring(11, 16), r, c - 1);
                        } else {
                            model.setValueAt(stat, r, c);
                        }
                    }
                }
                r++;
            }
            TableCellRenderer renderer = new CustomTableCellRenderer();
            this.calTable.setDefaultRenderer(Class.forName("java.lang.Object"), renderer);

            FixedColumnTable fct = new FixedColumnTable(1, this.jScrollPane2);

            this.calTable.repaint();
            this.calTable.validate();
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.toString());
        } catch (ClassNotFoundException cE) {
            System.out.println("Class Not Found Exception: " + cE.toString());
        } catch (ParseException ex) {
            Logger.getLogger(RoomCalendar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void displayCal() {
        loadTable();
        setVisible(true);
    }

    public class CustomTableCellRenderer
            extends DefaultTableCellRenderer {

        public CustomTableCellRenderer() {
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            Object amount = value;
            if (amount == null) {
                cell.setBackground(new Color(255, 255, 204));
            } else if (amount.toString().startsWith("R")) {
                cell.setBackground(Color.RED);
            } else if (amount.toString().startsWith("O")) {
                cell.setBackground(Color.GREEN);
            }
            return cell;
        }
    }

    void clearTable(DefaultTableModel model) {
        model.setColumnCount(0);
        model.setRowCount(0);
    }
}



/* Location:           D:\New folder\New folder\dist\11thPrototype.jar

 * Qualified Name:     MainForms.RoomCalendar

 * JD-Core Version:    0.7.0.1

 */
