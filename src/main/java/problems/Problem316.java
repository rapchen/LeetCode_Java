package problems;

/**
 * 316. 去除重复字母
 * @difficulty H
 * @status TODO WA
 * @author Chen Runwen
 * @time 2020/4/25 10:27
 */
public class Problem316 {
    public String removeDuplicateLetters(String s) {
        char[] cs = s.toCharArray();
        // 维护一个栈。先从后向前遍历，如果遇到新字母，就压入，否则仅当其比当前栈顶更小才压入
        char[] stack = new char[s.length()];
        int len = 0;
        int[] charPos = new int[58];  // 存放每个字母最后一次压入后栈的长度（不能存放栈顶位置，因为栈顶位置可能是0，跟初始值一样）
        for (int i = cs.length - 1; i >= 0; i--) {
            if (charPos[cs[i] - 65] == 0) {
                stack[len++] = cs[i];  // stack.push(cs[i])
                charPos[cs[i] - 65] = len;
            } else {
                if (cs[i] < stack[len - 1]) {
                    stack[len++] = cs[i];  // stack.push(cs[i])
                    charPos[cs[i] - 65] = len;
                }
            }
        }

        // 从栈顶开始往下读，每个字符都只取一次（这里当且仅当栈里的位置跟charPos里对应字符的位置相同，才是第一次取）
        StringBuilder sb = new StringBuilder();
        for (int i = len - 1; i >= 0; i--) {
            if (i == charPos[stack[i] - 65] - 1) {
                sb.append(stack[i]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
//        String s = "bcabc";
//        String s = "cbacdcbc";
        String s = "abacb";
//        String s = "bcanfdlwrbvkuahefbvkauyhdfbc";
//        String s = "bcanfdlaoikjuwhersgflkiajewrhflkjsdhbgjhkreabgkjurwehtbvkjseyrfghbvakjhyfgaksjldhfijaeygfkruyfgfadsmjhfgvcjhaswerbfvkiuaywecgkuaycvbakjuseryhufvkajhyrsgfkuywrbvkuahefbvkauyhdfbc";
        System.out.println(new Problem316().removeDuplicateLetters(s));
    }
}
