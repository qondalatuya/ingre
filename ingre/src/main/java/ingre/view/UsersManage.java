package ingre.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import ingre.dao.UserDao;
import ingre.model.User;

public class UsersManage extends JFrame {
	private static final long serialVersionUID = -4897244397400980940L;
	JTable table;
	DefaultTableModel model;
	List<User> users;
	JPanel newUserPanel;
	JScrollPane usersPanel;
	JButton savebtn;
	JLabel userNameLabel,realNameLabel;
	JTextField userNameField,realNameField;
	UserDao dao = new UserDao();
	
	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable() {			
			@Override
			public void run() {
				UsersManage window = new UsersManage();
				window.setVisible(true);				
			}
		});
	}
	
	public UsersManage(){
		this.constructLeftPanel();
		this.constructCenterPanel();
		this.init();
	}
	
	public void constructLeftPanel(){
		newUserPanel = new JPanel();
		
		userNameLabel = new JLabel("Usuario");
		realNameLabel = new JLabel("Nombre");
		userNameField = new JTextField();
		realNameField = new JTextField();
		userNameField.setPreferredSize(new Dimension(120, 24));
		realNameField.setPreferredSize(new Dimension(120, 24));
		
		savebtn = new JButton("Guardar");
		savebtn.addActionListener( new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
//				User newUser = new User(userNameField.getText(), realNameField.getText());
				User newUser = new User();
				newUser.setUserName(userNameField.getText());
				newUser.setRealName(realNameField.getText());
				dao.save(newUser);
				
				fillTable();
			}
		});
		
		newUserPanel.add(userNameLabel);
		newUserPanel.add(userNameField);
		newUserPanel.add(realNameLabel);
		newUserPanel.add(realNameField);
		newUserPanel.add(savebtn);
		getRootPane().setDefaultButton(savebtn);//agrega el boton como "enter por defecto" para el Jframe. Al presionar la tecla se invoca al actionPermormed del Jbutton		
		
	}
	
	public void constructCenterPanel(){
		usersPanel = new JScrollPane();
		model = new DefaultTableModel()
			{
			private static final long serialVersionUID = -3215825960888712484L;
			@Override
			public boolean isCellEditable(int fila, int columna){
				return false;
			}
		};
		table = new JTable(model);
		table.setRowSorter( new TableRowSorter<DefaultTableModel>(model));//Le decimos que la tabla se pueda ordenar (Haciendo clic en las columnas)
		model.addColumn("Nombre usuario");
		model.addColumn("Nombre real");
		model.addColumn("Usuario Activo");
		this.fillTable();
		
	}
	
	public void init(){
		this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
		this.setTitle("Administración de Usuarios");
		this.add(usersPanel,BorderLayout.CENTER);
		this.add(newUserPanel, BorderLayout.WEST);
		this.pack();
        this.setVisible(true);
		
	
	}
	
	public void fillTable(){
		try{					
			model.setRowCount(0);
			users= dao.getAll();
			for (User user:users){
				Object[] o = {user.getUserName(),user.getRealName(),user.isActive()}; 
				model.addRow(o);
				usersPanel.setViewportView(table);
			}
			table.updateUI();
		}
		catch (Exception e) {
			e.toString();
		}
	}
	
}
