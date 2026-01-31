package coding.playground.patterns.twopointers;

// A palindrome is a sequence of characters that reads the same forward and backward.
// Given a string, determine if it's a palindrome after removing all non-alphanumeric characters.
// A character is alphanumeric if it's either a letter or a number/
public class IsPalindromeValid {
    public static void main(String[] args) {
        String s1 = "a dog! a panic in a pagoda.";
        String s2 = "abc123";
        String s3 = "";
        String s4 = "A man, a plan, a canal: Panama";
        String s5 = "race a car";
        String s6 = "12.02.2021";
        String s7 = "a";
        String s8 = "aa";
        String s9 = "ab";
        String s10 = "!, (?)";

        System.out.println("String " + s1 + ": " + isPalindromeValid(s1));
        System.out.println("String " + s2 + ": " + isPalindromeValid(s2));
        System.out.println("String " + s3 + ": " + isPalindromeValid(s3));
        System.out.println("String " + s4 + ": " + isPalindromeValid(s4));
        System.out.println("String " + s5 + ": " + isPalindromeValid(s5));
        System.out.println("String " + s6 + ": " + isPalindromeValid(s6));
        System.out.println("String " + s7 + ": " + isPalindromeValid(s7));
        System.out.println("String " + s8 + ": " + isPalindromeValid(s8));
        System.out.println("String " + s9 + ": " + isPalindromeValid(s9));
        System.out.println("String " + s10 + ": " + isPalindromeValid(s10));
    }

    public static boolean isPalindromeValid(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            // Skip non-alphanumeric characters from the left
            while (left < right && !Character.isLetterOrDigit(str.charAt(left))) {
                left++;
            }
            // Skip non-alphanumeric characters from the right
            while (left < right && !Character.isLetterOrDigit(str.charAt(right))) {
                right--;
            }
            // Compare characters (case-insensitive)
            // If the characters at the left and right pointers don't match, the string is not a palindrome.
            if (Character.toLowerCase(str.charAt(left)) != Character.toLowerCase(str.charAt(right))) {
                return false;
            }

            left++;
            right--;
        }
        return true;
    }
}
