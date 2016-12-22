package ingre.dao;

import org.springframework.stereotype.Repository;

import ingre.model.User;

@Repository
public class UserDao extends Dao<User,String> {
	
	public UserDao(){
		super(User.class);		
	}
	

}
