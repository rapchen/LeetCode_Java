package problems;

import java.util.Stack;

/**
 * 84. Largest Rectangle in Histogram
 * @author Chen Runwen
 * @time 2019/11/3 16:36
 */
public class Problem84 {
    /**
     * 最初的做法，O(N)
     * 从左往右依次计算每个柱子的左边第一个比它低的柱子在哪，这也就是以该柱子为高度的矩形的左边界
     */
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) return 0;
        if (heights.length == 1) return heights[0];

        // 存每个柱子对应矩形的左边界
        int[] left = new int[heights.length];
        // 这个栈用来存可能的左边界。如果一个柱子右边有柱子比它更高，那么他就不是可能的左边界了，所以这个栈里的元素是递增的。
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() >= 0 && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            left[i] = stack.peek();
//            System.out.printf("%d ", left[i]);

            stack.push(i);
        }

//        System.out.println("\n---");

        // 求右边界，不存，直接算max
        int max = 0;
        stack = new Stack<>();
        stack.push(heights.length);
        for (int i = heights.length - 1; i >= 0; i--) {
            while (stack.peek() < heights.length && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
//            System.out.printf("%d ", stack.peek());

            max = Math.max(max, (stack.peek() - left[i] - 1) * heights[i]);
            stack.push(i);
        }
//        System.out.println("\n---");
        return max;
    }

    /**
     * 手撸个栈看看
     */
    public int largestRectangleArea2(int[] heights) {
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

    public static void main(String[] args) {
//        int[] heights = {2,1,5,6,2,3};
        int[] heights = {2,4};
        System.out.println(new Problem84().largestRectangleArea2(heights));
    }

}
