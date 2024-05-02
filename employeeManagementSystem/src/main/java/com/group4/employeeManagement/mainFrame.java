package com.group4.employeeManagement;

import javax.swing.WindowConstants;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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

        btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tfID.getText().trim().isEmpty() || tfFName.getText().trim().isEmpty() || tfLName.getText().trim().isEmpty() || tfEmail.getText().trim().isEmpty() || tfContact.getText().trim().isEmpty()) {
					//error message
					JOptionPane.showMessageDialog(rootPane, "Please fill up the empty fields.", "Missing Information", JOptionPane.ERROR_MESSAGE);
				}
				else {
					int id = Integer.parseInt(tfID.getText());
					String firstName = tfFName.getText();
			        String lastName = tfLName.getText();
			        String email = tfEmail.getText();
			        String contact = tfContact.getText();
                    String department = tfDept.getText();
			        
			        EntityManagerFactory emf = Persistence.createEntityManagerFactory("employeeschema"); //specifying database name
					EntityManager em = emf.createEntityManager(); //manager to perform database operations
					EntityTransaction et = em.getTransaction();
					
					et.begin(); //begins the transaction
					
			        EmployeeEntity newMember = new EmployeeEntity(id, firstName, lastName, email, contact, department);

					em.persist(newMember);
					et.commit(); //commit the transaction
					em.close(); //close the manager
					emf.close(); //close the manager
			        
					//add created member to table
			        Object[] row = {id, firstName, lastName, email, contact, department};
			        DefaultTableModel model = (DefaultTableModel) table.getModel();
			        model.addRow(row);
			        
			        //remove input values in textfields
			        tfID.setText("");
			        tfFName.setText("");
			        tfFName.setText("");
			        tfEmail.setText("");
			        tfContact.setText("");
                    tfDept.setText("");
				}	
			}
		});
                btnUpdate.addActionListener((ActionEvent e) -> {
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow != -1) { // Check if a row is selected
                        if(tfID.getText().trim().isEmpty() || tfFName.getText().trim().isEmpty() || tfLName.getText().trim().isEmpty() || tfEmail.getText().trim().isEmpty() || tfContact.getText().trim().isEmpty() || tfDept.getText().trim().isEmpty()) {
                            //error message
                            JOptionPane.showMessageDialog(rootPane, "Please fill up the empty fields.", "Missing Information", JOptionPane.ERROR_MESSAGE);
                        }
                        else {
                            int id = Integer.parseInt(tfID.getText());
                            String firstName = tfFName.getText();
                            String lastName = tfLName.getText();
                            String email = tfEmail.getText();
                            String contact = tfContact.getText();
                            String department = tfDept.getText();
                            
                            DefaultTableModel model = (DefaultTableModel) table.getModel();
                            model.setValueAt(id, selectedRow, 0);
                            model.setValueAt(firstName, selectedRow, 1);
                            model.setValueAt(lastName, selectedRow, 2);
                            model.setValueAt(email, selectedRow, 3);
                            model.setValueAt(contact, selectedRow, 4);
                            model.setValueAt(department, selectedRow, 5);
                            
                            EntityManagerFactory emf = Persistence.createEntityManagerFactory("employeeschema"); //specifying database name
                            EntityManager em = emf.createEntityManager(); //manager to perform database operations
                            EntityTransaction et = em.getTransaction();
                            et.begin(); //begins the transaction
                            
                            EmployeeEntity editedMember = em.find(EmployeeEntity.class, id);
                            editedMember.setfName(firstName);
                            editedMember.setlName(lastName);
                            editedMember.setEmail(email);
                            editedMember.setContact(contact);
                            editedMember.setDepartment(department);
                            
                            et.commit(); //commit the transaction
                            em.close(); //close the manager
                            emf.close(); //close the manager
                        }
                    }
                    else {
                        //error message
                        JOptionPane.showMessageDialog(rootPane, "Please select a row and click on the edit button to save an edited record", "Error", JOptionPane.ERROR_MESSAGE);
                    }
        });
                btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();
		        if (selectedRow != -1) { // Check if a row is selected
		            int id = (int) table.getValueAt(selectedRow, 0);
		            String firstName = table.getValueAt(selectedRow, 1).toString();
		            String lastName = table.getValueAt(selectedRow, 2).toString();
		            String email = table.getValueAt(selectedRow, 3).toString();
		            String contact = table.getValueAt(selectedRow, 4).toString();
                    String department = table.getValueAt(selectedRow, 5).toString();

		            tfID.setText(Integer.toString(id));
		            tfFName.setText(firstName);
		            tfLName.setText(lastName);
		            tfEmail.setText(email);
		            tfContact.setText(contact);
                    tfDept.setText(department);
		        }
		        else {
		        	//error message
					JOptionPane.showMessageDialog(rootPane, "Select a row to edit.", "Error", JOptionPane.ERROR_MESSAGE);
		        }
			}
		});
                btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();
		        if (selectedRow != -1) { // Check if a row is selected
		            int idToDelete = (int) table.getValueAt(selectedRow, 0);

		            EntityManagerFactory emf = Persistence.createEntityManagerFactory("employeeschema"); //specifying database name
					EntityManager em = emf.createEntityManager(); //manager to perform database operations
					EntityTransaction et = em.getTransaction();
					et.begin(); //begins the transaction

		            EmployeeEntity memberToDelete = em.find(EmployeeEntity.class, idToDelete); //get id as reference
		            em.remove(memberToDelete); //remove record from the database
		            et.commit(); //commit the transaction
					em.close(); //close the manager
					emf.close(); //close the manager

		            DefaultTableModel model = (DefaultTableModel) table.getModel();
		            model.removeRow(selectedRow); // Remove the row from the table model
		        }
		        else {
		        	//error message
					JOptionPane.showMessageDialog(rootPane, "Select a row to delete.", "Error", JOptionPane.ERROR_MESSAGE);
		        }
			}
		});
   }

}
        
        
        
        

    
    
