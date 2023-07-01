import java.util.*;

class Edge
{
    int source, dest;

    public Edge(int source, int dest)
    {
        this.source = source;
        this.dest = dest;
    }
}

// A class to represent a graph object
class Graph {
    // A list of lists to represent an adjacency list
    List<List<Integer>> adjList = null;

    // Constructor
    Graph(List<Edge> edges, int n) {
        adjList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        // add edges to the undirected graph
        for (Edge edge : edges) {
            int src = edge.source;
            int dest = edge.dest;

            adjList.get(src).add(dest);
            adjList.get(dest).add(src);
        }
    }
}

    class Node_1
    {
        int v, parent;

        Node_1(int v, int parent)
        {
            this.v = v;
            this.parent = parent;
        }
    }

    class CycleInGraph {
        public static void main(String[] args)  {
            List<Edge> edges = Arrays.asList(
                    new Edge(0, 1), new Edge(0, 2), new Edge(0, 3),
                    new Edge(1, 4), new Edge(1, 5), new Edge(4, 8),
                    new Edge(4, 9), new Edge(3, 6), new Edge(3, 7),
                    new Edge(6, 10), new Edge(6, 11), new Edge(5, 9)
            );

            Graph graph = new Graph(edges,12);
            CycleInGraph obj = new CycleInGraph();

            if (obj.BFS(graph, 0, 12)) {
                System.out.println("The graph contains a cycle");
            }
            else {
                System.out.println("The graph doesn't contain any cycle");
            }

            boolean[] discovered = new boolean[12];

            if (obj.DFS(graph, 0, 12,discovered,-1)) {
                System.out.println("The graph contains a cycle");
            }
            else {
                System.out.println("The graph doesn't contain any cycle");
            }


        }

        private boolean DFS(Graph graph, int src, int n, boolean[] visited, int parent) {
            visited[src]=true;

            for(Integer it: graph.adjList.get(src))
            {
                if(!visited[it])
                {
                    if(DFS(graph,it,n,visited,src))
                    {
                        return true;
                    }
                }
                else {
                    if(it!=parent)return true;
                }
            }
            return false;
        }



        private boolean BFS(Graph graph, int src, int n) {
            Queue<Node_1> bfs = new LinkedList<>();
            boolean[]visited = new boolean[n];

            bfs.add(new Node_1(src,-1));
            visited[src]=true;

            while (!bfs.isEmpty())
            {
                Node_1 extract = bfs.poll();
                int node = extract.v;
                int parent = extract.parent;

                for(int i: graph.adjList.get(node))
                {
                    if(!visited[i])
                    {
                        visited[i]=true;
                        bfs.add(new Node_1(i,node));
                    }
                    else
                    {
                        if(i!=parent)return true;
                    }
                }

            }
            return false;
        }
    }


