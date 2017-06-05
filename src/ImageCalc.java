/**
 * Created by block7 on 4/10/17.
 */
public class ImageCalc {
    int colorDiff;
    int meanDiff;
    int pixels = 234000;
    static int authenticated = 0;
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
