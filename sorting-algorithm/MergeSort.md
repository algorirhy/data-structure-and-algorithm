# 归并排序

| 平均时间复杂度 | 最好时间复杂度 | 最坏时间复杂度 | 空间复杂度 | 稳定性 |
| :------------: | :------------: | :------------: | :--------: | :----: |
|    O(nlogn)    |    O(nlogn)    |    O(nlogn)    |    O(n)    |  稳定  |

```java
public void mergeSort(int[] arr) {
    int len = arr.length;
    int[] tmp = new int[len];
    mSort(arr, tmp, 0, len - 1);
}

private void mSort(int[] arr, int[] tmp, int startIndex, int endIndex) {
    if (endIndex <= startIndex) {
        return;
    }
    int midIndex = startIndex + (endIndex - startIndex) / 2;
    mSort(arr, tmp, startIndex, midIndex);
    mSort(arr, tmp, midIndex + 1, endIndex);
    merge(arr, tmp, startIndex, midIndex, endIndex);
}

private void merge(int[] arr, int[] tmp, int startIndex, int midIndex, int endIndex) {
    System.arraycopy(arr, startIndex, tmp, startIndex, endIndex + 1 - startIndex);
    int left = startIndex;
    int right = midIndex + 1;
    for (int i = startIndex; i <= endIndex; i++) {
        if (left > midIndex) {
            //左边的数据已经排完
            arr[i] = tmp[right++];
        } else if (right > endIndex) {
            //右边的数据已经排完
            arr[i] = tmp[left++];
        } else if (tmp[left] < arr[right]) {
            arr[i] = tmp[left++];
        } else {
            arr[i] = tmp[right++];
        }
    }
}
```

