import java.util.*;

class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {

        List<int[]> list = new ArrayList<>();

        // Count soldiers in each row
        for (int i = 0; i < mat.length; i++) {

            int soldiers = 0;

            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1)
                    soldiers++;
            }

            // Store {soldierCount, rowIndex}
            list.add(new int[]{soldiers, i});
        }

        // Sort
        Collections.sort(list, (e1, e2) -> {

            // Same soldier count
            if (e1[0] == e2[0]) {
                return e1[1] - e2[1];
            }

            // Fewer soldiers first
            return e1[0] - e2[0];
        });

        int[] ans = new int[k];

        for (int i = 0; i < k; i++) {
            ans[i] = list.get(i)[1];
        }

        return ans;
    }
}