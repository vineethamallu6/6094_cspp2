import java.util.Scanner;
import java.lang.Math;

public class Solution
 {
	/*
	Do not modify this main function.
	*/
	public static void main(String[] args)
	 {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();
		rootsOfQuadraticEquation(a, b, c);
	}
	/*
	Need to write the rootsOfQuadraticEquation function and print the output.
	*/
	public static void rootsOfQuadraticEquation(int p,int q,int r)
	{
		double d = (q*q)-(4*p*r);
		double qua = Math.sqrt(d);
		double r1 = ((-q + qua)/ (2*p));
		double r2 = ((-q - qua)/ (2*p));
		System.out.println(r1+" "+r2);
	}

}
	

