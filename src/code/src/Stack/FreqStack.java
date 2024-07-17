package src.Stack;


import java.util.*;

class FreqStack {

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
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
