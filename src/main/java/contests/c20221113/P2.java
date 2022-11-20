package contests.c20221113;

/**
 * @author Chen Runwen
 * @difficulty
 * @status TODO
 * @time 2022/11/13 10:26
 */
public class P2 {
    public int gcd(int a, int b) {
        if (b==0) return a;
        return gcd(b,a%b);
    }

    public int subarrayLCM(int[] nums, int k) {
        int n = nums.length, ans = 0;
        for (int i = 0; i < n; i++) {
            int bei = nums[i];
            for (int j = i; j < n; j++) {
                bei = nums[j] / gcd(bei, nums[j]) * bei;
                if (bei > k) break;
                if (bei == k) ans ++;
            }
        }
        return ans;
    }
}
