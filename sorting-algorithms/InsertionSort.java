package sorting;

import java.util.Arrays;

/**
 * 堆排序
 * 平均 最好 最坏 空间 稳定
 * n^2 n n^2 1 稳定
 *
 * @author algorirhy
 */
public class InsertionSort {

    public static void insertionSort(int[] arr) {
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

    public static void main(String[] args) {
        int[] arr = {3, 6, 2, 8, 9, 5, 1, 4, 7};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
