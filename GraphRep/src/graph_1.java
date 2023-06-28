import java.util.ArrayList;

public class graph_1 {

    public static void main(String[] args) {
        int nodes =3;
        int edges = 3;

        // Method 1 - adj matrix

        int adj[][]=new int[nodes+1][edges+1];

        //edge 1:2
        adj[1][2]=1;
        adj[2][1]=1;

        // method 2 : ArrayList<ArrayList<>>

        /*
        1->2
        1->3
        2->4
        3->4
        2->5
        4->5

         should contain its neighbour
         0->
         1-> {2,3}
         2-> {4.1,5}
         3-> {1,4}
         4->{3,2,5}
         5->{4,2}
         */

        ArrayList<ArrayList<Integer>> adj_1= new ArrayList<>();

        for(int i=0;i<=nodes;i++)
        {
            adj_1.add(new ArrayList<>());
        }

        adj_1.get(1).add(2);
        adj_1.get(2).add(1);

    }

}
