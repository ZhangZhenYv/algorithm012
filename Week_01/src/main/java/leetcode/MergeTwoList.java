package leetcode;

/**
 * LeetCode-21:合并
 *
 * @author bingjie.chen
 * @date 2020/7/10
 */
public class MergeTwoList {

    //week01
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);

        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        prev.next = l1 == null ? l2 : l1;

        return prehead.next;
    }



    /**
     * 使用递归来合并两个有序链表
     */
    public ListNode mergeTwoListsUseRecursive(ListNode header1, ListNode header2) {
        //递归的出口
        if (header1 == null) {
            return header2;
        }

        if (header2 == null) {
            return header1;
        }

        if(header1.val < header2.val) {
            header1.next = mergeTwoListsUseRecursive(header1.next,header2);
            return header1;
        }else {
            header2.next = mergeTwoListsUseRecursive(header1,header2.next);
            return header2;
        }

    }




}
