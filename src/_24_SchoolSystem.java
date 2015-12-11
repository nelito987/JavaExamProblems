import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class _24_SchoolSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        TreeMap<String, TreeMap<String, ArrayList<Integer>>> allGrades = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            String fullname = input[0] + " " + input[1];
            String subject = input[2];
            Integer grade = Integer.parseInt(input[3]);

            if (!allGrades.containsKey(fullname)) {
                allGrades.put(fullname, new TreeMap<>());
            }
            TreeMap<String, ArrayList<Integer>> subjectGrade = allGrades.get(fullname);
            if (!subjectGrade.containsKey(subject)) {
                subjectGrade.put(subject, new ArrayList<>());
            }
            subjectGrade.get(subject).add(grade);

        }

        for (String student : allGrades.keySet()) {
            System.out.printf("%s: ", student);

            ArrayList<String> allAverageGrades = new ArrayList<>();
            for (Map.Entry<String, ArrayList<Integer>> subject : allGrades.get(student).entrySet()) {
                allAverageGrades.add(String.format( "%s - %.2f",
                        subject.getKey(),
                        subject.getValue().stream()
                                .mapToDouble(value -> value)
                                .average()
                                .getAsDouble()));
            }

            System.out.printf("[%s]\n", String.join(", ", allAverageGrades));
        }
    }

}

