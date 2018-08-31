
// Given an String, Write a java method that returns the decimal value for the given binary string.
import java.util.Scanner;
public class Solution
{/*
	Do not modify this main function.
	*/
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i = 0; i < n; i++) {
			String s = sc.next();
			String res = binaryToDecimal(s);//Write binaryToDecimal function
			System.out.println(res);
		}
	}
	public static String binaryToDecimal(String str) {
		 int decimal = 0,i = 0;
		 long n = Long.parseLong(str);
		 while(n != 0) {
		 	decimal += ((n % 10) * Math.pow(2, i));
		 	n = n / 10;
		 	i ++;
		 }
		 String s1 = decimal + "";
		 return s1;

	}

}
