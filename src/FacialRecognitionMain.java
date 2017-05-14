import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by block7 on 3/28/17.
 */
public class FacialRecognitionMain {
    static BufferedImage imgMain = null;
    int[] rgbArrayMain;
    String[] imageList= {"image1", "image2", "image3", "image4", "image5"};

    JFrame mainFrame;
    ImagePanel mainPanel;
    JComboBox box1;

    public FacialRecognitionMain() {
        ImagePanel panel = new ImagePanel();
        mainFrame = new JFrame();
        mainFrame.setLayout(null);

        mainPanel = new ImagePanel();
        mainFrame.setContentPane(mainPanel);
        mainPanel.setBackground(Color.BLACK);

        box1 = new JComboBox(imageList);
        box1.setLocation(5,10);
        box1.setSize(60,25);
        mainPanel.add(box1);



//        panel.drawTestImg();
        mainFrame.setVisible(true);
    }


    
    public static void main(String[] args) {
        MyImage myImage = new MyImage();
        FacialRecognitionMain rec = new FacialRecognitionMain();
        System.out.println(rec.rgbArrayMain);
        System.out.println(myImage.readImageWithGetRGB(myImage.img));

    }
}
