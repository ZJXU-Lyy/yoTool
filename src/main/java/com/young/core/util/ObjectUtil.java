package com.young.core.util;

import com.young.core.io.FastByteArrayOutputStream;
import com.young.core.io.IoUtil;

import java.io.ByteArrayInputStream;
import java.io.Serializable;

/**
 * @ProjectName: yoTool
 * @Package: com.young.core.util
 * @ClassName: ObjectUtil
 * @Description: 对象工具类，包括判空、克隆、序列化等操作
 * @Author: Young
 * @CreateDate: 2021/3/26 1:23
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/3/26 1:23
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class ObjectUtil {

    /**
     * 检查对象是否为null
     *
     * @param obj 对象
     * @return 是否为null
     */
    public static boolean isNull(Object obj) {
        //noinspection ConstantConditions
        return null == obj || obj.equals(null);
    }

    /**
     * 检查对象是否不为null
     *
     * @param obj 对象
     * @return 是否为null
     */
    public static boolean isNotNull(Object obj) {
        //noinspection ConstantConditions
        return null != obj && !obj.equals(null);
    }

    /**
     * 如果给定对象为{@code null}返回默认值
     *
     * @param object       被检查对象
     * @param defaultValue 默认值
     * @param <T>          对象类型
     * @return 被检查对象为{@code null}返回默认值，否则返回原值
     */
    public static <T> T defaultIfNull(final T object, final T defaultValue) {
        return (null != object) ? object : defaultValue;
    }

    /**
     * 序列化<br>
     * 对象必须实现Serializable接口
     *
     * @param <T> 对象类型
     * @param obj 要被序列化的对象
     * @return 序列化后的字节码
     */
    public static <T> byte[] serialize(T obj) {
        if (!(obj instanceof Serializable)) {
            return null;
        }
        final FastByteArrayOutputStream byteOut = new FastByteArrayOutputStream();
        IoUtil.writeObjects(byteOut, false, (Serializable) obj);
        return byteOut.toByteArray();
    }

    /**
     * 反序列化<br>
     * 对象必须实现Serializable接口
     *
     * @param <T>   对象类型
     * @param bytes 反序列化的字节码
     * @return 反序列化后的对象
     */
    public static <T> T deserialize(byte[] bytes) {
        return IoUtil.readObj(new ByteArrayInputStream(bytes));
    }

    /**
     * 反序列化<br>
     * 对象必须实现Serializable接口
     *
     * @param <T>   对象类型
     * @param bytes 反序列化的字节码
     * @return 反序列化后的对象
     * @see #deserialize(byte[])
     * @deprecated 请使用 {@link #deserialize(byte[])}
     */
    @Deprecated
    public static <T> T unserialize(byte[] bytes) {
        return deserialize(bytes);
    }
}
