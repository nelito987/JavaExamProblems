import java.util.Scanner;

public class _09_CountBeers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum  = 0;

        while (!scanner.hasNext("End")){
            String [] input = scanner.nextLine().split(" ");
            int beers = Integer.parseInt(input[0]);
            String measure = input[1];

            switch (measure){
                case "stacks":
                    beers *= 20;
                    sum+= beers;
                    break;
                case "beers":
                    sum += beers;
                    break;
            }
        }

        System.out.printf("%d stacks + %d beers", sum/20, sum%20);
    }
}
