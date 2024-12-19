package code.interviews.googlePrep;


import java.util.ArrayList;
import java.util.List;

/*

An arithmetic sequence is a list of numbers with a definite pattern. If you take any number in the sequence then subtract it from the previous one, the difference is always a constant.

A good arithmetic sequence is an arithmetic sequence with a common difference of either 1 or -1.

For example, [4, 5, 6] is a good arithmetic sequence. So is [6, 5, 4], [10, 9], or [-3, -2, -1]. But, [1, 2, 1] (no common difference) or [3, 7] (common difference is 4) is NOT.
Implied, any sequence that has only one element is a good arithmetic sequence.

For example, [4] is a good arithmetic sequence.
Given an integer array nums, return the sum of the sums of each subarray that is a good arithmetic sequence.

Example:

Given nums = [7, 4, 5, 6, 5]. Each of the following subarrays is a good arithmetic sequence:

each item individual + 4,5 5,6 456 65
 */
public class GoogleRound2 {

    public static void main(String[] args) {
        int[] arr = new int[]{7, 4, 5, 6, 5};
        int sum = 0;
        for(int i=0; i< arr.length; i++){
            sum = sum + arr[i];
        }

        for(int i=0; i< arr.length-1; i++){
            int diff = arr[i+1] - arr[i];
            List<Integer> list = new ArrayList<>();

            if(diff == 1 || diff == -1) {
                list.add(arr[i]);
            }
                while(i < arr.length-1){
                    if(arr[i+1] - arr[i] == diff){
                        list.add(arr[i+1]);
                        i++;
                    }else{
                        i--;
                        break;
                    }
                }

                sum = sum + getSum(list);







        }

        System.out.println(sum);
    }

    public static int getSum(List<Integer> list){
        int sum =0;
        int[] arr = new int[list.size()];
        arr[0] = list.get(0);
        for(int i=1; i< list.size(); i++){
            arr[i] = arr[i-1]+list.get(i);
            sum = sum + arr[i];
        }

        int window = 2;
        for(int i=window; i< arr.length; i++){
            for(int j=0; j<=i-window;j++){
                sum = sum + arr[i] - arr[j];
            }
        }

        return sum;

    }
}
