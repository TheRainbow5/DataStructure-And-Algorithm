package Queue;

/**
 * Rainbow
 * 队列遵循先进先出原则的线性结构
 * 队首  <--出列--[1,2,3,4,4,5,6]<--入列--   队尾
 *
 * @DATE:2023/7/13 0013
 */
public class ArrayQueue<T> {
    private final int ratio = 2;   //数组扩容倍数
    private int CAPACITY = 10;  //数组默认容量
    private int size = 0;  //元素个数
    private int front=0; //遍历元素的索引
    private Object[] elementData;  //存放数组个数

    public ArrayQueue() {
        elementData = new Object[CAPACITY];
    }

    public ArrayQueue(int capacity) {
        this.CAPACITY = capacity;
        elementData = new Object[CAPACITY];
    }

    /**
     * 添加元素
     *
     * @param value
     */
    public void push(T value) {
        //判断是否栈满
        if (isFull()) {
            System.out.println("队列已满，扩容");
            //扩容
            extendArray();
            elementData[size] = value;
        } else {
            elementData[size] = value;
        }
        size++;  //元素个数+1
    }


    /**
     * 出列
     * 1、front索引用于访问队列，实际元素仍保留在数组中
     * 降低时间复杂度T(n)=O(1)
     * @return
     */
    public T pop() {
        //判断是否为空
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        } else {
            T temp = (T) elementData[front];
            // 队首指针向后移动一位，若越过尾部则返回到数组头部
            front = (front + 1) % CAPACITY;
            size--;
            return temp;
        }
    }

    /**
     * 访问队首元素，不是删除队首元素
     */
    public T peek() {
        return (T) elementData[front];
    }


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
