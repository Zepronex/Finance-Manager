package main;

import java.util.Date;

public class Transaction {
	private int id;
	private double amount;
	private Date date;
	private String category;
	private String description;
	private String type; // expense or income
	
	public Transaction(int id, double amount, Date date, String category, String description, String type) {
		this.id = id;
		this.amount = amount;
		this.date = date;
		this.category = category;
		this.description = description;
		this.type = type;
		
	}
	
	// implement getters and setters

}
