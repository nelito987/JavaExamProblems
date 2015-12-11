import java.util.Scanner;

public class _06_PythagoreanNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int [] numbers = new int [n];
        for (int i = 0; i < n; i++) {
            numbers[i] = (Integer.parseInt(scanner.nextLine()));
        }

        int count = 0;

        for (int a = 0; a < numbers.length; a++) {
            for (int b = 0; b < numbers.length; b++) {
                for (int c = 0; c < numbers.length; c++) {
                    if (numbers[a]*numbers[a]+numbers[b]* numbers[b] == numbers[c]*numbers[c]
                            && numbers[a]<=numbers[b]){
                        System.out.printf("%d*%d + %d*%d = %d*%d\n", numbers[a], numbers[a], numbers[b], numbers[b], numbers[c], numbers[c]);
                        count++;
                    }
                }
            }
        }

        if ( count == 0){
            System.out.println("No");
        }
    }
}
