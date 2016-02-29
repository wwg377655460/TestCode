/**
 * Created by wsdevotion on 16/2/29.
 */
public class crlist {

    public static void main(String [] args) {
        int [] b = {54,35,48,36,27,12,44,44,8,14,26,17,28};
        int [] a = bubbleSort(b,13);
        for (int i=0; i<a.length; i++) {
            System.out.println(a[i]);
        }
    }

    public static int[] bubbleSort(int[] A, int n) {
        // write code here
        int f = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (A[j] > A[j + 1]) {
                    swap(A, j, j + 1);
                }
            }
        }
        return A;
    }

    public static void swap(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }
}
