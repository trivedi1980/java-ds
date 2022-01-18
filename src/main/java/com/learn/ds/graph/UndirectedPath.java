package com.learn.ds.graph;

import java.util.*;

public class UndirectedPath {
    private static boolean undirectedPath (char[][] edges, char source, char dest) {
        Map<Character, List<Character>> adj = new HashMap<>();
        for (char[] edge : edges) {
            if (!adj.containsKey(edge[0])) {
                adj.put(edge[0], new ArrayList<>());
            }

            if (!adj.containsKey(edge[1])) {
                adj.put(edge[1], new ArrayList<>());
            }

            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        Set<Character> visited = new HashSet<>();
        return canReach(source, dest, adj, visited);
    }

    private static boolean canReach(char source,
                                    char dest,
                                    Map<Character, List<Character>> adj,
                                    Set<Character> visited) {
        if (source == dest) return true;
        if (visited.contains(source)) return false;

        visited.add(source);
        for (char ch : adj.get(source)) {
            if (canReach(ch, dest, adj, visited)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(undirectedPath(new char[][] {
                { 'i', 'j'},
                { 'k', 'i'},
                { 'm', 'k'},
                { 'k', 'l'},
                { 'o', 'n'}
        }, 'i', 'o'));

        System.out.println(undirectedPath(new char[][] {
                { 'i', 'j'},
                { 'k', 'i'},
                { 'm', 'k'},
                { 'k', 'l'},
                { 'o', 'n'}
        }, 'i', 'm'));

        System.out.println(undirectedPath(new char[][] {
                { 'i', 'j'},
                { 'k', 'i'},
                { 'm', 'k'},
                { 'k', 'l'},
                { 'o', 'n'}
        }, 'i', 'l'));

        System.out.println(undirectedPath(new char[][] {
                { 'i', 'j'},
                { 'k', 'i'},
                { 'm', 'k'},
                { 'k', 'l'},
                { 'o', 'n'}
        }, 'k', 'i'));
    }
}
