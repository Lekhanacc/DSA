class Solution {
    public String getEncryptedString(String s, int k) {
        int n = s.length();

        k = k % n;  // reduce k first

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int newIndex = (i + k) % n;
            result.append(s.charAt(newIndex));
        }

        return result.toString();
    }
}