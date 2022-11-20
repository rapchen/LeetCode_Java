package contests.c20221112;

/**
 * @author Chen Runwen
 * @difficulty
 * @status TODO
 * @time 2022/11/12 22:53
 */
public class P4 {
    public String[] splitMessage(String message, int limit) {
        int num_len_sum = 0, msg_len = message.length();
        // i: 分隔组数
        for (int i = 1; i <= message.length(); i++) {
            int num_len = String.valueOf(i).length();
            num_len_sum += num_len;
            int total_len = msg_len + num_len_sum + (num_len + 3) * i;
            int remain = total_len - limit * (i-1);
            if (remain <= limit && remain >= num_len * 2 + 3) {
                String[] res = new String[i];
                int p = 0, len;
                for (int j = 1; j < i; j++) {
                    len = limit - (String.valueOf(j).length() + num_len + 3);
                    res[j-1] = message.substring(p, p+len) + '<' + j + '/' + i + '>';
                    p = p+len;
                }
                res[i-1] = message.substring(p) + '<' + i + '/' + i + '>';
                return res;
            }
        }
        return new String[]{};
    }
}
