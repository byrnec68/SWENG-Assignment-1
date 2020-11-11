public class DAG {
    private int V;// # of vertices in graph
    private int E;// # of edges in graph
    private int[][] adj; // adjacency list for vertex v - changed to 2D array
    private int[] visit; // vertices that have been visited
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
            visit = new int[V];
            adj = new int[V][V];
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    adj[i][j] = 0;
                }
            }
        }
    }
    //return number of Es
	public int Es()
	{
		return E;
	}
	
	//return number of vertices
	public int vertices() {
		return V;
	}
	
	public void validate(int v)	// see if V that is attempting to be inserted is not within scope of graph.
	{
		if(v < 0 || v>= V)
		{
			throw new IllegalArgumentException("not a valid V");
			
		}
	}

	//adds a directed E to graph x to y.
	public void addEdges(int x, int y)
	{
		validate(x);
		validate(y);
		adj[x][y] = 1;
		indegree[y]++;
		outdegree[x]++;
		E++;
	}
	//removes E x to y from graph
	public void removeEdges(int x, int y)
	{
		validate(x);
		validate(y);
		if(adj[x][y] == 1) //if an E already exists
		{
		adj[x][y] = 0;
		indegree[y]--;
		outdegree[x]--;
		E--;
		}
		else
			return;
	}
	//returns the indegree of V x(number of Es incoming to a V)
	public int indegree(int x)
	{
		validate(x);
		return indegree[x];
	
	}
	//returns the outdegree of a V(number of outgoing Es of a V).
	public int outdegree(int x)
	{
		validate(x);
		return outdegree[x];
	
	}
	//returns whether a cycle occurs in a directed graph, graph must be acyclic to find LCA
	public boolean cycleOccur()
	{
		boolean cycle = false;
		int count = 0;
		for(int i = 0; i < V; i++)
		{
			visit[count] = i;
			for(int j = 0; j < V; j++)
			{
				for(int k = 0; k < V; k++)
				{
					if(visit[k] == j && adj[i][j] == 1) //if visit[k] is equal to the V j and i and j have an E between them 
					{
						cycle = true; // there is a cycle
						return cycle;
					}
				}
			}
			count++; 
		}
		return cycle;
	}
	//finds the LCA of vertices x and y
	public int LCA(int x, int y)
	{
		validate(x);
		validate(y);
		boolean cycle;
		cycle = cycleOccur();
		if(E > 0 && cycle == false) //if there are no edges or there is a cycle, it cannot be a directed acyclic graph
			return LCAHelp(x, y);
		else
		{
			return -1;  //not an acyclic graph so cant find LCA
		}
	}
	
	private int LCAHelp(int x, int y)
	{
		int[] xPath = new int[E]; //create a first path
		int[] yPath = new int[E]; //create a second path
		
		boolean[] xVisited = new boolean[V]; //an array of booleans which stores which vertices have been visited
		boolean[] yVisited = new boolean[V]; //an array of booleans which stores which vertices have been visited
		int countX = 0;
		int countY = 0;
		xPath[countX] = x;
		yPath[countY] = y;
		for(int i = 0; i < V; i++)
		{
			xVisited[i] = false;		//setting every V to not visited at the start of the search
			yVisited[i] = false;		//setting every V to not visited at the start of the search
		}
		for(int j = 0; j < V; j++)
		{
			xVisited[x] = true;
			yVisited[y] = true;
			for(int k = 0; k<V; k++)
			{
				if(adj[j][k] == 1 && xVisited[j])
				{
					countX++;
					xPath[countX] = k;		// this becomes the current LCA
					xVisited[k] = true;
				}
				if(adj[j][k] == 1 && yVisited[j])
				{
					countY++;
					yPath[countY] = k;		//becomes the current LCA
					yVisited[k] = true;
				}
				if(yPath[countY] == xPath[countX]) //if both of these are equal then we have found the LCA of x and y 
				{
					return yPath[countY];
				}
			}
		}
		return -1; // no ancestor found so return -1.
				
	}
	
	

}

    