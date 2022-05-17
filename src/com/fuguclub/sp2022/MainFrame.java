package com.fuguclub.sp2022;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.fuguclub.sp2022.Main.*;

public class MainFrame extends JFrame implements ActionListener {

    JButton firstButton;
    JButton secondButton;
    JButton thirdButton;
    JLabel label;
    JLabel answerLabel;

    public void rightAnswer(){
        ImageIcon checkmark = new ImageIcon("checkmark.png");

        answerLabel = new JLabel();
        answerLabel.setText("Bonne réponse! Bravo");
        answerLabel.setIcon(checkmark);
        answerLabel.setIconTextGap(40);
        answerLabel.setVisible(true);
    }

    public void wrongAnswer(){

    }

    MainFrame(){

    ImageIcon icon = new ImageIcon("icon.png");
    ImageIcon wrong = new ImageIcon("wrong.png");

    Border border = BorderFactory.createLineBorder(Color.BLACK,20,true);
    //System.out.println(randomNum2);

    //Title
    label = new JLabel();
    label.setText("Calculateur de Resistance");
    label.setIcon(icon);
    label.setHorizontalTextPosition(JLabel.RIGHT);
    //label.setVerticalTextPosition(JLabel.)
    label.setHorizontalAlignment(JLabel.CENTER);
    label.setVerticalAlignment(JLabel.TOP);
    label.setFont(new Font("MV Boli",Font.BOLD,40));
    label.setIconTextGap(40);
    label.setVisible(true);
    label.setBorder(border);
    //label.setBorder(border);
        
    firstButton = new JButton();
    //firstButton.setText(answerText);
    firstButton.setFocusable(false);
    firstButton.setVisible(true);
    firstButton.setBounds(100, 100, 100, 50);
    firstButton.addActionListener(this);

    secondButton = new JButton();
    //firstButton.setText(answerText);
    secondButton.setFocusable(false);
    secondButton.setVisible(true);
    secondButton.setBounds(200, 100, 100, 50);
    secondButton.addActionListener(this);

    thirdButton = new JButton();
    //firstButton.setText(answerText);
    thirdButton.setFocusable(false);
    thirdButton.setVisible(true);
    thirdButton.setBounds(200, 100, 100, 50);
    thirdButton.addActionListener(this);

    switch(answerButton) {
        case 1:
            firstButton.setText(answerText);
            secondButton.setText(randomizedAnswerOneText);
            thirdButton.setText(randomizedAnswerSecondText);
        break;
        case 2:
            firstButton.setText(randomizedAnswerSecondText);
            secondButton.setText(answerText);
            thirdButton.setText(randomizedAnswerOneText);
        break;
        case 3:
            firstButton.setText(randomizedAnswerOneText);
            secondButton.setText(randomizedAnswerSecondText);
            thirdButton.setText(answerText);
        break;
    }

    //GUI
    this.setTitle("School Project 2022");
    //this.setLayout(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit out of application
    this.setResizable(true);
    this.setVisible(true);
    this.setSize(1000,1000);
    this.setIconImage(icon.getImage());
    this.getContentPane().setBackground(Color.WHITE);
    this.add(firstButton);
    this.add(secondButton);
    this.add(thirdButton);
    this.add(label);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==firstButton) {
            if(answerButton == 1) {
                rightAnswer();
            } else {
                wrongAnswer();
            }
        }
        if(e.getSource()==secondButton) {
            if(answerButton == 2) {
                rightAnswer();
            } else {
                wrongAnswer();
            }
        }
        if(e.getSource()==thirdButton) {
            if(answerButton == 3) {
                rightAnswer();
            } else {
                wrongAnswer();
            }
        }
    }
}
