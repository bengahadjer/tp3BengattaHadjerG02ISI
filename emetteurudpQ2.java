package tp3res;
import java.io.*;
import java.net.*;
public class emetteurudpQ2 {

	    private static final int BUFFER_SIZE = 1024;
	    private static final int PORT = 4504;

	    public static void main(String[] args) {
	        try {
	            DatagramSocket socket = new DatagramSocket();
	            InetAddress address = InetAddress.getByName("localhost");

	            
	            File file = new File("C:\\Users\\amgsoft\\Pictures\\wallpaper\\skiii.png");
	            FileInputStream fileInputStream = new FileInputStream(file);
	            byte[] buffer = new byte[BUFFER_SIZE];

	            
	            int bytesRead = 0;
	            while ((bytesRead = fileInputStream.read(buffer)) != -1) {
	                DatagramPacket packet = new DatagramPacket(buffer, bytesRead, address, PORT);
	                socket.send(packet);
	            }

	            
	            byte[] endData = "END".getBytes();
	            DatagramPacket endPacket = new DatagramPacket(endData, endData.length, address, PORT);
	            socket.send(endPacket);

	            
	            fileInputStream.close();
	            socket.close();

	            System.out.println("Fichier envoyé avec succès !");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	}



