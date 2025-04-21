import java.util.*;

class Solution5 {
    public static int longestRepeatChar (String s, int k) {
        int start = 0;
        int mostFreq = 0;
        Map<Character, Integer> CharFreq = new HashMap<>();
        int longestSubString = 0;
        int length = s.length();
        for (int end = 0; end < length; end++) {
            char currentChar = s.charAt(end);
            CharFreq.put(currentChar, CharFreq.getOrDefault(currentChar, 0) + 1);
            mostFreq = Math.max(mostFreq, CharFreq.get(currentChar));
            if (end - start + 1 - mostFreq > k) {
                CharFreq.put(s.charAt(start), CharFreq.get(s.charAt(start)) - 1);
                start += 1;
            }
            longestSubString = Math.max(longestSubString, end - start +1);
        }
        return longestSubString;
    }
    public static void main(String[] args) {
        List<String> inputStrings = Arrays.asList("aabccbb", "abbcb", "abccde", "abbcab", "bbbbbbbbb");
        List<Integer> k = Arrays.asList(2, 1, 1, 2, 4);

        for (int i = 0; i < inputStrings.size(); ++i) {
            System.out.println((i + 1) + ".\tInput String: '" + inputStrings.get(i) + "'");
            System.out.println("\tk: " + k.get(i));
            System.out.println("\tLength of the longest substring with repeating characters: "
                    + longestRepeatChar(inputStrings.get(i), k.get(i)));
            System.out.println(new String(new char[100]).replace("\0", "-"));
        }
    }
}