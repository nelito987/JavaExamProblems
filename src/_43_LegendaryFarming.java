import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class _43_LegendaryFarming {
    private static final int WIN_QUANTITY = 250; //if this int is inside the main class,
                                                 // it gives runtime error in judje

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String keyCollectedFirst = "";

        LinkedHashMap<String, Integer> keyMaterials = new LinkedHashMap<String, Integer>() {{
            put("fragments", 0);
            put("motes", 0);
            put("shards", 0);
        }};
        TreeMap<String, Integer> junkMaterials = new TreeMap<>();

        while(true){
            String [] input = scanner.nextLine().split(" ");
            for (int i = 0; i < input.length ; i+=2) {
                int quantity = Integer.parseInt(input[i]);
                String item = input[i+1].toLowerCase();

                if(keyMaterials.containsKey(item)){
                   keyMaterials.put(item, keyMaterials.get(item) + quantity);

                    if(keyMaterials.get(item) >= WIN_QUANTITY){
                        keyMaterials.put(item, keyMaterials.get(item) - WIN_QUANTITY);
                        keyCollectedFirst = item;
                        break;
                    }

                }else{
                    if(!junkMaterials.containsKey(item)){
                        junkMaterials.put(item, 0);
                    }
                    junkMaterials.put(item, junkMaterials.get(item) + quantity);
                }
            }
            if (keyCollectedFirst.length() > 0) {
                break;
            }
        }
        String obtainedOutput = "";
        switch (keyCollectedFirst){
            case "shards": obtainedOutput = "Shadowmourne"; break;
            case "fragments": obtainedOutput = "Valanyr"; break;
            case "motes": obtainedOutput = "Dragonwrath"; break;
        }

        System.out.println(obtainedOutput + " obtained!");

        keyMaterials.entrySet().stream()
                .sorted((k1, k2) -> k2.getValue().compareTo(k1.getValue()))
                .forEach(k -> System.out.println(k.getKey() + ": " + k.getValue()));

        junkMaterials.entrySet().forEach(j -> System.out.println(j.getKey() + ": "+ j.getValue() ));
    }
}
