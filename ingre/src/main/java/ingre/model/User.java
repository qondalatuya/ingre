package ingre.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name = "users")
public class User implements Serializable {
	
	private static final long serialVersionUID = 7220128160395743729L;
	
	public User(String uname, String rname){
		this.userName=uname;
		this.realName=rname;
	}
	
	public User(){	
	}
	
	@Id
	@Column	
	private String userName;
	
	@Column
	private String realName;
	
	@Column
	private String password;

	@Column
	private boolean isActive=true;
	
	@OneToOne//no me queda del todo claro
	@JoinColumn(name="id_dep")
	private Department department;
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName.trim().toLowerCase();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return userName + " - " + realName;
	}	
}
