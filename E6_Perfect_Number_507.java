public class E6_Perfect_Number_507 {

    /*
     * =========================================================
     * 🔹 Problem: Perfect Number (LeetCode 507)
     * =========================================================
     *
     * A perfect number is a number that is equal to the sum
     * of its proper divisors (excluding itself).
     *
     * Example:
     * 28 → divisors: 1, 2, 4, 7, 14
     * sum = 28 → Perfect Number ✅
     */

    public static boolean checkPerfectNumber(int num) {

        // Edge case: 1 is NOT a perfect number
        if (num <= 1) return false;

        int sum = 0;

        /*
         * Step 1: Find all divisors from 1 to num/2
         * (excluding the number itself)
         */
        for (int i = 1; i <= num / 2; i++) {

            if (num % i == 0) {
                sum += i; // add divisor
            }
        }

        // Step 2: Compare sum with original number
        return sum == num;
    }

    /*
     * =========================================================
     * 🔹 Main Method (For Teaching / Testing)
     * =========================================================
     */
    public static void main(String[] args) {

        int[] testCases = {6, 28, 12, 1};

        for (int num : testCases) {
            System.out.println("Number: " + num +
                    " → Perfect? " + checkPerfectNumber(num));
        }
    }
}