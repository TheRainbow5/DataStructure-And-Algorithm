package SortAlgorihtm;

/**
 * Rainbow
 * 选择排序
 *
 * @DATE:2023/8/24 0024
 */
public class selectionSort {
    public static void main(String[] args) {
        int[] nums = {2, 4, 3, 1, 5, 2};
        System.out.println("===== Original =====");
        Utils.toString(nums);
        System.out.println("===== Sorted =====");
        selectionSorted(nums);
        Utils.toString(nums);
    }

    /**
     * 选择排序
     */
    private static void selectionSorted(int[] array) {
        int length = array.length;
        for (int i = 0; i < length - 1; i++) {
//            Utils.toString(array);   //显示每一轮循环
            int minIndex = i;   //index of min
            for (int j = i + 1; j < length; j++) {
                if (array[minIndex] > array[j]) {
                    minIndex = j;
                }
            }
            //Swap
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }
}
