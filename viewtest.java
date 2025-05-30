package jan1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class viewtest extends JFrame {

    private JTable jTable1;

    public viewtest() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Test Information");
        setLayout(null); // Use null layout to specify absolute positioning

        JScrollPane jScrollPane1 = new JScrollPane();
        jScrollPane1.setBounds(10, 10, 600, 300); // Set the bounds for the scroll pane

        jTable1 = new JTable(new DefaultTableModel(
            new Object[][]{},
            new String[]{
                "name", "fees", "description", "doct"
            }
        ) {
            boolean[] canEdit = new boolean[]{
                false, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        jTable1.setBounds(10, 10, 600, 300); // Set the bounds for the table within the scroll pane

        add(jScrollPane1);

        populateTable();
    }

    private void populateTable() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        try {
            Connection con = Connectiondb.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM test");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String name = rs.getString("name1");
                String fees = rs.getString("fees");
                String description = rs.getString("description");
                String doct = rs.getString("doct");
                Object ob[] = {name, fees, description, doct};
                model.addRow(ob);
            }

            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                viewtest viewt = new viewtest();
                viewt.setSize(630, 350); // Set the frame size
                viewt.setLocationRelativeTo(null); // Center the frame on the screen
                viewt.setVisible(true);
            }
        });
    }
}
