/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sudokusolver;

import java.util.ArrayList;

/**
 *
 * @author mrfish
 */
public class Matrix {
    private ArrayList<Integer>[][] matrix;
    private ArrayList<Integer> matrixNumber;
    
    public Matrix() {
        this.matrix = new ArrayList[9][9];
        matrixNumber = new ArrayList<>();
        
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                this.matrix[i][j] = matrixNumber = new ArrayList<>();
                for(int k = 1; k < 10; k++) {
                    this.matrixNumber.add(k);
                }
            }   
        }
    }
    
    public void removeNumberFromMatrix(int number, int xPos, int yPos) {
        if(number <= 9 && number >= 1) {
            if(xPos < 10 && xPos > 0) {
                if(yPos < 10 && yPos > 0) {
                    this.matrix[xPos - 1][yPos - 1].remove(number - 1);
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
    
    public void removeNumberInRow(int number, int xPos, int yPos) {
        if(number <= 9 && number >= 1) {
            if(xPos < 10 && xPos > 0) {
                for(int i = 0; i < 9; i++) {
                    this.matrix[xPos - 1][i].remove(number - 1);
                }
            } else {
                System.out.println("ERROR: wrong xPos ["+xPos+"]!");
            }
        } else {
            System.out.println("ERROR: wrong number ["+number+"]!");
        }
    }
    
    public void removeNumberInCol(int number, int xPos, int yPos) {
        if(number <= 9 && number >= 1) {
            if(yPos < 10 && yPos > 0) {
                for(int i = 0; i < 9; i++) {
                    this.matrix[i][yPos - 1].remove(number - 1);
                }
            } else {
                System.out.println("ERROR: wrong yPos ["+yPos+"]!");
            }
        } else {
            System.out.println("ERROR: wrong number ["+number+"]!");
        }
    }
    
    public void removeAllNumbersInMatrix(int xPos, int yPos) {
        if(xPos < 10 && xPos > 0) {
                if(yPos < 10 && yPos > 0) {
                    this.matrix[xPos - 1][yPos - 1].clear();
                } else {
                    System.out.println("ERROR: wrong yPos ["+yPos+"]!");
                }
            } else {
                System.out.println("ERROR: wrong xPos ["+xPos+"]!");
            }
    }
    
    @Override
    public String toString() {
        String x = "";
        int nextLine = 1;
        
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(nextLine == 9) {
                    x = x+matrix[i][j]+"\n";
                    nextLine = 1;
                } else {
                    x = x+matrix[i][j]+" ";
                    nextLine++;
                }     
            }
        }
        return x;
    }
}
