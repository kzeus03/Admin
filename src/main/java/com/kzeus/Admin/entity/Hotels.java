package com.kzeus.Admin.entity;
import javax.persistence.*;

@Entity
@Table(name="hotels")
public class Hotels {

	//define fields
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="city_name")
	private String firstName;
	
	@Column(name="hotel_name")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	@Column(name="contact_number")
	private String contactNumber;
	
	//define no argument constructors
	public Hotels() {
		
	}

	public Hotels(String firstName, String lastName, String email, String contactNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.contactNumber = contactNumber;
	}

	//define getter/setter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	
	//define toString
	@Override
	public String toString() {
		return "Hotels [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", contactNumber=" + contactNumber + "]";
	}
}
