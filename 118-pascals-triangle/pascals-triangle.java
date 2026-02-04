class Solution {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> triangle = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {

            List<Integer> row = new ArrayList<>();

            // first element
            row.add(1);

            // middle elements
            for (int j = 1; j < i; j++) {
                List<Integer> prev = triangle.get(i - 1);
                row.add(prev.get(j - 1) + prev.get(j));
            }

            // last element
            if (i > 0) row.add(1);

            triangle.add(row);
        }
        return triangle;
    }
}
