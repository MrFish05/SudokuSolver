/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sudokusolver;

/**
 *
 * @author mrfish
 */
public class SudokuSolver {

    public static void main(String[] args) {
        Field f = new Field();
        System.out.println(f.toString());
        
        Matrix m = new Matrix();
        m.removeNumberFromMatrix(1, 1, 1);
        m.removeNumberFromMatrix(2, 1, 1);
        m.removeNumberFromMatrix(3, 1, 1);
        m.removeNumberFromMatrix(4, 1, 1);
        m.removeNumberFromMatrix(5, 1, 1);
        m.removeNumberFromMatrix(6, 1, 1);
        m.removeNumberFromMatrix(7, 1, 1);
        m.removeNumberFromMatrix(8, 1, 1);
        
        m.findLonelyNumber(f);
        
        System.out.println(m.toString());
    }
}
