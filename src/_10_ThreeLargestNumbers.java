import java.math.BigDecimal;
import java.util.*;

public class _10_ThreeLargestNumbers {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<BigDecimal> numbers = new ArrayList<>();

        for (int i = 0; i < n ; i++) {
            numbers.add(scanner.nextBigDecimal());
        }

        Collections.sort(numbers);
        Collections.reverse(numbers);
        if(numbers.size()==2){
            System.out.println(numbers.get(0));
            System.out.println(numbers.get(1));
        }else if(numbers.size()==1){
            System.out.println(numbers.get(0));
        } else{
            for (int i = 0; i < 3; i++) {
                System.out.println(numbers.get(i).toPlainString());
            }
        }
    }
}
