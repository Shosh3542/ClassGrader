package schwartz.HELPER;
import java.util.Scanner;

public class helper {
	public static String nameClass() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("What is the name of your class? ");
		String className = scanner.nextLine();
		return className;
		
	}
	public static String[] arrayFactors(int X) {
		String[] factors = new String[X];
		int count = 0;
		for(String i: factors) {
			Scanner scanner = new Scanner(System.in);
			System.out.print("What is factor#" + (count + 1) + "? ");
			factors[count] = scanner.nextLine();
			count++;
		}
		return factors;
		
		
	}
	public static int numFactors(){
		Scanner scanner = new Scanner(System.in);
		System.out.print("How many factors go into your grade? ");
		int number = scanner.nextInt();
		return number;
		
	}
	public static int numX(String X){
		Scanner scanner = new Scanner(System.in);
		System.out.print("How many " + X + " do you have? ");
		int number = scanner.nextInt();
		return number;
		
	}
	public static int[] percentGrade(String[] factors) {
		int[] percentage = new int[factors.length];
		int count = 0;
		for(int i: percentage) {
			Scanner scanner = new Scanner(System.in);
			System.out.print("What percentage of your grade out of 100 is " + factors[count] + "? ");
			int percent = scanner.nextInt();
			percentage[count] = percent;
			count++;	
		}
		return percentage;
	}
	public static int[] numOfFactor(String[] factors) {
		int[] numOf = new int[factors.length];
		int count = 0;
		for(int i: numOf) {
			numOf[count] = helper.numX(factors[count]);
			count++;
		}
		return numOf;
	}
	public static int[] numRemaining(String[] factors, int[] numOfFactor) {
		int[] numLeft = new int[factors.length];
		int count = 0;
		for(int i: numLeft) {
			Scanner scanner = new Scanner(System.in);
			System.out.print("How many " + factors[count] + " have you taken so far? ");
			int totalTaken = scanner.nextInt();
			int remaining = numOfFactor[count] - totalTaken;
			numLeft[count] = remaining;
			count++;
		}
		return numLeft;
	}
	public static int[] numTaken(int[] numOfFactor, int[] numLeft) {
		int[] numTaken = new int[numOfFactor.length];
		int count = 0;
		for(int i: numTaken) {
			numTaken[count] = numOfFactor[count] - numLeft[count];
			count++;
		}
		return numTaken;
	}
	public static int gradeNeeded(String x) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("What number grade do you need for a " + x + " ? ");
		int gradeNeeded = scanner.nextInt();
		return gradeNeeded;
	}
	public static int[] numGrades(String[] letterGrades) {
		int count = 0;
		int[] numGrades = new int[letterGrades.length];
		for(int i: numGrades) {
			numGrades[count] = helper.gradeNeeded(letterGrades[count]);
			count++;	
		}
		return numGrades;
	}
	public static double gradeOn(String i, int t) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("What did you get on " + i + " #" + t + " ? ");
		double gradeOn = scanner.nextDouble();
		return gradeOn;
	}
	public static double currentGrade(String[] factors, int[] numOfFactors, int[] percentGrade, int[] numTaken, int[] numGrades) {
		int count = 0;
		double total = 0;
		for(String i: factors) {
			double percentPerNum = ((percentGrade[count] / numOfFactors[count]) * .01);
			int numT = numTaken[count];
			for(int t = 1; t <= numT; t++) {
				total += (helper.gradeOn(i, t) * percentPerNum);
				
			}
			count++;}
			
		
		return total;	

}
	
	public static String convertToLetter(double totalGrade, int[] numGrades, String[] letterGrades) {
		int count = 0;
		String letter = null;
		for(int i: numGrades) {
			if(totalGrade >= i) {
				return letterGrades[count];
				
			}
			count++;
			
		}
		return letter;
	}
	public static double[] percentEach(int[] percentage, int[] numOfFactor) {
		double[] percentEach = new double[percentage.length];
		int count = 0;
		for(double i: percentEach) {
			percentEach[count] = ((percentage[count] / numOfFactor[count])*.01);
			count++;
		}
		return percentEach;
	}
	public static double gradeOnE(String i, int t) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("What grade do you think you will get on " + i + " #" + t + " ? ");
		double gradeH = scanner.nextDouble();
		return gradeH;
	}
	public static double hGrade(String[] factors,double[] percentEach, int[] numLeft, int[] numOfFactors) {
		int count = 0;
		double total = 0;
		for(String i: factors) {
			double percentE = percentEach[count];
			int numL = numLeft[count];
			for(int t = (numOfFactors[count]- numL + 1); t <= numOfFactors[count]; t++) {
				total += (helper.gradeOnE(i, t) * percentE);
				
			}
			count++;}
			
		
		return total;	

}
	

	
}
