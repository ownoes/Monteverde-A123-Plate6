import java.util.Scanner;

public class Problem2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of vertices in the graph: ");
        int numVertices = input.nextInt();

        int[][] graphMatrix = new int[numVertices][numVertices];
        System.out.println("Input the adjacency matrix for the graph:");
        for (int row = 0; row < numVertices; row++) {
            for (int col = 0; col < numVertices; col++) {
                graphMatrix[row][col] = input.nextInt();
            }
        }

        System.out.println("List of edges and their counts:");
        for (int row = 0; row < numVertices; row++) {
            for (int col = row + 1; col < numVertices; col++) {
                if (graphMatrix[row][col] > 0) {
                    System.out.println("Edge (" + row + ", " + col + "): " + graphMatrix[row][col]);
                }
            }
        }

        input.close();
    }
}
