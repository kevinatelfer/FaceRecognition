import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.lang.reflect.Array;

/**
 * Created by block7 on 4/10/17.
 */
public class MyImage {
    BufferedImage img = null;
    int[] rgbArray;

    public MyImage() {

    }

    public void loadImage(String path) {
        try {
            img = ImageIO.read(ImagePanel.class.getResource(path));
            System.out.println("image loaded");

        } catch (IOException e) {
            System.out.println(e);

        }
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
