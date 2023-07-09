package coding.strings.easy;


import java.util.HashMap;
import java.util.HashSet;

/**
 * EASY

    Check if all characters in document string are present in characters string.

    Sample Input:
        characters = "abcabc"
        document = "aabbccc";

    Sample Output:
        False
 */
public class GenerateDocument {
    // O(n + m) time | O(c) space - where n is the number of characters,
    // m is the length of the document, and c os the number of unique characters
    // in the characters string
    public boolean generateDocument(String characters, String document) {
    /*
      characters = "abcabc"
      document = "aabbccc";
      Ans: False

      MapCharacters {
        "a" : 2
        "b" : 2
        "c" : 2
      }

      loop through characters in document string
    - if key not present, or value is 0, return false
    - else, decrement its alue to indicate we have used one value.
    If any key is not present, then false.
    map1 each value for a key >= same value in map2
    Spaces ?
    "space" - replace it with _

    */
        HashMap<Character, Integer> characterCounts = new HashMap<>();
        for (char character : characters.toCharArray()) {
            characterCounts.put(character, characterCounts.getOrDefault(character, 0) + 1);
        }

        for (char character : document.toCharArray()) {
            if (!characterCounts.containsKey(character) || characterCounts.get(character) == 0) {
                return false;
            }
            characterCounts.put(character, characterCounts.get(character) - 1);
        }

        return true;
    }



    // O(m * (n + m)) time | O(1) space, where n is the length of the characters
    // string, n is the length of the document string
    public boolean generateDocument2(String characters, String document) {
        for (char character : document.toCharArray()) {
            int charactersFrequency = countCharacterFrequency(character, characters);
            int documentFrequency = countCharacterFrequency(character, document);
            if (documentFrequency > charactersFrequency) {
                return false;
            }
        }

        return true;
    }

    private int countCharacterFrequency(char character, String target) {
        int characterFrequency = 0;
        for (char c : target.toCharArray()) {
            if (c == character) {
                characterFrequency++;
            }
        }
        return characterFrequency;
    }


    // O(c * (n + m)) time | O(c) space, where n is the length of the characters
    // string, n is the length of the document string, and c is the number
    // of unique characters in the document string
    public boolean generateDocument3(String characters, String document) {
        HashSet<Character> alreadyCountedCharacters = new HashSet<>();
        for (char character : document.toCharArray()) {
            if (alreadyCountedCharacters.contains(character)) {
                continue;
            }
            int charactersFrequency = countCharacterFrequency(character, characters);
            int documentFrequency = countCharacterFrequency(character, document);
            if (documentFrequency > charactersFrequency) {
                return false;
            }
            alreadyCountedCharacters.add(character);
        }

        return true;
    }

}
