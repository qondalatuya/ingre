package ingre.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ingre.dao.SpringDao;
import ingre.model.AnEntity;

public class SpringTest {

	public static void main(String[] args) {
		 ApplicationContext context = new ClassPathXmlApplicationContext("spring.beans.xml");
		 SpringDao dao = (SpringDao) context.getBean("springDao");
		 dao.save(new AnEntity("Red hot chilli peppers"));
		 
	}

}
