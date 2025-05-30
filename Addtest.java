package jan1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class Addtest extends javax.swing.JFrame {
    public Addtest() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        buttonGroup1 = new javax.swing.ButtonGroup();
        setLayout(null); // Use null layout to specify absolute positioning

        jLabel1 = new javax.swing.JLabel("ADD NEW TEST");
        jLabel2 = new javax.swing.JLabel("TEST NAME");
        jLabel3 = new javax.swing.JLabel("TEST FEES");
        jLabel4 = new javax.swing.JLabel("DESCRIPTION");
        DOCTOR = new javax.swing.JLabel("DOCTOR");
        jButton1 = new javax.swing.JButton("SAVE");
        jButton2 = new javax.swing.JButton("CLEAR");
        name1 = new javax.swing.JTextField();
        fees = new javax.swing.JTextField();
        description = new javax.swing.JTextField();
        doct = new javax.swing.JTextField();


        jLabel1.setBounds(10, 10, 150, 20);
        jLabel2.setBounds(10, 40, 100, 20);
        name1.setBounds(120, 40, 150, 20);
        jLabel3.setBounds(10, 70, 100, 20);
        fees.setBounds(120, 70, 150, 20);
        jLabel4.setBounds(10, 100, 100, 20);
        description.setBounds(120, 100, 150, 20);
        DOCTOR.setBounds(10, 130, 100, 20);
        doct.setBounds(120, 130, 150, 20);
        jButton1.setBounds(10, 160, 80, 30);
        jButton2.setBounds(100, 160, 80, 30);

        add(jButton1);
        add(jButton2);
        add(jLabel1);
        add(jLabel2);
        add(jLabel3);
        add(name1);
        add(fees);
        add(doct);
        add(DOCTOR);
        add(description);
        add(jLabel4);

        setSize(320, 300);
        setLocationRelativeTo(null); // Center the frame
        setResizable(false);

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
            PreparedStatement ps = con.prepareStatement("insert into test(name1, fees, description, doct) values(?,?,?,?)");
            ps.setString(1, name1.getText());
            ps.setString(2, fees.getText());
            ps.setString(3, description.getText());
            ps.setString(4, doct.getText());

            int x = ps.executeUpdate();
            if (x > 0) {
                JOptionPane.showMessageDialog(null, "TEST Added");
                // You might want to handle frame navigation correctly here.
                Addtest ad = new Addtest();
                ad.setVisible(true);
                this.dispose();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        name1.setText(" ");
        fees.setText(" ");
        description.setText(" ");
        doct.setText(" ");
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Addtest().setVisible(true);
            }
        });
    }

    private javax.swing.JLabel DOCTOR;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField description;
    private javax.swing.JTextField doct;
    private javax.swing.JTextField fees;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField name1;
}
