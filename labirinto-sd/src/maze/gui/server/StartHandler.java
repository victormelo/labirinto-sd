package maze.gui.server;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import maze.net.Server;


public class StartHandler implements ActionListener {
    ServerGUI tela;
    public StartHandler(ServerGUI tela) {
        this.tela = tela;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(!tela.started) {
            try {
                this.startServer();
            } catch (RemoteException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            } catch (AlreadyBoundException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            tela.startButton.setEnabled(false);
            tela.area.setText("Server started");
            tela.started = false;
        }
    }

    public void startServer() throws RemoteException, AlreadyBoundException {
        Registry registry = LocateRegistry.createRegistry(9090);
        registry.bind("Hello", new Server(new SwingLogger(tela.area)));
    }
}
