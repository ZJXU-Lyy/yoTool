package com.young.core.convert;

import com.young.core.exceptions.ExceptionUtil;
import com.young.core.lang.StrUtil;

/**
 * @ProjectName: yoTool
 * @Package: com.young.core.convert
 * @ClassName: ConvertException
 * @Description: 转换异常
 * @Author: Young
 * @CreateDate: 2021/3/26 2:24
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/3/26 2:24
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class ConvertException extends RuntimeException {
    private static final long serialVersionUID = 3748753722087283213L;

    public ConvertException(Throwable e) {
        super(ExceptionUtil.getMessage(e), e);
    }

    public ConvertException(String message) {
        super(message);
    }

    public ConvertException(String messageTemplate, Object... params) {
        super(StrUtil.format(messageTemplate, params));
    }

    public ConvertException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public ConvertException(Throwable throwable, String messageTemplate, Object... params) {
        super(StrUtil.format(messageTemplate, params), throwable);
    }
}
