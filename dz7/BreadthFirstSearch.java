package ru.geekbrains.algorithms.lesson7;

import java.util.LinkedList;

public class BreadthFirstSearch {
    private boolean[] marked;
    private int[] edgeTo;
    private int[] distTo;
    private int source;
    private static final int INF=Integer.MAX_VALUE;

    public BreadthFirstSearch(Graph g, int source){
        marked=new boolean[g.vertexCount()];
        edgeTo=new int[g.vertexCount()];
        distTo=new int[g.vertexCount()];
        this.source=source;
        for (int i = 0; i < g.vertexCount(); i++) {
            distTo[i]=INF;
        }

        bfs(g,source);
    }

    private void bfs(Graph g, int source){
        LinkedList<Integer> queue=new LinkedList<>();
        queue.addLast(source);
        marked[source]=true;
        distTo[source]=0;
        while (!queue.isEmpty()){
            int vertex=queue.removeFirst();
            for (int w:
                 g.adjList(vertex)) {
                if(!marked[w]) {
                    marked[w]=true;
                    edgeTo[w]=vertex;
                    distTo[w]=distTo[vertex]+1;
                    queue.addLast(w);
                }
            }
        }

    }
    public boolean hasPathTo(int dist){
        return marked[dist];

    }
    public LinkedList<Integer> pathTo(int dist){
        if(!hasPathTo(dist)) return null;

        LinkedList<Integer> stack = new LinkedList<>();

        int vertex=dist;
        while(vertex!=source){
            stack.push(vertex);
            vertex=edgeTo[vertex];
        }
        return stack;
    }
    public int distTo(int v){
        return distTo[v];
    }
}
