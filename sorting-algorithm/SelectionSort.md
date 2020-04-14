# 选择排序

| 平均时间复杂度 | 最好时间复杂度 | 最坏时间复杂度 | 空间复杂度 | 稳定性 |
| :------------: | :------------: | :------------: | :--------: | :----: |
|     O(n^2)     |     O(n^2)     |     O(n^2)     |    O(1)    | 不稳定 |

```java
public void selectionSort(int[] arr) {
    int len = arr.length;
    for (int i = 0; i < len; i++) {
        int min = i;
        for (int j = i + 1; j < len; j++) {
            if (arr[j] < arr[min]) {
                min = j;
            }
        }
        swap(arr, min, i);
    }
}

private void swap(int[] arr, int i, int j) {
    int tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
}
```

