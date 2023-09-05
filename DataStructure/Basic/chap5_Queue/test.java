package Basic.chap5_Queue;

import org.junit.Test;

/**
 * Rainbow
 *
 * @DATE:2023/7/13 0013
 */
public class test {
    @Test
    public void testArrayQueue() {
        ArrayQueue<Integer> integerArrayQueue = new ArrayQueue<>();
        System.out.println("****入列****");
        for (int i = 0; i < 10; i++) {
            integerArrayQueue.push(i);
        }
        integerArrayQueue.push(10);
        integerArrayQueue.forEach();
        System.out.println("****出列****");
        System.out.println("出列元素：" + integerArrayQueue.pop());
        integerArrayQueue.forEach();
        System.out.println("队首元素=" + integerArrayQueue.peek());

    }

    @Test
    public void testLinkedListQueue() {
        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        System.out.println("****尾插法****");
        for (int i = 0; i < 10; i++) {
            linkedListQueue.push(i);
        }
        linkedListQueue.forEach();
        System.out.println("****弹出队首元素****");
        System.out.println("队首元素=" + linkedListQueue.pop());
        System.out.println("队首元素=" + linkedListQueue.pop());
        linkedListQueue.forEach();
        System.out.println("****访问队首元素****");
        System.out.println(linkedListQueue.peek());


    }
}
