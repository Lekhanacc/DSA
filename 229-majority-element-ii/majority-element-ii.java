import java.util.*;

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int count1 = 0, count2 = 0;
        Integer cand1 = null, cand2 = null;

        // Pass 1: find candidates
        for (int num : nums) {
            if (cand1 != null && num == cand1) {
                count1++;
            } else if (cand2 != null && num == cand2) {
                count2++;
            } else if (count1 == 0) {
                cand1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                cand2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        // Pass 2: verify
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == cand1) count1++;
            else if (num == cand2) count2++;
        }

        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        if (count1 > n/3) res.add(cand1);
        if (count2 > n/3) res.add(cand2);

        return res;
    }
}