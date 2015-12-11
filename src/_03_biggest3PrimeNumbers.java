import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _03_biggest3PrimeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Pattern pattern = Pattern.compile("([-\\d]+)");
        Matcher matcher = pattern.matcher(input);
        List<Integer> numbers =  new ArrayList<>();
        List<Integer> primes = new ArrayList<>();
        int sum = 0;

        while (matcher.find()){
            numbers.add(Integer.parseInt(matcher.group()));
        }

        for (Integer number : numbers) {
            if (isPrime(number) && !primes.contains(number) && (number<-1 || number>1)){
                primes.add(number);
            }
        }

        if (primes.size() < 3){
            System.out.print("No");
        }else {
            Collections.sort(primes);
            Collections.reverse(primes);


            for (int i = 0; i < 3; i++) {
                sum += primes.get(i);
            }
            System.out.print(sum);
        }
    }

    public static boolean isPrime(int num) {
        boolean isprime = true;
        int n = Math.abs(num);
        for (int i=2; i<n;i++) {
            if(n%i==0) {
                isprime = false;
            }
        }
        return isprime;
    }
}
