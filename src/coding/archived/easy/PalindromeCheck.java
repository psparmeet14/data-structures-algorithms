package coding.archived.easy;

/**
 * EASY


 Write a function that takes in a non-empty string and that returns a boolean
 representing whether the string is a palindrome.

 A palindrome is defined as a string that's written the same forward and
 backward. Note that single-character strings are palindromes.

 Sample Input
    string = "abcdcba"

 Sample Output
 true // it's written the same forward and backward
 */
public class PalindromeCheck {
    // O(n^2) time | O(n) space, where n is the length of the string
    public static boolean isPalindrome(String str) {
        String reversedString = "";
        for (int idx = str.length() - 1; idx >= 0; idx--) {
            reversedString += str.charAt(idx);
        }
        return str.equals(reversedString);
    }

    // O(n) time | O(n) space
    public static boolean isPalindrome2(String str) {
        StringBuilder reversedString = new StringBuilder();
        for (int idx = str.length() - 1; idx >= 0; idx--) {
            reversedString.append(str.charAt(idx));
        }
        return str.equals(reversedString.toString());
    }

    public static boolean isPalindrome3(String str) {
        return new StringBuilder(str).reverse().toString().equals(str);
    }

    // O(n) time | O(n) space
    public static boolean isPalindrome4(String str) {
        return isPalindrome4(str, 0);
    }

    public static boolean isPalindrome4(String str, int i) {
        int j = str.length() - 1 - i;
        return i >= j || str.charAt(i) == str.charAt(j) && isPalindrome4(str, i + 1);
    }

    // O(n) time, O(1) space - where n is the length of the string
    public static boolean isPalindrome5(String str) {
    /*
      str = "abcdcba"
      yes, palindrome

      a - odd
      aa - even
      aba - odd
      abba - even

      ab|ba, comparing left most and right most
      abcba,
   */
        int startIdx = 0;
        int endIdx = str.length() - 1;

        while (startIdx < endIdx) {
            if (str.charAt(startIdx) != str.charAt(endIdx)) {
                return false;
            }
            startIdx++;
            endIdx--;
        }

        return true;
    }

    // O(n) time, O(1) space - where n is the length of the string
    public static boolean isPalindrome6(String str) {
    /*
      str = "abcdcba"
      yes, palindrome

      a - odd
      aa - even
      aba - odd
      abba - even

      ab|ba, comparing left most and right most
      abcba,
   */
        for (int idx = 0; idx < str.length() / 2; idx++) {
            if (str.charAt(idx) != str.charAt(str.length() - 1 - idx)) {
                return false;
            }
        }

        return true;
    }
}
