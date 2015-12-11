import java.util.Scanner;

public class _25_MirrorNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String [] allNumbers = scanner.nextLine().split(" ");
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < n ; i++) {
            sb.append(allNumbers[i].charAt(3));
            sb.append(allNumbers[i].charAt(2));
            sb.append(allNumbers[i].charAt(1));
            sb.append(allNumbers[i].charAt(0));
            String newNumber = sb.toString();
            sb.delete(0,4);

            for (int j = i+1; j < n ; j++) {
                if(allNumbers[j].equals(newNumber)){
                    System.out.printf("%s<!>%s\n", allNumbers[i], newNumber);
                    count++;
                }
            }
        }
        if (count == 0){
            System.out.println("No");
        }
    }
}
