package client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SendThread extends Thread{

	private Socket m_Socket;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		try {
			BufferedReader tmpbuf = new BufferedReader(new InputStreamReader(System.in));
			PrintWriter sendwriter = new PrintWriter(m_Socket.getOutputStream());
			String sendString;
			
			while(true) {
				sendString = tmpbuf.readLine();
				if(sendString.equals("exit")) {
					break;
				}
				sendwriter.println(sendString);
				sendwriter.flush();
			}
			sendwriter.close();
			tmpbuf.close();
			m_Socket.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}
	}

	public void setSocket(Socket _socket) {
		m_Socket=_socket;
	}
}
