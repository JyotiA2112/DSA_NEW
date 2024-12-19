package code.arrays;

import java.util.Arrays;
import java.util.List;

/** Explanation for this logic -
 * https://codecurse.medium.com/sum-of-all-subarrays-of-an-array-438045da7897
 *
 * possible subarrays - {4,5,6} = 4  5  6  45  56  456
 *
 */
//


public class FindSubArraySum {

    public static void main(String[] args) {
        int[] arr = new int[]{4,5,6};
        int n = arr.length;
        int sum = 0;
        for(int i=0; i< n; i++){
            int factor = (n-i)*(i+1);
            sum = sum + arr[i]*factor;
        }


        System.out.println(sum);
    }
}
