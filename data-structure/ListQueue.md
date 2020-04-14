# 基于链表的队列

```java
public class ListQueue<E> {
    private Node head, tail;

    private class Node {
        public E val;
        public Node next;

        public Node(E e) {
            this.val = e;
            this.next = null;
        }
    }

    // 入队
    public void add(E e) {
        if (tail == null) {
            tail = new Node(e);
            head = tail;
        } else {
            Node node = new Node(e);
            tail.next = node;
            tail = node;
        }
    }

    // 出队
    public E remove() {
        if (head == null) {
            return null;
        }
        E val = head.val;
        head = head.next;
        return val;
    }

    // 获取队列头元素
    public E element() {
        if (head == null) {
            return null;
        }
        return head.val;
    }
}
```

