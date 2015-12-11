import java.util.Scanner;

public class _05_VideoDurator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalHours = 0;
        int totalMins = 0;

        while(!scanner.hasNext("End")){
            String [] input = scanner.nextLine().split(":");
            int hours = Integer.parseInt(input[0]);
            int mintutes = Integer.parseInt(input[1]);
            totalHours += hours;
            totalMins += mintutes;
        }

        totalHours = totalHours + totalMins/60;
        totalMins = totalMins % 60;
        System.out.printf("%d:%02d\n",totalHours,totalMins);
    }
}
