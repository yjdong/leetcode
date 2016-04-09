package leetcode;

import java.util.HashMap;

public class LRUCache {
    private int capacity;
    private LinkedListNode head;
    private LinkedListNode end;
    private HashMap<Integer, LinkedListNode> map = new HashMap<Integer, LinkedListNode>();
    private int len = 0;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        len = 0;
    }
    
    public int get(int key) {
        if(map.containsKey(key))
        {
            LinkedListNode node = map.get(key);
            removeNode(node);
            setHead(node);
            return node.value;
        }
        else
            return -1;
    }
    
    public void removeNode(LinkedListNode n)
    {
        LinkedListNode pre = n.pre;
        LinkedListNode post = n.next;
        if(pre!=null)
            pre.next = post;
        else
            head = post;
        if(post!=null)
            post.pre = pre;
        else
            end = pre;
    }
    
    public void setHead(LinkedListNode n)
    {
        n.next = head;
        n.pre = null;
        if(head!=null)
            head.pre = n;
        head = n;
        if(end == null)
            end = n;
    }
    
    public void set(int key, int value) {
        if(map.containsKey(key))
        {
            LinkedListNode oldNode = map.get(key);
            oldNode.value = value;
            removeNode(oldNode);
            setHead(oldNode);
        }
        else
        {
            LinkedListNode newNode = new LinkedListNode(key, value);
            map.put(key, newNode);
            if(len<capacity)
            {
                setHead(newNode);
                len ++;
            }
            else
            {
                map.remove(end.key);
                end = end.pre;
                if(end != null)
                    end.next = null;
                setHead(newNode);
            }
        }
    }
}