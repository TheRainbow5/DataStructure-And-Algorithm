package LinkedList;

/**
 * Rainbow
 * 数组的数据在内存中是连续存储，当数组扩容所申请的内存连续地址超出了内存最大范围，
 * 数组就无法完成扩容，数据无法存储。
 * <p>
 * 链表则表现的十分灵活，数据可以存储在非连续的内存空间。
 * 每个元素都是一个节点对象，各个节点之间通过指针连接
 * （指针记录了各个节点的内存地址，从而保证了各个节点分散的存储在内存）
 * 单链表的存储结构有两种：
 *      1、不带头节点：[data|next]-->[data|next]-->[data|next]-->null
 *      2、带头节点：head-->[data|next]-->[data|next]-->[data|next]-->null
 * 链表的分类
 *      1、单链表
 *      2、环形链表
 *      3、双向链表
 * @DATE:2023/7/10
 */
public class LinkedList_ {
    public Node head;  //头节点
    public int length=0; //计算节点个数（不包括头节点）

    /**
     * 初始化带有头节点的链表
     *      head-->[data|next]-->[data|next]-->[data|next]-->null
     */
    public LinkedList_(){
        //初始化头节点
        head= new Node();
    }
    /**
     * 节点内部类
     */
    static class Node{
        int data;
        Node next;
        //初始化头节点
        Node(){
            data=-1;
            next=null;
        }
        //新建节点
        Node(int x){
            this.data=x;
            this.next=null;
        }
    }

    /**
     * 添加元素--头插法
     */
    public void addFirst(int val){
        Node newNode = new Node(val);
        //先指向head后的链表，防止书丢失
        newNode.next=head.next;
        head.next=newNode;
        //节点数量+1
        length++;
    }

    /**
     * 添加元素-尾插法
     * 1、初始化一个辅助指针temp
     * 2、遍历辅助指针temp指向最后一个节点
     */
    public void addTail(int val){
        Node temp=head;
        Node node = new Node(val);
        //遍历链表
        while(temp.next!=null){
            temp=temp.next;  //指向向后移动
        }
        temp.next=node;  //连接新节点
        //节点数量+1
        length++;
    }

    /**
     * 添加元素--插入指定位置
     * 1、判断插入位置pos是否合法
     * 2、初始化一个辅助指针temp
     * 3、遍历辅助指针temp指向目标节点的前一个节点
     * 4、
     * @param pos：插入的位置
     * @param value：插入的值
     */
    public void insertPos(int pos,int value){
        Node temp=head;
        Node node = new Node(value);
        if(pos<0 || pos>length){
            System.out.println("超出链表范围");
        }else{
            for(int i=0;i<pos-1;i++){
                temp=temp.next;
            }
            //temp指向目标节点的前一个节点
            node.next=temp.next;
            temp.next=node;
            //节点数量+1
            length++;
        }
    }

    /**
     * 删除元素--删除指定位置的元素
     * 1、初始化一个辅助指针temp
     * 2、遍历temp指向目标节点的前一个节点
     * 3、temp.next=temp.next.next;
     * @param pos：指定位置
     */
    public void remove(int pos){
        Node temp=head;
        for(int i=0;i<pos-1;i++){
            temp=temp.next;
        }
        //删除节点
        temp.next=temp.next.next;
        //节点数量-1
        length--;
    }

    /**
     * 删除第一个节点
     */
    public void removeFirst(){
        head.next=head.next.next;
    }

    /**
     * 删除最后一个节点
     */
    public void removeLast(){
        Node temp=head;
        while(temp.next.next!=null){
            temp=temp.next;
        }
        temp.next=null;
        length--;
    }

    /**
     * 修改指定位置节点
     * 1、初始化辅助指针temp
     * 2、遍历链表，temp指向目标节点
     * 3、修改temp.data=value
     * @param pos：位置
     * @param value：数值
     */
    public void set(int pos,int value){
        Node temp=head;
        if(pos<0 || pos>length){
            System.out.println("超出链表范围");
        }else{
            for(int i=0;i<pos;i++){
                temp=temp.next;
            }
            //temp指向目标节点，修改节点数据
            temp.data=value;
        }
    }
    public void setFirst(int value){
        head.next.data=value;
    }
    public void setLast(int value){
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.data=value;
    }

    public int get(int pos){
        Node temp=head;
        if(pos<0 || pos>length){
            System.out.println("超出链表范围");
            return -1;
        }else{
            for(int i=0;i<pos;i++){
                temp=temp.next;
            }
            return temp.data;
        }
    }
    public int getFirst(){
        return head.next.data;
    }
    public int getLast(){
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        return temp.data;
    }



    /**
     * 遍历链表
     * 1、初始化辅助指针temp指向head
     * 2、当temp.next不等于null时，向后移动
     * 3、直到temp.next=null，说明遍历到尾节点（空节点）
     */
    public void forList(){
        Node temp=head;
        while(temp.next!=null){
            System.out.print(temp.next.data);
            if(temp.next.next!=null){
                System.out.print("-->");
            }
            //temp向后移动
            temp=temp.next;
        }
        System.out.println();
    }
}
