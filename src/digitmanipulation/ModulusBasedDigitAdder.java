package digitmanipulation;

/**
 * .
 *
 * @author Initial: amark
 * @version 1.0
 */
public abstract class ModulusBasedDigitAdder implements DigitAdder {
    
    protected int calculateModulus(int input) {

        int mod = input % 10;

        return mod;
    }

    protected int calculateNewValue(int input, int mod) {

        int diff = (input - mod) / 10;

        return diff;
    }
}
