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
    boolean compareImages;
    int angleP;
    int meanDiffP;

    JFrame mainFrame;
    ImagePanel mainPanel;
    JComboBox box1;
    JComboBox box2;
    JLabel title;
    JLabel imageApproved;
    JLabel imageDeclined;
    JButton compare;
    JLabel imagePlaceholder1;
    JLabel imagePlaceholder2;
    JLabel angleTitle;
    JLabel avgPixTitle;
    JLabel angleDiff;
    JLabel meanPix;

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
//        mainPanel.setBackground(new Color(74,124,249));

        mainFrame.setLayout(null);

        box1 = new JComboBox(imageList);
        box1.setBounds(200,100,100,30);
        mainPanel.add(box1);
        box1.addActionListener(this);

        box2 = new JComboBox(imageList);
        box2.setBounds(700,100,100,30);
        mainPanel.add(box2);
        box2.addActionListener(this);

        compare = new JButton("Compare");
        compare.setBounds(425,480,150,40);
        compare.setFont(compare.getFont().deriveFont(20.0f));
//        compare.setBackground(new Color(66,83,244));
        compare.setForeground(Color.darkGray);
        mainPanel.add(compare);
        compare.addActionListener(this);

        title = new JLabel("Face Authenticator");
        title.setBounds(314, 17, 450,40);
        title.setFont(title.getFont().deriveFont(40.0f));
        title.setForeground(Color.darkGray);
        mainPanel.add(title);

        angleTitle = new JLabel("Vector Angle Difference");
        angleTitle.setBounds(40,500,500,40);
        angleTitle.setFont(angleTitle.getFont().deriveFont(25.0f));
        angleTitle.setForeground(Color.darkGray);
        mainPanel.add(angleTitle);

        avgPixTitle = new JLabel("Mean Difference in Color");
        avgPixTitle.setBounds(650,500,500,40);
        avgPixTitle.setFont(avgPixTitle.getFont().deriveFont(25.0f));
        avgPixTitle.setForeground(Color.darkGray);
        mainPanel.add(avgPixTitle);

//        angleDiff = new JLabel(Integer.toString(angleP));
//        angleDiff.setBounds(720,520,500,40);
//        angleDiff.setFont(angleDiff.getFont().deriveFont(20.0f));
//        angleDiff.setForeground(Color.darkGray);
//        mainPanel.add(angleDiff);

//        meanPix = new JLabel(Integer.toString(meanDiffP));
//        meanPix.setBounds(120,520,500,40);
//        meanPix.setFont(meanPix.getFont().deriveFont(20.0f));
//        meanPix.setForeground(Color.darkGray);
//        mainPanel.add(meanPix);

        imagePlaceholder1 = new JLabel("Reference Image");
        imagePlaceholder1.setBounds(115,283,450,50);
        imagePlaceholder1.setFont(imagePlaceholder1.getFont().deriveFont(35.0f));
        imagePlaceholder1.setForeground(Color.gray);
        mainPanel.add(imagePlaceholder1);

        imagePlaceholder2 = new JLabel("Test Image");
        imagePlaceholder2.setBounds(660,283,450,50);
        imagePlaceholder2.setFont(imagePlaceholder2.getFont().deriveFont(35.0f));
        imagePlaceholder2.setForeground(Color.gray);
        mainPanel.add(imagePlaceholder2);

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
        imageDeclined.setVisible(false);

        mainFrame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == box1) {
            choice1 = box1.getSelectedItem().toString();
            System.out.println("choice " + choice1);
            MyImage.loadSourceImage(choice1);
            imagePlaceholder1.setVisible(false);
//            setDrawTrue();
        }
        if (e.getSource() == box2) {
            choice2 = box2.getSelectedItem().toString();
            System.out.println("choice " + choice2);
            MyImage.loadTestImage(choice2);
            imagePlaceholder2.setVisible(false);
//            setDrawTrue();
        }
        if (e.getSource() == compare) {
            compareImages = true;
            System.out.println("BUTTON PRESSED");
            System.out.println(compareImages);
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

    public void updateCalcInfo() {
        angleP = (int) ImageCalc.angle;
        meanDiffP = ImageCalc.meanDiff;
        System.out.println("angleP " + angleP);
        System.out.println("meanDiffP " + meanDiffP);
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
        System.out.println("compare Images: " + rec.compareImages);


        do {
//            System.out.println(rec.compareImages);
            if (rec.compareImages) {
//                System.out.println("entered if");
                rec.imageApproved.setVisible(false);
                rec.imageDeclined.setVisible(false);
                rec.finished = true;
                MyImage myImage = new MyImage();
                ImageCalc calc = new ImageCalc();

                System.out.println(rec.rgbArrayMain);

                myImage.readImageWithGetRGB(myImage.getSourceImg(), myImage.getSourceH(), myImage.getSourceW(), myImage.getSourceRGBArray());
//                System.out.println("Test Image:");
                myImage.readImageWithGetRGB(myImage.getTestImg(), myImage.getTestH(),myImage.getTestW(), myImage.getTestRGBArray());
                calc.simpleCompare(myImage.getSourceRGBArray(), myImage.getTestRGBArray(), 520, 451);
                calc.vectorCompare(myImage.getSourceRGBArray(),myImage.getTestRGBArray(), 520,451);
                rec.changeBackgroundColor();
                rec.updateCalcInfo();

                rec.meanPix = new JLabel(Integer.toString(rec.meanDiffP));
                rec.meanPix.setBounds(160,530,50,20);
                rec.meanPix.setFont(rec.meanPix.getFont().deriveFont(20.0f));
                rec.meanPix.setForeground(Color.darkGray);
                rec.mainPanel.add(rec.meanPix);

                rec.angleDiff = new JLabel(Integer.toString(rec.angleP));
                rec.angleDiff.setBounds(770,530,40,20);
                rec.angleDiff.setFont(rec.angleDiff.getFont().deriveFont(20.0f));
                rec.angleDiff.setForeground(Color.darkGray);
                rec.mainPanel.add(rec.angleDiff);

                rec.compareImages = false;
                rec.finished = false;
            }else {
                System.out.println("select images");
            }
        } while(!rec.finished);

//        do {
//            if (MyImage.testImg != null && MyImage.sourceImg != null) {
//                System.out.println("entered if");
//                rec.finished = true;
//                MyImage myImage = new MyImage();
//                ImageCalc calc = new ImageCalc();
//
//                System.out.println(rec.rgbArrayMain);
//
//                myImage.readImageWithGetRGB(myImage.getSourceImg(), myImage.getSourceH(), myImage.getSourceW(), myImage.getSourceRGBArray());
//                System.out.println("Test Image:");
//                myImage.readImageWithGetRGB(myImage.getTestImg(), myImage.getTestH(),myImage.getTestW(), myImage.getTestRGBArray());
//                calc.simpleCompare(myImage.getSourceRGBArray(), myImage.getTestRGBArray(), 520, 451);
//                rec.changeBackgroundColor();
////        myImage.resizeDimensions();
//            }else {
//                System.out.println("select images");
//            }
//        } while (!rec.finished);

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
