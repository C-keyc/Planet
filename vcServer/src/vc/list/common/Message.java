package vc.list.common;

import java.util.Date;
import java.util.List;

import vc.list.common.User;

public class Message implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8454558035178168414L;

	private String id;
	private String type;
	private User sender;
	private User receiver;
	
	private String content;
	private String sendTime;
	
	private Goods gd;

	private List<Goods> gdlist;

	private Object data;
	
	private Book bk;
	
	private List<Book> bklist;

	public Message() {
		this.sendTime = new Date().toString();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public User getSender() {
		return sender;
	}
	public void setSender(User user) {
		this.sender = user;
	}
	public User getReceiver() {
		return receiver;
	}
	public void setReceiver(User receiver) {
		this.receiver = receiver;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSendTime() {
		return sendTime;
	}

	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}



	public void setData(Object data) {
		this.data = data;
	}

	public Object getData() {
		return this.data;
	}

	public Goods getGd() {
		return gd;
	}

	public void setGd(Goods gd) {
		this.gd = gd;
	}

	public List<Goods> getGdlist() {
		return gdlist;
	}

	public void setGdlist(List<Goods> gdlist) {
		this.gdlist = gdlist;
	}

	public Book getBk() {
		return bk;
	}

	public void setBk(Book bk) {
		this.bk = bk;
	}

	public List<Book> getBklist() {
		return bklist;
	}

	public void setBklist(List<Book> bklist) {
		this.bklist = bklist;
	}
	
	
}
