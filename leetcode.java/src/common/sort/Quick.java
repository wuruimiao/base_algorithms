package common.sort;

import java.util.Arrays;

public class Quick implements Sort{
    private final Swap swap = Swap.getInstance();

    private int partition(int[] nums, int left, int right) {
        int i = left, j = right - 1, pivot = nums[right];
        System.out.println("分区" + left + "与" + right);
        while (i < j ) {
            while (nums[i] <= pivot && i < j) { i++;}
            while (nums[j] > pivot && i < j) { j--;}
            if (i < j) {
                swap.make(nums, i, j);
            }
        }
        if (nums[i] > nums[right]) {
            swap.make(nums, i, right);
            return i;
        }
        return right;
    }

    @Override
    public void sort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = partition(nums, left, right);
        sort(nums, left, mid - 1);
        sort(nums, mid + 1, right);
    }

    @Override
    public int swapTimes() {
        return swap.swapTimes;
    }
    //    安全懒汉
//    private static Quick instance;
//    private Quick() {}
//
//    public static synchronized Quick getInstance() {
//        if (instance == null) {
//            instance = new Quick();
//        }
//        return instance;
//    }

//    饿汉
//    private static final Quick instance = new Quick();
//    public static Quick getInstance() {
//        return instance;
//    }

    //    双校验锁——懒汉进阶
    private volatile static Quick singleton;
    private Quick (){}
    public static Quick getInstance() {
        if (singleton == null) {
            synchronized (Quick.class) {
                if (singleton == null) {
                    singleton = new Quick();
                }
            }
        }
        return singleton;
    }

//  静态类
//    private static class QuickHolder {
//        private static final Quick INSTANCE = new Quick();
//    }
//    private Quick (){}
//    public static Quick getInstance() {
//        return QuickHolder.INSTANCE;
//    }
}


