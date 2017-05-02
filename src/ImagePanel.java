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

        g.drawImage(myImage.getImage(), 0, 0, null);
    }

}
