package com.samrat.obms.model;

import javax.persistence.Entity;

import javax.persistence.Table;
import javax.persistence.*;

//Account Table
@Entity
@Table(name = "account")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Accnt_No;

	@Column(name = "Accnt_Type")
	private String Accnt_Type;

	@Column(name = "Accnt_Balance")
	private long Accnt_Balance;

	@Column(name = "IFSC_Code")
	private String IFSC_Code;

	@Column(name = "Opening_Date")
	private String Opening_Date;

	@Column(name = "Branch_Name")
	private String Branch_Name;

	@Column(name = "Branch_Code")
	private String Branch_Code;

	@Column(name = "Cust_ID")
	private int Cust_ID;

	@Column(name = "Cust_NomineeName")
	private String Cust_NomineeName;
	
	

	public long getAccnt_No() {
		return Accnt_No;
	}

	public void setAccnt_No(long accnt_No) {
		Accnt_No = accnt_No;
	}

	public String getAccnt_Type() {
		return Accnt_Type;
	}

	public void setAccnt_Type(String accnt_Type) {
		Accnt_Type = accnt_Type;
	}

	public long getAccnt_Balance() {
		return Accnt_Balance;
	}

	public void setAccnt_Balance(long accnt_Balance) {
		Accnt_Balance = accnt_Balance;
	}

	public String getIFSC_Code() {
		return IFSC_Code;
	}

	public void setIFSC_Code(String iFSC_Code) {
		IFSC_Code = iFSC_Code;
	}

	public String getOpening_Date() {
		return Opening_Date;
	}

	public void setOpening_Date(String opening_Date) {
		Opening_Date = opening_Date;
	}

	public String getBranch_Name() {
		return Branch_Name;
	}

	public void setBranch_Name(String branch_Name) {
		Branch_Name = branch_Name;
	}

	public String getBranch_Code() {
		return Branch_Code;
	}

	public void setBranch_Code(String branch_Code) {
		Branch_Code = branch_Code;
	}

	public int getCust_ID() {
		return Cust_ID;
	}

	public void setCust_ID(int cust_ID) {
		Cust_ID = cust_ID;
	}

	public String getCust_NomineeName() {
		return Cust_NomineeName;
	}

	public void setCust_NomineeName(String cust_NomineeName) {
		Cust_NomineeName = cust_NomineeName;
	}

	// Parameterized Constructors
	public Account(long accnt_No, String accnt_Type, long accnt_Balance, String iFSC_Code, String opening_Date,
			String branch_Name, String branch_Code, int cust_ID, String cust_NomineeName) {
		super();
		Accnt_No = accnt_No;
		Accnt_Type = accnt_Type;
		Accnt_Balance = accnt_Balance;
		IFSC_Code = iFSC_Code;
		Opening_Date = opening_Date;
		Branch_Name = branch_Name;
		Branch_Code = branch_Code;
		Cust_ID = cust_ID;
		Cust_NomineeName = cust_NomineeName;
	}

	public Account() {
		super();
	}
}