package ingre.dao;

import ingre.model.Department;

public class DepartmentDao extends Dao<Department, Integer> {
	
	public DepartmentDao(){
		super (Department.class);
	}
}
