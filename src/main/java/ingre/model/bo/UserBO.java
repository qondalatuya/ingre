package ingre.model.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ingre.dao.UserDao;
import ingre.model.User;

@Service
public class UserBO {
	
	@Autowired
	UserDao dao;
	
	public List<User> getAll(){
		return dao.getAll();
	}
}
