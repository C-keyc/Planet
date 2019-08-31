package vc.list.common;
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
	
    String CMD_CHECK_GOODS = "CMD_CHECK_GOODS";
    String CMD_OPEN_GOODS_MAIN = "CMD_OPEN_GOODS_MAIN";
    String CMD_QUERY_GOODS = "CMD_QUERY_GOODS";
    //--------Data------------//
	String DAT_LOGOUT = "DAT_LOGOUT";
	String DAT_LOGIN = "DAT_LOGIN";
	
	String DAT_TEXT = "DAT_TEXT";//普通信息包
	String DAT_ACTION = "DAT_ACTION"; // 动作包
	

	
	String DAT_ADD_FRIEND = "DAT_ADD_FRIEND";
	String DAT_DEL_FRIEND = "DAT_DEL_FRIEND";
	String DAT_UPD_FRIEND = "DAT_UPD_FRIEND";
	String DAT_QUY_FRIEND = "DAT_QUY_FRIEND";
	
	//--------Result----------//
	String RST_SUCCESS = "Success";//表明是否成功
	String RST_FAILURE = "Failure";//表明失败	

	
}
