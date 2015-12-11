import java.util.*;

public class _04_ActivityTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        TreeMap<Integer,TreeMap<String,Integer>> tracker = new TreeMap<>();

        for (int i = 0; i < n ; i++) {
            String [] input = scanner.nextLine().split(" ");
            String date = input[0];
            int month = Integer.parseInt(date.substring(3,5));
            String name = input[1];
            int distance = Integer.parseInt(input[2]);

            if(!tracker.containsKey(month)){
                tracker.put(month, new TreeMap<>());
            }

            TreeMap<String,Integer> runnerInfo = tracker.get(month);
            int curDistance = 0;
            if (runnerInfo.containsKey(name)){
                curDistance = runnerInfo.get(name);
            }
            runnerInfo.put(name,curDistance+distance);
        }

        for (Integer month : tracker.keySet()) {
            System.out.print(month + ": ");

            TreeMap users = (TreeMap) tracker.get(month);
            String outputLine =  new String();
            for (Iterator it = users.entrySet().iterator(); it.hasNext();){
                Map.Entry user = (Map.Entry) it.next();
                outputLine += user.getKey() + "(" + user.getValue() + "), ";
            }
            outputLine = outputLine.substring(0, outputLine.length() - 2);
            System.out.println(outputLine);
        }
    }
}
