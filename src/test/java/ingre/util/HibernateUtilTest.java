package ingre.util;

import static org.junit.Assert.*;

import org.junit.Test;
import ingre.util.HibernateUtil;

public class HibernateUtilTest {
	@Test
	public void testGetSessionFactory() {
		assertEquals(HibernateUtil.getSessionFactory()!=null,true);
	}
	@Test
	public void testOpenSession() {
		assertEquals(HibernateUtil.getSessionFactory().openSession()!=null,true);
	}
	
}
