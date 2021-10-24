import java.io.*;
import java.net.Socket;

public class Client {
	private static final String IP = "127.0.0.1";
	private static final int PORT = 55555;
	
	public static void main(String[] args) {
		
		try (Socket clientSocket = new Socket(IP, PORT);
			 BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			 BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			 BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()))
		) {
			System.out.println("Клиент запущен !");
			System.out.println("Введите N - ый член Фибоначчи");
			String number = reader.readLine();
			out.write(number + "\n");
			out.flush();
			String serverNumber = in.readLine();
			System.out.println(serverNumber);
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
