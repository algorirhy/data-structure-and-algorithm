package sorting;

import java.util.Arrays;

/**
 * 堆排序
 * 平均 最好 最坏 空间 稳定
 * nlogn nlogn nlogn 1 稳定
 *
 * @author algorirhy
 */
public class MergeSort {

    public static void mergeSort(int[] arr) {
        int[] tmp = new int[arr.length];
        mSort(arr, tmp, 0, arr.length - 1);
    }

    private static void mSort(int[] arr, int[] tmp, int startIndex, int endIndex) {
        if (endIndex <= startIndex) {
            return;
        }
        int midIndex = startIndex + (endIndex - startIndex) / 2;
        mSort(arr, tmp, startIndex, midIndex);
        mSort(arr, tmp, midIndex + 1, endIndex);
        merge(arr, tmp, startIndex, midIndex, endIndex);
    }

    private static void merge(int[] arr, int[] tmp, int startIndex, int midIndex, int endIndex) {
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

    public static void main(String[] args) {
        int[] arr = {3, 6, 2, 8, 9, 5, 1, 4, 7};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
