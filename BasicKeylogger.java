import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;

public class BasicKeylogger extends JFrame implements KeyListener {

    FileWriter logger;

    public BasicKeylogger() {
        setTitle("Keylogger - Educational Use Only");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JTextArea textArea = new JTextArea();
        textArea.addKeyListener(this);
        add(textArea);
        setVisible(true);

        try {
            logger = new FileWriter("keylog.txt", true);
        } catch (IOException e) {
            System.out.println("Could not open file for logging.");
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        try {
            logger.write(e.getKeyChar());
            logger.flush();
        } catch (IOException ex) {
            System.out.println("Error writing to log file.");
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {}
    @Override
    public void keyReleased(KeyEvent e) {}

    public static void main(String[] args) {
        new BasicKeylogger();
    }
}
