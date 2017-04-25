import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.lang.reflect.Array;

/**
 * Created by block7 on 4/10/17.
 */
public class MyImage {
    BufferedImage img = null;
    int[] rgbArray = new int[100];

    public MyImage() {

    }

    public BufferedImage loadImage() {
        try {
            img = ImageIO.read(ImagePanel.class.getResource("/resources/images/NaturePatterns08copy.jpg"));
            System.out.println("image loaded");

        } catch (IOException e) {
            System.out.println(e);

        }
        return img;
    }

    public BufferedImage getImage() {
    return img;
    }

    public void readImage() {

    }

    public int[] getArray() {
        return rgbArray;
    }

}
