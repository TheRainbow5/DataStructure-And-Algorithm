package SortAlgorihtm;

/**
 * Rainbow
 * 插入排序
 *
 * @DATE:2023/9/5 0005
 */
public class insertionSort {
    public static void main(String[] args) {
        int[] nums = {6, 3, 0, 5};
        insertionSorted(nums);
        Utils.toString(nums);
    }

    /**
     * 插入排序
     *
     * @param nums
     */
    public static void insertionSorted(int[] nums) {
        for (int i = 1; i < nums.length; i++) {   //控制轮数
            int base = nums[i];
            int j;
            for (j = i - 1; j >= 0; j--) {   //控制比较次数
                if (base < nums[j]) {   //向前移动一位
                    nums[j + 1] = nums[j];
                } else {
                    break;
                }
            }
            nums[j + 1] = base;     //找到base插入的位置
        }
    }
}
