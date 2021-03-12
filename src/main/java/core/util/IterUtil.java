package core.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @ProjectName: yoTool
 * @Package: core.util
 * @ClassName: IterUtil
 * @Description: {@link Iterator}和{@link Iterable}相关工具类
 * @Author: Young
 * @CreateDate: 2021/2/8 22:11
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/2/8 22:11
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class IterUtil {

    /**
     * 是否为空
     *
     * @param iterator 目标对象
     * @return 是否为空
     */
    public static boolean isEmpty(Iterator<?> iterator) {
        return null == iterator || !iterator.hasNext();
    }

    /**
     * 是否为空
     *
     * @param iterable 目标对象
     * @return 是否为空
     */
    public static boolean isEmpty(Iterable<?> iterable) {
        return null == iterable || isEmpty(iterable.iterator());
    }

    /**
     * 是否不为空
     *
     * @param iterator 目标对象
     * @return 是否不为空
     */
    public static boolean isNotEmpty(Iterator<?> iterator) {
        return null != iterator && iterator.hasNext();
    }

    /**
     * 是否不为空
     *
     * @param iterable 目标对象
     * @return 是否不为空
     */
    public static boolean isNotEmpty(Iterable<?> iterable) {
        return null != iterable && isNotEmpty(iterable.iterator());
    }

    /**
     * 是否包含null元素
     *
     * @param iterator 被检查对象
     * @return 是否包含
     */
    public static boolean hasNull(Iterator<?> iterator) {
        if (null == iterator)
            return true;
        while (iterator.hasNext()) {
            if (null == iterator.next()) {
                return true;
            }
        }
        return false;
    }

    /**
     * 是否包含null元素
     *
     * @param iterable 被检查对象
     * @return 是否包含
     */
    public static boolean hasNull(Iterable<?> iterable) {
        return hasNull(null == iterable ? null : iterable.iterator());
    }

    /**
     * 是否全部元素为null
     *
     * @param iterator 被检查对象
     * @return 是否全部元素为null
     */
    public static boolean isAllNull(Iterator<?> iterator) {
        if (null == iterator) {
            return true;
        }
        while (iterator.hasNext()) {
            if (null != iterator.next()) {
                return false;
            }
        }
        return true;
    }

    /**
     * 是否全部元素为null
     *
     * @param iterable 被检查对象
     * @return 是否全部元素为null
     */
    public static boolean isAllNull(Iterable<?> iterable) {
        return isAllNull(null == iterable ? null : iterable.iterator());
    }

    /**
     * 根据集合返回一个元素计数的 {@link Map}
     * 所谓元素计数就是假如这个集合中某个元素出现了n次，那将这个元素做为key，n做为value<br>
     * 例如：[a,b,c,c,c] 得到：
     * a: 1
     * b: 1
     * c: 3
     *
     * @param <T>      集合元素类型
     * @param iterator {@link Iterator}，如果为null返回一个空的Map
     * @return {@link Map}
     */
    public static <T> Map<T, Integer> countMap(Iterator<T> iterator) {
        final HashMap<T, Integer> countMap = new HashMap<>();
        if (null != iterator) {
            Integer count;
            T t;
            while (iterator.hasNext()) {
                t = iterator.next();
                count = countMap.get(t);
                if (null == count) {
                    countMap.put(t, 1);
                } else {
                    countMap.put(t, count + 1);
                }
            }
        }
        return countMap;
    }
}
