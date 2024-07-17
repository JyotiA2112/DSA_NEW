package src.Arrays;



class MinInRotatedArray {
    public int findMin(int[] nums) {

        int n =nums.length;


        int min = findMinInLeft(0,n-1,nums);
        return min;
    }
    //int rightMin = findMinInLeft(right,n-1)



    public int findMinInLeft(int start, int end, int[] nums)
    {


        if(start < end)
        {


            int left = (end+start)/2;
            int right = left+1;


            if(nums[left]<nums[start])
            {

                return findMinInLeft(start,left,nums);
            }
            else if(nums[right] > nums[end])
            {
                return findMinInLeft(right,end,nums);
            }
            else
            {
                return Math.min(nums[start],nums[right]);
            }


            //return 0;
        }
        else{

            return nums[start];

        }
    }

    public static void main(String[] args) {
        MinInRotatedArray min = new MinInRotatedArray();
        min.findMin(new int[]{2,3,4,5,1});
    }



}
