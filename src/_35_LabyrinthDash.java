import java.util.Scanner;

public class _35_LabyrinthDash {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        char [][] labyrinth = new char[n][];

        for (int i = 0; i <n ; i++) {
            labyrinth[i] = scanner.nextLine().toCharArray();
        }
        char [] moves = scanner.nextLine().toCharArray();

        int lives = 3;
        int curRow =0;
        int curCol =0;
        int movesMade = 0;

        for (char move : moves) {
            int initialRow = curRow;
            int initialCol = curCol;

            switch (move){
                case '>': curCol++; break;
                case '<': curCol--; break;
                case 'v': curRow++; break;
                case '^': curRow--; break;
            }

            if (
                    labyrinth[curRow][curCol] == ' ' ||
                    curRow<= 0 || curRow>= labyrinth.length ||
                    curCol < 0 || curCol >= labyrinth[curRow].length) {
                movesMade++;
                System.out.println("Fell off a cliff! Game Over!");
            }else if(labyrinth[curRow][curCol] == '_' || labyrinth[curRow][curCol] == '|'){
                curRow = initialRow;
                curCol = initialCol;
                System.out.println("Bumped a wall.");

            }else if(labyrinth[curRow][curCol] == '@' ||
                    labyrinth[curRow][curCol] == '#' ||
                    labyrinth[curRow][curCol] == '*'){
                movesMade++;
                lives--;
                System.out.printf("Ouch! That hurt! Lives left: %d%n", lives);
                if(lives == 0){
                    System.out.println("No lives left! Game over!");
                    break;
                }
            }else if(labyrinth[curRow][curCol] == '$'){
                lives++;
                movesMade++;
                labyrinth[curRow][curCol] = '.';
                System.out.printf("Awesome! Lives left: %d\n", lives);
            }else{
                movesMade++;
                System.out.println("Made a move!");
            }
        }
        System.out.printf("Total moves made: %d", movesMade);
    }
}
