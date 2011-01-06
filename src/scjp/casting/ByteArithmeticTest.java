/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scjp.casting;

/**
 *
 * @author Angus
 */
public class ByteArithmeticTest {

    public static void main(String[] args) {

        byte a = 10;
        byte b = 2;
        // without a cast this will not compile
        // byte c = (a + b);
        byte c = (byte) (a + b);
        System.out.println(c);

        short s1 = 10;
        short s2 = 5;
        final int s3 = s1 + s2;
        System.out.println(s3);

        float f1 = 10.5F;
        float f2 = 3.3F;
        float f3 = f1 + f2;
        System.out.println(f3);
        
        // the higher type always gets picked
        float d = f1 + a;
        System.out.println(d);

        
    }
}

