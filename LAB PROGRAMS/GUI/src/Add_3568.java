import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Add_3568 extends JFrame implements ActionListener {
    JLabel num1, num2, res;
    JTextField n1, n2;
    JTextField r;
    JButton add;
    Add_3568(){
        setTitle("Calculator");

        num1 = new JLabel("Number 1");
        num2 = new JLabel("Number 2");
        res = new JLabel("Result");

        n1 = new JTextField(10);
        n2 = new JTextField(10);
        r = new JTextField(10);

        //add = new JButton(new ImageIcon("C:\\Users\\2021503568\\Downloads\\add.png"));
        add = new JButton("+");
        add.setBounds(30, 30, 300, 50);
        r.setEditable(false);

        add(num1);
        add(n1);
        add(num2);
        add(n2);
        add(add);
        add(res);
        add(r);

        add.addActionListener(this);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setSize(300,300);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        try{
            int a = Integer.parseInt(n1.getText());
            int b = Integer.parseInt(n2.getText());
            r.setText(String.valueOf(a+b));
        }
        catch (NumberFormatException e1){
            r.setText("Invalid Input");
        }
    }

    public static void main(String[] args){
        Add_3568 q = new Add_3568();
    }
}
