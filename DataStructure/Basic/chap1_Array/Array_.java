package Basic.chap1_Array;

/**
 * 程序任务：
 * 1、数组的初始化
 * 2、增删改查
 * 3、访问元素地址
 *
 * @author Rainbow
 * @date 2023/7/4 0004
 */
public class Array_ {
    private final int[] objectData;
    //默认数组大小
    private int capacity = 10;
    private int lastIndex = 0;

    /**
     * 初始化数组有两种方式：
     * 1、有初始值：指定数组的大小、索引数值
     * 2、无初始值：指定了数组的大小
     * 这里以int类型数组举例说明
     */
    public Array_() {
        this.objectData = new int[this.capacity];
    }

    public Array_(int capacity) {
        this.capacity = capacity;
        this.objectData = new int[capacity];
    }

    /**
     * 查询数据
     * 数组通过索引访问元素，可以快速定位元素
     * T(n)=O(1)
     *
     * @param index：目标索引
     */
    public int getElement(int index) {
        return objectData[index];
    }

    /**
     * 修改数据
     *
     * @param index：目标索引
     * @param value：修改值
     */
    public void updateElement(int index, int value) {
        objectData[index] = value;
    }

    /**
     * 添加元素
     */
    public void insert(int value) {
        //获取元素
        objectData[lastIndex] = value;
        lastIndex++;
    }


    /**
     * 插入数据
     * 1、将目标索引之后的元素向后移动一位
     * 2、插入新数据
     * T(n)=O(n)
     *
     * @param index
     * @param value
     */
    public void insert(int index, int value) {
        for (int i = objectData.length - 1; i > index; i--) {
            objectData[i] = objectData[i - 1];
        }
        objectData[index] = value;
        //最后索引加1
        lastIndex++;
    }

    /**
     * 删除元素
     * 1、找到目标索引
     * 2、目标索引后面的元素向前移动一位
     *
     * @param index
     */
    public void remove(int index) {
        for (int i = index; i < objectData.length - 1; i++) {
            objectData[i] = objectData[i + 1];
        }
        objectData[objectData.length - 1] = 0;
        lastIndex--;
    }

    /**
     * 数组长度
     */
    public int length() {
        return objectData.length;
    }

    /**
     * 返回元素个数
     *
     * @return
     */
    public int elementLength() {
        return lastIndex;
    }

    /**
     * 数组中的元素在内存中是连续存放的，因此可以通过公式计算出每个元素在内存中的地址
     * address=索引最大值*当前索引
     * 问题：为什么数组元素的索引以0开始？
     * 索引在计算机中本质是内存地址的偏移量，
     */
    public int indexAddress(int index) {
        return (objectData.length - 1) * index;
    }

    /**
     * 遍历数组
     */
    public void listArray() {
        System.out.print("[");
        for (int i = 0; i < objectData.length; i++) {
            if (i == objectData.length - 1) {
                System.out.print(objectData[i]);
            } else {
                System.out.print(objectData[i] + ",");
            }
        }
        System.out.println("]");
    }
}
