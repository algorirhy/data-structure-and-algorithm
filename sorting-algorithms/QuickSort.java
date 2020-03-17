package sorting;

import java.util.Arrays;

/**
 * 堆排序
 * 平均 最好 最坏 空间 稳定
 * nlogn nlogn n^2 logn 不稳定
 *
 * @author algorirhy
 */
public class QuickSort {

    public static void quickSort(int[] arr) {
        qSort(arr, 0, arr.length - 1);
    }

    private static void qSort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int pos = partition(arr, low, high);
        qSort(arr, low, pos - 1);
        qSort(arr, pos + 1, high);
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        while (low < high) {
            while (low < high && arr[high] > pivot) {
                high--;
            }
            arr[low] = arr[high];
            while (low < high && arr[low] <= pivot) {
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = pivot;
        return low;
    }

    public static void main(String[] args) {
        int[] arr = {3, 6, 2, 8, 9, 5, 1, 4, 7};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}