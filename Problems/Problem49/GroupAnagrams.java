//----------------------------------------------------------------------------------------------------------------------
//  49. Group Anagrams
//
//  Given an array of strings strs, group the anagrams together. You can return the answer in any order.
//
//  Example 1:
//    Input: strs = ["eat","tea","tan","ate","nat","bat"]
//    Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
//    Explanation:
//    There is no string in strs that can be rearranged to form "bat".
//    The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
//    The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.
//----------------------------------------------------------------------------------------------------------------------

package Problem49;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        List<List<String>> groupAnagrams = groupAnagrams(strs);

        for (List<String> list : groupAnagrams) {
            System.out.println(list);
        }
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramMap = new HashMap<>();

        for (String s : strs) {
            // Create new string with sorted characters
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);

            // Add anagram to its corresponding list
            if (!anagramMap.containsKey(sorted)) {
                anagramMap.put(sorted, new ArrayList<>());
            }

            anagramMap.get(sorted).add(s);
        }

        return new ArrayList<>(anagramMap.values());
    }
}
