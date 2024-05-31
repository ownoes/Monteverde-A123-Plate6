import java.util.*;

public class Problem8 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

      
        System.out.print("Enter the number of vertices for the first graph: ");
        int n1 = scanner.nextInt();

       
        System.out.println("Enter the adjacency matrix or adjacency list for the first graph:");
        List<Integer>[] graph1 = getInputGraph(scanner, n1);


        System.out.print("Enter the number of vertices for the second graph: ");
        int n2 = scanner.nextInt();

  
        System.out.println("Enter the adjacency matrix or adjacency list for the second graph:");
        List<Integer>[] graph2 = getInputGraph(scanner, n2);

        scanner.close();


        boolean isIsomorphic = checkIsomorphism(graph1, graph2);

        if (isIsomorphic) {
            System.out.println("The graphs are isomorphic.");
        } else {
            System.out.println("The graphs are not isomorphic.");
        }
    }

    private static List<Integer>[] getInputGraph(Scanner scanner, int n) {
        List<Integer>[] graph = new ArrayList[n];
        scanner.nextLine(); 
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().trim().split(" ");
            graph[i] = new ArrayList<>();
            for (String s : input) {
                graph[i].add(Integer.parseInt(s));
            }
        }
        return graph;
    }

    private static boolean checkIsomorphism(List<Integer>[] graph1, List<Integer>[] graph2) {
   
        if (graph1.length != graph2.length) {
            return false;
        }

       
        int[] degrees1 = new int[graph1.length];
        int[] degrees2 = new int[graph2.length];
        for (int i = 0; i < graph1.length; i++) {
            degrees1[i] = graph1[i].size();
            degrees2[i] = graph2[i].size();
        }
        Arrays.sort(degrees1);
        Arrays.sort(degrees2);
        if (!Arrays.equals(degrees1, degrees2)) {
            return false;
        }

        for (int i = 0; i < graph1.length; i++) {
            Collections.sort(graph1[i]);
            Collections.sort(graph2[i]);
        }

     
        Arrays.sort(graph1, Comparator.comparing(Object::hashCode));
        Arrays.sort(graph2, Comparator.comparing(Object::hashCode));
        return Arrays.equals(graph1, graph2);
    }
}
