/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package scjp;

/**
 *
 * @author Angus
 */
public class InvalidVarArgs {

    // will not compile because vararg wist always be last param
    /*
    public static void invalidMethodWith2Params(String... args, String prefix) {
        for (String arg : args) {
            System.out.println(arg);
        }
    }
    */

    // will not compile because only 1 vararg is allowed per method
    /*
    public static void invalidMethodWith2Varargs(String... args, String ... args2) {
        for (String arg : args) {
            System.out.println(arg);
        }
    }
    */
}
