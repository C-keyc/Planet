package vc.list.common;

import java.io.Serializable;

public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4750440256356208087L;
	/**
	 * 
	 */

	private String UserID;
	private String UserPassword;
	private int UserType;
	private String UserName;
	private double account;
	public double getAccount() {
		return account;
	}

	public void setAccount(double account) {
		this.account = account;
	}
	
	public User() {
		super();
	}
	
	public User(String uid, String upass) {
		super();
		this.UserID = uid;
		this.UserPassword = upass;
	}

	public User(String uid, String upass, int type) {
		super();
		this.UserID = uid;
		this.UserPassword = upass;
		this.UserType = type;
	}
	
	public User(String uid, String upass,String uname, int type,double uaccount) {
		super();
		this.UserID = uid;
		this.UserPassword = upass;
		this.UserType = type;
		this.account=uaccount;
		this.UserName = uname;
	}
	
	public String getUserID() {
		return UserID;
	}

	public void setUserID(String userID) {
		UserID = userID;
	}

	public String getUname() {
		return UserName;
	}
	
	public void setUname(String uname) {
		this.UserName = uname;
	}
	
	public String getUpass() {
		return UserPassword;
	}
	
	public void setUpass(String upass) {
		this.UserPassword = upass;
	}
	
	public int getType() {
		return UserType;
	}
	
	public void setType(int type) {
		this.UserType = type;
	}


	public String toString() {
		return "User [uname=" + UserID + ", upass=" + UserPassword + ", type=" + UserType + "]";
	}
	
	
}
