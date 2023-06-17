import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
private Socket sock = null;
private ServerSocket serv = null;
private Server s = null;
private DataInputStream in = null;
private DataOutputStream out = null;
private FileReader filer = null;
	
public Client(String url, int port) throws IOException, UnknownHostException, FileNotFoundException {

try {
	
sock = new Socket(url, port);

System.out.println("Client has connected");
System.out.println("");

in = new DataInputStream(sock.getInputStream());

String line = "";

while(!line.equals("over")) {
	
String input = in.readUTF();

System.out.println(input);
	
}
	
}catch (IOException e) {
System.out.println("");
System.out.println("Programme Complete");
	

try {
	
sock.close();
in.close();


	
}catch (IOException x) {
	x.printStackTrace();
}
}
}
	
public static void main(String [] args) throws IOException{

Client cli = new Client("127.0.0.1", 5000);	

}
}
