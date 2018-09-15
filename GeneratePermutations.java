import java.util.*;

public class GeneratePermutations {

    public static List<List<Integer>> generatePermutations(List<Integer> a){
        List<List<Integer>> results = new ArrayList<>();
        permutaionRecurrence(a, 0, results);
        return results;
    }

    public static void permutaionRecurrence(List<Integer> a, int start, List<List<Integer>> results){
        if(start == a.size() - 1){
            results.add(new ArrayList<>(a));
            return;
        }

        for(int i=start; i<a.size(); i++){
            Collections.swap(a, start, i);
            permutaionRecurrence(a, start+1, results);
            Collections.swap(a, start, i);
        }
    }

    public static void main(String[] args){
        Integer[] input = { 2, 4, 1, 43, 53, 54};
        List<Integer> a = Arrays.asList(input);
        List<List<Integer>> permutations = generatePermutations(a);
        for(int i=0; i<permutations.size(); i++){
            System.out.println(permutations.get(i).toString());
        }
    }
}
