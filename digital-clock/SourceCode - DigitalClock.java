package AllTasks;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class DigitalClock extends JFrame {

	private static final long serialVersionUID = 1L;
	
	
	JLabel clockInfo;
    TimerThread timer;

    public DigitalClock() {

        // initializing the label
        clockInfo = new JLabel("");

        // initializing the thread that updates the clock time
        timer = new TimerThread(this);

        // setting up the frame
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(clockInfo);
        setSize(640, 80);

        // center the frame on the screen
        setLocationRelativeTo(null);

        // Setting up the font and color properties
        clockInfo.setFont(new Font("Arial", Font.ITALIC, 32));
        clockInfo.setOpaque(true);
        clockInfo.setBackground(Color.LIGHT_GRAY);

        setVisible(true);
    }

    public static void main(String... args) {

        new DigitalClock();

    }

}
