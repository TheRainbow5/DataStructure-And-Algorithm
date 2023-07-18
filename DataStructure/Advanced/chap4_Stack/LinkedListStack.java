package Advanced.chap4_Stack;

/**
 * Rainbow
 * 基于链表（头节点存储数据）实现栈
 *
 * @DATE:2023/7/12 0012
 */
public class LinkedListStack<T> {
    public Node head;  //头节点
    private int count = 0;  //元素个数

    //初始化头节点
    public LinkedListStack() {
        head = new Node();
    }

    /**
     * 头插法实现入栈操作
     * 1、创建新节点new
     * 2、新节点new.next=head.next，防止后面节点丢失
     * 3、head.next=new
     * T(n)=O(1)
     * @param val
     */
    public void push(T val) {
        Node newNode = new Node(val);
        //先指向head后的链表，防止书丢失
        newNode.next = head.next;
        head.next = newNode;
        //节点数量+1
        count++;
    }

    /**
     * 出栈
     * 1、删除头节点：head.next=head.next.next
     * 2、temp存储删除的节点元素
     * T(n)=O(1)
     *
     * @return
     */
    public T pop() {
        //判断是否为空
        if (isEmpty()) {
            throw new RuntimeException("栈空");
        } else {
            T temp = head.next.data;
            head.next = head.next.next;
            count--;  //元素个数-1
            return temp;
        }
    }

    /**
     * 访问栈顶元素，不是删除节点元素！
     *
     * @return
     */
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("栈空");
        } else {
            return head.next.data;
        }
    }

    /**
     * 判断栈是否为空
     * count记录了每次push和pop的元素个数
     * 1、count>=0表示链表为空
     * 2、反之则不为空
     *
     * @return
     */
    public Boolean isEmpty() {
        return count == 0;
    }

    /**
     * 返回元素个数
     *
     * @return
     */
    public int length() {
        return this.count;
    }

    /**
     * 遍历链表
     * 1、初始化辅助指针temp指向head
     * 2、当temp.next不等于null时，向后移动
     * 3、直到temp.next=null，说明遍历到尾节点（空节点）
     */
    public void forList() {
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
     * 节点内部类
     */
    private class Node {
        T data;
        Node next;

        public Node() {
            this.next = null;
        }

        public Node(T value) {
            this.data = value;
            this.next = null;
        }
    }

}
