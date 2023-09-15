package LinkedList;

public class mergeSortedLists {


    /**
     * There can be many risk with recursion such as stack overflow,
     * space complexity (often better to add a dummy than create new ones
     * every recursion), overhead and potential for infinite recursion.
     *
     * This would maybe cost so much money in a faulty cloud implementation.
     * Make sure it is well tested before implementing recursion.
     * */

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode dummy = new ListNode(-432);

        ListNode traverse = dummy;

        while(list1!=null&&list2!=null){

            if(list1.val<=list2.val){

                traverse.next = list1;
                list1 = list1.next;

            }

            else {

                traverse.next = list2;
                list2 = list2.next;

            }
            traverse = traverse.next;

        }


        while(list1!=null){

            traverse.next = list1;

            traverse = traverse.next;

            list1 = list1.next;

        }

        while(list2!=null){

            traverse.next = list2;

            traverse = traverse.next;

            list2 = list2.next;

        }

        return dummy.next;
    }

    public ListNode mergeTwoListsRecursive(ListNode list1, ListNode list2) {

        if(list1!=null && list2!=null){
            if(list1.val<list2.val){
                list1.next=mergeTwoLists(list1.next,list2);
                return list1;
            }
            else{
                list2.next=mergeTwoLists(list1,list2.next);
                return list2;
            }
        }
        if(list1==null)
            return list2;
        return list1;
    }


    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
