package sorting;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 堆排序
 * 平均 最好 最坏 空间 稳定
 * n*k n*k n*k  n+k 稳定
 *
 * @author algorirhy
 */
public class RadixSort {

    public static void radixSort(int[] arr) {
        int max = arr[0];
        for (int value : arr) {
            if (value > max) {
                max = value;
            }
        }
        //当前排序位置
        int location = 1;
        //桶列表
        ArrayList<ArrayList<Integer>> bucketList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            bucketList.add(new ArrayList());
        }
        while (true) {
            //判断是否排完
            int bigNum = (int) Math.pow(10, (location - 1));
            if (max < bigNum) {
                break;
            }
            //数据入桶
            for (int value : arr) {
                //计算余数 放入相应的桶
                int number = ((value / bigNum) % 10);
                bucketList.get(number).add(value);
            }
            //写回数组
            int index = 0;
            for (int i = 0; i < 10; i++) {
                int size = bucketList.get(i).size();
                for (int j = 0; j < size; j++) {
                    arr[index++] = bucketList.get(i).get(j);
                }
                bucketList.get(i).clear();
            }
            location++;
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 6, 2, 8, 9, 5, 1, 4, 7};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
