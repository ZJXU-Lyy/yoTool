package core.util;

import java.lang.reflect.Array;

/**
 * @ProjectName: yoTool
 * @Package: core.util
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
     * @return 空数组
     */
    @SuppressWarnings("unchecked")
    public static <T> T[] newArray(Class<?> typeName, int size) {
        return (T[]) Array.newInstance(typeName, size);
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
}
