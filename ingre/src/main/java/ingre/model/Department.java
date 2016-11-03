package ingre.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name="departments")
public class Department implements Serializable {

	private static final long serialVersionUID = -2850331130307487608L;
	
	@Id
	@GeneratedValue
	@Column
	private int id;
	
	@Column
	private String name;
	
	@OneToOne
	@JoinColumn(name="id_boss_user")
	private User boss;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
	
	
	
	
	

}
