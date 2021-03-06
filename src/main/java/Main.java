import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

	public static void main(String[] args) {
		int port = 8099;
		try (ServerSocket serverSocket = new ServerSocket(port)) {

			System.out.println("Server is working...");

			while (true) {
				try (Socket clientSocket = serverSocket.accept()) {
					PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
					BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));


				final String name = in.readLine();

				out.println(String.format("Your name is %s, your port is %d", name, clientSocket.getPort()));
				}  catch (IOException exception) {
					exception.printStackTrace();
				}
			}
		} catch (IOException exception) {
			exception.printStackTrace();
		}
	}
}
