/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package scjp.inheritance;

/**
 *
 * @author Angus
 */
public class ClassB extends ClassA {

    // cannot do this - the parent method is not static
    //public static void methodOne(int i) {
    //}

    @Override
    public void methodTwo(int i) {
    }

    // cannot do this - the parent method is static
    //public void methodThree(int i) {
    //}

    // hides method in superclass
    public static void methodFour(int i) {
    }

}
