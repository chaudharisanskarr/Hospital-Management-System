
package jan1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class HospitalManagementSystem extends JFrame implements ActionListener {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JRadioButton staffRadioButton;
    private JRadioButton doctorRadioButton;
    private ButtonGroup buttonGroup;
    private JButton loginButton;

    public HospitalManagementSystem() {
        setTitle("Hospital Management System Login");
        setLayout(null);
        
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(50, 50, 100, 30);
        add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setBounds(150, 50, 200, 30);
        add(usernameField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 100, 100, 30);
        add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 100, 200, 30);
        add(passwordField);

        staffRadioButton = new JRadioButton("Staff");
        staffRadioButton.setBounds(50, 150, 100, 30);
        add(staffRadioButton);

        doctorRadioButton = new JRadioButton("Doctor");
        doctorRadioButton.setBounds(200, 150, 100, 30);
        add(doctorRadioButton);

        buttonGroup = new ButtonGroup();
        buttonGroup.add(staffRadioButton);
        buttonGroup.add(doctorRadioButton);

        loginButton = new JButton("Login");
        loginButton.setBounds(150, 200, 100, 30);
        add(loginButton);
        loginButton.addActionListener(this);

        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @SuppressWarnings("deprecation")
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
        
        //  Connectiondb conn = new Connectiondb() ;
        //  String q = "select * from doctors";
        //  ResultSet rs = executeQuery(q);
        String namer = usernameField.getText();
        String pwd = passwordField.getText();

        try {
            Connection con = Connectiondb.getConnection(); // You should define Connectiondb class
            PreparedStatement ps = null;

            if (staffRadioButton.isSelected()) {
                ps = con.prepareStatement("select * from staff where uname=? and pwd=?");
                ps.setString(1, namer);
                ps.setString(2, pwd);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Welcome STAFF");
                    // You should define Staffdashboard class
                    Staffdashboard sd = new Staffdashboard();
                    sd.setVisible(true);
                    this.dispose();
                } 
                else {
                   // Invalid admin
                    JOptionPane.showMessageDialog(null, "Invalid Uname or Password");
                    
                    this.dispose();
                } 
            } else if (doctorRadioButton.isSelected()) {
                // Doctor login
                ps = con.prepareStatement("select * from doctor where uname=? and pwd=?");
                ps.setString(1, namer);
                ps.setString(2, pwd);
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
                    
                    this.dispose();
                }
            }
        } catch (Exception ae) {
            ae.printStackTrace(); // Print the exception stack trace for debugging
        }
        }
    }

    // Implement your database authentication methods here
    private boolean authenticateStaff(String username, String password) {
        // Add your staff authentication logic here
        return false;
    }

    private boolean authenticateDoctor(String username, String password) {
        // Add your doctor authentication logic here
        return false;
    }

    public static void main(String[] args) {
        HospitalManagementSystem hms = new HospitalManagementSystem();
        hms.setVisible(true);
    }
}