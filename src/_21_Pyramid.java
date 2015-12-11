import java.util.Arrays;
import java.util.Scanner;

public class _21_Pyramid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        int currentNum = Integer.parseInt(scanner.nextLine().trim());
        String output = "" + currentNum;

        for (int i = 1; i < n ; i++) {
            String [] line = scanner.nextLine().trim().split("[ ]+");
            int [] numbers = new int[line.length];
            for (int j = 0; j < line.length ; j++) {
                numbers[j] = Integer.parseInt(line[j]);
            }

            Arrays.sort(numbers);
            boolean isBreak = false;
            for (int j = 0; j <numbers.length ; j++) {
                if(numbers[j]> currentNum ){
                    currentNum = numbers[j];
                    output += ", " + currentNum;
                    isBreak = true;
                    break;
                }
            }

            if(!isBreak){
                currentNum++;
            }
        }
        System.out.print(output);

    }
}
