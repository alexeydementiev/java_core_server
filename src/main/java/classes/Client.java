package classes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

	public static void main(String[] args) throws IOException {
		int port = 8099;
		String host = "netology.homework";

		try (Socket clientSocket = new Socket(host, port);
				PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
				BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));) {
				out.println("Petr");
				String responce = in.readLine();
				System.out.println(responce);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
