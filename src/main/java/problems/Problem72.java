package problems;

import java.lang.Math;

/**
 * 72. Edit Distance
 * @author Chen Runwen
 * @time 2019/11/1 22:21
 */
public class Problem72 {

    /**
     * 最开始写的方法
     */
    public int minDistance(String word1, String word2) {
        if (word1.length() == 0) {
            return word2.length();
        }
        if (word2.length() == 0) {
            return word1.length();
        }

        // dist[j]: word1的前i+1个字母到word2的前j+1个字母的编辑距离
        int[] dist = new int[word2.length()];
        int[] last_dist;
        dist[0] = word1.charAt(0) == word2.charAt(0) ? 0 : 1;
        for (int j = 1; j < word2.length(); j++) {
            dist[j] = Math.min(dist[j-1] + 1, j + (word1.charAt(0) == word2.charAt(j) ? 0 : 1));
        }

        for (int i = 1; i < word1.length(); i++) {
            last_dist = dist;
            dist = new int[word2.length()];
            dist[0] = Math.min(last_dist[0] + 1, i + (word1.charAt(i) == word2.charAt(0) ? 0 : 1));
            for (int j = 1; j < word2.length(); j++) {
                dist[j] = last_dist[j - 1] + (word1.charAt(i) == word2.charAt(j) ? 0 : 1);
                dist[j] = Math.min(dist[j], Math.min(last_dist[j], dist[j - 1]) + 1);
            }

        }
        return dist[word2.length() - 1];
    }

    /**
     * 改成char试试看
     */
    public int minDistanceChar(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();

        if (len1 == 0) {
            return len2;
        }
        if (len2 == 0) {
            return len1;
        }

        // dist[j]: word1的前i+1个字母到word2的前j+1个字母的编辑距离
        int[] dist = new int[len2];
        int[] last_dist;  // TODO: 2019/11/2 这里可以把两个数组优化成一个，加一个tmp存左上角的格子，省空间
        dist[0] = chars1[0] == chars2[0] ? 0 : 1;
        for (int j = 1; j < len2; j++) {
            dist[j] = Math.min(dist[j-1] + 1, j + (chars1[0] == chars2[j] ? 0 : 1));
        }

        for (int i = 1; i < len1; i++) {
            last_dist = dist;
            dist = new int[len2];
            dist[0] = Math.min(last_dist[0] + 1, i + (chars1[i] == chars2[0] ? 0 : 1));
            for (int j = 1; j < len2; j++) {
                dist[j] = last_dist[j - 1] + (chars1[i] == chars2[j] ? 0 : 1);
                dist[j] = Math.min(dist[j], Math.min(last_dist[j], dist[j - 1]) + 1);
            }

        }
        return dist[len2 - 1];
    }

    /**
     * 添加debug输出的测试方法
     */
    public int minDistanceTest(String word1, String word2) {
        if (word1.length() == 0) {
            return word2.length();
        }
        if (word2.length() == 0) {
            return word1.length();
        }

        // dist[j]: word1的前i+1个字母到word2的前j+1个字母的编辑距离
        int[] dist = new int[word2.length()];
        int[] last_dist;
        dist[0] = word1.charAt(0) == word2.charAt(0) ? 0 : 1;
        for (int j = 1; j < word2.length(); j++) {
            dist[j] = Math.min(dist[j-1] + 1, j + (word1.charAt(0) == word2.charAt(j) ? 0 : 1));
        }

        for (int j = 0; j < word2.length(); j++) {
            System.out.printf("%d ", dist[j]);
        }
        System.out.print("\n");

        for (int i = 1; i < word1.length(); i++) {
            last_dist = dist;
            dist = new int[word2.length()];
            dist[0] = Math.min(last_dist[0] + 1, i + (word1.charAt(i) == word2.charAt(0) ? 0 : 1));
            for (int j = 1; j < word2.length(); j++) {
                dist[j] = last_dist[j - 1] + (word1.charAt(i) == word2.charAt(j) ? 0 : 1);
                dist[j] = Math.min(dist[j], Math.min(last_dist[j], dist[j - 1]) + 1);
            }

            for (int j = 0; j < word2.length(); j++) {
                System.out.printf("%d ", dist[j]);
            }
            System.out.print("\n");

        }
        return dist[word2.length() - 1];
    }

    public static void main(String[] args) {
        String word1 = "sea", word2 = "eat";
        System.out.println(new Problem72().minDistanceChar(word1, word2));
    }

}
