package problems.bitManipulation;

/**
 * 318. 最大单词长度乘积
 * @author Chen Runwen
 * @difficulty M
 * @status AC 99% 20%
 * @time 2020/7/12 22:13 - 22:28
 */
public class Problem318 {
    /** 预计算每个字符串对应的bitmap，99% 20% */
    public int maxProduct(String[] words) {
        int max = 0, n = words.length;
        int[] bitmap = new int[n], len = new int[n];
        for (int i = 0; i < n; i++) {
            len[i] = words[i].length();
            for (char c : words[i].toCharArray()) bitmap[i] |= 1 << (c - 97);
            for (int j = 0; j < i; j++) {
                if ((bitmap[i] & bitmap[j]) == 0)
                    max = Math.max(max, len[i] * len[j]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String[] words = new String[]{"abcw","baz","foo","bar","xtfn","abcdef"};
        System.out.println(new Problem318().maxProduct(words));
    }
}
