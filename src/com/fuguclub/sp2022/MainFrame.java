package com.fuguclub.sp2022;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

import static com.fuguclub.sp2022.Main.*;

public class MainFrame extends JFrame implements ActionListener{

    public static ImageIcon resistor;
    public static ImageIcon icon;
    public static JTextField textField;
    public static JButton textFieldButton;
    public static JButton retryButton;
    public static JButton firstButton;
    public static JButton secondButton;
    public static JButton thirdButton;
    public static JButton fourthButton;
    public static JButton fifthButton;
    public static JPanel panel;
    public static JPanel panelTolerance;
    public static JPanel panelCenter;
    public static JPanel panelCenterBottom;
    public static JPanel panelEast;
    public static JPanel panelWest;
    public static JPanel panelBottom;
    public static JPanel panelBottomBottom;
    public static JPanel panelBottomCenter;
    public static JPanel panelBottomCenterRetry;
    public static JPanel panelBottomEast;
    public static JPanel panelBottomWest;
    public static JPanel panelFirstBand;
    public static JPanel panelSecondBand;
    public static JPanel panelMultiplierBand;
    public static JPanel panelToleranceBand;
    public static JLabel label;
    public static JLabel labelBottom;
    //JLabel labelBottom;
    public static JLabel labelAnswer;
    public static JLabel labelResistor;
    public static JPanel nonVisiblePanel;
    public static JPanel nonVisiblePanel2;
    public static JPanel nonVisiblePanel3;
    public static JPanel nonVisiblePanel4;
    public static JRadioButton firstChoice;
    public static JRadioButton secondChoice;
    public static JRadioButton thirdChoice;
    public static boolean isRightTolerance;

    public void rightAnswer(){
        System.out.println("init: rightAnswer");

        ImageIcon checkmarkImage = new ImageIcon(getClass().getClassLoader().getResource("checkmark.png"));
        Image checkmark2 = checkmarkImage.getImage();
        Image checkmarkResized = checkmark2.getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH);
        ImageIcon checkmark = new ImageIcon(checkmarkResized);

        labelAnswer.setText("Bonne réponse! Bravo");
        labelAnswer.setFont(new Font("Arial",Font.BOLD,60));
        labelAnswer.setIcon(checkmark);
        labelAnswer.setIconTextGap(40);
        labelAnswer.setVisible(true);

