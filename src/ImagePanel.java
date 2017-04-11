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
    int[] rgbArray = new int[100];

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

    public void analyzeRGB() {
        img.getRGB(0,0,10,10,rgbArray,0,1);
//        System.out.println("type " + img.getType());
//
//        img = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_ARGB);
//        System.out.println("type2 " + img.getType());
        for (int i = 0; i <rgbArray.length; i++) {
            System.out.print(rgbArray[i] + ",");
        }
        System.out.println();

//        System.out.println(c.getRed());
//        System.out.println(c.getGreen());
//        System.out.println(c.getBlue());
//        System.out.println(c.getAlpha());
    }

}
