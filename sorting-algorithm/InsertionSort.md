# 插入排序

| 平均时间复杂度 | 最好时间复杂度 | 最坏时间复杂度 | 空间复杂度 | 稳定性 |
| :------------: | :------------: | :------------: | :--------: | :----: |
|     O(n^2)     |      O(n)      |     O(n^2)     |    O(1)    |  稳定  |

```java
public void insertionSort(int[] arr) {
    for (int i = 1; i < arr.length; i++) {
        int tmp = arr[i];
        int pos = i;
        while (pos > 0 && arr[pos - 1] > tmp) {
            arr[pos] = arr[pos - 1];
            pos--;
        }
        arr[pos] = tmp;
    }
}
```

