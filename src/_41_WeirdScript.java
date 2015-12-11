import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _41_WeirdScript {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int keyNum= Integer.parseInt(scanner.nextLine());
        //System.out.println(findKey(keyNum));
        String key = findKey(keyNum);

        Pattern pattern = Pattern.compile(key + "(.*?)" + key);

        String input;
        StringBuilder text =  new StringBuilder();
        while(!(input = scanner.nextLine()).equals("End")){
            text.append(input);
        }
        Matcher matcher = pattern.matcher(text);
        while(matcher.find()){
            if(matcher.group(1).length() > 0){
                System.out.println(matcher.group(1));
            }
        }
    }

    private static String findKey (int keyNum){
        int num = (keyNum -1) % 52;
        char letter;
        if (num >=0 && num <= 26){
            letter = (char)(num + 97);
        }else{
            letter = (char)(num +39);
        }

        StringBuilder key = new StringBuilder();
        key.append(letter);
        key.append(letter);
        return key.toString();
    }
}
