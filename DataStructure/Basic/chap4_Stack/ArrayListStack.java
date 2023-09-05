package Basic.chap4_Stack;

/**
 * Rainbow
 * 基于动态数组实现栈
 *
 * @DATE:2023/7/12 0012
 */
public class ArrayListStack<T> {
    private final int ratio = 2;   //数组扩容倍数
    private int CAPACITY = 10;  //数组默认容量
    private int size = 0;  //元素个数
    private Object[] elementData;  //存放数组个数

    public ArrayListStack() {
        elementData = new Object[CAPACITY];  //默认数组长度
    }

    /**
     * 自定义栈的长度
     * @param capacity
     */
    public ArrayListStack(int capacity) {
        CAPACITY = capacity;
        elementData = new Object[CAPACITY];
    }

    /**
     * 入栈
     * size记录元素个数，同时也可以作为数组的下一个索引
     * 每次入栈，size++
     * @param value
     */
    public void push(T value) {
        //判断是否栈满
        if (isFull()) {
            //扩容
            extendArray();
            elementData[size] = value;
        } else {
            elementData[size] = value;
        }
        size++;  //元素个数+1
    }
    /**
     * 出栈
     * 1、判断栈是否为空
     * 2、temp临时存储弹出的元素
     * 3、元素个数-1
     */
    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈为空");
        } else {
            int index = size - 1;
            //元素向下转型
            T temp = (T) elementData[index];
            elementData[index] = null;
            size--;  //元素个数-1
            return temp;
        }
    }

    /**
     * 访问栈顶元素，不是删除元素
     */
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("栈为空");
        } else {
            return (T) elementData[size - 1];
        }
    }

    /**
     * 判断栈是否为空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 返回元素个数
     */
    public int getSize() {
        return size;
    }

    /**
     * 数组扩容
     */
    public void extendArray() {
        CAPACITY = ratio * CAPACITY;  //容量扩大两倍
        Object[] objects = new Object[CAPACITY];
        //将原来的元素复制到新数组
        System.arraycopy(elementData, 0, objects, 0, elementData.length);
        //更新数组
        elementData = objects;
    }

    /**
     * 判断栈是否满
     * COUNT记录元素个数，同时也是数组的索引
     * 1、栈满：COUNT==CAPACITY
     */
    public boolean isFull() {
        return size == CAPACITY;
    }

    /**
     * 遍历列表元素
     */
    public void forEach() {
        System.out.print("[");
        for (int i = 0; i < elementData.length; i++) {
            if (i == elementData.length - 1) {
                System.out.print(elementData[i]);
            } else {
                System.out.print(elementData[i] + ",");
            }
        }
        System.out.println("]");
    }

}
