class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        // Early exit if magazine doesn't have enough total characters
        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        // Array to store the frequency of each letter ('a' to 'z')
        int[] charCounts = new int[26];

        // Count every available letter in magazine
        for (char c : magazine.toCharArray()) {
            charCounts[c - 'a']++;
        }

        // Subtract letters needed for ransomNote
        for (char c : ransomNote.toCharArray()) {
            // If a required letter is unavailable, return false
            if (charCounts[c - 'a'] == 0) {
                return false;
            }
            charCounts[c - 'a']--;
        }

        return true;
    }
}
