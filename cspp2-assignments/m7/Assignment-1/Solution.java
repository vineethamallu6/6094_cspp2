import java.util.Scanner;
/**
* Class for InputValidator.
*/
class InputValidator {
/**
* length is attribute.
*/
private int length;
/**
* data is attribute.
*/
 private String data;
 /**
 * constructor for InputValidator.
 *
 *@param      input is input.
 */
public InputValidator(final String input) {
    data = input;
    length = input.length();
 }
 /**
 * function to return true or false based on given input.
 *
 *@return     return true or false.
 */
 boolean validateData() {
    final int var = 6;
    if (length >= var) {
        return true;
    }
    return false;
    }
 }
 /**
 * class Solution that contains main method.
 */
final class Solution {
    /**constructor for solution.
    */
    private Solution() {
}
/**
* main function.
*
*@param    args  the arguments
*/
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.next();
        InputValidator i = new InputValidator(input);
        System.out.println(i.validateData());
    }
}
