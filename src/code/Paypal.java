

/*

https://www.hackerearth.com/problem/algorithm/beautiful-numbers-05de0f51-101121ca

Write a function that takes a list L and returns a random sublist of size N of that list. Assume that the indexes must be in increasing order. That is, you cannot go backwards.
Example:
L = [1, 2, 3, 4, 5]
N = 3
The function should return one of these lists:
[1, 2, 3]
[1, 2, 4]
[1, 2, 5]
[1, 3, 4]
[1, 3, 5]
[1, 4, 5]
[2, 3, 4]
[2, 3, 5]
[2, 4, 5]
[3, 4, 5]

*/

import java.util.*;


class Paypal
{
    public List<List<Integer>> findSubArray(List<Integer> list, int N)
    {
        List<List<Integer>> answer = new ArrayList<>();
        for(int i =0; i <= list.size() - N ; i ++)
        {
            int pointer1 = i+1;
            int pointer2 = pointer1 + N-2;

            while(pointer2 < list.size())
            {
                List<Integer> data = new ArrayList<>();
                data.add(list.get(i));
                for(int j = pointer1; j <= pointer2; j++)
                {
                    data.add(list.get(pointer1));
                    data.add(list.get(pointer2));
                    j++;
                }

                answer.add(data);
                pointer1++;
                pointer2++;
            }


        }

        return answer;
    }

    public static void main(String arg[])
    {
        Paypal s = new Paypal();
        Arrays.asList(new int[]{1, 2});
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);


        List<List<Integer>> ans = s.findSubArray(list, 3);
        for(int i =0; i < ans.size(); i ++)
        {
            List<Integer> list1 = ans.get(i);
            System.out.println(list1);
        }

    }


}