package src.Arrays;

import java.util.HashMap;
import java.util.Map;



class NextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Map<Integer,Integer> map = new HashMap<Integer,Integer>();

        int result[] = new int[nums2.length];


        for(int i = nums2.length-1; i>=0 ; i--)
        {
            map.put(nums2[i],i);
            if(i == nums2.length-1)
            {
                result[i] = -1;
               continue;
            }

            if(nums2[i+1] > nums2[i])
            {
                result[i] = nums2[i+1];
            }
            else{
                result[i] = result[i+1];
            }
        }

        for(int i = 0; i < nums1.length; i++)
        {
            int index =  map.get(nums1[i]);
            nums1[i] = result[index];
        }

        return nums1;
    }

    public static void main(String[] args) {
        NextGreaterElement ng = new NextGreaterElement();
        ng.nextGreaterElement(new int[]{4,1,2},new int[]{1,3,4,2});
    }
}
