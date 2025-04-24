import java.util.*;

class Solution4 {
    public static String minWindow (String s, String t) {
        if (t.isEmpty())
            return "";
        Map <Character, Integer> reqCount = new HashMap <>();
        Map <Character, Integer> window = new HashMap <>();
        for (char c :t.toCharArray()) {
            reqCount.put(c, reqCount.getOrDefault(c,0) + 1);
        }
        int current = 0;
        int required = reqCount.size();
        int[] result = {-1, -1};
        int resLen = Integer.MAX_VALUE;
        int left = 0;
        for (int right = 0; right < s.length(); right ++){
            char c = s.charAt(right);
            if (reqCount.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(reqCount.get(c))) {
                    current ++;
                }
            }
            while (current == required) {
                if ((right - left + 1) < resLen) {
                    result[0] = left;
                    result[1] = right;
                    resLen = right - left + 1;
                }
                char leftChar = s.charAt(left);
                if (reqCount.containsKey(leftChar)) {
                    window.put(leftChar, window.getOrDefault(leftChar, 0) - 1);
                    if (window.get(leftChar) < reqCount.get(leftChar)) {
                        current--;
                    }
                }
                left++;
            }
        }
        return result[0] == -1 ? "" : s.substring(result[0], result[1] + 1);
    }
    public static void main(String[] args) {
        // Test cases: strings `s` and corresponding substrings `t`
        String[] s = {"PATTERN", "LIFE", "ABRACADABRA", "STRIKER", "DFFDFDFVD"};
        String[] t = {"TN", "I", "ABC", "RK", "VDD"};

        for (int i = 0; i < s.length; i++) {
            System.out.printf("%d.\ts: %s\n\tt: %s\n\tThe minimum substring containing %s is: %s\n",
                    i + 1, s[i], t[i], t[i], minWindow(s[i], t[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}