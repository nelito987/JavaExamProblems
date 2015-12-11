import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class _44_ArrayManipulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] nums = scanner.nextLine().trim().split(" ");
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < nums.length ; i++) {
            numbers.add(Integer.parseInt(nums[i]));
        }

        String command;
        while(!(command = scanner.nextLine()).equals("end")){
            String [] commandArg = command.split(" ");

            String commandMain = commandArg[0];

            if(commandMain.equals("exchange")){
                int index = Integer.parseInt(commandArg[1]);
                if(index> numbers.size()-1 || index <0){
                    System.out.println("Invalid index");
                }else{
                    numbers = exchangeIndex(numbers, index);
                }
            }else if(commandMain.equals("max")){
                String oddEven = commandArg[1];
                System.out.println(maxElementIndex(numbers, oddEven));
            }else if(commandMain.equals("min")) {
                String oddEven = commandArg[1];
                System.out.println(minElementIndex(numbers, oddEven));

            }else if(commandMain.equals("first")){
                int numElements = Integer.parseInt(commandArg[1]);
                String oddEven = commandArg[2];
                if(numElements> numbers.size()){
                    System.out.println("Invalid count");
                }else {
                    System.out.println(firstEvenOddElements(numbers, numElements, oddEven));
                }
            }else if(commandMain.equals("last")){
                int numElements = Integer.parseInt(commandArg[1]);
                String oddEven = commandArg[2];

                if(numElements> numbers.size()){
                    System.out.println("Invalid count");
                }else {
                    System.out.println(lastEvenOddElements(numbers, numElements, oddEven));
                }
            }

        }

        System.out.println(numbers);


    }

    private static List<Integer> exchangeIndex(List<Integer> numbers, int index){
        List<Integer> newList = new ArrayList<>();
        for (int i = index+1; i < numbers.size() ; i++) {
            newList.add(numbers.get(i));
        }
        for (int i = 0; i <= index ; i++) {
            newList.add(numbers.get(i));
        }

        return newList;
    }

    private static String maxElementIndex(List<Integer> numbers, String oddEven){
        int maxIndex = -1;
        int maxNum = Integer.MIN_VALUE;
        int remainder = oddEven.equals("odd") ? 1 : 0;

        for (int i = 0; i <numbers.size() ; i++) {
            int currentNum = numbers.get(i);
            if(currentNum % 2 == remainder && currentNum >= maxNum){
                maxNum = currentNum;
                maxIndex =i;
            }
        }

        return maxIndex < 0 ? "No matches" : Integer.toString(maxIndex);
    }

    private static String minElementIndex(List<Integer> numbers, String oddEven){
        int minIndex = -1;
        int minNum = Integer.MAX_VALUE;
        int remainder = oddEven.equals("odd") ? 1 : 0;

        for (int i = 0; i <numbers.size() ; i++) {
            int currentNum = numbers.get(i);
            if(currentNum % 2 == remainder && currentNum <= minNum){
                minNum = currentNum;
                minIndex =i;
            }
        }

        return minIndex < 0 ? "No matches" : Integer.toString(minIndex);
    }
    private static List<Integer> firstEvenOddElements(List<Integer> numbers, int numElements, String oddEven){
        List<Integer> firstEvenOdd = new ArrayList<>();
        int remainder = oddEven.equals("odd") ? 1 : 0;
        int counter = 0;

        for (int j = 0; j < numbers.size() ; j++) {
            if(numbers.get(j) % 2 == remainder){
                firstEvenOdd.add(numbers.get(j));
                counter++;
            }
            if(counter == numElements) break;
        }
        return  firstEvenOdd;
    }
    private static List<Integer> lastEvenOddElements(List<Integer> numbers, int numElements, String oddEven){
        List<Integer> lastEvenOdd = new ArrayList<>();
        int remainder = oddEven.equals("odd") ? 1 : 0;
        int counter = 0;

        if(numElements> numbers.size()){
            System.out.println("Invalid count");
        }

        for (int i = numbers.size()-1; i >= 0 ; i--) {
            if(numbers.get(i) % 2 == remainder){
                lastEvenOdd.add(numbers.get(i));
                counter++;
            }
            if(counter == numElements) break;
        }

        //while (lastEvenOdd.size() < numElements){
        //    if(numbers.get(i) % 2 == remainder){
        //        lastEvenOdd.add(numbers.get(i));
        //    }
        //    i--;
        //}
        Collections.reverse(lastEvenOdd);
        return  lastEvenOdd;
    }
}
