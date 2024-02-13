import java.util.*;

public class GraphDepthFirstSearch {

    private static void dfs(int vertex, ArrayList<ArrayList<Integer>> graph, boolean[] visited, List<Integer> component) {
        visited[vertex] = true; // Mark the vertex as visited
        component.add(vertex + 1); // Add the vertex to the connectivity component (+1 to adjust the index)

        for (int nextVertex : graph.get(vertex)) { // Iterate over all next vertices
            if (!visited[nextVertex]) { // If the next vertex is not visited
                dfs(nextVertex, graph, visited, component); // Recursively visit it
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(); // Number of vertices
        int M = scanner.nextInt(); // Number of edges

        // Graph initializing, we represent graph as ArrayList<ArrayList<Integer>>
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>()); // Add a new list for each vertex
        }
        // We have an empty graph

        // Reading the edges
        for (int i = 0; i < M; i++) {
            int v1 = scanner.nextInt() - 1; // Adjusting the index (since input is 1-based but we need 0-based numbers for array)
            int v2 = scanner.nextInt() - 1; // Adjusting the index
            graph.get(v1).add(v2); // Add v2 to the adjacency list of v1
            graph.get(v2).add(v1); // Add v1 to the adjacency list of v2, because the graph is undirected
        }

        boolean[] visited = new boolean[N]; // Array to mark visited vertices
        List<Integer> connectivityComponent = new ArrayList<>(); // List to store vertices of the connectivity connectivityComponent

        // Launching DFS from the first vertex
        dfs(0, graph, visited, connectivityComponent);

        // Sorting the connectivity connectivityComponent by the vertices' numbers
        Collections.sort(connectivityComponent);

        // Outputting the results
        System.out.println(connectivityComponent.size()); // Number of vertices in the connectivity connectivityComponent
        for (int vertex : connectivityComponent) {
            System.out.print(vertex + 1 + " "); // Printing vertices of the connectivityComponent, adjusting the index back to 1-based for output
        }
    }
}
