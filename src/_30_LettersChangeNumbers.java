import java.util.Scanner;

public class _30_LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] input = scanner.nextLine().trim().split("\\s+");
        double curSum = 0;
        double totalSum = 0;
        for (int i = 0; i < input.length; i++) {
            char first = input[i].charAt(0);
            char last = input[i].charAt(input[i].length()-1);
            int number = Integer.parseInt(input[i].substring(1,input[i].length()-1));

            //calculating first char
            if (first>='a' && first<='z'){
                curSum = (double)number*(first - 'a' +1);
            }else if(first>='A' && first<='Z'){
                curSum = (double)number/(first - 'A' +1);
            }

            //calculating last char
            if(last >='a' && last<='z'){
                curSum+=(last - 'a' +1);
            }else if(last>='A' && last <='Z'){
                curSum-=(last - 'A' +1);
            }
            totalSum+=curSum;
        }
        System.out.printf("%.2f", totalSum);
    }
}
