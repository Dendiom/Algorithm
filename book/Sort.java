package LeetCode.book;

import javax.lang.model.util.ElementScanner6;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * 各种排序算法
 */
public class Sort {


    /**
     * 冒泡排序（交换排序），O(n^2)，稳定排序
     */
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        for (int i = 0; i < arr.length - 1; i++) {  // 需要排序的次数
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j - 1] > arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
    }

    /**
     * 插入排序，O(n^2)，稳定排序，适合已经部分有序的数组
     */
    public static void insertSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        for (int i = 1; i < arr.length ; i++) {  // i为需要进行插入的数的下标
            int pivot = arr[i];
            int j;
            for (j = i - 1; j >= 0 && arr[j] > pivot; j--) {
                arr[j + 1] = arr[j];
            }

            arr[j + 1] = pivot;
        }
    }

    /**
     * 希尔排序，o(n^1.3)，插入排序改进版，非稳定排序
     */
    public static void hellSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        int d = arr.length;
        while (true) {
            d = d / 2;
            for (int i = 0; i < d; i++) {   // 几轮排序
                for (int j = i + d; j < arr.length; j = j + d) {
                    int pivot = arr[j];
                    int k;
                    for (k = j - d; k >= 0 && arr[k] > pivot; k = k - d) {
                        arr[k + d] = arr[k];
                    }
                    arr[k + d] = pivot;
                }
            }

            if (d == 1) {
                return;
            }
        }
    }

    /**
     * 归并排序，O(nlong)，稳定排序，需要额外的空间
     */
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        mergeHelper(arr,0, arr.length - 1, new int[arr.length]);
    }

    // 递归，分治
    private static void mergeHelper(int[] arr, int start, int end, int[] temp) {
        if (start < end) {
            int mid = (start + end) >> 1;
            mergeHelper(arr, start, mid, temp);      // start~mid有序
            mergeHelper(arr, mid + 1, end, temp);   // mid+1~end有序
            merge(arr, start, mid, end, temp);  // 合并
        }
    }

    // 将两个已经有序的数组合并成一个数组
    private static void merge(int[] arr, int start, int mid, int end, int[] temp) {
        int i = start, j = mid + 1;
        int index = start;
        while (i <= mid && j <= end) {
            if (arr[i] >= arr[j]) {
                temp[index] = arr[j];
                j++;
                index++;
            } else {
                temp[index] = arr[i];
                i++;
                index++;
            }
        }

        if (i > mid) {
            while (j <= end) {
                temp[index] = arr[j];
                j++;
                index++;
            }
        } else {
            while (i <= mid) {
                temp[index] = arr[i];
                i++;
                index++;
            }
        }

        for (int k = start; k <= end; k++) { // 赋值
            arr[k] = temp[k];
        }
    }

    /**
     * 简单选择排序，O(n^2)，不稳定排序
     */
    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        for (int i = 0; i < arr.length - 1; i++) {  // i为选择出来的数需要插入的位置
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[index]) {
                    index = j;
                }
            }
            if (index != i) {      // 交换
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
            }
        }

    }

    /**
     * 快速排序（交换排序），O(nlogn)，不稳定排序
     */
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        quickHelper(arr, 0, arr.length - 1);
    }

    private static void quickHelper(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }

        int pivot = arr[start];  // 取第一个数为哨兵，需要找到这个数最后的位置
        int i = start, j = end;
        while (i < j) {
            while (i < j && arr[j] >= pivot) {  // 右边起第一个比哨兵小的数
                j--;
            }
            arr[i] = arr[j];
            while (i < j && arr[i] <= pivot) {  // 左边起第一个比哨兵大的数
                i++;
            }
            arr[j] = arr[i];
        }

        arr[i] = pivot;
        quickHelper(arr, start, i -1);
        quickHelper(arr, i + 1, end);
    }

    /**
     * 堆排序，O(nlogn)，非稳定排序
     */
    public static void heapSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        for (int i = arr.length / 2 - 1; i >= 0; i--) {   // 从最后一个非叶子节点开始从下到上建堆
            adjust(arr, i, arr.length - 1);
        }

        for (int i = arr.length - 1; i > 0; i--) {   // 堆排序，将堆顶元素与最后一个元素交换，然后再调整堆
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            adjust(arr, 0, i - 1);
        }
    }

    // 将数组指定位置调整成大根堆
    private static void adjust(int[] arr, int start, int end) {
        int cur = start, lChild = 2 * cur + 1, rChild = 2 * cur + 2;
        int max = lChild;
        while (lChild <= end) {
            if (rChild <= end && arr[lChild] < arr[rChild]) {   // 将max赋值为孩子节点中较大一个
                max = rChild;
            }

            if (arr[cur] < arr[max]) {   // 如果父节点小于孩子节点，则需要交换
                int temp  = arr[cur];
                arr[cur] = arr[max];
                arr[max] = temp;

                cur = max;        // 向下移动
                lChild = 2 * cur + 1;
                rChild = 2 * cur + 2;
                max = lChild;
            } else {
                break;
            }
        }
    }


    /** test functions */

    public static void test(int length) {
        int[] arr = generate(length);
        System.out.print("待排序数组：");
        System.out.println(Arrays.toString(arr));

        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static int[] generate(int length) {
        if (length <= 0) {
            System.out.println("length need to be more than 0");
            return new int[0];
        }

        int[] arr = new int[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            arr[i] = random.nextInt(length);
        }

        return arr;
    }

    public static void main(String[] args) {
        test(10);
    }
}
