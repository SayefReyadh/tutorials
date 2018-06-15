/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the.mypoint.pkgclass;

/**
 *
 * @author SayefReyadh
 */
public class TheMyPointClass {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        
        MyPoint[] array = new MyPoint[10];
        int[][] array2D = new int[5][];
        
        
        
        
        
        array2D[0] = new int[1]; // 1
        array2D[1] = new int[5]; // 1 1 1 1 1
        array2D[2] = new int[4]; // 1 1 1 1 
        array2D[3] = new int[3]; // 1 1 1 
        array2D[4] = new int[2]; // 1 1  
        
        
        for(int i = 0 ; i < array2D.length ; i++)
        {
            for(int j = 0 ; j < array2D[i].length ; j++)
            {
                array2D[i][j] = (i+1)*(j+1);
                System.out.print(array2D[i][j] + "\t");
            }
            System.out.println("");
        }
        
        System.out.println("");
        
        for(int[] i : array2D)
        {
            for(int j : i)
            {
                j = 1;
                System.out.print(j + " ");
            }
            System.out.println("");
        }
        
    }
    
}
