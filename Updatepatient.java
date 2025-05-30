package jan1;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;

public class Updatepatient extends JFrame {

    
    private JButton jButton1;

    public Updatepatient() {
        initComponents();
    }

    private void initComponents() {
        setSize(390, 390);
        setLocationRelativeTo(null); // Center the frame
        setResizable(false);
        setTitle("UPDATE PATIENT");
        setLayout(null); // Use null layout to specify absolute positioning

        JLabel jLabel1 = new JLabel("UPDATE PATIENT");
        JLabel jLabel2 = new JLabel("USER NAME");
        JLabel jLabel3 = new JLabel("NAME1");
        JLabel jLabel4 = new JLabel("AGE1");
        JLabel jLabel6 = new JLabel("DISEASE");
        JLabel jLabel7 = new JLabel("PHONE_NUMBER");
        JLabel jLabel8 = new JLabel("GUARDIAN");
        JLabel jLabel9 = new JLabel("UNAME");
        JLabel jLabel10 = new JLabel("PWD");

        JTextField adm = new JTextField();
        jButton1 = new JButton("SEARCH");
        JTextField name = new JTextField();
        JTextField age = new JTextField();
        JTextField disease = new JTextField();
        JTextField phone_number = new JTextField();
        JTextField guardian = new JTextField();
        JTextField uname = new JTextField();
        JPasswordField pwd = new JPasswordField();
        JButton jButton2 = new JButton("UPDATE");

        jLabel1.setBounds(10, 10, 150, 20);
        jLabel2.setBounds(10, 40, 100, 20);
        jLabel3.setBounds(10, 70, 100, 20);
        jLabel4.setBounds(10, 100, 100, 20);
        jLabel6.setBounds(10, 130, 100, 20);
        jLabel7.setBounds(10, 160, 100, 20);
        jLabel8.setBounds(10, 190, 100, 20);
        jLabel9.setBounds(10, 220, 100, 20);
        jLabel10.setBounds(10, 250, 100, 20);

        adm.setBounds(120, 40, 150, 20);
        jButton1.setBounds(280, 40, 90, 20);
        name.setBounds(120, 70, 150, 20);
        age.setBounds(120, 100, 150, 20);
        disease.setBounds(120, 130, 150, 20);
        phone_number.setBounds(120, 160, 150, 20);
        guardian.setBounds(120, 190, 150, 20);
        uname.setBounds(120, 220, 150, 20);
        pwd.setBounds(120, 250, 150, 20);
        jButton2.setBounds(120, 280, 90, 20);

        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        add(jLabel1);
        add(jLabel2);
        add(jLabel3);
        add(adm);
        add(jButton1);
        add(jLabel4);
        add(jLabel6);
        add(jLabel7);
        add(jLabel8);
        add(jLabel9);
        add(jLabel10);
        add(name);
        add(age);
        add(disease);
        add(phone_number);
        add(guardian);
        add(uname);
        add(pwd);
        add(jButton2);
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        String userName = adm.getText();
        try{
            Connection con = Connectiondb.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM  WHERE patient uname=?");
            ps.setString(1, userName);
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
                adm.setEditable(false);
                name.setText(rs.getString("name1"));
                age.setText(rs.getString("age1"));
                disease.setText(rs.getString("disease"));
                guardian.setText(rs.getString("guardian"));
                phone_number.setText(rs.getString("phone_number"));
                uname.setText(rs.getString("uname"));
                pwd.setText(rs.getString("pwd"));
            } else {
            JOptionPane.showMessageDialog(null, "Invalid User Name !!");
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
    }
}

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        // Your update button action code
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Updatepatient().setVisible(true);
            }
        });
    }
    private javax.swing.JTextField adm;
    private javax.swing.JTextField age;
    private javax.swing.JTextField disease;
    
    private javax.swing.JTextField guardian;
    private javax.swing.JTextField name;
    private javax.swing.JTextField phone_number;
    private javax.swing.JPasswordField pwd;
    private javax.swing.JTextField uname;
}
