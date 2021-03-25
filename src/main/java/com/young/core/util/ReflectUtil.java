package com.young.core.util;

import com.sun.xml.internal.ws.util.UtilException;
import com.young.core.lang.SimpleCache;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @ProjectName: yoTool
 * @Package: com.young.core.util
 * @ClassName: ReflectUtil
 * @Description: 反射工具类
 * @Author: Young
 * @CreateDate: 2021/3/26 1:52
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/3/26 1:52
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class ReflectUtil {

    /**
     * 构造对象缓存
     */
    private static final SimpleCache<Class<?>, Constructor<?>[]> CONSTRUCTORS_CACHE = new SimpleCache<>();

    /**
     * 字段缓存
     */
    private static final SimpleCache<Class<?>, Field[]> FIELDS_CACHE = new SimpleCache<>();

    /**
     * 方法缓存
     */
    private static final SimpleCache<Class<?>, Method[]> METHODS_CACHE = new SimpleCache<>();

    /**
     * 实例化对象
     *
     * @param <T>   对象类型
     * @param clazz 类名
     * @return 对象
     * @throws UtilException 包装各类异常
     */
    @SuppressWarnings("unchecked")
    public static <T> T newInstance(String clazz) throws UtilException {
        try {
            return (T) Class.forName(clazz).newInstance();
        } catch (Exception e) {
            throw new UtilException(e, "Instance class [{}] error!", clazz);
        }
    }
}
