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
    MyImage myImage = new MyImage();

    public ImagePanel() {
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(myImage.getImage(), 100, 100, myImage.getAdjustedW(), myImage.getAdjustedH(), null);

    }

    public void drawTestImg(Graphics g, BufferedImage image) {
        g.drawImage(image, 100, 100, myImage.getAdjustedW(), myImage.getAdjustedH(), null);
    }

}
