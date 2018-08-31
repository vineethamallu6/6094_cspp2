
import java.util.Scanner;
public final class FirstLast6 {
	public static void main(final String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int count=0;
		int firstLast[]=new int[n];
		int len=firstLast.length;
		for (int i=0;i<n;i++)
		{
			firstLast[i]=s.nextInt();
		}
		for (int i=0;i<n;i++)
		{
			if(firstLast[0]==6)
			{
				count+=1;
			}
			if(firstLast[len-1]==6)
			{
				count+=1;
			}
		}
		if (count>0)
		{
			System.out.println("true");
		}
		else
		{
			System.out.println("false");
		}

		}
	}

