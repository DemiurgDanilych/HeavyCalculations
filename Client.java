import java.io.*;
import java.net.Socket;

public class Client {
	private static final String IP = "127.0.0.1";
	private static final int PORT = 55555;
	
	private static Socket clientSocket;
	private static BufferedReader reader;
	private static BufferedReader in;
	private static BufferedWriter out;
	
	
	public static void main(String[] args)  {
		try{
			try{
				clientSocket = new Socket(IP,PORT);
				reader = new BufferedReader(new InputStreamReader(System.in));
				in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
				
				System.out.println("Клиент запущен !");
				System.out.println("Введите N - ый член Фибоначчи");
				String number = reader.readLine();
				out.write(number + "\n");
				out.flush();
				String serverNumber = in.readLine();
				System.out.println(serverNumber);
				
			} finally {
				System.out.println("Клиент закрыт ...");
				clientSocket.close();
				in.close();
				out.close();
			}
		} catch (IOException e){
			System.out.println(e);
		}
	}
}
