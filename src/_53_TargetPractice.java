import java.util.Scanner;

public class _53_TargetPractice {

    //judje 80/100

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] dimensions = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        String snake = scanner.nextLine();

        String [] shotParams = scanner.nextLine().split(" ");
        int impactRow = Integer.parseInt(shotParams[0]);
        int impactCol = Integer.parseInt(shotParams[1]);
        int radius = Integer.parseInt(shotParams[2]);

        char [][] matrix = new char [rows][cols];

        fillingTheMatrix(rows, cols, snake, matrix);
        shooting(impactRow, impactCol, radius, matrix);
        dropChars(matrix);


    }
    private static void fillingTheMatrix(int rows, int cols, String snake, char[][] matrix){
        int index = 0;
        int rowsCount = 0;

        for (int row = matrix.length - 1; row >=0; row--) {
            rowsCount++;
            if(rowsCount%2 == 0){
                for (int col = 0; col < matrix[1].length; col++) {
                    matrix[row][col] = snake.charAt(index);
                    index++;
                    if(index == snake.length()){
                        index = 0;
                    }
                }
            }else{
                for (int col = matrix[1].length-1; col >=0 ; col--) {
                    matrix[row][col] = snake.charAt(index);
                    index++;
                    if(index == snake.length()){
                        index = 0;
                    }
                }
            }
        }
    }
    private static void shooting(int shotRow, int shotCol, int radius, char[][] matrix){
        for (int r = 0; r < matrix.length ; r++) {
            for (int c = 0; c <matrix[1].length ; c++) {
                int inDiskY = r - shotRow;
                int inDiskX = c - shotCol;
                double distance = Math.sqrt((Math.pow(inDiskX,2)+Math.pow(inDiskY,2)));
                boolean inDisk = distance <= radius;
                if(inDisk == true){
                    matrix[r][c] = ' ';
                }
            }
        }
    }
    private static void dropChars(char[][] matrix){
        while(true){
            boolean fallen = false;
            for (int r = 0; r < matrix.length-1; r++) {
                for (int c = 0; c < matrix[1].length ; c++) {
                    if(matrix[r][c] != ' ' && matrix[r+1][c] == ' '){
                        matrix[r+1][c] = matrix[r][c];
                        matrix[r][c] = ' ';
                        fallen = true;
                    }
                }
            }
            if(!fallen){
                break;
            }
        }
        printMatrix(matrix);
    }

    private static void printMatrix(char[][] matrix){
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[1].length; c++) {
                System.out.print(matrix[r][c]);
            }
            System.out.println();
        }
    }
}
