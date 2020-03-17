package sorting;

import java.util.Arrays;

/**
 * 堆排序
 * 平均 最好 最坏 空间 稳定
 * n^2 n n^2 1 稳定
 *
 * @author algorirhy
 */
public class BubbleSort {

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean isSwap = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    isSwap = true;
                }
            }
            if (!isSwap) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 6, 2, 8, 9, 5, 1, 4, 7};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
