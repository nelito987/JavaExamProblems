import java.util.HashMap;
        import java.util.LinkedHashMap;
        import java.util.Scanner;
        import java.util.TreeMap;

public class _20_Nuts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        TreeMap<String,LinkedHashMap<String, Integer>> companyMap = new TreeMap<>();

        for (int i = 0; i < n ; i++) {
            String [] input = scanner.nextLine().split(" ");
            String company = input[0];
            String nuts = input[1];
            String kg = input[2];
            Integer amount = Integer.parseInt(kg.substring(0,kg.length()-2));

            if(!companyMap.containsKey(company)){
                companyMap.put(company, new LinkedHashMap<>());
            }
            int curNuts =0;
            if(companyMap.get(company).containsKey(nuts)){
                curNuts = companyMap.get(company).get(nuts);
            }
            companyMap.get(company).put(nuts,curNuts+amount);
        }
        for (String companyKey : companyMap.keySet()) {
            System.out.print(companyKey + ": ");
            boolean first = true;
            for (HashMap.Entry<String, Integer> pair : companyMap.get(companyKey).entrySet()) {
                if (!first){
                    System.out.print(", ");
                }
                first = false;
                String nutKey = pair.getKey();
                int nutAmount = pair.getValue();
                System.out.print(nutKey+"-"+nutAmount+"kg");
            }
            System.out.println();
        }

    }
}
