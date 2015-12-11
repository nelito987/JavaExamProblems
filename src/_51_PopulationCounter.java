import java.util.*;

public class _51_PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Long> totalSum = new LinkedHashMap<>();
        LinkedHashMap<String, LinkedHashMap<String, Long>> populationMap = new LinkedHashMap<>();
        String input;

        while(!(input = scanner.nextLine()).equals("report")){
            String [] populationArgs = input.split(("[|]"));
            String city = populationArgs[0].trim();
            String country = populationArgs[1].trim();
            int population = Integer.parseInt(populationArgs[2]);

            if(!populationMap.containsKey(country)){
                populationMap.put(country, new LinkedHashMap<>());
            }
            if (!totalSum.containsKey(country)) {
                totalSum.put(country, 0L);
            }
            long curPopulation = 0;
            if(populationMap.get(country).containsKey(city)){
                curPopulation = populationMap.get(country).get(city);
            }
            populationMap.get(country).put(city, population + curPopulation);
            totalSum.put(country, totalSum.get(country) + population);
        }

        totalSum.entrySet()
                .stream()
                .sorted((a,b) -> b.getValue().compareTo(a.getValue()))
                .forEach(entry -> {
                    System.out.printf("%s (total population: %d)\n",
                            entry.getKey(), entry.getValue());
                    populationMap.get(entry.getKey()).entrySet()
                            .stream()
                            .sorted((a,b) -> b.getValue().compareTo(a.getValue()))
                            .forEach(m-> System.out.printf("=>%s: %d\n",
                                    m.getKey(),
                                    m.getValue()));
                });

    }


   // private static String calculatePopulation(LinkedHashMap<String, Integer> populationMap){
   //     int totalCount = 0;
   //     for (Map.Entry<String, Integer> cities : populationMap.entrySet()) {
   //        totalCount += cities.getValue();
   //     }
   //     return String.format("%d", totalCount);
   // }

}
