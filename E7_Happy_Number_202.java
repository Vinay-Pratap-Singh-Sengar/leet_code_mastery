public class E7_Happy_Number_202 {

    /*
     * A number is happy if:
     * Replace number with sum of squares of digits repeatedly
     * If it becomes 1 → Happy
     * If it loops → Not Happy
     */

    public static boolean isHappy(int n) {

        // Use set to detect cycle
        java.util.HashSet<Integer> set = new java.util.HashSet<>();

        while (n != 1) {

            if (set.contains(n)) {
                return false; // loop detected
            }

            set.add(n);

            int sum = 0;

            // Sum of squares of digits
            while (n > 0) {
                int digit = n % 10;
                sum += digit * digit;
                n = n / 10;
            }

            n = sum;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(19)); // true
        System.out.println(isHappy(2));  // false
    }
}