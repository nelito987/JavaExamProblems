import java.util.Scanner;

public class _40_TinySporebat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int health = 5800;
        String input = "";
        int glowcaps = 0;

        while(!(input = scanner.nextLine()).equals("Sporeggar")) {
            int curGlowcap = input.charAt(input.length() - 1) - '0';
            for (int i = 0; i < input.length() - 1; i++) {
                Character ch = input.charAt(i);
                if (ch != 'L') {
                    health -= ch;
                    if (health <= 0) {
                        System.out.println("Died. Glowcaps: " + glowcaps);
                        return;
                    }
                } else {
                    health += 200;
                }
            }
            glowcaps += curGlowcap;
        }

        System.out.println("Health left: " + health);
        if(glowcaps >= 30){
            System.out.println("Bought the sporebat. Glowcaps left: " + (glowcaps - 30));
        }else{
            int neededGlowcaps = Math.abs(glowcaps - 30);
            System.out.printf("Safe in Sporeggar, but another %d Glowcaps needed.", neededGlowcaps);
        }

    }
}
