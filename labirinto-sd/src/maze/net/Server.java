package maze.net;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import maze.gui.server.SwingLogger;

public class Server extends UnicastRemoteObject implements IServer {
    Logger logger;
    public Server(Logger logger) throws RemoteException {
        super();
        this.logger = logger;
    }

    public String sendMsg(String msg) throws RemoteException {
        String result = "[Client]: "+ msg;
        System.out.println(result);
//        logger.log(result);
        return result; 
    }

}
