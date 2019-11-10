package problems;

/**
 * 85. Maximal Rectangle
 * @author Chen Runwen
 * @time 2019/11/10 11:14
 */
public class Problem85 {
    /**
     * P84的答案
     */
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) return 0;
        if (heights.length == 1) return heights[0];

        // 存每个柱子对应矩形的左边界
        int[] left = new int[heights.length];
        // 这个栈用来存可能的左边界。如果一个柱子右边有柱子比它更高，那么他就不是可能的左边界了，所以这个栈里的元素是递增的。
        int[] stack = new int[heights.length + 1];
        stack[0] = -1;
        int stackTop = 0;
        for (int i = 0; i < heights.length; i++) {
            while (stack[stackTop] >= 0 && heights[stack[stackTop]] >= heights[i]) {
                stackTop --;
            }
            left[i] = stack[stackTop];
//            System.out.printf("%d ", left[i]);

            stackTop ++;
            stack[stackTop] = i;
        }

//        System.out.println("\n---");

        // 求右边界，不存，直接算max
        int max = 0;
        stack[0] = heights.length;
        stackTop = 0;
        for (int i = heights.length - 1; i >= 0; i--) {
            while (stack[stackTop] < heights.length && heights[stack[stackTop]] >= heights[i]) {
                stackTop --;
            }
//            System.out.printf("%d ", stack[stackTop]);

            max = Math.max(max, (stack[stackTop] - left[i] - 1) * heights[i]);
            stackTop ++;
            stack[stackTop] = i;
        }
//        System.out.println("\n---");
        return max;
    }

    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        int nrow = matrix.length;
        int ncol = matrix[0].length;

        int[] hist = new int[ncol];
        int max = 0;
        for (char[] chars : matrix) {
            for (int j = 0; j < ncol; j++) {
                hist[j] = chars[j] == '0' ? 0 : hist[j] + 1;
            }
            max = Math.max(max, largestRectangleArea(hist));
        }
        return max;
    }


    public static void main(String[] args) {
//        char[][] matrix = new char[4][5];
//        matrix[0] = new char[] {49,48,49,48,48};
//        matrix[1] = new char[] {49,48,49,49,49};
//        matrix[2] = new char[] {49,49,49,49,49};
//        matrix[3] = new char[] {49,48,48,49,48};

        char[][] matrix = new char[2][2];
        matrix[0] = new char[] {48,49};
        matrix[1] = new char[] {49,48};

        System.out.println(new Problem85().maximalRectangle(matrix));
    }
}
