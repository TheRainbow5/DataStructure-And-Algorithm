package Basic.chap7_HashTable;

import org.junit.Test;

/**
 * Rainbow
 *
 * @DATE:2023/7/18 0018
 */
public class test {
    @Test
    public void testLinkedListHashTable() {
        HashMap<Integer, String> map = new HashMap<>(7);
        System.out.println("***添加***");
        map.put(1, "Value 1");
        map.put(11, "Value 11");
        map.put(22, "Value 21");
        map.put(33, "Value 21");
        map.put(44, "Value 21");
        map.put(51, "Value 21");
        map.forEach();
        System.out.println("***查询***");
        System.out.println(map.get(1));
        System.out.println("***删除***");
        map.remove(11);
        map.forEach();


    }
}
