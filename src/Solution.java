import java.util.*;

class Solution {
    public static List<String> findRepeatedSequences(String s) {
        Map <Character, Integer> toInt = new HashMap <Character, Integer>() {{put('A', 0); put('C', 1); put('G', 2); put('T', 3);}};
        List <Integer> encodedSequence = new ArrayList<>();
        for (char c : s.toCharArray()) {
            encodedSequence.add(toInt.get(c));
        }
        int k = 10;
        int n = s.length();
        if (n < k) return new ArrayList<>();
        int a = 4;
        int h = 0;
        Set <Integer> seenHash = new HashSet <>();
        Set <String> output = new HashSet<>();
        int a_k = 1;
        for (int i = 0; i < k; i++ ) {
            h = h*a + encodedSequence.get(i);
            a_k *= a;
        }
        seenHash.add(h);
        for (int start = 1; start <= n-k; start++) {
            h = h*a - encodedSequence.get(start - 1)*a_k + encodedSequence.get(start + k -1);
            if (seenHash.contains(h)) {
                output.add(s.substring(start, start + k));
            } else {
                seenHash.add(h);
            }
        }
        return new ArrayList<>(output);
    }
    public static void main(String[] args) {
        List<String> testCases = Arrays.asList(
                "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
                "AAAAAAAAAAAAA",
                "ACGTACGTACGTACGTACGTACGTACGTACGT",
                "GGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG",
                "GTACGTACGTACGCCCCCCCCGGGGG"
        );

        for (int i = 0; i < testCases.size(); i++) {
            System.out.println((i + 1) + ".\tInput: \"" + testCases.get(i) + "\"");

            List<String> result = findRepeatedSequences(testCases.get(i));
            System.out.println("\n\tOutput: " + result);
            System.out.println("-" + new String(new char[100]).replace('\0', '-') + "\n");
        }
    }
}