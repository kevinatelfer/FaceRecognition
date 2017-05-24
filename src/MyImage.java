import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.DataBufferInt;
import java.io.IOException;
import java.lang.reflect.Array;

/**
 * Created by block7 on 4/10/17.
 */
public class MyImage {
    static BufferedImage sourceImg = null;
    static BufferedImage testImg = null;
    static int sourceW;
    static int sourceH;
    static int testW;
    static int testH;
//    int adjustedW;
//    int adjustedH;
    static int[][][] sourceRGBArray;
    static int[][][] testRGBArray;
//    int[][] result;
//    int[] pixels;

    public MyImage() {
        loadSourceImage("/resources/images/TinyImage.jpg");
        loadTestImage("/resources/images/TinyImageComp.jpg");

        this.sourceW = sourceImg.getWidth();
        this.sourceH = sourceImg.getHeight();
        this.testW = testImg.getWidth();
        this.testH = testImg.getHeight();
//        adjustedH = h / 6;
//        adjustedW = w / 6;
        System.out.println("source width " + sourceW);
        System.out.println("source height " + sourceH);
        System.out.println("test width " + testW);
        System.out.println("test height " + testH);
        sourceRGBArray = new int[3*sourceH][sourceW][3];
        testRGBArray = new int[3*testH][testW][3];
//        result = new int[h][w];
    }

    public static void loadSourceImage(String path) {
        try {
            sourceImg = ImageIO.read(ImagePanel.class.getResource(path));
            System.out.println("image loaded");

        } catch (IOException e) {
            System.out.println(e);

        }
    }

    public static void loadTestImage(String path) {
        try {
            testImg = ImageIO.read(ImagePanel.class.getResource(path));
            System.out.println("image loaded");

        } catch (IOException e) {
            System.out.println(e);

        }
    }

    public BufferedImage getSourceImg() {
        return sourceImg;
    }

    public BufferedImage getTestImg() {
        return testImg;
    }

    public int[][][] getSourceRGBArray() {
        return sourceRGBArray;
    }

    public int[][][] getTestRGBArray() {
        return testRGBArray;
    }

    public int getSourceH() {
        return sourceH;
    }

    public int getSourceW() {
        return sourceW;
    }

    public int getTestH() {
        return testH;
    }

    public int getTestW() {
        return testW;
    }

//    public int getAdjustedW() {
//        return adjustedW;
//    }
//
//    public int getAdjustedH() {
//        return adjustedH;
//    }

    public static int[][][] readImageWithGetRGB(BufferedImage image, int h, int w, int[][][] rgbArray) {
        Color myColor;

        int[] color = new int[3];

        for (int i = 0; i < h; i++){
            for (int j = 0; j < w; j++) {
                myColor = new Color(image.getRGB(j,i));
                color[0] = myColor.getRed();
                color[1] = myColor.getGreen();
                color[2] = myColor.getBlue();
                for (int k = 0; k < 3; k++ ) {
                    rgbArray[i][j][k] = color[k];
                }
            }
        }
        print3DArray(rgbArray, h, w);
        return rgbArray;
    }

//    public int[][][] readImage(BufferedImage image) {
////        image = new BufferedImage(w,h,BufferedImage.TYPE_INT_RGB);
//        boolean hasAlpha = image.getAlphaRaster() != null;
//
//        byte[] pixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
//        for (int i = 0; i < pixels.length; i++){
////            System.out.println(pixels[i]);
//            System.out.println(String.format("%06X", pixels[i]));
//        }
//
//        int pixelSize = hasAlpha?4:3;
//        int pixelOffset = hasAlpha?1:0;
//
//        int x = 0;
//        int y = 0;
//
//        int pixel = 0;
//        int[] color = new int[3];
//
//        System.out.println("pix leng " + pixels.length);
//        for (int i = 0; i < pixels.length; i++) {
////            System.out.println(String.format("%06X", pixels[i]));
//            color[0] = ((pixels[i] >> 16) & 0xff); //red
////            System.out.println("color 0 " + color[0]);
//            color[1] = ((pixels[i] >> 8) & 0xff); //green
////            System.out.println("color 1 " + color[1]);
//            color[2] = (pixels[i] & 0xff); //blue
////            System.out.println("color 2 " + color[2]);
//            for (int j = 0; j < 3; j++) {
////                System.out.println("color j " + color[j]);
////                rgbArray[y][x][j] = - A + B + C + color[j];
//                rgbArray[y][x][j] = color[j];
//            }
//            x++;
//            if(x >= w) {
//                x = 0;
//                y++;
//            }
//        }
//        print3DArray(rgbArray);
//        return  rgbArray;
//    }

    public static void print3DArray(int[][][] rgbArray, int h, int w) {
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

//    public void print2DArray(int[][] array) {
//        for (int i = 0; i < h; i++) {
//            for (int j = 0; j < w; j++) {
//                System.out.print("arr[" + i + "][" + j + "] = " + result[i][j] + " ");
//            }
//            System.out.println();
//        }
//    }

}
