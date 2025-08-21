public class TrappingRainWater {
    public static int trap(int[] height) {
        if (height == null || height.length < 3) return 0; // Edge case
        
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int water = 0;
        
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    water += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    water += rightMax - height[right];
                }
                right--;
            }
        }
        return water;
    }
    
    public static void main(String[] args) {
        int[] h1 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[] h2 = {4, 2, 0, 3, 2, 5};
        int[] h3 = {1, 1, 1};
        int[] h4 = {5};
        int[] h5 = {2, 0, 2};
        
        System.out.println(trap(h1)); // Output: 6
        System.out.println(trap(h2)); // Output: 9
        System.out.println(trap(h3)); // Output: 0
        System.out.println(trap(h4)); // Output: 0
        System.out.println(trap(h5)); // Output: 2
    }
}
