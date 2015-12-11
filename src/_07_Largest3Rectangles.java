import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _07_Largest3Rectangles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim().replace(" ", "");
        input = input.replace("[","");
        input = input.replace("]"," ");
        input = input.replace("x", " ");

        String [] nums = input.split(" ");
        int [] numbers = new int [nums.length];
        for (int i = 0; i < numbers.length ; i++) {
            numbers[i] = Integer.parseInt(nums[i]);
        }

        List<Integer> area = new ArrayList<>();
        for (int i = 0; i <numbers.length ; i+=2) {
            int rectArea = numbers[i]*numbers[i+1];
            area.add(rectArea);
        }

        int max = 0;
        int curMax = 0;
        for (int i = 0; i < area.size()-2 ; i++) {
            curMax = area.get(i) + area.get(i+1)+area.get(i+2);
            if(curMax>max){
                max = curMax;
            }
        }

        System.out.println(max);

    }
}
