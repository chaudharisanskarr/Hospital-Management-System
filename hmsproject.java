package jan1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class hmsproject extends javax.swing.JFrame {
    
    public hmsproject() {
        initComponents();
    }
   
    @SuppressWarnings("unchecked")
                          
    private void initComponents() {
        

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        staffr = new javax.swing.JRadioButton();
        doctorr = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        namer = new javax.swing.JTextField();
        pwd = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        jLabel1.setText("LOGIN FORM");
        jLabel2.setText("NAME");
        jLabel3.setText("PASSWORD");
        buttonGroup1.add(staffr);
        staffr.setText("STAFF");
        buttonGroup1.add(doctorr);
        doctorr.setText("DOCTOR");
        jButton1.setText("LOGIN");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton2.setText("CLEAR");
        jLabel4.setText("LOGIN AS");
        setBounds(0, 0, 800, 500);
    }
                           
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        try {
            Connection con = Connectiondb.getConnection(); // You should define Connectiondb class
            PreparedStatement ps = null;
            if (staffr.isSelected()) {
                ps = con.prepareStatement("select * from staff where uname=? and pwd=?");
                ps.setString(1, namer.getText());
                ps.setString(2, pwd.getText());
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Welcome STAFF");
                    // You should define Staffdashboard class
                    Staffdashboard sd = new Staffdashboard();
                    sd.setVisible(true);
                    this.dispose();
                } else {
                    // Invalid admin
                    JOptionPane.showMessageDialog(null, "Invalid Uname or Password");
                    hmsproject hms = new hmsproject();
                    hms.setVisible(true);
                    this.dispose();
                }
            } else if (doctorr.isSelected()) {
                // Doctor login
                ps = con.prepareStatement("select * from doctor where uname=? and pwd=?");
                ps.setString(1, namer.getText());
                ps.setString(2, pwd.getText());
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    // Valid doctor
                    JOptionPane.showMessageDialog(null, "Welcome DOCTOR");
                    // You should define Doctordashboard class
                    Doctordashboard td = new Doctordashboard();
                    td.setVisible(true);
                    this.dispose();
                } else {
                    // Invalid doctor
                    JOptionPane.showMessageDialog(null, "Invalid username and password");
                    hmsproject hms = new hmsproject();
                    hms.setVisible(true);
                    this.dispose();
                }
            }
        } catch (Exception e) {
            e.printStackTrace(); // Print the exception stack trace for debugging
        }
    }
  
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new hmsproject().setVisible(true);
            }
        });
    }
    
    // Declare all your GUI components here
    
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton doctorr;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField namer;
    private javax.swing.JPasswordField pwd;
    private javax.swing.JRadioButton staffr;
}
