# 基于链表的栈

```java
public class ListStack<E> {
    private Node head;

    private class Node {
        public E val;
        public Node next;

        public Node(E e) {
            this.val = e;
            this.next = null;
        }
    }

    // 入栈
    public void push(E e) {
        if (head == null) {
            head = new Node(e);
        } else {
            Node node = new Node(e);
            node.next = head;
            head = node;
        }
    }

    // 出栈
    public E pop() {
        if (head == null) {
            return null;
        }
        E val = head.val;
        head = head.next;
        return val;
    }

    // 获取栈顶元素
    public E peek() {
        if (head == null) {
            return null;
        }
        return head.val;
    }
}
```

