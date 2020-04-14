# 基于数组的栈

```java
public class ArrayStack {
    private int[] items;
    private int count;
    private int capacity;

    public ArrayStack(int capacity) {
        this.capacity = capacity;
        items = new int[capacity];
        count = 0;
    }

    public boolean push(int x) {
        if (count == capacity) {
            return false;
        }
        items[count++] = x;
        return true;
    }

    public int pop() {
        if (count == 0) {
            return -1;
        }
        return items[--count];
    }
}
```

