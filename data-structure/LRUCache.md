# LRU缓存

```java
import java.util.HashMap;
import java.util.Map;

class LRUCache {
    private int capacity;
    private DoubleList cache;
    private Map<Integer, Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new DoubleList();
        map = new HashMap<>();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        int value = map.get(key).value;
        // 利用 put 方法把该数据提前
        put(key, value);
        return value;
    }

    public void put(int key, int value) {
        Node node = new Node(key, value);
        if (map.containsKey(key)) {
            // 删除原节点
            cache.remove(map.get(key));
        } else if (cache.size == capacity) {
            // 容量已满，删除尾节点
            Node last = cache.removeLast();
            map.remove(last.key);
        }
        // 添加新节点
        cache.addFirst(node);
        map.put(key, node);
    }

    // 双向链表节点
    class Node {
        public int key, value;
        public Node pre, next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    // 双向链表
    class DoubleList {
        private Node head, tail;
        public int size;

        public DoubleList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.pre = head;
            size = 0;
        }

        // 在链表头部添加节点 node
        public void addFirst(Node node) {
            node.pre = head;
            node.next = head.next;
            head.next.pre = node;
            head.next = node;
            size++;
        }

        // 删除链表中的 node 节点（node 一定存在）
        public void remove(Node node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
            size--;
        }

        // 删除链表中最后一个节点，并返回该节点
        public Node removeLast() {
            if (head.next == tail) {
                return null;
            }
            Node last = tail.pre;
            remove(last);
            return last;
        }
    }
}
```

