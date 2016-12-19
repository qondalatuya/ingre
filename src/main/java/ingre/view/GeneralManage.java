package ingre.view;


import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import ingre.view.deps.DepsManage;
import ingre.view.users.UsersManage;

public class GeneralManage extends JFrame {
	private static final long serialVersionUID = 2403686788652812408L;

	public static void main (String[] args){
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new GeneralManage().setVisible(true);				
			}
		});
	}
	
	public GeneralManage(){
		init();
	}
	
	protected void init(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Administración");
		JTabbedPane tabbedpane = new JTabbedPane();
		
		tabbedpane.addTab("Usuarios", new UsersManage());
		tabbedpane.addTab("Departamentos",new DepsManage());
				
		this.add(tabbedpane);
		this.pack();		
		
		tabbedpane.addChangeListener(new ChangeListener() {			
			@Override
			public void stateChanged(ChangeEvent e) {
				tabbedpane.setComponentAt(0, new UsersManage());
				tabbedpane.setComponentAt(1, new DepsManage());
			}
		}); 
	}
}
