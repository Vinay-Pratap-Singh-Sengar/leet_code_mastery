public class E3_Reverse_Integer_007 {

    /*
     * =========================================================
     * 🔹 Problem: Reverse Integer (LeetCode 7)
     * =========================================================
     *
     * Given a 32-bit signed integer, reverse its digits.
     *
     * If the reversed integer overflows, return 0.
     *
     * ---------------------------------------------------------
     * Example:
     * Input: 123     → Output: 321
     * Input: -123    → Output: -321
     * Input: 120     → Output: 21
     * ---------------------------------------------------------
     */

    /*
     * =========================================================
     * 🔹 Approach: Digit Extraction Method
     * =========================================================
     *
     * Step 1: Extract last digit → x % 10
     * Step 2: Add it to result → rev = rev * 10 + digit
     * Step 3: Remove last digit → x / 10
     *
     * ⚠️ Important: Handle overflow before updating result
     *
     * Time Complexity: O(log10(n))
     * Space Complexity: O(1)
     */

    public static int reverse(int x) {

        int rev = 0; // stores reversed number

        while (x != 0) {

            int digit = x % 10; // Step 1: extract last digit

            /*
             * Step 2: Check overflow BEFORE multiplying by 10
             *
             * Integer range:
             * MAX = 2147483647
             * MIN = -2147483648
             */
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && digit > 7)) {
                return 0;
            }

            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && digit < -8)) {
                return 0;
            }

            // Step 3: build reversed number
            rev = rev * 10 + digit;

            // Step 4: remove last digit from original number
            x = x / 10;
        }

        return rev;
    }

    /*
     * =========================================================
     * 🔹 Main Method (Driver Code for Teaching)
     * =========================================================
     */
    public static void main(String[] args) {

        // Test Cases (Explain one by one in class)
        int[] testCases = {123, -123, 120, 0, 1534236469};

        for (int num : testCases) {
            int result = reverse(num);
            System.out.println("Input: " + num + " → Reversed: " + result);
        }
    }
}