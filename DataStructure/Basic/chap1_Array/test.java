package Basic.chap1_Array;

import org.junit.Test;

/**
 * @author Rainbow
 * @date 2023/7/4 0004
 */
public class test {
    @Test
    public void testArray() {
        Array_ arr = new Array_(20);
        for (int i = 0; i < 10; i++) {
            arr.insert(i);
        }
        arr.listArray();
        //测试插入功能
        System.out.println("***测试插入功能***");
        arr.insert(2, 3);
        arr.listArray();
        //测试删除功能
        System.out.println("***测试删除功能***");
        arr.remove(1);
        arr.listArray();
        //
        System.out.println("数组长度=" + arr.length());
        System.out.println("元素个数=" + arr.elementLength());

    }

}
