package common.sort;

import java.util.Arrays;


public class SortTest {
    private boolean real = true;
    private void sort(int[] nums, Sort sortStratry) throws Exception {
        System.out.println("原始数组：" + Arrays.toString(nums));
        sortStratry.sort(nums, 0, nums.length - 1);
        for (int i=0;i < nums.length-1;i++) {
            if (nums[i] > nums[i+1]) {
                throw new Exception();
            }
        }
        System.out.println("交换次数：" + sortStratry.swapTimes());
        System.out.println("完成：" + Arrays.toString(nums));
        System.out.println();
    }

    public void test(Sort strategy) throws Exception {
        int[] a;
        a = new int[]{1, 2};
        this.sort(a, strategy);

        a = new int[]{2, 1};
        this.sort(a, strategy);

        a = new int[]{2, 1, 2};
        this.sort(a, strategy);

        a = new int[]{1, 2, 2};
        this.sort(a, strategy);

        a = new int[]{1, 2, 2, 3};
        this.sort(a, strategy);

        a = new int[]{4, 2, 3, 1, 10};
        this.sort(a, strategy);
        if(real) {
            int sortNums = (int)(Math.random() * 100);
            for (int i = 0; i < sortNums;i++) {
                int numNum = (int)(Math.random() * 100);
                int[] nums = new int[numNum];
                for (int j = 0; j < numNum;j++) {
                    nums[j] = (int)(Math.random() * 100) + 1;
                }
                this.sort(nums, strategy);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        SortTest t = new SortTest();
        Sort strategy;

//        strategy = Quick.getInstance();
//        strategy = Insert.getInstance();
        strategy = Merge.getInstance();

        t.test(strategy);

    }
}
