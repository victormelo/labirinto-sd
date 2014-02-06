package maze.gui.client;


import java.awt.FlowLayout;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import maze.net.IServer;

public class ClientGUI extends JFrame {
    JButton send;
    JTextField text;
    IServer server;
    public ClientGUI() throws RemoteException, NotBoundException {
        super("Client");
        send = new JButton("Send Message");
        text = new JTextField(20);
        setLayout(new FlowLayout());
        setSize(300, 150);
        add(text);
        add(send);
        Registry registry = LocateRegistry.getRegistry("189.70.12.111", 9090);
        server = (IServer) registry.lookup("Hello");
        send.addActionListener(new SendHandler(this));
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    
    public static void main(String[] args) {
        try {
            new ClientGUI().setVisible(true);
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NotBoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
