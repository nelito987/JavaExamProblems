import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class _47_SrbskoUnleashed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, LinkedHashMap<String, Integer>> program = new LinkedHashMap<>();
        Pattern pattern = Pattern.compile("([a-zA-Z ]+)\\s@([a-zA-Z ]+)\\s([0-9]+)\\s([0-9]+)");
        String input;
        while(!(input = scanner.nextLine()).equals("End")){
            Matcher matcher = pattern.matcher(input);
            while (matcher.find()){
                String singer = matcher.group(1).trim();
                String city = matcher.group(2).trim();
                int price = Integer.parseInt(matcher.group(3));
                int countTickets = Integer.parseInt(matcher.group(4));
                int curIncome = 0;
                int income = price*countTickets;

                if(!program.containsKey(city)){
                    program.put(city, new LinkedHashMap<>());
                }
                if(program.get(city).containsKey(singer)){
                    curIncome = program.get(city).get(singer);
                }
                program.get(city).put(singer, income+curIncome);

            }
        }
        for (Map.Entry<String, LinkedHashMap<String, Integer>> pair: program.entrySet()) {
            System.out.println(pair.getKey());
            pair.getValue().entrySet().stream()
                    .sorted((t1, t2) -> t2.getValue().compareTo(t1.getValue()))
                    .forEach((entry) -> {
                        System.out.printf("#  %s -> %d\n", entry.getKey().trim(), entry.getValue());
                    });
        }

    }
}
