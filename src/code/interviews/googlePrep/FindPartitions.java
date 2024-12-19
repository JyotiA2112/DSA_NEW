package code.interviews.googlePrep;

/**
 *
 * Find the number of partitions of an array such that each contiguous partition consists of atleast one negative number.
 * eg. [-1,-2,-3,-4] has these possible partitions :
 * [-1], [-2], [-3], [-4]
 *
 * [-1, -2], [-3], [-4]
 *
 * [-1, -2, -3], [-4]
 *
 * [-1, -2, -3, -4]
 *
 * [-1], [-2, -3], [-4]
 *
 * [-1], [-2, -3, -4]
 *
 * [-1], [-2], [-3, -4]
 *
 * [-1, -2], [-3, -4]
 */

public class FindPartitions {

    public static void main(String[] args) {
        System.out.println(findPartitions(new int[]{-1,-2,-3,-4}));
    }

    public static int findPartitions(int[] arr){

        int n = arr.length;
        int[] dp = new int[n+1];
        dp[n] = 0;
        int noOfPartition = 0;

        for(int i =n-1; i>=0 ; i--){
            if(arr[i] < 0){
                noOfPartition = dp[i+1] + 1 ;
                dp[i] = noOfPartition + dp[i+1];
            }else{
                dp[i] = dp[i+1];
            }
        }
        return noOfPartition;
    }
}
