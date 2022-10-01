package lesson2;

import java.util.Arrays;

public class Lesson2Task2 {

    public static void main(String[] args) {

        int[] nums = new int[] {5, 2, 3, 1};
        mergeSort(nums, nums.length);
        printArray(nums);

        int[] nums2 = new int[] {5, 1, 1, 2, 0, 0};
        mergeSort(nums2, nums2.length);
        printArray(nums2);
    }

    public static void printArray(int[] nums){
        for (var el: nums) {
            System.out.print(el);
            System.out.print(" ");
        }
        System.out.println("");
    }
    public static void mergeSort(int[] a, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] l = Arrays.copyOf(a, mid);
        int[] r = Arrays.copyOfRange(a, mid,n);
        mergeSort(l, mid);
        mergeSort(r, n - mid);

        merge(a, l, r, mid, n - mid);
    }
    public static void merge(int[] a, int[] l, int[] r, int left, int right) {
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            }
            else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }
}