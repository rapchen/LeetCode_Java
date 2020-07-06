package problems;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * @author Chen Runwen
 * @difficulty M
 * @status AC 100% 5%
 * @time 2020/7/5 12:06 - 12:41
 */
public class Problem22 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        char[] c = new char[n * 2];
        recurse(n, 0, 0, c, res);
        return res;
    }

    /**
     * 递归函数
     * @param p 当前位置
     * @param leftNum 当前已经放入的左括号数量
     * @param c 当前的括号数组
     * @param res 结果集
     */
    private void recurse(int n, int p, int leftNum, char[] c, List<String> res) {
        // 先放一个左括号
        c[p++] = '(';
        leftNum++;

        // 如果已经放入了最后一个左括号，就直接把右边填满右括号然后返回
        if (leftNum == n) {
            while (p < n * 2) c[p++] = ')';
            res.add(String.valueOf(c));
            return;
        }

        // 否则，遍历在当前位置插入0-leftNum个连续右括号的情形
        recurse(n, p, leftNum, c, res);
        while (p < 2 * leftNum) {
            c[p++] = ')';
            recurse(n, p ,leftNum, c, res);
        }
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(new Problem22().generateParenthesis(n));
    }
}
