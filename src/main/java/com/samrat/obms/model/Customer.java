package com.samrat.obms.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;

@Entity
@Table(name="customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Cust_ID;
	
	@Column(name = "Cust_Address")
    private String Cust_Address;
	
	@Column(name="Cust_Name")
    private String Cust_Name;
	
	@Column(name="Cust_Address")
    private String Cust_Password;
	
	@Column(name="Cust_Aadharno")
    private String Cust_Aadharno;
	
	@Column(name="Cust_Panno")
    private String Cust_Panno;
	
	@Column(name="Cust_Email")
    private String Cust_Email;
	
	@Column(name="Cust_MobileNo")
    private int Cust_MobileNo;
	
	@Column(name="Cust_PinCode")
    private int Cust_PinCode;
	
	@Column(name="Cust_State")
    private String Cust_State;
	
	@Column(name="User_Name")
    private String User_Name;
	
	@Column(name="Cust_NomineeName")
    private String Cust_NomineeName;
	
	@Column(name="Cust_DOB")
    private String Cust_DOB;
	
	@Column(name="Accnt_No")
    private int Accnt_No;
    
    
}
