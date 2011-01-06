package digitmanipulation;

/**
 * .
 *
 * @author Initial: amark
 * @version 1.0
 */
public class NonRecursiveModulusBasedDigitAdder extends ModulusBasedDigitAdder {

    public int add(int input) {

        // fn(126) = 6
        // fn(12) = 2
        // fn(1) = 1
        int sum = 0;

        while (input > 0) {

            int mod = calculateModulus(input);

            sum += mod;

            // assign new value so that loop condition can be checked
            input = calculateNewValue(input, mod);

            System.out.println(input + " | " + mod + " | " + sum);
        }

        return sum;
    }

}
