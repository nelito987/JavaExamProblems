import java.util.*;
import java.util.Locale;

public class _26_PossibleTriangle {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        List<Double> numbers = new ArrayList<>();
        int count = 0;

        while(!(scanner.hasNext("End"))){
            numbers.add(scanner.nextDouble());
            numbers.add(scanner.nextDouble());
            numbers.add(scanner.nextDouble());
            Collections.sort(numbers);
            if(numbers.get(0)+ numbers.get(1) > numbers.get(2)){
                System.out.printf("%.2f+%.2f>%.2f\n",numbers.get(0), numbers.get(1),numbers.get(2));
                count++;
            }
            numbers.clear();
        }
        if(count == 0){
            System.out.print("No");
        }
    }
}
