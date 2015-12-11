import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _55_OlimpycsAreComing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        int counter = 0;
        LinkedHashMap<String, LinkedHashMap<String, Integer>> olympics = new LinkedHashMap<>();
        Map<String, Integer> totalWins = new LinkedHashMap<>();

        while(!(input = scanner.nextLine()).equals("report")){
            String whitespaceInput = input.replaceAll("([\\s]+)", " ");
            String [] inputArg = whitespaceInput.split("[|]");
            String participant = inputArg[0].trim();
            String country = inputArg[1].trim();

            if(!olympics.containsKey(country)){
                olympics.put(country, new LinkedHashMap<>());
            }
            if(!totalWins.containsKey(country)){
                totalWins.put(country, 0);
            }
            int currWins = 0;
            if(olympics.get(country).containsKey(participant)){
                currWins = olympics.get(country).get(participant);
            }
            olympics.get(country).put(participant, currWins + 1);
            totalWins.put(country, totalWins.get(country) + 1);

        }

        totalWins.entrySet()
                .stream()
                .sorted((a,b) -> b.getValue().compareTo(a.getValue()))
                .forEach(entry -> {
                    System.out.printf("%s (%d participants: %d wins)\n",entry.getKey(),
                            olympics.get(entry.getValue())
                            , entry.getValue() );
                });


    }
}
