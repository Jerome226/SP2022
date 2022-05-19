package com.fuguclub.sp2022;

import java.awt.*;
import java.util.Random;

public class Main {

    public static String answerText;
    public static String randomizedAnswerOneText;
    public static String randomizedAnswerSecondText;
    public static int answerButton;
    public static int firstBandColor;
    public static int secondBandColor;
    public static int multiplierBandColor;
    public static int multiplier;
    public static Color multiplierColor;
    public static int toleranceBandColor;
    public static String tolerance;
    public static Color toleranceColor;
    public static int randomizedAnswerOne;
    public static int randomizedAnswerSecond;

    public static void main(String[] args) {
    System.out.println("init: Main");

    Random rand = new Random();
    answerButton = rand.nextInt((5 - 1) + 1) + 1;

    firstBandColor = rand.nextInt((9 - 1) + 1) + 1;
    secondBandColor = rand.nextInt((9 - 1) + 1) + 1;
    multiplierBandColor = rand.nextInt((9 - 1) + 1) + 1;
    toleranceBandColor = rand.nextInt((3 - 1) + 1) + 1;

    randomizedAnswerOne = rand.nextInt((24000 - 1) + 1) + 1;
    randomizedAnswerSecond = rand.nextInt((24000 - 1) + 1) + 1;

    switch(multiplierBandColor) {
        case 1:
            multiplier = 1;
            multiplierColor = Color.black;
        break;
        case 2:
            multiplier = 10;
            multiplierColor = new Color(69, 42, 14);
        break;
        case 3:
            multiplier = 100;
            multiplierColor = Color.red;
        break;
        case 4:
            multiplier = 1000;
            multiplierColor = Color.orange;
        break;
        case 5:
            multiplier = 10000;
            multiplierColor = Color.yellow;
        break;
        case 6:
            multiplier = 100000;
            multiplierColor = Color.green;
        break;
        case 7:
            multiplier = 1000000;
            multiplierColor = Color.blue;
        break;
        case 8:
            multiplier = 10000000;
            multiplierColor = new Color(218, 66, 245);
        break;
        case 9:
            multiplier = 100000000;
            multiplierColor = Color.gray;
        break;
        case 10:
            multiplier = 1000000000;
            multiplierColor = Color.white;
        break;
    }

    switch(toleranceBandColor) {
        case 1:
            tolerance = "∓5%";
            toleranceColor = new Color(209, 138, 31);
        break;
        case 2:
            tolerance = "∓10%";
            toleranceColor = new Color(145, 143, 140);
        break;
        case 3:
            tolerance = "∓20%";
            toleranceColor = Color.black;
        break;
    }

    int first = 1;
    int second = 2;

    String firstText = String.valueOf(first);
    String secondText = String.valueOf(second);

    String numberText = firstText + secondText;
    int number = Integer.parseInt(numberText);
    int answer = number * multiplier;
    answerText = answer + System.lineSeparator() + "(Tolérance: " + tolerance + " )";

    randomizedAnswerOneText = String.valueOf(randomizedAnswerOne);
    randomizedAnswerSecondText = String.valueOf(randomizedAnswerSecond);

    //

    //Frame
    MainFrame frame = new MainFrame();

    }

}
