package LinkedList;

public class mergeKLists {

    /**
     * This solution uses divide-and-conquer approach to merge k sorted linked lists.
     * It recursively partitions the array of lists into smaller subproblems until it
     * reaches a base case where there is only one list. Then it uses the mergeTwoLists
     * function to merge two lists at a time until it eventually merges all the lists together.
     * This solution has a time complexity of O(N log k), where N is the total number of nodes
     * in all the lists and k is the number of lists.*/
    public ListNode mergeKLists(ListNode[] lists) {
        return partition(lists, 0, lists.length - 1);
    }

    private ListNode partition(ListNode[] lists, int left, int right) {
        if (right < left) {
            return null;
        }
        if (right == left) {
            return lists[right];
        }
        int mid = left + (right - left)/2;
        ListNode l1 = partition(lists, left, mid);
        ListNode l2 = partition(lists, mid + 1, right);
        return mergeTwoLists(l1, l2);
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(-1);
        ListNode prev = head;
        while(list1 != null && list2 != null) {
            if(list1.val < list2.val) {
                prev.next = list1;
                list1 = list1.next;
            } else {
                prev.next = list2;
                list2 = list2.next;
            }
            prev = prev.next;
        }
        while(list1 != null ) {
            prev.next = list1;
            list1 = list1.next;
            prev = prev.next;
        }
        while(list2 != null ) {
            prev.next = list2;
            list2 = list2.next;
            prev = prev.next;
        }
        return head.next;
    }


    /**
     * I used an iterative approach to merge k sorted linked lists. This solution
     * has a time complexity of O(Nk), where N is the total number of nodes in all
     * the lists and k is the number of lists.*/
    public ListNode mergeKListsMine(ListNode[] lists) {

        ListNode dummy = new ListNode();

        ListNode traverse = dummy;

        int counter = 0;

        while (counter < lists.length - 1) {
            if (lists[counter] == null) {
                counter++;
                continue;
            }
            ListNode lowest = lists[counter];
            int lowestAt = counter;

            for (int j = counter + 1; j < lists.length; j++) {
                if (lists[j] == null) {
                    continue;
                }
                if (lowest.val >= lists[j].val) {
                    lowest = lists[j];
                    lowestAt = j;
                }

            }

            traverse.next = lowest;

            traverse = traverse.next;

            lists[lowestAt] = lists[lowestAt].next;

        }

        while (lists.length > 0 && lists[lists.length - 1] != null) {

            traverse.next = lists[lists.length - 1];

            traverse = traverse.next;

            lists[lists.length - 1] = lists[lists.length - 1].next;

        }

        return dummy.next;
    }

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {};
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
