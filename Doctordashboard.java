package jan1;


import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Image;
import java.awt.Dimension;

public class Doctordashboard extends javax.swing.JFrame {
    
    public Doctordashboard() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
                          //   setBounds(0, 0, 800, 500);
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        JLabel imageLabel = new JLabel();
        ImageIcon imageIcon = new ImageIcon("jan1/carewell_collage.jpg"); // Specify your image file path
        Image originalImage = imageIcon.getImage();
        int newWidth = (int)(originalImage.getWidth(null) * 0.29); 
        int newHeight = (int)(originalImage.getHeight(null) * 0.25); 
        Image scaledImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(scaledImage);
        imageLabel.setIcon(imageIcon);
        add(imageLabel);

        // Set the position and size of the image label
        imageLabel.setBounds(0, 0, newWidth, newHeight); // Use the new dimensions

        setBounds(0, 0, newWidth, newHeight);
        setLocationRelativeTo(null); // Center the frame
        setResizable(false);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        jLabel1.setText("WELCOME DOCTOR");
        jMenu1.setText("File");
        
        jMenuItem1.setText("View Test");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);
        
        jMenuItem2.setText("Add Test");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);
        
        jMenuItem3.setText("View Patients");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);
        
        jMenuItem4.setText("Add Patient");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);
        
        jMenuItem5.setText("Update Patient");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuItem6.setText("View appointment");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem6);

        jMenuItem7.setText("Log Out");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem7);
    
        
        jMenuBar1.add(jMenu1);
        setJMenuBar(jMenuBar1);

        setLayout(null);
    }

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        //new viewtest().setVisible(true);
        viewtest viewt = new viewtest();
        viewt.setSize(630, 350); // Set the frame size
        viewt.setLocationRelativeTo(null); // Center the frame on the screen
        viewt.setVisible(true); // Assuming "Viewtest" is a valid class
    }                                          
    
    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        Viewpatient views = new Viewpatient();
                views.setSize(630, 350); // Set the frame size
                views.setLocationRelativeTo(null); // Center the frame on the screen
                views.setVisible(true);
    }                                          
    
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        new Addtest().setVisible(true);
    }                                          
    
    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        new Addpatient().setVisible(true);
    }                                          
    
    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        new Updatepatient().setVisible(true);
    }

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        Viewappoint viewappo = new Viewappoint();
                viewappo.setSize(630, 350); // Set the frame size
                viewappo.setLocationRelativeTo(null); // Center the frame on the screen
                viewappo.setVisible(true);
    }

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        HospitalManagementSystem hms = new HospitalManagementSystem();
        hms.setVisible(true);
        this.dispose();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Doctordashboard().setVisible(true);
            }
        });
    }

    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
}
