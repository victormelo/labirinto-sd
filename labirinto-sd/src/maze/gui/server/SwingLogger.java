package maze.gui.server;

import javax.swing.JTextArea;

import maze.net.Logger;

public class SwingLogger implements Logger{
    
    public JTextArea area;
    public SwingLogger(JTextArea area) {
        this.area = area;
        
    }
    public void log(String msg) {
        this.area.setText(this.area.getText() +  "\n" + msg);
    }

}
