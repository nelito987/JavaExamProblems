import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//judje 90/100

public class _50_RageQuit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Pattern pattern = Pattern.compile("(\\D+)(\\d+)");
        List<Character> unique = new ArrayList<>();
        Matcher matcher = pattern.matcher(input);
        StringBuilder output = new StringBuilder();

        while (matcher.find()){
            String message = matcher.group(1).toUpperCase();
            int repeating = Integer.parseInt(matcher.group(2));

            for (int i = 0; i < repeating ; i++) {
                output.append(message);
            }
            for (int i = 0; i < message.length() ; i++) {
                if (!unique.contains(message.charAt(i))){
                    unique.add(message.charAt(i));
                }
            }
        }

        System.out.printf("Unique symbols used: %d\n", unique.size());
        //System.out.print(output);
        System.out.print(unique);

    }
}
