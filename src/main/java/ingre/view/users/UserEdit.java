package ingre.view.users;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

import ingre.model.User;

/*
 * Dialogo para modificar el usuario cargado previamente.recibe como parámetro un objeto "User" y despliega el dialogo para modificar sus datos.
 * Las modificaciones se hacen sobre el parámetro. NO ACTUALIZA LA BD
 * 
 */

public class UserEdit extends JDialog {
	private static final long serialVersionUID = 4852407853975781816L;
	private JPanel panel = new JPanel();
	private UserEditPanel userEditPanel;
	
	public UserEdit(User user){			
		userEditPanel= new UserEditPanel(user);
		
		JButton savebtn = new JButton("Guardar");
		savebtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				user.setRealName(userEditPanel.getRealName());
				user.setUserName(userEditPanel.getUserName());
				user.setDepartment(userEditPanel.getDepartment());
				user.setActive(userEditPanel.isActiveUser());
				dispose();
			}			
		});
		
		panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
		this.add(panel);
		
		panel.add(userEditPanel);
		panel.add(savebtn);
				
		this.setModal(true);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.pack();
	}
}
