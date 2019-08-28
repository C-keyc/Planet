package seu.list.common;
/**
 * 消息类型分为三类：命令CMD---数据DAT---结果RST
 * @author Aodong Shen
 *
 */
public interface MessageType {
	//--------Command---------//
	String CMD_LOGIN = "CMD_LOGIN";
	String CMD_LOGOUT = "CMD_LOGOUT";
	String CMD_REGISTER = "CMD_REGISTER";
	
	String CMD_GROUPS = "CMD_GROUPS";//要求在线好友的分组	
	String CMD_ONLINE_FRIENDS = "CMD_ONLINE_FRIENDS";//要求在线好友的包
	//------------------------------------//
	String CMD_ALL_FRIENDS = "CMD_ALL_FRIENDS";
	String CMD_ADD_FRIEND = "CMD_ADD_FRIEND";
	String CMD_DEL_FRIEND = "CMD_DEL_FRIEND";
	String CMD_UPD_FRIEND = "CMD_UPD_FRIEND";
	String CMD_QUY_FRIEND = "CMD_QUY_FRIEND";
	//--------Data------------//
	String DAT_LOGOUT = "DAT_LOGOUT";
	String DAT_LOGIN = "DAT_LOGIN";
	
	String DAT_TEXT = "DAT_TEXT";//普通信息包
	String DAT_ACTION = "DAT_ACTION"; // 动作包
	
	String DAT_ALL_FRIENDS = "DAT_ALL_FRIENDS";
	String DAT_ONLINE_FRIENDS = "DAT_ONLINE_FRIENDS";//返回在线好友的包
	
	String DAT_ADD_FRIEND = "DAT_ADD_FRIEND";
	String DAT_DEL_FRIEND = "DAT_DEL_FRIEND";
	String DAT_UPD_FRIEND = "DAT_UPD_FRIEND";
	String DAT_QUY_FRIEND = "DAT_QUY_FRIEND";
	
	//--------Result----------//
	String RST_SUCCESS = "Success";//表明是否成功
	String RST_FAILURE = "Failure";//表明失败	
	
//
	
	String FILE_SEND = "FILE_SEND";
	String FILE_DATA = "FILE_DATA";
	String FILE_RECE = "FILE_RECE";
	
		
}
