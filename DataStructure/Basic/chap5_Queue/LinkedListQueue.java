package Basic.chap5_Queue;

/**
 * Rainbow
 * 基于链表实现队列
 * 队首<--出列--head<--[1<--3<--4<--4<--5<--6]<--入列--队尾
 *
 * @DATE:2023/7/13 0013
 */
public class LinkedListQueue<T> {
    private final Node head;  //头指针
    private int SIZE;   //元素个数

    /**
     * 初始化头节点
     */
    public LinkedListQueue() {
        this.head = new Node();
    }

    /**
     * 尾插法插入元素
     * 1、创建新节点
     * 2、辅助指针temp=head;
     * 3、while循环遍历到尾节点
     * 4、temp.next=node
     *
     * @param value
     */
    public void push(T value) {
        //创建新节点
        Node node = new Node(value);
        Node temp = head;
        while (temp.next != null) {
            //指针向后移动
            temp = temp.next;
        }
        //添加新节点
        temp.next = node;
    }


    /**
     * 弹出队首
     * 1、临时变量temp存储队首元素
     *
     * @return
     */
    public T pop() {
        T temp = head.next.data;
        head.next = head.next.next;
        return temp;
    }

    /**
     * 访问队首元素
     */
    public T peek() {
        return head.next.data;
    }

    /**
     * 遍历链表
     */
    public void forEach() {
        Node temp = head;
        while (temp.next != null) {
            System.out.print(temp.next.data);
            if (temp.next.next != null) {
                System.out.print("-->");
            }
            //temp向后移动
            temp = temp.next;
        }
        System.out.println();
    }

    /**
     * 获取元素个数
     *
     * @return
     */
    public int getSIZE() {
        return SIZE;
    }

    private class Node {
        public T data;
        public Node next;

        public Node() {
            this.next = null;
        }

        public Node(T value) {
            this.data = value;
            this.next = null;
        }
    }
}
