package coding.strings.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * EASY

    Sample input:
    words = ["diaper", "abc", "test", "cba", "repaid"]

    Sample output:
    [["diaper", "repaid"], ["abc", "cba"]]

 */
public class Semordnilap {
    // O(n * m) time | O(n * m) space - where n is the number of words
    // and m is the length of the longest word
    public ArrayList<ArrayList<String>> semordnilap(String[] words) {
      /*
      words = ["diaper", "abc", "test", "cba", "repaid"]
      output = [["diaper", "repaid"], ["abc", "cba"]]
      */
        HashSet<String> wordsSet = new HashSet<>(Arrays.asList(words));
        ArrayList<ArrayList<String>> semordnilapPairs = new ArrayList<ArrayList<String>>();

        for (String word : words) {
            String reverse = new StringBuilder(word).reverse().toString();
            if (wordsSet.contains(reverse) && !reverse.equals(word)) {
                ArrayList<String> pair = new ArrayList<>();
                pair.add(word);
                pair.add(reverse);
                semordnilapPairs.add(pair);
                wordsSet.remove(word);
                wordsSet.remove(reverse);
            }
        }

        return semordnilapPairs;
    }


    public ArrayList<ArrayList<String>> semordnilap2(String[] words) {
    /*
      words = ["diaper", "abc", "test", "cba", "repaid"]
      output = [["diaper", "repaid"], ["abc", "cba"]]

      w = diaper | length same -> abc - test - cba - repaid (yes)
      if (same length)
        if reverse same,
          add list in result list.
      w = abc | test - cba
          add in list
      w = test | cba, repaid
      w = cba | repaid

      O(n * (n + m))
    */
        ArrayList<ArrayList<String>> semordnilapPairs = new ArrayList<ArrayList<String>>();
        for (int idx = 0; idx < words.length - 1; idx++) {
            String word = words[idx];
            for (int idx2 = idx + 1; idx2 < words.length; idx2++) {
                String nextWord = words[idx2];
                if (word.length() != nextWord.length()) {
                    continue;
                }
                String reversedWord = new StringBuilder(word).reverse().toString();
                if (reversedWord.equals(nextWord)) {
                    semordnilapPairs.add(new ArrayList<String>(Arrays.asList(word, reversedWord)));
                }
            }
        }
        return semordnilapPairs;
    }
}
