import java.util.Scanner;

public class _11_LongestOddEvenSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim().replace(" ", "");
        String newInput = input.replace("(","");
        String [] numbersAsString = newInput.split("\\)");
        int [] numbers = new int[numbersAsString.length];
        for (int i = 0; i < numbers.length ; i++) {
            numbers[i] = Integer.parseInt(numbersAsString[i]);
        }

        int maxLenght = 0;
        int curLenght = 1;

        for (int i = 0; i <numbers.length-1 ; i++) {
            int current = numbers[i];
            int next = numbers[i+1];

            if((current%2==0 || current==0) && (next%2!=0 || next==0) ||
                    (current%2!=0 || current==0) && (next%2==0 || next==0)){
                curLenght++;
                if(curLenght>maxLenght){
                    maxLenght = curLenght;
                }
            }else{
                curLenght = 1;
            }
        }
        System.out.print(maxLenght);
    }

}
