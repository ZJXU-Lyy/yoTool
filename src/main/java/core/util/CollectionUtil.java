package core.util;

import java.util.*;

/**
 * @ProjectName: yoTool
 * @Package: core.util
 * @ClassName: CollectionUtil
 * @Description: 集合工具类
 * @Author: Young
 * @CreateDate: 2021/2/5 19:33
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/2/5 19:33
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class CollectionUtil {

    /**
     * 判断集合对象是否为空
     *
     * @param collection 集合对象
     * @return 布尔值
     */
    public static boolean isEmpty(Collection<?> collection) {
        return null == collection || collection.isEmpty();
    }

    /**
     * 判断集合对象是否不为空
     *
     * @param collection 集合对象
     * @return 布尔值
     */
    public static boolean isNotEmpty(Collection<?> collection) {
        return !isEmpty(collection);
    }

    /**
     * 当传入集合为null时，返回不可变的默认空集合，否则返回原集合
     * 空集合使用{@link Collections#emptySet()}
     *
     * @param set 提供的集合
     * @param <T> 集合元素类型
     * @return 原集合或空集合
     */
    public static <T> Set<T> emptyIfNull(Set<T> set) {
        return (null == set) ? Collections.emptySet() : set;
    }

    /**
     * 当传入集合为null时，返回不可变的默认空集合，否则返回原集合
     * 空集合使用{@link Collections#emptyList()}
     *
     * @param list 提供的集合
     * @param <T>  集合元素类型
     * @return 原集合或空集合
     */
    public static <T> List<T> emptyIfNull(List<T> list) {
        return (null == list) ? Collections.emptyList() : list;
    }

    public static <T> Collection<T> union(Collection<T> collection1, Collection<T> collection2) {
        if (isEmpty(collection1))
            return new ArrayList<>(collection2);
        else if (isEmpty(collection2))
            return new ArrayList<>(collection1);
        final ArrayList<T> list = new ArrayList<>(Math.max(collection1.size(), collection2.size()));
        final Map<T, Integer> map1 = countMap(collection1);
        final Map<T, Integer> map2 = countMap(collection2);
        final Set<T> ts;//TODO
        return null;
    }

    /**
     * 根据集合返回一个元素计数的 {@link Map}
     * 所谓元素计数就是假如这个集合中某个元素出现了n次，那将这个元素做为key，n做为value
     * 例如：[a,b,c,c,c] 得到：
     * a: 1
     * b: 1
     * c: 3
     *
     * @param <T>        集合元素类型
     * @param collection 集合
     * @return {@link Map}
     * @see IterUtil#countMap(Iterator)
     */
    public static <T> Map<T, Integer> countMap(Iterable<T> collection) {
        return IterUtil.countMap(null == collection ? null : collection.iterator());
    }

}
