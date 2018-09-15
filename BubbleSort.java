import java.util.Scanner;

class BubbleSort {

    public static void bubbleSort(int[] array){
        boolean isSorted = false;
        int sortedAhead = array.length - 1;
        while(!isSorted){
            isSorted = true;
            for(int i = 0; i < sortedAhead; i++){
                if(array[i] > array[i+1]){
                    swap(array, i, i + 1);
                    isSorted =  false;
                }
            }
            sortedAhead--;
        }
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int[] array = new int[n];
        String[] inputItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for(int i=0; i<n; i++){
            array[i] = Integer.parseInt(inputItems[i]);
        }
        scanner.close();

        bubbleSort(array);

        for(int i=0;i<array.length-1; i++){
            System.out.print(Integer.toString(array[i]) + " ");
        }
        System.out.print(Integer.toString(array[array.length-1]));
    }
}