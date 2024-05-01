import javax.swing.WindowConstants;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.LayoutManager;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;

public class mainFrame extends JFrame {
    private JPanel contentPane;
    private JTextField tfFName;
    private JTextField tfLName;
    private JTextField tfID;
    private JTextField tfEmail;
    private JTextField tfContact;
    private JTable table;

    //MAIN FUNCTION
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    mainFrame frame = new mainFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    //MAINFRAME FUNCTION
    public mainFrame() {
        setTitle("Database");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 862, 568);


        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(this.contentPane);
        contentPane.setLayout((LayoutManager)null);

        JPanel pInput = new JPanel();
        pInput.setBorder(new LineBorder(new Color(0, 0, 0)));
        pInput.setBounds(0, 0, 848, 108);
        contentPane.add(pInput);
        pInput.setLayout((LayoutManager)null);

        JButton btnAdd = new JButton("Add Member");
        btnAdd.setBounds(712, 28, 115, 21);
        pInput.add(btnAdd);

        JButton btnSave = new JButton("Save Member");
        btnSave.setBounds(712, 59, 115, 21);
        pInput.add(btnSave);

        JPanel panel = new JPanel();
        panel.setBounds(20, 11, 672, 84);
        pInput.add(panel);
        panel.setBorder(new TitledBorder(new TitledBorder(new EtchedBorder(1, new Color(255, 255, 255), new Color(160, 160, 160)), "Member Information", 4, 2, (Font)null, new Color(0, 0, 0)), "", 4, 2, (Font)null, (Color)null));
        panel.setLayout((LayoutManager)null);
        JLabel lblNewLabel_2 = new JLabel("Member ID");
        lblNewLabel_2.setBounds(10, 26, 66, 13);
        panel.add(lblNewLabel_2);
        JLabel lblNewLabel_3 = new JLabel("Email Address");
        lblNewLabel_3.setBounds(10, 56, 89, 13);
        panel.add(lblNewLabel_3);
        tfID = new JTextField();
        tfID.setBounds(86, 23, 115, 19);
        panel.add(this.tfID);
        tfID.setColumns(10);
        tfEmail = new JTextField();
        tfEmail.setBounds(104, 53, 145, 19);
        panel.add(tfEmail);
        tfEmail.setColumns(10);
        JLabel lblNewLabel = new JLabel("First Name");
        lblNewLabel.setBounds(219, 26, 66, 13);
        panel.add(lblNewLabel);
        JLabel lblNewLabel_4 = new JLabel("Contact");
        lblNewLabel_4.setBounds(274, 56, 45, 13);
        panel.add(lblNewLabel_4);
        tfContact = new JTextField();
        tfContact.setBounds(329, 53, 136, 19);
        panel.add(tfContact);
        tfContact.setColumns(10);
        tfFName = new JTextField();
        tfFName.setBounds(295, 23, 136, 19);
        panel.add(tfFName);
        tfFName.setColumns(10);
        JLabel lblNewLabel_1 = new JLabel("Last Name");
        lblNewLabel_1.setBounds(452, 26, 66, 13);
        panel.add(lblNewLabel_1);
        tfLName = new JTextField();
        tfLName.setBounds(518, 23, 136, 19);
        panel.add(tfLName);
        tfLName.setColumns(10);

        JPanel pTable = new JPanel();
        pTable.setBackground(Color.PINK);
        pTable.setBorder((Border)null);
        pTable.setBounds(10, 118, 828, 403);
        contentPane.add(pTable);
        pTable.setLayout((LayoutManager)null);
        JButton btnDelete = new JButton("Delete");

        btnDelete.setBounds(730, 372, 88, 21);
        pTable.add(btnDelete);

        JButton btnEdit = new JButton("Edit");
        btnEdit.setBounds(632, 372, 88, 21);

        pTable.add(btnEdit);
        String[] columnNames = new String[]{"ID", "First Name", "Last Name", "Email", "Contact"};
        table = new JTable(new DefaultTableModel(columnNames, 0));
        table.setDefaultEditor(Object.class, (TableCellEditor)null);
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 10, 808, 350);
        scrollPane.setViewportView(table);
        table.setBorder(new LineBorder(new Color(0, 0, 0)));
        pTable.add(scrollPane);
   }

}