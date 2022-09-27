package my_java;

import java.lang.reflect.Array;
import java.util.Arrays;

public class lesson1Solution2 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //for (int i = 0; i < n; i++){
        //    nums1[m+i] = nums2[i];
        //}
        //Arrays.sort(nums1);

        //int i = m - 1;
        //int j = n - 1;
        //int k = m + n - 1;

        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
        for (int i = m - 1, j = n - 1, k = m + n - 1; k >= 0; k--){
            if ((i >= 0) && (j >= 0)) {
                if (nums1[i] > nums2[j])
                    nums1[k] = nums1[i--];
                else
                    nums1[k] = nums2[j--];
            }
            else {
                if (j >= 0)
                    nums1[k] = nums2[j--];
            }
        }

        System.out.println(Arrays.toString(nums1));
    }
}
