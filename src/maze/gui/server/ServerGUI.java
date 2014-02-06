package maze.gui.server;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import maze.net.Server;


public class ServerGUI extends JFrame {
    JButton startButton;
    JTextArea area;
    JScrollPane scrollPane;
    boolean started = false;
    
    public ServerGUI() {
        
        startButton = new JButton("Start Server");
        area = new JTextArea(15, 20);
        area.setEditable(false);
        scrollPane = new JScrollPane(area);
        setLayout(new FlowLayout());
        setSize(300, 300);
        add(startButton);
        add(scrollPane);

        startButton.addActionListener(new StartHandler(this));
        
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    
    public static void main(String[] args) {
        new ServerGUI().setVisible(true);
    }
}
