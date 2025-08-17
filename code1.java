public class FindDuplicate {
    public static int findDuplicate(int[] nums) {
        // Phase 1: Detect cycle (Floyd’s Tortoise and Hare)
        int slow = nums[0];
        int fast = nums[0];
        
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        
        // Phase 2: Find entry point of cycle (duplicate)
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        
        return slow;
    }
    
    public static void main(String[] args) {
        int[] arr = {3, 1, 3, 4, 2};
        System.out.println("Duplicate number: " + findDuplicate(arr));
    }
}
