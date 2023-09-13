package AlgorithmsPreparation;

import java.util.Arrays;
import java.util.Scanner;

public class core3Matrix {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int connections = Integer.parseInt(scanner.nextLine());

        int [][] graph = new int[n + 1][connections + 1];

        for (int i = 1; i <= connections ; i++) {
            int [] edges = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

            int from = edges[0];
            int to = edges[1];

            graph[from][to] = 1;
        }

        int start = Integer.parseInt(scanner.nextLine());

        boolean [] visited = new boolean[n + 1];

        dfs(visited,start,graph);

        for (int i = 1; i <visited.length ; i++) {
            if(!visited[i]){
                System.out.print(i + " ");
            }
        }

    }

    private static void dfs(boolean[] visited, int start, int[][] graph) {
        if(visited[start]){
            return;
        }

        visited[start] = true;
        for (int i = 1; i < graph[start].length ; i++) {
            if(graph[start][i] == 1) {
                int child = i;
                dfs(visited,child,graph);
            }
        }

    }
}
