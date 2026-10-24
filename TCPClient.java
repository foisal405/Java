
import java.io.*;
import java.net.*;

public class TCPClient {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("localhost", 5000);

        BufferedReader kb = new BufferedReader(
            new InputStreamReader(System.in));
        BufferedReader in = new BufferedReader(
            new InputStreamReader(s.getInputStream()));
        PrintWriter out = new PrintWriter(
            s.getOutputStream(), true);

        String msg;
        while (true) {
            System.out.print("Enter message: ");
            msg = kb.readLine();

            out.println(msg);

            if (msg.equalsIgnoreCase("exit"))
                break;

            System.out.println("Server: " + in.readLine());
        }

        s.close();
    }
}

