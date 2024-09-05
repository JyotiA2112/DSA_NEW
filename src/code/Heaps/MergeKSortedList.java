package code.Heaps;

import java.util.*;
import java.util.stream.Collectors;

// Definition for singly-linked list.
 class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
class MergeKSortedList {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1,(new ListNode(4,(new ListNode(5,null)))));
        ListNode node2 = new ListNode(1,(new ListNode(3,(new ListNode(4,null)))));
        ListNode node3 = new ListNode(2,(new ListNode(4,null)));
        ListNode node4 = null;

        ListNode[] arr = new ListNode[]{node4,node1};


        MergeKSortedList merge = new MergeKSortedList();
        ListNode result = merge.mergeKLists(arr);
        while(result != null)
        {
            System.out.println(result.val);
            result = result.next;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {

        if(lists.length == 0)
            return null;




       // ListNode[] tempArray = new ListNode[lists.length];
        List<ListNode> tempArray1 = Arrays.stream(lists).filter(data -> data != null).collect(Collectors.toList());
        ListNode[] tempArray = tempArray1.toArray(ListNode[]::new);
        /*for(int j=0 ; j< lists.length; j++)
        {
            tempArray[j] = lists[j];
        }*/
        /*int j=0;
        for(ListNode node : lists)
        {
            if(node != null)
            {
                tempArray[j] = node;
                j++;
            }
        }*/

        ListNode result = new ListNode(-1,null);
        ListNode temp = result;
        while(tempArray != null && tempArray.length > 0)
        {
            tempArray = buildMinHeap(tempArray);
            temp.next = new ListNode(tempArray[0].val,null);
            temp=temp.next;
            if(tempArray[0].next == null)
            {
                tempArray = deleteNode(tempArray);
            }
            else{
                tempArray[0] = tempArray[0].next;
            }
        }

        return result.next;
    }

    public ListNode[] deleteNode(ListNode[] array)
    {
        ListNode[] data = new ListNode[array.length - 1];
        for(int i = 1; i < array.length; i++)
        {
            data[i-1] = array[i];
        }
        return data;
    }

    public ListNode[] buildMinHeap(ListNode[] array)
    {
        if(array == null || array.length == 0)
        {
            return null;
        }
        int n = array.length;
        for(int i = n/2 ; i>=0; i--)
        {
            if(array[i] == null)
            {
                array = deleteNode(array);
                buildMinHeap(array);
            }

            int left = i*2 + 1;
            int right = i*2 + 2;

            //ListNode max = array[i];
            int max = i;
            if(left < array.length && array[max].val > array[left].val)
            {
                max = left;
            }
            if(right < array.length && array[max].val > array[right].val)
            {
                max = right;
            }
            if(array[max].val != array[i].val)
            {
                ListNode temp = array[i];
                array[i] = array[max];
                array[max] = temp;
            }
        }

        return array;
    }
}