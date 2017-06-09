/**
 * Created by block7 on 4/10/17.
 */
public class ImageCalc {
    int colorDiff;
    static int meanDiff;
    int pixels = 234000;
    static int authenticated = 0;
    double dotProduct;
    double vect1Mag;
    double vect2Mag; //may need to be float
    double magProduct;
//    int magProductInt;
    double devided;
    static double angle;

    public void vectorCompare(int[][][] source, int[][][] test, int h, int w) {
        System.out.println("vectorCompare start: ");
        for (int i = 0; i < h; i++){
            for (int j = 0; j < w; j++) {
                for (int k = 0; k < 3; k++ ) {
                    dotProduct = dotProduct + (source[i][j][k]*test[i][j][k]);
                    vect1Mag = vect1Mag + (source[i][j][k]*source[i][j][k]);
                    vect2Mag = vect2Mag + (test[i][j][k]*test[i][j][k]);
                }
            }
        }
        vect1Mag = Math.sqrt(vect1Mag);
        vect2Mag = Math.sqrt(vect2Mag);
        magProduct = vect1Mag*vect2Mag;
//        magProductInt = (int) magProductDouble;
        devided = dotProduct/magProduct;
        angle = Math.toDegrees(Math.acos(devided));
        System.out.println("angle" + angle);

    }

    public void simpleCompare(int[][][] source, int[][][] test, int h, int w) {
        System.out.println("calc start");
        for (int i = 0; i < h; i++){
            for (int j = 0; j < w; j++) {
                for (int k = 0; k < 3; k++ ) {
                    colorDiff = colorDiff + (source[i][j][k] - test[i][j][k])*(source[i][j][k] - test[i][j][k]);

                }
            }
        }
        meanDiff = colorDiff/pixels;
        System.out.println(colorDiff);
        if (meanDiff > 2500) {
            authenticated = 2;
        } else {
            authenticated = 1;
        }
    }



}
