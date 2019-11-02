package problems;

import java.util.Stack;

/**
 * 32. Longest Valid Parentheses
 * @author Chen Runwen
 * @date 2019/7/21
 */
public class Solution032 {

    /**
     * 这个是最初自己写的
     */
    public int longestValidParentheses(String s) {
        // 最大的连续合法括号的数量
        int max = 0;
        // 用于存储左括号位置的栈
        Stack<Integer> stack = new Stack<>();
        // 每层合法括号的起始ID列表
        int[] begin = new int[s.length()];
        // 当前合法括号层数
        int layer = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                // 左括号，压入栈
                stack.push(i);
                // 如果高于之前的层数，更新到合法括号列表
                if (stack.size() > layer) {
                    begin[layer] = i;
                    layer ++;
                }
            } else {
                if (!stack.empty()) {
                    // 如果之前左括号栈已经小于合法括号层数，就要减一层
                    if (stack.size() < layer) {
                        layer --;
                    }
                    stack.pop();
                    if (i - begin[layer - 1] + 1 > max) {
                        max = i - begin[layer - 1] + 1;
                    }
                } else {
                    // 如果栈已经空了，说明之前的括号跟之后无法合法相连
                    layer = 0;
                }
            }
        }
        return max;
    }

    /**
     * TODO 按最佳答案那个方法自己写下
     */
    public int longestValidParentheses2(String s) {
        return 0;
    }

    public static void main(String[] args) {
        String s = ")()())";
        System.out.println(new Solution032().longestValidParentheses(s));
    }
}
