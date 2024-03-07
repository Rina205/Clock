package Ex;

import javax.swing.JFrame;



import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Clock extends JPanel {
    private JLabel timeLabel;
    private String timezone;

    public Clock(String timezone) {
    	this.timezone= timezone;
        setBounds(0,0,200,100);
        setLayout(new FlowLayout());

        timeLabel = new JLabel();
        add(timeLabel);
    }

    public void Start() {
        new Thread(()->{
            while (true) {
                updateTime();
                try {
					Thread.sleep(1000);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
            }
        }).start();
    }

    private void updateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        dateFormat.setTimeZone(TimeZone.getTimeZone(timezone));
        timeLabel.setText(dateFormat.format(new Date()));
    }


}
