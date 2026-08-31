class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode prev = head;
        ListNode curr = head.next;
        
        int min = Integer.MAX_VALUE;
        int max = -1;

        int first = -1;
        int prevCrit = -1;

        int i = 1;
        while (curr.next != null) {
            if (
                (prev.val < curr.val && curr.val > curr.next.val) ||
                (prev.val > curr.val && curr.val < curr.next.val)
            ) {
                
                if (first == -1) first = i;

                if (prevCrit != -1) {
                    min = Math.min(min, i-prevCrit);
                }

                prevCrit = i;

                max = Math.max(max, i-first);
            }

            i++;
            prev = curr;
            curr = curr.next;
        }

        if (first == -1 || first == prevCrit) {
            return new int[]{-1, -1};
        }

        return new int[]{min, max};
    }
}
