import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//50/100 judje beacuse of not using BigInteger

public class _49_ArraySlider {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] input = scanner.nextLine().split("\\s+");
        List<Long> list = new ArrayList<>();
        //int listLenght = list.size();


        for (int i = 0; i < input.length ; i++) {
            list.add(Long.parseLong(input[i]));
        }

        //System.out.println(list);
        int index = 0;

        String commands;
        while(!(commands = scanner.nextLine()).equals("stop")){
            String [] commandsArgs = commands.split("\\s+");
            long offset = Long.parseLong(commandsArgs[0]);
            String operation = commandsArgs[1];
            long operand = Long.parseLong(commandsArgs[2]);
            if (offset < 0){
                offset += list.size();
            }
            index += offset;
            examineCommand(index, operation, operand, list);
        }

        System.out.println(list);
    }
    private static void examineCommand(int index, String operation, long operand, List<Long> list){
        int listLenght = list.size();
        long result = 0;
        index = index % listLenght;

        switch (operation){
            case "&": result = list.get(index) & operand;break;
            case "|": result = list.get(index) | operand;break;
            case "^": result = list.get(index) ^ operand;break;
            case "+": result = list.get(index) + operand;break;
            case "-": result = list.get(index) - operand;
                if(result<0) result = 0;break;
            case "*": result = list.get(index) * operand;break;
            case "/": result = list.get(index) / operand;break;
        }

        list.set(index, result);
    }
}
