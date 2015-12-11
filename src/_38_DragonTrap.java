import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _38_DragonTrap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<List<Character>> board = new ArrayList<>();

        int numRows = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numRows ; i++) {
            board.add(new ArrayList<>());
            String line = scanner.nextLine().trim();
            char [] charArray = line.toCharArray();
            for (int j = 0; j <charArray.length ; j++) {
                board.get(i).add(charArray[j]);
            }

        }

        String command;

        while (!(command = scanner.nextLine()).equals("End")){
            String [] commandArg = command.trim().split("[) ]");
            String [] coordinates = (commandArg[0].substring(1)).split(" ");
            int x = Integer.parseInt(coordinates[0]);
            int y = Integer.parseInt(coordinates[1]);
            String [] radiusAndRotation = commandArg[1].trim().split(" ");
            int radius = Integer.parseInt(radiusAndRotation[0]);
            int rotation = Integer.parseInt(radiusAndRotation[1]);
        }



    }
}
