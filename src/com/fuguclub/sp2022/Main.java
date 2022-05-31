package com.fuguclub.sp2022;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

import static com.fuguclub.sp2022.MainFrame.*;

public class Main {
    public static Random rand;
    public static String answerText;
    public static String rawAnswerText;
    public static String firstBandText;
    public static String secondBandText;
    public static int firstBand;
    public static int secondBand;
    public static String fakeAnswerText;
    public static int answerButton;
    public static String multiplier;
    public static Color color;
    public static Color lastColor;
    public static int bandNumber;
    public static int toleranceBandNumber;
    public static String tolerance;
    public static Color firstBandColor;
    public static Color secondBandColor;
    public static Color multiplierBandColor;
    public static Color toleranceBandColor;
    public static String multiplierBand;
    public static String toleranceBand;
    public static String numberText;

    public static void generateMainValues(){
        System.out.println("init: generateMainValues");

        bandNumber = rand.nextInt((9 - 1) + 1) + 1;

        switch(bandNumber) {
            case 1:
                multiplier = "";
                color = Color.black;
                break;
            case 2:
                multiplier = "0";
                color = new Color(61, 34, 0);
                break;
            case 3:
                multiplier = "00";
                color = new Color(255, 0, 0);
                break;
            case 4:
                multiplier = "000";
                color = new Color(248, 128, 7);
                break;
            case 5:
                multiplier = "0000";
                color = new Color(255, 251, 0);
                break;
            case 6:
                multiplier = "00000";
                color = new Color(29, 129, 18);
                break;
            case 7:
                multiplier = "000000";
                color = new Color(0, 78, 194, 136);
                break;
            case 8:
                multiplier = "0000000";
                color = new Color(91, 14, 107);
                break;
            case 9:
                multiplier = "00000000";
                color = Color.gray;
                break;
            case 10:
                multiplier = "000000000";
                color  = Color.white;
                break;
        }

        toleranceBandNumber = rand.nextInt((3 - 1) + 1) + 1;

        switch(toleranceBandNumber) {
            case 1:
                tolerance = "∓5%";
                lastColor = new Color(209, 138, 31);
                break;
            case 2:
                tolerance = "∓10%";
                lastColor = new Color(145, 143, 140);
                break;
            case 3:
                tolerance = "∓20%";
                lastColor = Color.black;
                break;
        }
    }

    public static void generateRightAnswer(){
        System.out.println("init: generateRightAnswer");

        generateMainValues();
        if(bandNumber != 1) {
            firstBand = bandNumber - 1;
            firstBandText = String.valueOf(firstBand);
        } else {
            firstBandText = "0";
        }
        firstBandColor = color;

        generateMainValues();
        if(bandNumber != 1) {
            secondBand = bandNumber - 1;
            secondBandText = String.valueOf(secondBand);
        } else {
            secondBandText = "0";
        }
        secondBandColor = color;

        generateMainValues();
        multiplierBand = multiplier;
        multiplierBandColor = color;

        generateMainValues();
        toleranceBand = tolerance;
        toleranceBandColor = lastColor;

        numberText = firstBandText + secondBandText;
        if (numberText.equals("")) {
            answerText = "0Ω";
            rawAnswerText = "0";
        } else {
            answerText = numberText + multiplierBand + "Ω (Tolérance: " + toleranceBand + ")";
            rawAnswerText = numberText + multiplierBand;
        }
        System.out.println("answerText: " + answerText);
    }

    public static void generateWrongAnswer(){
        System.out.println("init: generateWrongAnswer");

        generateMainValues();
        int fakeNumber = rand.nextInt((99 - 1) + 1) + 1;
        String fakeMultiplier = multiplier;
        String fakeTolerance = tolerance;

        fakeAnswerText = fakeNumber + fakeMultiplier + "Ω (Tolérance: " + fakeTolerance + ")";
        System.out.println("fakeAnswerText: " + fakeAnswerText);
    }

    public static MainFrame mainFrame;
    public static SelectionFrame selectionFrame;

    public static void main(String[] args) {
    System.out.println("init: Main");

    rand = new Random();

    //Frame
    mainFrame = new MainFrame();
    MainFrame.panelBottom.setVisible(false);

    selectionFrame = new SelectionFrame();

    }

    public static void easyMode(){
        Main.selectionFrame.setVisible(false);
        MainFrame.panelBottom.setVisible(true);
        MainFrame.panelBottomCenter = new JPanel(new GridLayout(1, 5, 20, 20));
        MainFrame.panelBottomCenter.add(firstButton);
        MainFrame.panelBottomCenter.add(secondButton);
        MainFrame.panelBottomCenter.add(thirdButton);
        MainFrame.panelBottomCenter.add(fourthButton);
        MainFrame.panelBottomCenter.add(fifthButton);
        MainFrame.panelBottomCenter.setVisible(true);
        MainFrame.panelBottom.add(panelBottomCenter,BorderLayout.CENTER);
        MainFrame.panelCenter.add(labelResistor,BorderLayout.NORTH);

    }

    public static void hardMode(){
        Main.selectionFrame.setVisible(false);
        MainFrame.panelBottom.setVisible(true);
        MainFrame.panelBottomEast.setPreferredSize(new Dimension(500, 100));
        MainFrame.panelBottomWest.setPreferredSize(new Dimension(500, 100));
        MainFrame.panelBottomCenter = new JPanel(new GridLayout(1, 3, 20, 20));
        MainFrame.panelBottomCenter.add(textField);
        MainFrame.panelBottomCenter.add(panelTolerance);
        MainFrame.panelBottomCenter.add(textFieldButton);
        MainFrame.panelBottomCenter.setVisible(true);
        MainFrame.panelBottom.add(panelBottomCenter,BorderLayout.CENTER);
        MainFrame.panelCenter.add(labelResistor,BorderLayout.NORTH);

    }

}
