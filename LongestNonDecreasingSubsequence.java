import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LongestNonDecreasingSubsequence {

    // Time Complexity: O(n^2)
    // Space Complexity: O(n)

    public static int lengthOfLongestNonDecreasingSubsequence(List<Integer> arr){
        Integer[] maxLength =  new Integer[arr.size()];
        Arrays.fill(maxLength, 1);

        for(int i=1; i<arr.size(); i++){
            for(int j=0; j<i; j++){
                if(arr.get(j) <= arr.get(i)){
                    maxLength[i] = Math.max(maxLength[i], maxLength[j] + 1);
                }
            }
        }
        return Collections.max(Arrays.asList(maxLength));
    }

    public static List<Integer> printLongestNonDecSubsequence(List<Integer> arr){
        Integer[] maxLength =  new Integer[arr.size()];
        Integer[] predecessor = new Integer[arr.size()];
        for(int i=0; i<arr.size(); i++){
            predecessor[i] = i;
        }
        Arrays.fill(maxLength, 1);

        for(int i=1; i<arr.size(); i++){
            for(int j=0; j<i; j++){
                if(arr.get(j) <= arr.get(i)){
                    if(maxLength[j] + 1 > maxLength[i]) {
                        maxLength[i] = maxLength[j] + 1;
                        predecessor[i] = j;
                    }
                }
            }
        }

        List<Integer> maxLengthList = Arrays.asList(maxLength);
        int length = Collections.max(maxLengthList);
        int i = maxLengthList.indexOf(length);
        List<Integer> result = new ArrayList<>();
        while (predecessor[i] != i){
            result.add(arr.get(i));
            i = predecessor[i];
        }
        result.add(arr.get(i));
        Collections.reverse(result);

        return result;
    }

    public static void main(String[] args){

        Integer[] arr = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9};
        int num = lengthOfLongestNonDecreasingSubsequence(Arrays.asList(arr));
        System.out.println(num);

        List<Integer> seq = printLongestNonDecSubsequence(Arrays.asList(arr));
        System.out.println(seq.toString());
    }
}
