import java.util.*;

public class Problem1 {
    
    public static boolean isConnected(List<Integer>[] adjList, int n) {
        boolean[] visited = new boolean[n];
        dfs(0, adjList, visited);
        for (boolean v : visited) {
            if (!v) return false;
        }
        return true;
    }
    
    public static int findConnectedComponents(List<Integer>[] adjList, int n) {
        boolean[] visited = new boolean[n];
        int components = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, adjList, visited);
                components++;
            }
        }
        return components;
    }
    
    public static void dfs(int node, List<Integer>[] adjList, boolean[] visited) {
        visited[node] = true;
        for (int neighbor : adjList[node]) {
            if (!visited[neighbor]) {
                dfs(neighbor, adjList, visited);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of vertices: ");
        int n = scanner.nextInt();
        System.out.println("Enter the number of edges: ");
        int m = scanner.nextInt();
        List<Integer>[] adjList = new ArrayList[n];
        for (int i = 0; i < n; i++) adjList[i] = new ArrayList<>();
        System.out.println("Enter the edges:");
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            adjList[u].add(v);
            adjList[v].add(u);
        }
        scanner.close();
        if (isConnected(adjList, n)) {
            System.out.println("The graph is connected");
        } else {
            System.out.println("The graph is not connected");
            System.out.println("Number of connected components: " + findConnectedComponents(adjList, n));
        }
    }
}
