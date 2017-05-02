import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.lang.reflect.Array;

/**
 * Created by block7 on 4/10/17.
 */
public class MyImage {
    BufferedImage img = null;
    int w;
    int h;
    int[][][] rgbArray = new int[h][w][3];

    public MyImage() {
        loadImage("/resources/images/NaturePatterns08copy.jpg");
        this.w = img.getWidth();
        this.h = img.getHeight();
        System.out.println("width " + w);
        System.out.println("height " + h);

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

    public int[][][] getArray() {
        return rgbArray;
    }

}
