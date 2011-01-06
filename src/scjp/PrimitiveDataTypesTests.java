/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scjp;

/**
 *
 * @author Angus
 */
public class PrimitiveDataTypesTests {

    public static void main(String[] args) {
        testWholeNumbers();
    }

    private static void testWholeNumbers() {
        byte b = 1;
        short s = b;
        int i = s;
        long l = i;
        printValues(b, s, i, l);

        // all of these require casting (with possible loss of precision)
        char c = '\u0000';
        b = (byte) c;

        b = (byte) l;
        b = (byte) s;
        b = (byte) i;

        s = (short) i;
        s = (short) l;

        i = (int) l;

        printValues(b, s, i, l);
    }

    private static void printValues(byte b, short s, int i, long l) {
        System.out.println(b);
        System.out.println(s);
        System.out.println(i);
        System.out.println(l);
    }
}
