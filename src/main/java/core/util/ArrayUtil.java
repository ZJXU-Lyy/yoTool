package core.util;

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

    
}
