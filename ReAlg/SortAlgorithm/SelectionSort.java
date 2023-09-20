package SortAlgorithm;

import SortAlgorihtm.Utils;

/**
 * Rainbow
 * 选择排序
 *
 * @DATE:2023/9/19 0019
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] nums = {2, 4, 3, 1, 5, 2};
        selectSort(nums);
        Utils.toString(nums);
    }

    /**
     * 选择排序
     *
     * @param nums 思路：
     *             （2,4,3,1,5,2）
     *             初始化基准数base=2，循环遍历比较未排序的子集，找到最小的元素，base=最小元素
     *             然后base向前移动一位，直到排序完成。
     *             1、base=2，循环遍历（4,3,1,5,2）找到最小值，交换位置
     *             -->（1,4,3,2,5,2）
     *             2、base=4，循环遍历（3,2,5,2），交换位置
     *             。。。。
     */
    public static void selectSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int base = i;          //记录最小元素的索引
            //循环遍历比较未排序的子集
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] <= nums[base]) {
                    base = j;
                }
            }
            //此时找到最小值的位置，交换位置
            int min = nums[base];
            nums[base] = nums[i];
            nums[i] = min;
        }
    }
}
