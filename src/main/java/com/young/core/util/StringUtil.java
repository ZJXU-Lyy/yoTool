package com.young.core.util;

import com.young.core.text.CharSequenceUtil;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ProjectName: yoTool
 * @Package: com.young.core.util
 * @ClassName: StringUtil
 * @Description: 字符串工具类
 * @Author: Young
 * @CreateDate: 2021/2/4 22:01
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/2/4 22:01
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class StringUtil extends CharSequenceUtil {
    private static final Pattern HK_PATTERN = Pattern.compile("^([5689])\\d{7}$");

    private static final Pattern CHINA_PATTERN = Pattern.compile("^((13[0-9])|(14[0,1,4-9])|(15[0-3,5-9])|(16[2,5,6,7])|(17[0-8])|(18[0-9])|(19[0-3,5-9]))\\d{8}$");

    /**
     * 字符常量：空格符 {@code ' '}
     */
    public static final char C_SPACE = CharUtil.SPACE;

    /**
     * 字符常量：制表符 {@code '\t'}
     */
    public static final char C_TAB = CharUtil.TAB;

    /**
     * 字符常量：点 {@code '.'}
     */
    public static final char C_DOT = CharUtil.DOT;

    /**
     * 字符常量：斜杠 {@code '/'}
     */
    public static final char C_SLASH = CharUtil.SLASH;

    /**
     * 字符常量：反斜杠 {@code '\\'}
     */
    public static final char C_BACKSLASH = CharUtil.BACKSLASH;

    /**
     * 字符常量：回车符 {@code '\r'}
     */
    public static final char C_CR = CharUtil.CR;

    /**
     * 字符常量：换行符 {@code '\n'}
     */
    public static final char C_LF = CharUtil.LF;

    /**
     * 字符常量：下划线 {@code '_'}
     */
    public static final char C_UNDERLINE = CharUtil.UNDERLINE;

    /**
     * 字符常量：逗号 {@code ','}
     */
    public static final char C_COMMA = CharUtil.COMMA;

    /**
     * 字符常量：花括号（左） <code>'{'</code>
     */
    public static final char C_DELIM_START = CharUtil.DELIM_START;

    /**
     * 字符常量：花括号（右） <code>'}'</code>
     */
    public static final char C_DELIM_END = CharUtil.DELIM_END;

    /**
     * 字符常量：中括号（左） {@code '['}
     */
    public static final char C_BRACKET_START = CharUtil.BRACKET_START;

    /**
     * 字符常量：中括号（右） {@code ']'}
     */
    public static final char C_BRACKET_END = CharUtil.BRACKET_END;

    /**
     * 字符常量：冒号 {@code ':'}
     */
    public static final char C_COLON = CharUtil.COLON;

    /**
     * 字符常量：艾特 {@code '@'}
     */
    public static final char C_AT = CharUtil.AT;

    /**
     * 字符串常量：制表符 {@code "\t"}
     */
    public static final String TAB = "	";

    /**
     * 字符串常量：点 {@code "."}
     */
    public static final String DOT = ".";

    /**
     * 字符串常量：双点 {@code ".."} <br>
     * 用途：作为指向上级文件夹的路径，如：{@code "../path"}
     */
    public static final String DOUBLE_DOT = "..";

    /**
     * 字符串常量：斜杠 {@code "/"}
     */
    public static final String SLASH = "/";

    /**
     * 字符串常量：反斜杠 {@code "\\"}
     */
    public static final String BACKSLASH = "\\";

    /**
     * 字符串常量：回车符 {@code "\r"} <br>
     * 解释：该字符常用于表示 Linux 系统和 MacOS 系统下的文本换行
     */
    public static final String CR = "\r";

    /**
     * 字符串常量：换行符 {@code "\n"}
     */
    public static final String LF = "\n";

    /**
     * 字符串常量：Windows 换行 {@code "\r\n"} <br>
     * 解释：该字符串常用于表示 Windows 系统下的文本换行
     */
    public static final String CRLF = "\r\n";

    /**
     * 字符串常量：下划线 {@code "_"}
     */
    public static final String UNDERLINE = "_";

    /**
     * 字符串常量：减号（连接符） {@code "-"}
     */
    public static final String DASHED = "-";

    /**
     * 字符串常量：逗号 {@code ","}
     */
    public static final String COMMA = ",";

    /**
     * 字符串常量：花括号（左） <code>"{"</code>
     */
    public static final String DELIM_START = "{";

    /**
     * 字符串常量：花括号（右） <code>"}"</code>
     */
    public static final String DELIM_END = "}";

    /**
     * 字符串常量：中括号（左） {@code "["}
     */
    public static final String BRACKET_START = "[";

    /**
     * 字符串常量：中括号（右） {@code "]"}
     */
    public static final String BRACKET_END = "]";

    /**
     * 字符串常量：冒号 {@code ":"}
     */
    public static final String COLON = ":";

    /**
     * 字符串常量：艾特 {@code "@"}
     */
    public static final String AT = "@";

    /**
     * 字符串常量：HTML 空格转义 {@code "&nbsp;" -> " "}
     */
    public static final String HTML_NBSP = XmlUtil.NBSP;

    /**
     * 字符串常量：HTML And 符转义 {@code "&amp;" -> "&"}
     */
    public static final String HTML_AMP = XmlUtil.AMP;

    /**
     * 字符串常量：HTML 双引号转义 {@code "&quot;" -> "\""}
     */
    public static final String HTML_QUOTE = XmlUtil.QUOTE;

    /**
     * 字符串常量：HTML 单引号转义 {@code "&apos" -> "'"}
     */
    public static final String HTML_APOS = XmlUtil.APOS;

    /**
     * 字符串常量：HTML 小于号转义 {@code "&lt;" -> "<"}
     */
    public static final String HTML_LT = XmlUtil.LT;

    /**
     * 字符串常量：HTML 大于号转义 {@code "&gt;" -> ">"}
     */
    public static final String HTML_GT = XmlUtil.GT;

    /**
     * 字符串常量：空 JSON {@code "{}"}
     */
    public static final String EMPTY_JSON = "{}";

    /**
     * 字符串是否为空
     *
     * @param str 被判断字符串对象
     * @return 是否为空布尔值
     */
    public static boolean isEmpty(String str) {
        return str == null || "".equals(str);
    }

    /**
     * 字符串是否不为空
     *
     * @param str 被判断字符串对象
     * @return 是否不为空布尔值
     */
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    /**
     * 特殊情况下须增加对字符串"null"的空判断
     *
     * @param str 被判断字符串对象
     * @return 是否为空布尔值
     */
    public static boolean isNullOrEmpty(String str) {
        return isEmpty(str) || ("null".equals(str));
    }

    /**
     * 字符串是否纯数字
     *
     * @param str 被判断字符串对象
     * @return 是否纯数字布尔值
     */
    public static boolean isInteger(String str) {
        String NUMBER_JUDGE = "[0-9]+";
        if (isNotEmpty(str))
            return str.matches(NUMBER_JUDGE);
        return false;
    }

    /**
     * 包括中国大陆及香港手机号
     *
     * @param str 手机号
     * @return 是否为真
     */
    public static boolean isPhone(String str) {
        return isChinaPhoneLegal(str) || isHKPhoneLegal(str);
    }

    /**
     * 中国大陆手机号
     *
     * @param str 手机号
     * @return 是否为真
     */
    public static boolean isChinaPhoneLegal(String str) {
        Matcher m = CHINA_PATTERN.matcher(str);
        return m.matches();
    }

    /**
     * 香港手机号
     *
     * @param str 手机号
     * @return 是否为真
     */
    public static boolean isHKPhoneLegal(String str) {
        Matcher m = HK_PATTERN.matcher(str);
        return m.matches();
    }

    /**
     * 判断邮箱号是否合法
     *
     * @param str 邮箱号
     * @return 是否合法
     */
    public static boolean isValidEmail(String str) {
        if (!isNullOrEmpty(str)) {
            return Pattern.matches("^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$", str);
        }
        return false;
    }

    /**
     * 统计目标字符串在源字符串中出现的次数
     *
     * @param str 源字符串
     * @param tag 目标字符串
     * @return 次数
     */
    public static int appearNumber(String str, String tag) {
        int count = 0;
        Pattern pattern = Pattern.compile(tag);
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            count++;
        }
        return count;
    }

    /**
     * 字符串是否为复数
     *
     * @param str 被判断字符串
     * @return 是否为复数布尔值
     */
    public static boolean isComplex(String str) {
        if (appearNumber(str, "\\.") != 1)
            return false;
        String[] complexNumber = str.split("\\.");
        return isInteger(complexNumber[0]) && isInteger(complexNumber[1]);
    }


    /**
     * 左填充0字符
     *
     * @param str 源字符串
     * @param len 给定长度
     * @return 见padding函数
     */
    public static String padZeroLeft(String str, int len) {
        return padding(str, len, '0', true);
    }

    /**
     * 左填充pad字符
     *
     * @param str 源字符串
     * @param len 给定长度
     * @param pad 填充字符
     * @return 见padding函数
     */
    public static String padLeft(String str, int len, char pad) {
        return padding(str, len, pad, true);
    }

    /**
     * 右填充0字符
     *
     * @param str 源字符串
     * @param len 给定长度
     * @return 见padding函数
     */
    public static String padZeroRight(String str, int len) {
        return padding(str, len, '0', false);
    }

    /**
     * 右填充pad字符
     *
     * @param str 源字符串
     * @param len 给定长度
     * @param pad 填充字符
     * @return 见padding函数
     */
    public static String padRight(String str, int len, char pad) {
        return padding(str, len, pad, false);
    }

    /**
     * 源字符串填充字符至给定长度
     *
     * @param str    源字符串
     * @param len    给定长度
     * @param pad    填充字符
     * @param isLeft 是否左填充
     * @return 源字符串为空返回给定长度填充字符序列，源字符串长度超过给定长度返回源字符串，否则返回填充后新字符串
     */
    private static String padding(String str, int len, char pad, boolean isLeft) {
        StringBuilder stringBuilder = new StringBuilder();
        if (isEmpty(str)) {
            for (int i = 0; i < len; i++) {
                stringBuilder.append(pad);
            }
            return stringBuilder.toString();
        }
        if (str.length() >= len)
            return str;
        if (isLeft) {
            while (stringBuilder.length() < len - str.length()) {
                stringBuilder.append(pad);
            }
            stringBuilder.append(str);
        } else {
            stringBuilder.append(str);
            while (stringBuilder.length() < len) {
                stringBuilder.append(pad);
            }
        }
        return stringBuilder.toString();
    }

    /**
     * 字符串反转
     *
     * @param str 源字符串
     * @return 反转后字符串
     */
    public static String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    /**
     * 将对象转为字符串
     *
     * @param obj 对象
     * @return 字符串
     */
    public static String utf8Str(Object obj) {
        return str(obj, CharsetUtil.CHARSET_UTF_8);
    }

    /**
     * 将对象转为字符串
     *
     * @param obj         对象
     * @param charsetName 字符集
     * @return 字符串
     */
    public static String str(Object obj, String charsetName) {
        return str(obj, Charset.forName(charsetName));
    }

    /**
     * 将对象转为字符串
     *
     * @param obj     对象
     * @param charset 字符集
     * @return 字符串
     */
    public static String str(Object obj, Charset charset) {
        if (null == obj) {
            return null;
        }

        if (obj instanceof String) {
            return (String) obj;
        } else if (obj instanceof byte[]) {
            return str((byte[]) obj, charset);
        } else if (obj instanceof Byte[]) {
            return str((Byte[]) obj, charset);
        } else if (obj instanceof ByteBuffer) {
            return str((ByteBuffer) obj, charset);
        } else if (ArrayUtil.isArray(obj)) {
            return ArrayUtil.toString(obj);
        }

        return obj.toString();
    }

    /**
     * 格式化文本，使用 {varName} 占位
     * map = {a: "aValue", b: "bValue"} format("{a} and {b}", map) ---=》 aValue and bValue
     *
     * @param template 文本模板，被替换的部分用 {key} 表示
     * @param map      参数值对
     * @return 格式化后的文本
     */
    public static String format(CharSequence template, Map<?, ?> map) {
        return format(template, map, true);
    }

    /**
     * 格式化文本，使用 {varName} 占位
     * map = {a: "aValue", b: "bValue"} format("{a} and {b}", map) ---=》 aValue and bValue
     *
     * @param template   文本模板，被替换的部分用 {key} 表示
     * @param map        参数值对
     * @param ignoreNull 是否忽略 {@code null} 值，忽略则 {@code null} 值对应的变量不被替换，否则替换为""
     * @return 格式化后的文本
     */
    public static String format(CharSequence template, Map<?, ?> map, boolean ignoreNull) {
        if (null == template) {
            return null;
        }
        if (null == map || map.isEmpty()) {
            return template.toString();
        }

        String template2 = template.toString();
        String value;
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            value = utf8Str(entry.getValue());
            if (null == value && ignoreNull) {
                continue;
            }
            template2 = replace(template2, "{" + entry.getKey() + "}", value);
        }
        return template2;
    }
}
