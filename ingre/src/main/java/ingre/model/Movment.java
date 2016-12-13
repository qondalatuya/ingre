package ingre.model;

import java.util.Date;

public class Movment {

	private int id;
	private Date setDate,receivedDate;
	private User sender, particularReceptor;
	private Department receptor;
	private String description;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getSetDate() {
		return setDate;
	}
	public void setSetDate(Date setDate) {
		this.setDate = setDate;
	}
	public Date getReceivedDate() {
		return receivedDate;
	}
	public void setReceivedDate(Date receivedDate) {
		this.receivedDate = receivedDate;
	}
	public User getSender() {
		return sender;
	}
	public void setSender(User sender) {
		this.sender = sender;
	}
	public Department getReceptor() {
		return receptor;
	}
	public void setReceptor(Department receptor) {
		this.receptor = receptor;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public User getParticularReceptor() {
		return particularReceptor;
	}
	public void setParticularReceptor(User particularReceptor) {
		this.particularReceptor = particularReceptor;
}
	
}
