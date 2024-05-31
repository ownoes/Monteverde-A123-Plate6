import java.util.*;

public class Problem7 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int n = scanner.nextInt();
        System.out.print("Enter the number of edges: ");
        int m = scanner.nextInt();

        int[][] incidenceMatrix = new int[n][m];

        System.out.println("Enter the edges (format: source destination):");
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            incidenceMatrix[u][i] = 1; 
            incidenceMatrix[v][i] = 1; 
        }

        System.out.println("Incidence matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(incidenceMatrix[i][j] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
