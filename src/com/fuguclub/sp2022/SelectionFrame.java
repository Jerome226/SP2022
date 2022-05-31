package com.fuguclub.sp2022;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.fuguclub.sp2022.Main.*;
import static com.fuguclub.sp2022.MainFrame.*;

public class SelectionFrame extends JFrame implements ActionListener {

    JPanel panel;
    JLabel label;
    JPanel buttonPanel;
    JPanel panelCenter;
    JButton easyButton;
    JButton hardButton;
    SelectionFrame(){

    this.setTitle("School Project 2022");
    this.setAlwaysOnTop(true);
    this.setLayout(new BorderLayout());
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit out of application
    this.setResizable(true);
    this.setSize(600,300);

    label = new JLabel();
    label.setHorizontalAlignment(JLabel.CENTER);
    label.setVerticalAlignment(JLabel.NORTH);
    label.setSize(new Dimension(100, 100));
    label.setFont(new Font("MV Boli",Font.BOLD,25));
    label.setText("Choisir la difficulté");

    easyButton = new JButton();
    easyButton.addActionListener(this);
    easyButton.setPreferredSize(new Dimension(200, 100));

    hardButton = new JButton();
    hardButton.addActionListener(this);
    hardButton.setPreferredSize(new Dimension(200, 100));

    panel = new JPanel(new BorderLayout());
    panel.setSize(new Dimension(100, 100));
    panel.add(label);

    buttonPanel = new JPanel(new GridLayout(1, 2, 20, 20));
    buttonPanel.add(easyButton);
    buttonPanel.add(hardButton);

    panelCenter = new JPanel(new GridBagLayout());
    panelCenter.add(buttonPanel, new GridBagConstraints());

    //this.setIconImage(icon.getImage());
    this.getContentPane().setBackground(Color.WHITE);
    //this.pack();
    this.setLocationRelativeTo(null);
    this.add(panel, BorderLayout.NORTH);
    this.add(panelCenter, BorderLayout.CENTER);
    this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==easyButton) {
            easyMode();
        }

        if(e.getSource()==hardButton) {
            this.setVisible(false);
            hardMode();
        }

    }
}
