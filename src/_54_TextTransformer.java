import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//40/100 of judje because of time limit, but I guess the reasn is that timelimit settings are for C#, the outputs looks ok.

public class _54_TextTransformer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        StringBuilder totalInput = new StringBuilder();
        String str = "";
        while(!(input = scanner.nextLine()).equals("burp")){

            totalInput.append(input);
            str = totalInput.toString().replaceAll("([\\s]+)", " ");
        }

        Pattern pattern = Pattern.compile("([$%&'])([^$%&']+)\\1");
        Matcher matcher = pattern.matcher(str);

        StringBuilder result = new StringBuilder();
        while (matcher.find()){
            String word = matcher.group(2);
            String weight = matcher.group(1);

            for (int i = 0; i < word.length(); i++) {
                if(i%2==0){
                    char resEven = (char)(word.charAt(i) + calcWeight(weight));
                    result.append(resEven);
                }else{
                    char resOdd = (char)(word.charAt(i) - calcWeight(weight));
                    result.append(resOdd);
                }
            }
            result.append(" ");
        }

        System.out.println(result);
    }

    private static int calcWeight (String weight){
        int charWeight = 0;
        switch (weight){
            case "$": charWeight = 1;break;
            case "%": charWeight = 2;break;
            case "&": charWeight = 3;break;
            case "'": charWeight = 4;break;
        }

        return charWeight;
    }
}
