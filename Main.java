package Ex;


import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimeZone;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main extends JFrame {
    private Clock clock;

	public Main() {
    	 setTitle("Simple Clock");
         setSize(300, 300);
         setDefaultCloseOperation(EXIT_ON_CLOSE);
         setLocationRelativeTo(null);
         setLayout(new BorderLayout());

         JPanel panel = new JPanel();
         panel.setLayout(new FlowLayout());

         JTextField timezoneTextField = new JTextField(10);
         JButton openButton = new JButton("Open");

         panel.add(timezoneTextField);
         panel.add(openButton);

         clock = new Clock(TimeZone.getDefault().getID());
         add(clock, BorderLayout.CENTER);
         add(panel, BorderLayout.SOUTH);

         openButton.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 String timezone = timezoneTextField.getText();
                 createNewClock(timezone);
             }
         });

         clock.Start();
     }
    private void createNewClock(String timezone) {
    	 Clock newClock = new Clock(timezone);
         JFrame newFrame = new JFrame("Clock - " + timezone);
         newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
         newFrame.setLayout(new BorderLayout());
         newFrame.add(newClock, BorderLayout.CENTER);
         newFrame.pack();
         newFrame.setLocationRelativeTo(null);
         newFrame.setVisible(true);
         newClock.Start();
     
    }

    public static void main(String[] args) {
    	 SwingUtilities.invokeLater(new Runnable() {
             @Override
             public void run() {
                 new Main().setVisible(true);
             }
         });
    }
}