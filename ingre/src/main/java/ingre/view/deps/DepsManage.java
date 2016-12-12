package ingre.view.deps;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import ingre.dao.DepartmentDao;
import ingre.model.Department;

public class DepsManage extends JPanel{
	private static final long serialVersionUID = 3488348905286436149L;
	private DepartmentDao daoDep = new DepartmentDao();
	private JPanel newDepPanel,depsPanel;
	private JTable table;
	private DefaultTableModel model;
	private List<Department> deps;
	
	public DepsManage(){
		createLeftPanel();
		createCenterPanel();
		init();
	}
	
	private void init(){
		this.setLayout(new BorderLayout());
		this.add(newDepPanel,BorderLayout.WEST);
		this.add(depsPanel,BorderLayout.CENTER);
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
				fillTable();
				
			}
		});
		newDepPanel.add(addDepButton);
	}
	
	private void createCenterPanel(){
		depsPanel= new JPanel();
		depsPanel.setLayout(new BorderLayout());		
		
		model = new DefaultTableModel()
			{
			private static final long serialVersionUID = -8211011558141463467L;
			@Override
			public boolean isCellEditable(int fila, int columna){
				return false;//pareceria que se puede definir algun tipo de logica que returne V/F según si la celda de la tabla es editable o no.
			}// en este caso returna falso, para cualquier combinacion de fila/columna
		};
			
		model.addColumn("Departamento");
		model.addColumn("Jefe");
		
		table=new JTable(model);
		table.setRowSorter( new TableRowSorter<DefaultTableModel>(model));//Le decimos que la tabla se pueda ordenar (Haciendo clic en las columnas).
		
		JScrollPane tablePanel = new JScrollPane();
		tablePanel.setViewportView(table);
		this.fillTable();
		
		depsPanel.add(tablePanel,BorderLayout.CENTER);
		
		JButton editbtn= new JButton("Editar");
		editbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow()!=-1){
					DepEdit depEdit = new DepEdit(deps.get(table.getSelectedRow()));
					depEdit.setVisible(true);
					fillTable();
				}	
			}
		});
		JButton rembtn = new JButton("Eliminar");
		rembtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow()!=-1){
					daoDep.delete(deps.get(table.getSelectedRow()));
					fillTable();
				}
				
			}
		});
		
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.add(rembtn);
		buttonsPanel.add(editbtn);
		depsPanel.add(buttonsPanel,BorderLayout.SOUTH);				
	}
	
	protected void fillTable(){
		try{					
			model.setRowCount(0);
			deps = daoDep.getAll(); 
			for (Department dep:deps){
				Object[] o = {dep.getName(),dep.getBoss()}; 
				model.addRow(o);
			}
			table.updateUI();
		}
		catch (Exception e) {
			
		}
	}
}
