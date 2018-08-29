import java.util.Scanner;
public class area_of_Circle
{
	public static void main(String[] args)
	{
	  Scanner s=new Scanner(System.in);
	  int r=s.nextInt();
	  double area=areaOfCircle(r);
	  System.out.println(area);
	}
	public static double areaOfCircle(int num)
	{
		double pie=pi();
		double a=pie* (num * num);
		return a;
	}
	public static double pi()
	{
		return 3.14;
	}
}