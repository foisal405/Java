
import javax.swing.*;
import java.awt.*;

public class Simple_Calculator extends JFrame {
    JTextField t = new JTextField();
    double a;
    String op = "";

    Simple_Calculator() {
        setTitle("Calculator");
        setLayout(new BorderLayout());
        add(t, "North");

        JPanel p = new JPanel(new GridLayout(4, 4));
        String[] k = {"7","8","9","/","4","5","6","*",
                      "1","2","3","-","AC","0","=","+"};

        for (String s : k) {
            JButton b = new JButton(s);
            p.add(b);

            b.addActionListener(e -> {
                if (s.equals("AC")) {
                    t.setText("");
                    a = 0;
                    op = "";
                }
                else if (s.equals("=")) {
                    double b1 = Double.parseDouble(t.getText());
                    double r = 0;
                    if (op.equals("+")) r = a + b1;
                    if (op.equals("-")) r = a - b1;
                    if (op.equals("*")) r = a * b1;
                    if (op.equals("/")) r = a / b1;
                    t.setText("" + r);
                } else if ("+-*/".contains(s)) {
                    a = Double.parseDouble(t.getText());
                    op = s;
                    t.setText("");
                } else {
                    t.setText(t.getText() + s);
                }
            });
        }

        add(p, "Center");
        setSize(250, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Simple_Calculator();
    }
}