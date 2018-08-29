import java.util.*;
public class degreeFahrenheit
{
	public static void main(String[] args)
	{
	  Scanner de=new Scanner(System.in);
	  float c=de.nextInt();
	  float fahren= c* 9/5 + 32;

	  System.out.println("faren="+fahren);
	}
}