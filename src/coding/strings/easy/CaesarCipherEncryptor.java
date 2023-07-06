package coding.strings.easy;

/**
 * EASY

 Given a non-empty string of lowercase letters and a non-negative integer
 representing a key, write a function that returns a new string obtained by
 shifting every letter in the input string by k positions in the alphabet,
 where k is the key.


 Note that letters should "wrap" around the alphabet; in other words, the
 letter 'z' shifted by one returns the letter 'a'

 Sample Input
 string = "xyz"
 key = 2

 Sample Output
 "zab"

 */
public class CaesarCipherEncryptor {
    // O(n) time | O(n) space, where n is the length of the string
    public static String caesarCypherEncryptor1(String str, int key) {
        // ascii lowercase starts at 65 till 90
        // A = 65
        // Z = 90
        // a = 97
        // z = 122
    /*
      str xyz , 2 -> zab
      each character
    */
        char[] newLetters = new char[str.length()];
        int newKey = key % 26;
        for (int idx = 0; idx < str.length(); idx++) {
            newLetters[idx] = getNewLetter1(str.charAt(idx), newKey);
        }
        return new String(newLetters);
    }

    public static char getNewLetter1(char letter, int key) {
        int newLetterCode = letter + key;
        if (newLetterCode <= 122) {
            return (char) newLetterCode;
        }
        return (char) (96 + newLetterCode % 122);
    }

    // O(n) time | O(n) space
    public static String caesarCypherEncryptor2(String str, int key) {
        char[] newLetters = new char[str.length()];
        int newKey = key % 26;
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        for (int idx = 0; idx < str.length(); idx++) {
            newLetters[idx] = getNewLetter2(str.charAt(idx), newKey, alphabet);
        }
        return new String(newLetters);
    }

    public static char getNewLetter2(char letter, int key, String alphabet) {
        int newLetterCode = alphabet.indexOf(letter) + key;
        return alphabet.charAt(newLetterCode % 26);
    }
}
