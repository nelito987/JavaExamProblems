
import java.util.*;


public class _36_Weghtlifting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = Integer.parseInt(scanner.nextLine());

        TreeMap<String, TreeMap<String, Long>> list = new TreeMap<>();

        for (int i = 0; i < lines; i++) {
            String[] input = scanner.nextLine().trim().split(" ");
            String player = input[0];
            String exercise = input[1];
            Long weight = Long.parseLong(input[2]);

            if (!list.containsKey(player)) {
                list.put(player, new TreeMap<>());
                list.get(player).put(exercise, weight);
            } else {
                long curWeight = 0;
                if (list.get(player).containsKey(exercise)) {
                    curWeight = list.get(player).get(exercise);
                }
                list.get(player).put(exercise, curWeight + weight);
            }
        }

       Set<String> players = list.keySet();
        for (String player : players) {

            System.out.printf("%s : ", player);

            TreeMap<String, Long> results = list.get(player);
            Set<String> exercises = results.keySet();

            boolean isFirst = true;

            for (String ex : exercises) {
                if(isFirst){
                    System.out.printf("%s - %d kg", ex, results.get(ex));
                    isFirst= false;
                }else{
                    System.out.printf(", %s - %d kg", ex, results.get(ex));
                }
            }
            System.out.println();
        }

    }
}