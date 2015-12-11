import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class _31_LegoBlocks_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        List<List<Integer>> firstBlock = new ArrayList<>();
        List<List<Integer>> secondBlock = new ArrayList<>();

        //reading the first block
        for (int i = 0; i < n ; i++) {
            firstBlock.add(new ArrayList<>());
            String [] numsAsString = scanner.nextLine().trim().split("\\s+");
            for (String s : numsAsString) {
                firstBlock.get(i).add(Integer.parseInt(s));
            }
        }

        //reading the second block
        for (int i = 0; i < n ; i++) {
            secondBlock.add(new ArrayList<>());
            String [] numsAsString = scanner.nextLine().trim().split("\\s+");
            for (String s : numsAsString) {
                secondBlock.get(i).add(Integer.parseInt(s));
            }
        }

        //merging
        boolean fit = true;
        int length = firstBlock.get(0).size() + secondBlock.get(0).size();
        int totalLength = 0;
        for (int i = 0; i <n ; i++) {
            Collections.reverse(secondBlock.get(i));
            totalLength += firstBlock.get(i).size() + secondBlock.get(i).size();
            if(length!= firstBlock.get(i).size() + secondBlock.get(i).size()){
                fit = false;
            }
        }

        //printing the result
        if(fit){
            for (int i = 0; i < n ; i++) {
                firstBlock.get(i).addAll(secondBlock.get(i));
            }
            for (List<Integer> integers : firstBlock) {
                System.out.println(integers);
            }
        }else{
            System.out.printf("The total number of cells is: " + totalLength);
        }
    }
}
