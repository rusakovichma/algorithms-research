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
public interface Paths {

    public boolean hasPathTo(int v);

    public Iterable<Integer> pathTo(int v);

}
