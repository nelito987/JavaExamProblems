import java.util.Scanner;

public class _33_Enigma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i <n ; i++) {
            String input = scanner.nextLine();
            String calcLength = new String(input.replace(" ",""));
            for (int j = 0; j < input.length() ; j++) {
                char a = input.charAt(j);
                if (a == ' ' || Character.isDigit(a)){
                    sb.append(a);
                }else{
                    char b = (char)(a + calcLength.length()/2);
                    sb.append(b);
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
