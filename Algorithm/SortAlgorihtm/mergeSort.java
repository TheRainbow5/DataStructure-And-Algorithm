package SortAlgorihtm;

/**
 * Rainbow
 * 归并排序
 *
 * @DATE:2023/9/14 0014
 */
public class mergeSort {

    public static void main(String[] args) {
        int[] nums = {7, 3, 2, 5, 6};
        Utils.toString(nums);
        merge_sort(nums, 0, nums.length - 1);
        Utils.toString(nums);
    }


    /**
     * 划分
     * 使用递归完成对数组的划分
     *
     * @param arr
     * @param left
     * @param right
     */
    public static void merge_sort(int[] arr, int left, int right) {
        //辅助数组
        int[] temp = new int[arr.length];
        if (left < right) {    //保证索引的合法
            //划分的中心点
            int mid = (right + left) / 2;
            //递归完成左子树划分
            merge_sort(arr, left, mid);
            //递归完成右子树划分
            merge_sort(arr, mid + 1, right);
            //合并子树
            merge(arr, temp, left, mid, right);
        }
    }

    /**
     * 合并子数组
     *
     * @param arr
     * @param temp
     * @param left
     * @param mid
     * @param right
     */
    private static void merge(int[] arr, int[] temp, int left, int mid, int right) {
        int left_pos = left;     //左子树的起始索引
        int right_pos = mid + 1;   //右子树的起始索引
        int pos = left;          //辅助数组的起始索引
        //合并左右相同长度的元素
        while (left_pos <= mid && right_pos <= right) {
            if (arr[left_pos] < arr[right_pos]) {
                temp[pos++] = arr[left_pos++];
            } else {
                temp[pos++] = arr[right_pos++];
            }
        }
        //左半区还有元素未排序
        while (left_pos <= mid) {
            temp[pos++] = arr[left_pos++];
        }
        //右边半区还有元素未排序
        while (right_pos <= right) {
            temp[pos++] = arr[right_pos++];
        }
        //将辅助数组中的元素合并到arr
        while (left <= right) {
            arr[left] = temp[left];
            left++;
        }
    }
}
