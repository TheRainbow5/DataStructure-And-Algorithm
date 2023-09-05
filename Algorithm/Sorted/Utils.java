package Sorted;

/**
 * Rainbow
 *
 * @DATE:2023/8/28 0028
 */
public class Utils {
    public static void toString(int[] array) {
        String res = "";
        for (int val : array) {
            res += val + ",";
        }
        if (res != "")
            System.out.println(res = "[" + res.substring(0, res.length() - 1) + "]");
        else
            System.out.println(res = "[]");
    }
}
