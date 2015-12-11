import java.util.*;

public class _39_DragonArmy {
    private static final int DEFAULT_DMG = 45;
    private static final int DEFAULT_HEALTH = 250;
    private static final int DEFAULT_ARMOR = 10;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String, TreeMap<String, int[]>> army = new LinkedHashMap<>();

        for (int i = 0; i < n ; i++) {
            String [] input = scanner.nextLine().trim().split(" ");
            String type = input[0];
            String name = input[1];
            int damage = (input[2].equals("null") ? DEFAULT_DMG : Integer.parseInt(input[2]));
            int health = (input[3].equals("null") ? DEFAULT_HEALTH : Integer.parseInt(input[3]));
            int armor = (input[4].equals("null") ? DEFAULT_ARMOR : Integer.parseInt(input[4]));


            if(!army.containsKey(type)){
                army.put(type, new TreeMap<>());
            }
            if(!army.get(type).containsKey(name)){
                army.get(type).put(name, new int[3]);
            }
            army.get(type).get(name)[0] = damage;
            army.get(type).get(name)[1] = health;
            army.get(type).get(name)[2] = armor;
        }

        for (Map.Entry<String, TreeMap<String, int[]>> pair : army.entrySet()) {
            System.out.println(pair.getKey() + "::" + getAverage(pair.getValue()));
            pair.getValue()
                    .entrySet()
                    .stream()
                    .forEach(innerPair -> System.out.printf("-%s -> damage: %d, health: %d, armor: %d\n",
                            innerPair.getKey(),
                            innerPair.getValue()[0],
                            innerPair.getValue()[1],
                            innerPair.getValue()[2]));
        }
    }
   private static String getAverage(TreeMap<String, int []> dragonStats){
       double damage = 0;
       double health = 0;
       double armor = 0;
       int count = dragonStats.size();

       for (Map.Entry<String, int[]> pair : dragonStats.entrySet()) {
           damage += pair.getValue()[0];
           health += pair.getValue()[1];
           armor += pair.getValue()[2];
       }
       double avgDamage = damage/count;
       double avgHealth = health/count;
       double avgArmor = armor/count;

       return String.format("(%.2f/%.2f/%.2f)",avgDamage, avgHealth, avgArmor);

   }
}
