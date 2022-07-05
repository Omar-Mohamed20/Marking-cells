/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marking.cells;

import java.util.Scanner;
public class MarkingCells {

 public static void checked(
        int matrix[][], int n)
    { 
        boolean done[][] = new boolean[n][n];
        boolean flag = false;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1   && !done[i][j])
                    if (checked(  matrix, i, j, done))
                     { flag = true;
                        break;}
            }
        }
        if (flag)
            System.out.println("YES");
        else
            System.out.println("NO");
    }
 
    public static boolean path(
        int i, int j,
        int matrix[][])
    {
        if ( i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length)
        return true;
        return false;
    }
    
 
    public static boolean checked(
        int matrix[][],
        int i, int j,
        boolean done[][])
    {
 
        if (
            path(i, j, matrix)
            && matrix[i][j] != 0
            && !done[i][j]) {
            done[i][j] = true;
 
            if (matrix[i][j] == 2)
                return true;
 
            boolean up = checked( matrix, i - 1,     j, done);
            if (up)
             return true;

            boolean down = checked( matrix, i + 1, j, done);
            if (down)
                return true;
 
 
            boolean right= checked(matrix, i, j + 1,  done);
            if (right)
                return true;
 
            boolean left = checked(  matrix, i, j - 1, done);
            if (left)
                return true;
        }
        return false;
    }
    
    
    public static void main(String[] args) {
        
       
          int matrix[][] = { { 0, 3, 0, 1 },
                           { 3, 0, 3, 3 },
                           { 2, 3, 3, 3 },
                           { 0, 3, 3, 3 } };
 
       
        checked(matrix, 4);
        
    }
    
}
