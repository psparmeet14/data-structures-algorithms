package coding.archived.easy;

/**
 * EASY


 Write a function that takes in a non-empty string and returns its run-length
 encoding.

 From Wikipedia, "run-length encoding is a form of lossless data compression in
 which runs of data are stored as a single data value and count, rather than as
 the original run." For this problem, a run of data is any sequence of
 consecutive, identical characters. So the run "AAA" would be
 run-length-encoded as "3A".

 To make things more complicated, however, the input string can contain all
 sorts of special characters, including numbers. And since encoded data must be
 decodable, this means that we can't naively run-length-encode long runs. For
 example, the run "AAAAAAAAAAAA" (12 As), can't
 naively be encoded as "12A", since this string can be decoded as
 either "AAAAAAAAAAAA" or "1AA". Thus, long runs (runs
 of 10 or more characters) should be encoded in a split fashion; the
 aforementioned run should be encoded as "9A3A"

 Sample Input
 string = "AAAAAAAAAAAAABBCCCCDD"

 Sample Output
 "9A4A2B4C2D"
 */
public class RunLengthEncoding {
    // O(n) time | O(n) space - where n is the length of the input string
    public String runLengthEncoding(String string) {
    /*
    string = "AAA"
    run-length encoded = "3A"

    currentChar = 'A';
    count = 1;
    is nextChar same as currentChar
      incrementCount++
      if count == 9 {
        append
        count = 1
      }
    if different
      str.append(count).append(currentChar)
      currentChar = nextChar;
      count=1;

    str.append(count).append(currentChar);

    */
        int count = 1;
        char currentChar = string.charAt(0);
        StringBuilder sb = new StringBuilder();
        for (int idx = 1; idx < string.length(); idx++) {
            char nextChar = string.charAt(idx);
            if (currentChar == nextChar) {
                count++;
                if (count > 9) {
                    sb.append(9).append(currentChar);
                    count = 1;
                }
            } else {
                sb.append(count).append(currentChar);
                count = 1;
                currentChar = nextChar;
            }
        }
        sb.append(count).append(currentChar);

        return sb.toString();
    }

    // O(n) time | O(n) space - where n is the length of the input string
    public String runLengthEncoding2(String string) {
    /*
      string = "AAA"
      run-length encoded = "3A"
    */
        StringBuilder encodedStringCharacters = new StringBuilder();
        int currentRunLength = 1;

        for (int idx = 1; idx < string.length(); idx++) {
            char currentCharacter = string.charAt(idx);
            char previousCharacter = string.charAt(idx - 1);

            if ((currentCharacter != previousCharacter) || currentRunLength == 9) {
                encodedStringCharacters.append(currentRunLength);
                encodedStringCharacters.append(previousCharacter);
                currentRunLength = 0;
            }

            currentRunLength += 1;
        }

        // Handle last run
        encodedStringCharacters.append(currentRunLength);
        encodedStringCharacters.append(string.charAt(string.length() - 1));

        return encodedStringCharacters.toString();
    }
}
