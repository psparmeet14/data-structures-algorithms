package coding.archived.arrays.medium;

import java.util.List;

/**
 * MEDIUM
 *
 *  Move Element To End
 *
 *  Sample Input:
 *  array = [2, 1, 2, 2, 2, 3, 4, 2]
 *  toMove = 2
 *
 *  Sample Output:
 *  [1, 3, 4, 2, 2, 2, 2, 2]
 */
public class MoveElementToEnd {
    // O(n) time | O(1) space - where n is the length of the array
    public static List<Integer> moveElementToEnd_approach1(
            List<Integer> array, int toMove
    ) {
    /*
      array = [2, 1, 2, 2, 2, 3, 4, 2]
      toMove = 2
[2, 1, 2, 2, 2, 3, 4, 2]
[4, 1, 2, 2, 2, 3, 2, 2]
[4, 1, 3, 2, 2, 2, 2, 2]
    */
        int startPointer = 0;
        int endPointer = array.size() - 1;
        while (startPointer < endPointer) {
            if (array.get(endPointer) == toMove) {
                endPointer--;
            } else if (array.get(startPointer) == toMove) {
                int temp = array.get(endPointer);
                array.set(endPointer, toMove);
                array.set(startPointer, temp);
                endPointer--;
                startPointer++;
            } else {
                startPointer++;
            }
        }
        return array;
    }

    // O(n) time | O(1) space - where n is the length of the array
    public static List<Integer> moveElementToEnd_approach2(
            List<Integer> array, int toMove
    ) {
        int i = 0;
        int j = array.size() - 1;
        while (i < j) {
            while (i < j && array.get(j) == toMove) j--;
            if (array.get(i) == toMove) swap(i, j, array);
            i++;
        }
        return array;
    }
    private static void swap(int i, int j, List<Integer> array) {
        int temp = array.get(j);
        array.set(j, array.get(i));
        array.set(i, temp);
    }

    public static List<Integer> moveElementToEnd_bruteForce(
            List<Integer> array, int toMove
    ) {
    /*
      array = [2, 1, 2, 2, 2, 3, 4, 2]
      toMove = 2
      [2, 1, 2, 2, 2, 3, 4, 2]
      [2, 1, 2, 2, 4, 3, 2, 2]
      [2, 1, 2, 3, 4, 2, 2, 2]
      [2, 1, 4, 3, 2, 2, 2, 2]
      [3, 1, 4, 2, 2, 2, 2, 2]
    */
        for (int i = array.size() - 1; i > 0; i--) {
            if (array.get(i) == toMove) {
                continue;
            }
            for (int j = i - 1; j >= 0; j--) {
                if (array.get(j) != toMove) {
                    continue;
                }
                int temp = array.get(i);
                array.set(i, array.get(j));
                array.set(j, temp);
                break;
            }
        }
        return array;
    }
}
