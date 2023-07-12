package List;

import org.junit.Test;

/**
 * Rainbow
 *
 * @DATE:2023/7/6 0006
 */
public class test {
    @Test
    public void testArrayList() {
        ArrayList_<Integer> objectArrayList = new ArrayList_();
        for (int i = 0; i < 20; i++) {
            objectArrayList.add(i);
        }
        System.out.println("***遍历数组元素***");
        objectArrayList.forEach();
        System.out.println("***插入元素***");
        objectArrayList.insert(0, 9);
        objectArrayList.forEach();
        System.out.println("***删除元素***");
        objectArrayList.remove(1);
        objectArrayList.forEach();
        System.out.println("***修改元素***");
        objectArrayList.set(0, 1);
        objectArrayList.forEach();
        System.out.println("***查找元素***");
        Integer num = objectArrayList.get(3);
        System.out.println(num);
        System.out.println("数组容量=" + objectArrayList.length());
        System.out.println("元素个数=" + objectArrayList.getSize());

    }
}
