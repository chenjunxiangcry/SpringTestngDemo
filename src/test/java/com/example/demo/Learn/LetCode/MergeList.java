package com.example.demo.Learn.LetCode;

public class MergeList {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode merge = new ListNode(0);
        ListNode current = merge;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
                current = current.next;

            } else {
                current.next = list2;
                list2 = list2.next;
                current = current.next;
            }
        }
        if (list1 != null) {
            current.next = list1;
        }
        if (list2 != null) {
            current.next = list2;
        }
        ListNode copy = merge.next;
        while (copy != null) {
            System.out.print(copy.val + ", ");
            copy = copy.next;
        }
        System.out.println("");
        return merge.next;

    }

    public static ListNode deleteNodeByIndex(ListNode head, int k) throws Exception {
        ListNode dummy = new ListNode(0);
        dummy.next=head;
        ListNode pre = dummy;
        ListNode currentNode = pre;
        String s ="1-->2-->3--4>--5--null";
        while(k>0){
            if(currentNode !=null){
                pre = currentNode;
                currentNode=currentNode.next;
            }else{
                System.out.println("Excceed listNode size");
                throw new Exception("Exccedd listNode size");
            }
            k--;
        }
        pre.next = currentNode.next;
        Utils.printArray(dummy.next);
        return dummy.next;
    }
    public static ListNode deleteNodeByReverseIndex(ListNode head, int k) throws Exception {
        ListNode dummy = new ListNode(0);
        dummy.next=head;
        ListNode slow = dummy;
        ListNode fast = head;
        while(k>0){
            fast=fast.next;
            k--;
        }
        while(fast!=null){
            fast=fast.next;
            slow=slow.next;
        }
        slow.next=slow.next.next;
        return dummy.next;
    }
    public static ListNode deleteNodeByValue(ListNode head, int val) {
        ListNode dummy = new ListNode(1);
        dummy.next=head;
        ListNode pre = dummy;
        while(pre.next!=null){
            if(pre.next.val == val){
                pre.next = pre.next.next;
            }else{
                pre = pre.next;
            }
        }
        Utils.printArray(dummy.next);
        return dummy.next;
    }
    public static void main(String[] args) throws Exception {
        ListNode list1 = new ListNode(1);
        ListNode list12 = new ListNode(2);
        ListNode list13 = new ListNode(3);
        ListNode list14 = new ListNode(4);
        ListNode list15 = new ListNode(5);

        list1.next = list12;
        list12.next = list13;
        list13.next = list14;
        list14.next = list15;
        ListNode list2 = new ListNode(1);
        ListNode list22 = new ListNode(2);
        ListNode list23 = new ListNode(3);
        list2.next = list22;
        list22.next = list23;
        //mergeTwoLists(list1,list2);
        deleteNodeByIndex(list1, 7);
        //new LinkedList<>();

    }
}
