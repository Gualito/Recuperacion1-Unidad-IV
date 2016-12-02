package boot.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="accounts")
public class Account implements Serializable {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(length=45)
	private String name;
	@Column(length=45)
	private String surname;
	@Column(length=45)
	private String email;
	@Column(length=15)
	private String phone;
	@Column(length=45)
	private String password;
	
	
	public Account() {
		this("","","","","");
	}
	
	public Account( String name, String surname, String email, String phone, String password) {
		super();
		
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.phone = phone;
		this.password = password;
	}
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
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", name=" + name + ", surname=" + surname + ", email=" + email + ", phone=" + phone
				+ ", password=" + password + "]";
	}
	
	
	
	


}
