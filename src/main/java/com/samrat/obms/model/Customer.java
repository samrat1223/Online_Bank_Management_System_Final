package com.samrat.obms.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;

//Customer Table
@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Cust_ID;

	@Column(name = "Cust_Address")
	private String Cust_Address;

	@Column(name = "Cust_Name")
	private String Cust_Name;

	@Column(name = "Cust_Password")
	private String Cust_Password;

	@Column(name = "Cust_Aadharno")
	private String Cust_Aadharno;

	@Column(name = "Cust_Panno")
	private String Cust_Panno;

	@Column(name = "Cust_Email")
	private String Cust_Email;

	@Column(name = "Cust_MobileNo")
	private int Cust_MobileNo;

	@Column(name = "Cust_PinCode")
	private int Cust_PinCode;

	@Column(name = "Cust_State")
	private String Cust_State;

	@Column(name = "User_Name")
	private String User_Name;

	@Column(name = "Cust_NomineeName")
	private String Cust_NomineeName;

	@Column(name = "Cust_DOB")
	private String Cust_DOB;

	@Column(name = "Accnt_No")
	private int Accnt_No;

	// Getter and Setters for customer table
	public int getCust_ID() {
		return Cust_ID;
	}

	public void setCust_ID(int cust_ID) {
		Cust_ID = cust_ID;
	}

	public String getCust_Address() {
		return Cust_Address;
	}

	public void setCust_Address(String cust_Address) {
		Cust_Address = cust_Address;
	}

	public String getCust_Name() {
		return Cust_Name;
	}

	public void setCust_Name(String cust_Name) {
		Cust_Name = cust_Name;
	}

	public String getCust_Password() {
		return Cust_Password;
	}

	public void setCust_Password(String cust_Password) {
		Cust_Password = cust_Password;
	}

	public String getCust_Aadharno() {
		return Cust_Aadharno;
	}

	public void setCust_Aadharno(String cust_Aadharno) {
		Cust_Aadharno = cust_Aadharno;
	}

	public String getCust_Panno() {
		return Cust_Panno;
	}

	public void setCust_Panno(String cust_Panno) {
		Cust_Panno = cust_Panno;
	}

	public String getCust_Email() {
		return Cust_Email;
	}

	public void setCust_Email(String cust_Email) {
		Cust_Email = cust_Email;
	}

	public int getCust_MobileNo() {
		return Cust_MobileNo;
	}

	public void setCust_MobileNo(int cust_MobileNo) {
		Cust_MobileNo = cust_MobileNo;
	}

	public int getCust_PinCode() {
		return Cust_PinCode;
	}

	public void setCust_PinCode(int cust_PinCode) {
		Cust_PinCode = cust_PinCode;
	}

	public String getCust_State() {
		return Cust_State;
	}

	public void setCust_State(String cust_State) {
		Cust_State = cust_State;
	}

	public String getUser_Name() {
		return User_Name;
	}

	public void setUser_Name(String user_Name) {
		User_Name = user_Name;
	}

	public String getCust_NomineeName() {
		return Cust_NomineeName;
	}

	public void setCust_NomineeName(String cust_NomineeName) {
		Cust_NomineeName = cust_NomineeName;
	}

	public String getCust_DOB() {
		return Cust_DOB;
	}

	public void setCust_DOB(String cust_DOB) {
		Cust_DOB = cust_DOB;
	}

	public int getAccnt_No() {
		return Accnt_No;
	}

	public void setAccnt_No(int accnt_No) {
		Accnt_No = accnt_No;
	}

	// Parameterized Constructors
	public Customer(int cust_ID, String cust_Address, String cust_Name, String cust_Password, String cust_Aadharno,
			String cust_Panno, String cust_Email, int cust_MobileNo, int cust_PinCode, String cust_State,
			String user_Name, String cust_NomineeName, String cust_DOB, int accnt_No) {
		super();
		Cust_ID = cust_ID;
		Cust_Address = cust_Address;
		Cust_Name = cust_Name;
		Cust_Password = cust_Password;
		Cust_Aadharno = cust_Aadharno;
		Cust_Panno = cust_Panno;
		Cust_Email = cust_Email;
		Cust_MobileNo = cust_MobileNo;
		Cust_PinCode = cust_PinCode;
		Cust_State = cust_State;
		User_Name = user_Name;
		Cust_NomineeName = cust_NomineeName;
		Cust_DOB = cust_DOB;
		Accnt_No = accnt_No;
	}

	public Customer() {
		super();
	}

}
