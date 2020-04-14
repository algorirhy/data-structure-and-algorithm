# 希尔排序

| 平均时间复杂度 | 最好时间复杂度 | 最坏时间复杂度 | 空间复杂度 | 稳定性 |
| :------------: | :------------: | :------------: | :--------: | :----: |
|    O(n^1.3)    |      O(n)      |     O(n^2)     |    O(1)    | 不稳定 |

```java
public void shellSort(int[] arr) {
    int len = arr.length;
    for (int step = len / 2; step >= 1; step /= 2) {
        for (int i = 0; i < step; i++) {
            //插入排序
            for (int j = i + step; j < len; j += step) {
                int tmp = arr[j];
                int pos = j;
                while (pos >= step && arr[pos - step] > tmp) {
                    arr[pos] = arr[pos - step];
                    pos -= step;
                }
                arr[pos] = tmp;
            }
        }
    }
}
```

