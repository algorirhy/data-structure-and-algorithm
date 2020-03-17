package sorting;

import java.util.Arrays;

/**
 * 堆排序
 * 平均 最好 最坏 空间 稳定
 * n^1.3 n n^2 1 不稳定
 *
 * @author algorirhy
 */
public class ShellSort {

    public static void shellSort(int[] arr) {
        int len = arr.length;
        for (int step = len / 2; step >= 1; step /= 2) {
            for (int i = 0; i < step; i++) {
                //插入排序
                for (int j = i + step; j < len; j += step) {
                    int tmp = arr[j];
                    int pos = j;
                    while (pos >= step && arr[pos - step] > tmp) {
                        arr[pos] = arr[pos - step];
                        pos -= step;
                    }
                    arr[pos] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 6, 2, 8, 9, 5, 1, 4, 7};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
