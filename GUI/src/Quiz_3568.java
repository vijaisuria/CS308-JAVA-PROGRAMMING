import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class QuizApp extends JFrame implements ActionListener {
    JPanel qPanel, resPanel;
    JLabel ql1, ql2, ql3, ql4, ql5, res;
    JTextField score;
    private JRadioButton[] radioButtons;
    private JCheckBox[] checkBoxes;
    ButtonGroup radioGroup;
    JButton submit, ok;
    JDialog result;

    QuizApp() {
        radioButtons = new JRadioButton[4];
        checkBoxes = new JCheckBox[4];
        result = new JDialog(this, "Score", false);

        JPanel q1, q2, q3, q4, q5;

        ql1 = new JLabel("Who is the father of Java?");
        q1 = new JPanel(new GridLayout(2, 4));
        radioButtons[0] = new JRadioButton("James Gosling");
        radioButtons[1] = new JRadioButton("Mark Zuckerberg");
        radioButtons[2] = new JRadioButton("Bill Gates");
        radioButtons[3] = new JRadioButton("Linus Torvalds");
        radioGroup = new ButtonGroup();
        for (JRadioButton radioButton : radioButtons) {
            radioGroup.add(radioButton);
        }
        q1.add(radioButtons[0]);
        q1.add(radioButtons[1]);
        q1.add(radioButtons[2]);
        q1.add(radioButtons[3]);

        ql2 = new JLabel("What are the advantages of Java?");
        q2 = new JPanel(new GridLayout(2, 4));
        checkBoxes[0] = new JCheckBox("Platform Independent");
        checkBoxes[1] = new JCheckBox("Simple");
        checkBoxes[2] = new JCheckBox("Robust");
        checkBoxes[3] = new JCheckBox("Presence of Pointers");
        q2.add(checkBoxes[0]);
        q2.add(checkBoxes[1]);
        q2.add(checkBoxes[2]);
        q2.add(checkBoxes[3]);

        ql3 = new JLabel("What is the main feature of OOP?");
        q3 = new JPanel(new GridLayout(2, 4));
        radioButtons[0] = new JRadioButton("Encapsulation");
        radioButtons[1] = new JRadioButton("Inheritance");
        radioButtons[2] = new JRadioButton("Polymorphism");
        radioButtons[3] = new JRadioButton("Abstraction");
        radioGroup = new ButtonGroup();
        for (JRadioButton radioButton : radioButtons) {
            radioGroup.add(radioButton);
        }
        q3.add(radioButtons[0]);
        q3.add(radioButtons[1]);
        q3.add(radioButtons[2]);
        q3.add(radioButtons[3]);

        ql4 = new JLabel("What is a constructor in Java?");
        q4 = new JPanel(new GridLayout(2, 4));
        checkBoxes[0] = new JCheckBox("A special method used to initialize objects");
        checkBoxes[1] = new JCheckBox("A static variable");
        checkBoxes[2] = new JCheckBox("A loop structure");
        checkBoxes[3] = new JCheckBox("A data type");
        q4.add(checkBoxes[0]);
        q4.add(checkBoxes[1]);
        q4.add(checkBoxes[2]);
        q4.add(checkBoxes[3]);

        ql5 = new JLabel("Which of the following is a collection in Java?");
        q5 = new JPanel(new GridLayout(2, 4));
        checkBoxes[0] = new JCheckBox("ArrayList");
        checkBoxes[1] = new JCheckBox("HashMap");
        checkBoxes[2] = new JCheckBox("String");
        checkBoxes[3] = new JCheckBox("int");
        q5.add(checkBoxes[0]);
        q5.add(checkBoxes[1]);
        q5.add(checkBoxes[2]);
        q5.add(checkBoxes[3]);

        submit = new JButton("Submit");
        submit.setBounds(30, 30, 120, 50);
        submit.addActionListener(this);

        qPanel = new JPanel(new GridLayout(10, 1, 20, 20));
        qPanel.add(ql1);
        qPanel.add(q1);
        qPanel.add(ql2);
        qPanel.add(q2);
        qPanel.add(ql3);
        qPanel.add(q3);
        qPanel.add(ql4);
        qPanel.add(q4);
        qPanel.add(ql5);
        qPanel.add(q5);
        qPanel.add(submit);

        resPanel = new JPanel(new FlowLayout());
        res = new JLabel("Results");
        score = new JTextField(30);
        resPanel.add(res);
        resPanel.add(score);

        ok = new JButton("OK");
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                result.setVisible(false);
            }
        });
        result.add(ok);

        setVisible(true);
        setLayout(new BorderLayout());
        setSize(800, 500);

        add(qPanel, BorderLayout.NORTH);
        add(resPanel, BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent e) {
        int c = 0;
        if (radioButtons[0].isSelected()) {
            c++;
        }
        if (checkBoxes[0].isSelected() && checkBoxes[1].isSelected() && checkBoxes[2].isSelected()) {
            c++;
        }
        if (radioButtons[3].isSelected()) {
            c++;
        }
        if (checkBoxes[0].isSelected()) {
            c++;
        }
        if (checkBoxes[0].isSelected() && checkBoxes[1].isSelected()) {
            c++;
        }
        score.setText(String.valueOf(c));
        result.add(new JLabel("Score: " + c));
        result.setLayout(new FlowLayout());
        result.setSize(300, 300);
        result.setVisible(true);
    }

    public static void main(String[] args) {
        new QuizApp();
    }
}
