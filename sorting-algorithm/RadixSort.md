# 基数排序

| 平均时间复杂度 | 最好时间复杂度 | 最坏时间复杂度 | 空间复杂度 | 稳定性 |
| :------------: | :------------: | :------------: | :--------: | :----: |
|     O(n*k)     |     O(n*k)     |     O(n*k)     |   O(n+k)   |  稳定  |

```java
public void radixSort(int[] arr) {
    int min = arr[0], max = arr[0];
    for (int num : arr) {
        min = Math.min(min, num);
        max = Math.max(max, num);
    }
    // 求得绝对值最大的值
    max = Math.max(max, -min);
    // 当前排序位置
    int digits = 0;
    // 计算 max 的位数
    while (max > 0) {
        max /= 10;
        digits++;
    }
    // 考虑负数 桶的数量
    int bucketNum = 19;
    ArrayList<ArrayList<Integer>> bucketList = new ArrayList<>(bucketNum);
    for (int i = 0; i < bucketNum; i++) {
        bucketList.add(new ArrayList<>());
    }
    for (int i = 0, mod = 1; i < digits; i++, mod *= 10) {
        for (int num : arr) {
            //计算余数 放入相应的桶
            int pos = (num / mod) % 10;
            bucketList.get(pos + 9).add(num);
        }
        //写回数组
        int index = 0;
        for (ArrayList<Integer> bucket : bucketList) {
            for (int num : bucket) {
                arr[index++] = num;
            }
            bucket.clear();
        }
    }
}
```

