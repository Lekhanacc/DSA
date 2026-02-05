class Solution {

    public List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<>();

        backtrack(result, "", 0, 0, n);

        return result;
    }

    private void backtrack(List<String> result, String current,
                           int open, int close, int n) {

        // Base case: if length is complete
        if (current.length() == 2 * n) {
            result.add(current);
            return;
        }

        // Option 1: Add '(' if open brackets are left
        if (open < n) {
            backtrack(result, current + "(", open + 1, close, n);
        }

        // Option 2: Add ')' only if it stays valid
        if (close < open) {
            backtrack(result, current + ")", open, close + 1, n);
        }
    }
}
