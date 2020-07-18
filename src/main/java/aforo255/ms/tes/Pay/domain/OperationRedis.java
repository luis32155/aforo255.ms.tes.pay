package aforo255.ms.tes.Pay.domain;

import java.io.Serializable;

public class OperationRedis implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	
	private String id ;	
	private double amount ;	
	private String date;	
	private int idinvoce;
	
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getIdinvoce() {
		return idinvoce;
	}
	public void setIdinvoce(int idinvoce) {
		this.idinvoce = idinvoce;
	}

	
	
	
	
}
