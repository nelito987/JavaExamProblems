import sun.reflect.generics.tree.Tree;

import java.util.Scanner;
import java.util.TreeMap;

public class _15_ExamScore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<Integer,TreeMap<String, Double>> map = new TreeMap<>();
        for (int i = 0; i <3 ; i++) {
            scanner.nextLine();
        }
        String line;
        while(!(line = scanner.nextLine()).contains("-")){
            String[] input = line.substring(1)
                    .substring(0, line.length() - 1)
                    .split("\\s*\\|\\s*");

            String student = input[0].trim();
            Integer score = Integer.parseInt(input[1].trim());
            Double grade = Double.parseDouble(input[2].trim());

            if(!map.containsKey(score)){
                map.put(score, new TreeMap<>());
            }
            TreeMap<String, Double> stuentsGrade = map.get(score);
            stuentsGrade.put(student, grade);
        }

        for (Integer score : map.keySet()) {
            System.out.print(score + " -> ");
            System.out.print(map.get(score).keySet());
            double sum = 0;
            for (Double grade : map.get(score).values()) {
                sum+= grade;
            }

            double average = sum/map.get(score).values().size();
            System.out.printf("; avg=%.2f\n", average);
        }

    }
}
