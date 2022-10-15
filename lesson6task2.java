package lesson6;

import java.util.*;
import java.util.stream.Collectors;

public class lesson6task2 {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,1,2,3};
        int[] nums2 = new int[]{2,4,6};
        List<List<Integer>> result = findDifference(nums1, nums2);
        printList(result);
    }

    public static void printList(List<List<Integer>> lists) {
        System.out.print("[");
        for (var el : lists) {
            System.out.print(el);
            if (el != lists.get(lists.size() - 1))
                System.out.print(",");
        }
        System.out.println("]");

        //lists.forEach(s -> System.out.print(s + " "));
    }

    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<Integer>();
        for (int i = 0; i < nums1.length; i++){
            set1.add(nums1[i]);
        }
        Set<Integer> set2 = new HashSet<Integer>();
        for (int i = 0; i < nums2.length; i++){
            set2.add(nums2[i]);
        }

        Set<Integer> intersection = new HashSet<Integer>(set1);
        intersection.retainAll(set2);
        set1.removeAll(intersection);
        set2.removeAll(intersection);

        return Arrays.asList(new ArrayList<>(set1), new ArrayList<>(set2));
    }

    public static List<List<Integer>> findDifference2(int[] nums1, int[] nums2) {
        Set<Integer> set1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> set2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
        Arrays.stream(nums1).forEach(set2::remove);
        Arrays.stream(nums2).forEach(set1::remove);
        return Arrays.asList(new ArrayList<>(set1), new ArrayList<>(set2));
    }

}
