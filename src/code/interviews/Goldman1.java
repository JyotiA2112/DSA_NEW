package code.interviews;



/*
 * Click `Run` to execute the snippet below!
 */


import java.util.ArrayList;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */
// 1 0 1 0 0
// 0 1 1 1 0
// 1 0 1 1 1
// 0 1 0 1 1
class Goldman1 {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("Hello, World!");
        strings.add("Welcome to CoderPad.");
        strings.add("This pad is running Java " + Runtime.version().feature());

        for (String string : strings) {
            System.out.println(string);
        }
        int[][] nums = new int[][]{{1,0,1,0,0},{0,1,1,1,0},{1,0,1,1,1},{0,1,0,1,1}};

        System.out.println(findIsland(nums));


    }


    public static int findIsland(int[][] nums)
    {
        if(nums.length == 0){
            return 0;
        }

        int n = nums.length;
        int m = nums[0].length;
        int count = 0;

        for(int i =0 ; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                if(nums[i][j] == 1)
                {
                    checkForIsland(i,j,nums);
                    count++;
                }
            }
        }

        return count;
    }

    public static void checkForIsland(int i, int j, int[][] nums){
        if(i >=0 && j>= 0 && i<nums.length && j<nums[0].length && nums[i][j] == 1){
            nums[i][j] = -1;
            checkForIsland(i-1,j,nums);
            checkForIsland(i+1,j,nums);
            checkForIsland(i,j-1,nums);
            checkForIsland(i,j+1,nums);
        }
    }
}


// Your previous Plain Text content is preserved below:

// This is just a simple shared plaintext pad, with no execution capabilities.

// When you know what language you'd like to use for your interview,
// simply choose it from the dots menu on the tab, or add a new language
// tab using the Languages button on the left.

// You can also change the default language your pads are created with
// in your account settings: https://app.coderpad.io/settings

// Enjoy your interview!


/**
 Problem Statement: You are the owner of a Shipment company. You use conveyor belts to ship packages from one port to another. The packages must be shipped within 'd' days.
 The weights of the packages are given in an array 'of weights'. The packages are loaded on the conveyor belts every day in the same order as they appear in the array. The loaded weights must not exceed the maximum weight capacity of the ship.
 Find out the least-weight capacity so that you can ship all the packages within 'd' days.



 Input Format:
 N = 5, weights[] = {1,2,3,4,5,6,7,8,9,10}, d = 5 //d-counter = 2 Range = (Sum - Min) = O()
 Result:
 15

 //Day 1 - 1 2 3 4 5 = 15
 //Day 2 - 6 7 = 13
 //Day 3 - 8
 //Day 4 - 9
 //Day 5 - 10

 */



 /*

1, land and 0 water

// 1 0 1 0 0
// 0 1 1 1 0
// 1 0 1 1 1
// 0 1 0 1 1

 */


