package common.sort;

import java.util.Arrays;

public class Swap {
    private static Swap instance;
    public int swapTimes = 0;

    public void make(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }
        swapTimes++;
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
        System.out.println("交换：" + i + "与" + j + Arrays.toString(nums));
    }

    private Swap() {
    }

    public static Swap getInstance() {
        if (instance == null) {
            synchronized (Swap.class) {
                instance = new Swap();
            }
        }
        return instance;
    }
}
