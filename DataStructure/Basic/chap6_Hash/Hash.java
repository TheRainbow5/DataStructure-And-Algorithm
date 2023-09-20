package Basic.chap6_Hash;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * Rainbow
 * 哈希表
 *
 * @DATE:2023/9/20 0020
 * 需求：
 * 有一个公司，当有新员工报道时，将该员工的新的加入（id，姓名，年龄）
 * 当输入相应的id，可以查找到员工的所有信息。
 * <p>
 * 实现思路：
 * 1、使用数组+链表实现哈希表的结构
 * 2、链表没有头节点，head节点直接存储员工信息
 */

/**
 * 数组+链表实现哈希表
 */
@Data
@AllArgsConstructor
public class Hash {
    private LinkedList[] empHashTable;
    private int CAPACITY = 10;                   //数组容量
    private List<LinkedList> buckets;  //动态数组

    /**
     * 默认情况，哈希表长度=10
     */
    public Hash() {
        buckets = new ArrayList<>(CAPACITY);
        //初始化链表
        for (int i = 0; i < CAPACITY; i++) {
            buckets.add(new LinkedList());
        }
    }

    /**
     * 可以设置数组的长度
     *
     * @param capacity
     */
    public Hash(int capacity) {
        this.CAPACITY = capacity;
        buckets = new ArrayList<>(CAPACITY);
        //初始化链表
        for (int i = 0; i < CAPACITY; i++) {
            buckets.add(new LinkedList());
        }
    }

    public static void main(String[] args) {
        Hash hash = new Hash();

        Node node = new Node(2, "rainbow", 20);
        hash.add(node);
        Node node1 = new Node(13, "rainbow", 22);
        hash.add(node1);
        Node node2 = new Node(23, "rainbow", 23);
        hash.add(node2);
        Node node3 = new Node(33, "rainbow", 23);
        hash.add(node3);

        hash.list();

        //删除节点
        hash.remove(23);
        hash.list();
        //查询节点
        System.out.println(hash.get(13));

    }

    /**
     * 计算哈希值
     *
     * @param key
     */
    public int hashCode(int key) {
        return key % CAPACITY;
    }


    /**
     * 添加新员工
     * 1、计算哈希值
     * 2、存储到对应链表
     *
     * @param node
     */
    public void add(Node node) {
        if (get(node.getId()) != null) {
            System.out.println("id=" + node.getId() + "数据已经存在，请重新输入");
            return;
        }
        int index = hashCode(node.getId());  //获取数组的索引
        buckets.get(index).add(node);   //添加新节点
    }

    /**
     * 通过id删除数据
     * 1、计算index，找到对应节点的链表
     *
     * @param id
     */
    public void remove(int id) {
        if (get(id) == null) {
            System.out.println("没有id=" + id + "的数据");
            return;
        }
        int index = hashCode(id);
        buckets.get(index).remove(id);
    }


    /**
     * 根据id查询员工数据
     *
     * @param id
     * @return
     */
    public Node get(int id) {
        int index = hashCode(id);
        return buckets.get(index).get(id);
    }


    /**
     * 遍历哈希表
     */
    public void list() {
        if (buckets.size() == 0) {
            System.out.println("哈希表为空");
            return;
        }
        //遍历数组
        for (int i = 0; i < buckets.size(); i++) {
            System.out.print("bucket" + i + ":");
            //遍历数组中的链表
            System.out.print("[");
            buckets.get(i).list();
            System.out.print("]");
            System.out.println();
        }
    }
}

/**
 * 链表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
class LinkedList {
    private int size = 0;
    private Node head = null;   //头节点直接存储数据

    /**
     * 向链表末尾添加新节点
     *
     * @param node 向链表末尾添加新节点
     */
    public void add(Node node) {
        // 如果链表为空，将新节点设为头节点
        if (head == null) {
            head = node;
            size++;      // 增加节点个数
            return;
        }
        // 不是第一个节点，使用辅助指针定位到最后一个节点
        Node cur = head;
        while (cur.next != null) {
            cur = cur.next;    // 辅助指针向后移动，定位到最后一个节点
        }
        // 此时cur指向最后一个节点，将新节点加入末尾
        cur.next = node;
        size++;  // 增加节点个数
    }

    /**
     * 通过id删除节点元素
     *
     * @param id 要删除的节点的ID
     */
    public void remove(int id) {
        if (head == null) {
            return;
        }
        // 如果目标节点是头节点
        if (head.getId() == id) {
            head = head.next;
            return;
        }

        Node cur = head;
        while (cur.next != null) {
            if (cur.next.getId() == id) {
                cur.next = cur.next.next;   //删除节点
                return;
            }
            cur = cur.next;
        }
    }


    /**
     * 根据id查询数据
     *
     * @param id
     * @return
     */
    public Node get(int id) {
        if (head == null) {
            return null;
        }
        //如果是第一个节点
        if (head.getId() == id) {
            return head;
        }
        Node cur = head;
        while (cur.next != null) {
            if (cur.next.getId() == id) {
                return cur.next;
            }
            cur = cur.next;
        }
        // 如果未找到匹配的节点
        return null;
    }


    /**
     * 遍历链表
     */
    public void list() {
        if (head == null) {
            System.out.print("当前链表为空");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.getId());
            if (temp.next != null) {
                System.out.print("->");
            }
            //temp向后移动
            temp = temp.next;
        }
    }
}


/**
 * 员工对象
 */
@Data
@AllArgsConstructor
class Node {
    public Node next;
    private int id;
    private String name;
    private int age;

    public Node(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
