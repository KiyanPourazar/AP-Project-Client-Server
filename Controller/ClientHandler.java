import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import Utility.DataObject;

class ClientHandler implements Runnable {

    private Socket connectionSocket;

    public ClientHandler(Socket connectionSocket) {
        this.connectionSocket = connectionSocket;
    }

    @Override
    public void run() {
        DataObject dataObject=null;
        try {
            ObjectOutputStream out=new ObjectOutputStream(connectionSocket.getOutputStream());
            ObjectInputStream in=new ObjectInputStream(connectionSocket.getInputStream());
            dataObject=(DataObject)in.readObject();
            dataObject=ServerDataManager.runMethod(dataObject);
            out.writeObject(dataObject);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}