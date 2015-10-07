/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.basic.graph.undirected;

import by.creepid.algorithms.basic.bags.ResizedStack;

/**
 *
 * @author rusakovich
 */
public class DepthPaths implements Paths {

    private boolean[] marked;
    private int[] edgeTo;
    private final int start;

    public DepthPaths(Graph g, int start) {
        this.marked = new boolean[g.vertexCount()];
        this.edgeTo = new int[g.vertexCount()];
        this.start = start;
        crawl(g, start);
    }

    private void crawl(Graph g, int v) {
        this.marked[v] = true;
        for (int w : g.adjacentVertices(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                crawl(g, w);
            }
        }
    }

    @Override
    public boolean hasPathTo(int v) {
        return marked[v];
    }

    @Override
    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }

        ResizedStack<Integer> path = new ResizedStack<>();
        for (int x = v; x != this.start; x = edgeTo[x]) {
            path.push(x);
        }

        path.push(start);
        return path;
    }

}
