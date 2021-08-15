// A Java program for a ClientSide
import java.net.*;
import java.io.*;
public class ClientProgram2
{
// initialize socket and input streams
private Socket socket = null;
private ServerSocket client = null;
private DataInputStream in = null;
// constructor with port
public ClientProgram2(int port)
{
// starts client ans waits for a connection
try{
client = new ServerSocket(port);
System.out.println("Client Started");
System.out.println("Waiting for a server...");
socket = client.accept();
System.out.println("Server accepted");
// takes input to the server socket
in = new DataInputStream(
new BufferedInputStream(socket.getInputStream()));
String line = "";
// reads message from server until "Over" is sent
while (!line.equals("Over"))
{
try
{
line = in.readUTF();
System.out.println(line);
}
catch(IOException i)
{
System.out.println(i);
}
}
System.out.println("Closing connection");
// close connection
socket.close();
in.close();
}
catch(IOException i){
System.out.println(i);
}
}
public static void main(String args[]){
ClientProgram2 client = new ClientProgram2(2000);
}
}


