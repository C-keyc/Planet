package seu.list.client.bz;

import java.io.IOException;

import seu.list.common.Message;

public interface IClientSrv {

	/**
	 * 负责向服务器发送消息
	 * 
	 * @param msgPack
	 * @throws IOException 
	 */
	public void send(Message msgPack) throws IOException;

	/**
	 * 负责由服务器接收消息
	 * 
	 * @return
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public Message receive(String qqNo) throws ClassNotFoundException, IOException;

}
