package code.interviews.googlePrep;


/*

Given an integer array A[] of size N and integer k. For a fixed value p,
choose an index i (1 ≤ i ≤ n) and assign A[i] = max(0, A[i] − p),
this counts as one operation, and the task is to find the smallest value of p such that
all the elements of the array A[] become 0 in at most k operations.
 */


public class ZeroArray {
    public static void main(String[] args)
    {
        // Considering same input set of values
        int n = 4;
        int k = 6;
        int[] A = { 3, 5, 1, 4 };

        int max_val = 0;
        for (int i = 0; i < n; i++) {
            max_val = Math.max(max_val, A[i]);
        }

        int ans = Integer.MAX_VALUE;
        for (int p = 1; p <= max_val; p++) {
            int num_ops = 0;
            for (int i = 0; i < n; i++) {
                num_ops += Math.ceil((double)A[i] / p);
            }
            if (num_ops <= k) {
                ans = Math.min(ans, p);
            }
        }

        System.out.println(ans);
    }
}
// This code is contributed by Chetan Bargal
