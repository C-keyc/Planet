package seu.list.client.bz;

import java.io.IOException;

import seu.list.common.Message;

public interface IClientSrv {

	/**
	 * �����������������Ϣ
	 * 
	 * @param msgPack
	 * @throws IOException 
	 */
	public void send(Message msgPack) throws IOException;

	/**
	 * �����ɷ�����������Ϣ
	 * 
	 * @return
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public Message receive(String qqNo) throws ClassNotFoundException, IOException;

}
