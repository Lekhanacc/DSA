class Solution {
    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();

        if (digits.length() == 0) {
            return result;
        }

        String[] letters = {
            "", "", "abc", "def", "ghi",
            "jkl", "mno", "pqrs", "tuv", "wxyz"
        };

        backtrack(0, digits, "", letters, result);

        return result;
    }

    private void backtrack(int index, String digits, String current,
                           String[] letters, List<String> result) {

        if (index == digits.length()) {
            result.add(current);
            return;
        }

        String possible = letters[digits.charAt(index) - '0'];

        for (int i = 0; i < possible.length(); i++) {
            backtrack(
                index + 1,
                digits,
                current + possible.charAt(i),
                letters,
                result
            );
        }
    }
}