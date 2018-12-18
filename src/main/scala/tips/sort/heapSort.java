package tips.sort;

/**
 * Created by john_liu on 2018/12/4.
 */
public class HeapSort {
    public static void heapSort(int[] arr) {
       makeHeap(arr);
       for(int i =arr.length;i>1;i--){
           heapAdjust(arr,i,arr.length);
       }
    }

    private static void makeHeap(int[] arr) {
      for(int i= arr.length/2;i>0;i--){
          heapAdjust(arr,i,arr.length-1);
      }
    }

    /**
     *已知arr[start,end]中只有arr[start]不满足堆定义
     * 是arr【start,end]成为大顶堆
     * @param arr
     * @param start
     * @param end
     */
    private static void heapAdjust(int[] arr, int start, int end) {
        int temp = arr[start];
        for(int i = 2*start;i<=end;i*=2){
            if(i<end && arr[i]> arr[i+1])i++;
            if(temp>arr[i])break;
            arr[start] =arr[i];
            start=i;
        }
        arr[start] = temp;
    }
}
