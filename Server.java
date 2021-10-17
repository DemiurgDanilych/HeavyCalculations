import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	private static final int PORT = 55555;
	
	private static Socket clientSocket;
	private static ServerSocket server;
	private static BufferedReader in;
	private static BufferedWriter out;
	
	public static void main(String[] args) {
		try {
			try {
				server = new ServerSocket(PORT);
				System.out.println("Сервер запущен !");
				clientSocket = server.accept();
				
				try {
					in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
					out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
					String resultFib = calculation(in.readLine());
					out.write("Результат - " + resultFib + "\n");
					out.flush();
					System.out.println("Ответ отправлен!");
				} finally {
					clientSocket.close();
					in.close();
					out.close();
				}
				
			}finally{
				System.out.println("Сервер закрыт ...");
				server.close();
			}
		} catch (IOException e) {
			System.out.println(e);
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
