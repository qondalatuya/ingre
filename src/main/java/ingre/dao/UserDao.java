package ingre.dao;

import ingre.model.User;

public class UserDao extends Dao<User,String> {
	
	public UserDao(){
		super(User.class);		
	}
	

}
