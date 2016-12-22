package ingre.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AnEntity {

	public AnEntity(String name) {
		this.name=name;
	}
	
	@Id
	@Column
	private int id;
	
	@Column
	private String name;
}
