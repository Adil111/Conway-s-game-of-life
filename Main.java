package com.Adil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    static PixelComponentBlack black;
    static PixelComponentWhite white;
    static Graphics graphics;
    static GameFrame frame;
    static InputFrame frame2;
    public static void main(String[] args) {
        //TODO: rewrite gameThread and Main (add getters)
        //TODO: rewrite Pixels(make one class instead two)!!
        //TODO: add statistics on close
        //*TODO: add checking by last 10 turns after every 100 turns, reduce every turn checking
        //TODO: check values on start ~ rewrite InputFrame
        //TODO: draw borders
        //TODO: add alive cell on click
        //TODO: add stop button
        //TODO: add choosing count of cells
        initGUI();
        waitForStart();
    }

    private static void waitForStart() {
        frame2 = new InputFrame();
        frame2.start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Constants.FILL_PERCENT = Integer.parseInt(frame2.getFillPercent().getText());
                Constants.DEATH_CHANCE = Integer.parseInt(frame2.getDeathChance().getText());
                Constants.LIFE_CHANCE = Integer.parseInt(frame2.getLifeChance().getText());
                Constants.DELAY = Integer.parseInt(frame2.getDelayMS().getText());
                JOptionPane.showMessageDialog(frame2, "Игра началась!");
                GameThread thread = new GameThread();
                thread.start();
            }
        });
    }

    public static void initGUI() {
        Field.create();
        frame = new GameFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        graphics = frame.getGraphics();
        black = new PixelComponentBlack();
        white = new PixelComponentWhite();
    }
}
