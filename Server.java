import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	private static final int PORT = 55555;
	
	public static void main(String[] args) {
		
		try (ServerSocket server = new ServerSocket(PORT);
			 Socket clientSocket = server.accept();
			 BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			 BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()))
			 ) {
			
			String resultFib = calculation(in.readLine());
			out.write("Результат - " + resultFib + "\n");
			out.flush();
			System.out.println("Ответ отправлен!");
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private static String calculation(String num) {
		int numbFib = Integer.parseInt(num);
		
		long[] arr = new long[numbFib + 1];
		
		arr[0] = 0;
		arr[1] = 1;
		
		for (int i = 2; i <= numbFib; i++)
			arr[i] = arr[i - 1] + arr[i - 2];
		
		return String.valueOf(arr[numbFib]);
	}
}
