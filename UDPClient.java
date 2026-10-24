import java.net.*;
import java.util.Scanner;

public class UDPClient {
    public static void main(String[] args) throws Exception {
        DatagramSocket s = new DatagramSocket();
        Scanner sc = new Scanner(System.in);
        InetAddress host = InetAddress.getByName("localhost");

        byte[] buf = new byte[1024];

        while (true) {
            System.out.print("Enter message: ");
            String msg = sc.nextLine();

            if (msg.equalsIgnoreCase("exit"))
                break;

            byte[] data = msg.getBytes();

            if (data.length > 1024) {
                System.out.println("Message too long!");
                continue;
            }

            DatagramPacket p = new DatagramPacket(
                data, data.length, host, 6000);
            s.send(p);

            DatagramPacket r =new DatagramPacket(buf, buf.length);
            s.receive(r);

            System.out.println("Server: "
                + new String(r.getData(), 0, r.getLength()));
        }

        s.close();
        sc.close();
    }
}

