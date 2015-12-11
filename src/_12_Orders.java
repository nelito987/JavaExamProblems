import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _12_Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        LinkedHashMap<String, TreeMap<String,Integer>> orders = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String [] input = scanner.nextLine().split(" ");
            String name = input[0];
            int quantity = Integer.parseInt(input[1]);
            String fruit = input[2];

            if(!orders.containsKey(fruit)){
                orders.put(fruit, new TreeMap<>());
            }
            TreeMap<String, Integer> fruitOrder = orders.get(fruit);
            int curQuantity = 0;
            if(fruitOrder.containsKey(name)){
                curQuantity = fruitOrder.get(name);
            }
            fruitOrder.put(name, quantity+curQuantity);
        }

        for (String product : orders.keySet()) {
            System.out.print(product + ": ");
            TreeMap<String, Integer> fruitOrder = orders.get(product);
            boolean first = true;
            for (Map.Entry<String, Integer> pair : fruitOrder.entrySet()) {
                if (!first) {
                    System.out.print(", ");
                }
                first = false;
                String customer = pair.getKey();
                int amount = pair.getValue();
                System.out.print(customer + " " + amount);
            }
            System.out.println();
        }

    }
}
