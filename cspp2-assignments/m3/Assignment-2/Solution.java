
import java.util.Scanner;
/*
	Do not modify this main function.
	*/
public class Solution {
/* Fill the main function to print the number of 7's between 1 to n*/
    public static void main(String[] args) {

        Scanner s=new Scanner(System.in);      
        int n = s.nextInt();
        int count=0;
        int temp=1;

        for(int i=0;i<=n;i++)
        {
        	temp=i;
            while(temp>0){
            int digit=temp%10;
            temp= temp/10;
            if(digit==7){
            	count++;
            }


        }
       
        
    }
    System.out.println(count);


}
}