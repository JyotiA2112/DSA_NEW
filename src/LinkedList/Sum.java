package LinkedList;




 //* Definition for singly-linked list.
  class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
class Sum {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode result = new ListNode();
        ListNode resultFinal = result;
        int carry = 0;

        while(l1 != null || l2 != null)
        {
            int num1 = l1 == null ? 0 : l1.val;
            int num2 = l2 == null ? 0 : l2.val;

            int sum  = num1 + num2 + carry;
            int value = sum % 10;
            carry = sum / 10;

            ListNode newNode = new ListNode(value,null);
            resultFinal.next = newNode;
            resultFinal = resultFinal.next;

            l1=l1.next;
            l2=l2.next;


        }

        return result.next;

    }

    public static void main(String[] args) {
        Sum s = new Sum();
        ListNode l1 = new ListNode();
        l1.val = 6;
        l1.next = new ListNode(3,null);

        ListNode l2 = new ListNode();
        l2.val = 4;
        l2.next = new ListNode(4,null);;


        ListNode result = s.addTwoNumbers(l1,l2);
        while(result != null)
        {
            System.out.println(result.val);
            result = result.next;
        }

    }
}


