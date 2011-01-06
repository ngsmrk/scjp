/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scjp;

/**
 *
 * @author Angus
 */
public class ArrayTest {

    public static void main(String[] args) {

        int Array1[] = {3, 6, 2, 9, 5, 8};
        int Array2[] = Array1;
        int Array3[] = Array2;

        Array1[2] = 2;
        Array2[3] = 5;
        Array3[4] = 7;
        Array2[4] = Array3[4];

        for (int val : Array1){
            System.out.println("Array 1 " + val);
        }

        for (int val : Array2){
            System.out.println("Array 2 " + val);
        }

        for (int val : Array3){
            System.out.println("Array 3 " + val);
        }
    }
}
