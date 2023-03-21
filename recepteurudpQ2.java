package tp3res;
import java.io.*;
import java.net.*;
public class recepteurudpQ2 {

		
		    private static final int BUFFER_SIZE = 1024;
		    private static final int PORT = 4553;

		    public static void main(String[] args) {
		        try {
		            DatagramSocket socket = new DatagramSocket(PORT);

		            
		            File file = new File("C:\\\\Users\\\\amgsoft\\\\Pictures\\\\wallpaper\\\\e\\\\skiii.png");
		            FileOutputStream fileOutputStream = new FileOutputStream(file);

		            
		            byte[] buffer = new byte[BUFFER_SIZE];
		            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
		            while (true) {
		                socket.receive(packet);
		                if (new String(packet.getData(), 0, packet.getLength()).equals("END")) {
		                    break;
		                }
		                fileOutputStream.write(packet.getData(), 0, packet.getLength());
		            }

		            
		            fileOutputStream.close();
		            socket.close();

		            System.out.println("Fichier reçu avec succès !");
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		    }
		
	}
