package AlgorithmsPreparation;

import java.util.*;
import java.util.stream.Collectors;

public class core3 {
    static Map<Integer, List<Integer>> graph = new LinkedHashMap<>();
    static Set<Integer> visited = new HashSet<>();

    static Set<Integer>numbers = new TreeSet<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i <n ; i++) {
            numbers.add(i+1);
        }

        int connections = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i <connections ; i++) {

            int [] command = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();

            int parent = command[0];
            int child = command[1];

            graph.putIfAbsent(parent,new ArrayList<>());
            graph.get(parent).add(child);
        }

        int start = Integer.parseInt(scanner.nextLine());



        dfs(start);

        numbers.removeIf(e -> visited.contains(e));

        numbers.forEach(e -> System.out.print(e + " "));


    }

    private static void dfs(int start) {

       if(visited.contains(start)){
           return;
       }

       visited.add(start);


        List<Integer> integers = graph.get(start);
        if(integers != null){
            for (int i = 0; i <graph.get(start).size() ; i++) {
                int child = graph.get(start).get(i);
                dfs(child);
            }
        }
        graph.remove(start);

    }
}
