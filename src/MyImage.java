import java.awt.image.BufferedImage;
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
