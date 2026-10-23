
import javax.swing.*;
import java.awt.*;

public class StudentForm extends JFrame {

    JTextField name = new JTextField();
    JTextField roll = new JTextField();

    JComboBox<String> dept = new JComboBox<>(
        new String[]{"ICE", "CSE", "EEE", "BBA"}
    );

    JRadioButton male = new JRadioButton("Male", true);
    JRadioButton female = new JRadioButton("Female");

    JTextArea out = new JTextArea(5, 25);

    StudentForm() {
        setTitle("Student Form");
        setSize(450, 450);
        setLayout(new BorderLayout(10, 10));

        JPanel form = new JPanel(new GridLayout(5, 2, 10, 10));

        ButtonGroup g = new ButtonGroup();
        g.add(male);
        g.add(female);

        JPanel gender = new JPanel(new FlowLayout(FlowLayout.LEFT));
        gender.add(male);
        gender.add(female);

        JButton sub = new JButton("Submit");

        form.add(new JLabel("Name:"));
        form.add(name);

        form.add(new JLabel("Roll:"));
        form.add(roll);

        form.add(new JLabel("Department:"));
        form.add(dept);

        form.add(new JLabel("Gender:"));
        form.add(gender);

        form.add(sub);
        form.add(new JLabel(""));

        out.setEditable(false);
        out.setFont(new Font("Arial", Font.PLAIN, 16));
        out.setLineWrap(true);

        JPanel outputPanel = new JPanel(new BorderLayout(5, 5));
        outputPanel.add(new JLabel("Student Information:"), BorderLayout.NORTH);
        outputPanel.add(new JScrollPane(out), BorderLayout.CENTER);

        add(form, BorderLayout.NORTH);
        add(outputPanel, BorderLayout.CENTER);

        sub.addActionListener(e -> {
            out.setText(
                "Name: " + name.getText()
                + "\nRoll: " + roll.getText()
                + "\nDepartment: " + dept.getSelectedItem()
                + "\nGender: " + (male.isSelected() ? "Male" : "Female")
            );
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new StudentForm();
    }
}
