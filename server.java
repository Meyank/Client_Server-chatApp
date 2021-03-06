

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws IOException {
		
	

		ServerSocket ss = new ServerSocket(9029);
		Socket s = ss.accept();
		DataInputStream din = new DataInputStream(s.getInputStream());
		DataOutputStream dout = new DataOutputStream(s.getOutputStream());
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1 = "", str2 = "";
		while (!str1.equals("s")) {
			str2 = br.readLine();
			dout.writeUTF(str2);
			dout.flush();
			str1 = din.readUTF();
			System.out.println("client says  " + str1);
		}
		din.close();
		s.close();
		ss.close();

	}
}
