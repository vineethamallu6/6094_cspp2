import java.util.Scanner;
public class StudentDetails {
	public String name;
	public int roll;
	public float m1;
	public float m2;
	public float m3;
	public StudentDetails(String name, int roll, float m1, float m2, float m3) {
		this.name=name;
		this.roll=roll;
		this.m1=m1;
		this.m2=m2;
		this.m3=m3;
	}
	double GPA() {
		double avg=(m1+m2+m3)/3D;
		return avg;
	}

public static void main(String[] args) {
	 	Scanner sc= new Scanner(System.in);
	 	String name = sc.next();
	 	int roll = sc.nextInt();
	 	float m1 = sc.nextFloat();
	 	float m2 = sc.nextFloat();
	 	float m3 = sc.nextFloat();
	 	StudentDetails s1 = new StudentDetails(name, roll, m1, m2, m3);
	 	System.out.format("%.1f",s1.GPA());
	 }
	}
	