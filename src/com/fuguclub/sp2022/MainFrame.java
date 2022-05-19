package com.fuguclub.sp2022;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;

import static com.fuguclub.sp2022.Main.*;

public class MainFrame extends JFrame implements ActionListener{

    JButton firstButton;
    JButton secondButton;
    JButton thirdButton;
    JButton fourthButton;
    JButton fifthButton;
    JPanel panel;
    JPanel panelCenter;
    JPanel panelCenterBottom;
    JPanel panelEast;
    JPanel panelWest;
    JPanel panelBottom;
    JPanel panelBottomBottom;
    JPanel panelBottomCenter;
    JPanel panelBottomEast;
    JPanel panelBottomWest;
    JLabel label;
    JLabel labelBottom;
    //JLabel labelBottom;
    JLabel labelAnswer;

    public void rightAnswer(){
        System.out.println("init: rightAnswer");

        ImageIcon checkmarkImage = new ImageIcon("checkmark.png");
        Image checkmark2 = checkmarkImage.getImage();
        Image checkmarkResized = checkmark2.getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH);
        ImageIcon checkmark = new ImageIcon(checkmarkResized);

        labelAnswer.setText("Bonne réponse! Bravo");
        labelAnswer.setFont(new Font("Arial",Font.BOLD,60));
        labelAnswer.setIcon(checkmark);
        labelAnswer.setIconTextGap(40);
        labelAnswer.setVisible(true);
    }

    public void wrongAnswer(){
        System.out.println("init: wrongAnswer");

        ImageIcon wrongImage = new ImageIcon("wrong.png");
        Image wrong2 = wrongImage.getImage();
        Image wrongResized = wrong2.getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH);
        ImageIcon wrong = new ImageIcon(wrongResized);

        labelAnswer.setText("Mauvaise réponse! Ré-essai");
        labelAnswer.setFont(new Font("Arial",Font.BOLD,60));
        labelAnswer.setIcon(wrong);
        labelAnswer.setIconTextGap(40);
        labelAnswer.setVisible(true);
    }

    public void generateWindowSize(){

        int frameWidth = getWidth();
        int buttonBorderWidth = frameWidth / 7;

        panelBottomEast.setPreferredSize(new Dimension(buttonBorderWidth, 100));
        panelBottomWest.setPreferredSize(new Dimension(buttonBorderWidth, 100));
        panelEast.setPreferredSize(new Dimension(buttonBorderWidth, 100));
        panelWest.setPreferredSize(new Dimension(buttonBorderWidth, 100));

    }

    MainFrame(){
    System.out.println("init: MainFrame");

    ImageIcon iconImage = new ImageIcon("icon.png");
    Image icon2 = iconImage.getImage();
    Image iconResized = icon2.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH);
    ImageIcon icon = new ImageIcon(iconResized);

    Border border = BorderFactory.createLineBorder(Color.BLACK,10,false);
    //System.out.println(randomNum2);

    //Title
    label = new JLabel();
    label.setText("Calculateur de Resistance");
    label.setIcon(icon);
    label.setSize(new Dimension(100, 100));
    //label.setToolTipText("test");
    label.setHorizontalTextPosition(JLabel.RIGHT);
    //label.setVerticalTextPosition(JLabel.)
    label.setHorizontalAlignment(JLabel.CENTER);
    label.setVerticalAlignment(JLabel.TOP);
    label.setFont(new Font("MV Boli",Font.BOLD,50));
    label.setIconTextGap(40);
    label.setVisible(true);
    //label.setBorder(border);
    label.setPreferredSize(new Dimension(300, 100));

    labelBottom = new JLabel();
    labelBottom.setText("Choisi la bonne réponse");
    labelBottom.setFont(new Font("MV Boli",Font.BOLD,20));
    labelBottom.setVerticalAlignment(JLabel.TOP);
    labelBottom.setHorizontalAlignment(JLabel.CENTER);
    labelBottom.setVerticalTextPosition(JLabel.TOP);
    labelBottom.setPreferredSize(new Dimension(10, 50));
    labelBottom.setVisible(true);

    labelAnswer = new JLabel();
    labelAnswer.setPreferredSize(new Dimension(80, 80));
    labelAnswer.setHorizontalAlignment(JLabel.CENTER);
    labelAnswer.setVerticalAlignment(JLabel.CENTER);

    firstButton = new JButton();
    //firstButton.setText(answerText);
    firstButton.setFocusable(false);
    firstButton.addActionListener(this);
    firstButton.setVisible(true);

    secondButton = new JButton();
    //secondButton.setText(answerText);
    secondButton.setFocusable(false);
    secondButton.addActionListener(this);
    secondButton.setVisible(true);

    thirdButton = new JButton();
    //thirdButton.setText(answerText);
    thirdButton.setFocusable(false);
    thirdButton.addActionListener(this);
    thirdButton.setVisible(true);

    fourthButton = new JButton();
    //thirdButton.setText(answerText);
    fourthButton.setFocusable(false);
    fourthButton.addActionListener(this);
    fourthButton.setVisible(true);

    fifthButton = new JButton();
    //thirdButton.setText(answerText);
    fifthButton.setFocusable(false);
    fifthButton.addActionListener(this);
    fifthButton.setVisible(true);

    switch(answerButton) {
        case 1:
            firstButton.setText(answerText);
            generateWrongAnswer();
            secondButton.setText(fakeAnswerText);
            generateWrongAnswer();
            thirdButton.setText(fakeAnswerText);
            generateWrongAnswer();
            fourthButton.setText(fakeAnswerText);
            generateWrongAnswer();
            fifthButton.setText(fakeAnswerText);
        break;
        case 2:
            generateWrongAnswer();
            firstButton.setText(fakeAnswerText);
            secondButton.setText(answerText);
            generateWrongAnswer();
            thirdButton.setText(fakeAnswerText);
            generateWrongAnswer();
            fourthButton.setText(fakeAnswerText);
            generateWrongAnswer();
            fifthButton.setText(fakeAnswerText);
        break;
        case 3:
            generateWrongAnswer();
            firstButton.setText(fakeAnswerText);
            generateWrongAnswer();
            secondButton.setText(fakeAnswerText);
            thirdButton.setText(answerText);
            generateWrongAnswer();
            fourthButton.setText(fakeAnswerText);
            generateWrongAnswer();
            fifthButton.setText(fakeAnswerText);
        break;
        case 4:
            generateWrongAnswer();
            firstButton.setText(fakeAnswerText);
            generateWrongAnswer();
            secondButton.setText(fakeAnswerText);
            generateWrongAnswer();
            thirdButton.setText(fakeAnswerText);
            fourthButton.setText(answerText);
            generateWrongAnswer();
            fifthButton.setText(fakeAnswerText);
        break;
        case 5:
            generateWrongAnswer();
            firstButton.setText(fakeAnswerText);
            generateWrongAnswer();
            secondButton.setText(fakeAnswerText);
            generateWrongAnswer();
            thirdButton.setText(fakeAnswerText);
            generateWrongAnswer();
            fourthButton.setText(fakeAnswerText);
            fifthButton.setText(answerText);
        break;
    }

    //GUI
    this.setTitle("School Project 2022");
    this.setLayout(new BorderLayout());
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit out of application
    this.setResizable(true);
    this.setSize(1000,1000);
    this.setIconImage(icon.getImage());
    this.getContentPane().setBackground(Color.WHITE);

    panelBottomCenter = new JPanel(new GridLayout(1, 5, 20, 20));
    panelBottomCenter.add(firstButton);
    panelBottomCenter.add(secondButton);
    panelBottomCenter.add(thirdButton);
    panelBottomCenter.add(fourthButton);
    panelBottomCenter.add(fifthButton);

    panelBottomBottom = new JPanel(new BorderLayout());
    panelBottomBottom.setPreferredSize(new Dimension(100, 50));
    panelBottomEast = new JPanel(new BorderLayout());
    panelBottomWest = new JPanel(new BorderLayout());

    panelBottom = new JPanel(new BorderLayout());
    panelBottom.setPreferredSize(new Dimension(50, 200));
    panelBottom.setBorder(border);
    panelBottom.add(labelBottom,BorderLayout.NORTH);
    //panelBottom.add(secondButton,BorderLayout.CENTER);
    panelBottom.add(panelBottomCenter,BorderLayout.CENTER);
    panelBottom.add(panelBottomBottom,BorderLayout.SOUTH);
    panelBottom.add(panelBottomEast,BorderLayout.EAST);
    panelBottom.add(panelBottomWest,BorderLayout.WEST);

    panelEast = new JPanel(new BorderLayout());
    panelWest = new JPanel(new BorderLayout());

    panelCenterBottom = new JPanel(new BorderLayout());
    panelCenterBottom.add(labelAnswer,BorderLayout.CENTER);

    panelCenter = new JPanel(new BorderLayout());
    panelCenter.setBackground(Color.red);
    panelCenter.setOpaque(true);
    panelCenter.add(panelCenterBottom,BorderLayout.SOUTH);
    //panelCenter.add(panelCenterCenter,BorderLayout.CENTER);
    //panelCenter.add(label,BorderLayout.NORTH);

    panel = new JPanel(new BorderLayout());
    panel.setPreferredSize(new Dimension(100, 300));
    panel.add(panelCenter,BorderLayout.CENTER);
    panel.add(panelEast,BorderLayout.EAST);
    panel.add(panelWest,BorderLayout.WEST);
    panel.add(panelBottom,BorderLayout.SOUTH);
    panel.add(label,BorderLayout.NORTH);

    generateWindowSize();
    this.addComponentListener(new frameResized());
    this.addWindowStateListener(new frameResizedIcon());

    this.setContentPane(panel);
    this.setVisible(true);
        //this.add(answerLabel,BorderLayout.SOUTH);

    }

    public class frameResized implements ComponentListener {

        @Override
        public void componentResized(ComponentEvent e) {
            generateWindowSize();
        }

        @Override
        public void componentMoved(ComponentEvent e) {
            generateWindowSize();
        }

        @Override
        public void componentShown(ComponentEvent e) {
            generateWindowSize();
        }

        @Override
        public void componentHidden(ComponentEvent e) {
            generateWindowSize();
        }

    }

    public class frameResizedIcon implements WindowStateListener {
        @Override
        public void windowStateChanged(WindowEvent e) {
            generateWindowSize();
        }
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
        if(e.getSource()==fourthButton) {
            if(answerButton == 4) {
                rightAnswer();
            } else {
                wrongAnswer();
            }
        }
        if(e.getSource()==fifthButton) {
            if(answerButton == 5) {
                rightAnswer();
            } else {
                wrongAnswer();
            }
        }
    }
}