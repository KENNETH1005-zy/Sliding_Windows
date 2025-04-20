class Solution3 {
    public static String findMinSubsequence (String str1, String str2) {
        int sizeS1 = str1.length();
        int sizeS2 = str2.length();
        int IndexS1 = 0;
        int IndexS2 = 0;
        int start = 0;
        int end = 0;
        float length = Float.POSITIVE_INFINITY;
        String minSubsequence = "";
        while (IndexS1 < sizeS1) {
            if (str1.charAt(IndexS1) == str2.charAt(IndexS2)) {
                IndexS2 += 1;
                if (IndexS2 == sizeS2) {
                    start = IndexS1;
                    end = IndexS1;
                    IndexS2 -= 1;
                    while (IndexS2 >= 0) {
                        if (str1.charAt(start) == str2.charAt(IndexS2)) {
                            IndexS2 -= 1;
                        }
                        start -= 1;
                    }
                    start += 1;
                    if ((end - start + 1) < length) {
                        length = end - start +1;
                        minSubsequence = str1.substring(start, end + 1);
                    }
                    IndexS1 = start;
                    IndexS2 = 0;
                }
            }
            IndexS1 += 1;
        }
        return minSubsequence;
    }
    public static void main(String[] args) {
        // Driver code
        String[] str1 = {
                "abcdedeaqdweq", "fgrqsqsnodwmxzkzxwqegkndaa", "zxcvnhss", "alpha", "beta"
        };
        String[] str2 = {
                "adeq", "kzed", "css", "la", "ab"
        };
        for (int i = 0; i < str1.length; i++) {
            System.out.println(i + 1 + ".\tInput String: " + "(" + str1[i] + ", " + str2[i] + ")");
            System.out.println("\tSubsequence string: " + findMinSubsequence(str1[i], str2[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}