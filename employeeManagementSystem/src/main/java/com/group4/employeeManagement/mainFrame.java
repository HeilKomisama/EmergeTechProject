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
        
        btnAdd.addActionListener(new ActionListener() {
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
			        
			        EntityManagerFactory emf = Persistence.createEntityManagerFactory("memberdata"); //specifying database name
					EntityManager em = emf.createEntityManager(); //manager to perform database operations
					EntityTransaction et = em.getTransaction();
					
					et.begin(); //begins the transaction
					
			        MemberEntity newMember = new MemberEntity(id, firstName, lastName, email, contact);

					em.persist(newMember);
					et.commit(); //commit the transaction
					em.close(); //close the manager
					emf.close(); //close the manager
			        
					//add created member to table
			        Object[] row = {id, firstName, lastName, email, contact};
			        DefaultTableModel model = (DefaultTableModel) table.getModel();
			        model.addRow(row);
			        
			        //remove input values in textfields
			        tfID.setText("");
			        tfFName.setText("");
			        tfFName.setText("");
			        tfEmail.setText("");
			        tfContact.setText("");
				}	
			}
		});
                btnSave.addActionListener((ActionEvent e) -> {
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow != -1) { // Check if a row is selected
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
                            
                            DefaultTableModel model = (DefaultTableModel) table.getModel();
                            model.setValueAt(id, selectedRow, 0);
                            model.setValueAt(firstName, selectedRow, 1);
                            model.setValueAt(lastName, selectedRow, 2);
                            model.setValueAt(email, selectedRow, 3);
                            model.setValueAt(contact, selectedRow, 4);
                            
                            EntityManagerFactory emf = Persistence.createEntityManagerFactory("memberdata"); //specifying database name
                            EntityManager em = emf.createEntityManager(); //manager to perform database operations
                            EntityTransaction et = em.getTransaction();
                            et.begin(); //begins the transaction
                            
                            MemberEntity editedMember = em.find(MemberEntity.class, id);
                            editedMember.setfName(firstName);
                            editedMember.setlName(lastName);
                            editedMember.setEmail(email);
                            editedMember.setContact(contact);
                            
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

		            tfID.setText(Integer.toString(id));
		            tfFName.setText(firstName);
		            tfLName.setText(lastName);
		            tfEmail.setText(email);
		            tfContact.setText(contact);
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

		            EntityManagerFactory emf = Persistence.createEntityManagerFactory("memberdata"); //specifying database name
					EntityManager em = emf.createEntityManager(); //manager to perform database operations
					EntityTransaction et = em.getTransaction();
					et.begin(); //begins the transaction

		            MemberEntity memberToDelete = em.find(MemberEntity.class, idToDelete); //get id as reference
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