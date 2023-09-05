package Basic.chap7_HashTable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.LinkedList;


/**
 * Rainbow
 * 通常情况下哈希函数的输入空间大于输出空间
 * 当多个key的哈希值都相同时，必然造成多个key映射到同一个数组索引，引起哈希冲突
 * 解决办法：
 * 1、每当遇到哈希冲突时就扩容哈希表，直到哈希冲突消失为止，
 * 此方法简单粗暴，需要进行大量的数据搬运和哈希计算，效率很低
 * 2、改变哈希表的存储结构，使用链表存储
 * 每个桶表示一个链表，将相同哈希值的元素添加到链表后面
 * [key,value]--->HashFunction()--->[key1,value1]->[key2,value2]->[key3,value3]....->[keyn,valuen]
 *
 * @DATE:2023/7/18
 */

/**
 * 链表中存储的节点对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
class KeyValuePair<T, E> {
    private T key;
    private E value;
}

public class HashMap<T, E> {
    //数组容量
    private int CAPACITY = 10;
    private int Size = 0;
    private final int extendRatio = 2;  //扩容倍数
    private final double loadThres = 0.75;
    //存储链表的数组
    private ArrayList<LinkedList<KeyValuePair<T, E>>> buckets;

    public HashMap() {
        buckets = new ArrayList<>(CAPACITY);
        //初始化链表
        for (int i = 0; i < CAPACITY; i++) {
            buckets.add(new LinkedList<>());
        }
    }

    public HashMap(int capacity) {
        this.CAPACITY = capacity;
        buckets = new ArrayList<>(CAPACITY);
        //初始化链表
        for (int i = 0; i < CAPACITY; i++) {
            buckets.add(new LinkedList<>());
        }
    }

    /**
     * 计算触发扩容的负载因子
     */
    public double loadFactor() {
        return (double) Size / CAPACITY;
    }

    /**
     * 计算哈希值
     * @param key
     */
    public int hash(T key) {
        return key.hashCode() % CAPACITY;
    }

    /**
     * 添加元素
     * 1、计算哈希值index
     * 2、通过index找到桶的位置
     * 3、遍历链表，查看是否有相同的key
     *  有，覆盖value
     *  没有，链表添加新节点
     *
     * 时间复杂度；
     *  1、最优情况T(n)=O(1)
     *  2、最坏情况（全部元素冲突）T(n)=O(n)
     * @param key
     * @param value
     */
    public void put(T key, E value) {
        ;
        //判断数组是否需要扩容
        if (loadFactor() > loadThres) {
            System.out.println("触发数组扩容");
            extend();
        }
        //计算哈希值
        int index = hash(key);
        //找到桶的位置
        LinkedList<KeyValuePair<T, E>> linkedList = buckets.get(index);
        //链表不为空时，遍历链表查找key相同的节点
        for (KeyValuePair<T, E> kvp : linkedList) {
            //1、存在则覆盖元素
            if (kvp.getKey() == key) {
                kvp.setValue(value);
                return;
            }
        }
        //链表为空，添加新节点
        linkedList.addLast(new KeyValuePair<>(key, value));
        Size++;
    }


    /**
     * 查询
     * 1、计算哈希值index
     * 2、通过index找到数组中的桶
     * 3、遍历桶中的链表，找到key相同的节点
     * 4、返回节点数据
     * @param key
     */
    public E get(T key) {
        int index = hash(key);
        LinkedList<KeyValuePair<T, E>> linkedList = buckets.get(index);
        //遍历链表
        for (KeyValuePair<T, E> kvp : linkedList) {
            //找到key相同的节点
            if (kvp.getKey() == key) {
                return kvp.getValue();
            }
        }
        return null;
    }

    /**
     * 删除元素
     * 1、计算哈希值index
     * 2、通过index找到数组中的桶
     * 3、遍历桶中的链表，找到key相同的节点，
     * 4、删除节点
     * @param key
     */
    public void remove(T key) {
        //计算哈希值
        int index = hash(key);
        LinkedList<KeyValuePair<T, E>> linkedList = buckets.get(index);
        //遍历列表中的节点
        //删除节点
        linkedList.removeIf(kvp -> kvp.getKey() == key);
        //元素个数-1
        Size--;

    }

    /**
     * 数组扩容
     */
    public void extend() {
        // 暂存原哈希表
        ArrayList<LinkedList<KeyValuePair<T, E>>> bucketsTemp = buckets;
        //初始化扩容的新表
        CAPACITY = CAPACITY * extendRatio;
        buckets = new ArrayList<>(CAPACITY);
        //元素个数重置
        Size = 0;
        //初始化新表中的链表
        for (int i = 0; i < CAPACITY; i++) {
            buckets.add(new LinkedList<>());
        }
        //遍历旧表的元素，赋值到新表
        for (LinkedList<KeyValuePair<T, E>> bucket : bucketsTemp) {
            for (KeyValuePair<T, E> kvp : bucket) {
                put(kvp.getKey(), kvp.getValue());
            }
        }

    }

    /**
     * 获取元素个数
     * @return
     */
    public int getSize() {
        return Size;
    }

    /**
     * 遍历哈希表
     */
    public void forEach() {
        //遍历数组
        for (int i = 0; i < buckets.size(); i++) {
            System.out.print("bucket" + i + ":");
            //遍历数组中的链表
            for (int j = 0; j < buckets.get(i).size(); j++) {
                if (j == buckets.get(i).size() - 1) {
                    System.out.print("[" + buckets.get(i).get(j).getKey() + "," + buckets.get(i).get(j).getValue() + "]");
                } else {
                    System.out.print("[" + buckets.get(i).get(j).getKey() + "," + buckets.get(i).get(j).getValue() + "]->");
                }
            }
            System.out.println();
        }
    }

}
