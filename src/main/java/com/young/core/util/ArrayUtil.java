package com.young.core.util;

import com.young.core.comparator.CompareUtil;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @ProjectName: yoTool
 * @Package: com.young.core.util
 * @ClassName: ArrayUtil
 * @Description: 数组工具类（扩展了面向对象层面方法）
 * @Author: Young
 * @CreateDate: 2021/2/7 23:31
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/2/7 23:31
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class ArrayUtil extends BasicTypeArrayUtil {

    /**
     * 数组是否为空
     *
     * @param array 对象数组
     * @param <T>   数组元素类型
     * @return 是否为空
     */
    public static <T> boolean isEmpty(T[] array) {
        return array == null || array.length == 0;
    }

    /**
     * 数组是否不为空
     *
     * @param array 对象数组
     * @param <T>   数组元素类型
     * @return 是否不为空
     */
    public static <T> boolean isNotEmpty(T[] array) {
        return !isEmpty(array);
    }

    /**
     * 如果目标数组为空时，返回指定默认数组
     *
     * @param array        目标数组
     * @param defaultArray 默认数组
     * @param <T>          数组元素类型
     * @return 目标数组或默认数组
     */
    public static <T> T[] defaultIfEmpty(T[] array, T[] defaultArray) {
        return isEmpty(array) ? defaultArray : array;
    }

    /**
     * 创建目标元素类型定长数组
     *
     * @param typeName 元素类型名称
     * @param size     数组长度
     * @param <T>      元素类型
     * @return 定长空数组
     */
    @SuppressWarnings("unchecked")
    public static <T> T[] newArray(Class<?> typeName, int size) {
        return (T[]) Array.newInstance(typeName, size);
    }

    /**
     * 新建无长度目标元素类型数组
     *
     * @param typeName 元素类型名称
     * @param <T>      元素类型
     * @return 无长度空数组
     */
    public static <T> T[] newArray(Class<?> typeName) {
        return newArray(typeName, 0);
    }

    /**
     * 拷贝源数组至给定长度新数组中
     * 源数组长度不足则截断，过长则保留前N位
     *
     * @param array    源数组
     * @param newSize  新数组长
     * @param typeName 元素类型名称
     * @param <T>      元素类型
     * @return 新数组
     */
    public static <T> T[] resize(T[] array, int newSize, Class<?> typeName) {
        if (newSize < 0) {
            return array;
        }
        final T[] newArray = newArray(typeName, newSize);
        if (newSize > 0 && isNotEmpty(array)) {
            System.arraycopy(array, 0, newArray, 0, Math.min(array.length, newSize));
        }
        return newArray;
    }

    /**
     * 对象是否为数组对象
     *
     * @param obj 对象
     * @return 是否为数组对象，如果为{@code null} 返回false
     */
    public static boolean isArray(Object obj) {
        if (null == obj) {
            // throw new NullPointerException("Object check for isArray is null");
            return false;
        }
        return obj.getClass().isArray();
    }

    /**
     * 获取数组长度
     *
     * @param array 数组对象
     * @return 数组长度
     * @throws IllegalArgumentException 如果参数不为数组，抛出此异常
     */
    public static int length(Object array) throws IllegalArgumentException {
        if (null == array) {
            return 0;
        }
        return Array.getLength(array);
    }

    /**
     * 拷贝源数组至给定长度新数组中
     * 源数组长度不足则截断，过长则保留前N位
     *
     * @param array   源数组
     * @param newSize 新数组长
     * @param <T>     元素类型
     * @return 新数组
     */
    public static <T> T[] resize(T[] array, int newSize) {
        return resize(array, newSize, array.getClass().getComponentType());
    }

    /**
     * 获取数组对象中指定index的值，支持负数，例如-1表示倒数第一个值
     * 如果数组下标越界，返回null
     *
     * @param <T>   数组元素类型
     * @param array 数组对象
     * @param index 下标，支持负数
     * @return 值
     */
    @SuppressWarnings("unchecked")
    public static <T> T get(Object array, int index) {
        if (null == array) {
            return null;
        }
        if (index < 0) {
            index += Array.getLength(array);
        }
        try {
            return (T) Array.get(array, index);
        } catch (ArrayIndexOutOfBoundsException e) {
            return null;
        }
    }

    /**
     * 多数组合并
     *
     * @param arrays 多数组
     * @param <T>    元素类型
     * @return 合并后新数组
     */
    public static <T> T[] addAll(T[]... arrays) {
        if (arrays.length == 1) {
            return arrays[0];
        }
        int len = 0;
        for (T[] array : arrays) {
            if (array != null) {
                len += array.length;
            }
        }
        final T[] result = newArray(arrays.getClass().getComponentType(), len);
        len = 0;
        for (T[] array : arrays) {
            if (array != null) {
                System.arraycopy(array, 0, result, len, array.length);
            }
        }
        return result;
    }

    /**
     * 返回指定元素在目标数组中首次出现位置
     * 无目标元素返回{@link #INDEX_OVER}
     *
     * @param array 目标数组
     * @param value 指定元素
     * @param <T>   元素类型
     * @return 指定元素在目标数组中首次出现位置, 无目标元素返回{@link #INDEX_OVER}
     */
    public static <T> int indexOf(T[] array, T value) {
        if (isNotEmpty(array)) {
            for (int i = 0; i < array.length; i++) {
                if (value == array[i]) {
                    return i;
                }
            }
        }
        return INDEX_OVER;
    }

    /**
     * 返回指定元素在目标数组中最后出现位置
     * 无目标元素返回{@link #INDEX_OVER}
     *
     * @param array 目标数组
     * @param value 指定元素
     * @param <T>   元素类型
     * @return 指定元素在目标数组中最后出现位置, 无目标元素返回{@link #INDEX_OVER}
     */
    public static <T> int lastIndexOf(T[] array, T value) {
        if (isNotEmpty(array)) {
            for (int i = array.length - 1; i >= 0; i--) {
                if (value == array[i]) {
                    return i;
                }
            }
        }
        return INDEX_OVER;
    }

    /**
     * 检查数组中是否包含指定元素
     *
     * @param array 目标数组
     * @param value 指定元素
     * @param <T>   元素类型
     * @return 是否包含
     */
    public static <T> boolean contains(T[] array, T value) {
        return indexOf(array, value) > INDEX_OVER;
    }

    /**
     * 检查数组中是否包含若干指定元素中的任意一个
     *
     * @param array  目标数组
     * @param values 若干指定元素
     * @param <T>    元素类型
     * @return 是否包含
     */
    @SuppressWarnings("unchecked")
    public static <T> boolean containsAny(T[] array, T... values) {
        for (T value : values) {
            if (contains(array, value)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 检查数组是否包含若干指定元素中的所有元素
     *
     * @param array  目标数组
     * @param values 若干指定元素
     * @param <T>    元素类型
     * @return 是否包含
     */
    @SuppressWarnings("unchecked")
    public static <T> boolean containsAll(T[] array, T... values) {
        for (T value : values) {
            if (!contains(array, value)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 提取子数组
     *
     * @param array 原始数组
     * @param start 起始下标
     * @param end   结束下标+1
     * @param <T>   元素类型
     * @return 子数组
     */
    public static <T> T[] sub(T[] array, int start, int end) {
        if (isEmpty(array)) {
            return array;
        }
        int len = array.length;
        if (start < 0) {
            start += len;
        }
        if (end < 0) {
            end += len;
        }
        if (start == len) {
            return newArray(array.getClass().getComponentType(), 0);
        }
        if (start > end) {
            int temp = start;
            start = end;
            end = temp;
        }
        if (end > len) {
            if (start >= len) {
                return newArray(array.getClass().getComponentType(), 0);
            }
            end = len;
        }
        return Arrays.copyOfRange(array, start, end);
    }

    /**
     * 获取子数组
     *
     * @param array 原始数组
     * @param start 起始下标
     * @param end   结束下标+1
     * @return 子数组
     */
    public static Object[] sub(Object array, int start, int end) {
        return sub(array, start, end, 1);
    }

    /**
     * 获取子数组
     *
     * @param array 原始数组
     * @param start 起始下标
     * @param end   结束下标+1
     * @param step  步进
     * @return 子数组
     */
    public static Object[] sub(Object array, int start, int end, int step) {
        int length = length(array);
        if (start < 0) {
            start += length;
        }
        if (end < 0) {
            end += length;
        }
        if (start == length) {
            return new Object[0];
        }
        if (start > end) {
            int tmp = start;
            start = end;
            end = tmp;
        }
        if (end > length) {
            if (start >= length) {
                return new Object[0];
            }
            end = length;
        }
        if (step <= 1) {
            step = 1;
        }
        final ArrayList<Object> list = new ArrayList<>();
        for (int i = start; i < end; i += step) {
            list.add(get(array, i));
        }
        return list.toArray();
    }

    /**
     * 交换目标数组中的两个指定元素
     *
     * @param array  目标数组
     * @param index1 指定元素位置1
     * @param index2 指定元素位置2
     * @param <T>    元素类型
     * @return 交换后数组（等价于参数array）
     */
    public static <T> T[] swap(T[] array, int index1, int index2) {
        if (isEmpty(array)) {
            return array;
        }
        T temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
        return array;
    }

    /**
     * 反转数组
     *
     * @param array 原始数组，即结果数组
     * @param start 开始位置
     * @param end   结束位置，不包括
     * @param <T>   元素类型
     * @return 反转后数组
     */
    public static <T> T[] reverse(T[] array, int start, int end) {
        if (isEmpty(array)) {
            return array;
        }
        int i = Math.max(start, 0);
        int j = Math.min(array.length, end) - 1;
        while (j > i) {
            swap(array, i, j);
            j--;
            i++;
        }
        return array;
    }

    /**
     * 反转数组
     *
     * @param array 原始数组
     * @return 反转后数组
     */
    public static <T> T[] reverse(T[] array) {
        return reverse(array, 0, array.length);
    }

    /**
     * 获取数组对象的元素类型
     *
     * @param arrayClass 被检查数组类型
     * @return 元素类型
     */
    public static Class<?> getComponentType(Class<?> arrayClass) {
        return null == arrayClass ? null : arrayClass.getComponentType();
    }

    /**
     * 获取数组对象的元素类型
     *
     * @param array 被检查数组对象
     * @return 元素类型
     */
    public static Class<?> getComponentType(Object array) {
        return null == array ? null : array.getClass().getComponentType();
    }

    /**
     * 根据元素类型返回数组类型
     *
     * @param componentType 元素类型
     * @return 指定元素数组类型
     */
    public static Class<?> getArrayType(Class<?> componentType) {
        return newArray(componentType).getClass();
    }

    /**
     * 在指定位置插入若干指定元素
     *
     * @param array       源数组
     * @param index       插入位置
     * @param newElements 若干指定元素
     * @param <T>         元素类型
     * @return 插入元素后新数组, 不影响源数组结构
     */
    @SuppressWarnings({"unchecked"})
    public static <T> T[] insert(T[] array, int index, T... newElements) {
        if (isEmpty(newElements)) {
            return array;
        }
        if (isEmpty(array)) {
            return newElements;
        }
        final int len = array.length;
        if (index < 0) {
            index = (index % len) + len;
        }
        final T[] result = newArray(array.getClass().getComponentType(), Math.max(len, index) + newElements.length);
        System.arraycopy(array, 0, result, 0, Math.min(len, index));
        System.arraycopy(newElements, 0, result, index, newElements.length);
        if (index < len) {
            System.arraycopy(array, index, result, index + newElements.length, len - index);
        }
        return result;
    }

    /**
     * 在源数组末尾添加若干指定元素
     * 并返回一个新的数组，不影响源数组结构
     *
     * @param array       源数组
     * @param newElements 若干指定元素
     * @param <T>         元素类型
     * @return 新数组
     */
    @SuppressWarnings("unchecked")
    public static <T> T[] append(T[] array, T... newElements) {
        if (isEmpty(array)) {
            return newElements;
        }
        return insert(array, array.length, newElements);
    }

    /**
     * 取最小值
     *
     * @param numberArray 可排序数组
     * @param <T>         元素类型
     * @return 最小值
     */
    public static <T extends Comparable<? super T>> T min(T[] numberArray) {
        return min(numberArray, null);
    }

    /**
     * 取最小值
     *
     * @param numberArray 可排序数组
     * @param comparator  比较器
     * @param <T>         元素类型
     * @return 最小值
     */
    public static <T extends Comparable<? super T>> T min(T[] numberArray, Comparator<T> comparator) {
        if (isEmpty(numberArray)) {
            throw new IllegalArgumentException("Number array must not empty !");
        }
        T min = numberArray[0];
        for (T t : numberArray) {
            /*if (CompareUtil.compare(min, t, comparator) > 0) {
                min = t;
            }*/
        }
        //TODO
        return min;
    }

    /**
     * 打乱数组顺序，会变更源数组
     *
     * @param array  源数组
     * @param random 随机数生成器
     * @param <T>    元素类型
     * @return 无序随机数组
     */
    public static <T> T[] shuffle(T[] array, Random random) {
        if (array == null || random == null || array.length <= 1) {
            return array;
        }

        for (int i = array.length; i > 1; i--) {
            swap(array, i - 1, random.nextInt(i));
        }

        return array;
    }

    /**
     * 数组或集合转String
     *
     * @param obj 集合或数组对象
     * @return 数组字符串，与集合转字符串格式相同
     */
    public static String toString(Object obj) {
        if (null == obj) {
            return null;
        }

        if (obj instanceof long[]) {
            return Arrays.toString((long[]) obj);
        } else if (obj instanceof int[]) {
            return Arrays.toString((int[]) obj);
        } else if (obj instanceof short[]) {
            return Arrays.toString((short[]) obj);
        } else if (obj instanceof char[]) {
            return Arrays.toString((char[]) obj);
        } else if (obj instanceof byte[]) {
            return Arrays.toString((byte[]) obj);
        } else if (obj instanceof boolean[]) {
            return Arrays.toString((boolean[]) obj);
        } else if (obj instanceof float[]) {
            return Arrays.toString((float[]) obj);
        } else if (obj instanceof double[]) {
            return Arrays.toString((double[]) obj);
        } else if (ArrayUtil.isArray(obj)) {
            // 对象数组
            try {
                return Arrays.deepToString((Object[]) obj);
            } catch (Exception ignore) {
                //ignore
            }
        }

        return obj.toString();
    }

    /**
     * 数组是否为空
     *
     * @param array 数组
     * @return 是否为空
     */
    public static boolean isEmpty(Object array) {
        if (array != null) {
            if (isArray(array)) {
                return 0 == Array.getLength(array);
            }
            return false;
        }
        return true;
    }

    /**
     * 数组是否为非空
     *
     * @param array 数组
     * @return 是否为非空
     */
    public static boolean isNotEmpty(Object array) {
        return !isEmpty(array);
    }

    /**
     * 是否包含{@code null}元素
     *
     * @param <T>   数组元素类型
     * @param array 被检查的数组
     * @return 是否包含{@code null}元素
     */
    @SuppressWarnings("unchecked")
    public static <T> boolean hasNull(T... array) {
        if (isNotEmpty(array)) {
            for (T element : array) {
                if (null == element) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 取最大值
     *
     * @param <T>         元素类型
     * @param numberArray 数字数组
     * @return 最大值
     */
    public static <T extends Comparable<? super T>> T max(T[] numberArray) {
        return max(numberArray, null);
    }

    /**
     * 取最大值
     *
     * @param <T>         元素类型
     * @param numberArray 数字数组
     * @param comparator  比较器，null表示默认比较器
     * @return 最大值
     */
    public static <T extends Comparable<? super T>> T max(T[] numberArray, Comparator<T> comparator) {
        if (isEmpty(numberArray)) {
            throw new IllegalArgumentException("Number array must not empty !");
        }
        T max = numberArray[0];
        for (int i = 1; i < numberArray.length; i++) {
            if (CompareUtil.compare(max, numberArray[i], comparator) < 0) {
                max = numberArray[i];
            }
        }
        return max;
    }
}
