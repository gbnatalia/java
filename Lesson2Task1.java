package lesson2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Lesson2Task1 {
    public static void main(String[] args) {

        int n, k;
        Solution sol = new Solution();
        List<List<Integer>> lists;

        n = 4; k = 2;
        lists = sol.combine(n, k);
        printList(lists);

        n = 1; k = 1;
        lists = sol.combine(n, k);
        printList(lists);

        n = 3; k = 3;
        lists = sol.combine(n, k);
        printList(lists);

        n = 2; k = 1;
        lists = sol.combine(n, k);
        printList(lists);
    }

    private static void printList(List<List<Integer>> lists) {
        System.out.print("[");
        for (var el : lists) {
            System.out.print(el);
            if (el != lists.get(lists.size() - 1))
                System.out.print(",");
        }
        System.out.println("]");
    }

}

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> lists = new ArrayList<>();
        dfs(lists, new ArrayList<Integer>(), n, k, 1);
        return lists;
    }
    private void dfs(List<List<Integer>> lists, List<Integer> list, int n, int k, int start) {
        if (list.size() == k) {
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <= n; i++) {
            list.add(i);
            dfs(lists, list, n, k, i + 1);
            list.remove(list.size() - 1);
        }
    }
}