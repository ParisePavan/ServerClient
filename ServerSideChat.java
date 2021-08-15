// A Java program for a Serverside
import java.net.*;
import java.io.*;
public class ServerSideChat
{
//initialize socket and input output stream
private Socket socket = null;
private DataInputStream in = null;
private DataOutputStream out = null;
// constructor to put ip address and port
public ServerSideChat(String address, int port)
{
// establish a connection
try{
socket = new Socket(address, port);
System.out.println("Connected");
// takes input from terminal
in = new DataInputStream(System.in);
// sends output to the client
out = new DataOutputStream(socket.getOutputStream());
}
catch(UnknownHostException u)
{
System.out.println(u);
}
catch(IOException i)
{
System.out.println(i);
}
// string to read message from input
String line = "";
// keep reading until "Over" is input
while (!line.equals("Over"))
{
try
{
line = in.readLine();
out.writeUTF(line);
}
catch(IOException i)
{
System.out.println(i);
}
}
// close connection
try
{
in.close();
out.close();
socket.close();
}
catch(IOException i){
System.out.println(i);
}
}
public static void main(String args[]){
ServerSideChat server = new ServerSideChat("127.0.0.1", 2000);
}
}

