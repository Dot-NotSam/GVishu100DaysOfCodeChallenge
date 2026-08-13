class Solution {
    ListNode head;

    public Solution(ListNode head) {
        this.head = head;
    }
    
    public int getRandom() {
        int count = 0;
        int res = 0;
        ListNode node = this.head;

        while (node != null) {
            count++;
            if (Math.random() < 1.0/count) {
                res = node.val;
            }
            node = node.next;
        }

        return res;
    }
}
