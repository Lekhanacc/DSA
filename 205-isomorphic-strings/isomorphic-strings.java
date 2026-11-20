class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        // Arrays to store the last seen positions (1-indexed) of ASCII characters
        int[] mapS = new int[256];
        int[] mapT = new int[256];

        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            // If the last seen positions don't match, the mapping is inconsistent
            if (mapS[charS] != mapT[charT]) {
                return false;
            }

            // Update with i + 1 to distinguish from the default array value of 0
            mapS[charS] = i + 1;
            mapT[charT] = i + 1;
        }

        return true;
    }
}
