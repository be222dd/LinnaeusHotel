package model;

import java.sql.Date;

public class Guest {
	
	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	private String email;
	private String phoneNumber;
	private String idType;
	private String idNumber;
	private int guestId;
	
	public Guest(String firstName, String lastName, Date dateOfBirth, String email, String phoneNumber, String idType,
			String idNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.idType = idType;
		this.idNumber = idNumber;
	}
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getIdType() {
		return idType;
	}
	public void setIdType(String idType) {
		this.idType = idType;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	
	public int getGuestId() {
		return guestId;
	}


	public void setGuestId(int guestId) {
		this.guestId = guestId;
	}


	@Override
	public String toString() {
		return this.firstName+" "+this.lastName;
	}
	
	
	

}
