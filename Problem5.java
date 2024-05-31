import java.util.*;

public class Problem5 {
    private static boolean isBipartite(List<Integer>[] adjList, int n) {
        int[] colors = new int[n];
        Arrays.fill(colors, -1);

     
        for (int i = 0; i < n; i++) {
            if (colors[i] == -1) {
                if (!dfs(adjList, colors, i, 0)) {
                    return false; 
                }
            }
        }

        return true; 
    }

    private static boolean dfs(List<Integer>[] adjList, int[] colors, int vertex, int color) {
        colors[vertex] = color; 

     
        for (int neighbor : adjList[vertex]) {
            if (colors[neighbor] == -1) {
                
                if (!dfs(adjList, colors, neighbor, 1 - color)) {
                    return false;
                }
            } else if (colors[neighbor] == color) {
              
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Enter the number of vertices: ");
        int n = scanner.nextInt();
        System.out.print("Enter the number of edges: ");
        int m = scanner.nextInt();

        
        List<Integer>[] adjList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }

    
        System.out.println("Enter the edges (format: source destination):");
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            adjList[u].add(v);
            adjList[v].add(u); 
        }

        scanner.close();

      
        boolean bipartite = isBipartite(adjList, n);

        if (bipartite) {
            System.out.println("The graph is bipartite.");
        } else {
            System.out.println("The graph is not bipartite.");
        }
    }
}
