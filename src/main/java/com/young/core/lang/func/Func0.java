package com.young.core.lang.func;

/**
 * @ProjectName: yoTool
 * @Package: com.young.core.lang.func
 * @ClassName: Func0
 * @Description: 无参数的函数对象，一个函数接口代表一个一个函数，用于包装一个函数为对象
 * @Author: Young
 * @CreateDate: 2021/3/26 1:17
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/3/26 1:17
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@FunctionalInterface
public interface Func0<R> {
    /**
     * 执行函数
     *
     * @return 函数执行结果
     * @throws Exception 自定义异常
     */
    R call() throws Exception;

    /**
     * 执行函数，异常包装为RuntimeException
     *
     * @return 函数执行结果
     * @since 5.3.6
     */
    default R callWithRuntimeException() {
        try {
            return call();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
