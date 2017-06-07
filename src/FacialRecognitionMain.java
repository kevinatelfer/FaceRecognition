import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Created by block7 on 3/28/17.
 */
public class FacialRecognitionMain implements ActionListener {
    static BufferedImage imgMain = null;
    int[] rgbArrayMain;
    String[] imageList= {"KevSource", "KevTest", "DadSource", "image4", "image5"};
    String choice1;
    String choice2;
    boolean finished;

    JFrame mainFrame;
    ImagePanel mainPanel;
    JComboBox box1;
    JComboBox box2;
    JLabel title;
    JLabel imageApproved;
    JLabel imageDeclined;
    JButton compare;

//    static boolean drawKevSource1 = false;
//    static boolean drawKevTest1 = false;
//    static boolean drawDadSource1 = false;

    public FacialRecognitionMain() {
        mainFrame = new JFrame();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(1000,700);

        ImagePanel panel = new ImagePanel();
        mainPanel = new ImagePanel();
        mainFrame.setContentPane(mainPanel);
        mainPanel.setBackground(Color.lightGray);

        mainFrame.setLayout(null);

        box1 = new JComboBox(imageList);
        box1.setBounds(200,100,100,30);
        mainPanel.add(box1);
        box1.addActionListener(this);

        box2 = new JComboBox(imageList);
        box2.setBounds(700,100,100,30);
        mainPanel.add(box2);
        box2.addActionListener(this);

        compare = new JButton("compare");
        compare.setBounds(425,480,150,40);
        compare.setFont(compare.getFont().deriveFont(20.0f));
        compare.setForeground(Color.black);
        mainPanel.add(compare);
        compare.addActionListener(this);

        title = new JLabel("Face Authenticator");
        title.setBounds(320, 10, 450,40);
        title.setFont(title.getFont().deriveFont(40.0f));
        title.setForeground(Color.CYAN);
        mainPanel.add(title);

        imageApproved = new JLabel("Face Approved");
        imageApproved.setBounds(355, 575, 450,40);
        imageApproved.setFont(imageApproved.getFont().deriveFont(40.0f));
        imageApproved.setForeground(Color.black);
        mainPanel.add(imageApproved);

        imageDeclined = new JLabel("Face Declined");
        imageDeclined.setBounds(360, 575, 450,40);
        imageDeclined.setFont(imageDeclined.getFont().deriveFont(40.0f));
        imageDeclined.setForeground(Color.black);
        mainPanel.add(imageDeclined);

        imageApproved.setVisible(false);
        imageDeclined.setVisible(true);

        mainFrame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == box1) {
            choice1 = box1.getSelectedItem().toString();
            System.out.println("choice " + choice1);
            MyImage.loadSourceImage(choice1);
//            setDrawTrue();
        }
        if (e.getSource() == box2) {
            choice2 = box2.getSelectedItem().toString();
            System.out.println("choice " + choice2);
            MyImage.loadTestImage(choice2);
//            setDrawTrue();
        }
    }

    public void changeBackgroundColor() {
        if (ImageCalc.authenticated == 1){
            mainPanel.setBackground(Color.green);
            imageApproved.setVisible(true);
        } else if (ImageCalc.authenticated == 2){
            mainPanel.setBackground(Color.red);
            imageDeclined.setVisible(true);
        }
    }


//    public void setDrawTrue() {
//        if (choice1.equals("KevSource")) {
//            drawKevSource1 = true;
//        } else if(choice1.equals("KevTest")) {
//            drawKevTest1 = true;
//        }
//    }


    
    public static void main(String[] args) {
        FacialRecognitionMain rec = new FacialRecognitionMain();
        System.out.println("ready");
        System.out.println("testImg" + MyImage.testImg);
        System.out.println("sourceImg" + MyImage.sourceImg);

        do {
            if (MyImage.testImg != null && MyImage.sourceImg != null) {
                System.out.println("entered if");
                rec.finished = true;
                MyImage myImage = new MyImage();
                ImageCalc calc = new ImageCalc();

                System.out.println(rec.rgbArrayMain);

                myImage.readImageWithGetRGB(myImage.getSourceImg(), myImage.getSourceH(), myImage.getSourceW(), myImage.getSourceRGBArray());
                System.out.println("Test Image:");
                myImage.readImageWithGetRGB(myImage.getTestImg(), myImage.getTestH(),myImage.getTestW(), myImage.getTestRGBArray());
                calc.simpleCompare(myImage.getSourceRGBArray(), myImage.getTestRGBArray(), 520, 451);
                rec.changeBackgroundColor();
//        myImage.resizeDimensions();
            }else {
                System.out.println("select images");
            }
        } while (!rec.finished);

//        System.out.println("entered if");
////                rec.imagesChosen = true;
//        MyImage myImage = new MyImage();
//        ImageCalc calc = new ImageCalc();
//
//        System.out.println(rec.rgbArrayMain);
//
//        myImage.readImageWithGetRGB(myImage.getSourceImg(), myImage.getSourceH(), myImage.getSourceW(), myImage.getSourceRGBArray());
//        System.out.println("Test Image:");
//        myImage.readImageWithGetRGB(myImage.getTestImg(), myImage.getTestH(),myImage.getTestW(), myImage.getTestRGBArray());
//        calc.simpleCompare(myImage.getSourceRGBArray(), myImage.getTestRGBArray(), 520, 451);
////                FacialRecognitionMain recc = new FacialRecognitionMain();

    }
}
