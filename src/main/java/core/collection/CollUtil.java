package core.collection;

import core.util.IterUtil;

import java.util.*;

/**
 * @ProjectName: yoTool
 * @Package: core.collection
 * @ClassName: CollUtil
 * @Description: 作用描述
 * @Author: Young
 * @CreateDate: 2021/3/25 15:58
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/3/25 15:58
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class CollUtil {
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

    /**
     * @param collection1
     * @param collection2
     * @param <T>
     * @return
     */
    public static <T> Collection<T> union(Collection<T> collection1, Collection<T> collection2) {
        if (isEmpty(collection1))
            return new ArrayList<>(collection2);
        else if (isEmpty(collection2))
            return new ArrayList<>(collection1);
        final ArrayList<T> list = new ArrayList<>(Math.max(collection1.size(), collection2.size()));
        final Map<T, Integer> map1 = countMap(collection1);
        final Map<T, Integer> map2 = countMap(collection2);
        final Set<T> ts = newHashSet(collection2);
        ts.addAll(collection1);
        int m;
        for (T t : ts) {
            //TODO
        }
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

    /**
     * 新建一个HashSet
     *
     * @param <T> 集合元素类型
     * @param ts  元素数组
     * @return HashSet对象
     */
    @SafeVarargs
    public static <T> HashSet<T> newHashSet(T... ts) {
        return set(false, ts);
    }

    /**
     * 新建一个LinkedHashSet
     *
     * @param <T> 集合元素类型
     * @param ts  元素数组
     * @return HashSet对象
     */
    @SafeVarargs
    public static <T> LinkedHashSet<T> newLinkedHashSet(T... ts) {
        return (LinkedHashSet<T>) set(true, ts);
    }

    /**
     * 新建一个HashSet
     *
     * @param <T>      集合元素类型
     * @param isSorted 是否有序，有序返回 {@link LinkedHashSet}，否则返回 {@link HashSet}
     * @param ts       元素数组
     * @return HashSet对象
     */
    @SafeVarargs
    public static <T> HashSet<T> set(boolean isSorted, T... ts) {
        if (null == ts) {
            return isSorted ? new LinkedHashSet<>() : new HashSet<>();
        }
        int initialCapacity = Math.max((int) (ts.length / .75f) + 1, 16);
        final HashSet<T> set = isSorted ? new LinkedHashSet<>(initialCapacity) : new HashSet<>(initialCapacity);
        Collections.addAll(set, ts);
        return set;
    }

    /**
     * 新建一个HashSet
     *
     * @param <T>        集合元素类型
     * @param collection 集合
     * @return HashSet对象
     */
    public static <T> HashSet<T> newHashSet(Collection<T> collection) {
        return newHashSet(false, collection);
    }

    /**
     * 新建一个HashSet
     *
     * @param <T>        集合元素类型
     * @param isSorted   是否有序，有序返回 {@link LinkedHashSet}，否则返回{@link HashSet}
     * @param collection 集合，用于初始化Set
     * @return HashSet对象
     */
    public static <T> HashSet<T> newHashSet(boolean isSorted, Collection<T> collection) {
        return isSorted ? new LinkedHashSet<>(collection) : new HashSet<>(collection);
    }

    /**
     * 新建一个HashSet
     *
     * @param <T>      集合元素类型
     * @param isSorted 是否有序，有序返回 {@link LinkedHashSet}，否则返回{@link HashSet}
     * @param iter     {@link Iterator}
     * @return HashSet对象
     */
    public static <T> HashSet<T> newHashSet(boolean isSorted, Iterator<T> iter) {
        if (null == iter) {
            return set(isSorted, (T[]) null);
        }
        final HashSet<T> set = isSorted ? new LinkedHashSet<>() : new HashSet<>();
        while (iter.hasNext()) {
            set.add(iter.next());
        }
        return set;
    }

    /**
     * 新建一个HashSet
     *
     * @param <T>         集合元素类型
     * @param isSorted    是否有序，有序返回 {@link LinkedHashSet}，否则返回{@link HashSet}
     * @param enumeration {@link Enumeration}
     * @return HashSet对象
     */
    public static <T> HashSet<T> newHashSet(boolean isSorted, Enumeration<T> enumeration) {
        if (null == enumeration) {
            return set(isSorted, (T[]) null);
        }
        final HashSet<T> set = isSorted ? new LinkedHashSet<>() : new HashSet<>();
        while (enumeration.hasMoreElements()) {
            set.add(enumeration.nextElement());
        }
        return set;
    }
}
