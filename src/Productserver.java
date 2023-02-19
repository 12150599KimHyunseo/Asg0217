import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.io.DataInputStream;
import java.io.DataOutputStream;

import static jdk.internal.net.http.common.Utils.close;

public class ProductServer {
    private ServerSocket serversocket;
    private List<Product> products;
    private ExecutorService threadPool;
    private int sequence;

    public void start() throws IOException {
        serversocket = new ServerSocket();
        threadPool = ExecutorService.newFixedThreadPool();
        products = new Vector<Product>();

        System.out.println("프로덕트 서버 시작");

        while (true) {
            Socket socket = serversocket.accept();
            ProductClient sc = new ProductClient(socket);
        }
    }

    public void stop() {
        try {
            serversocket.close();
            threadPool.shutdownNow();
            System.out.println("프로덕트 서버 종료");
        } catch (IOException e) {

        }

    }

public class SocketClient {
    private Socket socket;
    private DataInputStream dis;
    private DataOutputStream dos;
}
    public SocketClient(Socket socket) {
    try {
        this.socket = socket;
        this.dis = new DataInputStream(socket.getInputStream());
        this.dos = new DataOutputStream(socket.getOutputStream());
        receive();
    } catch (IOException e) {
        close();
    }
}

    public void receive() {
        threadPool.execute(() -> {
            try {
                while (true) {
                    String receiveJson = dis.readUTF();

                    JSONObject request = new JSONObject(receiveJson);
                    int menu = request.getInt("menu");

                    switch (menu) {
                        case 0 -> list(request);
                        case 1 -> create(request);
                        case 2 -> update(request);
                        case 3 -> delete(request);
                    }
                }
            } catch (IOException e) {
                close();
            }
        });
    }
    public void list(JSONObject request) {

    }
    public void create(JSONObject request) {

    }
    public void update(JSONObject request) {

    }
    public void delete(JSONObject request) {

    }
    public void close() {

    }


    public static void main(String[] Args) {
        ProductServer productserver = new ProductServer();
        try {
            productserver.start();
        } catch (IOException e) {
            productserver.close();
        }
    }

}