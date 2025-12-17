import coding.arrays.Playground;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        // Creating an integer array using pre-defined array size
        int[] nums = new int[4];
        nums[0] = 1;
        nums[1] = 6;
        nums[2] = 8;
        nums[3] = 1;

        // Creating an integer array during instantiation
        int[] elements = new int[]{1, 6, 8, 1};

        Playground playground = new Playground();
        var result = playground.hasTwoSameElements_forLoop(nums);
        System.out.println(result);
        var result2 = playground.hasTwoSameElements_hashSetAndForEach(nums);
        System.out.println(result2);
        var result3 = playground.hasTwoSameElements_hashSetAndForEach2(nums);
        System.out.println(result3);
    }
}