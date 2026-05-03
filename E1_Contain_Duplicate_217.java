import java.util.Arrays;
import java.util.HashSet;

public class E1_Contain_Duplicate_217 {

    // 1 Brute Force Approach - O(n^2)
    public static boolean bruteForce(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    // 2 Sorting Approach - O(n log n)
    public static boolean sorting(int[] nums) {
        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }
        return false;
    }

    // 3 Optimal Approach (HashSet) - O(n)
    public static boolean optimal(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }

        return false;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 1};

        System.out.println("Brute Force: " + bruteForce(nums.clone()));
        System.out.println("Sorting: " + sorting(nums.clone()));
        System.out.println("Optimal (HashSet): " + optimal(nums.clone()));
    }
}