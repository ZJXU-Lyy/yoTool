package com.young.core.text;

/**
 * @ProjectName: yoTool
 * @Package: com.young.core.text
 * @ClassName: ASCIIStrCache
 * @Description: ASCII字符对应的字符串缓存
 * @Author: Young
 * @CreateDate: 2021/3/26 2:50
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/3/26 2:50
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class ASCIIStrCache {

    private static final int ASCII_LENGTH = 128;

    private static final String[] CACHE = new String[ASCII_LENGTH];

    static {
        for (char c = 0; c < ASCII_LENGTH; c++) {
            CACHE[c] = String.valueOf(c);
        }
    }

    /**
     * 字符转为字符串
     * 如果为ASCII字符，使用缓存
     *
     * @param c 字符
     * @return 字符串
     */
    public static String toString(char c) {
        return c < ASCII_LENGTH ? CACHE[c] : String.valueOf(c);
    }
}
