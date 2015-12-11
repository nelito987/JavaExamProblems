import java.util.Scanner;

public class _02_addingAngles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int [] numbers = new int [n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

        for (int a = 0; a < numbers.length; a++) {
            for (int b = a + 1; b < numbers.length; b++) {
                for (int c = b + 1; c < numbers.length ; c++) {
                    if ((numbers[a]+numbers[b]+numbers[c])%360 == 0){
                        int sum = numbers[a]+numbers[b]+numbers[c];
                        System.out.printf("%d + %d + %d = %d degrees\n",numbers[a], numbers[b], numbers[c],sum);
                        count++;
                    }
                }
            }
        }

        if (count == 0){
            System.out.print("No");
        }
    }
}
