package com.learn.ds.graph;

import java.util.*;

class AccountMerge {
    int[] root = null;
    int[] size = null;

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        root = new int[accounts.size()];
        size = new int[accounts.size()];

        for (int i = 0; i < accounts.size(); i++) {
            root[i] = i; // making the each accounts root as itself
            size[i] = 1;
        }

        Map<String, Integer> emailAccountMap = new HashMap<>();

        for (int i = 0; i < accounts.size(); i++) {
            List<String> account = accounts.get(i);

            for (int j = 1; j < account.size(); j++) {
                String email = account.get(j);
                if (!emailAccountMap.containsKey(email)) {
                    emailAccountMap.put(email, i);
                } else {
                    union(i, emailAccountMap.get(email));
                }
            }
        }

        Map<Integer, List<String>> groupedAccounts = new HashMap<>();
        for (String email : emailAccountMap.keySet()) {
            int accId = emailAccountMap.get(email);
            int rootId = findRoot(accId);
            if (!groupedAccounts.containsKey(rootId)) {
                groupedAccounts.put(rootId, new ArrayList<>());
            }
            groupedAccounts.get(rootId).add(email);
        }

        List<List<String>> results = new ArrayList<>();
        for (int accountId : groupedAccounts.keySet()) {
            List<String> account = new ArrayList<>();
            account.add(accounts.get(accountId).get(0));
            Collections.sort(groupedAccounts.get(accountId));
            account.addAll(groupedAccounts.get(accountId));
            results.add(account);
        }
        return results;
    }

    private void union(int one, int two) {
        int root1 = findRoot(one);
        int root2 = findRoot(two);
        if (root1 == root2) return;

        if (size[root1] >= size[root2]) {
            root[root2] = root1;
            size[root1] = size[root1] + 1;
        } else {
            root[root1] = root2;
            size[root2] = size[root2] + 1;
        }
    }

    private int findRoot(int item) {
        while (root[item] != item) {
            item = root[item];
        }
        return item;
    }
}
