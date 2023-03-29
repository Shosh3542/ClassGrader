package schwartz.TASK;

import schwartz.HELPER.helper;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.FileReader;

public class task {
	
	public static void findFinalGrade(String output) throws IOException {
		String fp = output;
		BufferedWriter BW = new BufferedWriter(new FileWriter(fp));
		
		String className = helper.nameClass();
		int numFactors = helper.numFactors();
		String[] factors = helper.arrayFactors(numFactors);
		int[] percentage = helper.percentGrade(factors);
		int[] numOfFactor = helper.numOfFactor(factors);
		int[] numLeft = helper.numRemaining(factors, numOfFactor);
		int[] numTaken = helper.numTaken(numOfFactor, numLeft);
		String[] letterGrades = {"A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D+", "D", "F" };
		int[] numGrades = helper.numGrades(letterGrades);
		double currentGrade = helper.currentGrade(factors, numOfFactor, percentage, numTaken, numGrades);
		String letterGrade = helper.convertToLetter(currentGrade, numGrades, letterGrades);
		System.out.println("Your current grade is a " + currentGrade + "-" + letterGrade);
		BW.write(className + "\n");
		for(String i:factors) {
			BW.write(i + "#");
		}
		BW.write("\n");
		for(int b: percentage) {
			BW.write(b + "#");
		}
		BW.write("\n");
		for(int c: numOfFactor) {
			BW.write(c + "#");
		}
		BW.write("\n");
		for(int d: numLeft) {
			BW.write(d + "#");
		}
		BW.write("\n");
		for(String e: letterGrades) {
			BW.write(e + "#");
		}
		BW.write("\n");
		for(int f: numGrades) {
			BW.write(f + "#");
		}
		BW.write("\n");
		BW.write(Double.toString(currentGrade));
		BW.close();
		
		
	}
	public static void hypothesizedGrade(String input) throws IOException{
		String fp = input;
		BufferedReader BR = new BufferedReader(new FileReader(fp));
		String className = BR.readLine();
		String line2 = BR.readLine();
		String[] factors = line2.split("#");
		String line3 = BR.readLine();
		int[] percentage = Arrays.stream(line3.split("#")).mapToInt(Integer::parseInt).toArray();
		String line4 = BR.readLine();
		int[] numOfFactor = Arrays.stream(line4.split("#")).mapToInt(Integer::parseInt).toArray();
		String line5 = BR.readLine();
		int[] numLeft = Arrays.stream(line5.split("#")).mapToInt(Integer::parseInt).toArray();
		String line6 = BR.readLine();
		String[] letterGrades = line6.split("#");
		String line7 = BR.readLine();
		int[] numGrades = Arrays.stream(line7.split("#")).mapToInt(Integer::parseInt).toArray();
		double currentGrade = Double.parseDouble(BR.readLine());
		double[] percentEach = helper.percentEach(percentage, numOfFactor);
		double finalGradeAdd = helper.hGrade(factors, percentEach, numLeft, numOfFactor);
		double finalGrade = finalGradeAdd + currentGrade;
		String letterGrade = helper.convertToLetter(finalGrade, numGrades, letterGrades);
		System.out.println("Your hypothesized grade is a " + finalGrade + "-" + letterGrade);
		BR.close();
		
		
		
		
		
	}
	

}
