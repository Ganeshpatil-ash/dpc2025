import java.util.*;

public class PrimeFactorization {
    
    // Function to find prime factors of a number
    public static List<Long> primeFactors(long n) {
        List<Long> factors = new ArrayList<>();
        
        // Divide out factors of 2
        while (n % 2 == 0) {
            factors.add(2L);
            n /= 2;
        }
        
        // Divide out odd factors from 3 to sqrt(n)
        for (long i = 3; i * i <= n; i += 2) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }
        
        // If n is still > 2, then it is prime
        if (n > 2) {
            factors.add(n);
        }
        
        return factors;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        long N = sc.nextLong();
        List<Long> result = primeFactors(N);
        
        System.out.println(result);
        
        sc.close();
    }
}
