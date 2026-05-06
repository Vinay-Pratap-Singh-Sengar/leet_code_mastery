public class E4_Palindrome_Number_009 {

    /*
     * =========================================================
     * 🔹 Problem: Palindrome Number (LeetCode 9)
     * =========================================================
     *
     * Given an integer x, return true if x is a palindrome,
     * otherwise return false.
     *
     * A palindrome number reads the same forward and backward.
     *
     * ---------------------------------------------------------
     * Example:
     * Input: 121     → Output: true
     * Input: -121    → Output: false
     * Input: 10      → Output: false
     * ---------------------------------------------------------
     */

    /*
     * =========================================================
     * 🔹 Approach: Reverse the Number
     * =========================================================
     *
     * Step 1: Store original number
     * Step 2: Reverse the number
     * Step 3: Compare original with reversed
     *
     * ⚠️ Important:
     * - Negative numbers are NOT palindrome
     *
     * Time Complexity: O(log10(n))
     * Space Complexity: O(1)
     */

    public static boolean isPalindrome(int x) {

        // Negative numbers are not palindrome
        if (x < 0) return false;

        int original = x;   // Store original number
        int rev = 0;        // Store reversed number

        while (x != 0) {

            int digit = x % 10;   // Step 1: extract last digit

            rev = rev * 10 + digit; // Step 2: build reversed number

            x = x / 10;           // Step 3: remove last digit
        }

        // Step 4: Compare original and reversed
        return original == rev;
    }

    /*
     * =========================================================
     * 🔹 Main Method (Driver Code for Teaching)
     * =========================================================
     */
    public static void main(String[] args) {

        int[] testCases = {121, -121, 10, 1221, 123};

        for (int num : testCases) {
            System.out.println("Input: " + num +
                    " → Is Palindrome? " + isPalindrome(num));
        }
    }
}