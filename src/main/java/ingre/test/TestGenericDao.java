package ingre.test;

import static org.junit.Assert.*;
import org.junit.Test;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;

import ingre.dao.UserDao;
import ingre.model.User;
import ingre.util.HibernateUtil;


public class TestGenericDao {
	Session session;
	User user = new User();
	UserDao dao = new UserDao();
	
	@Before
	public void setUp() throws Exception {

	}

	@After
	public void tearDown() throws Exception {
		user.setUserName("PRUEBA");
		dao.delete(user);
	}

	@Test
	public void test() {
		session= HibernateUtil.getSessionFactory().getCurrentSession();
		
		assertTrue(session.isOpen());
	}
	
	
	@Test
	public void insertingdao(){
		user=dao.getById("PRUEBA");//LAS CLAVES de hibernate no distinguen mayusculas de minusculas??
		if (user==null){
			user=new User();
			user.setRealName("PRUEBA");
			user.setUserName("PRUEBA");
			dao.save(user);
		}
		System.out.println(user);
		assertTrue(user.getRealName().equals("PRUEBA"));
		System.out.println("bandeó"); //junit sigue ejecutando despues del assert
	}

}
