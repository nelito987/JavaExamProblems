import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class _16_StraightFlush {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] input = scanner.nextLine().split(", ");
        List<String> spades = new ArrayList<>();
        List<String> hearts = new ArrayList<>();
        List<String> diamonds = new ArrayList<>();
        List<String> clubs = new ArrayList<>();

        for (int i = 0; i <input.length; i++) {
            int lastChar = input[i].length()-1;
            switch (input[i].charAt(lastChar)){
                case 'S': spades.add(input[i]);break;
                case 'H': hearts.add(input[i]);break;
                case 'D': diamonds.add(input[i]);break;
                case 'C': clubs.add(input[i]);break;
            }
        }
    }
// TO DO......

}
