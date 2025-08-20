import java.util.*;

public class SubarraysWithZeroSum {
    public static List<int[]> findSubarrays(int[] arr) {
        List<int[]> result = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        int prefixSum = 0;
        
        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];
            
            // If prefixSum == 0, subarray (0..i)
            if (prefixSum == 0) {
                result.add(new int[]{0, i});
            }
            
            // If prefixSum seen before, subarrays exist
            if (map.containsKey(prefixSum)) {
                for (int start : map.get(prefixSum)) {
                    result.add(new int[]{start + 1, i});
                }
            }
            
            // Add current index to the map
            map.computeIfAbsent(prefixSum, k -> new ArrayList<>()).add(i);
        }
        
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, -3, 3, -1, 2};
        List<int[]> subarrays = findSubarrays(arr);
        
        System.out.print("Subarrays with zero sum: ");
        for (int[] range : subarrays) {
            System.out.print("(" + range[0] + ", " + range[1] + ") ");
        }
    }
}
