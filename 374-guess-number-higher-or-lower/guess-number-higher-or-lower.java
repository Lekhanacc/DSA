/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int left = 1;
        int right = n;
        
        while (left <= right) {
            // Safe midpoint calculation to prevent integer overflow
            int mid = left + (right - left) / 2;
            int res = guess(mid);
            
            if (res == 0) {
                // Found the correct number!
                return mid; 
            } else if (res == -1) {
                // Your guess is higher than the picked number, search the left half
                right = mid - 1;
            } else {
                // Your guess is lower than the picked number, search the right half
                left = mid + 1;
            }
        }
        
        return -1;
    }
}
