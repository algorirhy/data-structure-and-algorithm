# 跳跃表

```java
class Skiplist {
    // 随机层数概率
    private static final float SKIPLIST_P = 0.5f;
    // 最大层数
    private static final int MAX_LEVEL = 16;

    Node head;

    class Node {
        int val;
        Node back; //后退指针
        Node[] forward; //前进指针

        public Node(int val) {
            this.val = val;
            forward = new Node[randomLevel()];
        }

        public Node(int val, int size) {
            this.val = val;
            forward = new Node[size + 1];
        }

        // 随机层数
        private int randomLevel() {
            int level = 1;
            while (Math.random() < SKIPLIST_P && level < MAX_LEVEL) {
                level++;
            }
            return level;
        }
    }

    public Skiplist() {
        head = new Node(-1, MAX_LEVEL);
    }

    public boolean search(int num) {
        Node p = searchNode(num);
        return p.val == num;
    }

    public void add(int num) {
        Node p = searchNode(num);
        Node n = new Node(num);
        n.back = p;
        for (int i = 0; i < n.forward.length; i++) {
            Node f = p;
            while (f.back != null && f.forward.length < i + 1) {
                f = f.back;
            }
            if (i == 0 && f.forward[i] != null) {
                f.forward[i].back = n;
            }
            n.forward[i] = f.forward[i];
            f.forward[i] = n;
        }
    }

    public boolean erase(int num) {
        if (isEmpty()) {
            return false;
        }
        Node p = searchNode(num);
        if (p.val != num) {
            return false;
        }
        for (int i = 0; i < p.forward.length; i++) {
            Node f = p.back;
            while (f.back != null && f.forward.length < i + 1) {
                f = f.back;
            }
            if (i == 0 && f.forward[i].forward[i] != null) {
                f.forward[i].forward[i].back = f;
            }
            f.forward[i] = f.forward[i].forward[i];
        }
        return true;
    }

    private Node searchNode(int target) {
        if (isEmpty()) {
            return head;
        }
        Node p = head;
        for (int i = MAX_LEVEL; i >= 0; i--) {
            while (p.forward[i] != null && p.forward[i].val <= target) {
                p = p.forward[i];
            }
        }
        return p;
    }

    private boolean isEmpty() {
        return head.forward[0] == null;
    }
}
```

