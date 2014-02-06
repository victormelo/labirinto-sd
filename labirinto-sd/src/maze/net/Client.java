package maze.net;

import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    
    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry("189.70.12.111", 9090);
        IServer server = (IServer) registry.lookup("Hello");
        
        System.out.println(server.sendMsg("Victor"));
    }
}
