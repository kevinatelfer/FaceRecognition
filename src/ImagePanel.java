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
//        g.drawLine(500,0,500,700);
//        g.drawLine(250,0,250,700);
//        g.drawLine(750,0,750,700);
        g.drawImage(MyImage.sourceImg, 50, 200, 400, 225, null);
        g.drawImage(MyImage.testImg, 550, 200, 400, 225, null);
//        if (FacialRecognitionMain.drawKevSource1) {
//            g.drawImage(MyImage.sourceImg, 50, 200, 400, 225, null);
//        } else if (FacialRecognitionMain.drawKevTest1) {
//            g.drawImage(MyImage.sourceImg, 50, 200, 400, 225, null);
//        }
    }

//    public void drawTestImg(Graphics g, BufferedImage image) {
//        g.drawImage(image, 100, 100, myImage.getAdjustedW(), myImage.getAdjustedH(), null);
//    }

}
