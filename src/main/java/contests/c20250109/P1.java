package contests.c20250109;

/**
 * 6241. 数组中不等三元组的数目
 * @author Chen Runwen
 * @difficulty E
 * @status AC
 * @time 2022/11/20 10:32
 */
public class P1 {
    public int subarraySum(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = Math.max(0, i - nums[i]); j <= i; j++) {
                sum += nums[j];
            }
        }
        return sum;
    }

//    public static void main(String[] args) {
//        new P1().minimumSumSubarray(List.of(7,3), 2,2);
//    }
}
