// judje 70/100
// the problem is that I cannot print "Compile time error"

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _37_DragonSharp {
    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Pattern pattern = Pattern.compile("(.+?)\"(.+?)\";");
        boolean expectsElse = false;
        boolean isComileError = false;
        int errorLine = 0;

        for (int i = 0; i < n ; i++) {
            String input = scanner.nextLine();
            Matcher matcher = pattern.matcher(input);

            if(matcher.find()){
                String [] matchTokens = matcher.group(1).trim().split("\\s+");
                String output = matcher.group(2);

                if(matchTokens[0].equals("if")){
                    if(checkIFStatement(matchTokens[1])){
                        if(matchTokens[2].equals("loop")){
                            int repeat = Integer.parseInt(matchTokens[3]);
                            for (int j = 0; j < repeat ; j++) {
                                System.out.println(output);
                            }
                        }else{
                            System.out.println(output);
                        }
                        expectsElse = false;
                    }else{
                        expectsElse = true;
                    }
                }else if (matchTokens[0].equals("else") && expectsElse){
                    if(matchTokens[1].equals("loop")){
                        int repeat = Integer.parseInt(matchTokens[2]);
                        for (int j = 0; j < repeat ; j++) {
                            System.out.println(output);
                        }
                    }else{
                        System.out.println(output);
                    }
                }else{
                    isComileError = true;
                    errorLine = i +1;
                }
            }

        }
    }

    private static boolean checkIFStatement(String condition){
        condition = condition.substring(1, condition.length()-1);
        String [] conditionArgs = condition.split("[><=]+");
        int firstNum = Integer.parseInt(conditionArgs[0]);
        int secondNum = Integer.parseInt(conditionArgs[1]);
        String operator = condition.replaceAll("\\d+", "");

        boolean result;
        switch (operator){
            case "==": result = firstNum == secondNum; break;
            case ">": result = firstNum > secondNum; break;
            case "<": result = firstNum < secondNum; break;
            default: result = false;
        }

        return result;
    }
}
