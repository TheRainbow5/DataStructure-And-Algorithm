package Basic.chap6_Hash;

import java.util.HashSet;
import java.util.Iterator;

/**
 * Rainbow
 *
 * @DATE:2023/10/10 0010
 */
public class HashSetTest {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        hashSet.add(1);
        hashSet.add(2);
        hashSet.add(3);
        //遍历hashSet
        Iterator iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }

}
