import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _29_GandalfStash {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int mood = Integer.parseInt(scanner.nextLine());

        String input = scanner.nextLine().toLowerCase();
        Pattern pattern = Pattern.compile("([a-z]+)");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()){
            switch (matcher.group()){
                case "cram": mood+=2;break;
                case "lembas": mood +=3;break;
                case "apple": mood +=1;break;
                case "melon": mood +=1;break;
                case "honeycake": mood+=5;break;
                case "mushrooms": mood-=10;break;
                    default:mood-=1;break;
            }
        }
        System.out.println(mood);
        if(mood<-5){
            System.out.println("Angry");
        }else if (mood>= -5 && mood <0){
            System.out.println("Sad");
        }else if(mood >=0 && mood <15){
            System.out.println("Happy");
        }else {
            System.out.println("Special JavaScript mood");
        }
    }
}
