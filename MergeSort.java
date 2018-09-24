public class MergeSort {

    public static int[] mergeSort(int[] arr){
        mergeSortFunc(arr, new int[arr.length], 0, arr.length-1);
        return arr;
    }

    public static void mergeSortFunc(int[] arr, int[] temp, int start, int end){
        if(start >= end){
            return;
        }
        int middle = (start + end)/2;
        mergeSortFunc(arr, temp, start, middle);
        mergeSortFunc(arr, temp,middle+1, end);
        mergeHalves(arr, temp, start, end);
    }

    public static void mergeHalves(int[] arr, int[] temp, int start, int end){
        int middle =  (start + end) / 2;

        int firstHalfStart = start;
        int secondHalfStart = middle + 1;
        int index = 0;

        while(firstHalfStart <= middle && secondHalfStart <= end){
            if(arr[firstHalfStart] < arr[secondHalfStart]){
                temp[index] = arr[firstHalfStart];
                firstHalfStart++;
            }
            else{
                temp[index] = arr[secondHalfStart];
                secondHalfStart++;
            }
            index++;
        }
        if(firstHalfStart<=middle){
            while (firstHalfStart<=middle){
                temp[index] = arr[firstHalfStart];
                firstHalfStart++;
                index++;
            }
        }
        if(secondHalfStart<=end){
            while (secondHalfStart<=end){
                temp[index] = arr[secondHalfStart];
                secondHalfStart++;
                index++;
            }
        }
        index = 0;
        for(int i=start; i<=end; i++){
            arr[i] = temp[index++];
        }
    }

    public static void main(String[] args){
        int[] arr = { 32, 4, 2, 533, 54, 224, 43, 22, 1, 4, 6, 7, 67 };
        arr = mergeSort(arr);
        for(int i=0; i<arr.length; i++){
            System.out.println(arr[i]);
        }
    }
}
