package Array;

import java.util.concurrent.ThreadLocalRandom;

/**
 * demo1
 *
 * @author Rainbow
 * @version 1.0
 * @description 数组的初始化和相关操作
 * @date 2023/6/22 0022 9:49
 * 数组是一种线性结构，将相同类型的元素存储在连续的内存空间中。
 * 将元素在数组的中的位置成为索引[index]
 */
public class array {
    public static void main(String[] args) {
        //初始化数组
        int[] initArr = initArray();
        //获取数组的内存地址
        int memoryAddress = memoryIndexOfArray(initArr, 4);
        System.out.println("访问数组元素的内存地址:" + memoryAddress);
        //随机访问数组元素
        int elementRandomAccess = getElementRandomAccess(initArr);
        System.out.println("随机访问数组元素:" + elementRandomAccess);
        //扩展空间
        int[] extendArr = extendNewArr(initArr,10);
        System.out.print("原来的数组:");
        listArr(initArr);
        System.out.println("扩展后:");
        listArr(extendArr);
        //插入元素
        System.out.println("插入元素");
        insertElementByIndex(initArr,8,3);
        listArr(initArr);
        //删除元素s
        System.out.println("删除元素");
        deleteElementByIndex(initArr,2);
        listArr(initArr);

    }

    /**
     * @description: 遍历数组元素
     * @param: [arr]
     * @return: void
     * @T(n)=O(n)
     **/
    public static void listArr(int[] arr) {
        System.out.print("[");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]);
            if(i<arr.length-1){
                System.out.print(",");
            }
        }
        System.out.println("]");
    }


    /**
     * @return: int[]
     * @description: 初始化创建数组的方式有两种
     * 1、指定数组的空间大小
     * 2、直接给定初始值，并且指定空间大小
     **/
    public static int[] initArray() {
        int[] arr1 = new int[5];  //无初始值
        int[] arr2 = {1, 2, 3, 4, 5};  //给定初始值
        return arr2;
    }

    /**
     * @description: 获取各个元素的内存地址
     * @param: [arr, index]
     * @return: int
     * 数组元素被存储在连续的内存空间中，访问元素十分高效，因此计算元素的内存空间十分容易。
     * memory=firstElementAddress+elementLength*elementIndex
     * 索引[index]本质上表示的是内存地址的偏移量。
     * 首个元素的地址偏移量（firstElementAddress）=0，index=0
     **/
    public static int memoryIndexOfArray(int[] arr, int index) {
        if (index > arr.length - 1) {  //-1：index不存在
            return -1;
        }
        return (arr.length - 1) * index;
    }

    /**
     * @description: 随机访问数组元素（数组的优点）
     * @param: [arr]
     * @return: int
     * @T(n)=O(1)
     **/
    public static int getElementRandomAccess(int[] arr) {
        //在[0,arr.length]中随机抽取一个数字
        int randomIndex = ThreadLocalRandom.current().nextInt(0, arr.length);
        //返回随即元素
        return arr[randomIndex];
    }

    /**
     * @description: 扩展数组空间（缺点）
     * @param: [arr, enlarge]
     * @return: int[]
     * @T(n)=O(n) 由于系统保证数组之后的内存空间可用，数组空间无法扩展。
     * 如果想要扩展数组空间，则需要再创建一个新的更大空间的数组(newArr)
     * 将原来的元素复制到新数组(newArr)，如果数组很大，则十分耗时。
     **/
    public static int[] extendNewArr(int[] arr, int enlarge) {
        //初始化一个空间扩展后的数组
        int[] newArr = new int[enlarge];
        //将元素复制到新数组
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        return newArr;
    }
    
    /**
     * @description: 插入元素（缺点）
     * @param: [arr, num, index]
     * @return: void
     * @T(n)=O(n)
     * 由于数组元素在内存中是”紧挨着“，它们之间没有空间存放数据，所以要在数组中间插入元素，
     * 1、判断index是否合法（超出数组的索引范围）
     * 2、索引之后的所有元素向后移动
     * 3、插入新元素
     **/
    public static void insertElementByIndex(int[] arr,int num,int index){
        if(index>arr.length-1){
            return;
        }
        for(int i=arr.length-1;i>index;i--){
            arr[i]=arr[i-1];
        }
        arr[index]=num;
    }
    
    /**
     * @description:  删除元素
     * @param: [arr, index]
     * @return: void
     * @T(n)=
     * 删除arr[index]元素后，需要将index之后的所有元素向前移动
     * 1、判断index是否合法
     * 2、删除arr[index]
     * 3、index之后的所有元素向前移动
     **/
    public static void deleteElementByIndex(int[] arr,int index){
        if(index>arr.length-1){
            return;
        }
        for(int i=index;i<arr.length-1;i++){
            arr[i]=arr[i+1];
        }
        arr[arr.length-1]=0;
    }
    
    /**
     * 优点:
     *  1、数组在访问元素T(n)=O(1)，访问速度快
     * 缺点：
     *  1、时间复杂度高：对于删除和插入元素，T(n)=O(n)
     *  2、丢失元素：数组的空间不可变，插入元素后，超出空间访问的元素丢失
     *  3、内存浪费：初始化一个比较大空间的数组，只用一部分
     **/
}
