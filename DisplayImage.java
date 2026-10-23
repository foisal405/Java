
import javax.swing.*;

class DisplayImage {
    public static void main(String[] args) {
        JFrame f = new JFrame("Image");
        f.add(new JLabel(new ImageIcon("images.jpg")));
        f.setSize(800, 700);
        f.setVisible(true);
    }
}