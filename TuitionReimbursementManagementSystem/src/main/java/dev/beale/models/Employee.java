package dev.beale.models;

import org.apache.log4j.Logger;

public class Employee {
	static final Logger log = Logger.getLogger(Employee.class);

	int id;
	String firstName;
	String lastName;
	String userName;
	String password;
	String email;
	int phoneNumber;
	int tuitionAvailable = 1000;
	String role;
	int supervisorId;
	int departHeadId;
	int benCoId;

	public Employee() {
		super();
	}

	public Employee(int id, String firstName, String lastName, String userName, String password, String email,
			int phoneNumber, String role, int supervisorId, int departHeadId, int benCoId) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.role = role;
		this.supervisorId = supervisorId;
		this.departHeadId = departHeadId;
		this.benCoId = benCoId;
	}

	public Employee(String firstName, String lastName, String userName, String password, String email, int phoneNumber,
			int tuitionAvailable, String role, int supervisorId, int departHeadId, int benCoId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.role = role;
		this.supervisorId = supervisorId;
		this.departHeadId = departHeadId;
		this.benCoId = benCoId;
	}

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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getTuitionAvailable() {
		return tuitionAvailable;
	}

	public void setTuitionAvailable(int tuitionAvailable) {
		this.tuitionAvailable = tuitionAvailable;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getSupervisorId() {
		return supervisorId;
	}

	public void setSupervisorId(int supervisorId) {
		this.supervisorId = supervisorId;
	}

	public int getDepartHeadId() {
		return departHeadId;
	}

	public void setDepartHeadId(int departHeadId) {
		this.departHeadId = departHeadId;
	}

	public int getBenCoId() {
		return benCoId;
	}

	public void setBenCoId(int benCoId) {
		this.benCoId = benCoId;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", userName=" + userName
				+ ", password=" + password + ", email=" + email + ", phoneNumber=" + phoneNumber + ", tuitionAvailable="
				+ tuitionAvailable + ", role=" + role + ", supervisorId=" + supervisorId + ", departHeadId="
				+ departHeadId + ", benCoId=" + benCoId + "]";
	}

}
