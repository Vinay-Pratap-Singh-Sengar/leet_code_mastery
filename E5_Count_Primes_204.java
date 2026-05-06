public class E5_Count_Primes_204 {

    /*
     * =========================================================
     * 🔹 Problem: Count Primes (LeetCode 204)
     * =========================================================
     *
     * Given an integer n, return the number of prime numbers
     * strictly less than n.
     *
     * ---------------------------------------------------------
     * Example:
     * Input: n = 10
     * Output: 4
     *
     * Explanation:
     * Prime numbers less than 10 → 2, 3, 5, 7
     * Count = 4
     * ---------------------------------------------------------
     */

    /*
     * =========================================================
     * 🔹 Approach: Brute Force (Check each number)
     * =========================================================
     *
     * Step 1: Loop from 2 to n-1
     * Step 2: Check if each number is prime
     * Step 3: If prime → increase count
     *
     * ---------------------------------------------------------
     * How to check prime?
     * A number is prime if it is divisible only by 1 and itself.
     *
     * Optimization:
     * Instead of checking till i/2, check till √i
     *
     * Time Complexity: O(n √n)
     * Space Complexity: O(1)
     */

    public static int countPrimes(int n) {

        int count = 0; // stores number of primes

        // Step 1: Check numbers from 2 to n-1
        for (int i = 2; i < n; i++) {

            boolean isPrime = true; // assume i is prime

            /*
             * Step 2: Check divisibility
             * If i is divisible by any number from 2 to √i,
             * then it is NOT prime
             */
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    isPrime = false; // not prime
                    break;
                }
            }

            // Step 3: If prime → increase count
            if (isPrime) {
                count++;
            }
        }

        return count;
    }

    /*
     * =========================================================
     * 🔹 Main Method (Driver Code for Teaching)
     * =========================================================
     */
    public static void main(String[] args) {

        int[] testCases = {10, 0, 1, 20, 100};

        for (int n : testCases) {
            System.out.println("n = " + n +
                    " → Count of Primes: " + countPrimes(n));
        }
    }
}