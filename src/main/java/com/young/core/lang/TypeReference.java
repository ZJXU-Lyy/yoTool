package com.young.core.lang;

import com.young.core.util.TypeUtil;

import java.lang.reflect.Type;

/**
 * @ProjectName: yoTool
 * @Package: com.young.core.lang
 * @ClassName: TypeReference
 * @Description: Type类型参考
 * @Author: Young
 * @CreateDate: 2021/3/26 2:27
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/3/26 2:27
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public abstract class TypeReference<T> implements Type {

    /**
     * 泛型参数
     */
    private final Type type;

    /**
     * 构造方法
     */
    public TypeReference() {
        this.type = TypeUtil.getTypeArgument(getClass());
    }

    /**
     * 获取用户定义的泛型参数
     *
     * @return 泛型参数
     */
    public Type getType() {
        return this.type;
    }

    @Override
    public String toString() {
        return this.type.toString();
    }
}