        generateRetryButton();
    }

    public void wrongAnswer(){
        System.out.println("init: wrongAnswer");

        ImageIcon wrongImage = new ImageIcon(getClass().getClassLoader().getResource("wrong.png"));
        Image wrong2 = wrongImage.getImage();
        Image wrongResized = wrong2.getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH);
        ImageIcon wrong = new ImageIcon(wrongResized);

        labelAnswer.setText("Mauvaise réponse! Ré-essai");
        labelAnswer.setFont(new Font("Arial",Font.BOLD,60));
        labelAnswer.setIcon(wrong);
        labelAnswer.setIconTextGap(40);
        labelAnswer.setVisible(true);

        generateRetryButton();
    }

    public static void generateButtonAnswer(){
        System.out.println("init: generateAnswer");

        answerButton = rand.nextInt((5 - 1) + 1) + 1;

        generateRightAnswer();

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
    }

    public void generateWindowSize(){

        int frameWidth = getWidth();
        int frameHeight = getHeight();

        int buttonBorderWidth = frameWidth / 7;
        int resistorWidth = buttonBorderWidth * 5;
        int resistorHeight = frameHeight / 2;
        int bandHeight = resistorHeight / 8;
        int bandWidth = resistorWidth / 15;

        panelBottomEast.setPreferredSize(new Dimension(buttonBorderWidth, 100));
        panelBottomWest.setPreferredSize(new Dimension(buttonBorderWidth, 100));
        panelEast.setPreferredSize(new Dimension(buttonBorderWidth, 100));
        panelWest.setPreferredSize(new Dimension(buttonBorderWidth, 100));

        ImageIcon resistorImage = new ImageIcon(getClass().getClassLoader().getResource("resistor.png"));
        Image resistor2 = resistorImage.getImage();
        Image resistorResized = resistor2.getScaledInstance(resistorWidth, resistorHeight, java.awt.Image.SCALE_FAST);
        resistor = new ImageIcon(resistorResized);

        labelResistor.setPreferredSize(new Dimension(resistorWidth, resistorHeight));
        labelResistor.setLayout((new GridLayout(3, 8, bandWidth, bandHeight)));
        labelResistor.setIcon(resistor);
    }

    public static void generateBandColor(){
        System.out.println("init: generateBandColor");

        panelFirstBand = new JPanel();
        panelFirstBand.setBackground(firstBandColor);
        panelFirstBand.setOpaque(true);
        panelFirstBand.setVisible(true);

        panelSecondBand = new JPanel();
        panelSecondBand.setBackground(secondBandColor);
        panelSecondBand.setOpaque(true);
        panelSecondBand.setVisible(true);

        panelMultiplierBand = new JPanel();
        panelMultiplierBand.setBackground(multiplierBandColor);
        panelMultiplierBand.setOpaque(true);
        panelMultiplierBand.setVisible(true);

        panelToleranceBand = new JPanel();
        panelToleranceBand.setBackground(toleranceBandColor);
        panelToleranceBand.setOpaque(true);
        panelToleranceBand.setVisible(true);
    }

    public static void generateRetryButton(){
        System.out.println("init: generateRetryButton");
        labelBottom.setText("");
        panelBottomCenterRetry = new JPanel(new GridBagLayout());
        panelBottomCenterRetry.add(retryButton, new GridBagConstraints());
        panelBottomCenterRetry.setVisible(true);
        panelBottom.add(panelBottomCenterRetry,BorderLayout.CENTER);
        panelBottomCenter.setVisible(false);
    }

    public void restartApplication() throws IOException, URISyntaxException {
        final String javaBin = System.getProperty("java.home") + File.separator + "bin" + File.separator + "java";
        final File currentJar = new File(Main.class.getProtectionDomain().getCodeSource().getLocation().toURI());

        /* is it a jar file? */
        if(!currentJar.getName().endsWith(".jar"))
            return;

        /* Build command: java -jar application.jar */
        final ArrayList<String> command = new ArrayList<String>();
        command.add(javaBin);
        command.add("-jar");
        command.add(currentJar.getPath());

        final ProcessBuilder builder = new ProcessBuilder(command);
        builder.start();
        System.exit(0);
    }

    MainFrame(){
    System.out.println("init: MainFrame");

    ImageIcon iconImage = new ImageIcon(getClass().getClassLoader().getResource("icon.png"));
    Image icon2 = iconImage.getImage();
    Image iconResized = icon2.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH);
    icon = new ImageIcon(iconResized);

    Border border = BorderFactory.createLineBorder(Color.BLACK,10,false);
    //System.out.println(randomNum2);

    //Title
    label = new JLabel();
    label.setText("Calculateur de Résistance");
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

    retryButton = new JButton();
    retryButton.setText("Ré-essayer");
    retryButton.setPreferredSize(new Dimension(250,80));
    retryButton.setFocusable(false);
    retryButton.addActionListener(this);
    retryButton.setVisible(true);

    labelBottom = new JLabel();
    labelBottom.setText("Choisis la bonne réponse");
    labelBottom.setFont(new Font("MV Boli",Font.BOLD,20));
    labelBottom.setVerticalAlignment(JLabel.TOP);
    labelBottom.setHorizontalAlignment(JLabel.CENTER);
    labelBottom.setVerticalTextPosition(JLabel.TOP);
    labelBottom.setPreferredSize(new Dimension(10, 50));
    labelBottom.setVisible(true);

    textFieldButton = new JButton();
    textFieldButton.setFocusable(false);
    textFieldButton.addActionListener(this);
    textFieldButton.setText("Confirmer");
    textFieldButton.setVisible(true);

    textField = new JTextField();
    textField.setPreferredSize(new Dimension(250,40));
    textField.setText("Cliquez pour écrire du texte");
    textField.addFocusListener(new textFieldFocus());
    textField.setFont(new Font("Arial",Font.PLAIN,25));
    textField.setForeground(Color.BLACK);
    textField.setBackground(Color.WHITE);
    textField.setCaretColor(Color.BLACK);

    firstButton = new JButton();
    firstButton.setFocusable(false);
    firstButton.addActionListener(this);
    firstButton.setVisible(true);

    secondButton = new JButton();
    secondButton.setFocusable(false);
    secondButton.addActionListener(this);
    secondButton.setVisible(true);

    thirdButton = new JButton();
    thirdButton.setFocusable(false);
    thirdButton.addActionListener(this);
    thirdButton.setVisible(true);

    fourthButton = new JButton();
    fourthButton.setFocusable(false);
    fourthButton.addActionListener(this);
    fourthButton.setVisible(true);

    fifthButton = new JButton();
    fifthButton.setFocusable(false);
    fifthButton.addActionListener(this);
    fifthButton.setVisible(true);

    generateButtonAnswer();
    generateBandColor();

    nonVisiblePanel = new JPanel();
    nonVisiblePanel.setVisible(false);
    nonVisiblePanel2 = new JPanel();
    nonVisiblePanel2.setVisible(false);
    nonVisiblePanel3 = new JPanel();
    nonVisiblePanel3.setVisible(false);
    nonVisiblePanel4 = new JPanel();
    nonVisiblePanel4.setVisible(false);

    labelResistor = new JLabel();
    labelResistor.setLayout((new GridLayout(3, 8, 50, 10)));
    labelResistor.setPreferredSize(new Dimension(500, 600));
    labelResistor.setHorizontalAlignment(JLabel.CENTER);
    labelResistor.add(new JPanel());
    labelResistor.add(new JPanel());
    labelResistor.add(new JPanel());
    labelResistor.add(new JPanel());
    labelResistor.add(new JPanel());
    labelResistor.add(new JPanel());
    labelResistor.add(new JPanel());
    labelResistor.add(new JPanel());

    labelResistor.add(nonVisiblePanel);
    labelResistor.add(nonVisiblePanel2);
    labelResistor.add(panelFirstBand);
    labelResistor.add(panelSecondBand);
    labelResistor.add(panelMultiplierBand);
    labelResistor.add(panelToleranceBand);
    labelResistor.add(nonVisiblePanel3);
    labelResistor.add(nonVisiblePanel4);

    labelResistor.add(new JPanel());
    labelResistor.add(new JPanel());
    labelResistor.add(new JPanel());
    labelResistor.add(new JPanel());
    labelResistor.add(new JPanel());
    labelResistor.add(new JPanel());
    labelResistor.add(new JPanel());
    labelResistor.add(new JPanel());

    labelAnswer = new JLabel();
    labelAnswer.setPreferredSize(new Dimension(80, 80));
    labelAnswer.setHorizontalAlignment(JLabel.CENTER);
    labelAnswer.setVerticalAlignment(JLabel.CENTER);

    //GUI
    this.setTitle("School Project 2022");
    this.setLayout(new BorderLayout());
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit out of application
    this.setResizable(true);
    this.setSize(1000,1000);
    this.setIconImage(icon.getImage());
    this.getContentPane().setBackground(Color.WHITE);

    panelBottomBottom = new JPanel(new BorderLayout());
    panelBottomBottom.setPreferredSize(new Dimension(100, 50));
    panelBottomEast = new JPanel(new BorderLayout());
    panelBottomWest = new JPanel(new BorderLayout());

    firstChoice = new JRadioButton("∓5%");
    firstChoice.addActionListener(this);
    secondChoice = new JRadioButton("∓10%");
    secondChoice.addActionListener(this);
    thirdChoice = new JRadioButton("∓20%");
    thirdChoice.addActionListener(this);

    ButtonGroup group = new ButtonGroup();
    group.add(firstChoice);
    group.add(secondChoice);
    group.add(thirdChoice);

    panelTolerance = new JPanel(new GridLayout(3, 1, 1, 1));
    panelTolerance.add(firstChoice);
    panelTolerance.add(secondChoice);
    panelTolerance.add(thirdChoice);
    panelTolerance.setVisible(true);

    panelBottom = new JPanel(new BorderLayout());
    panelBottom.setPreferredSize(new Dimension(50, 200));
    panelBottom.setBorder(border);
    panelBottom.add(labelBottom,BorderLayout.NORTH);
    //panelBottom.add(secondButton,BorderLayout.CENTER);
    panelBottom.add(panelBottomBottom,BorderLayout.SOUTH);
    panelBottom.add(panelBottomEast,BorderLayout.EAST);
    panelBottom.add(panelBottomWest,BorderLayout.WEST);

    panelEast = new JPanel(new BorderLayout());
    panelWest = new JPanel(new BorderLayout());

    panelCenterBottom = new JPanel(new BorderLayout());
    panelCenterBottom.add(labelAnswer,BorderLayout.CENTER);

    panelCenter = new JPanel(new BorderLayout());
    //panelCenter.setBackground(Color.red);
    panelCenter.setOpaque(true);
    panelCenter.add(panelCenterBottom,BorderLayout.SOUTH);

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
    this.setLocationRelativeTo(null);
    this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    this.setContentPane(panel);
    this.setVisible(true);
    this.setAlwaysOnTop(true);
    this.setAlwaysOnTop(false);

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

    public class textFieldFocus implements FocusListener {
        @Override
        public void focusGained(FocusEvent e) {
            textField.setText("");
        }

        @Override
        public void focusLost(FocusEvent e) {
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==firstChoice) {
            if(toleranceBand.equals("∓5%")) {
                isRightTolerance = true;
            } else {
                isRightTolerance = false;

            }
        }

        if(e.getSource()==secondChoice) {
            if(toleranceBand.equals("∓10%")) {
                isRightTolerance = true;
            } else {
                isRightTolerance = false;
            }
        }

        if(e.getSource()==thirdChoice) {
            if(toleranceBand.equals("∓20%")) {
                isRightTolerance = true;
            } else {
                isRightTolerance = false;
            }
        }

        if(e.getSource()==textFieldButton){
            if(textField.getText().equals(rawAnswerText) && isRightTolerance) {
                rightAnswer();
            } else {
                wrongAnswer();
                System.out.println(rawAnswerText);
            }
        }

        if(e.getSource()==retryButton){
            System.out.println("closing program");
            try {
                restartApplication();
            } catch (IOException | URISyntaxException ex) {
                throw new RuntimeException(ex);
            }
            //mainFrame.dispatchEvent(new WindowEvent(mainFrame, WindowEvent.WINDOW_CLOSING));
        }

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
