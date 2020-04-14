# 堆排序

| 平均时间复杂度 | 最好时间复杂度 | 最坏时间复杂度 | 空间复杂度 | 稳定性 |
| :------------: | :------------: | :------------: | :--------: | :----: |
|    O(nlogn)    |    O(nlogn)    |    O(nlogn)    |    O(1)    | 不稳定 |

```java
public void heapSort(int[] arr) {
    int len = arr.length;
    // 建大顶堆
    for (int i = len / 2; i >= 0; i--) {
        sink(arr, len, i);
    }
    // 取出堆顶元素
    for (int i = len - 1; i > 0; i--) {
        // 将堆顶元素与末位元素调换
        swap(arr, 0, i);
        // 数组长度-1，隐藏堆尾元素
        len--;
        sink(arr, len, 0);
    }
}

private void sink(int[] arr, int len, int index) {
    int parent = index;
    int lChild = 2 * index + 1;
    int rChild = 2 * index + 2;

    if (lChild < len && arr[lChild] > arr[parent]) {
        parent = lChild;
    }

    if (rChild < len && arr[rChild] > arr[parent]) {
        parent = rChild;
    }

    if (parent != index) {
        swap(arr, index, parent);
        //继续调整
        sink(arr, len, parent);
    }
}

private void swap(int[] arr, int i, int j) {
    int tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
}
```

