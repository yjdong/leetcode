package leetcode;

public class CopyListWithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null)
        {
            return null;
        }
        RandomListNode node = head;
        while(node!=null)
        {
            RandomListNode temp = node.next;
            node.next = new RandomListNode(node.label);
            node.next.next = temp;
            node = temp;
        }
        node = head;
        while(node != null)
        {
            node.next.random = node.random == null ? null : node.random.next;
            node = node.next.next;
        }
        node = head;
        RandomListNode n = head.next;
        RandomListNode start = head.next;
        while(node != null)
        {
            node.next = n.next;
            if(n.next == null)
            {
                break;
            }
            n.next = node.next.next;
            node = node.next;
            n = n.next;
        }
        return start;
    }
}