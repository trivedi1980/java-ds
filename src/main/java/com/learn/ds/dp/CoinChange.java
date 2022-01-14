package com.learn.ds.dp;

import java.util.ArrayList;
import java.util.List;

public class CoinChange {
    public static int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;

        List<Integer> list =  coinChangeDfs(coins, amount);
        return list == null ? -1: list.size();
    }

    private static List<Integer> coinChangeDfs(int[] coins, int amount) {
        if (amount == 0) return new ArrayList<>();
        if (amount < 0) return null;

        List<Integer> bestList = null;
        for (int i = 0; i < coins.length; i++) {
            List<Integer> list = coinChangeDfs(coins, amount - coins[i]);
            if (list != null) {
                List<Integer> coinList = new ArrayList<>(list);
                coinList.add(coins[i]);
                bestList = bestList != null && bestList.size() < coinList.size() ? bestList : coinList;
            }
        }
        return bestList;
    }

    public static void main(String[] args) {
        // [1,2,5]
        System.out.println(coinChange(new int[] {1, 2, 5}, 11));
    }
}
