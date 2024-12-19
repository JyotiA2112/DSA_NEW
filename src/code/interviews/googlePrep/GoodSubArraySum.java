package code.interviews.googlePrep;

import java.util.HashMap;
import java.util.Map;

/**

 An array is good if all subarrays have atleast 1 element in them whose frequency is 1.
 For Example :

 Good : 1,2,1
 Good: 1,2,5,2,4,3,4
 Bad: 1,2,3,1,2,3

 */
public class GoodSubArraySum {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,1,2,3};
        System.out.println(helper(arr, 0, arr.length - 1));
    }


        private static boolean helper(int[] arr, int start, int end) {

            if(start < 0 || end > arr.length || end - start <= 1) return true;

            Map<Integer, Integer> freq = new HashMap<>();
            Map<Integer, Integer> index = new HashMap<>();
            for(int i = start; i <= end; i++) {
                freq.put(arr[i], freq.getOrDefault(arr[i], 0) + 1);
                index.put(arr[i], i);
            }

            int idx = -1;
            for(int cur: freq.keySet()) {
                if(freq.get(cur) == 1) {
                    idx = index.get(cur);
                    break;
                }
            }
            if(idx == -1) return false;
            return helper(arr, start, idx) && helper(arr, idx +1, end);
        }

}
