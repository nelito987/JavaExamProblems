import java.util.*;

public class _52_CommandInterpreter {

    // judje 70/100

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<String> inputArray = new ArrayList<>();
        String [] input = scanner.nextLine().split("[\\s+]");

        for (int i = 0; i < input.length; i++) {
            inputArray.add(input[i]);
        }

        String commands;
        while (!(commands = scanner.nextLine()).equals("end")){
            String [] commandsArgs = commands.split("\\s+");
            String command = commandsArgs[0];

            switch (command){
                case "reverse":
                    int start = Integer.parseInt(commandsArgs[2]);
                    int count = Integer.parseInt(commandsArgs[4]);
                    if(isInvalid(inputArray.size(), start, count)){
                        System.out.println("Invalid input parameters.");
                        continue;
                    }else{
                        inputArray = reverseArray(inputArray,start, count);
                    }
                    break;
                case "sort":
                    int starts = Integer.parseInt(commandsArgs[2]);
                    int counts = Integer.parseInt(commandsArgs[4]);
                    if(isInvalid(inputArray.size(), starts, counts)){
                        System.out.println("Invalid input parameters.");
                        continue;
                    }else{
                        inputArray = sortArray(inputArray, starts, counts);
                    }

                    break;
                case "rollLeft":
                    int countRollLeft = Integer.parseInt(commandsArgs[1]);
                    inputArray = rollLeft(inputArray, countRollLeft);
                    break;
                case "rollRight":
                    int countRollRight = Integer.parseInt(commandsArgs[1]);
                    inputArray = rollRight(inputArray, countRollRight);
                    break;
            }
        }
        System.out.print(inputArray);
    }

    private static List<String> reverseArray(List<String> elements, int start, int count){
        List<String> newList = new ArrayList<>();
        int index = start+count-1;

        for (int i = 0; i < elements.size() ; i++) {
            newList.add(elements.get(i));
        }

        for (int i = start; i < start+count ; i++) {
            newList.remove(i);
            newList.add(i,elements.get(index));
            index--;
        }

        return newList;
    }

    private static List<String> sortArray(List<String> elements, int start, int count){
        List<String> newList = new ArrayList<>();
        List<String> sorted = new ArrayList<>();
        //int index = start;
        int end = Math.min((start + count - 1), elements.size() - 1);
        int indexSorted = 0;

        for (int i = 0; i < elements.size() ; i++) {
            newList.add(elements.get(i));
        }

        for (int i = start; i <= end ; i++) {
            sorted.add(elements.get(i));
            //index++;
        }
        Collections.sort(sorted);

        for (int i = start; i <= end; i++) {
            newList.remove(i);
            newList.add(i,sorted.get(indexSorted));
            indexSorted++;
        };

        return newList;
    }

    private static List<String> rollLeft(List<String> elements, int index){
        int count = index % elements.size();
        List<String> newList = new ArrayList<>();
        for (int i = count; i < elements.size(); i++) {
            newList.add(elements.get(i));
        }
        for (int i = 0; i <count ; i++) {
            newList.add(elements.get(i));
        }
        return newList;
    }

    private static List<String> rollRight(List<String> elements, int index){
        List<String> newList = new ArrayList<>();
        int count = index % elements.size();

        for (int i = elements.size() - count; i < elements.size(); i++) {
            newList.add(elements.get(i));
        }
        for (int i = 0; i <elements.size() - count; i++) {
            newList.add(elements.get(i));
        }
        return newList;
    }

    private static boolean isInvalid(int listLenght, int start, int count){
        boolean invalid = false;
        if( start< 0 || count < 0 || start>= listLenght){
            invalid = true;
        }

        return  invalid;
    }
}
// 1 2 3 4 5 6 7 8 // 3
// 4 5 6 7 8 1 2 3 // 9-3=6