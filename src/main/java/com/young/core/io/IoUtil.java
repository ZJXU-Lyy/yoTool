package com.young.core.io;

import com.young.core.exceptions.UtilException;

import java.io.*;

/**
 * @ProjectName: yoTool
 * @Package: com.young.core.io
 * @ClassName: IoUtil
 * @Description: IO工具类
 * @Author: Young
 * @CreateDate: 2021/3/26 4:42
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/3/26 4:42
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class IoUtil {

    /**
     * 从流中读取对象，即对象的反序列化
     * 注意！！！ 此方法不会检查反序列化安全，可能存在反序列化漏洞风险！！！
     *
     * @param <T> 读取对象的类型
     * @param in  输入流
     * @return 输出流
     * @throws IORuntimeException IO异常
     * @throws UtilException      ClassNotFoundException包装
     */
    public static <T> T readObj(InputStream in) throws IORuntimeException, UtilException {
        return readObj(in, null);
    }

    /**
     * 从流中读取对象，即对象的反序列化，读取后不关闭流
     * 注意！！！ 此方法不会检查反序列化安全，可能存在反序列化漏洞风险！！！
     *
     * @param <T>   读取对象的类型
     * @param in    输入流
     * @param clazz 读取对象类型
     * @return 输出流
     * @throws IORuntimeException IO异常
     * @throws UtilException      ClassNotFoundException包装
     */
    public static <T> T readObj(InputStream in, Class<T> clazz) throws IORuntimeException, UtilException {
        try {
            return readObj((in instanceof ValidateObjectInputStream) ?
                            (ValidateObjectInputStream) in : new ValidateObjectInputStream(in),
                    clazz);
        } catch (IOException e) {
            throw new IORuntimeException(e);
        }
    }

    /**
     * 将多部分内容写到流中
     *
     * @param out        输出流
     * @param isCloseOut 写入完毕是否关闭输出流
     * @param contents   写入的内容
     * @throws IORuntimeException IO异常
     */
    public static void writeObjects(OutputStream out, boolean isCloseOut, Serializable... contents) throws IORuntimeException {
        ObjectOutputStream osw = null;
        try {
            osw = out instanceof ObjectOutputStream ? (ObjectOutputStream) out : new ObjectOutputStream(out);
            for (Object content : contents) {
                if (content != null) {
                    osw.writeObject(content);
                    osw.flush();
                }
            }
        } catch (IOException e) {
            throw new IORuntimeException(e);
        } finally {
            if (isCloseOut) {
                close(osw);
            }
        }
    }

    /**
     * 关闭<br>
     * 关闭失败不会抛出异常
     *
     * @param closeable 被关闭的对象
     */
    public static void close(Closeable closeable) {
        if (null != closeable) {
            try {
                closeable.close();
            } catch (Exception e) {
                // 静默关闭
            }
        }
    }
}
