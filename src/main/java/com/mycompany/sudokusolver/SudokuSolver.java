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
        f.setNumberInField(1, 5, 5);
        //System.out.println(f.toString());
        
        Matrix m = new Matrix();
        System.out.println(m.toString());
        m.removeNumberFromMatrix(1, 1, 1);
        m.removeNumberFromMatrix(9, 1, 1);
        //m.removeAllNumbersInMatrix(2, 2);
        //m.removeNumberInRow(9, 3, 4);
        //m.removeNumberInCol(2, 1, 1);
        System.out.println(m.toString());
    }
}
