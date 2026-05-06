import java.util.Arrays;
import java.util.HashMap;

public class E2_Valid_Anagram_242 {

    /*
     * 1. Sorting Approach
     * --------------------
     * Idea:
     * - Convert both strings to char arrays
     * - Sort both arrays
     * - If sorted arrays are equal → anagram
     *
     * Time Complexity: O(n log n) (due to sorting)
     * Space Complexity: O(1) (ignoring sorting space)
     */
    public static boolean sorting(String s, String t) {
        // If lengths are different, cannot be anagrams
        if (s.length() != t.length()) return false;

        // Convert strings to character arrays
        char[] a = s.toCharArray();
        char[] b = t.toCharArray();

        // Sort both arrays
        Arrays.sort(a);
        Arrays.sort(b);

        // Compare sorted arrays
        return Arrays.equals(a, b);
    }


    /*
     * 2. Frequency Array Approach (Optimal ⭐)
     * ---------------------------------------
     * Idea:
     * - Use an array of size 26 (for lowercase letters)
     * - Increment count for string 's'
     * - Decrement count for string 't'
     * - If all values are 0 → anagram
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1) (fixed size array)
     */
    public static boolean frequencyArray(String s, String t) {
        // If lengths differ, not anagrams
        if (s.length() != t.length()) return false;

        // Frequency array for 26 lowercase letters
        int[] count = new int[26];

        // Traverse both strings together
        for (int i = 0; i < s.length(); i++) {
            // Increase count for character in s
            count[s.charAt(i) - 'a']++;

            // Decrease count for character in t
            count[t.charAt(i) - 'a']--;
        }

        // Check if all counts are zero
        for (int c : count) {
            if (c != 0) {
                return false; // mismatch found
            }
        }

        return true; // all matched
    }


    /*
     * 3. HashMap Approach (For Unicode / General Case)
     * ------------------------------------------------
     * Idea:
     * - Store frequency of each character using HashMap
     * - Decrease frequency while traversing second string
     * - If any mismatch → return false
     * - If map becomes empty → anagram
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static boolean hashMapApproach(String s, String t) {
        // Length mismatch check
        if (s.length() != t.length()) return false;

        // Map to store character frequency
        HashMap<Character, Integer> map = new HashMap<>();

        // Step 1: Count frequency of characters in string s
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Step 2: Decrease frequency using string t
        for (char c : t.toCharArray()) {

            // If character not found → not an anagram
            if (!map.containsKey(c)) return false;

            // Decrease count
            map.put(c, map.get(c) - 1);

            // Remove character if count becomes zero
            if (map.get(c) == 0) {
                map.remove(c);
            }
        }

        // If map is empty → all characters matched
        return map.isEmpty();
    }


    /*
     * Main Method (Driver Code)
     * -------------------------
     * Used to test all approaches
     */
    public static void main(String[] args) {

        String s = "anagram";
        String t = "nagaram";

        System.out.println("Sorting: " + sorting(s, t));
        System.out.println("Frequency Array: " + frequencyArray(s, t));
        System.out.println("HashMap: " + hashMapApproach(s, t));
    }
}