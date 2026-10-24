import java.net.*;

public class UDPServer {
    public static void main(String[] args) throws Exception {
        DatagramSocket s = new DatagramSocket(6000);
        byte[] buf = new byte[1024];

        System.out.println("UDP Server started...");

        while (true) {
            DatagramPacket p = new DatagramPacket(buf, buf.length);
            s.receive(p);

            String msg = new String(p.getData(), 0, p.getLength());
            System.out.println("Client: " + msg);

            Thread.sleep(6);

            byte[] data = msg.toUpperCase().getBytes();
            DatagramPacket r = new DatagramPacket(
                data, data.length,p.getAddress(), p.getPort());

            s.send(r);
        }
    }
}
