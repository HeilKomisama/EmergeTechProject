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
    //component instances
    private JPanel contentPane;
    private JPanel pInput;
    private JButton btnCreate;
    private JButton btnUpdate;
    private JButton btnEdit;
    private JButton btnDelete;
    private JTextField tfFName;
    private JTextField tfLName;
    private JTextField tfEmail;
    private JTextField tfID;
    private JTextField tfDept;
    private JTextField tfContact;
    private JTable table;

    //main function
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

    //main frame function
    public mainFrame() {
        setTitle("Database");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 900, 568);

        //main panel
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout((LayoutManager)null);

        //input panel
        pInput = new JPanel();
        pInput.setBorder(new LineBorder(new Color(0, 0, 0)));
        pInput.setBounds(0, 0, 885, 108);
        contentPane.add(pInput);
        pInput.setLayout((LayoutManager)null);

        //create button
        btnCreate = new JButton("Create Member");
        btnCreate.setBounds(740, 28, 125, 21);
        pInput.add(btnCreate);

        //update button
        btnUpdate = new JButton("Update Member");
        btnUpdate.setBounds(740, 59, 125, 21);
        pInput.add(btnUpdate);

        //member info panel
        JPanel panel = new JPanel();
        panel.setBounds(20, 11, 705, 84);
        pInput.add(panel);
        panel.setBorder(new TitledBorder(new TitledBorder(new EtchedBorder(1, new Color(255, 255, 255), new Color(160, 160, 160)), "Member Information", 4, 2, (Font)null, new Color(0, 0, 0)), "", 4, 2, (Font)null, (Color)null));
        panel.setLayout((LayoutManager)null);

        //label and textfield for first name
        JLabel lblNewLabel_2 = new JLabel("First Name");
        lblNewLabel_2.setBounds(10, 26, 66, 13);
        panel.add(lblNewLabel_2);
        tfFName = new JTextField();
        tfFName.setBounds(80, 23, 115, 19);
        panel.add(tfFName);
        tfFName.setColumns(10);

        //label and textfield for last name
        JLabel lblNewLabel = new JLabel("Last Name");
        lblNewLabel.setBounds(210, 26, 66, 13);
        panel.add(lblNewLabel);
        tfLName = new JTextField();
        tfLName.setBounds(280, 23, 136, 19);
        panel.add(tfLName);
        tfLName.setColumns(10);

        //label and textfield for email address
        JLabel lblNewLabel_1 = new JLabel("Email");
        lblNewLabel_1.setBounds(430, 26, 66, 13);
        panel.add(lblNewLabel_1);
        tfEmail = new JTextField();
        tfEmail.setBounds(475, 23, 136, 19);
        panel.add(tfEmail);
        tfEmail.setColumns(10);

        //label and textfield for employee id
        JLabel lblNewLabel_3 = new JLabel("Employee ID");
        lblNewLabel_3.setBounds(10, 56, 89, 13);
        panel.add(lblNewLabel_3);
        tfID = new JTextField();
        tfID.setBounds(90, 53, 145, 19);
        panel.add(tfID);
        tfID.setColumns(10);

        //label and textfield for department
        JLabel lblNewLabel_4 = new JLabel("Department");
        lblNewLabel_4.setBounds(250, 56, 70, 13);
        panel.add(lblNewLabel_4);
        tfDept = new JTextField();
        tfDept.setBounds(330, 53, 136, 19);
        panel.add(tfDept);
        tfDept.setColumns(10);

        //label and textfield for contact num
        JLabel lblNewLabel_5 = new JLabel("Contact No.");
        lblNewLabel_5.setBounds(480, 56, 120, 13);
        panel.add(lblNewLabel_5);
        tfContact = new JTextField();
        tfContact.setBounds(560, 53, 136, 19);
        panel.add(tfContact);
        tfContact.setColumns(10);

        //table panel
        JPanel pTable = new JPanel();
        pTable.setBorder((Border)null);
        pTable.setBounds(10, 118, 860, 403);
        contentPane.add(pTable);
        pTable.setLayout((LayoutManager)null);

        //edit button
        btnEdit = new JButton("Edit Member");
        btnEdit.setBounds(575, 372, 125, 21);
        pTable.add(btnEdit);

        //delete button
        btnDelete = new JButton("Delete member");
        btnDelete.setBounds(720, 372, 125, 21);
        pTable.add(btnDelete);

        //table of records
        String[] columnNames = new String[]{"ID", "First Name", "Last Name", "Email", "Contact No.", "Department"};
        table = new JTable(new DefaultTableModel(columnNames, 0));
        table.setDefaultEditor(Object.class, (TableCellEditor)null);
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 10, 848, 350);
        scrollPane.setViewportView(table);
        table.setBorder(new LineBorder(new Color(0, 0, 0)));
        pTable.add(scrollPane);
   }

}