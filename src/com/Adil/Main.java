package com.Adil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    private static PixelComponent blackPixel;
    private static PixelComponent whitePixel;
    private static Graphics graphics;
    private static GameFrame gameFrame;
    private static InputFrame inputFrame;
    private static GameThread gameThread;
    public static void main(String[] args) {
        System.out.println();
        //TODO: add statistics on close: frame with count of turns, percent of begin filling, percent of end filling, time, (changes of states??); - done
        //TODO: add checking by last 10 turns after every 100 turns, reduce every turn checking - Done Life, deth? - none
        //TODO: check values on start ~ rewrite InputFrame
        //TODO: draw borders
        //TODO: add alive cell on click
        //TODO: add stop button
        //TODO: add choosing count of cells
        //TODO: Bitset, m?)
        initGUI();
        waitForStart();
    }

    private static void waitForStart() {
        inputFrame = new InputFrame();
        inputFrame.start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Constants.setFillPercent(Integer.parseInt(inputFrame.getFillPercent().getText()));
                Constants.setDeathChance(Integer.parseInt(inputFrame.getDeathChance().getText()));
                Constants.setLifeChance(Integer.parseInt(inputFrame.getLifeChance().getText()));
                Constants.setDELAY(Integer.parseInt(inputFrame.getDelayMS().getText()));
                JOptionPane.showMessageDialog(inputFrame, "Игра началась!");
                gameThread = new GameThread();
                gameThread.start();
            }
        });
    }

    public static void initGUI() {
        Field.create();
        gameFrame = new GameFrame();
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setVisible(true);
        gameFrame.setLocationRelativeTo(null);

        graphics = gameFrame.getGraphics();
        blackPixel = new PixelComponent(Color.BLACK);
        whitePixel = new PixelComponent(Color.WHITE);
    }

    public static PixelComponent getBlackPixel() {
        return blackPixel;
    }

    public static PixelComponent getWhitePixel() {
        return whitePixel;
    }

    public static InputFrame getInputFrame(){
        return inputFrame;
    }

    public static Graphics getGraphics(){
        return graphics;
    }

    public static GameFrame getGameFrame() { return gameFrame; }
}
