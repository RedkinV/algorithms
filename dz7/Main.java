package ru.geekbrains.algorithms.lesson7;

public class Main {

    public static void main(String[] args) {
        Graph g=new Graph(13);

        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(0,5);
        g.addEdge(0,6);
        g.addEdge(6,4);
        g.addEdge(4,3);
        g.addEdge(4,5);
        g.addEdge(3,5);
        g.addEdge(7,8);
        g.addEdge(9,10);
        g.addEdge(9,11);
        g.addEdge(9,12);
        g.addEdge(11,12);

//        System.out.println(g.vertexCount());
//        System.out.println(g.edgeCount());
//        System.out.println(g.adjList(0));

//        DepthFirstSearch dfs=new DepthFirstSearch(g,0);
//        System.out.println(dfs.hasPathTo(5));
//        System.out.println(dfs.hasPathTo(11));
//        System.out.println(dfs.pathTo(5));


        BreadthFirstSearch bfs=new BreadthFirstSearch(g,0);
        System.out.println(bfs.hasPathTo(5));
        System.out.println(bfs.hasPathTo(11));
        System.out.println(bfs.pathTo(4));
        System.out.println(bfs.distTo(4));

    }
}
