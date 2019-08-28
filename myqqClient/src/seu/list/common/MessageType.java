package seu.list.common;
/**
 * ��Ϣ���ͷ�Ϊ���ࣺ����CMD---����DAT---���RST
 * @author Aodong Shen
 *
 */
public interface MessageType {
	//--------Command---------//
	String CMD_LOGIN = "CMD_LOGIN";
	String CMD_LOGOUT = "CMD_LOGOUT";
	String CMD_REGISTER = "CMD_REGISTER";
	
	String CMD_GROUPS = "CMD_GROUPS";//Ҫ�����ߺ��ѵķ���	
	String CMD_ONLINE_FRIENDS = "CMD_ONLINE_FRIENDS";//Ҫ�����ߺ��ѵİ�
	//------------------------------------//
	String CMD_ALL_FRIENDS = "CMD_ALL_FRIENDS";
	String CMD_ADD_FRIEND = "CMD_ADD_FRIEND";
	String CMD_DEL_FRIEND = "CMD_DEL_FRIEND";
	String CMD_UPD_FRIEND = "CMD_UPD_FRIEND";
	String CMD_QUY_FRIEND = "CMD_QUY_FRIEND";
	//--------Data------------//
	String DAT_LOGOUT = "DAT_LOGOUT";
	String DAT_LOGIN = "DAT_LOGIN";
	
	String DAT_TEXT = "DAT_TEXT";//��ͨ��Ϣ��
	String DAT_ACTION = "DAT_ACTION"; // ������
	
	String DAT_ALL_FRIENDS = "DAT_ALL_FRIENDS";
	String DAT_ONLINE_FRIENDS = "DAT_ONLINE_FRIENDS";//�������ߺ��ѵİ�
	
	String DAT_ADD_FRIEND = "DAT_ADD_FRIEND";
	String DAT_DEL_FRIEND = "DAT_DEL_FRIEND";
	String DAT_UPD_FRIEND = "DAT_UPD_FRIEND";
	String DAT_QUY_FRIEND = "DAT_QUY_FRIEND";
	
	//--------Result----------//
	String RST_SUCCESS = "Success";//�����Ƿ�ɹ�
	String RST_FAILURE = "Failure";//����ʧ��	
	
//
	
	String FILE_SEND = "FILE_SEND";
	String FILE_DATA = "FILE_DATA";
	String FILE_RECE = "FILE_RECE";
	
		
}
