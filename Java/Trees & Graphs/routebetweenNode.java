import java.util.*;

public class routebetweenNode {
    public static boolean dfs(int graph[][], boolean visited[], int s, int d, int n) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < graph.length; i++) {
            adj.get(graph[i][0]).add(graph[i][1]);
            adj.get(graph[i][1]).add(graph[i][0]);
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i : adj.get(s)) {
            if(i == d) {
                return true;
            }
            q.add(i);
        }
        visited[s] = true;
        while(!q.isEmpty()) {
            int temp = q.poll();
            if(temp == d) {
                return true;
            }
            visited[temp] = true;
            for(int i : adj.get(temp)) {
                if(!visited[i]) {
                    q.add(i);
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of nodes");
        int n = sc.nextInt();
        System.out.println("Enter the number of edges");
        int m = sc.nextInt();
        int graph[][] = new int[m][2];
        System.out.println("Enter the edges");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 2; j++) {
                graph[i][j] = sc.nextInt();
            }
        }
        boolean visited[] = new boolean[n + 1];
        System.out.println("Enter the source node");
        int s = sc.nextInt();
        System.out.println("Enter the destination node");
        int d = sc.nextInt();
        System.out.println(dfs(graph, visited, s, d, n));
    }
}
