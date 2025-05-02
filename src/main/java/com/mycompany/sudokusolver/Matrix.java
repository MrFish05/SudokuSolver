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
    
    /**
     * Creates a Matrix - Array and fills it with numbers
     */
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
    
    /**
     * Removes a specific number in a specific field at its cordinates
     * @param number
     * @param xPos
     * @param yPos 
     */
    public void removeNumberFromMatrix(int number, int xPos, int yPos) {
        if(number <= 9 && number >= 1) {
            if(xPos < 10 && xPos > 0) {
                if(yPos < 10 && yPos > 0) {
                    for(int i = 0; i < matrix[xPos - 1][yPos - 1].size(); i++) {
                        if(matrix[xPos - 1][yPos - 1].get(i).equals(number)) {
                            matrix[xPos - 1][yPos - 1].remove(i);
                        }
                    }
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
    
    /**
     * Removes the same number in the entire row
     * @param number
     * @param xPos 
     */
    public void removeNumberInRow(int number, int xPos) {
        if(number <= 9 && number >= 1) {
            if(xPos < 10 && xPos > 0) {
                for(int i = 0; i < 9; i++) {
                    for(int j = 0; j < matrix[xPos - 1][i].size(); j++){
                        if(matrix[xPos - 1][i].get(j).equals(number)) {
                            this.matrix[xPos - 1][i].remove(j);
                        }
                    }
                }
            } else {
                System.out.println("ERROR: wrong xPos ["+xPos+"]!");
            }
        } else {
            System.out.println("ERROR: wrong number ["+number+"]!");
        }
    }
    
    /**
     * Removes the same number in the entire colum
     * @param number
     * @param yPos 
     */
    public void removeNumberInCol(int number, int yPos) {
        if(number <= 9 && number >= 1) {
            if(yPos < 10 && yPos > 0) {
                for(int i = 0; i < 9; i++) {
                    for(int j = 0; j < matrix[i][yPos - 1].size(); j++){
                        if(matrix[i][yPos - 1].get(j).equals(number)) {
                            this.matrix[i][yPos - 1].remove(j);
                        }
                    }
                }
            } else {
                System.out.println("ERROR: wrong yPos ["+yPos+"]!");
            }
        } else {
            System.out.println("ERROR: wrong number ["+number+"]!");
        }
    }
    
    /**
     * Removes all Numbers in the specific Field at its cordinates
     * @param xPos
     * @param yPos 
     */
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
    
    /**
     * Removes a number from a specific quadrant
     * @param quadrantNumber
     * @param number 
     */
    public void removeNumberInAQuadrant(int quadrantNumber, int number) {
        int xPos = 0;
        int yPos = 0;
        
        switch(quadrantNumber) {
            case 1:
                xPos = 0;
                yPos = 0;
                break;
            case 2:
                xPos = 0;
                yPos = 3;
                break;
            case 3:
                xPos = 0;
                yPos = 6;
                break;
            case 4:
                xPos = 3;
                yPos = 0;
                break;
            case 5:
                xPos = 3;
                yPos = 3;
                break;
            case 6:
                xPos = 3;
                yPos = 6;
                break;
            case 7:
                xPos = 6;
                yPos = 0;
                break;
            case 8:
                xPos = 6;
                yPos = 3;
                break;
            case 9:
                xPos = 6;
                yPos = 6;
                break;
            default:
                System.out.println("ERROR: Quadrant dos not exist!");
                break;
        }
        
        for(int i = xPos; i < xPos + 3; i++) {
            for(int j = yPos; j < yPos + 3; j++) {
                for(int k = 0; k < matrix[i][j].size(); k++) {
                    if(matrix[i][j].get(k).equals(number)) {
                        matrix[i][j].remove(k);
                    }
                }
            }
        }
    }
    
    public void fieldScanner(Field f) {
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(f.getField()[i][j] > 0) {
                    matrix[i][j].clear();
                    removeNumberInRow(f.getField()[i][j], i + 1);
                    removeNumberInCol(f.getField()[i][j], j + 1);
                    
                    if(i < 3 && j < 3) {
                        removeNumberInAQuadrant(1, f.getField()[i][j]);
                    } else if(i < 3 && j < 6) {
                        removeNumberInAQuadrant(2, f.getField()[i][j]);
                    } else if(i < 3 && j < 9) {
                        removeNumberInAQuadrant(3, f.getField()[i][j]);
                    } else if(i < 6 && j < 3) {
                        removeNumberInAQuadrant(4, f.getField()[i][j]);
                    } else if(i < 6 && j < 6) {
                        removeNumberInAQuadrant(5, f.getField()[i][j]);
                    } else if(i < 6 && j < 9) {
                        removeNumberInAQuadrant(6, f.getField()[i][j]);
                    } else if(i < 9 && j < 3) {
                        removeNumberInAQuadrant(7, f.getField()[i][j]);
                    } else if(i < 9 && j < 6) {
                        removeNumberInAQuadrant(8, f.getField()[i][j]);
                    } else if(i < 9 && j < 9) {
                        removeNumberInAQuadrant(9, f.getField()[i][j]);
                    }
                }
            }
        }
    }
    
    /**
     * Searches for numbers that are lonely in the Matrix and sets them into the game Field
     * @param f 
     */
    public void findLonelyNumber(Field f) {
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(matrix[i][j].size() == 1) {
                    f.setNumberInField(matrix[i][j].get(0), i+1, j+1);
                    matrix[i][j].clear();
                }
            }
        }
    }
    
    public void horizontalUniqueNumber(int xPos, Field f) {
        int count = 0;
        for(int x = 1; x < 10; x++) {
            for(int i = 0; i < 9; i++) {
                for(int j = 0; j < matrix[xPos][i].size(); j++) {
                    if(matrix[xPos][i].get(j) == x) {
                        count++;
                    }   
                }
            }
            
            if(count == 1) {
                for(int a = 0; a < 9; a++) {
                    for(int b = 0; b < matrix[xPos - 1][a].size(); b++) {
                        if(matrix[xPos - 1][a].get(b) == x) {
                            f.setNumberInField(x, xPos, a + 1);
                        }
                    }
                }
            }
        }
    }
    
    public void verticalUniqueNumber(int yPos, Field f) {
        int count = 0;
        
        for(int x = 1; x < 10; x++) {
            for(int i = 0; i < 9; i++) {
                for(int j = 0; j < matrix[i][yPos - 1].size(); j++) {
                    if(matrix[i][yPos - 1].get(j) == x) {
                        count++;
                    }   
                }
            }
            
            if(count == 1) {
                for(int a = 0; a < 9; a++) {
                    for(int b = 0; b < matrix[a][yPos - 1].size(); b++) {
                        if(matrix[a][yPos - 1].get(b) == x) {
                            f.setNumberInField(x, a + 1, yPos);
                        }
                    }
                }
            }
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
