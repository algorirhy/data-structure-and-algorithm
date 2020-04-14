# 基于数组的队列

```java
public class ArrayQueue {
    private int[] items;
    private int capacity;
    private int head, tail;

    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        items = new int[capacity];
        head = 0;
        tail = 0;
    }

    public boolean enqueue(int x) {
        if ((tail + 1) % capacity == head) {
            return false;
        }
        items[tail] = x;
        tail = (tail + 1) % capacity;
        return true;
    }

    public int dequeue() {
        if (head == tail) {
            return -1;
        }
        int res = items[head];
        head = (head + 1) % capacity;
        return res;
    }
}
```

