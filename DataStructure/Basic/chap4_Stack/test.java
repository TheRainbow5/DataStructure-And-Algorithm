package Basic.chap4_Stack;

import org.junit.Test;

/**
 * Rainbow
 *
 * @DATE:2023/7/12 0012
 */
public class test {
    @Test
    public void testLinkedListStack() {
        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        System.out.println("****入栈****");
        for (int i = 0; i < 10; i++) {
            linkedListStack.push(i);
        }
        linkedListStack.forList();
        System.out.println("****出栈****");
        System.out.println("弹出: " + linkedListStack.pop());
        System.out.println("弹出: " + linkedListStack.pop());
        System.out.println("弹出: " + linkedListStack.pop());
        System.out.println("弹出: " + linkedListStack.pop());
        linkedListStack.forList();
        System.out.println("****访问栈顶****");
        System.out.println("栈顶元素: " + linkedListStack.peek());
    }

    @Test
    public void testArrayListStack() {
        ArrayListStack<Integer> arrayListStack = new ArrayListStack<>();
        System.out.println("****入栈****");
        for (int i = 0; i < 10; i++) {
            arrayListStack.push(i);
        }
        arrayListStack.forEach();
        System.out.println("****扩容****");
        arrayListStack.push(20);
        arrayListStack.forEach();
        System.out.println("****出栈****");
        System.out.println("弹出: " + arrayListStack.pop());
        System.out.println("弹出: " + arrayListStack.pop());
        arrayListStack.forEach();
        System.out.println("****访问栈顶元素****");
        System.out.println("栈顶: " + arrayListStack.peek());
        System.out.println("元数个数=" + arrayListStack.getSize());
    }
}
