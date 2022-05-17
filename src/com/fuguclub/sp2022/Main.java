package com.fuguclub.sp2022;

import java.util.Random;

public class Main {

    public static String answerText;
    public static String randomizedAnswerOneText;
    public static String randomizedAnswerSecondText;
    public static int answerButton;
    public static int firstBandColor;
    public static int secondBandColor;
    public static int multiplierBandColor;
    public static int toleranceBandColor;
    public static int randomizedAnswerOne;
    public static int randomizedAnswerSecond;

    public static void main(String[] args) {

    Random rand = new Random();
    answerButton = rand.nextInt((3 - 1) + 1) + 1;
    firstBandColor = rand.nextInt((9 - 1) + 1) + 1;
    secondBandColor = rand.nextInt((9 - 1) + 1) + 1;
    multiplierBandColor = rand.nextInt((9 - 1) + 1) + 1;
    toleranceBandColor = rand.nextInt((3 - 1) + 1) + 1;

    randomizedAnswerOne = rand.nextInt((24000 - 1) + 1) + 1;
    randomizedAnswerSecond = rand.nextInt((24000 - 1) + 1) + 1;

    int answer = 10;

    randomizedAnswerOneText = String.valueOf(randomizedAnswerOne);
    randomizedAnswerSecondText = String.valueOf(randomizedAnswerSecond);

    answerText = String.valueOf(answer);

    //Frame
    MainFrame frame = new MainFrame();
    }

}
