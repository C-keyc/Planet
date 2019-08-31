package vc.server.bz;

public interface IServerSrv extends Runnable {

	void start();

	void close();

	boolean isClosed();
}
