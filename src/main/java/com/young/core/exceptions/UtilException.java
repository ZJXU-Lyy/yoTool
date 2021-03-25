package com.young.core.exceptions;

import com.young.core.lang.StrUtil;

/**
 * @ProjectName: yoTool
 * @Package: com.young.core.exceptions
 * @ClassName: UtilException
 * @Description: 工具类异常
 * @Author: Young
 * @CreateDate: 2021/3/26 1:55
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/3/26 1:55
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class UtilException extends RuntimeException {
    private static final long serialVersionUID = 5878412447156218898L;

    public UtilException(Throwable e) {
        super(ExceptionUtil.getMessage(e), e);
    }

    public UtilException(String message) {
        super(message);
    }

    public UtilException(String messageTemplate, Object... params) {
        super(StrUtil.format(messageTemplate, params));
    }

    public UtilException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public UtilException(Throwable throwable, String messageTemplate, Object... params) {
        super(StrUtil.format(messageTemplate, params), throwable);
    }
}
