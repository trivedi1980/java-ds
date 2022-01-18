package com.learn.ds.graph;

import java.util.*;

public class ShortestPath {
    public static void main(String[] args) {
        System.out.println(shortestPath(new char[][] {
                {'w', 'x'}, {'x', 'y'}, {'z', 'y'}, {'z', 'v'}, {'w', 'v'}
        }, 'w', 'z'));
    }

    private static int shortestPath(char[][] edges, char src, char dest) {
        Map<Character, List<Character>> adj = new HashMap<>();
        for (char[] edge : edges) {
            if (!adj.containsKey(edge[0])) adj.put(edge[0], new ArrayList<>());
            if (!adj.containsKey(edge[1])) adj.put(edge[1], new ArrayList<>());

            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        Queue<Vertex> queue = new LinkedList<>();
        queue.offer(new Vertex(src, 0));
        Set<Character> visited = new HashSet<>();

        while (!queue.isEmpty()) {
            Vertex current = queue.poll();
            if (current.ch == dest) {
                return current.distance;
            }
            if (!visited.contains(current.ch)) {
                visited.add(current.ch);
                for (char neighbor : adj.get(current.ch)) {
                    queue.offer(new Vertex(neighbor, current.distance + 1));
                }
            }
        }
        return -1;
    }
}

class Vertex {
    char ch;
    int distance;

    Vertex(char ch, int d) {
        this.ch = ch;
        this.distance = d;
    }
}
