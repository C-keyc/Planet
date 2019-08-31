package vc.client.bz.thread;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;


import vc.list.common.Course;

public class CourseThreadSrv extends Thread {

	private Socket socket = null;
	private boolean isOffline;
	
	private Course course;
	
	public CourseThreadSrv() throws IOException {
		InetAddress addr = InetAddress.getLocalHost();
		
		socket = new Socket(addr.getHostAddress(),5678);
		isOffline = false;
	}
	
	public void run() {
		while (!isOffline) {
			ObjectInputStream ois = null;
			
			// ��ͣ�ض�ȡ�ӷ������˷�������Ϣ
			try {
				ois = new ObjectInputStream(socket.getInputStream());
				course = (Course) ois.readObject();
				System.out.println("���շ����������ݣ��ον�ʦ��Ϊ��"+course.getName());
			} catch (IOException e) {
				isOffline = true;
				
				e.printStackTrace();
				break;
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			} catch (Exception e) {
				
				e.printStackTrace();
			}finally {
				
			}
		}	
	}
	
	
	public OutputStream getOutputStream() throws IOException {
		return socket.getOutputStream();
	}

	public InputStream getInputStream() throws IOException {
		return socket.getInputStream();
	}
	
	
}