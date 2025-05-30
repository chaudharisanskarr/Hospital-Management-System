package jan1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Viewappoint extends JFrame {

    private JTable jTable1;

    public Viewappoint() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Appointment Information");
        setLayout(null); // Use null layout to specify absolute positioning

        JScrollPane jScrollPane1 = new JScrollPane();
        jScrollPane1.setBounds(10, 10, 600, 300); // Set the bounds for the scroll pane

        jTable1 = new JTable(new DefaultTableModel(
            new Object[][]{},
            new String[]{
                "name", "doctor name", "age", "date"
            }
        ) {
            boolean[] canEdit = new boolean[]{
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        jTable1.setBounds(10, 10, 600, 300); // Set the bounds for the table within the scroll pane

        setLocationRelativeTo(null); // Center the frame
        add(jScrollPane1);

        populateTable();
    }

    private void populateTable() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        try {
            Connection con = Connectiondb.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM appointment");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String name = rs.getString("name");
                String dname = rs.getString("dname");
                String age = rs.getString("page");
                String date = rs.getString("date");
                Object ob[] = {name, dname, age, date};
                model.addRow(ob);
            }

            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Viewappoint viewappo = new Viewappoint();
                viewappo.setSize(630, 350); // Set the frame size
                viewappo.setLocationRelativeTo(null); // Center the frame on the screen
                viewappo.setVisible(true);
            }
        });
    }
}
