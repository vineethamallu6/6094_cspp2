import java.util.Scanner;
public final class  Solution{
	public static void main(final String[] args) {
		int m,n,i,j;
		Scanner s=new Scanner(System.in);
		m=s.nextInt();
		n=s.nextInt();
		int arr1[][]=new int[m][n];
		int arr2[][]= new int[m][n];
		int sum[][]=new int[m][n];
		for (i=0;i<m;i++)
		{
			for (j=0;j<n;j++)
			{
				arr1[i][j]=s.nextInt();
			}
		}
		for (i=0;i<m;i++)
		{
			for (j=0;j<n;j++)
			{
				arr2[i][j]=s.nextInt();
			}
		}
		for (i=0;i<m;i++)
		{
			for (j=0;j<n;j++)
			{
				sum[i][j]=arr1[i][j]+arr2[i][j];
			}
		}
		 for (i=0;i<m;i++)
		{
			for (j=0;j<n;j++)
			{
				System.out.print(sum[i][j]+"\t");
			}
			System.out.println();
		}
	}
}
