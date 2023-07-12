package LinkedList;

import org.junit.Test;

/**
 * Rainbow
 * 链表的测试类
 *
 * @DATE:2023/7/10 0010
 */
public class test {
    @Test
    public void LinkedList() {
        singleLinkedListTemplate<Integer> linkedList = new singleLinkedListTemplate<>();
        //带有头节点的链表
//        LinkedList_ linkedList = new LinkedList_();
        //添加元素
        System.out.println("*****头插法添加节点*****");
        for (int i = 0; i < 10; i++) {
            linkedList.addFirst(i);
        }
        linkedList.forList();
        //添加元素-尾插法
        System.out.println("*****尾插法添加节点*****");
        linkedList.addTail(10);
        linkedList.forList();
        System.out.println("*****尾插法添加节点*****");
        linkedList.insertPos(3, 20);
        linkedList.forList();
        System.out.println("*****删除节点*****");
        linkedList.remove(3);
        linkedList.forList();
        System.out.println("*****删除第一个节点*****");
        linkedList.removeFirst();
        linkedList.forList();
        System.out.println("*****删除尾节点*****");
        linkedList.removeLast();
        linkedList.forList();
        System.out.println("*****修改节点数据*****");
        linkedList.set(3, 100);
        linkedList.forList();
        System.out.println("*****修改第一个节点数据*****");
        linkedList.setFirst(-1);
        linkedList.forList();
        System.out.println("*****修改尾节点数据*****");
        linkedList.setLast(100);
        linkedList.forList();
        System.out.println("*****获取节点数据*****");
        System.out.println(linkedList.get(3));
        System.out.println("*****获取第一个节点数据*****");
        System.out.println(linkedList.getFirst());
        System.out.println("*****获取节点数据*****");
        System.out.println(linkedList.getLast());
    }
}
