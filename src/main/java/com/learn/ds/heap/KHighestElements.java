package com.learn.ds.heap;

import java.util.*;

public class KHighestElements {
    private static class Element {
        int row;
        int col;
        int price;
        int distance;

        public Element(int r, int c, int p, int d) {
            this.row = r;
            this.col = c;
            this.price = p;
            this.distance = d;
        }
    }

    public List<List<Integer>> highestRankedKItems(int[][] grid, int[] pricing, int[] start, int k) {
        PriorityQueue<Element> pqueue = new PriorityQueue<>((a, b) -> {
            if (a.distance == b.distance) {
                if (a.price == b.price) {
                    if (a.row == b.row) {
                        return a.col - b.col;
                    }
                    return a.row - b.row;
                }
                return a.price - b.price;
            }
            return a.distance - b.distance;
        });

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        int d = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] each = queue.poll();
                if (each[0] < 0 || each[0] >= grid.length) continue;
                if (each[1] < 0 || each[1] >= grid[0].length) continue;
                if (visited[each[0]][each[1]]) continue;

                int value = grid[each[0]][each[1]];
                if (value == 0) continue;

                visited[each[0]][each[1]] = true;
                if (value >= pricing[0] && value <= pricing[1]) {
                    pqueue.offer(new Element(each[0], each[1], value, d));
                }

                queue.offer(new int[] { each[0], each[1] + 1});
                queue.offer(new int[] { each[0], each[1] - 1});
                queue.offer(new int[] { each[0] + 1, each[1]});
                queue.offer(new int[] { each[0] - 1, each[1]});
            }
            d++;
        }


        List<List<Integer>> result = new ArrayList<>();
        int length = Math.min(k, pqueue.size());

        for (int i = 0; i < length; i++) {
            Element each = pqueue.poll();
            List<Integer> list = new ArrayList<>();
            list.add(each.row);
            list.add(each.col);
            result.add(list);
        }
        return result;
    }

    public static void main(String[] args) {
        // [[1,2,0,1],[1,3,0,1],[0,2,5,1]]
        // [2,5]
        // [0,0]
        // 3

        // [[1,1,1],[0,0,1],[2,3,4]]
        // [2,3]
        // [0,0]
        // 3
        KHighestElements instance = new KHighestElements();
        instance.highestRankedKItems(new int[][] {
                {1,2,0,1},
                {1,3,0,1},
                {0,2,5,1}
        }, new int[] {2, 5}, new int[] {0, 0}, 3);
    }
}
