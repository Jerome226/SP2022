package com.fuguclub.sp2022;

import java.awt.*;
import java.util.Random;

public class Main {
    public static Random rand;
    public static String answerText;
    public static String fakeAnswerText;
    public static int answerButton;
    public static int multiplier;
    public static Color color;
    public static Color lastColor;
    public static int bandNumber;
    public static int toleranceBandNumber;
    public static String tolerance;
    public static Color firstBandColor;
    public static Color secondBandColor;
    public static Color multiplierBandColor;
    public static Color toleranceBandColor;

    public static void generateMainAnswer(){
        System.out.println("init: generateMainAnswer");

        bandNumber = rand.nextInt((9 - 1) + 1) + 1;

        switch(bandNumber) {
            case 1:
                multiplier = 1;
                color = Color.black;
                break;
            case 2:
                multiplier = 10;
                color = new Color(69, 42, 14);
                break;
            case 3:
                multiplier = 100;
                color = Color.red;
                break;
            case 4:
                multiplier = 1000;
                color = Color.orange;
                break;
            case 5:
                multiplier = 10000;
                color = Color.yellow;
                break;
            case 6:
                multiplier = 100000;
                color = Color.green;
                break;
            case 7:
                multiplier = 1000000;
                color = Color.blue;
                break;
            case 8:
                multiplier = 10000000;
                color = new Color(218, 66, 245);
                break;
            case 9:
                multiplier = 100000000;
                color = Color.gray;
                break;
            case 10:
                multiplier = 1000000000;
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

        generateMainAnswer();
        int firstBand = bandNumber;
        String firstBandText = String.valueOf(firstBand);
        firstBandColor = color;

        generateMainAnswer();
        int secondBand = bandNumber;
        String secondBandText = String.valueOf(secondBand);
        secondBandColor = color;

        generateMainAnswer();
        multiplierBandColor = color;

        generateMainAnswer();
        toleranceBandColor = lastColor;

        String numberText = firstBandText + secondBandText;
        int number = Integer.parseInt(numberText);
        int answer = number * multiplier;
        answerText = answer + "Ω (Tolérance: " + tolerance + " )";
        System.out.println(answerText);
    }
    public static void generateWrongAnswer(){
        System.out.println("init: generateWrongAnswer");

        generateMainAnswer();
        int fakeNumber = rand.nextInt((99 - 1) + 1) + 1;
        int fakeMultiplier = multiplier;
        String fakeTolerance = tolerance;

        int fakeAnswer = fakeNumber * fakeMultiplier;
        fakeAnswerText = fakeAnswer + "Ω (Tolérance: " + fakeTolerance + " )";
        System.out.println(fakeAnswerText);
    }

    public static void main(String[] args) {
    System.out.println("init: Main");

    rand = new Random();
    answerButton = rand.nextInt((5 - 1) + 1) + 1;

    generateRightAnswer();
    generateWrongAnswer();

    //Frame
    MainFrame frame = new MainFrame();

    }

}
