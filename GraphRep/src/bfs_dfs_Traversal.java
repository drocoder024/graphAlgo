import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class bfs_dfs_Traversal {
    /*
    Time Complexity : o(N)+ o(2E)
    Space Complexity : O(N)
     */
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<=2;i++)
        {
            adjList.add(new ArrayList<>());
        }

        adjList.get(0).add(1);
        adjList.get(0).add(2);

        adjList.get(1).add(0);
        adjList.get(1).add(2);

        adjList.get(2).add(0);
        adjList.get(2).add(1);

        ArrayList<Integer> bfsList = bfsOfGraph(3,adjList);
        ArrayList<Integer> dfsList = new ArrayList<>();
        boolean[] visited = new boolean[3];
        dfs(0,adjList,dfsList,visited);

       bfsList.forEach(System.out::println);
       dfsList.forEach(System.out::println);


    }

    private static void dfs(int index, ArrayList<ArrayList<Integer>> adjList, ArrayList<Integer> dfsList, boolean[] visited) {

        visited[index]=true;
        dfsList.add(index);

        for(int neighbour: adjList.get(index))
        {
            if(!visited[neighbour])
            {
                dfs(neighbour,adjList,dfsList,visited);
            }
        }
    }

    private static ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adjList) {
        Queue<Integer> bfs = new LinkedList<>();
        ArrayList<Integer> bfsList = new ArrayList<>();

        boolean[] vis = new boolean[V];
        bfs.add(0);
        vis[0]=true;

        while(!bfs.isEmpty())
        {
            Integer extract = bfs.poll();
            bfsList.add(extract);

            for(Integer neighbour : adjList.get(extract))
            {
                if(!vis[neighbour])
                {
                    vis[neighbour]=true;
                    bfs.add(neighbour);
                }
            }
        }
        return  bfsList;
    }
}
