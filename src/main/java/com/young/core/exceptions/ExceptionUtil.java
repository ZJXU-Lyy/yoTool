package com.young.core.exceptions;

import com.young.core.util.StringUtil;

/**
 * @ProjectName: yoTool
 * @Package: com.young.core.exceptions
 * @ClassName: ExceptionUtil
 * @Description: 异常工具类
 * @Author: Young
 * @CreateDate: 2021/3/26 1:56
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/3/26 1:56
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class ExceptionUtil {
    /**
     * 获得完整消息，包括异常名，消息格式为：{SimpleClassName}: {ThrowableMessage}
     *
     * @param e 异常
     * @return 完整消息
     */
    public static String getMessage(Throwable e) {
        if (null == e) {
            return StringUtil.NULL;
        }
        return StringUtil.format("{}: {}", e.getClass().getSimpleName(), e.getMessage());
    }
}
