package Basic.chap2_List;

/**
 * 数组长度不可变导致实用性降低。在许多情况下，
 * 我们事先无法确定需要存储多少数据，这使数组长度的选择变得困难。
 * 1、若长度过小，需要在持续添加数据时频繁扩容数组；
 * 2、若长度过大，则会造成内存空间的浪费。
 * 为解决此问题，出现了一种被称为「动态数组 Dynamic Array」的数据结构，
 * 即长度可变的数组，也常被称为「列表 List」
 * 在运行过程中动态扩容，可以自由添加元素，无需担心超过容量
 * <p>
 * 程序任务:
 * 1、初始化列表
 * 2、实现增删改查
 * 3、数组扩容
 */
public class ArrayList_<T> {
    private static final Object[] EMPTY_ELEMENTDATA = {};
    private static int CAPACITY = 10;
    private final int extendRatio = 2;  //数组扩容倍数
    private Object[] elementData;
    //元素个数
    private int size = 0;


    public ArrayList_() {
        this.elementData = new Object[CAPACITY];
    }

    public ArrayList_(int initialCapacity) {
        if (initialCapacity > 0) {
            CAPACITY = initialCapacity;
            this.elementData = new Object[CAPACITY];
        } else if (initialCapacity == 0) {
            this.elementData = EMPTY_ELEMENTDATA;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
    }

    /**
     * 末尾增添元素
     * T(n)=O(n)
     */
    public void add(T value) {
        //判断数组容量大小
        if (size == CAPACITY) {
            extendArray();
        }
        elementData[size] = value;
        size++;
    }

    /**
     * 插入元素
     *
     * @param index
     * @param value
     */
    public void insert(int index, T value) {
        //判断索引是否合法
        checkIndex(index);
        //判断数组容量大小
        if (size == CAPACITY) {
            extendArray();
        }
        //元素向后移动
        for (int i = elementData.length - 1; i > index; i--) {
            elementData[i] = elementData[i - 1];
        }
        elementData[index] = value;
        //元素个数+1
        size++;
    }

    /**
     * 删除元素
     * T(n)=O(n)
     *
     * @param index
     */
    public void remove(int index) {
        checkIndex(index);
        //只循环到存在的元素位置
        for (int i = index; i < size - 1; i++) {
            elementData[i] = elementData[i + 1];
        }
        elementData[size - 1] = null;
        //元素个数-1
        size--;
    }

    /**
     * 修改元素
     *
     * @param index
     * @param value
     */
    public void set(int index, int value) {
        checkIndex(index);
        elementData[index] = value;
    }

    /**
     * 查询数据
     */
    public T get(int index) {
        checkIndex(index);
        return elementData_(index);
    }

    /**
     * 数组类型向下转型
     *
     * @param index
     */
    T elementData_(int index) {
        return (T) elementData[index];
    }

    /**
     * 数组扩容
     */
    public void extendArray() {
        //更新列表容量
        CAPACITY = CAPACITY * extendRatio;
        Object[] objects = new Object[CAPACITY];
        //将原来的元素复制到新数组
        System.arraycopy(elementData, 0, objects, 0, elementData.length);
        //更新数组
        elementData = objects;
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


    /**
     * 判断索引是否合法
     *
     * @param index
     */
    public void checkIndex(int index) {
        if (index < 0 || index > elementData.length - 1) {
            throw new IndexOutOfBoundsException("索引越界");
        }
    }

    /**
     * 返回数组容量
     */
    public int length() {
        return CAPACITY;
    }

    /**
     * 返回元素个数
     */
    public int getSize() {
        return size;
    }
}
