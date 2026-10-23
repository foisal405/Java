
import javax.swing.*;
import java.awt.*;

public class RestaurantBill extends JFrame {

    JTextField burger, pizza, pasta;
    JTextArea bill;

    RestaurantBill() {
        setTitle("Restaurant Bill");
        setSize(400, 400);
        setLayout(new FlowLayout());

        add(new JLabel("Burger (150):"));
        burger = new JTextField("0", 5);
        add(burger);

        add(new JLabel("Pizza (450):"));
        pizza = new JTextField("0", 5);
        add(pizza);

        add(new JLabel("Pasta (300):"));
        pasta = new JTextField("0", 5);
        add(pasta);

        JButton gen = new JButton("Generate Bill");
        JButton reset = new JButton("Reset");
        add(gen);
        add(reset);

        bill = new JTextArea(12, 30);
        bill.setEditable(false);
        add(new JScrollPane(bill));

        gen.addActionListener(e -> generateBill());

        reset.addActionListener(e -> {
            burger.setText("0");
            pizza.setText("0");
            pasta.setText("0");
            bill.setText("");
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    void generateBill() {
        try {
            int b = Integer.parseInt(burger.getText());
            int p = Integer.parseInt(pizza.getText());
            int pa = Integer.parseInt(pasta.getText());

            double sub = b * 150 + p * 450 + pa * 300;
            double vat = sub * 0.15;
            double total = sub + vat;

            bill.setText(
                "===== RESTAURANT BILL =====\n" +
                "Burger: " + b * 150 + "\n" +
                "Pizza: " + p * 450 + "\n" +
                "Pasta: " + pa * 300 + "\n" +
                "---------------------------\n" +
                "Subtotal: " + sub + "\n" +
                "VAT (15%): " + vat + "\n" +
                "Grand Total: " + total + "\n" +
                "Thank You!"
            );

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                "Enter valid quantities!");
        }
    }

    public static void main(String[] args) {
        new RestaurantBill();
    }
}
