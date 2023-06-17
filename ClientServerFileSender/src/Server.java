import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.ArrayList;

public class Server {
	
private Socket sock = null;
private ServerSocket serv = null;
private FileReader filer = null;
private FileWriter writer = null;
private BufferedWriter writ = null;
private BufferedReader reader = null;
private DataInputStream in = null;
private DataOutputStream out = null;
private PrintWriter writerr = null;	

public Server(int port) {	

try {
		
serv = new ServerSocket(port);

System.out.println("Initializing Server......");
System.out.println("");
sock = serv.accept();

System.out.println("server ready");
System.out.println("");

filer = new FileReader("example/file2.txt");

in = new DataInputStream(System.in);

out = new DataOutputStream(sock.getOutputStream());

//writerr = new PrintWriter(sock.getOutputStream(), true);

Scanner fetch = new Scanner(filer);

//need to get the info onto the sock

if((fetch.hasNextLine())){ 
	
String o = fetch.nextLine();

System.out.println(o);

out.writeUTF("Server message:" +  o);
System.out.println("");
System.out.println("Programme Complete");
	

//need to be converted???


out.flush();


}else {
	
return;
}
		
}catch(IOException e) {
	
	
}



try { 
	
sock.close();

out.close();
//writerr.close();
	
} catch (IOException f) {
f.printStackTrace();	
	
}
}
	

public static void main(String [] args) {		
	
Server s = new Server(5000);
		

}
}