package jan1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class Addpatient extends javax.swing.JFrame {
    public Addpatient() {
        initComponents();
    }

    private void initComponents() {
        setLayout(null); // Use null layout to specify absolute positioning

        jLabel1 = new javax.swing.JLabel("ADD NEW PATIENT");
        jLabel2 = new javax.swing.JLabel("NAME");
        jLabel3 = new javax.swing.JLabel("AGE");
        jLabel4 = new javax.swing.JLabel("DISEASE");
        jLabel5 = new javax.swing.JLabel("PHONE NUMBER");
        jLabel6 = new javax.swing.JLabel("GUARDIAN");
        name1 = new javax.swing.JTextField();
        age1 = new javax.swing.JTextField();
        disease = new javax.swing.JTextField();
        phone_number = new javax.swing.JTextField();
        guardian = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton("SUBMIT");
        jButton2 = new javax.swing.JButton("CLEAR");
        jLabel7 = new javax.swing.JLabel("uname");
        jLabel8 = new javax.swing.JLabel("password");
        uname = new javax.swing.JTextField();
        pwd = new javax.swing.JTextField();

        setSize(320, 340);
        setLocationRelativeTo(null); // Center the frame
        setResizable(false);

        jLabel1.setBounds(10, 10, 150, 20);
        jLabel2.setBounds(10, 40, 100, 20);
        name1.setBounds(120, 40, 150, 20);
        jLabel3.setBounds(10, 70, 100, 20);
        age1.setBounds(120, 70, 150, 20);
        jLabel4.setBounds(10, 100, 100, 20);
        disease.setBounds(120, 100, 150, 20);
        jLabel5.setBounds(10, 130, 100, 20);
        phone_number.setBounds(120, 130, 150, 20);
        jLabel6.setBounds(10, 160, 100, 20);
        guardian.setBounds(120, 160, 150, 20);
        jLabel7.setBounds(10, 190, 100, 20);
        uname.setBounds(120, 190, 150, 20);
        jLabel8.setBounds(10, 220, 100, 20);
        pwd.setBounds(120, 220, 150, 20);
        jButton1.setBounds(10, 250, 80, 30);
        jButton2.setBounds(100, 250, 80, 30);
        add(jLabel1);
        add(jLabel2);
        add(jLabel3);
        add(jLabel4);
        add(jLabel5);
        add(jLabel6);
        add(jLabel7);
        add(jLabel8);
        add(name1);
        add(age1);
        add(uname);
        add(pwd);
        add(guardian);
        add(disease);
        add(jButton1);
        add(jButton2);
        add(phone_number);
      
       

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
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            Connection con = Connectiondb.getConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO patient (name1, age1, disease, phone_number, guardian, uname, pwd) VALUES (?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, name1.getText());
            ps.setString(2, age1.getText());
            ps.setString(3, disease.getText());
            ps.setString(4, phone_number.getText());
            ps.setString(5, guardian.getText());
            ps.setString(6, uname.getText());
            ps.setString(7, pwd.getText());

            int x = ps.executeUpdate();
            if (x > 0) {
                JOptionPane.showMessageDialog(null, "Patient Added");
                name1.setText("");
                age1.setText("");
                disease.setText("");
                phone_number.setText("");
                guardian.setText("");
                uname.setText("");
                pwd.setText("");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        name1.setText("");
        age1.setText("");
        disease.setText("");
        phone_number.setText("");
        guardian.setText("");
        uname.setText("");
        pwd.setText("");
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(Addpatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Addpatient().setVisible(true);
            }
        });
    }

    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField name1;
    private javax.swing.JTextField age1;
    private javax.swing.JTextField disease;
    private javax.swing.JTextField phone_number;
    private javax.swing.JTextField guardian;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JTextField uname;
    private javax.swing.JTextField pwd;
}
