package contests.c20240818;

/**
 * 6241. 数组中不等三元组的数目
 * @author Chen Runwen
 * @difficulty E
 * @status AC
 * @time 2022/11/20 10:32
 */
public class P1 {
    public int minChanges(int n, int k) {
        char[] ns = Integer.toBinaryString(n).toCharArray();
        char[] ks = Integer.toBinaryString(k).toCharArray();


        int nl = ns.length;
        int kl = ks.length;
        if (nl < kl) return -1;

        int ans = 0;
        for (int i = 0; i < nl; i++) {
            if (i >= kl) {
                if (ns[nl-i-1] == '1') ans++;
            }
            else if (ks[kl-i-1] == '0' && ns[nl-i-1] == '1') ans++;
//            if (ks[kl-i-1] == ns[nl-i-1]) continue;
            else if (ks[kl-i-1] == '1' && ns[nl-i-1] == '0') return -1;
        }
        return ans;
    }

    public static void main(String[] args) {
        new P1().minChanges(54,4);
    }
}
