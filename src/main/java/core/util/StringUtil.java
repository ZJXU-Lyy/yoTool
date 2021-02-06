package core.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ProjectName: yoTool
 * @Package: core.util
 * @ClassName: StringUtil
 * @Description: 字符串工具类
 * @Author: Young
 * @CreateDate: 2021/2/4 22:01
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/2/4 22:01
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class StringUtil {
    private static final Pattern HK_PATTERN = Pattern.compile("^([5689])\\d{7}$");

    private static final Pattern CHINA_PATTERN = Pattern.compile("^((13[0-9])|(14[0,1,4-9])|(15[0-3,5-9])|(16[2,5,6,7])|(17[0-8])|(18[0-9])|(19[0-3,5-9]))\\d{8}$");

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
}
