package jan1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.*;

public class Appointment extends javax.swing.JFrame{
	
	JLabel nameLabel,dnameLabel,ageLabel;
	JButton submitButton;
	
	Appointment() {
		  setBounds(0,0, 800, 500);
	        getContentPane().setLayout(null);
        
	        nameLabel = new JLabel("Patient's Name");
	        nameLabel.setBounds(10, 40, 100, 20);
	        add(nameLabel);

	        name = new JTextField();
	        name.setBounds(120, 40, 150, 20);
	        add(name);
	        
	        dnameLabel = new JLabel("Doctor's Name");
	        dnameLabel.setBounds(10, 70, 100, 20);
	        add(dnameLabel);

	        dname = new JTextField();
	        dname.setBounds(120, 70, 150, 20);
	        add(dname);

	        ageLabel = new JLabel("Age");
	        ageLabel.setBounds(10, 100, 100, 20);
	        add(ageLabel);

	        age = new JTextField();
	        age.setBounds(120, 100, 150, 20);
	        add(age);

	        JLabel text = new JLabel("We will text you the timings of the appointment as soon as possible");
	        text.setBounds(10, 130, 400, 20);
	        getContentPane().add(text);
	        
        jLabel6 = new javax.swing.JLabel("We will text you the timings of the appointment as soon as possible");
        submitButton = new JButton("Submit");
        submitButton.setBounds(10, 220, 100, 25);
        add(submitButton);
    
        setSize(500, 300);
        setLocationRelativeTo(null); // Center the frame
        setResizable(false);
        setTitle("Appointment");
    
        
        submitButton.setBounds(10, 160, 80, 30);
    
        
    
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            Connection con = Connectiondb.getConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO appointment(name, dname, page, date) VALUES(?, ?, ?, ?)");
            ps.setString(1, name.getText());
            ps.setString(2, dname.getText());
            ps.setString(3, age.getText());

            Date d = new Date();
            SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
            String dd = sd.format(d);
            ps.setString(4, dd);

            int x = ps.executeUpdate();
            if (x > 0) {
                JOptionPane.showMessageDialog(null, "Appointment Processed");
                this.dispose(); // Close the current window after processing
            } else {
                JOptionPane.showMessageDialog(null, "Failed to process the appointment.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        

        java.awt.EventQueue.invokeLater(() -> {
            new Appointment().setVisible(true);
        });
    }

    private javax.swing.JTextField dname;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField name;
    private javax.swing.JTextField age;
    private javax.swing.JButton jButton1;
}