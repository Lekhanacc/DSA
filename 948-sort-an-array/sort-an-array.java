import java.util.Arrays;    
class Solution{
    public int[] sortArray(int[] nums){
        sort(nums,0,nums.length-1);
        return nums;     
    }
    private void sort(int[] nums,int low,int high){
        if (low >= high) {
            return;
        }
        int s = low;
        int e = high;
        int m = s + (e - s) / 2;
        int pivot = nums[m];

        while (s <= e) {
            while (nums[s] < pivot) {
                s++;
            }
            while (nums[e] > pivot) {
                e--;
            }
            if (s <= e) {
                int temp = nums[s];
                nums[s] = nums[e];
                nums[e] = temp;
                s++;
                e--;
            }
        }

        // Pivot is NOT guaranteed to be at correct index (Hoare partition)
        sort(nums, low, e);
        sort(nums, s, high);
    }
}


// import java.util.Arrays;     (MERGE SORT)
// class Solution{
//     public int[] sortArray(int[] nums){
//         if(nums.length<=1){
//             return nums;
//         }
//         int mid = nums.length/2;
//         int[] left=sortArray(Arrays.copyOfRange(nums,0,mid));
//         int[] right=sortArray(Arrays.copyOfRange(nums,mid,nums.length));
//         return merge(left,right);
//     }
//     private int[] merge(int[] first,int[] second){
//         int[] mix= new int[first.length+second.length];
//         int i=0;
//         int j=0;
//         int k=0;
//         while(i<first.length&&j<second.length){
//             if(first[i]<second[j]){
//                 mix[k]=first[i];
//                 i++;
//             }else{
//                 mix[k]=second[j];
//                 j++;
//             }
//             k++;
//         }
//         while(i<first.length){
//             mix[k]=first[i];
//             i++;
//             k++;
//         }
//         while(j<second.length){
//             mix[k]=second[j];
//             j++;
//             k++;
//         }
//         return mix;
//     }
// } 


// import java.util.Arrays;          (BUBBLE SORT)
// class Solution {
//     public void main(String[] args){
//         int[] arr = {5,1,1,2,0,0};
//         sortArray(arr);
//         System.out.println(Arrays.toString(arr));
//     }
//     public int[] sortArray(int[] arr) {
//         int n = arr.length;
//         for(int i =0;i<n;i++) {
//             int min = i;
//             for (int j = i + 1; j < n; j++) {
//                 if (arr[j] < arr[min]) {
//                     min = j;
//                 }
//             }
//             int temp = arr[min];
//             arr[min] = arr[i];
//             arr[i] = temp;
//         }
//         return arr;
//     }
// }
