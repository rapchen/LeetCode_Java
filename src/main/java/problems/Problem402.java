package problems;

import java.util.LinkedList;

/**
 * 402. 移掉K位数字
 * @difficulty M
 * @status AC 100% 7%
 * @author Chen Runwen
 * @time 2020/4/25 17:27
 */
public class Problem402 {
    /** 从左向右遍历，每次把相邻两个数中间较小的去除，左边留一串相同数字：WA */
    public String removeKdigits1(String num, int k) {
        char[] nums = num.toCharArray();
        int p = 1; // 当前遍历到的位置
        char leftNum = nums[0]; // 保存当前遍历位置左边的数字大小
        int leftCount = 1; // 保存当前遍历位置左边数字的个数
//        char[] stack = new char[nums.length]; // 存放当前遍历位置左边保留的数字

        for (int i = 0; i < k; i++) {
            if (p == nums.length) {
                leftCount--;
            } else if (nums[p] > leftNum) {
                p++;
            } else if (nums[p] == leftNum) {
                leftCount++;
                p++;
                i--;
            } else {
                if (leftCount > 1) leftCount--;
                else {
                    leftNum = nums[p];
                    p++;
                }
            }
        }

        // 输出
        StringBuilder out = new StringBuilder();
        if (leftNum != '0') {
            for (int i = 0; i < leftCount; i++) {
                out.append(leftNum);
            }
        }
        while (p < nums.length && nums[p] == 0) p++;
        if (p < nums.length) out.append(num.substring(p));
        else if (out.length() == 0) out.append('0');
        return out.toString();
    }

    /** 从左向右遍历，比左边大的数依次压入栈，比左边小则弹出栈: 100.00% 7.69% */
    public String removeKdigits2(String num, int k) {
        char[] a = num.toCharArray();
        char[] stack = new char[a.length];
        int size = 0; // 栈的高度
        int deleted = 0; // 被删除的数的个数
        int i;

        for (i = 0; i < a.length; i++) {
            while (size > 0 && stack[size - 1] > a[i] && deleted < k) {
                size--;
                deleted++;
            }
            if (deleted >= k) break;
            stack[size++] = a[i];
        }

        // 输出
        StringBuilder out = new StringBuilder();
        for (int j = 0; j < size && j < a.length - k; j++)
            if (stack[j] != '0')
                out.append(stack[j]);
        if (size == 0 || stack[size - 1] == '0')
            while (i < a.length && a[i] == '0') i++;
        out.append(num.substring(i));
        if (out.length() == 0) out.append('0');
        return out.toString();
    }

    /** 把栈改成用LinkedList存 */
    public String removeKdigits(String num, int k) {
        LinkedList<Character> stack = new LinkedList<>();

        for (char c : num.toCharArray()) {
            while (stack.size() > 0 && k > 0 && stack.getLast() > c) {
                stack.removeLast();
                k--;
            }
            stack.addLast(c);
        }
        for (int i = 0; i < k; i++) {
            stack.removeLast();
        }

        // 输出
        StringBuilder out = new StringBuilder();
        boolean leadingZero = true;
        for (Character c : stack) {
            if (leadingZero && c == '0') continue;
            leadingZero = false;
            out.append(c);
        }
        if (out.length() == 0) return "0";
        return out.toString();
    }

    public static void main(String[] args) {
//        String num = "1432219";
//        String num = "1000019";
//        String num = "1002019";
//        String num = "100";
        String num = "10200";
//        String num = "1107";
//        String num = "9";
        int k = 1;
        System.out.println(new Problem402().removeKdigits(num, k));
    }
}
