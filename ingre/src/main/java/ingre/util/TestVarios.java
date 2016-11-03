package ingre.util;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ingre.dao.DepartmentDao;
import ingre.dao.UserDao;
import ingre.model.Department;
import ingre.model.User;

public class TestVarios {
	UserDao daouser = new UserDao();
	DepartmentDao daodep = new DepartmentDao();
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		User user = daouser.getAll().get(0);
		Department dep = daodep.getAll().get(0);
		user.setDepartment(dep);
		user.setActive(true);
		daouser.update(user);
		assertTrue(true);
	}

}
