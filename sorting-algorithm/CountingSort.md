# 计数排序

| 平均时间复杂度 | 最好时间复杂度 | 最坏时间复杂度 | 空间复杂度 | 稳定性 |
| :------------: | :------------: | :------------: | :--------: | :----: |
|     O(n+k)     |     O(n+k)     |     O(n+k)     |   O(n+k)   |  稳定  |

```java
public void countingSort(int[] arr) {
    int max = arr[0];
    int min = arr[0];
    for (int num : arr) {
        min = Math.min(min, num);
        max = Math.max(max, num);
    }
    int[] counter = new int[max - min + 1];
    for (int num : arr) {
        counter[num - min]++;
    }
    int index = 0;
    for (int i = 0; i < max - min + 1; i++) {
        while (counter[i] > 0) {
            arr[index++] = i + min;
            counter[i]--;
        }
    }
}
```

