/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.basic.graph.undirected;

/**
 *
 * @author rusakovich
 */
public class DepthSearch implements Search {

    private boolean[] marked;
    private int count;

    public DepthSearch(Graph g, int start) {
        marked = new boolean[g.vertexCount()];
        crawl(g, start);
    }

    private void crawl(Graph g, int start) {
        this.marked[start] = true;
        count++;

        for (int w : g.adjacentVertices(start)) {
            if (!marked[w]) {
                crawl(g, w);
            }
        }
    }

    @Override
    public boolean marked(int v) {
        return marked[v];
    }

    @Override
    public int count() {
        return count;
    }

}
