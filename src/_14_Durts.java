import java.util.Scanner;

public class _14_Durts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] center = scanner.nextLine().split(" ");
        int centerX = Integer.parseInt(center[0]);
        int centerY = Integer.parseInt(center[1]);

        int size = Integer.parseInt(scanner.nextLine());
        int darts = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < darts ; i++) {
            double x = scanner.nextDouble();
            double y = scanner.nextDouble();

            if(inHorizontal(x,y,centerX,centerY,size)||inVertical(x,y,centerX,centerY,size)){
                System.out.println("yes");
            }else{
                System.out.println("no");
            }
        }

    }

    private static boolean inVertical(double y, double x, double centerY, double centerX, int r){
      boolean vertical = y>=centerY-r && y<= centerY+r && x>=centerX-0.5*r && x<=centerX+0.5*r;
        return vertical;
    }
    private static boolean inHorizontal(double y, double x, double centerY, double centerX, int r){
        boolean horizontal = x>=centerX-r && x<= centerX+r && y>=centerY-0.5*r && y<=centerY+0.5*r;
        return horizontal;
    }
}
