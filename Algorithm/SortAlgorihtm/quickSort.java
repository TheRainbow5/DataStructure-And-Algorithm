package SortAlgorihtm;

/**
 * Rainbow
 * 快速排序
 *
 * @DATE:2023/9/6 0006
 */
public class quickSort {

    public static void main(String[] args) {
        int[] nums = {2, 4, 3, 1, 5, 2};
        quickSorted(nums, 0, nums.length - 1);
        Utils.toString(nums);
    }

    /**
     * 递归实现划分数组
     *
     * @param nums
     * @param left
     * @param right
     */
    public static void quickSorted(int[] nums, int left, int right) {
        while (left >= right) {   //终止递归
            return;
        }
        //获取基准元素位置
        int base = partition(nums, left, right);
        //递归左子数组
        quickSorted(nums, left, base - 1);
        //递归右子数组
        quickSorted(nums, base + 1, right);
    }

    /**
     * 划分数组
     *
     * @return
     */
    public static int partition(int[] nums, int left, int right) {
        //以nums[left]作为基准数
        int base = nums[left];
        int i = left;
        int j = right;
        while (i < j) {
            while (i < j && base <= nums[j]) {  //寻找大于base的元素
                j--;
            }
            while (i < j && base >= nums[i]) {  //寻找小于base的元素
                i++;
            }
            //交换i和j的元素位置
            swap(nums, i, j);
        }
        //找到基准数的位置（i==j）
        swap(nums, left, i);   //交换元素
        return i;   //返回基准数位置
    }

    /**
     * 交换元素
     *
     * @param nums
     * @param i
     * @param j
     */
    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
