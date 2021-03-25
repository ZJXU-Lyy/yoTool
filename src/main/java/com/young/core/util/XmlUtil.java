package com.young.core.util;

/**
 * @ProjectName: yoTool
 * @Package: com.young.core.util
 * @ClassName: XmlUtil
 * @Description: XML工具类
 * @Author: Young
 * @CreateDate: 2021/3/26 1:27
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/3/26 1:27
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class XmlUtil {

    /**
     * 字符串常量：XML 空格转义 {@code "&nbsp;" -> " "}
     */
    public static final String NBSP = "&nbsp;";

    /**
     * 字符串常量：XML And 符转义 {@code "&amp;" -> "&"}
     */
    public static final String AMP = "&amp;";

    /**
     * 字符串常量：XML 双引号转义 {@code "&quot;" -> "\""}
     */
    public static final String QUOTE = "&quot;";

    /**
     * 字符串常量：XML 单引号转义 {@code "&apos" -> "'"}
     */
    public static final String APOS = "&apos;";

    /**
     * 字符串常量：XML 小于号转义 {@code "&lt;" -> "<"}
     */
    public static final String LT = "&lt;";

    /**
     * 字符串常量：XML 大于号转义 {@code "&gt;" -> ">"}
     */
    public static final String GT = "&gt;";

    /**
     * 在XML中无效的字符 正则
     */
    public static final String INVALID_REGEX = "[\\x00-\\x08\\x0b-\\x0c\\x0e-\\x1f]";
    /**
     * 在XML中注释的内容 正则
     */
    public static final String COMMENT_REGEX = "(?s)<!--.+?-->";
    /**
     * XML格式化输出默认缩进量
     */
    public static final int INDENT_DEFAULT = 2;

    /**
     * 默认的DocumentBuilderFactory实现
     */
    private static String defaultDocumentBuilderFactory = "com.sun.org.apache.xerces.internal.jaxp.DocumentBuilderFactoryImpl";
}
