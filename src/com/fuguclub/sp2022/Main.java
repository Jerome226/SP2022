package com.fuguclub.sp2022;

import java.awt.*;
import java.util.Random;

public class Main {
    public static Random rand;
    public static String answerText;
    public static String firstBandText;
    public static String secondBandText;
    public static int firstBand;
    public static int number;
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
                color = new Color(69, 42, 14);
                break;
            case 3:
                multiplier = "00";
                color = Color.red;
                break;
            case 4:
                multiplier = "000";
                color = Color.orange;
                break;
            case 5:
                multiplier = "0000";
                color = Color.yellow;
                break;
            case 6:
                multiplier = "00000";
                color = Color.green;
                break;
            case 7:
                multiplier = "000000";
                color = Color.blue;
                break;
            case 8:
                multiplier = "0000000";
                color = new Color(218, 66, 245);
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
            firstBandText = "";
        }
        firstBandColor = color;

        generateMainValues();
        if(bandNumber != 1) {
            secondBand = bandNumber - 1;
            secondBandText = String.valueOf(secondBand);
        } else {
            secondBandText = "";
        }
        secondBandColor = color;

        generateMainValues();
        String multiplierBand = multiplier;
        multiplierBandColor = color;

        generateMainValues();
        String toleranceBand = tolerance;
        toleranceBandColor = lastColor;

        String numberText = firstBandText + secondBandText;
        if (numberText == "") {
            answerText = "0Ω";
        } else {
            answerText = numberText + multiplierBand + "Ω (Tolérance: " + toleranceBand + ")";
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

    public static void main(String[] args) {
    System.out.println("init: Main");

    rand = new Random();

    //Frame
    MainFrame frame = new MainFrame();

    }

}
