import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by block7 on 3/28/17.
 */
public class FacialRecognitionMain {
    BufferedImage img = null;

    public FacialRecognitionMain() {
        try {
            img = ImageIO.read(new File("NaturePatterns08.jpg"));

        } catch (IOException e) {

        }
    }




}
