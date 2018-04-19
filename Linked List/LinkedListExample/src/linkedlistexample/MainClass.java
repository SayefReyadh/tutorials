/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlistexample;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author SayefReyadh
 */
public class MainClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 10;//sc.nextInt();
        
        Random rand = new Random();
        LinkedList linkedList = new LinkedList();
        for(int i = 0 ; i < n ; i++)
        {
            int num = rand.nextInt()%1000;
            System.out.print(num + " ");
            linkedList.insertLast(num);
        }
        System.out.println("");
        linkedList.printList();
        linkedList.deleteFront();
        linkedList.deleteLast();
        linkedList.printList();
        linkedList.deleteAt(4);
        
        linkedList.printList();
    }
    
}
