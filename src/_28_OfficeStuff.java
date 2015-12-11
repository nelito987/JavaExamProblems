import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _28_OfficeStuff {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        TreeMap<String, LinkedHashMap<String, Integer>> orders = new TreeMap<>();

        for (int i = 0; i < n ; i++) {
            String input = scanner.nextLine();
            input = input.substring(1,input.length()-1);
            String [] inputArg = input.split(" - ");
            //for (int j = 0; j < inputArg.length ; j++) {
            //    System.out.println(inputArg[i]);
            //}
            String company = inputArg[0];
            int quantity = Integer.parseInt(inputArg[1]);
            String product = inputArg[2];

            if(!orders.containsKey(company)){
                orders.put(company, new LinkedHashMap<>());
            }
            LinkedHashMap<String, Integer> productOrder = orders.get(company);

            int curQuantity = 0;
            if(productOrder.containsKey(product)){
                curQuantity = productOrder.get(product);
            }
            productOrder.put(product, curQuantity+quantity);
        }

        for (String company : orders.keySet()) {
            System.out.print(company + ": ");
            LinkedHashMap<String, Integer> productOrder = orders.get(company);
            boolean first = true;
            for (Map.Entry<String, Integer> pair: productOrder.entrySet()) {
                if(!first){
                    System.out.print(", ");
                }
                first = false;
                String product = pair.getKey();
                int amount = pair.getValue();
                System.out.print(product + "-" + amount);
            }
            System.out.println();
        }
    }
}
