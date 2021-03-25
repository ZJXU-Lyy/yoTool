package com.young.core.io;

import com.young.core.exceptions.ExceptionUtil;
import com.young.core.lang.StrUtil;

/**
 * @ProjectName: yoTool
 * @Package: com.young.core.io
 * @ClassName: IORuntimeException
 * @Description: IO运行时异常
 * @Author: Young
 * @CreateDate: 2021/3/26 4:29
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/3/26 4:29
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class IORuntimeException extends RuntimeException {
    private static final long serialVersionUID = 5263915669887428023L;

    public IORuntimeException(Throwable e) {
        super(ExceptionUtil.getMessage(e), e);
    }

    public IORuntimeException(String message) {
        super(message);
    }

    public IORuntimeException(String messageTemplate, Object... params) {
        super(StrUtil.format(messageTemplate, params));
    }

    public IORuntimeException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public IORuntimeException(Throwable throwable, String messageTemplate, Object... params) {
        super(StrUtil.format(messageTemplate, params), throwable);
    }

    /**
     * 导致这个异常的异常是否是指定类型的异常
     *
     * @param clz 异常类
     * @return 是否为指定类型异常
     */
    public boolean causeInstanceOf(Class<? extends Throwable> clz) {
        final Throwable cause = this.getCause();
        return null != clz && clz.isInstance(cause);
    }
}
