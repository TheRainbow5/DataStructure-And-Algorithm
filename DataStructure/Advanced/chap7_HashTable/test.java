package Advanced.chap7_HashTable;

import org.junit.Test;

/**
 * Rainbow
 *
 * @DATE:2023/7/18 0018
 */
public class test {
    @Test
    public void testLinkedListHashTable() {
        LinkedListHashTable<Integer, String> hashTable = new LinkedListHashTable<>(7);
        System.out.println("***添加***");
        hashTable.put(1, "Value 1");
        hashTable.put(11, "Value 11");
        hashTable.put(22, "Value 21");
        hashTable.put(33, "Value 21");
        hashTable.put(44, "Value 21");
        hashTable.put(51, "Value 21");
        hashTable.forEach();
        System.out.println("***查询***");
        System.out.println(hashTable.get(1));
        System.out.println("***删除***");
        hashTable.remove(11);
        hashTable.forEach();


    }
}
