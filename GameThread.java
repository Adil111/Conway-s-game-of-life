package com.Adil;

public class GameThread extends Thread {
    @Override
    public void run() {
        Main.frame2.setVisible(false);
        Main.frame2.dispose();
        Field.fill(Constants.FILL_PERCENT);
        while (!Game.isOver()) {
            for (int i = 0; i < Constants.FIELD_SIZE; i++) {
                for (int j = 0; j < Constants.FIELD_SIZE; j++) {
                    if(Field.getCell(i,j) != Game.getCell(i,j)) {
                        if (Field.getCell(i, j)) {
                            Main.black.paintComponent(Main.graphics, i, j);
                        } else {
                            Main.white.paintComponent(Main.graphics, i, j);
                        }
                    }
                }
            }
            Game.update();
            try {
                Thread.sleep(Constants.DELAY);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

