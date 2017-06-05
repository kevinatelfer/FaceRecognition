import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Created by block7 on 3/28/17.
 */
public class FacialRecognitionMain implements ActionListener {
    static BufferedImage imgMain = null;
    int[] rgbArrayMain;
    String[] imageList= {"image1", "image2", "image3", "image4", "image5"};
    String choice;

    JFrame mainFrame;
    ImagePanel mainPanel;
    JComboBox box1;
    JComboBox box2;
    JLabel title;

    static boolean draw1 = false;

    public FacialRecognitionMain() {
        mainFrame = new JFrame();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(1000,700);

        ImagePanel panel = new ImagePanel();
        mainPanel = new ImagePanel();
        mainFrame.setContentPane(mainPanel);
        mainPanel.setBackground(Color.lightGray);

        mainFrame.setLayout(null);

        box1 = new JComboBox(imageList);
        box1.setBounds(200,100,100,30);
        mainPanel.add(box1);
        box1.addActionListener(this);

        box2 = new JComboBox(imageList);
        box2.setBounds(700,100,100,30);
        mainPanel.add(box2);
        box2.addActionListener(this);

        title = new JLabel("Face Authenticator");
        title.setBounds(320, 10, 450,40);
        title.setFont(title.getFont().deriveFont(40.0f));
        title.setForeground(Color.CYAN);
        mainPanel.add(title);

        mainFrame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == box1) {
            choice = box1.getSelectedItem().toString();
            System.out.println("choice " + choice);
            setDrawTrue();
        }
        if (e.getSource() == box2) {
            choice = box2.getSelectedItem().toString();
            System.out.println("choice " + choice);
            setDrawTrue();
        }

    }

    public void setDrawTrue() {
        if (choice.equals("image1")) {
            draw1 = true;
        }
    }


    
    public static void main(String[] args) {
        MyImage myImage = new MyImage();
        FacialRecognitionMain rec = new FacialRecognitionMain();
        ImageCalc calc = new ImageCalc();

        System.out.println(rec.rgbArrayMain);

        myImage.readImageWithGetRGB(myImage.getSourceImg(), myImage.getSourceH(), myImage.getSourceW(), myImage.getSourceRGBArray());
        System.out.println("Test Image:");
        myImage.readImageWithGetRGB(myImage.getTestImg(), myImage.getTestH(),myImage.getTestW(), myImage.getTestRGBArray());
//        calc.simpleCompare(myImage.getSourceRGBArray(), myImage.getTestRGBArray(), myImage.getSourceH(), myImage.getSourceW());
//        myImage.resizeDimensions();
    }
}
