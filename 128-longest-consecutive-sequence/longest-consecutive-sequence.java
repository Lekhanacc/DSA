// class Solution {
//     public int longestConsecutive(int[] nums) {
//         if(nums.length==0){
//             return 0;
//         }
//         HashSet <Integer> set = new HashSet<>();
//         for(int num: nums){
//             set.add(num);
//         }
//         int longest =0;
//         for(int num:nums){
//             if(!set.contains(num-1)){
//                 int curNum = num;
//                 int count = 1;
//                 while(set.contains(curNum+1)){
//                     curNum++;
//                     count++;
//                 }
//                 longest = Math.max(longest,count);
//             }
//         }
//         return longest;
//     }
// }

import java.util.HashSet;

class Solution {
    public int longestConsecutive(int[] nums) {

        if (nums.length == 0) return 0;

        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int longest = 0;

        for (int num : nums) {

            // process only if num is still in set
            if (set.contains(num)) {

                set.remove(num);
                int count = 1;

                // check smaller numbers
                int left = num - 1;
                while (set.contains(left)) {
                    set.remove(left);
                    left--;
                    count++;
                }

                // check larger numbers
                int right = num + 1;
                while (set.contains(right)) {
                    set.remove(right);
                    right++;
                    count++;
                }

                longest = Math.max(longest, count);
            }
        }

        return longest;
    }
}
