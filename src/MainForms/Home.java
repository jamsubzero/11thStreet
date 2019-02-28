package MainForms;

import Fields.DBUrl;
import Fields.Extras;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Home
  extends JPanel
{
  private JLabel hUser;
  private JButton jButton1;
  private JButton jButton16;
  private JLabel jLabel1;
  private JLabel jLabel18;
  private JLabel jLabel2;
  private JLabel jLabel25;
  private JLabel jLabel37;
  private JLabel jLabel42;
  private JSeparator jSeparator1;
  private JSeparator jSeparator6;
  private JLabel link;
  private JPanel logIn;
  private JInternalFrame logInFrame;
  private JPanel logInPanel;
  private JPasswordField pass;
  private JTextField user;
  
  public Home()
  {
    initComponents();
    this.logInFrame.setVisible(false);
    if (Extras.isLogged)
    {
      this.hUser.setText(Extras.loggeduser);
      this.hUser.setForeground(new Color(0, 204, 51));
      this.link.setVisible(false);
    }
  }
  
  private void initComponents()
  {
    this.logIn = new JPanel();
    this.logInFrame = new JInternalFrame();
    this.logInPanel = new JPanel();
    this.jButton16 = new JButton();
    this.jLabel18 = new JLabel();
    this.jLabel25 = new JLabel();
    this.jSeparator1 = new JSeparator();
    this.jSeparator6 = new JSeparator();
    this.user = new JTextField();
    this.jLabel1 = new JLabel();
    this.jLabel2 = new JLabel();
    this.pass = new JPasswordField();
    this.jButton1 = new JButton();
    this.jLabel42 = new JLabel();
    this.hUser = new JLabel();
    this.link = new JLabel();
    this.jLabel37 = new JLabel();
    
    this.logIn.setBackground(new Color(119, 116, 116));
    this.logIn.addMouseListener(new MouseAdapter()
    {
      public void mouseClicked(MouseEvent evt)
      {
        Home.this.logInMouseClicked(evt);
      }
    });
    this.logIn.setLayout(null);
    
    this.logInFrame.setVisible(true);
    
    this.logInPanel.setBackground(new Color(0, 0, 0));
    this.logInPanel.setPreferredSize(new Dimension(409, 600));
    
    this.jButton16.setText("Exit System");
    this.jButton16.setCursor(new Cursor(12));
    this.jButton16.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Home.this.jButton16ActionPerformed(evt);
      }
    });
    this.jLabel18.setFont(new Font("Tahoma", 0, 14));
    this.jLabel18.setForeground(new Color(51, 51, 255));
    this.jLabel18.setText("<html><u>About</u></html>");
    this.jLabel18.setCursor(new Cursor(12));
    this.jLabel18.addMouseListener(new MouseAdapter()
    {
      public void mouseClicked(MouseEvent evt)
      {
        Home.this.jLabel18MouseClicked(evt);
      }
    });
    this.jLabel25.setFont(new Font("SimHei", 0, 24));
    this.jLabel25.setForeground(new Color(51, 51, 255));
    this.jLabel25.setText("USER LOG IN");
    
    this.user.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Home.this.userActionPerformed(evt);
      }
    });
    this.jLabel1.setForeground(new Color(255, 255, 255));
    this.jLabel1.setText("User Name:");
    
    this.jLabel2.setForeground(new Color(255, 255, 255));
    this.jLabel2.setText("Password:");
    
    this.pass.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Home.this.passActionPerformed(evt);
      }
    });
    this.jButton1.setText("Log In");
    this.jButton1.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Home.this.jButton1ActionPerformed(evt);
      }
    });
    GroupLayout logInPanelLayout = new GroupLayout(this.logInPanel);
    this.logInPanel.setLayout(logInPanelLayout);
    logInPanelLayout.setHorizontalGroup(logInPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(logInPanelLayout.createSequentialGroup().addGroup(logInPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(logInPanelLayout.createSequentialGroup().addGroup(logInPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(logInPanelLayout.createSequentialGroup().addGap(88, 88, 88).addComponent(this.jLabel25)).addGroup(logInPanelLayout.createSequentialGroup().addGap(45, 45, 45).addGroup(logInPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel2).addComponent(this.jLabel1)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(logInPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jButton1, -2, 129, -2).addComponent(this.pass, -1, 145, 32767).addComponent(this.user)))).addGap(0, 50, 32767)).addGroup(logInPanelLayout.createSequentialGroup().addContainerGap().addGroup(logInPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(logInPanelLayout.createSequentialGroup().addComponent(this.jButton16, -2, 111, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.jLabel18, -2, 63, -2)).addComponent(this.jSeparator6, GroupLayout.Alignment.TRAILING).addComponent(this.jSeparator1, GroupLayout.Alignment.TRAILING)))).addContainerGap()));
    





























    logInPanelLayout.setVerticalGroup(logInPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, logInPanelLayout.createSequentialGroup().addGap(51, 51, 51).addComponent(this.jSeparator1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jLabel25).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jSeparator6, -2, 11, -2).addGap(45, 45, 45).addGroup(logInPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.user, -2, -1, -2).addComponent(this.jLabel1)).addGap(18, 18, 18).addGroup(logInPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel2).addComponent(this.pass, -2, -1, -2)).addGap(28, 28, 28).addComponent(this.jButton1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 126, 32767).addGroup(logInPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jButton16).addComponent(this.jLabel18)).addContainerGap()));
    
























    GroupLayout logInFrameLayout = new GroupLayout(this.logInFrame.getContentPane());
    this.logInFrame.getContentPane().setLayout(logInFrameLayout);
    logInFrameLayout.setHorizontalGroup(logInFrameLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.logInPanel, -2, 310, -2));
    


    logInFrameLayout.setVerticalGroup(logInFrameLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.logInPanel, -2, 424, -2));
    



    this.logIn.add(this.logInFrame);
    this.logInFrame.setBounds(380, 80, 320, 460);
    
    this.jLabel42.setFont(new Font("Tahoma", 0, 28));
    this.jLabel42.setText("Logged User:");
    this.logIn.add(this.jLabel42);
    this.jLabel42.setBounds(50, 390, 164, 34);
    
    this.hUser.setFont(new Font("Tahoma", 0, 28));
    this.hUser.setForeground(new Color(255, 0, 0));
    this.hUser.setText("Not Logged.");
    this.hUser.setCursor(new Cursor(0));
    this.hUser.addMouseListener(new MouseAdapter()
    {
      public void mouseClicked(MouseEvent evt)
      {
        Home.this.hUserMouseClicked(evt);
      }
    });
    this.logIn.add(this.hUser);
    this.hUser.setBounds(220, 390, 160, 34);
    
    this.link.setFont(new Font("Tahoma", 0, 28));
    this.link.setForeground(new Color(255, 0, 0));
    this.link.setText("<html><u>Click here to log in.</u></html>");
    this.link.setCursor(new Cursor(12));
    this.link.addMouseListener(new MouseAdapter()
    {
      public void mouseClicked(MouseEvent evt)
      {
        Home.this.linkMouseClicked(evt);
      }
    });
    this.logIn.add(this.link);
    this.link.setBounds(380, 390, 280, 34);
    
    this.jLabel37.setBackground(new Color(204, 204, 204));
    this.jLabel37.setIcon(new ImageIcon(getClass().getResource("/11th Street.jpg")));
    this.logIn.add(this.jLabel37);
    this.jLabel37.setBounds(30, 0, 1060, 710);
    
    GroupLayout layout = new GroupLayout(this);
    setLayout(layout);
    layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 1148, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.logIn, -1, -1, 32767).addContainerGap())));
    







    layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 732, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.logIn, -1, -1, 32767).addContainerGap())));
  }
  
  private void hUserMouseClicked(MouseEvent evt) {}
  
  private void linkMouseClicked(MouseEvent evt)
  {
    if (!Extras.isLogged) {
      this.logInFrame.setVisible(true);
    }
  }
  
  private void logInMouseClicked(MouseEvent evt)
  {
    Calendar c = Calendar.getInstance();
    int day = c.get(7);
    System.out.print(day);
  }
  
  private void jButton16ActionPerformed(ActionEvent evt)
  {
    exit();
  }
  
  private void jLabel18MouseClicked(MouseEvent evt) {}
  
  private void userActionPerformed(ActionEvent evt)
  {
    logIn();
  }
  
  private void passActionPerformed(ActionEvent evt)
  {
    logIn();
  }
  
  private void jButton1ActionPerformed(ActionEvent evt)
  {
    logIn();
  }
  
  void logIn()
  {
    String userName = this.user.getText();
    String passWord = new String(this.pass.getPassword());
    if ((userName.equals("")) || (passWord.equals("")) || (userName.contains(" ")) || (passWord.contains(" "))) {
      JOptionPane.showMessageDialog(this.logInFrame, "Error! Something is wrong with the input", "Input Error", 0);
    } else {
      try
      {
        Class.forName("com.mysql.jdbc.Driver");
        String connectionUrl = DBUrl.dbconSales;
        Connection con = DriverManager.getConnection(connectionUrl);
        
        Statement stmt1 = null;
        ResultSet rs1 = null;
        String encPass = Encrypt(passWord);
        PreparedStatement ps = con.prepareStatement("SELECT username FROM useraccount WHERE username=? AND password=?;");
        ps.setString(1, userName);
        ps.setString(2, encPass);
        stmt1 = con.createStatement();
        rs1 = ps.executeQuery();
        if (rs1.next())
        {
          JOptionPane.showMessageDialog(this, "Successfully logged in.", "Welcome", 1);
          Main.naviCur.setEnabled(true);
          Main.naviRes.setEnabled(true);
          Main.naviGuest.setEnabled(true);
          Main.naviRoom.setEnabled(true);
          Main.naviRec.setEnabled(true);
          Main.naviSet.setEnabled(true);
          Main.naviCal.setEnabled(true);
          Main.naviVac.setEnabled(true);
          

          Main.showNot.setEnabled(true);
          Extras.loggeduser = userName;
          Extras.isLogged = true;
          this.hUser.setText(Extras.loggeduser);
          this.hUser.setForeground(new Color(0, 204, 51));
          this.link.setVisible(false);
          


          this.user.setText("");
          this.pass.setText("");
          this.logInFrame.setVisible(false);
        }
        else
        {
          JOptionPane.showMessageDialog(this.logInFrame, "Incorrect userName or Password.", "LogIn Error", 0);
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
      catch (NoSuchAlgorithmException ex) {}catch (UnsupportedEncodingException ex) {}
    }
  }
  
  public static String Encrypt(String text)
    throws NoSuchAlgorithmException, UnsupportedEncodingException
  {
    MessageDigest md = MessageDigest.getInstance("SHA1");
    byte[] md5hash = new byte[32];
    md.update(text.getBytes("iso-8859-1"), 0, text.length());
    md5hash = md.digest();
    return convertToHex(md5hash);
  }
  
  private static String convertToHex(byte[] data)
  {
    StringBuffer buf = new StringBuffer();
    for (int i = 0; i < data.length; i++)
    {
      int halfbyte = data[i] >>> 4 & 0xF;
      int two_halfs = 0;
      do
      {
        if ((0 <= halfbyte) && (halfbyte <= 9))
        {
          buf.append((char)(48 + halfbyte));
        }
        else
        {
          buf.append((char)(97 + (halfbyte - 10)));
          halfbyte = data[i] & 0xF;
        }
      } while (two_halfs++ < 1);
    }
    return buf.toString();
  }
  
  void exit()
  {
    if (JOptionPane.showConfirmDialog(this, "Sure to exit?", "Exit Confirmation", 0) == 0) {
      System.exit(0);
    }
  }
}



/* Location:           D:\New folder\New folder\dist\11thPrototype.jar

 * Qualified Name:     MainForms.Home

 * JD-Core Version:    0.7.0.1

 */