package com.Adil;


public class Constants {
    private Constants(){}

    public static final int FIELD_SIZE = 100;
    public static final int CELL_SIZE = 10;
    public static final int FRAME_WIDTH = 1080;
    public static final int FRAME_HEIGHT = 1080;

    private static double FILL_PERCENT;
    private static double DEATH_CHANCE;
    private static double LIFE_CHANCE;
    private static int DELAY;

    public static void setFillPercent(double fillPercent) {
        FILL_PERCENT = fillPercent;
    }

    public static void setDeathChance(double deathChance) {
        DEATH_CHANCE = deathChance;
    }

    public static void setLifeChance(double lifeChance) {
        LIFE_CHANCE = lifeChance;
    }

    public static void setDELAY(int DELAY) {
        Constants.DELAY = DELAY;
    }

    public static double getFillPercent() {
        return FILL_PERCENT;
    }

    public static double getDeathChance() {
        return DEATH_CHANCE;
    }

    public static double getLifeChance() {
        return LIFE_CHANCE;
    }

    public static int getDELAY() {
        return DELAY;
    }

}



