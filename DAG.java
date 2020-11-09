public class DAG {
    private int V;// # of vertices in graph
    private int E;// # of edges in graph
    private int[][] adj; // adjacency list for vertex v - changed to 2D array
    private int[] visited; // vertices that have been visited
    private int[] outdegree;// outdegree of vertex v
    private int[] indegree; // indegree of vertex v
    

    // constructor to initialize and empty graph with size V
    public DAG(int V) {
        if (V < 0) {
            throw new IllegalArgumentException("Number of vertices in the DAG must be greater than 0.");
        } else {
            this.V = V;
            this.E = 0;
            indegree = new int[V];
            outdegree = new int[V];
            visited = new int[V];
            adj = new int[V][V];
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    adj[i][j] = 0;
                }
            }
        }
    }

}

    