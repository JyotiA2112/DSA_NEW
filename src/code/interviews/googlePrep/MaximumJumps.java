package code.interviews.googlePrep;

/*

Given an array of non-negative integers, the goal is to travel from the first index to the last index with maximum possible score with as many jumps allowed. Score of a jump is defined as the number of index jumped multiplied by the value on the jumped index.
e.g. [3,7,9,10]

If the jump is from index0 to index2, the score is (2-0)*9 = 18

Sample input: [3,12,9,10]
Sample output: 32
Explanation: jump from index0 to index1 and then to
index3 = (1-0) * 12 + (3-1) * 10 = 12 + 20 = 32

Stones = [1, 2, 3, 4, 5], o/p = 20
Stones = [5, 4, 3, 2, 1], o/p = 10

*/
public class MaximumJumps {

    public static void main(String[] args) {
        int arr[] = new int[]{2,4,6,8,10};
        int maxIndex = arr.length - 1;
        int i = arr.length - 1;
        int score = 0;

        while(i>0){
            i--;
            if(arr[i] > arr[maxIndex]){
                score = score + arr[maxIndex]*(maxIndex - i);
                maxIndex = i;
            }
        }

        score = score + (arr[maxIndex]*(maxIndex - i));
        System.out.println(score);

    }
}
