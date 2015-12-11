import java.util.LinkedHashMap;
import java.util.Scanner;

public class _08_CouplesFrequency {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] input = scanner.nextLine().split(" ");

        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < input.length -1 ; i++) {
            String sequence = input[i] + " " + input[i + 1];
                Integer count = map.get(sequence);
                if (count == null) {
                    count = 1;
                }else {
                count++;
                }
            map.put(sequence, count);
        }

        for (String s : map.keySet()) {
            double percentage = (double)map.get(s)*100/(input.length-1);
            System.out.printf("%s -> %.2f%%\n", s, percentage);
        }
    }
}
