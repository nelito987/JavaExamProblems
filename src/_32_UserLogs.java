import java.util.*;

public class _32_UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<String,LinkedHashMap<String,Integer>> usersLog = new TreeMap<>();

        while(!scanner.hasNext("end")){
            String input [] = scanner.nextLine().split(" ");
            String [] ipElements = input[0].split("=");
            String ip = ipElements[1];

            String [] userElements = input[2].split("=");
            String user = userElements[1];

            if(!usersLog.containsKey(user)){
                usersLog.put(user, new LinkedHashMap<>());
                usersLog.get(user).put(ip, 1);
            }else{
                Integer count =0;
                if(usersLog.get(user).containsKey(ip)){
                    count = usersLog.get(user).get(ip);
                }
                usersLog.get(user).put(ip, count+1);
            }

        }
        for (String entry : usersLog.keySet()) {
            System.out.printf("%s: \n", entry);

            boolean first = true;
            for (Map.Entry<String, Integer> ip : usersLog.get(entry).entrySet()) {
                if(first){
                    System.out.printf("%s => %d", ip.getKey(), ip.getValue());
                    first = false;
                }else{
                    System.out.printf(", %s => %d", ip.getKey(), ip.getValue());
                }
            }
            System.out.printf(".\n");
        }
    }
}
