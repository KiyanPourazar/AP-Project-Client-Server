package ClientModel;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import Utility.DataObject;

public class DataManager{
    public static DataObject sendData(DataObject dataObject){
        try (Socket client = new Socket("127.0.0.1", 5757)) {
            // System.out.println("Connected to server.");
            ObjectOutputStream out=new ObjectOutputStream(client.getOutputStream());
            ObjectInputStream in=new ObjectInputStream(client.getInputStream());
            out.writeObject(dataObject);
            dataObject=(DataObject)in.readObject();
            return dataObject;
        } catch (IOException | ClassNotFoundException ex) {
            System.err.println(ex);
            return null;
        }
    }
}