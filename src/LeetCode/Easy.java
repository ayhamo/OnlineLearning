package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Easy {
    public static void main(String[] args) {
        //System.out.println(Arrays.toString((twoSum1(new int[]{2, 7, 11, 15}, 9))));

        //System.out.println(isPalindrome9(121));

        //System.out.println(romanToInt13("III"));

        //System.out.println(longestCommonPrefix14(new String[]{"flower", "flow", "flight"}));

        //System.out.println(ValidParentheses20("([)]"));

        //ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4,null)));
        //ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4,null)));
        //System.out.println(mergeTwoLists21(list1,list2));

        //System.out.println(removeDuplicates26(new int[]{1,1,2}));

        //System.out.println(removeElement27(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2));

        //*System.out.println(searchInsert35(new int[]{1,3,5,6},5));

        //System.out.println(lengthOfLastWord58("   fly me   to   the moon  "));

        //System.out.println(Arrays.toString(plusOne66(new int[]{9, 9, 9, 9})));
    }

    public static int[] twoSum1(int[] nums, int target) {
        int[] ind = new int[2]; //only 2 index results

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (j != i) {
                    if (nums[i] + nums[j] == target) {
                        ind[0] = j;
                        ind[1] = i;
                    }
                }
            }
        }
        return ind;
    }

    public static int[] twoSum1_ver2(int[] numbers, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                result[1] = i;
                result[0] = map.get(target - numbers[i]);
                return result;
            }
            map.put(numbers[i], i);
        }
        return result;
    }

    /*--------------------------------------------------------------------*/

    public static boolean isPalindrome9(int x) {
        String s = String.valueOf(x); //convert int to string
        String reverse = "";
        char ch;

        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i); //extracts each character
            reverse = ch + reverse; //adds each character in front of the existing string
        }

        return (reverse.equals(s));
    }

    /*--------------------------------------------------------------------*/

    public static int romanToInt13(String s) {
        final String[] ROMAN = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        final int[] ARABIC = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String remaining = s;
        int result = 0;

        for (int i = 0; i < ROMAN.length; i++) {
            while (remaining.startsWith(ROMAN[i])) {
                remaining = remaining.substring(ROMAN[i].length());
                result += ARABIC[i];
            }
        }
        return result;


    }

    /*--------------------------------------------------------------------*/

    public static String longestCommonPrefix14(String[] strs) {
        String prefix = strs[0];
        for (int index = 1; index < strs.length; index++) {
            while (strs[index].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;

    }

    /*--------------------------------------------------------------------*/

    public static boolean ValidParentheses20(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            if (a == '(' || a == '[' || a == '{') stack.push(a);
            else if (stack.empty()) return false;
            else if (a == ')' && stack.pop() != '(') return false;
            else if (a == ']' && stack.pop() != '[') return false;
            else if (a == '}' && stack.pop() != '{') return false;
        }
        return stack.empty();
    }

    /*--------------------------------------------------------------------*/

    public static ListNode mergeTwoLists21(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        if (list1.val < list2.val) {
            list1.next = mergeTwoLists21(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists21(list1, list2.next);
            return list2;
        }
    }

    /*--------------------------------------------------------------------*/

    public static int removeDuplicates26(int[] nums) {
        int i = 0;
        for (int n : nums)
            if (i == 0 || n > nums[i - 1]) //first check is for first element check
                nums[i++] = n;
        return i;
    }

    /*--------------------------------------------------------------------*/

    public static int removeElement27(int[] nums, int val) {
        int index = 0;
        for (int ele : nums) {
            if (ele != val) {
                nums[index++] = ele;
            }
        }
        return index;
    }

    /*--------------------------------------------------------------------*/

    public static int searchInsert35(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;

        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while (left < right) {
            int mid = left + (right - left) / 2; //middle index, avoid overflow rather than "m = (l + r)/2"

            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) right = mid; // right could be the result
            else left = mid + 1; // mid + 1 could be the result
        }

        // 1 element left at the end
        // post-processing
        return nums[left] < target ? left + 1 : left;
    }

    /*--------------------------------------------------------------------*/

    public static int lengthOfLastWord58(String s) {
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') { // a letter is found so count
                count++;
            } else {  // it's a white space instead
                //  Did we already started to count a word ? Yes so we found the last word
                if (count > 0) return count;
            }
        }
        return count;
    }

    /*--------------------------------------------------------------------*/

    public static int[] plusOne66(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] <= 8) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }

        int[] newNumber = new int[n + 1];
        newNumber[0] = 1;

        return newNumber;
    }
}


