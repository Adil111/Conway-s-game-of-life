package com.Adil;

public class Field {
    private static boolean[][] field;
    private Field(){}

    public static void create(){
        field = new boolean[Constants.FIELD_SIZE][Constants.FIELD_SIZE];
    }

    public static void fill(double percents){
        for (int i = 0; i < Constants.FIELD_SIZE; i++) {
            for (int j = 0; j < Constants.FIELD_SIZE ; j++) {
                if(Math.random() * 100 <= percents) {
                    field[i][j] = !field[i][j];
                }
            }
        }
    }

    public static void clean(){
        for (int i = 0; i < Constants.FIELD_SIZE; i++) {
            for (int j = 0; j < Constants.FIELD_SIZE ; j++) {
                field[i][j] = false;
            }
        }
    }

    public static boolean getCell(int i, int j){
        return field[i][j];
    }

    public static void setCell(int i, int j, boolean state){
        boolean lastState = field[i][j];
        if(lastState == state){ return; }

        if(lastState){
            if(Constants.DEATH_CHANCE >= Math.random()*100) {field[i][j] = state;}
        }

        else{
            if(Constants.LIFE_CHANCE >= Math.random()*100) {field[i][j] = state;}
        }

    }
}
