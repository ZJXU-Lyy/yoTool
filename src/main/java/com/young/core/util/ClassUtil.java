package com.young.core.util;

import java.lang.reflect.Type;

/**
 * @ProjectName: yoTool
 * @Package: com.young.core.util
 * @ClassName: ClassUtil
 * @Description: 类工具类
 * @Author: Young
 * @CreateDate: 2021/3/26 1:47
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/3/26 1:47
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class ClassUtil {
    /**
     * {@code null}安全的获取对象类型
     *
     * @param <T> 对象类型
     * @param obj 对象，如果为{@code null} 返回{@code null}
     * @return 对象类型，提供对象如果为{@code null} 返回{@code null}
     */
    @SuppressWarnings("unchecked")
    public static <T> Class<T> getClass(T obj) {
        return ((null == obj) ? null : (Class<T>) obj.getClass());
    }

    /**
     * 获得外围类
     * 返回定义此类或匿名类所在的类，如果类本身是在包中定义的，返回{@code null}
     *
     * @param clz 类
     * @return 外围类
     */
    public static Class<?> getEnclosingClass(Class<?> clz) {
        return null == clz ? null : clz.getEnclosingClass();
    }

    /**
     * 是否为顶层类，即定义在包中的类，而非定义在类中的内部类
     *
     * @param clz 类
     * @return 是否为顶层类
     */
    public static boolean isTopLevelClass(Class<?> clz) {
        if (null == clz) {
            return false;
        }
        return null == getEnclosingClass(clz);
    }

    /**
     * 获取类名
     *
     * @param obj      获取类名对象
     * @param isSimple 是否简单类名，如果为true，返回不带包名的类名
     * @return 类名
     */
    public static String getClassName(Object obj, boolean isSimple) {
        if (null == obj) {
            return null;
        }
        final Class<?> clz = obj.getClass();
        return getClassName(clz, isSimple);
    }

    /**
     * 获取类名
     * 类名并不包含“.class”这个扩展名<br>
     *
     * @param clz      类
     * @param isSimple 是否简单类名，如果为true，返回不带包名的类名
     * @return 类名
     */
    public static String getClassName(Class<?> clz, boolean isSimple) {
        if (null == clz) {
            return null;
        }
        return isSimple ? clz.getSimpleName() : clz.getName();
    }

    /**
     * 加载类
     *
     * @param <T>           对象类型
     * @param className     类名
     * @param isInitialized 是否初始化
     * @return 类
     */
    @SuppressWarnings("unchecked")
    public static <T> Class<T> loadClass(String className, boolean isInitialized) {
        return (Class<T>) ClassLoaderUtil.loadClass(className, isInitialized);
    }

    /**
     * 加载类并初始化
     *
     * @param <T>       对象类型
     * @param className 类名
     * @return 类
     */
    public static <T> Class<T> loadClass(String className) {
        return loadClass(className, true);
    }

    /**
     * 获得给定类的第一个泛型参数
     *
     * @param clazz 被检查的类，必须是已经确定泛型类型的类
     * @return {@link Class}
     */
    public static Class<?> getTypeArgument(Class<?> clazz) {
        return getTypeArgument(clazz, 0);
    }

    /**
     * 获得给定类的泛型参数
     *
     * @param clz   被检查的类，必须是已经确定泛型类型的类
     * @param index 泛型类型的索引号，即第几个泛型类型
     * @return {@link Class}
     */
    public static Class<?> getTypeArgument(Class<?> clz, int index) {
        final Type argumentType = TypeUtil.getTypeArgument(clz, index);
        return TypeUtil.getClass(argumentType);
    }
}
