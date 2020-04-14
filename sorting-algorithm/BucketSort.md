# 桶排序

| 平均时间复杂度 | 最好时间复杂度 | 最坏时间复杂度 | 空间复杂度 | 稳定性 |
| :------------: | :------------: | :------------: | :--------: | :----: |
|     O(n+k)     |      O(n)      |     O(n^2)     |   O(n+k)   |  稳定  |

```java
public void bucketSort(int[] arr) {
    int min = arr[0], max = arr[0];
    for (int num : arr) {
        min = Math.min(min, num);
        max = Math.max(max, num);
    }
    // 桶的区间大小
    int interval = 10;
    // 桶的数量
    int bucketNum = (max - min) / interval + 1;
    ArrayList<ArrayList<Integer>> bucketList = new ArrayList<>();
    for (int i = 0; i < bucketNum; i++) {
        bucketList.add(new ArrayList<>());
    }
    // 把所有元素放入对应的桶里面
    for (int num : arr) {
        int pos = (num - min) / interval;
        bucketList.get(pos).add(num);
    }
    //桶内排序
    for (ArrayList<Integer> list : bucketList) {
        Collections.sort(list);
    }
    //写入原数组
    int index = 0;
    for (ArrayList<Integer> list : bucketList) {
        for (int num : list) {
            arr[index] = num;
            index++;
        }
    }
}
```

