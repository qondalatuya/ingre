package ingre.view.deps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

import ingre.dao.DepartmentDao;
import ingre.model.Department;

/*
 * Dialogo para modificar un departamento cargado previamente.
 */

public class DepEdit extends JDialog {
	private static final long serialVersionUID = 2780792692149409368L;
	private JPanel panel = new JPanel();
	private DepEditPanel depEditPanel;
	
	public DepEdit(Department dep){			
		depEditPanel= new DepEditPanel(dep);
		
		JButton savebtn = new JButton("Guardar");
		savebtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dep.setName(depEditPanel.getDepName());
				dep.setBoss(depEditPanel.getSelectedBoss());
				new DepartmentDao().update(dep);
				dispose();
			}			
		});
		
		panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
		this.add(panel);
		
		panel.add(depEditPanel);
		panel.add(savebtn);
				
		this.setModal(true);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.pack();
	}

}
