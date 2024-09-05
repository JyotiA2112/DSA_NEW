package code.Stack;


import java.util.*;

/*class FreqStack {

    Map<Integer,Integer> frequency;
    Map<Integer,Stack<Integer>> stack;
    int maxfreq = 0;


    public FreqStack() {
        frequency = new HashMap<>();
        stack = new HashMap<>();
    }

    public void push(int val) {
        //stack.push(val);
        Integer freq = 1;
        if(frequency.containsKey(val))
            freq = frequency.get(val) + freq;

        frequency.put(val,freq);
        if(freq > maxfreq)
        {
            maxfreq = freq;
        }
        if(stack.containsKey(freq))
        {
            Stack<Integer> tempStack = stack.get(freq);
            tempStack.push(val);
            stack.put(freq,tempStack);

        }else{
            Stack<Integer> tempStack = new Stack<>();
            tempStack.push(val);
            stack.put(freq,tempStack);
        }

    }

    public int pop() {



        // Remove element from setMap
        // from maximum frequency list
        int top = stack.get(maxfreq).pop();

        // Decrement the frequency of the popped element
       frequency.put(top, frequency.get(top) - 1);

        // If whole list is popped
        // then decrement the maxfreq
        if (stack.get(maxfreq).size() == 0)
            maxfreq--;
        return top;

    }
}*/

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */


class Solution {

    Map<Integer, Integer> frequencyMap = new HashMap<>();
    Map<Integer, Stack<Integer>> stack = new HashMap<>();
    int maxFreq = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Solution sn = new Solution();
        int[] nums = {1,2,2,3,3,3};
        int[] ans = sn.topKFrequent(nums,2);
        System.out.println(ans);
    }

    public int[] topKFrequent(int[] nums, int k) {


        int[] ans = new int[k];
        for(int i=0 ; i<nums.length; i++)
        {
            push(nums[i]);
        }



        for(int i=0 ; i<k; i++)
        {
            ans[i] = pop();
        }


        return ans;


    }

    public void push(int num)
    {
        int freqMap = 1;
        System.out.println("In If"+num);
        if(frequencyMap.containsKey(num)){

            freqMap = frequencyMap.get(num) + 1;
            if(freqMap > maxFreq)
            {
                maxFreq = freqMap;
            }
        }
        frequencyMap.put(num, freqMap);

        if(stack.containsKey(freqMap)){
            Stack<Integer> stackTemp = stack.get(freqMap);
            stackTemp.push(num);
            stack.put(freqMap, stackTemp);
        }
        else{
            Stack<Integer> stackTemp = new Stack();
            stackTemp.push(num);
            stack.put(freqMap, stackTemp);
        }
    }

    public int pop()
    {
        System.out.println(maxFreq+"MAX");
        Stack<Integer> stackTemp = stack.get(maxFreq);
        int item = stackTemp.pop();

        if(stack.get(maxFreq).isEmpty())
            maxFreq--;

        return item;
    }
}