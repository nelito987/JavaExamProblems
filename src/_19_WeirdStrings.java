import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _19_WeirdStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        input = input.replaceAll("[()\\/|\\s]+", "");
        Pattern pattern = Pattern.compile("[a-zA-Z]+");
        Matcher matcher = pattern.matcher(input);
        List<String> words = new ArrayList<>();
        int sum = 0;
        int maxSum = 0;
        String result = "";

        while (matcher.find()){
            words.add(matcher.group());
        }
        for (int i = 0; i < words.size()-1; i++) {
            String couple = (words.get(i)+words.get(i+1)).toLowerCase();
            sum = calculateWeight(couple);
            if(sum>maxSum){
                maxSum=sum;
                result = words.get(i)+"\n"+words.get(i+1);
            }
        }
        System.out.print(result);

    }
    private static Integer calculateWeight(String s){
        int weight = 0;
        for (int i = 0; i <s.length() ; i++) {
            weight += s.charAt(i) - ('a'-1);
        }
        return weight;
    }
}
