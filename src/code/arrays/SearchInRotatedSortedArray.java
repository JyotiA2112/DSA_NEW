package code.arrays;

class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        int result = binarySearch(left, right, nums, target);

        return result;
    }

    public int binarySearch(int left, int right, int[] nums, int target)
    {
        if(left >= nums.length || right >= nums.length)
        {
            System.out.println("coming here 4");
            return -1;
        }


    else{
        if(nums[left] == target)
        {
            System.out.println("coming here 5"+left);
            return left;
        }
        else if(nums[right] == target)
        {
            return right;
        }
        else{
            int mid = (left+right)/2;
            System.out.println(mid);
        if(nums[mid] == target)
        {
            return mid;
        }
        if(nums[left] < nums[mid] && target >= nums[left] && target <= nums[mid])
        {
            System.out.println("coming here 1");
            return binarySearch(left, mid, nums, target);
        }
        else if(nums[left] > nums[mid])
        {
             System.out.println("coming here 2");
            if(nums[mid+1] < nums[right] && target >= nums[mid+1] && target <= nums[right])
            {
                return binarySearch(mid+1, right, nums, target);
            }
            else{
                return binarySearch(left, mid, nums, target);
            }
        }
        else{
             System.out.println("coming here 3");
            return binarySearch(mid+1, right, nums, target);
        }
        }
    }




    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray search = new SearchInRotatedSortedArray();
        System.out.println(search.search(new int[]{1,3,5},2));
    }
}
