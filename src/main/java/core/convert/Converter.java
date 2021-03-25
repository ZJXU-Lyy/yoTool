package core.convert;

/**
 * @param <T> 目标转换类型
 * @ProjectName: yoTool
 * @Package: core.convert
 * @ClassName: Converter
 * @Description: 转换器接口，实现类型转换
 * @Author: Young
 * @CreateDate: 2021/3/25 22:02
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/3/25 22:02
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface Converter<T> {
    /**
     * 转换为指定类型<br>
     * 如果类型无法确定，将读取默认值的类型做为目标类型
     *
     * @param value        原始值
     * @param defaultValue 默认值
     * @return 转换后的值
     * @throws IllegalArgumentException 无法确定目标类型，且默认值为{@code null}，无法确定类型
     */
    T convert(Object value, T defaultValue) throws IllegalArgumentException;
}
