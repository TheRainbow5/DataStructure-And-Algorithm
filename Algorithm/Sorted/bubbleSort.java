package Sorted;

/**
 * Rainbow
 *
 * @DATE:2023/8/24 0024
 */
public class bubbleSort {
    public static void main(String[] args) {
        int[] nums = {6, 3, 0, 5};
        bubbleSorted(nums);
        Utils.toString(nums);
    }

    /**
     * 冒泡排序
     *
     * @param nums
     */
    public static void bubbleSorted(int[] nums) {
        int n = nums.length;
        for (int i = n - 1; i > 0; i--) {  //外层循环控制循环轮数
            for (int j = 0; j < i; j++) {  //内层循环控制控制每轮循环比较元素的个数
                if (nums[j] > nums[j + 1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;   //大的向右边移动
                }
            }
        }
    }
}
