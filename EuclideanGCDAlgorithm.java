import java.util.Scanner;

public class EuclideanGCDAlgorithm {

    // Time complexity is O(max(x, y)) since x is at least halved. Or O(n) where n is the number of bits needed
    // to represent the inputs

    // Space Complexity: O(n)

    public static long calculateGCD(long x, long y){
        return x == 0 ? y : calculateGCD(y%x, x);
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        long x = scanner.nextLong();
        long y = scanner.nextLong();
        scanner.close();

        if(x > y){
            long temp = y;
            y = x;
            x = temp;
        }
        long gcd = calculateGCD(x, y);
        System.out.println(Long.toString(gcd));
    }
}
