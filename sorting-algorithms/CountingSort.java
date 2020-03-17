package sorting;

import java.util.Arrays;

/**
 * 堆排序
 * 平均 最好 最坏 空间 稳定
 * n+k n+k n+k k 稳定
 *
 * @author algorirhy
 */
public class CountingSort {

    public static void countingSort(int[] arr) {
        int max = arr[0];
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max){
                max = arr[i];
            } else if (arr[i] < min){
                min = arr[i];
            }
        }
        int[] countArr = new int[max - min + 1];
        for (int value : arr) {
            countArr[value - min]++;
        }
        int index = 0;
        for (int i = 0; i < countArr.length; i++) {
            while (countArr[i] > 0) {
                arr[index++] = i + min;
                countArr[i]--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 6, 2, 8, 9, 5, 1, 4, 7};
        countingSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
