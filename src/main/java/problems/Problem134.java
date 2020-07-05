package problems;

/**
 * 134. 加油站
 * @difficulty M
 * @status AC
 * @author Chen Runwen
 * @time 2020/4/18 19:23
 */
public class Problem134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0, remain = 0, sum = 0;
        for (int i = 0; i < gas.length; i++) {
            remain += gas[i] - cost[i];
            if (remain < 0) {
                start = i + 1;
                sum += remain;
                remain = 0;
            }
        }
        sum += remain;
        return sum >= 0 ? start : -1;
    }

    public static void main(String[] args) {
        int[] gas = {2,3,4};
        int[] cost = {3,4,3};
//        int[] gas = {1,2,3,4,5};
//        int[] cost = {3,4,5,1,2};
        System.out.println(new Problem134().canCompleteCircuit(gas, cost));
    }
}
