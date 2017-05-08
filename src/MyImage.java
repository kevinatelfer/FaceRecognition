import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.io.IOException;
import java.lang.reflect.Array;

/**
 * Created by block7 on 4/10/17.
 */
public class MyImage {
    BufferedImage img = null;
    int w;
    int h;
    double[][][] rgbArray;
//    int[] pixels;

    public MyImage() {
        loadImage("/resources/images/NaturePatterns08copy.jpg");
        rgbArray = new double[h][w][3];
//        int[] pixels = ((DataBufferInt) img.getRaster().getDataBuffer()).getData();
//        System.out.println(pixels);
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

    public double[][][] readImage(BufferedImage image) {
        boolean hasAlpha = image.getColorModel().hasAlpha() != false;

        int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
        System.out.println(pixels);

        int pixelSize = hasAlpha?4:3;
        int pixelOffset = hasAlpha?1:0;

        int x = 0;
        int y = 0;

        int pixel = 0;
        int[] color = new int[3];

        for (int i = 0; i < pixels.length; i++) {
            color[0] = ((pixels[i] >> 16) & 0xff); //red
            color[1] = ((pixels[i] >> 8) & 0xff); //green
            color[0] = (pixels[i] & 0xff); //blue
            for (int j = 0; j < 3; j++) {
                double A = (x > 0 && y > 0) ? rgbArray[y-1][x-1][j] : 0;
                double B = (x > 0) ? rgbArray[y][x-1][j] : 0;
                double C = (y > 0) ? rgbArray[y-1][x][j] : 0;
                rgbArray[y][x][j] = - A + B + C + color[j];
            }
            x++;
            if(x >= w) {
                x = 0;
                y++;
            }
        }
        return  rgbArray;
    }

//    public double[][][] getArray() {
//        return rgbArray;
//    }

}
