package common.sort;

public class Merge implements Sort {

    private void merge(int[] nums, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = left + (right - left) / 2;
        merge(nums, left, mid);
        merge(nums, mid + 1, right);
        int i = left, j = mid + 1, k = 0;
        int[] tmp = new int[right - left + 1];
        while (i <= mid && j <= right) {
            if (nums[i] < nums[j]) {
                tmp[k++] = nums[i++];
            } else {
                tmp[k++] = nums[j++];
            }
        }
        while (i <= mid) tmp[k++] = nums[i++];
        while (j <= right) tmp[k++] = nums[j++];

        for (i = 0, j = left; i < tmp.length && j <= right; i++, j++) {
            nums[j] = tmp[i];
        }
    }

    @Override
    public void sort(int[] nums, int left, int right) {
        if (nums.length == 0)  {
            return;
        }
        merge(nums, left, right);
    }

    @Override
    public int swapTimes() {
        return 0;
    }

    private Merge() {
    }

    private static Merge instance;

    public static Merge getInstance() {
        if (instance == null) {
            synchronized (Merge.class) {
                instance = new Merge();
            }
        }
        return instance;
    }
}
