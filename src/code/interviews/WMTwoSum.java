package code.interviews;

import java.util.*;

public class WMTwoSum {

    public List<Integer> findTarget(int[] arr, int target)
    {
        List list = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++)
        {
            if(map.containsKey(arr[i]))
            {
                list.add(map.get(arr[i]));
                list.add(i);
                return list;
            }
            else{
                map.put(target - arr[i], i);
            }

        }
        return null;
    }



    public static void main(String[] args) {
        WMTwoSum wm = new WMTwoSum();
        int[] arr = new int[]{2,7,11,15};
        int target = 9;
        wm.findTarget(arr, target);
    }

}


    /*Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.

Example 1:
Input:nums = [2,7,11,15], target = 9
Output:[0,1]
Explanation:Because nums[0] + nums[1] == 9, we return [0, 1].Example 2:
Input:nums = [3,2,4], target = 6
Output:[1,2]*/