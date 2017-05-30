/**
 * Created by block7 on 4/10/17.
 */
public class ImageCalc {
//    int diffRed;
//    int diffGreen;
//    int diffBlue;
    int colorDiff;
    public void simpleCompare(int[][][] source, int[][][] test, int h, int w) {
        System.out.println("calc start");

        for (int i = 0; i < h; i++){
            for (int j = 0; j < w; j++) {
                for (int k = 0; k < 3; k++ ) {
                    colorDiff = colorDiff + (source[i][j][k] - test[i][j][k])*(source[i][j][k] - test[i][j][k]);
                    //                    if (k == 0) {//red
//                        diffRed = Math.pow(source[h][w][k] - test[h][w][k], 2);
//                    }
//                    if (k == 1) {//green
//                        diffGreen = Math.pow(source[h][w][k] - test[h][w][k], 2);
//
//                    }
//                    if (k == 2) {//blue
//                        diffBlue = Math.pow(source[h][w][k] - test[h][w][k], 2);
//
//                    }
                }
            }
        }
        System.out.println(colorDiff);
    }

}
