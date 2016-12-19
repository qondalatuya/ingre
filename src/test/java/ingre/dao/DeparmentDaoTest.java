package ingre.dao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ingre.dao.DepartmentDao;
import ingre.model.Department;

public class DeparmentDaoTest {
	DepartmentDao dao = new DepartmentDao();
	Department dep=new Department();
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInsert() {
		dep.setName("departamento de prueba");
		dao.save(dep);
		assertTrue(true);
	}

}
