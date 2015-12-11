import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _27_ValidUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] input = scanner.nextLine().split("[\\s()/\\\\]+");
        List<String> usernames = new ArrayList<>();

        Pattern pattern = Pattern.compile("\\b[a-zA-Z][\\w_]{2,25}\\b");
        for (String username : input) {
            Matcher matcher = pattern.matcher(username);
            if(matcher.find()){
                usernames.add(username);
            }
        }
        int maxLenght =0;
        int firstIndex =0;
        int secondIndex =0;
        for (int i = 0; i < usernames.size()-1 ; i++) {
            int curLenght = usernames.get(i).length()+usernames.get(i+1).length();
            if(curLenght> maxLenght){
                maxLenght =curLenght;
                firstIndex = i;
                secondIndex =i+1;
            }
        }
        System.out.println(usernames.get(firstIndex));
        System.out.println(usernames.get(secondIndex));
    }
}
