package LeetCode;

import com.sun.source.tree.Tree;

import java.util.*;

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

        //System.out.println(addBinary67("1010", "1011"));

        //System.out.println(mySqrt69(2147395600));

        //System.out.println(climbStairs70(3));

        //ListNode list3 = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3)))));
        //System.out.println(deleteDuplicates83(list3));

        //merge88(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);

        //TreeNode tree = new TreeNode(1, null, new TreeNode(2, new TreeNode(3, null, null), null));
        //System.out.println(inorderTraversal94(tree));
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

    /*--------------------------------------------------------------------*/

    public static String addBinary67(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry; //if there is a carry from the last addition, add it to carry
            if (j >= 0) sum += b.charAt(j--) - '0'; //we subtract '0' to get the int value of the char from the ascii
            if (i >= 0) sum += a.charAt(i--) - '0';
            sb.append(sum % 2); //if sum==2 or sum==0 append 0 cause 1+1=0 in this case
            carry = sum / 2; //if sum==2 we have a carry, else no carry 1/2 rounds down to 0 in integer arithematic
        }
        if (carry != 0) sb.append(carry); //leftover carry, add it
        return sb.reverse().toString();
    }

    /*--------------------------------------------------------------------*/

    public static int mySqrt69(int x) {
        long r = x;
        while (r * r > x) {
            r = (r + x / r) / 2; //using integer division for the Newton method*

            //r = r -1; // (using linear search, descending), takes too much time on LeetCode
            //example: sqrt(27) = 5 because 6^2 > 27 and 5^2 !> 27
        }
        return (int) r;
    }

    /*--------------------------------------------------------------------*/

    public static int climbStairs70(int n) {
        // https://leetcode.com/problems/climbing-stairs/discuss/25299/Basically-it's-a-fibonacci.
        // 3 base cases, can be summed in the if below
        //if(n <= 0) return 0;
        //if(n == 1) return 1;
        //if(n == 2) return 2;
        if (n < 3)
            return n;

        int one_step_before = 2;
        int two_steps_before = 1;
        int all_ways = 0;

        for (int i = 2; i < n; i++) {
            all_ways = one_step_before + two_steps_before;
            two_steps_before = one_step_before;
            one_step_before = all_ways;
        }
        return all_ways;
    }

    /*--------------------------------------------------------------------*/

    public static ListNode deleteDuplicates83(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode list = head;
        while (list.next != null) {
            if (list.val == list.next.val)
                list.next = list.next.next;
            else
                list = list.next;
        }

        return head;
    }

    /*--------------------------------------------------------------------*/

    public static void merge88(int[] nums1, int m, int[] nums2, int n) {
        int tail1 = m - 1, tail2 = n - 1, finished = m + n - 1;
        while (tail1 >= 0 && tail2 >= 0) {
            nums1[finished--] = (nums1[tail1] > nums2[tail2]) ? nums1[tail1--] : nums2[tail2--];
        }

        while (tail2 >= 0) { //only need to combine with remaining nums2, if any
            nums1[finished--] = nums2[tail2--];
        }

        System.out.println(Arrays.toString(nums1));
    }

    /*--------------------------------------------------------------------*/

    public static List<Integer> inorderTraversal94(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while (cur != null || !stack.empty()) {
            while (cur != null) { //push all elements first then go to left ( in-order)
                stack.add(cur);
                cur = cur.left;
            }
            cur = stack.pop(); //then pop all element
            list.add(cur.val);
            cur = cur.right; // to handle left elements that were not in the stack
        }

        return list;
    }
}


