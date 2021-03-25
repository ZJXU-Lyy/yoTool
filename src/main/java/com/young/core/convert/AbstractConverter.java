package com.young.core.convert;

import com.young.core.lang.StrUtil;
import com.young.core.util.ArrayUtil;
import com.young.core.util.CharUtil;
import com.young.core.util.ClassUtil;

import java.io.Serializable;
import java.util.Map;

/**
 * @ProjectName: yoTool
 * @Package: com.young.core.convert
 * @ClassName: AbstractConverter
 * @Description: 抽象转换器，提供通用的转换逻辑，同时通过convertInternal实现对应类型的专属逻辑
 * @Author: Young
 * @CreateDate: 2021/3/26 2:46
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/3/26 2:46
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public abstract class AbstractConverter<T> implements Converter<T>, Serializable {
    private static final long serialVersionUID = -8238268849640245796L;

    /**
     * 不抛异常转换
     * 当转换失败时返回默认值
     *
     * @param value 被转换的值
     * @param defaultValue 默认值
     * @return 转换后的值
     */
    public T convertQuietly(Object value, T defaultValue) {
        try {
            return convert(value, defaultValue);
        } catch (Exception e) {
            return defaultValue;
        }
    }

    /**
     * 内部转换器，被 {@link AbstractConverter#convert(Object, Object)} 调用，实现基本转换逻辑
     *
     * @param value 值
     * @return 转换后的类型
     */
    protected abstract T convertInternal(Object value);

    /**
     * 值转为String，用于内部转换中需要使用String中转的情况
     *
     * @param value 值
     * @return String
     */
    protected String convertToStr(Object value) {
        if (null == value) {
            return null;
        }
        if (value instanceof CharSequence) {
            return value.toString();
        } else if (ArrayUtil.isArray(value)) {
            return ArrayUtil.toString(value);
        } else if(CharUtil.isChar(value)) {
            //对于ASCII字符使用缓存加速转换，减少空间创建
            return CharUtil.toString((char)value);
        }
        return value.toString();
    }

    /**
     * 获得此类实现类的泛型类型
     *
     * @return 此类的泛型类型，可能为{@code null}
     */
    @SuppressWarnings("unchecked")
    public Class<T> getTargetType() {
        return (Class<T>) ClassUtil.getTypeArgument(getClass());
    }

    @Override
    @SuppressWarnings("unchecked")
    public T convert(Object value, T defaultValue) {
        Class<T> targetType = getTargetType();
        if (null == targetType && null == defaultValue) {
            throw new NullPointerException(StrUtil.format("[type] and [defaultValue] are both null for Converter [{}], we can not know what type to convert !", this.getClass().getName()));
        }
        if (null == targetType) {
            // 目标类型不确定时使用默认值的类型
            targetType = (Class<T>) defaultValue.getClass();
        }
        if (null == value) {
            return defaultValue;
        }

        if (null == defaultValue || targetType.isInstance(defaultValue)) {
            if (targetType.isInstance(value) && !Map.class.isAssignableFrom(targetType)) {
                // 除Map外，已经是目标类型，不需要转换（Map类型涉及参数类型，需要单独转换）
                return targetType.cast(value);
            }
            T result = convertInternal(value);
            return ((null == result) ? defaultValue : result);
        } else {
            throw new IllegalArgumentException(
                    StrUtil.format("Default value [{}]({}) is not the instance of [{}]", defaultValue, defaultValue.getClass(), targetType));
        }
    }
}
