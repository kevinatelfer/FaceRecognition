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
    static int resizeSourceH;
    static int resizeSourceW;
    static int resizeTestH;
    static int resizeTestW;

    static int[][][] sourceRGBArray;
    static int[][][] testRGBArray;
//    int[][] result;
//    int[] pixels;

    public MyImage() {
//        loadSourceImage("KevSource");
//        loadTestImage("DadSource");

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
//        sourceRGBArray = new int[3*520][451][3];
//        testRGBArray = new int[3*520][451][3];
        sourceRGBArray = new int[3*520][451][3];
        testRGBArray = new int[3*520][451][3];
    }

    public static void loadSourceImage(String sourceName) {
        try {
            sourceImg = ImageIO.read(ImagePanel.class.getResource("/resources/images/" + sourceName + ".jpg"));
            System.out.println("image loaded");
            System.out.println("sourceImg " + MyImage.sourceImg);

        } catch (IOException e) {
            System.out.println(e);

        }
    }

    public static void loadTestImage(String testName) {
        try {
            testImg = ImageIO.read(ImagePanel.class.getResource("/resources/images/" + testName + ".jpg"));
            System.out.println("image loaded");
            System.out.println("testImg " + MyImage.testImg);

        } catch (IOException e) {
            System.out.println(e);
        }
    }

//    public void resizeDimensions() {
//        boolean done = true;
//        int i = 1;
//        int j = 1;
//        while (!(sourceW*i == 400) || i*sourceH > 500 || i*sourceH > 500) {
//            i++;
//            System.out.println("i" + i);
//        }
//        while (!(testW*j < 400 || j*testH > 500 || i*sourceH > 500)) {
//            j++;
//        }
//        resizeSourceW = sourceW*i;
//        resizeSourceH = sourceH*i;
//        resizeTestW = resizeTestW*j;
//        resizeTestH = resizeTestH*j;
//    }


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

    public static int[][][] readImageWithGetRGB(BufferedImage image, int h, int w, int[][][] rgbArray) {
        Color myColor;
        int startY;
        int stopY = 561;
        int startX;
        int stopX = 866;
//        int pixelCount = 0;
//        h = 560;
//        w = 865;

        int[] color = new int[3];

        for (startY = 40; startY < stopY; startY++){

            for (startX = 415; startX < stopX; startX++) {
//                pixelCount = pixelCount + 1;
                myColor = new Color(image.getRGB(startX,startY));
                color[0] = myColor.getRed();
                color[1] = myColor.getGreen();
                color[2] = myColor.getBlue();
                for (int k = 0; k < 3; k++ ) {
//                    System.out.println("startY: " + startY + " startX: " + startX + " k: " + k + " pix: " + pixelCount);
                    rgbArray[startY - 40][startX - 415][k] = color[k];
                }
            }
        }
//        print3DArray(rgbArray, 520, 450);
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
