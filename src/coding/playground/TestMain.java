package coding.playground;

public class TestMain {

    public static void main(String[] args) {
        printAllUniqueIndexPairs();
    }

    // Print all unique index pairs (i, j) such that i < j.
    // It prints all 2-combinations of the array elements.
    // No duplicates like (1,2) and (2,1), and it never prints (x, x).
    // Time Complexity: O(n^2), where n is the length of the array.
    // Space Complexity: O(1)
    private static void printAllUniqueIndexPairs() {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6};
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                System.out.println("Pair: (" + nums[i] + ", " + nums[j] + ")");
            }
        }
    }
}
