import java.util.Scanner;

public class _45_RadioactiveBunnies {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] matrixSize = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(matrixSize[0]);
        int cols = Integer.parseInt(matrixSize[1]);

        int playerRow = 0;
        int playerCol = 0;

        char [][]matrix = new char[rows][];

        for (int i = 0; i <rows ; i++) {
            String rowArgs = scanner.nextLine();
            matrix[i] = rowArgs.toCharArray();
            int playerC = rowArgs.indexOf('P');
            if (playerC != -1){
                playerCol = playerC;
                playerRow = i;
                matrix[playerRow][playerCol] = '.';
            }
        }

        String commands = scanner.nextLine();

        for (int i = 0; i < commands.length() ; i++) {
            char command = commands.charAt(i);

            int oldPRow = playerRow;
            int oldPCol = playerCol;

            switch (command){
                case 'U': playerRow--;break;
                case 'D': playerRow++;break;
                case 'L': playerCol--;break;
                case 'R': playerCol++; break;
            }

            matrix = spreadBunnies(matrix, rows - 1, cols -1 );

            if (playerRow < 0 || playerRow >= rows ||
                    playerCol < 0 || playerCol >= cols){

                for (int j = 0; j < rows; j++) {
                    for (int k = 0; k < cols ; k++) {
                        System.out.print(matrix[j][k]);
                    }
                    System.out.println();
                }
                System.out.println("won: " + oldPRow + " " + oldPCol);
                return;
            }

            if (matrix[playerRow][playerCol] == 'B'){
                for (int j = 0; j < rows; j++) {
                    for (int k = 0; k < cols ; k++) {
                        System.out.print(matrix[j][k]);
                    }
                    System.out.println();
                }
                System.out.println("dead: " + playerRow + " " + playerCol);
                return;
            }
        }

    }
    public static char [][] spreadBunnies (char [][] matrix, int rows, int cols){

        char [][] newBunnies = new char[matrix.length][];

        for (int i = 0; i < matrix.length; i++) {
            newBunnies[i] = (char[])matrix[i].clone();
        }

        for (int i = 0; i <= rows; i++) {
            for (int j = 0; j <= cols; j++) {
                if(matrix[i][j] == 'B'){
                    if(i > 0) newBunnies[i-1][j] = 'B';
                    if(i < rows) newBunnies[i+1][j] = 'B';
                    if(j > 0) newBunnies[i][j-1] = 'B';
                    if(j < cols) newBunnies[i][j+1] = 'B';
                }
            }

            //for (int j = 0; j < rows; j++) {
            //    for (int k = 0; k < cols ; k++) {
            //        System.out.print(matrix[i][j]);
            //    }
            //    System.out.println();
            //}
        }
        return newBunnies;
    }
}
