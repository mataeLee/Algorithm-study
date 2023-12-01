import java.io.*;
import java.util.*;

public class Main{
	// 백준 너의 평점은 - 25206 실버5
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
        Map<String,Double> gradeMap = new HashMap<>();
        gradeMap.put("A+", 4.5);
        gradeMap.put("A0", 4.0);
        gradeMap.put("B+", 3.5);
        gradeMap.put("B0", 3.0);
        gradeMap.put("C+", 2.5);
        gradeMap.put("C0", 2.0);
        gradeMap.put("D+", 1.5);
        gradeMap.put("D0", 1.0);
        gradeMap.put("F", 0.0);
        
        
        double sum = 0;
        int gradeSum = 0;
        while(true) {
        	String line = br.readLine();
        	if(line == null || line.length() < 3) break;
        	
        	String[] data = line.split(" ");
        	if("P".equals(data[2])) continue;
        	
        	double grade = Double.parseDouble(data[1]);
        	double average = gradeMap.get(data[2]);
        	
        	sum += grade * average;
        	gradeSum += grade;
        }
        
        System.out.println(sum / gradeSum);
    }
}