import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _46_ShmoogleCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> integers = new ArrayList<>();
        List<String> doubles = new ArrayList<>();

        Pattern intPattern = Pattern.compile("int\\s+([a-z][a-zA-Z]*)");
        Pattern doublePattern = Pattern.compile("double\\s+([a-z][a-zA-Z]*)");

        String input;
        while(!(input = scanner.nextLine()).equals("//END_OF_CODE")){
            Matcher intMatch = intPattern.matcher(input);
            while(intMatch.find()){
                integers.add(intMatch.group(1));
            }
            Matcher doubleMatch = doublePattern.matcher(input);
            while(doubleMatch.find()){
                doubles.add(doubleMatch.group(1));
            }
        }

        Collections.sort(doubles);
        Collections.sort(integers);
        if(doubles.size()==0){
            System.out.println("Doubles: None");
        }else{
            System.out.print("Doubles: ");
            printList(doubles);
        }

        if(integers.size() ==0){
            System.out.println("Ints: None");
        }else{
            System.out.print("Ints: ");
            printList(integers);
        }

    }

    private static void printList (List<String> numbers){
        boolean isFirst = true;
        for (int i = 0; i <numbers.size() ; i++) {
            if(isFirst){
                System.out.print(numbers.get(i));
                isFirst = false;
            }else{
                System.out.printf(", %s", numbers.get(i));
            }
        }
        System.out.println();
    }
}
