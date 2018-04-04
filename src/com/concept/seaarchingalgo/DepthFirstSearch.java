package com.concept.seaarchingalgo;

import java.util.Iterator;
import java.util.LinkedList;

public class DepthFirstSearch
{
    private int V;   // No. of vertices
    private LinkedList<Integer> adj[]; //Adjacency Lists
 
    // Constructor
    DepthFirstSearch(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }
 
    // Function to add an edge into the graph
    void addEdge(int v,int w)
    {
        adj[v].add(w);
    }
 
    /*******************************************/
    /*******************************************/

    // A function used by DFS
    void DFSUtil(int v,boolean visited[])
    {
        // Mark the current node as visited and print it
        visited[v] = true;
        System.out.print(v+" ");
 
        // Recur for all the vertices adjacent to this vertex
        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext())
        {
            int n = i.next();
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }
 
    // The function to do DFS traversal. It uses recursive DFSUtil()
    void DFS(int v)
    {
        // Mark all the vertices as not visited(set as
        // false by default in java)
        boolean visited[] = new boolean[V];
 
        // Call the recursive helper function to print DFS traversal
        DFSUtil(v, visited);
    }
    
    /*******************************************/   
    /*******************************************/
 
    // Driver method to
    public static void main(String args[])
    {
    	DepthFirstSearch g = new DepthFirstSearch(9);
    	
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 1);
        g.addEdge(2, 4);
        g.addEdge(2, 5);
        g.addEdge(3, 1);
        g.addEdge(3, 6);
        g.addEdge(3, 7);
        g.addEdge(4, 2);
        g.addEdge(4, 8);
        g.addEdge(5, 2);
        g.addEdge(5, 8);
        g.addEdge(6, 3);
        g.addEdge(6, 8);
        g.addEdge(7, 3);
        g.addEdge(7, 8);
        g.addEdge(8, 4);
        g.addEdge(8, 5);
        g.addEdge(8, 6);
        g.addEdge(8, 7);

 
/*        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(2, 5);
        g.addEdge(3, 6);
        g.addEdge(3, 7);
        g.addEdge(4, 8);
        g.addEdge(5, 8);
        g.addEdge(6, 8);
        g.addEdge(7, 8);
*/

/*    	g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 5);
        g.addEdge(2, 6);
        g.addEdge(3, 7);
        g.addEdge(4, 7);
        g.addEdge(5, 7);
        g.addEdge(6, 7);
*/        

        System.out.println("\n\nFollowing is Depth First Traversal :"+
                "(starting from vertex 1)");

        g.DFS(1);
        
        System.out.println("\n\nFollowing is Depth First Traversal :"+
                "(starting from vertex 2)");

        g.DFS(2);

        System.out.println("\n\nFollowing is Depth First Traversal :"+
                "(starting from vertex 8)");

        g.DFS(8);


    }
}