package PriorityQueue;

import java.util.PriorityQueue;

public class KthLargestNumber {

    public static void main(String[] args) {

    }

    public int findKthLargest(int k, int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b) -> b - a);
int N = nums.length;
        for (int i = 0; i < N; i++) {
            // Push the current element onto the max heap
            pq.offer(nums[i]);

            // If the size of the max heap exceeds K, remove the largest element
            if (pq.size() > k)
                pq.poll();
        }

        // Return the Kth smallest element (top of the max heap)
        return pq.peek();

    }
}
