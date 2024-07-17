package src.Arrays;
import java.util.*;
public class CountPairs {
    public int countPairs(List<Integer> nums, int target) {


        Collections.sort(nums); // Sort the list in ascending order
        int cnt = 0;
        int left = 0;
        int right = nums.size() - 1;

        while (left < right) {
            int sum = nums.get(left) + nums.get(right);
            if (sum < target) {
                // If the sum is less than the target, all pairs between left and right will also be less than the target
                cnt += (right - left);
                left++;
            } else {
                // If the sum is greater or equal to the target, move the right pointer to the left
                right--;
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        CountPairs cp = new CountPairs();
        List<Integer> nums = new ArrayList<>();
        nums.add(-1);
        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(1);
        System.out.println(cp.countPairs(nums, 2));
    }
}






