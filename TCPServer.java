
import java.io.*;
import java.net.*;

public class TCPServer {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(5000);
        System.out.println("Server started...");

        Socket s = ss.accept();

        BufferedReader in = new BufferedReader(
            new InputStreamReader(s.getInputStream()));
        PrintWriter out = new PrintWriter(
            s.getOutputStream(), true);

        String msg;
        while ((msg = in.readLine()) != null) {
            if (msg.equalsIgnoreCase("exit"))
                break;

            System.out.println("Client: " + msg);
            out.println(msg.toUpperCase());
        }

        s.close();
        ss.close();
    }
}
