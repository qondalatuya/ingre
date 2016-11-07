package ingre.view.deps;

import java.awt.Dimension;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ingre.dao.UserDao;
import ingre.model.User;

public class DepEditPanel extends JPanel{
	private static final long serialVersionUID = -8122379291501577599L;
	private JLabel nameLabel,bossLabel;
	private JTextField nameField;
	private JComboBox<User> bossComboBox;
	private UserDao daoUser = new UserDao();
	private List<User> users;  
	
	public DepEditPanel(){
		init();
	}
	
	public void init(){
		users = daoUser.getAll();
		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		layout.setAutoCreateGaps(true);
		
		nameLabel = new JLabel("Departamento");
		bossLabel = new JLabel("Jefe de Departamento");
		nameField = new JTextField();
		bossComboBox = new JComboBox<>();
		
		nameLabel.setPreferredSize(new Dimension(120, 24));
		bossLabel.setPreferredSize(new Dimension(120, 24));
		nameField.setPreferredSize(new Dimension(120, 24));
		bossComboBox.setPreferredSize(new Dimension(120, 24));
		
		
		
		for (User u : users){
			bossComboBox.addItem(u);
		}
		
		layout.setHorizontalGroup(
				layout.createSequentialGroup()
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
							.addComponent(nameLabel)
							.addComponent(bossLabel)
					)
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
							.addComponent(nameField)
							.addComponent(bossComboBox)
					)
		);
		
		layout.setVerticalGroup(
				layout.createSequentialGroup()
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
							.addComponent(nameField)
							.addComponent(nameLabel)
					)
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
							.addComponent(bossLabel)
							.addComponent(bossComboBox))
		);
		
		
		
	}
	
	public String getDepName(){
		return nameField.getText();
	}
	
	public User getSelectedBoss(){
		return (User) bossComboBox.getSelectedItem();
	}
	
}
