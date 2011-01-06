package digitmanipulation;

/**
 * .
 *
 * @author Initial: amark
 * @version 1.0
 */
public class RecursiveModulusBasedDigitAdder extends ModulusBasedDigitAdder {

    public int add(int input) {

        return add(input, 0);
    }

    private int add(int input, int sum) {

        if (input > 0) {

            int mod = calculateModulus(input);
            sum += mod;

            int diff = calculateNewValue(input, mod);
            return add(diff, sum);
        }

        return sum;
    }


}
