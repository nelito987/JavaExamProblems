import java.util.Scanner;

public class _01_DozenEggs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        for (int i = 0; i < 7; i++) {
            String [] input = scanner.nextLine().split(" ");
            int eggs = Integer.parseInt(input[0]);
            String measure = input[1];

            switch (measure){
                case "eggs": sum += eggs;break;
                case "dozens": sum += eggs*12;break;
            }
        }
        int eggsSum = (int)sum%12;
        int dozens = sum/12;

        System.out.printf("%d dozens + %d eggs", dozens, eggsSum);
    }
}
