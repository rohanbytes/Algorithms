public class QuickSort {

    public static void quickSort(int[] array, int start, int end){
        if(start >= end) {
            return;
        }
            int pivot = (end + start) / 2;
            int partition = partition(array, start, end, array[pivot]);
            quickSort(array, start, partition - 1 );
            quickSort(array, partition, end);
    }

    public static int partition(int[] array, int start, int end, int pivot){
        while(start <= end){
            while(array[start] < pivot){
                start++;
            }
            while(array[end] > pivot){
                end--;
            }
            if(start <= end){
                swap(array, start, end);
                start++;
                end--;
            }
        }
        return start;
    }

    public static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args){
        int[] array = {23, 66, 64, 2, 1, 45, 2, 56};
        quickSort(array, 0, array.length - 1);
        for(int i=0; i < array.length - 1; i++){
            System.out.print(Integer.toString(array[i]) + " ");
        }
        System.out.print(Integer.toString(array[array.length - 1]));
    }
}
