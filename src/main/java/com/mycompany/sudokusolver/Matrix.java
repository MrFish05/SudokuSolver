/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sudokusolver;

import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author mrfish
 */
public class Matrix {
    private ArrayList<Integer>[][] matrix;
    private ArrayList<Integer> matrixNumber;
    
    /**
     * creates a matrix [Array] filled with number from 1 - 9
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
     * removes a specific number from the given position
     * @param yPos y position [yPos - 1]
     * @param xPos x position [xPos - 1]
     * @param number number that is going to be removed
     */
    public void removeNumberFromMatrix(int yPos, int xPos, int number) {
        if(number < 10 && number > 0) {
            if(yPos < 10 && yPos > 0) {
                if(xPos < 10 && xPos > 0) {
                    for(int i = 0; i < matrix[yPos - 1][xPos - 1].size(); i++) {
                        if(matrix[yPos - 1][xPos - 1].get(i).equals(number)) {
                            matrix[yPos - 1][xPos - 1].remove(i);
                        }
                    }
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
     * Removes the same number in the entire row
     * @param number number that is going to be removed
     * @param xPos [xPos - 1]
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
     * Removes the same number in the entire column
     * @param number number that is going to be removed
     * @param yPos [yPos - 1]
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
     * removes all numbers from the matrix at the given position
     * @param yPos x position [yPos - 1]
     * @param xPos y position [xPos - 1]
     */
    public void removeAllNumbersInMatrix(int yPos, int xPos) {
        if(yPos < 10 && yPos > 0) {
            if(xPos < 10 && xPos > 0) {
                this.matrix[yPos - 1][xPos - 1].clear();
            } else {
                System.out.println("ERROR: wrong xPos value ["+xPos+"]!");
            }
        } else {
            System.out.println("ERROR: wrong yPos value ["+yPos+"]!");
        }
    }
    
    /**
     * Removes a number from a specific quadrant
     * @param quadrantNumber number of the quadrant [1 - 9]
     * @param number number that is going to be removed
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
                    f.setNumberInField(j+1, i+1, matrix[i][j].get(0));
                    matrix[i][j].clear();
                }
            }
        }
    }
    
    public void horizontalUniqueNumber(int xPos, Field f) {
        int count = 0;
        
        for(int x = 1; x < 10; x++) {
            for(int i = 0; i < 9; i++) {
                for(int j = 0; j < matrix[xPos - 1][i].size(); j++) {
                    if(matrix[xPos - 1][i].get(j) == x) {
                        count++;
                    }   
                }
            }
            
            if(count == 1) {
                //System.out.println(x+" is unique horizontal ["+count+"]");
                
                for(int a = 0; a < 9; a++) {
                    for(int b = 0; b < matrix[xPos - 1][a].size(); b++) {
                        if(matrix[xPos - 1][a].get(b) == x) {
                            f.setNumberInField(xPos, a+1, x);
                            removeNumberInCol(x, a+1);
                            
                            matrix[xPos - 1][a].clear();
                        }
                    }
                }
            } else {
                
                if(x < 9) {
                    //System.out.println(x+" is not unique horizontal ["+count+"]");
                } else {
                    //System.out.println(x+" is not unique horizontal ["+count+"]\n");
                }
                
                count = 0;
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
                //System.out.println(x+" is unique vertical ["+count+"]");
                
                for(int a = 0; a < 9; a++) {
                    for(int b = 0; b < matrix[a][yPos - 1].size(); b++) {
                        if(matrix[a][yPos - 1].get(b) == x) {
                            f.setNumberInField(a+1, yPos, x);
                            removeNumberInRow(x, a+1);
                            
                            matrix[a][yPos - 1].clear();
                        }
                    }
                }
            } else {
                
                if(x < 9) {
                    //System.out.println(x+" is not unique vertical ["+count+"]");
                } else {
                    //System.out.println(x+" is not unique vertical ["+count+"]\n");
                }
                
                count = 0;
            }
        }
    }
    
    public void quadrantUniqueNumbers(int quadrantNumber, Field f) {
        int xPos = 0;
        int yPos = 0;
        
        int count = 0;
        
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
        
        for(int x = 1; x < 10; x++) {
            for(int i = xPos; i < xPos + 3; i++) {
                for(int j = yPos; j < yPos + 3; j++) {
                    for(int k = 0; k < matrix[i][j].size(); k++) {
                        if(matrix[i][j].get(k).equals(x)) {
                            count++;
                            
                            //System.out.println(x+": "+count);
                        }
                    }
                }
            }
            
            if(count == 1) {
                //System.out.println(x+" is unique quadrant ["+count+"]");
                
                for(int i = xPos; i < xPos + 3; i++) {
                    for(int j = yPos; j < yPos + 3; j++) {
                        for(int k = 0; k < matrix[i][j].size(); k++) {
                            //System.out.println(k+" -> k");
                            if(matrix[i][j].get(k) == x) {
                                //System.out.println(x+"["+i+"]"+"["+j+"]");
                                
                                f.setNumberInField(i+1, j+1, x);
                                
                                removeNumberInRow(x, i+1);
                                removeNumberInCol(x, j+1);
                                
                                matrix[i][j].clear();
                            } 
                        }
                    }
                }
                
                count = 0;
            } else {
                
                if(x < 9) {
                    //System.out.println(x+" is not unique quadrant ["+count+"]");
                } else {
                    //System.out.println(x+" is not unique quadrant ["+count+"]\n");
                }
                
                count = 0;
            }
        }
        
    }
    
    public void uniqueFieldScanner(Field f) {
        for(int i = 0; i < 9; i++) {
            horizontalUniqueNumber(i + 1, f);
            verticalUniqueNumber(i + 1, f);
            quadrantUniqueNumbers(i + 1, f);
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
