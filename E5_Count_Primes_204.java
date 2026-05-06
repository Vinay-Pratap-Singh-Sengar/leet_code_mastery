public class E5_Count_Primes_204 {

    /*
     * =========================================================
     * 🔹 Problem: Count Primes (LeetCode 204)
     * =========================================================
     *
     * Given an integer n, return the number of prime numbers
     * strictly less than n.
     *
     * Example:
     * Input: n = 10
     */

    public static int countPrimes(int n) {


        for (int i = 2; i < n; i++) {

        /*
         */
            }
        }

                count++;
            }
        }

        return count;
    }

    /*
     * =========================================================
     * =========================================================
     */
    public static void main(String[] args) {


        for (int n : testCases) {
            System.out.println("n = " + n +
                    " → Count of Primes: " + countPrimes(n));
        }
    }
}