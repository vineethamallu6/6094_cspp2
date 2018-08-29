
import java.util.Scanner;
/*
	Do not modify this main function.
	*/
public class Solution {

    public static void main(String[] args) {

        Scanner s=new Scanner(System.in);      
        int n1 = s.nextInt();
        int n2 = s.nextInt();
        gcd(n1,n2);
        System.out.println(gcd(n1,n2));
    }
    /*
	Need to write the gcd function and print the output.
	*/
    public static int gcd(int a, int b)
    {
        if(a==0 ||b==0){
            return 0;
        }
        if(a==b){
            return a;
        }
        if(a>b){
            return gcd(a-b, b);
        }
    
        return gcd(a, b-a);
        
    }
        /*if (b==0) return a;
        return gcd(b,a%b);*/

        }
    

