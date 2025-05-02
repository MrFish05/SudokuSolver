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
        
        //Field spf = new Field(); 
        
        /*
        spf.setNumberInField(4, 1, 4); 
        spf.setNumberInField(8, 1, 8); 
        spf.setNumberInField(7, 1, 9); 
        spf.setNumberInField(8, 2, 2); 
        spf.setNumberInField(7, 2, 4); 
        spf.setNumberInField(4, 2, 7); 
        spf.setNumberInField(9, 2, 8); 
        spf.setNumberInField(3, 3, 1); 
        spf.setNumberInField(9, 3, 4); 
        spf.setNumberInField(2, 3, 5); 
        spf.setNumberInField(1, 3, 8); 
        spf.setNumberInField(1, 4, 3); 
        spf.setNumberInField(6, 4, 4); 
        spf.setNumberInField(7, 4, 5); 
        spf.setNumberInField(4, 4, 8); 
        spf.setNumberInField(6, 5, 1); 
        spf.setNumberInField(4, 5, 2); 
        spf.setNumberInField(8, 5, 4); 
        spf.setNumberInField(3, 5, 5); 
        spf.setNumberInField(2, 5, 7); 
        spf.setNumberInField(7, 5, 8); 
        spf.setNumberInField(5, 5, 9); 
        spf.setNumberInField(2, 6, 2); 
        spf.setNumberInField(7, 6, 3); 
        spf.setNumberInField(5, 6, 4); 
        spf.setNumberInField(4, 6, 5); 
        spf.setNumberInField(9, 6, 6); 
        spf.setNumberInField(3, 6, 8); 
        spf.setNumberInField(6, 7, 3); 
        spf.setNumberInField(5, 7, 5); 
        spf.setNumberInField(2, 7, 8); 
        spf.setNumberInField(2, 8, 1); 
        spf.setNumberInField(1, 8, 2); 
        spf.setNumberInField(8, 8, 3); 
        spf.setNumberInField(7, 8, 7); 
        spf.setNumberInField(5, 9, 2); 
        spf.setNumberInField(3, 9, 3); 
        spf.setNumberInField(4, 9, 6);
        */
        
        f.setNumberInField(5, 1, 1);
        f.setNumberInField(3, 1, 2);
        f.setNumberInField(2, 1, 4);
        f.setNumberInField(9, 1, 7);
        f.setNumberInField(3, 2, 5);
        f.setNumberInField(2, 2, 7);
        f.setNumberInField(5, 2, 9);
        f.setNumberInField(2, 3, 2);
        f.setNumberInField(9, 3, 4);
        f.setNumberInField(6, 3, 7);
        f.setNumberInField(3, 3, 8);
        f.setNumberInField(1, 5, 2);
        f.setNumberInField(6, 5, 4);
        f.setNumberInField(3, 5, 6);
        f.setNumberInField(7, 5, 7);
        f.setNumberInField(4, 6, 1);
        f.setNumberInField(5, 6, 5);
        f.setNumberInField(9, 7, 1);
        f.setNumberInField(3, 7, 7);
        f.setNumberInField(7, 7, 9);
        f.setNumberInField(8, 8, 2);
        f.setNumberInField(6, 8, 5);
        f.setNumberInField(9, 8, 8);
        f.setNumberInField(4, 9, 3);
        f.setNumberInField(8, 9, 4);
        
        /*
        System.out.println(spf.toString());
        while(!spf.gameFinished()) {
            m.fieldScanner(spf);
            m.findLonelyNumber(spf);
            System.out.println(spf.toString());
        }
        */
        
        System.out.println(f.toString());
        
        m.fieldScanner(f);
        m.findLonelyNumber(f);
        
        System.out.println(m.toString());
        System.out.println(f.toString());
        
        m.verticalUniqueNumber(2, f);
        
        System.out.println(m.toString());
        System.out.println(f.toString());
    }
}
