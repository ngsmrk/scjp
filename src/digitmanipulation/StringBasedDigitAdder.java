package digitmanipulation;

/**
 * .
 *
 * @author Initial: amark
 * @version 1.0
 */
public class StringBasedDigitAdder implements DigitAdder {
    
    public int add(int input) {

        int output = 0;
        String value = Integer.toString(input);
        for (int i = 0; i < value.length() ; i++) {
            char x = value.charAt(i);
            output += Integer.parseInt(String.valueOf(x));
        }

        return output;

    }
}
