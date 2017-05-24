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

    static boolean draw1 = false;

    public FacialRecognitionMain() {
        mainFrame = new JFrame();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(500,400);


        ImagePanel panel = new ImagePanel();
        mainPanel = new ImagePanel();
        mainFrame.setContentPane(mainPanel);
        mainPanel.setBackground(Color.BLACK);

        mainFrame.setLayout(null);

        box1 = new JComboBox(imageList);
        box1.setBounds(50,20,70,20);
//        box1.setLocation(5,10);
//        box1.setSize(60,25);
        mainPanel.add(box1);
        box1.addActionListener(this);

        mainFrame.setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == box1) {
            choice = box1.getSelectedItem().toString();
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
//        myImage.loadSourceImage("/resources/images/ThreeColor.jpg");
//        myImage.loadTestImage("/resources/images/ThreeColor.jpg");
        System.out.println(rec.rgbArrayMain);
//        System.out.println(myImage.readImageWithGetRGB(myImage.getSourceImg(), myImage.getSourceH(),myImage.getSourceW(), myImage.getSourceRGBArray()));
//        System.out.println(myImage.readImageWithGetRGB(myImage.getTestImg(), myImage.getTestH(),myImage.getTestW(), myImage.getTestRGBArray()));
        myImage.readImageWithGetRGB(myImage.getSourceImg(), myImage.getSourceH(),myImage.getSourceW(), myImage.getSourceRGBArray());
        System.out.println("Test Image:");
        myImage.readImageWithGetRGB(myImage.getTestImg(), myImage.getTestH(),myImage.getTestW(), myImage.getTestRGBArray());
//        System.out.println("reading finished");
        calc.simpleCompare(myImage.getSourceRGBArray(), myImage.getTestRGBArray(), myImage.getSourceH(), myImage.getSourceW());


    }
}
