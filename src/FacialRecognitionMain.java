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

    JFrame mainFrame;
    ImagePanel mainPanel;

    public FacialRecognitionMain() {
        mainFrame = new JFrame();

        mainPanel = new ImagePanel();
        mainFrame.setContentPane(mainPanel);

        mainFrame.setVisible(true);


    }


    
    public static void main(String[] args) {
        FacialRecognitionMain rec = new FacialRecognitionMain();
        ImagePanel image = new ImagePanel();
        image.analyzeRGB();
        rec.rgbArrayMain = image.rgbArray;
        System.out.println(rec.rgbArrayMain);


    }
}
