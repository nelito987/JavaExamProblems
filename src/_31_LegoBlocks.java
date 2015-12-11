import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// this way of solving this problem is NOT CORRECT,
// because when it prints the output it reverse also the integers '37' => '73'
// and in case the arrays don`t fit it counts each digit , instead of counting the whole integer num
// have to do it with List<List<Character>>
// judge => 87/100

public class _31_LegoBlocks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        List<String> firstJag = new ArrayList<>();
        List<String> secondJag = new ArrayList<>();

        for (int i = 0; i <rows; i++) {
            String firstString = scanner.nextLine().trim().replace(" ","");
            firstJag.add(firstString);
        }
        for (int i = 0; i <rows ; i++) {
            String second = scanner.nextLine().trim().replace(" ", "");
            String reverse = new StringBuilder(second).reverse().toString();
            secondJag.add(reverse);
        }

        boolean fit = true;
        int lenght = firstJag.get(0).length() + secondJag.get(0).length();
        int totalLength = lenght;
        for (int i = 1; i < rows ; i++) {
            totalLength += firstJag.get(i).length() + secondJag.get(i).length();
           if(firstJag.get(i).length() + secondJag.get(i).length() != lenght){
               fit = false;
           }
        }

        List<Character> rowToPrint = new ArrayList<>();
        if(fit){
            for (int i = 0; i < rows; i++) {
                String completeRow = firstJag.get(i) + secondJag.get(i);
                for (int j = 0; j <completeRow.length(); j++) {
                    rowToPrint.add(completeRow.charAt(j));
                }
                System.out.println(rowToPrint);
                rowToPrint.clear();
            }
        }else{
            System.out.printf("The total number of cells is: " + totalLength);
        }
    }
}
