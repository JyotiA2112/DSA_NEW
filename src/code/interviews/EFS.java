package code.interviews;


import java.util.HashMap;
import java.util.Map;

/*

Problem :- Check if the array is balanced array or not.
Description:- A balanced array is defined to be an array where for every value n in the array, -n also is in the array.

Example 1:- {-2, 3, 2, -3} is a balanced array.
Example 2:- {1,1,-1,-1} is a balanced array.
Example 3:- {1,1,-1} is a NOT balanced array.
Example 4:- {-2, 3, 2, -3, 0, 5,-5} is a balanced array.
Example 5:- {1, 2, -3} is NOT a balanced array.
Example 6:- {-3,-2, -3, -2, 4, 1, 4, 1 , 3, 2, -4, -1} is NOT a balanced array

Note:-
1. Zeroes can be ignored.
2. There can be duplicates in the array. Every duplicate n needs to have -n


 */


/*

Problem:- Rotate an array to the left or right direction by count k.

Example 1:

Input :- Array = [1,2,3,4,5,6,7], direction = left, k = 1
Output :- Array = [2,3,4,5,6,7,1]

Input :- Array = [1,2,3,4,5,6,7], direction = left,
Output :- Array = [3,4,5,6,7,1,2] // [6,7,1,2,3,4,5]

Input :- Array = [1,2,3,4,5,6,7], direction = left, k = 8
Output :- Array = [2,3,4,5,6,7,1]

Input :- Array = [1,2,3,4,5,6,7], direction = right, k = 3
Output :- Array = [5,6,7,1,2,3,4]

Input :- Array = [1,2,3,4,5,6,7], direction = right, k = 1
Output :- Array = [7,1,2,3,4,5,6]

Note: Treat array as a circular array where it can be rotated even if the number of rotations is more than the length of the array.
 */
public class EFS {


    public boolean isBalancedArray(int[] arr)
    {
        Map<Integer,Integer> map = new HashMap<>();

        for(int i =0 ;  i<arr.length; i++)
        {
            if(arr[i] == 0)
            {
                continue;
            }
            //int num = arr[i] >  0 ? arr[i] : 0-(arr[i]);
            if(map.containsKey(0-arr[i])) //
            {
                int count = map.get(0-arr[i])-1; //0
                if(count>0)
                map.put(0-arr[i],count);
                else
                    map.remove(0-arr[i]);
            }
            else{
                int count = 1;
                if(map.containsKey(arr[i]))
                     count = map.get(arr[i]) +count;
                map.put(arr[i],count); //  3,1
            }
        }

        return map.isEmpty();


    }



    public static void main(String[] args) {
        EFS efs = new EFS();
        System.out.println(efs.isBalancedArray(new int[]{-3,-2, -3, -2, 4, 1, 4, 1 , 3, 2, -4, -1}));
    }



}
