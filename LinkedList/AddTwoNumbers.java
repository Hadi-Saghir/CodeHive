package LinkedList;

//URL: https://leetcode.com/problems/add-two-numbers/
//Level: Medium

public class AddTwoNumbers {

    private ListNode listNode = null;

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Integer sum = 0;
        Integer carry = 0;

        while (l1 != null || l2 != null) {

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            if(listNode == null){
                listNode = new ListNode(sum % 10);
            } else {
                addLast(sum % 10);
            }

            carry = Math.round(sum / 10);
            sum = carry;
        }

        if(carry != 0){
            addLast(carry);
        }

        return listNode;
    }

    //maintains the order from left to right insertion
    public void addLast(Integer num){
        ListNode newNode = new ListNode(num);

        if (listNode.next == null) {
            listNode.next = newNode;
        } else {
            ListNode current = listNode.next;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
