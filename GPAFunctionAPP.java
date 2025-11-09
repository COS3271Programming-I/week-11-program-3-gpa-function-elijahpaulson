package GPAFunctionAPP;
import java.util.Scanner;
import java.util.Arrays;
import java.util.InputMismatchException;
public class GPAFunctionAPP {
	static Scanner userinput = new Scanner(System.in);
	// calculate the GPA by getting the total value of grade*credit load
	// and dividing by the total credit load
	static double computeGPA(double [] grades, double [] credits) {
		double GPAtot=0;
		double sum=0;
		for (int i=0;i<grades.length;i++) {
			GPAtot=GPAtot+grades[i]*credits[i];
			sum=sum+credits[i];
		}
		double GPA=GPAtot/sum;
		return GPA;
	}
	// return the numerical value of the letter grade
	static double gradecalc(String grade) {
		if (grade.equals("A")) {return 4.00;}
		if (grade.equals("A-")) {return 3.67;}
		if (grade.equals("B+")) {return 3.33;}
		if (grade.equals("B")) {return 3.00;}
		if (grade.equals("B-")) {return 2.67;}
		if (grade.equals("C+")) {return 2.33;}
		if (grade.equals("C")) {return 2.00;}
		if (grade.equals("C-")) {return 1.67;}
		if (grade.equals("D+")) {return 1.33;}
		if (grade.equals("D")) {return 1.00;}
		if (grade.equals("D-")) {return 0.67;}
		else {return 0.00;}
	}
	// get the user responses including their grades, credits, and number of classes
	public static void main(String[] args) {
		System.out.print("How many classes are you taking?");
		int classes=userinput.nextInt();
		double [] grades = new double[classes];
		double [] credits = new double[classes];
		int i=0;
		String input="";
		String num="0123456789";
		// make sure that the inputs are valid
		// repeat loop for every class
		while (true&&(i<classes)) {
			try {
				userinput.nextLine();
				System.out.print("Enter class "+(i+1)+"'s letter grade.");
				input=userinput.nextLine();
				if (!(num.indexOf(input)==-1)) {
					System.out.print("Enter the correct input type (Press Enter)");
					continue;
				}
				grades[i]=gradecalc(input);
				System.out.print("Enter the amount of credits for that class.");
				credits[i]=userinput.nextInt();	
			}
			catch (InputMismatchException e) {
				System.out.print("Enter the correct input type:");
			}
			i++;
		}
		// display the results
		double GPA=Math.round(computeGPA(grades,credits)*100.0)/100.0;
		System.out.print("Your GPA is: "+GPA);
	}
}
