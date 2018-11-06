package com.Adil;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class GameThread extends Thread {
    private int countTurns = 0;
    private boolean isOver = false;
    private double endFilling = 0;
    private long changesOfStates = 0;
    private double filling;
    private long timeMs;
    @Override
    public void run() {
        Date dateStart = new Date();
        Main.getInputFrame().setVisible(false);
        Main.getInputFrame().dispose();
        Field.fill(Constants.getFillPercent());
        while (!isOver) {
            for (int i = 0; i < Constants.FIELD_SIZE; i++) {
                for (int j = 0; j < Constants.FIELD_SIZE; j++) {
                    if(Field.getCell(i,j) != Game.getCell(i,j)) {
                        if (Field.getCell(i, j)) {
                            filling++; //show later every turn??
                            changesOfStates++;
                            Main.getBlackPixel().paintComponent(Main.getGraphics(), i, j);
                        } else {
                            changesOfStates++;
                            Main.getWhitePixel().paintComponent(Main.getGraphics(), i, j);
                        }
                    }
                }
            }
            filling = filling / Constants.FIELD_SIZE;
            Game.update();
            try {
                Thread.sleep(Constants.getDELAY());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            countTurns++;
            isOver = Game.isOver();
            if(!isOver) {filling = 0;}
            else{countEndFilling();}
        }
        timeMs = new Date().getTime() - dateStart.getTime();
        showStat();
        endAnimation();
        System.out.println(countTurns);

       // Main.getGameFrame().setVisible(false); //TODO: to know why?
       // Main.getGameFrame().dispose();
    }

    private void countEndFilling() {
        for (int i = 0; i < Constants.FIELD_SIZE; i++) {
            for (int j = 0; j < Constants.FIELD_SIZE; j++) {
                if (Field.getCell(i, j)) {
                    endFilling++;
                }
            }
        }
        endFilling = endFilling / (Constants.FIELD_SIZE*Constants.FIELD_SIZE) * 100;
    }

    private void showStat() {
        Runnable r = new Runnable() {
            //TODO: add statistics on close: frame with count of turns, percent of begin filling, percent of end filling, timeMs, (changes of states??);
            public void run() {
                String pt1 = "<html><body width='";
                String pt0 = "<html><body height='";
                String pt2 =
                        "'><h1>Statistics</h1>" +
                                "<p>count of turns = " + countTurns + ";</p>" +
                                "<p>percent of begin filling = " + Constants.getFillPercent() + ";</p>" +
                                "<p>percent of end filling = " + endFilling + ";</p>" +
                                "<p>time = " + (double)timeMs/1000 + ";</p>" +
                                "<p>changes of states = " + changesOfStates + ";</p>"+
                                "<p>FPS = " + (double)(countTurns*1000/timeMs) + ";</p>"
                                + "<p></p>" + "<p></p>";
                String pt3 = "<h3>Made by Adil Sharipov<h3>";
               // String pt4 = "<h5>help me learn Java please<h5>";

                JPanel p = new JPanel( new BorderLayout() );

                int width = 500;
                int height = 700;
                String s = pt0 + height + pt1 + width + pt2 + pt3;

                JOptionPane.showMessageDialog(p, s);
            }
        };
        SwingUtilities.invokeLater(r);
    }

    private void endAnimation() {
        for (int k = 0; k < 15; k++) {
            for (int i = 0; i < Constants.FIELD_SIZE; i++) {
                for (int j = 0; j < Constants.FIELD_SIZE; j++) {
                    if(Field.getCell(i,j) != Game.getCell(i,j)) {
                        if (Field.getCell(i, j)) {
                            Main.getBlackPixel().paintComponent(Main.getGraphics(), i, j);
                        } else {
                            Main.getWhitePixel().paintComponent(Main.getGraphics(), i, j);
                        }
                    }
                }
            }
            Game.update();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

