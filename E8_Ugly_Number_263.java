public class E8_Ugly_Number_263 {

    /*
     * Ugly number → only prime factors are 2, 3, 5
     */

    public static boolean isUgly(int n) {

        if (n <= 0) return false;

        int[] factors = {2, 3, 5};

        for (int f : factors) {
            while (n % f == 0) {
                n = n / f;
            }
        }

        return n == 1;
    }

    public static void main(String[] args) {
        System.out.println(isUgly(6));  // true
        System.out.println(isUgly(14)); // false
    }
}