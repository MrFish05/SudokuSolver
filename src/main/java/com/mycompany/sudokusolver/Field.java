/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sudokusolver;

/**
 *
 * @author mrfish
 */
public class Field {
    private int[][] field;
    
    /**
     * creates a empty 9x9 field
     */
    public Field() {
        this.field = new int[9][9];
    }
    
    /**
     * sets a number inside the field at the yPos and xPos
     * @param yPos y position
     * @param xPos x position
     * @param number number that is going to be added
     */
    public void setNumberInField(int yPos, int xPos, int number) {
        if(number < 10 && number > 0) {
            if(yPos < 10 && yPos > 0) {
                if(xPos < 10 && xPos > 0) {
                    this.field[yPos - 1][xPos - 1] = number;
                } else {
                    System.out.println("ERROR: wrong xPos value ["+xPos+"]!");
                }
            } else {
                System.out.println("ERROR: wrong yPos value ["+yPos+"]!");
            }
        } else {
            System.out.println("ERROR: wrong number size ["+number+"]!");
        }
    }
    
    /**
     * check if game is finished
     * @return game status
     */
    public boolean gameFinished() {
        int x = 0;
        
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(field[i][j] > 0) {
                    x++;
                }
            }
        }
        
        if(x == 81) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * gives the field
     * @return field
     */
    public int[][] getField() {
        return this.field;
    }
    
    /**
     * prints the field
     * @return field
     */
    @Override
    public String toString() {
        String x = "";
        int nextLine = 1;
        
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(nextLine == 9) {
                    x = x+field[i][j]+"\n";
                    nextLine = 1;
                } else {
                    x = x+field[i][j]+" ";
                    nextLine++;
                }     
            }
        }
        return x;
    }
}
