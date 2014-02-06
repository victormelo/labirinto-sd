package maze.gui.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import maze.net.IServer;

public class SendHandler implements ActionListener {
    ClientGUI clientGUI;
    public SendHandler(ClientGUI clientGUI) {
        this.clientGUI = clientGUI;
    }

    public void actionPerformed(ActionEvent e) {
        try {
            this.clientGUI.server.sendMsg(this.clientGUI.text.getText());
        } catch (RemoteException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

}
