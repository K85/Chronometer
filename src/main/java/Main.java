import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Main {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Hello World");
        frame.setTitle("Chronometer");
        frame.add(new JPanel() {
            private final Chronometer chronometer = new Chronometer();
            private final JTextField startTime = new JTextField(10);
            private final JTextField endTime = new JTextField(10);
            private final JButton button = new JButton("Current Time");

            {
                this.setLayout(new GridLayout(3, 1, 10, 10));
                this.setBorder(new EmptyBorder(10, 20, 10, 20));
                this.startTime.setEditable(false);
                this.add(startTime);
                this.endTime.setEditable(false);
                this.button.addActionListener(e -> {
                    if (!endTime.getText().isEmpty()) {
                        startTime.setText("");
                        endTime.setText("");
                        chronometer.reset();
                    }

                    if (startTime.getText().isEmpty())
                        startTime.setText(Chronometer.getTimeString(chronometer.start()));
                    else endTime.setText(Chronometer.getTimeString(chronometer.stop()));
                });
                this.add(button);
                this.add(endTime);
            }

        });
        frame.setSize(260, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
