package AlgorithmsPreparation;

import java.util.*;

public class try2 {

    static Map<Integer, List<Integer>> graph = new LinkedHashMap<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n - 1 ; i++) {
            int [] num = Arrays.stream(scanner.nextLine().split("\\s+"))
                            .mapToInt(Integer::parseInt).toArray();

            graph.putIfAbsent(i,new ArrayList<>());

            for (int j = 0; j <num.length ; j++) {
                graph.get(i).add(num[j]);
            }

        }

        graph.put(n - 1,new ArrayList<>());

        Set<Integer> used = new HashSet<>();

        for (int i = 0; i < n - 1 ; i++) {
            dfs(i,used,n);
            used.clear();
        }


    }

    private static void dfs(int node, Set<Integer> used, int n) {

        used.add(node);

        for (int i = 0; i < graph.get(node).size() ; i++) {
            int child = graph.get(node).get(i);
            if(!used.contains(child)) {
                dfs(child, used, n);
                used.remove(child);
            }
        }

        if(node == n - 1){
            used.forEach(e -> System.out.print(e + " "));
            System.out.println();
        }
    }
}
