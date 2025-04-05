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
     * Creates a empty field
     */
    public Field() {
        this.field = new int[9][9];
    }
    
    /**
     * Sets a number inside the field at the xPos and yPos
     * @param number
     * @param xPos
     * @param yPos 
     */
    public void setNumberInField(int number, int xPos, int yPos) {
        if(number <= 9 && number >= 1) {
            if(xPos < 10 && xPos > 0) {
                if(yPos < 10 && yPos > 0) {
                    this.field[xPos - 1][yPos - 1] = number;
                } else {
                    System.out.println("ERROR: wrong yPos ["+yPos+"]!");
                }
            } else {
                System.out.println("ERROR: wrong xPos ["+xPos+"]!");
            }
        } else {
            System.out.println("ERROR: wrong number ["+number+"]!");
        }
    }
    
    public int[][] getField() {
        return this.field;
    }
    
    /**
     * Prints the field with its values
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
