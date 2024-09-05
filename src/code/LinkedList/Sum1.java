package code.LinkedList;




 //* Definition for singly-linked list.
  class ListNode1 {
      int val;
      ListNode1 next;
      ListNode1() {}
      ListNode1(int val) { this.val = val; }
      ListNode1(int val, ListNode1 next) { this.val = val; this.next = next; }
  }
class Sum1 {
    public ListNode1 addTwoNumbers(ListNode1 l1, ListNode1 l2) {

        ListNode1 result = new ListNode1();
        ListNode1 resultFinal = result;
        int carry = 0;

        while(l1 != null || l2 != null)
        {
            int num1 = l1 == null ? 0 : l1.val;
            int num2 = l2 == null ? 0 : l2.val;

            int sum  = num1 + num2 + carry;
            int value = sum % 10;
            carry = sum / 10;

            ListNode1 newNode = new ListNode1(value,null);
            resultFinal.next = newNode;
            resultFinal = resultFinal.next;

            l1=l1.next;
            l2=l2.next;


        }

        return result.next;

    }

    public static void main(String[] args) {
        Sum1 s = new Sum1();
        ListNode1 l1 = new ListNode1();
        l1.val = 6;
        l1.next = new ListNode1(3,null);

        ListNode1 l2 = new ListNode1();
        l2.val = 4;
        l2.next = new ListNode1(4,null);;


        ListNode1 result = s.addTwoNumbers(l1,l2);
        while(result != null)
        {
            System.out.println(result.val);
            result = result.next;
        }

    }
}


