
import java.util.ArrayList;
import java.util.Scanner;

public class _38_DragonTrap_Edo {

    private static ArrayList<int[]> positions;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numRows = Integer.parseInt(scanner.nextLine());
        char [][] pernik = new char[numRows][];
        char [][] originalPernik = new char[numRows][];

        for (int i = 0; i < numRows ; i++) {
            String line = scanner.nextLine();
            pernik[i] = line.toCharArray();
            originalPernik[i] = line.toCharArray();
        }

        String command = scanner.nextLine();

        while(!command.equals("End")){
            command = command.replaceAll("[)(]+", "");
            String [] commandArgs = command.split(" ");
            int row = Integer.parseInt(commandArgs[0]);
            int col = Integer.parseInt(commandArgs[1]);
            int radius = Integer.parseInt(commandArgs[2]);
            int rotations = Integer.parseInt(commandArgs[3]);

            int topBorder = row - radius;
            int bottomBorder = row + radius;
            int leftBorder = col - radius;
            int rightBorder = col + radius;

            String borders = getBorders(pernik, topBorder, bottomBorder, leftBorder, rightBorder);

            if(rotations !=0 && borders.length() > 0){
                borders = rotateBorders(borders, rotations);
                for (int i = 0; i < borders.length(); i++) {
                    int curRow = positions.get(i)[0];
                    int curCol = positions.get(i)[1];
                    char currentChar = borders.charAt(i);

                    pernik[curRow][curCol] = currentChar;
                }
            }

            command = scanner.nextLine();
        }

        printOutput(pernik, originalPernik);
    }

    private static String getBorders(char[][] pernik, int top, int bottom, int left, int right){
        StringBuilder borders = new StringBuilder();
        positions = new ArrayList<>();
        if (top >= 0 && top <pernik.length){
            int minCol = Math.max(0, left);
            int maxCol = Math.min(pernik[0].length-1, right);
            for (int i = minCol; i <= maxCol; i++) {
                borders.append(pernik[top][i]);
                positions.add(new int [] {top, i});
            }
            top++;
        }
        if (right >=0 && right < pernik[0].length){
            int minRow = Math.max(0, top);
            int maxRow = Math.min(pernik.length-1, bottom);
            for (int i = minRow; i <= maxRow; i++) {
                borders.append(pernik[i][right]);
                positions.add(new int [] {i, right});
            }

            right--;
        }
        if (bottom>=0 && bottom < pernik.length){
            int minCol = Math.max(0, left);
            int maxCol = Math.min(pernik[0].length-1, right);
            for (int i = maxCol; i >= minCol; i--) {
                borders.append(pernik[bottom][i]);
                positions.add(new int [] {bottom, i});
            }
            bottom--;
        }
        if (left >= 0 && left < pernik[0].length){
            int minRow = Math.max(0, top);
            int maxRow = Math.min(pernik.length-1, bottom);
            for (int i = maxRow; i >= minRow; i--) {
                borders.append(pernik[i][left]);
                positions.add(new int [] {i, left});
            }
        }

        return borders.toString();
    }

    private static String rotateBorders(String borders, int rotations){
        if (rotations < 0 ){
            rotations = Math.abs(rotations);
            rotations %= borders.length();
            String leftPart = borders.substring(0, rotations);
            String rightPart = borders.substring(rotations);
            return rightPart + leftPart;
        }else{
            rotations %= borders.length();
            String leftPart = borders.substring(0, borders.length() - rotations);
            String rightPart = borders.substring(borders.length() - rotations);
            return rightPart + leftPart;
        }
    }

    private static  void printOutput(char [][] pernik, char [][] originalPernik){

        int symbolChanged = 0;
        for (int i = 0; i <pernik.length ; i++) {
            for (int j = 0; j <pernik[i].length ; j++) {
                System.out.print(pernik[i][j]);
                if(pernik[i][j] != originalPernik[i][j]){
                    symbolChanged++;
                }
            }
            System.out.println();
        }

        System.out.println("Symbols changed: " + symbolChanged);
    }
}
