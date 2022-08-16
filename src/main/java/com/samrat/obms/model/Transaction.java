package com.samrat.obms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="transaction")
public class Transaction {

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Transaction_Id;
	
	@Column(name = "Amount")
	private long Amount;
	
	@Column(name = "Transac_Date")
	private String Transac_Date;
	
	@Column(name = "Sender")
	private String Sender;
	
	@Column(name = "Receiver")
	private String Receiver;
	
	@Column(name = "Transac_Type")
	private String Transac_Type;
	
	@Column(name = "Accnt_No")
	private long Accnt_No;

	public long getTransaction_Id() {
		return Transaction_Id;
	}

	public void setTransaction_Id(long transaction_Id) {
		Transaction_Id = transaction_Id;
	}

	public long getAmount() {
		return Amount;
	}

	public void setAmount(long amount) {
		Amount = amount;
	}

	public String getTransac_Date() {
		return Transac_Date;
	}

	public void setTransac_Date(String transac_Date) {
		Transac_Date = transac_Date;
	}

	public String getSender() {
		return Sender;
	}

	public void setSender(String sender) {
		Sender = sender;
	}

	public String getReceiver() {
		return Receiver;
	}

	public void setReceiver(String receiver) {
		Receiver = receiver;
	}

	public String getTransac_Type() {
		return Transac_Type;
	}

	public void setTransac_Type(String transac_Type) {
		Transac_Type = transac_Type;
	}

	public long getAccnt_No() {
		return Accnt_No;
	}

	public void setAccnt_No(long accnt_No) {
		Accnt_No = accnt_No;
	}
	
}
