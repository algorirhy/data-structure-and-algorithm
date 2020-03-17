package sorting;

import java.util.Arrays;

/**
 * 堆排序
 * 平均 最好 最坏 空间 稳定
 * nlogn nlogn nlogn 1 不稳定
 *
 * @author algorirhy
 */
public class HeapSort {

    public static void heapSort(int[] arr) {
        int len = arr.length;
        buildHeap(arr, len);
        for (int i = len - 1; i > 0; i--) {
            //将堆顶元素与末位元素调换
            int tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;
            len--;
            //调整大顶堆
            sink(arr, 0, len);
        }
    }

    /**
     * 构建大顶堆
     *
     * @param arr 数组
     * @param len 数组长度
     */
    private static void buildHeap(int[] arr, int len) {
        for (int i = len / 2; i >= 0; i--) {
            sink(arr, i, len);
        }
    }

    /**
     * 下沉调整
     *
     * @param arr   数组
     * @param index 调整的位置
     * @param len   数组长度
     */
    private static void sink(int[] arr, int index, int len) {
        int parent = index;
        int lChild = 2 * index + 1;
        int rChild = 2 * index + 2;

        if (lChild < len && arr[lChild] > arr[parent]) {
            parent = lChild;
        }

        if (rChild < len && arr[rChild] > arr[parent]) {
            parent = rChild;
        }

        if (parent != index) {
            int tmp = arr[index];
            arr[index] = arr[parent];
            arr[parent] = tmp;
            //继续调整
            sink(arr, parent, len);
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 6, 2, 8, 9, 5, 1, 4, 7};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
