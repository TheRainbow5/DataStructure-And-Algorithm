package Basic.chap6_Hash;

/**
 * Rainbow
 * 实现HashMap
 *
 * @DATE:2023/9/20 0020
 */

import lombok.Data;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class HashMap<E> {
    public static void main(String[] args) {
        HashMap<Object> map = new HashMap<>();
        map.put(1, 23);
        map.put(2, 25);
        map.put(3, 22);
        map.put(15, 23);
        map.put(6, 23);
        map.put(1, 2444);
        map.list();


        //查找
        System.out.println(map.get(1));

        //删除元素
        map.remove(15);
        map.list();


    }

    private final double loadFactor = 0.75;  //负载因子
    private final int extendRatio = 2;   //扩容的倍数
    private List<LinkedList<Node<E>>> buckets;  //桶数组，链表，用于解决哈希冲突问题
    private int CAPACITY = 5;   //默认桶的数量
    private int size = 0;        //记录元素个数

    /**
     * 无参构造函数
     */
    public HashMap() {
        buckets = new ArrayList<>(CAPACITY);   //使用动态数组
        //初始化每个桶的链表
        for (int i = 0; i < CAPACITY; i++) {
            buckets.add(new LinkedList<>());
        }
    }

    /**
     * 有参构造函数
     *
     * @param capacity 设置桶的个数
     */
    public HashMap(int capacity) {
        this.CAPACITY = capacity;
        buckets = new ArrayList<>(CAPACITY);   //使用动态数组
        //初始化每个桶的链表
        for (int i = 0; i < CAPACITY; i++) {
            buckets.add(new LinkedList<>());
        }
    }

    /**
     * 返回节点个数
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 添加新元素
     *
     * @param key
     * @param value
     */
    public void put(int key, E value) {
        //判断是否需要扩容
        if (checkExtend()) {
            extend();
        }
        Node<E> node = new Node<>(key, value);  //创建新节点
        int index = hashCode(key);
        buckets.get(index).add(node);
        size++;
    }

    /**
     * 查找节点
     *
     * @param key
     * @return
     */
    public E get(int key) {
        int index = hashCode(key);
        LinkedList<Node<E>> linkedList = buckets.get(index);
        //遍历链表
        for (Node<E> node : linkedList) {
            //找到key相同的节点
            if (node.getKey() == key) {
                return node.getValue();
            }
        }
        return null;
    }

    /**
     * 根据key，删除节点数据
     *
     * @param key
     */
    public void remove(int key) {
        int index = hashCode(key);
        LinkedList<Node<E>> linkedList = buckets.get(index);
        //遍历链表
        for (Node<E> node : linkedList) {
            if (node.getKey() == key) {
                linkedList.remove(node);
            }
        }
    }

    /**
     * 判断是否需要扩容
     *
     * @return
     */
    private boolean checkExtend() {
        return loadFactor() > loadFactor ? true : false;
    }

    /**
     * 计算触发扩容的负载因子
     */
    private double loadFactor() {
        return (double) size / CAPACITY;
    }

    /**
     * 哈希表扩容
     */
    private void extend() {
        // 暂存原哈希表
        List<LinkedList<Node<E>>> bucketsTemp = buckets;
        //修改新表的容量
        CAPACITY = CAPACITY * extendRatio;
        buckets = new ArrayList<>(CAPACITY);
        size = 0;
        //初始化新哈希表
        for (int i = 0; i < CAPACITY; i++) {
            buckets.add(new LinkedList<>());
        }

        //将辅助表的节点拷贝到新表
        for (LinkedList<Node<E>> linkedList : bucketsTemp) {
            for (Node node : linkedList) {
                put(node.getKey(), (E) node.getValue());
            }
        }

    }

    /**
     * 计算元素的哈希码
     *
     * @param key 节点的id
     * @return
     */
    private int hashCode(int key) {
        return key % CAPACITY;
    }

    /**
     * 遍历哈希表
     */
    private void list() {
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

    /**
     * 静态内部类表示哈希表的节点
     *
     * @param <E> 数据类型
     */

    @Data
    private static class Node<E> {
        private int key;
        private E value;
        private Node next;

        public Node(int key, E value) {
            this.key = key;
            this.value = value;
        }
    }

}
