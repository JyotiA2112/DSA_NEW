package Heaps;

import java.util.Arrays;

public class KthLargestNumber {

    public static void main(String[] args) {
        KthLargestNumber k = new KthLargestNumber();
        System.out.println("Result : "+k.findKthLargest(2));
    }

    public int findKthLargest(int k) {
        int[] nums = new int[]{3, 2, 1, 5, 6, 4};

        int count = 1;

        int[] array = buildMaxHeap(nums);
        //int max = array[0];
        while(count < k)
        {
            array = deleteMaxNode(array);
            count ++;
        }

        return array[0];

    }

    private int[] deleteMaxNode(int[] array) {
        array[0] = array[array.length - 1];
        int[] newArray  = new int[array.length - 1];
        for(int i = 0; i < newArray.length; i++)
        {
            newArray[i] = array[i];
        }
        return buildMaxHeap(newArray);
    }

    /*public int[] heapify(int[] nums, int i)
    {
        int n = nums.length;


            int max = i;
            int left = i * 2 + 1;
            int right = i * 2 + 2;

            if(left < n && nums[left] > nums[max] )
            {
                max = left;
            }
            if(right < n && nums[right] > nums[max] )
            {
                max = right;
            }

            if(nums[i] != nums[max])
            {
                int temp = nums[i];
                nums[i] = nums[max];
                nums[max] = temp;
                heapify(nums, max);
            }

        return nums;
    }*/

    public int[] buildMaxHeap(int[] nums)
    {
        int n = nums.length;
        for (int i = n/2; i >= 0; i --)
        {
            //int parent = (i - 1)/2;
            int max = i;
            int left = i * 2 + 1;
            int right = i * 2 + 2;

            if(left < n && nums[left] > nums[max])
            {
                max = left;
            }
            if(right < n && nums[right] > nums[max])
            {
                max = right;
            }
            if(nums[max] != nums[i])
            {
                int temp = nums[i];
                nums[i] = nums[max];
                nums[max] = temp;
            }
        }
        return nums;
    }
}
