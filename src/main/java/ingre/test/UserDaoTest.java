package ingre.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ingre.dao.DepartmentDao;
import ingre.dao.UserDao;
import ingre.model.Department;
import ingre.model.User;

public class UserDaoTest {
	User user1 = new User();
	User user2 = new User();
	UserDao dao = new UserDao();
	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetByID() {
		user1=dao.getById("Jaina");//es responsabilidad de la clase user pasar todo a minuscula
		user2 = dao.getById("Igor");
		Department dep = new DepartmentDao().getById(1);
		user1.setDepartment(dep);
		user2.setDepartment(dep);
		dao.update(user1);
		dao.update(user2);
		assertTrue(true);
	}
	
	@Test
	public void testForaneas(){
		
	}

}
