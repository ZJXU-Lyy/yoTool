package com.young.core.convert;

import com.young.core.lang.TypeReference;
import com.young.core.util.*;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.Map;

/**
 * @ProjectName: yoTool
 * @Package: com.young.core.convert
 * @ClassName: ConverterRegistry
 * @Description: 转换器登记中心
 * @Author: Young
 * @CreateDate: 2021/3/25 16:09
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/3/25 16:09
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class ConverterRegistry implements Serializable {
    private static final long serialVersionUID = -1799303317362812964L;

    /**
     * 默认类型转换器
     */
    private Map<Type, Converter<?>> defaultConverterMap;

    /**
     * 用户自定义类型转换器
     */
    private volatile Map<Type, Converter<?>> customConverterMap;

    /**
     * 类级的内部类，也就是静态的成员式内部类，该内部类的实例与外部类的实例 没有绑定关系，而且只有被调用到才会装载，从而实现了延迟加载
     */
    private static class SingletonHolder {
        /**
         * 静态初始化器，由JVM来保证线程安全
         */
        private static final ConverterRegistry INSTANCE = new ConverterRegistry();
    }

    /**
     * 获得单例的ConverterRegistry
     *
     * @return ConverterRegistry
     */
    public static ConverterRegistry getInstance() {
        return SingletonHolder.INSTANCE;
    }

    /**
     * 使用SPI加载转换器
     */
    private void putCustomBySpi() {
        ServiceLoaderUtil.load(Converter.class).forEach(converter -> {
            try {
                Type type = TypeUtil.getTypeArgument(ClassUtil.getClass(converter));
                if(null != type){
                    putCustom(type, converter);
                }
            } catch (Exception e) {
                // 忽略注册失败的
            }
        });
    }

    /**
     * 登记自定义转换器
     *
     * @param type           转换的目标类型
     * @param converterClass 转换器类，必须有默认构造方法
     * @return ConverterRegistry
     */
    public ConverterRegistry putCustom(Type type, Class<? extends Converter<?>> converterClass) {
        return putCustom(type, ReflectUtil.newInstance(converterClass));
    }

    public ConverterRegistry() {
        defaultConverter();
        putCustomBySpi();
    }

    /**
     * 转换值为指定类型
     *
     * @param <T>           转换的目标类型（转换器转换到的类型）
     * @param type          类型目标
     * @param value         被转换值
     * @param defaultValue  默认值
     * @param isCustomFirst 是否自定义转换器优先
     * @return 转换后的值
     * @throws ConvertException 转换器不存在
     */
    @SuppressWarnings("unchecked")
    public <T> T convert(Type type, Object value, T defaultValue, boolean isCustomFirst) throws ConvertException {
        if (TypeUtil.isUnknown(type) && null == defaultValue) {
            // 对于用户不指定目标类型的情况，返回原值
            return (T) value;
        }
        if (ObjectUtil.isNull(value)) {
            return defaultValue;
        }
        if (TypeUtil.isUnknown(type)) {
            type = defaultValue.getClass();
        }

        if (type instanceof TypeReference) {
            type = ((TypeReference<?>) type).getType();
        }

        // 标准转换器
        final Converter<T> converter = getConverter(type, isCustomFirst);
        if (null != converter) {
            return converter.convert(value, defaultValue);
        }

        Class<T> rowType = (Class<T>) TypeUtil.getClass(type);
        if (null == rowType) {
            if (null != defaultValue) {
                rowType = (Class<T>) defaultValue.getClass();
            } else {
                // 无法识别的泛型类型，按照Object处理
                return (T) value;
            }
        }


        // 特殊类型转换，包括Collection、Map、强转、Array等
        /*final T result = convertSpecial(type, rowType, value, defaultValue);
        if (null != result) {
            return result;
        }*///TODO

        // 尝试转Bean
        /*if (BeanUtil.isBean(rowType)) {
            return new BeanConverter<T>(type).convert(value, defaultValue);
        }*///TODO

        // 无法转换
        throw new ConvertException("Can not Converter from [{}] to [{}]", value.getClass().getName(), type.getTypeName());
    }

    /**
     * 转换值为指定类型<br>
     * 自定义转换器优先
     *
     * @param <T>          转换的目标类型（转换器转换到的类型）
     * @param type         类型
     * @param value        值
     * @param defaultValue 默认值
     * @return 转换后的值
     * @throws ConvertException 转换器不存在
     */
    public <T> T convert(Type type, Object value, T defaultValue) throws ConvertException {
        return convert(type, value, defaultValue, true);
    }

    /**
     * 转换值为指定类型
     *
     * @param <T>   转换的目标类型（转换器转换到的类型）
     * @param type  类型
     * @param value 值
     * @return 转换后的值，默认为<code>null</code>
     * @throws ConvertException 转换器不存在
     */
    public <T> T convert(Type type, Object value) throws ConvertException {
        return convert(type, value, null);
    }

    /**
     * 获得默认转换器
     *
     * @param <T>  转换的目标类型（转换器转换到的类型）
     * @param type 类型
     * @return 转换器
     */
    @SuppressWarnings("unchecked")
    public <T> Converter<T> getDefaultConverter(Type type) {
        return (null == defaultConverterMap) ? null : (Converter<T>) defaultConverterMap.get(type);
    }

    /**
     * 获得自定义转换器
     *
     * @param <T>  转换的目标类型（转换器转换到的类型）
     * @param type 类型
     * @return 转换器
     */
    @SuppressWarnings("unchecked")
    public <T> Converter<T> getCustomConverter(Type type) {
        return (null == customConverterMap) ? null : (Converter<T>) customConverterMap.get(type);
    }

    /**
     * 获得转换器<br>
     *
     * @param <T>           转换的目标类型
     * @param type          类型
     * @param isCustomFirst 是否自定义转换器优先
     * @return 转换器
     */
    public <T> Converter<T> getConverter(Type type, boolean isCustomFirst) {
        Converter<T> converter;
        if (isCustomFirst) {
            converter = this.getCustomConverter(type);
            if (null == converter) {
                converter = this.getDefaultConverter(type);
            }
        } else {
            converter = this.getDefaultConverter(type);
            if (null == converter) {
                converter = this.getCustomConverter(type);
            }
        }
        return converter;
    }
}
