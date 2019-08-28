package seu.list.client.bz;

import java.io.File;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.List;

import seu.list.common.Group;
import seu.list.common.Message;
import seu.list.common.User;

/**
 * �û���ص���Ϊ
 * @author Aodong Shen
 *
 */
public interface IUserSrv {

	// ��¼
	public User login(User user) throws IOException, ClassNotFoundException;
	// �ǳ�
	public boolean logout(User user) throws IOException;
	// ע��
	public User register(User user) throws IOException, ClassNotFoundException;
	// ����
	public User update(User user);
	
	
	// ��Ӻ���
	public void addFriend(User user, String friendNo) throws IOException;
	// ɾ������
	public void delFriend(User user, String friendNo) throws IOException;
	// ���º���
	public void updFriend(User user, User friend);
	// ��ѯ����
	public void quyFriend(User user, String friendNo);
	public void quyFriend(User user) throws IOException;
	
	// ����Ĳ���
	public Group addGroup(User user, String grpName);
	public Group delGroup(User user, String grpName);
	public Group updGroup(User user, Group group);
	public List<Group> quyGroup(User user, String grpName);
	
	// ����
	public void chat(User sender, User reciever, String content) throws IOException;
	public User isFriend(User user, String friendNo);
	
	public void sendMessage(Message msg) throws IOException;	
	public void sendFile(User sender, String ownerId, File file) throws UnknownHostException, IOException;
	public void receiveFile(User owner, String string, File file, long length) throws UnknownHostException, IOException;
	public void sendFileMessage(Message msg) throws IOException;
	public void sendFile(User owner, User friend, File file) throws IOException;
	public void sendShake(User owner, User friend) throws IOException;
	
	
}
