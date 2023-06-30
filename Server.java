import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    public static class closingResources extends Thread{
        ExecutorService pool;

        public closingResources(){
            pool = Executors.newCachedThreadPool();
        }

        public ExecutorService getPool(){
            return pool;
        }

        @Override
        public void run(){
            pool.shutdown();
            System.out.println("Server closed.");
        }
    }
    public static void main(String[] args) {
        closingResources cR=new closingResources();
        Runtime.getRuntime().addShutdownHook(cR);
        ExecutorService pool = cR.getPool();
        try (ServerSocket welcomingSocket = new ServerSocket(5757)) {
            System.out.println("Server opened.");
            while (true) {
                Socket connectionSocket = welcomingSocket.accept();
                pool.execute(new ClientHandler(connectionSocket));
            }
            
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}
// TODO:add config file