import java.util.*;

public class Problem4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Enter the number of vertices: ");
        int n = scanner.nextInt();
        System.out.print("Enter the number of edges: ");
        int m = scanner.nextInt();

      
        int[] degree = new int[n];

   
        System.out.println("Enter the edges (format: vertex1 vertex2):");
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            degree[u]++;
            degree[v]++;
        }

      
        System.out.println("Vertex degrees:");
        for (int i = 0; i < n; i++) {
            System.out.println("Vertex " + i + ": " + degree[i]);
        }

        scanner.close();
    }
}
