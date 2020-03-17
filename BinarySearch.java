public class BinarySearch {

    public static int recursiveBinarySearch(int[] arr, int left, int right, int target) {
        int mid = left + (right - left) / 2;
        while (left <= right) {
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                return recursiveBinarySearch(arr, mid + 1, right, target);
            } else {
                return recursiveBinarySearch(arr, left, mid - 1, target);
            }
        }
        return -1;
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
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

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int pos1 = recursiveBinarySearch(arr, 0, arr.length, 9);
        int pos2 = binarySearch(arr, 9);
        System.out.println(pos1 + " " + pos2);
    }
}
