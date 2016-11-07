package ingre.view.deps;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import ingre.dao.DepartmentDao;
import ingre.model.Department;

public class DepsManage extends JFrame{
	private static final long serialVersionUID = 2465363188216532877L;
	private DepartmentDao daoDep = new DepartmentDao();
	private JPanel newDepPanel,depsPanel;
	

	public static void main (String[] args){
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new DepsManage().setVisible(true);
			}
		}); 
	}
	
	public DepsManage(){
		createLeftPanel();
		init();
	}
	
	private void init(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.add(newDepPanel,BorderLayout.WEST);

		this.pack();
	}
	
	private void createLeftPanel(){
		newDepPanel = new JPanel();
		newDepPanel.setLayout(new BoxLayout(newDepPanel, BoxLayout.Y_AXIS));
		DepEditPanel panelDep = new DepEditPanel();
		newDepPanel.add(panelDep);
		
		JButton addDepButton = new JButton("Agregar Departamento");
		addDepButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Department newDep = new Department();
				newDep.setName(panelDep.getDepName());
				newDep.setBoss(panelDep.getSelectedBoss());
				daoDep.save(newDep);
				
			}
		});
		
		newDepPanel.add(addDepButton);
	}
	
	
}
