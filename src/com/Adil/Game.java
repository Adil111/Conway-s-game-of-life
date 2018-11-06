package com.Adil;

public class Game {
    private static int offset1 = Constants.FIELD_SIZE - 1;
    private static int offset2 = Constants.FIELD_SIZE + 1;
    private static boolean[][] CURRENT_TURN = new boolean[Constants.FIELD_SIZE][Constants.FIELD_SIZE];
    private static boolean[][] LAST_TURN = new boolean[Constants.FIELD_SIZE][Constants.FIELD_SIZE];

    private Game(){}

    public static void update(){
        for (int i = 0; i < Constants.FIELD_SIZE; i++) {   //update to this turn
            for (int j = 0; j < Constants.FIELD_SIZE; j++) {
                LAST_TURN[i][j] = CURRENT_TURN[i][j];
                CURRENT_TURN[i][j] = Field.getCell(i,j);
            }
        }
        for (int i = 0; i < Constants.FIELD_SIZE; i++) {   //update to arr in Field to the next turn
            for (int j = 0; j < Constants.FIELD_SIZE; j++) {
                Field.setCell(i, j,(evolve(CURRENT_TURN, i, j)));
            }
        }
    }

    private static boolean evolve(boolean[][] current, int i, int j) {
        int nearestCount = 0;
        int left = (i + offset1) % Constants.FIELD_SIZE;
        int top = (j + offset1) % Constants.FIELD_SIZE;
        int right = (i + offset2) % Constants.FIELD_SIZE;
        int down = (j + offset2) % Constants.FIELD_SIZE;;

        boolean state = current[i][j];

        if(current[left][top]) nearestCount++;
        if(current[left][j]) nearestCount++;
        if(current[left][down]) nearestCount++;
        if(current[i][top]) nearestCount++;
        if(current[i][down]) nearestCount++;
        if(current[right][top]) nearestCount++;
        if(current[right][j]) nearestCount++;
        if(current[right][down]) nearestCount++;

        if(nearestCount > 3 || nearestCount < 2){ state = false; }
        if(nearestCount == 3){ state = true; }
        return state;
    }

    public static boolean isOver(){
        for (int i = 0; i < Constants.FIELD_SIZE; i++) {
            for (int j = 0; j < Constants.FIELD_SIZE; j++) {
                if(Field.getCell(i,j) != LAST_TURN[i][j]){return false;}
            }
        }
        return true;
    }
    public static boolean getCell(int i, int j){
        return CURRENT_TURN[i][j];
    }
}
