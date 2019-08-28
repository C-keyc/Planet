package seu.list.client.bz;

import java.io.File;
import java.io.IOException;
import java.net.UnknownHostException;

public interface IFileClientSrv extends IClientSrv {

	public void send(String qqNo, String receiverNo, File file) throws UnknownHostException, IOException;	

	public void receive(String qqNo, String senderNo, File file, long length) throws UnknownHostException, IOException;

}
