package coding.archived.easy;

import java.util.*;

/**
 * EASY

    Return list of characters that are common to all strings.

    Sample input:
    string = ["abc", "bcd", "cbaccd"]

    Sample output:
    ["b", "c"]
 */
public class CommonCharacters {
    // O(n * m) time | O(c) space - where n is the number of strings,
    // m is the length of the longest string, and c is the number of unique
    // characters across all strings
    public String[] commonCharacters(String[] strings) {
    /*
Set: {"a","b","c"} | {"b","c","d"} | {"c","b","a","d"}
      strings = ["abc", "bcd", "cbaccd"]
      output = ["b", "c"]

      characterCounts = {
        "a" : 2,
        "b" : 3,
        "c" : 3,
        "d" : 2
      }

      loop through map, see if characterCount == length of strings
      if yes, then add to list
    */
        HashMap<Character, Integer> characterCounts = new HashMap<>();
        for (String string : strings) {
            HashSet<Character> uniqueStringCharacters = new HashSet<>();
            for (char character : string.toCharArray()) {
                uniqueStringCharacters.add(character);
            }

            for (char character : uniqueStringCharacters) {
                if (!characterCounts.containsKey(character)) {
                    characterCounts.put(character, 0);
                }
                characterCounts.put(character, characterCounts.get(character) + 1);
            }
        }

        ArrayList<Character> finalCharacters = new ArrayList<>();
        for (Map.Entry<Character, Integer> characterCount : characterCounts.entrySet()) {
            Character character = characterCount.getKey();
            Integer count = characterCount.getValue();
            if (count == strings.length) {
                finalCharacters.add(character);
            }
        }

        String[] commonChars = new String[finalCharacters.size()];
        for (int i = 0; i < finalCharacters.size(); i++) {
            commonChars[i] = finalCharacters.get(i).toString();
        }

        return commonChars;
    }

    // TIME: O(n + m*k), where n is the length of the first string, m is the number
    // of distinct characters in the first string, and k is the average length
    // of the strings
    // SPACE: O(n + m)
    public String[] commonCharacters2(String[] strings) {
        List<String> commonChars = Arrays.stream(strings[0].split(""))
                .distinct()
                .filter(c -> Arrays.stream(strings).allMatch(s -> s.contains(c)))
                .toList();

        return commonChars.toArray(new String[0]);
    }

    // O(n * m) time | O(m) space - where n is the number of strings,
    // and m is the length of the longest string
    public String[] commonCharacters3(String[] strings) {
     /*
      strings = ["abc", "bcd", "cbaccd"]
      output = ["b", "c"]

      1. find smallest string
      2. Get potential common characters from this smallest string
      3. Traverse each string, remove nonexistent character from potential common characters

    */

    String smallestString = getSmallestString(strings);
    HashSet<Character> potentialCommonCharacters = new HashSet<>();
    for (char character : smallestString.toCharArray()) {
        potentialCommonCharacters.add(character);
    }

    for (String string : strings) {
        removeNonexistentCharacters(string, potentialCommonCharacters);
    }

    String[] finalCommonCharacters = new String[potentialCommonCharacters.size()];
    int i = 0;
    for (Character character : potentialCommonCharacters) {
        finalCommonCharacters[i] = character.toString();
        i++;
    }

    return finalCommonCharacters;
}

    private String getSmallestString(String[] strings) {
        String smallestString = strings[0];
        for (String string : strings) {
            if (string.length() < smallestString.length()) {
                smallestString = string;
            }
        }
        return smallestString;
    }

    private void removeNonexistentCharacters(
            String string, HashSet<Character> potentialCommonCharacters) {
        HashSet<Character> charactersToRemove = new HashSet<>();

        for (char character : potentialCommonCharacters) {
            if (string.indexOf(character) == -1) {
                charactersToRemove.add(character);
            }
        }

        potentialCommonCharacters.removeAll(charactersToRemove);
    }


    public String[] commonCharacters4(String[] strings) {
        Map<Character, Integer> charToCountMap = new HashMap<>();
        List<String> commonChars = new ArrayList<>();

        String str = strings[0];
        for (char currentChar : str.toCharArray()) {
            if (charToCountMap.containsKey(currentChar)) {
                continue;
            }

            charToCountMap.put(currentChar, 1);
            for (int j = 1; j < strings.length; j++) {
                String currentStr = strings[j];
                if (currentStr.indexOf(currentChar) != -1) {
                    charToCountMap.put(currentChar, charToCountMap.get(currentChar) + 1);
                }
            }

            if (charToCountMap.get(currentChar) == strings.length) {
                commonChars.add(String.valueOf(currentChar));
            }
        }

        return commonChars.toArray(new String[0]);
    }
}
