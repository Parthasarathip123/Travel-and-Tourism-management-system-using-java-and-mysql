package travelwebsite1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class destinations extends JFrame implements Runnable {

    Thread t1;
    JLabel caption;
    JLabel[] label = new JLabel[10];

    public void run(){
        String[] text = new String[]{"manali", "ladakh","Napoli", "Miami", "Los Vegas", "New York", "Berlin", "Barcelona", "Austin","Hampi",};

        try {
            for (int i = 0; i < 10; i++) {
                if (label[i] != null) {
                    label[i].setVisible(true);
                    caption.setText(text[i]);
                    Thread.sleep(2000);
                    label[i].setVisible(false);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    destinations() {
        setBounds(300, 100, 800, 600);
        caption = new JLabel();
        caption.setBounds(50, 500, 1000, 70);
        caption.setFont(new Font("Tahoma", Font.PLAIN, 40));
        caption.setForeground(Color.WHITE);
        add(caption);

        ImageIcon[] image = new ImageIcon[10];

        for (int i = 0; i < 10; i++) {
            try {
                image[i] = new ImageIcon(ClassLoader.getSystemResource("icons/dest" + (i + 1) + ".jpg"));
                Image jimage = image[i].getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT);
                ImageIcon kimage = new ImageIcon(jimage);
                label[i] = new JLabel(kimage); // Initialize each element of the label array
                label[i].setBounds(5, 0, 800, 600);
                label[i].setVisible(false);
                add(label[i]);
            } catch (Exception e) {
                System.out.println("Image not found for dest" + (i + 1) + ".jpg. Skipping...");
                label[i] = null; // Set the element to null if image loading fails
            }
        }
        t1 = new Thread(this);
        t1.start();

        setVisible(true);
    }

    public static void main(String[] args) {
        new destinations();
    }
}
