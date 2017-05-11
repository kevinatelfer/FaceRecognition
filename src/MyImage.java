import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
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
//        loadImage("/resources/images/NaturePatterns08copy.jpg");
        loadImage("/resources/images/ThreeColor.jpg");

//        int[] pixels = ((DataBufferInt) img.getRaster().getDataBuffer()).getData();
//        System.out.println(pixels);
        this.w = img.getWidth();
        this.h = img.getHeight();
        System.out.println("width " + w);
        System.out.println("height " + h);
        rgbArray = new double[3*h][w][3];


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
//        image = new BufferedImage(w,h,BufferedImage.TYPE_INT_RGB);
        boolean hasAlpha = image.getColorModel().hasAlpha() != false;

        byte[] pixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
//        for (int i = 0; i < pixels.length; i++){
//            System.out.println(pixels[i]);
//        }

        int pixelSize = hasAlpha?4:3;
        int pixelOffset = hasAlpha?1:0;

        int x = 0;
        int y = 0;

        int pixel = 0;
        int[] color = new int[3];

        System.out.println("pix leng " + pixels.length);
        for (int i = 0; i < pixels.length; i++) {
            color[0] = ((pixels[i] >> 16) & 0xff); //red
//            System.out.println("color 0 " + color[0]);
            color[1] = ((pixels[i] >> 8) & 0xff); //green
//            System.out.println("color 1 " + color[1]);
            color[2] = (pixels[i] & 0xff); //blue
//            System.out.println("color 2 " + color[2]);
            for (int j = 0; j < 3; j++) {
//                double A = (x > 0 && y > 0) ? rgbArray[y-1][x-1][j] : 0;
//                double B = (x > 0) ? rgbArray[y][x-1][j] : 0;
//                double C = (y > 0) ? rgbArray[y-1][x][j] : 0;
//                System.out.println("x" + x);
//                System.out.println("y" + y);
//                System.out.println("j" + j);

//                System.out.println("color j " + color[j]);
//                rgbArray[y][x][j] = - A + B + C + color[j];
                rgbArray[y][x][j] = color[j];
            }
            x++;
            if(x >= w) {
                x = 0;
                y++;
            }

        }
        printArray(rgbArray);
        return  rgbArray;
    }

    public void printArray(double[][][] array) {
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++){
                for (int k = 0; k < 3; k++) {
                    System.out.print("arr[" + i + "][" + j + "][" + k + "] = " + rgbArray[i][j][k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

}
