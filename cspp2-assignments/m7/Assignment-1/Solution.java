import java.util.Scanner;
class InputValidator {
 int length;
 String data;
public InputValidator(String input) {
 	data = input;
 	length = input.length();
 }
 boolean validateData() {
 	final int var = 6;
 	if (length >= var) {
 		return true;
 	}
 	return false;
 	}
 }
public class Solution {
	public static void main(String args[]) {
    	Scanner s = new Scanner(System.in);
    	String input = s.next();
    	InputValidator i = new InputValidator(input);
    	System.out.println(i.validateData());
    }
}
