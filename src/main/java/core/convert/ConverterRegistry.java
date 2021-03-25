package core.convert;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.Map;

/**
 * @ProjectName: yoTool
 * @Package: core.convert
 * @ClassName: ConverterRegistry
 * @Description: 作用描述
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
}
