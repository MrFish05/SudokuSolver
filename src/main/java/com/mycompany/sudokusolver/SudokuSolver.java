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
        Matrix m = new Matrix();
        
        f.setNumberInField(1, 4, 4);
        f.setNumberInField(1, 8, 8);
        f.setNumberInField(1, 9, 7);
        f.setNumberInField(2, 2, 8);
        f.setNumberInField(2, 4, 7);
        f.setNumberInField(2, 7, 4);
        f.setNumberInField(2, 8, 9);
        f.setNumberInField(3, 1, 3);
        f.setNumberInField(3, 4, 9);
        f.setNumberInField(3, 5, 2);
        f.setNumberInField(3, 8, 1);
        f.setNumberInField(4, 3, 1);
        f.setNumberInField(4, 4, 6);
        f.setNumberInField(4, 5, 7);
        f.setNumberInField(4, 8, 4);
        f.setNumberInField(5, 1, 6);
        f.setNumberInField(5, 2, 4);
        f.setNumberInField(5, 4, 8);
        f.setNumberInField(5, 5, 3);
        f.setNumberInField(5, 7, 2);
        f.setNumberInField(5, 8, 7);
        f.setNumberInField(5, 9, 5);
        f.setNumberInField(6, 2, 2);
        f.setNumberInField(6, 3, 7);
        f.setNumberInField(6, 4, 5);
        f.setNumberInField(6, 5, 4);
        f.setNumberInField(6, 6, 9);
        f.setNumberInField(6, 8, 3);
        f.setNumberInField(7, 3, 6);
        f.setNumberInField(7, 5, 5);
        f.setNumberInField(7, 8, 2);
        f.setNumberInField(8, 1, 2);
        f.setNumberInField(8, 2, 1);
        f.setNumberInField(8, 3, 8);
        f.setNumberInField(8, 7, 7);
        f.setNumberInField(9, 2, 5);
        f.setNumberInField(9, 3, 3);
        f.setNumberInField(9, 6, 4);
        
        m.fieldScanner(f);
        System.out.println(m.toString());
        
        System.out.println(f.toString());

        m.uniqueFieldScanner(f);
        //m.uniqueFieldScanner(f);
        
        //m.findLonelyNumber(f);
        
        System.out.println(f.toString());
        System.out.println(m.toString());
    }
}
