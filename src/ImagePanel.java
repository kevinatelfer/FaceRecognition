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
    BufferedImage img = null;

    public ImagePanel() {
        try {
            img = ImageIO.read(ImagePanel.class.getResource("/resources/images/NaturePatterns08copy.jpg"));
            System.out.println("image loaded");

        } catch (IOException e) {
            System.out.println(e);

        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawLine(40,60,40,250);
        g.drawImage(img, 0, 0, null);
    }


}
