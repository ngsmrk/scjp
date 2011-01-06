/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package scjp;

/**
 *
 * @author Angus
 */
public class VarArgsTests {

    // name and number of spaces don't matter
    public static void validMethodWith1Param(String     ... bob) {
        for (String arg : bob) {
            System.out.println(arg);
        }
    }

    public static void validMethodWith2Params(String prefix, String... args) {
        for (String arg : args) {
            System.out.println(prefix + "_" + arg);
        }
    }

    public static void main(String[] args) {
        validMethodWith1Param(new String[]{"1", "2"});
        validMethodWith2Params("test", new String[]{"1", "2"});
    }
}
