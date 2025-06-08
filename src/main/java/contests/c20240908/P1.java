package contests.c20240908;

/**
 * 6241. 数组中不等三元组的数目
 * @author Chen Runwen
 * @difficulty E
 * @status AC
 * @time 2022/11/20 10:32
 */
public class P1 {
    public String convertDateToBinary(String date) {
        String y = Integer.toBinaryString(Integer.parseInt(date.substring(0, 4)));
        String m = Integer.toBinaryString(Integer.parseInt(date.substring(5, 7)));
        String d = Integer.toBinaryString(Integer.parseInt(date.substring(8, 10)));
        return y + "-" + m + "-" + d;
    }

    public static void main(String[] args) {
        new P1().convertDateToBinary("2080-02-29");
    }
}
