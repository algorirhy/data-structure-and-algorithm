package sorting;

import java.util.Arrays;

/**
 * 堆排序
 * 平均 最好 最坏 空间 稳定
 * n^2 n^2 n^2 1 不稳定
 *
 * @author algorirhy
 */
public class SelectionSort {

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[min];
            arr[min] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 6, 2, 8, 9, 5, 1, 4, 7};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
