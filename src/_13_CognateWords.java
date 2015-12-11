import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _13_CognateWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Pattern pattern = Pattern.compile("[A-Za-z]+");
        Matcher matcher = pattern.matcher(input);
        List<String> words = new ArrayList<>();
        List<String> cognateWords = new ArrayList<>();
        int count = 0;

        while (matcher.find()){
            words.add(matcher.group());
        }

        for (int a = 0; a < words.size() ; a++) {
            for (int b = 0; b < words.size() ; b++) {
                for (int c = 0; c < words.size() ; c++) {
                    if((words.get(a) + words.get(b)).equals(words.get(c)) && a!=b && b!=c && a!=c){
                        String wordToPrint = words.get(c);
                        if(!cognateWords.contains(wordToPrint)){
                            cognateWords.add(wordToPrint);
                            System.out.printf("%s|%s=%s\n", words.get(a), words.get(b), words.get(c));
                            count++;
                        }
                    }
                }
            }
        }
        if(count == 0){
            System.out.println("No");
        }
    }
}
