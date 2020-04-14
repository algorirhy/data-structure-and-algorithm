# 冒泡排序

| 平均时间复杂度 | 最好时间复杂度 | 最坏时间复杂度 | 空间复杂度 | 稳定性 |
| :------------: | :------------: | :------------: | :--------: | :----: |
|     O(n^2)     |      O(n)      |     O(n^2)     |    O(1)    |  稳定  |

```java
public void bubbleSort(int[] arr) {
    int len = arr.length;
    for (int i = 0; i < len; i++) {
        boolean isSwap = false;
        for (int j = 0; j < len - i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                // 大于后一个数，交换
                swap(arr, j, j + 1);
                isSwap = true;
            }
        }
        // 未交换， 退出排序
        if (!isSwap) {
            break;
        }
    }
}

private void swap(int[] arr, int i, int j) {
    int tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
}
```

