package core.util;

import java.util.Collection;
import java.util.List;

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
     * @param objects 集合对象
     * @param <T>     集合接口及其所有子类
     * @return 布尔值
     */
    public static <T extends Collection<?>> boolean isEmpty(T objects) {
        return null == objects || objects.isEmpty();
    }

    /**
     * 判断集合对象是否不为空
     *
     * @param objects 集合对象
     * @param <T>     集合接口及其所有子类
     * @return 布尔值
     */
    public static <T extends Collection<?>> boolean isNotEmpty(T objects) {
        return !isEmpty(objects);
    }

    /**
     * List遍历执行listForEach接口定义的objectOperate方法
     *
     * @param objects     list对象
     * @param listForEach 匿名接口
     * @param <T>         T instanceof Object
     */
    public static <T> void forEach(List<T> objects, ListForEach<T> listForEach) {
        if (isNotEmpty(objects)) {
            for (T t : objects) {
                listForEach.objectOperate(t);
            }
        }
    }

    /**
     * List遍历执行接口
     *
     * @param <T> T instanceof Object
     */
    public interface ListForEach<T> {
        void objectOperate(T object);
    }
}
