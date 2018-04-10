/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1.pkg8.using.jdk.s.biginteger.pkgclass;

/**
 *
 * @author SayefReyadh
 */
import java.math.BigInteger;

public class TestBigInteger {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BigInteger i1 = new BigInteger("11111111111111111111111111111111111111111111111111111111111111");
        BigInteger i2 = new BigInteger("22222222222222222222222222222222222222222222222222");
        System.out.println(i1.add(i2));
        System.out.println(i1.multiply(i2));
    }
    
}
