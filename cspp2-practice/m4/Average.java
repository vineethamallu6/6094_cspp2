import java.util.Scanner;
public final class Average {
	public static void main(final String[] args) {
		
			Scanner s=new Scanner(System.in);
			int n=s.nextInt();
			double sum=0;
			double arr[]=new double[n];
			for (int i=0;i<n;i++)
			{
				arr[i]=s.nextDouble();
			}
			for (int i=0;i<n;i++){
				sum=sum+arr[i];
			}
			
			double avg=(sum/n);
			System.out.format("%.2f",avg);

		}
	}