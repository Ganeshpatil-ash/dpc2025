import java.util.Scanner;

public class LCMofTwoNumbers {
    
    // Function to calculate GCD using Euclidean algorithm
    public static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Function to calculate LCM
    public static long lcm(long a, long b) {
        return (a / gcd(a, b)) * b; // To prevent overflow
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Input two integers
        long N = sc.nextLong();
        long M = sc.nextLong();
        
        // Output LCM
        System.out.println(lcm(N, M));
        
        sc.close();
    }
}
