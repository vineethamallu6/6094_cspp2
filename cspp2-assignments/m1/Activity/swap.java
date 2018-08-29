/** 

import java.util.Scanner;
public class swap
{
	public static void main(String[] args)
	{
	  Scanner a = new Scanner(System.in);
	  Scanner b = new Scanner(System.in);
	  int p  = a.nextInt();
	  int q = b.nextInt();
	  int temp;
	  temp = p;
	  p = q;
	  q = temp;
	  System.out.println("swap of p=" + p);
	  System.out.println("swap of q=" + q);

	}
}
