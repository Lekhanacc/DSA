class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtrack(1, k, n, new ArrayList<>());
        return result;
    }

    private void backtrack(int start, int k, int target, List<Integer> current) {

        if (current.size() == k) {
            if (target == 0) {
                result.add(new ArrayList<>(current));
            }
            return;
        }

        for (int i = start; i <= 9; i++) {

            if (i > target) {
                break;
            }

            current.add(i);

            backtrack(i + 1, k, target - i, current);

            current.remove(current.size() - 1);
        }
    }
}