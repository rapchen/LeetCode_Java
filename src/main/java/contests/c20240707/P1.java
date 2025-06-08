package contests.c20240707;

/**
 * 6241. 数组中不等三元组的数目
 * @author Chen Runwen
 * @difficulty E
 * @status AC
 * @time 2022/11/20 10:32
 */
public class P1 {
    public String getEncryptedString(String s, int k) {
        char[] chars = s.toCharArray();
        char[] newChars = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            newChars[i] = chars[(i + k) % chars.length];
        }
        return new String(newChars);
    }
}
