import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class SumCalculatorApplet extends Applet implements ActionListener {
    TextField num1Field, num2Field;
    Button calculateButton;
    Label resultLabel;

    public void init() {
        num1Field = new TextField(10);
        num2Field = new TextField(10);
        calculateButton = new Button("Calculate Sum");
        resultLabel = new Label("Sum will be displayed here");

        add(new Label("Enter number 1:"));
        add(num1Field);
        add(new Label("Enter number 2:"));
        add(num2Field);
        add(calculateButton);
        add(resultLabel);

        calculateButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == calculateButton) {
            try {
                int num1 = Integer.parseInt(num1Field.getText());
                int num2 = Integer.parseInt(num2Field.getText());

                int sum = num1 + num2;

                resultLabel.setText("The sum is: " + sum);
            } catch (NumberFormatException e) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }

    public void paint(Graphics g) {
        g.drawString("This is in applet window", 10, 20);
    }
}
