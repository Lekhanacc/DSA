class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        
        while (columnNumber > 0) {
            // Shift to 0-indexed range (0 = A, 25 = Z)
            columnNumber--; 
            
            // Get the current character from right to left
            int remainder = columnNumber % 26;
            sb.append((char) ('A' + remainder));
            
            // Move to the next position
            columnNumber /= 26;
        }
        
        // The characters were added right-to-left, so reverse the final string
        return sb.reverse().toString();
    }
}
