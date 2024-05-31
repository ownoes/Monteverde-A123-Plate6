import java.util.*;

public class Problem6 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int n = scanner.nextInt();
        System.out.print("Enter the number of edges: ");
        int m = scanner.nextInt();

        int[][] adjacencyMatrix = new int[n][n];

        System.out.println("Enter the edges (format: source destination):");
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            adjacencyMatrix[u][v] = 1; // Mark edge from u to v
            adjacencyMatrix[v][u] = 1; // Mark edge from v to u
        }

        System.out.println("Adjacency matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
