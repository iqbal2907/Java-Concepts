package com.concept.seaarchingalgo;

import java.util.Iterator;
import java.util.LinkedList;

public class BreadthFirstSearch
{
    private int V;   // No. of vertices
    private LinkedList<Integer>[] adj; //Adjacency Lists
 
    // Constructor
    BreadthFirstSearch(int v)
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
    
    // prints BFS traversal from a given source s
    void BFSUtil(int s, boolean visited[])
    { 
        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<Integer>();
 
        // Mark the current node as visited and enqueue it
        visited[s]=true;
        queue.add(s);
 
        while (queue.size() != 0)
        {
            // Dequeue a vertex from queue and print it
            s = queue.poll();
            System.out.print(s+" ");
 
            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext())
            {
                int n = i.next();
                if (!visited[n])
                {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }
    
    void BFS(int v)
    {
        // Mark all the vertices as not visited(set as
        // false by default in java)
        boolean visited[] = new boolean[V];
 
        // Call the recursive helper function to print DFS traversal
        BFSUtil(v, visited);
    }
    
    
    /*******************************************/
    /*******************************************/
 
    // Driver method to
    public static void main(String args[])
    {
    	BreadthFirstSearch g = new BreadthFirstSearch(9);
 
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


        System.out.println("\n\nFollowing is Breadth First Traversal "+
                "(starting from vertex 1)");
        g.BFS(1);


        System.out.println("\n\nFollowing is Breadth First Traversal "+
                "(starting from vertex 2)");
        g.BFS(2);

        System.out.println("\n\nFollowing is Breadth First Traversal "+
                "(starting from vertex 8)");
        g.BFS(8);

    }
}