

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {
		
	

				Socket s = new Socket("10.26.10.1", 9029);
		DataInputStream din = new DataInputStream(s.getInputStream());
		DataOutputStream dout = new DataOutputStream(s.getOutputStream());
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1 = "", str2 = "";
		while (!str1.equals("s")) {
			str2 = br.readLine();
			dout.writeUTF(str2);
			dout.flush();
			str1 = din.readUTF();
			System.out.println("server  says  " + str1);
		}
		din.close();
		s.close();
	}
}
