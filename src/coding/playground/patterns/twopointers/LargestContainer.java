package coding.playground.patterns.twopointers;

// You are given an array of numbers, each representing the height of a vertical line on a graph.
// A container can be formed with any pair of these lines, along with the x-axis of the graph.
// Return the amount of water which the largest container can hold.
public class LargestContainer {

    // heights = [2, 7, 8, 3, 7, 6]
    // Output: 24
    // water = min(i, j) * (j - i)
    public static void main(String[] args) {
        int[] heights = new int[]{2, 7, 8, 3, 7, 6};
        int[] heights2 = new int[]{};
        int[] heights3 = new int[]{1};
        int[] heights4 = new int[]{0, 1, 0};
        int[] heights5 = new int[]{3, 3, 3, 3};
        int[] heights6 = new int[]{1, 2, 3};
        int[] heights7 = new int[]{3, 2, 1};
        System.out.println("max water bruteforce: " + largestContainerBruteForce(heights));
        System.out.println("max water optimized: " + largestContainerOptimized(heights));
        System.out.println("max water optimized: " + largestContainerOptimized(heights2));
        System.out.println("max water optimized: " + largestContainerOptimized(heights3));
        System.out.println("max water optimized: " + largestContainerOptimized(heights4));
        System.out.println("max water optimized: " + largestContainerOptimized(heights5));
        System.out.println("max water optimized: " + largestContainerOptimized(heights6));
        System.out.println("max water optimized: " + largestContainerOptimized(heights7));
    }

    // Searching through all possible pairs of values.
    // Time complexity: O(n2), where n is the length of the array.
    public static int largestContainerBruteForce(int[] heights) {
        int maxWater = 0;
        for (int i = 0; i < heights.length; i++) {
            for (int j = i + 1; j < heights.length; j++) {
                int water = Math.min(heights[i], heights[j]) * (j - i);
                maxWater = Math.max(maxWater, water);
            }
        }
        return maxWater;
    }

    // Time complexity: O(n) because we perform approximately n iterations using the two-pointer technique.
    // Space complexity: O(1) because we only allocated a constant number of variables.
    public static int largestContainerOptimized(int[] heights) {
        int maxWater = 0;
        int left = 0;
        int right = heights.length - 1;

        while (left < right) {
            // Calculate the water contained between the current pair of lines.
            int water = Math.min(heights[left], heights[right]) * (right - left);
            maxWater = Math.max(maxWater, water);

            // Move the pointers inward, always moving the pointer at the shorter line.
            // If both lines have the same height, move both pointers inward.
            if (heights[left] < heights[right]) {
                left++;
            } else if (heights[left] > heights[right]) {
                right--;
            } else {
                left++;
                right--;
            }
        }
        return maxWater;
    }
}
