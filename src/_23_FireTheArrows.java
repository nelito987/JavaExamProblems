
import java.util.Scanner;

public class _23_FireTheArrows {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        char [][] matrix = new char[rows][];

        for (int i = 0; i < rows ; i++) {
            matrix[i] = scanner.nextLine().toCharArray();
        }

        boolean moved = true;
        while (moved){
            moved = false;
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < matrix[0].length ; c++) {
                    if(matrix[r][c] != 'o'){
                        int newRow =r;
                        int newCol =c;
                        switch (matrix[r][c]){
                            case '^': newRow--; break;
                            case 'v': newRow++; break;
                            case '>': newCol++; break;
                            case '<': newCol--; break;
                        }
                        if (newRow>=0 && newRow < rows &&
                                newCol>=0 && newCol<matrix[0].length &&
                                matrix[newRow][newCol] == 'o'){
                            matrix[newRow][newCol] = matrix[r][c];
                            matrix[r][c] = 'o';
                            moved = true;
                        }
                    }
                }
            }
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }

    }
}
