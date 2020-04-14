# 二分查找

### 1、简单二分查找

##### 迭代

```java
public int binarySearch(int[] arr, int target) {
    int left = 0, right = arr.length - 1;
    while (left <= right) {
        int mid = left + (right - left) / 2;
        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] < target) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    return -1;
}
```

##### 递归

```java
public int recursiveBinarySearch(int[] arr, int target) {
    return recursive(arr, 0, arr.length - 1, target);
}

public int recursive(int[] arr, int left, int right, int target) {
    if (left > right) {
        return -1;
    }
    int mid = left + (right - left) / 2;
    if (arr[mid] == target) {
        return mid;
    } else if (arr[mid] < target) {
        return recursive(arr, mid + 1, right, target);
    } else {
        return recursive(arr, left, mid - 1, target);
    }
}
```

### 2、二分查找的变形

##### 查找第一个值等于给定值的元素

```java
public int firstBinarySearch(int[] arr, int target) {
    int left = 0, right = arr.length - 1;
    while (left <= right) {
        int mid = left + (right - left) / 2;
        if (arr[mid] > target) {
            right = mid - 1;
        } else if (arr[mid] < target) {
            left = mid + 1;
        } else {
            if (mid == 0 || arr[mid - 1] != target) {
                return mid;
            } else {
                right = mid - 1;
            }
        }
    }
    return -1;
}
```

##### 查找最后一个值等于给定值的元素

```java
public int lastBinarySearch(int[] arr, int target) {
    int left = 0, right = arr.length - 1;
    while (left <= right) {
        int mid = left + (right - left) / 2;
        if (arr[mid] > target) {
            right = mid - 1;
        } else if (arr[mid] < target) {
            left = mid + 1;
        } else {
            if (mid == arr.length - 1 || arr[mid + 1] != target) {
                return mid;
            } else {
                left = mid + 1;
            }
        }
    }
    return -1;
}
```

##### 查找第一个大于等于给定值的元素

````java
public int nextBinarySearch(int[] arr, int target) {
    int left = 0, right = arr.length - 1;
    while (left <= right) {
        int mid = left + (right - left) / 2;
        if (arr[mid] >= target) {
            if (mid == 0 || arr[mid - 1] < target) {
                return mid;
            } else {
                right = mid - 1;
            }
        } else {
            left = mid + 1;
        }
    }
    return -1;
}
````

##### 查找最后一个小于等于给定值的元素

```java
public int preBinarySearch(int[] arr, int target) {
    int left = 0, right = arr.length - 1;
    while (left <= right) {
        int mid = left + (right - left) / 2;
        if (arr[mid] <= target) {
            if (mid == arr.length - 1 || arr[mid + 1] > target) {
                return mid;
            } else {
                left = mid + 1;
            }
        } else {
            right = mid - 1;
        }
    }
    return -1;
}
```

