package problems;

/**
 * 12. 整数转罗马数字
 * @author Chen Runwen
 * @difficulty M
 * @status AC 99% 9%
 * @time 2020/6/27 15:38 - 16:06
 */
public class Problem12 {
    /** 穷举，用SB比用String快很多 86% 5% */
    public String intToRoman1(int num) {
        String[] one = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String[] ten = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] hundred = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] thousand = {"", "M", "MM", "MMM"};
        return new StringBuilder(thousand[num / 1000])
                .append(hundred[num / 100 % 10])
                .append(ten[num / 10 % 10])
                .append(one[num % 10]).toString();
    }

    /** 贪心，平行数组 99% 9% */
    public String intToRoman(int num) {
        int[] keys = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] values = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < keys.length && num > 0; i++) {
            while (num >= keys[i]) {
                res.append(values[i]);
                num -= keys[i];
            }
        }
        return res.toString();
    }


    public static void main(String[] args) {
        int num = 3999;
        System.out.println(new Problem12().intToRoman(num));
    }
}
