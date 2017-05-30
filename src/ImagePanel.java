import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by block7 on 4/3/17.
 */
public class ImagePanel extends JPanel {
//    FacialRecognitionMain rec = new FacialRecognitionMain();

    public ImagePanel() {
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawLine(500,0,500,700);
        g.drawLine(250,0,250,700);
        g.drawLine(750,0,750,700);
        if (FacialRecognitionMain.draw1) {
//            myImage.loadImage("/resources/images/ThreeColor.jpg");
//            g.drawImage(MyImage.sourceImg, 50, 200, MyImage.resizeSourceW, MyImage.resizeSourceH, null);
//            System.out.println("rw " + MyImage.resizeSourceW);
//            System.out.println("rw" + MyImage.resizeSourceH);
        }
    }

//    public void drawTestImg(Graphics g, BufferedImage image) {
//        g.drawImage(image, 100, 100, myImage.getAdjustedW(), myImage.getAdjustedH(), null);
//    }

}
