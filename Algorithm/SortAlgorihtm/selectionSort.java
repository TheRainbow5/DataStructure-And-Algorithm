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
     * 排序数组：（2 4 3 1 5 2）
     * 1. （**2** 4 3 1 5 2）：2依次和`4 3 1 5 2`比较，$if(2>other) ⇒ index=minIndex$，比较完后，交换元素位置。
     * 2. （1 **4** 3 2 5 2）：4依次和`3 2 5 2`比较，同理得到最小元素的index，比较完后，交换元素位置。
     * 3. （1 2 **3** 4 5 2）：3依次和`4 5 2`比较，同理，交换元素位置。
     * 4. （1 2 2 **4** 5 3）
     * 5. （1 2 2 3 **5** 4）
     * 6. （1 2 2 3 ****4 5）
     * T(n)=O(n^2)
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
