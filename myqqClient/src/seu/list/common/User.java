/*
 * 这是个用户信息类
 */
package seu.list.common;

/**
 * @author  john
 */
public class User implements java.io.Serializable{//序列化，可以让一个对象在网络上传输
	// 属性的顺序是有用的！
	/**
	 * @uml.property  name="qqNo"
	 */
	private String qqNo;
	/**
	 * @uml.property  name="nickName"
	 */
	private String nickName;
	/**
	 * @uml.property  name="password"
	 */
	private String password;
	/**
	 * @uml.property  name="sex"
	 */
	private String sex;
	/**
	 * @uml.property  name="status"
	 */
	private String status;
	/**
	 * @uml.property  name="friendId"
	 */
	private String friendId;
	
	/**
	 * @author   john
	 */
	public enum STAUTS_TYPE {
		/**
		 * @uml.property  name="oNLINE"
		 * @uml.associationEnd  
		 */
		ONLINE, /**
		 * @uml.property  name="oFFLINE"
		 * @uml.associationEnd  
		 */
		OFFLINE,
		/**
		 * @uml.property  name="iNVISIBLE"
		 * @uml.associationEnd  
		 */
		INVISIBLE, /**
		 * @uml.property  name="oUT"
		 * @uml.associationEnd  
		 */
		OUT,
		/**
		 * @uml.property  name="bUSY"
		 * @uml.associationEnd  
		 */
		BUSY,  /**
		 * @uml.property  name="nO_DISTURB"
		 * @uml.associationEnd  
		 */
		NO_DISTURB
	}
	
//	public enum OPERATION_TYPE {
//		LOGIN, LOGOUT,	REGISTER, UPDATE, 					// 对自身的操作	
//		ADD_FRIEND, DEL_FRIEND, UPD_FRIEND, QUY_FRIEND, 	// 对好友的操作
//		ADD_GROUP, DEL_GROUP, UPD_GROUP, QUY_GROUP,			// 对分组的操作
//	}	
	//
	private static final long serialVersionUID = -297263815435796507L;
	
	public User(String qqNo) {
		this.qqNo = qqNo;
	}
	public User() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return
	 * @uml.property  name="friendId"
	 */
	public String getFriendId() {
		return friendId;
	}
	/**
	 * @param friendId
	 * @uml.property  name="friendId"
	 */
	public void setFriendId(String friendId) {
		this.friendId = friendId;
	}
	/**
	 * @return
	 * @uml.property  name="qqNo"
	 */
	public String getQqNo() {
		return qqNo;
	}
	/**
	 * @param qqNo
	 * @uml.property  name="qqNo"
	 */
	public void setQqNo(String qqNo) {
		this.qqNo = qqNo;
	}
	/**
	 * @return
	 * @uml.property  name="nickName"
	 */
	public String getNickName() {
		return nickName;
	}
	/**
	 * @param nickName
	 * @uml.property  name="nickName"
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	/**
	 * @return
	 * @uml.property  name="password"
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password
	 * @uml.property  name="password"
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return
	 * @uml.property  name="sex"
	 */
	public String getSex() {
		return sex;
	}
	/**
	 * @param sex
	 * @uml.property  name="sex"
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}
	/**
	 * @return
	 * @uml.property  name="status"
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status
	 * @uml.property  name="status"
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "User [qqNo=" + qqNo + ", nickName=" + nickName + ", password="
				+ password + ", sex=" + sex + ", status=" + status + "]";
	}
	
}
