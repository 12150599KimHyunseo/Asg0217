import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ProductClient {
    private Socket socket;
    private DataInputStream dis;
    private DataOutputStream dos;
    private Scanner sc;

    public void start() throws IOException {
        socket = new Socket();
        dis = new DataInputStream(socket.getInputStream());
        dos = new DataOutputStream(socket.getOutputStream());
        System.out.println("서버에 연결됨");

        Scanner sc = new Scanner(System.in);

    }
    public void stop() {
        try {
            socket.close();
            sc.close();
        } catch (Exception e) {}
        System.out.println("클라이언트 연결 종료됨");
    }
    public void list() throws IOException{

    }
    public void create() throws IOException{

    }
    public void update() throws IOException{

    }
    public void delete() throws IOException{

    }
    public static void main(String[] Args) {
        ProductClient productClient = new ProductClient();
        try {
            productClient.start();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            productClient.stop();
        }
    }

}
