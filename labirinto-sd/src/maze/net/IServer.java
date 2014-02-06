package maze.net;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IServer extends Remote {
    public String sendMsg(String msg) throws RemoteException;
}
