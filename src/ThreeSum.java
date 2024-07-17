import java.util.*;

public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        //[-4,-1,-1,0,1,2]

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(int i=0; i < nums.length; i++)
        {
            if(i>0 && nums[i] == nums[i-1])
            {
                continue;
            }
            int target = 0 - nums[i];
            int leftPointer = i+1;
            int rightPointer = nums.length - 1;

            while(leftPointer < rightPointer)
            {

                if(nums[leftPointer] + nums[rightPointer] == target)
                {
                    List<Integer> data = Arrays.asList(nums[i],nums[leftPointer],nums[rightPointer]);
                    result.add(data);
                    leftPointer++;
                    rightPointer--;
                }
                if(nums[leftPointer] == nums[leftPointer+1])
                {
                    leftPointer++;
                    continue;
                }
                if(nums[rightPointer] == nums[rightPointer-1])
                {
                    rightPointer--;
                    continue;
                }


            }

            /*Map<Integer,Integer> map = new HashMap<Integer,Integer>();
            for(int j = i+1 ; j<nums.length; j++ )
            {
                if(map.containsKey(nums[j]))
                {
                    int k = map.get(nums[j]);
                    List<Integer> data = Arrays.asList(nums[i],nums[j],nums[k]);
                    result.add(data);
                }
                else{
                    map.put(target-nums[j],j);
                }
            }*/



        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,0,0};
        System.out.println((threeSum(nums)));

        Stack<Integer> stack = new Stack<>();
        //stack.s
    }
}
