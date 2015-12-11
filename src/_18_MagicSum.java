import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _18_MagicSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int divider = Integer.parseInt(scanner.nextLine());
        List<Integer> numbers = new ArrayList<>();
        List<Integer> maxSumNumbers = new ArrayList<>();
        int count = 0;
        long maxSum = Integer.MIN_VALUE;
        long sum = 0;

        while (!scanner.hasNext("End")){
            numbers.add(Integer.parseInt(scanner.nextLine()));
        }

        for (int a = 0; a < numbers.size() ; a++) {
            for (int b = a+1; b < numbers.size() ; b++) {
                for (int c = b+1; c < numbers.size(); c++) {
                    if((numbers.get(a)+numbers.get(b)+numbers.get(c))%divider == 0){
                        sum = numbers.get(a)+numbers.get(b)+numbers.get(c);
                        if(sum> maxSum){
                            maxSumNumbers.clear();
                            maxSum = sum;
                            maxSumNumbers.add(numbers.get(a));
                            maxSumNumbers.add(numbers.get(b));
                            maxSumNumbers.add(numbers.get(c));
                            count++;
                        }
                    }
                }
            }
        }
        if (count>0){
            System.out.printf("(%d + %d + %d) %% %d = 0", maxSumNumbers.get(0), maxSumNumbers.get(1), maxSumNumbers.get(2), divider);
        }else{
            System.out.print("No");
        }
    }
}
