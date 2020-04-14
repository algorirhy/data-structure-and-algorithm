# 快速排序

| 平均时间复杂度 | 最好时间复杂度 | 最坏时间复杂度 | 空间复杂度 | 稳定性 |
| :------------: | :------------: | :------------: | :--------: | :----: |
|    O(nlogn)    |    O(nlogn)    |     O(n^2)     |  O(nlogn)  | 不稳定 |

```java
public void quickSort(int[] arr) {
    qSort(arr, 0, arr.length - 1);
}

private void qSort(int[] arr, int low, int high) {
    if (low >= high) {
        return;
    }
    int pos = partition(arr, low, high);
    qSort(arr, low, pos - 1);
    qSort(arr, pos + 1, high);
}

private int partition(int[] arr, int low, int high) {
    // 可使用三数取中法/随机法优化
    int pivot = arr[low];
    while (low < high) {
        while (low < high && arr[high] > pivot) {
            high--;
        }
        arr[low] = arr[high];
        while (low < high && arr[low] <= pivot) {
            low++;
        }
        arr[high] = arr[low];
    }
    arr[low] = pivot;
    return low;
}
```

