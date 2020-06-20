package common.sort;

import java.util.Arrays;

public class Insert implements Sort{
    private Swap swap = Swap.getInstance();

    @Override
    public int swapTimes() {
        return swap.swapTimes;
    }

    @Override
    public void sort(int[] nums, int left, int right) {
        for (int i = 0; i < nums.length;i++) {
            for (int j = i+1;j< nums.length;j++) {
                if (nums[i] > nums[j]) {
                    swap.make(nums, i, j);
                }
            }
        }
    }

    private Insert() {}
    private static class InsertHolder {
        private static final Insert instance = new Insert();
    }
    public static Insert getInstance() {
        return InsertHolder.instance;
    }

}
