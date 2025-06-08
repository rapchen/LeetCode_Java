package contests.c20241222;

import java.util.Objects;

/**
 * 6244. 完美分割的方案数
 * @author Chen Runwen
 * @difficulty H
 * @status AC
 * @time 2022/11/20 11:23
 */
public class P4 {
    public static class Pair {
        int num;
        int cnt;

        public Pair(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return num == pair.num && cnt == pair.cnt;
        }

        @Override
        public int hashCode() {
            return Objects.hash(num, cnt);
        }
    }


    public static void main(String[] args) {
        int kx = 0;
        int ky = 2;
        int[][] positions = new int[][]{{1,1},{2,2},{3,3}};
//        System.out.println(new P4().maxMoves(kx, ky, positions));
    }
}
