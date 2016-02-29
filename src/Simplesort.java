/**
 * Created by wsdevotion on 16/2/29.
 */
public class Simplesort {

    public static void main(String[] args) {


        Simplesort simplesort = new Simplesort();

        int[] a = {3, 0, 3, 23, 2, 1, 23, 21, 24, 3};
        simplesort.QuickSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    /**
     * 简单的冒泡
     *
     * @param array
     */
    public void BubbleSort0(int[] array) {
        int i, j;
        for (i = 0; i < array.length; i++) {
            for (j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    swap(array, i, j);
                }
            }
        }
    }

    /**
     * 改进的冒泡
     *
     * @param array
     */
    public void BubbleSort1(int[] array) {
        int i, j;
        for (i = 0; i < array.length; i++) {
            for (j = array.length - 2; j >= i; j--) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
    }

    /**
     * 改进的冒泡
     *
     * @param array
     */
    public void BubbleSort2(int[] array) {
        int i, j;
        boolean flag = true;
        for (i = 0; i < array.length && flag; i++) {
            flag = false;
            for (j = array.length - 2; j >= i; j--) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                    flag = true;
                }
            }
        }
    }

    /**
     * 选择排序
     *
     * @param array
     */
    public void SelectSort(int[] array) {
        int i, j, min;
        for (i = 0; i < array.length; i++) {
            min = i;
            for (j = i + 1; j < array.length; j++) {
                if (array[min] > array[j]) {
                    min = j;
                }
                if (i != min) {
                    swap(array, i, min);
                }
            }
        }
    }

    /**
     * 插入排序
     *
     * @param array
     */
    public void InsertSort(int[] array) {
        int i, j, flag;
        for (i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                flag = array[i];
                for (j = i - 1; j >= 0 && array[j] > flag; j--) {
                    array[j + 1] = array[j];
                }
                array[j + 1] = flag;
            }
        }
    }

    /**
     * 希尔排序
     *
     * @param array
     */
    public void ShellSort(int[] array) {
        int i, j, flag;
        int increment = array.length;
        do {
            increment = increment / 3 + 1;
            for (i = increment; i < array.length; i++) {
                if (array[i] < array[i - increment]) {
                    flag = array[i];
                    for (j = i - increment; j >= 0 && flag < array[j]; j -= increment) {
                        array[j + increment] = array[j];
                    }
                    array[j + increment] = flag;
                }
            }
        } while (increment > 1);
    }

    //改成一个大顶堆
    public void HeapAdjust(int[] array, int s, int m) {
        int temp, j;
        temp = array[s];
        for (j = 2 * s; j <= m; j *= 2) {
            if (j < m && array[j] < array[j + 1]) {
                j++;
            }
            if (temp >= array[j]) {
                break;
            }
            array[s] = array[j];
            s = j;
        }
        array[s] = temp;
    }

    /**
     * 堆排序
     *
     * @param array
     */
    public void HeapSort(int[] array) {

        int i;
        for (i = array.length / 2; i >= 0; i--) {
            HeapAdjust(array, i, array.length - 1);
        }

        for (i = array.length - 1; i >= 1; i--) {
            swap(array, 0, i);
            HeapAdjust(array, 0, i - 1);
        }
    }


    /*******************************
     * 归并排序
     **************************************/

    //归并两个数组
    public void Merge(int[] arrayR, int[] arrayL, int i, int m, int n) {
        int j, k, l;
        for (j = m + 1, k = i; i <= m && j <= n; k++) {
            if (arrayR[i] < arrayR[j]) {
                arrayL[k] = arrayR[i++];
            } else {
                arrayL[k] = arrayR[j++];
            }
        }
        if (i <= m) {
            for (l = 0; l <= m - i; l++) {
                arrayL[k + l] = arrayR[i + l];
            }
        }
        if (j <= n) {
            for (l = 0; l <= n - j; l++) {
                arrayL[k + l] = arrayR[j + l];
            }
        }
    }

    //归并数组
    public void MSort(int[] array, int[] array1, int s, int t) {
        int m;
        int[] array2 = new int[100];
        if (s == t) {
            array1[s] = array[s];
        } else {
            m = (s + t) / 2;
            MSort(array, array2, s, m);
            MSort(array, array2, m + 1, t);
            Merge(array2, array1, s, m, t);
        }
    }

    /**
     * 归并排序
     *
     * @param array
     */
    public void MergeSort(int[] array) {
        MSort(array, array, 0, array.length - 1);
    }


    /*********************************************************************/


    /******************************
     * 快速排序
     ************************************/


    public void QuickSort(int [] array) {
        QSort(array, 0, array.length-1);
    }

    public void QSort(int[] array, int low, int high) {
        int p;
        if (low < high) {
            p = Partition(array, low, high);

            QSort(array, low, p-1);
            QSort(array, p+1, high);
        }
    }


    public int Partition(int[] array, int low, int high) {
        int p;
        p = array[low];
        while (low < high) {
            while (low < high && array[high] >= p) {
                high--;
            }
            swap(array, low, high);
            while (low < high && array[low] <= p) {
                low++;
            }
            swap(array, low, high);
        }
        return low;
    }

    /*********************************************************************/


    public void swap(int[] array, int i, int j) {
        int flag = 0;
        flag = array[i];
        array[i] = array[j];
        array[j] = flag;
    }
}
