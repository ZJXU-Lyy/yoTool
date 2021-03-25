package com.young.core.util;

import com.young.core.collection.CollUtil;
import com.young.core.lang.PatternPool;
import com.young.core.lang.StrUtil;

import java.util.Set;
import java.util.regex.Pattern;

/**
 * @ProjectName: yoTool
 * @Package: com.young.core.util
 * @ClassName: ReUtil
 * @Description: 正则相关工具类
 * @Author: Young
 * @CreateDate: 2021/3/26 4:16
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/3/26 4:16
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class ReUtil {

    /**
     * 正则表达式匹配中文汉字
     */
    public final static String RE_CHINESE = "[\u4E00-\u9FFF]";

    /**
     * 正则表达式匹配中文字符串
     */
    public final static String RE_CHINESES = RE_CHINESE + "+";

    /**
     * 正则中需要被转义的关键字
     */
    public final static Set<Character> RE_KEYS = CollUtil.newHashSet('$', '(', ')', '*', '+', '.', '[', ']', '?', '\\', '^', '{', '}', '|');

    /**
     * 指定内容中是否有表达式匹配的内容
     *
     * @param regex   正则表达式
     * @param content 被查找的内容
     * @return 指定内容中是否有表达式匹配的内容
     */
    public static boolean contains(String regex, CharSequence content) {
        if (null == regex || null == content) {
            return false;
        }

        final Pattern pattern = PatternPool.get(regex, Pattern.DOTALL);
        return contains(pattern, content);
    }

    /**
     * 指定内容中是否有表达式匹配的内容
     *
     * @param pattern 编译后的正则模式
     * @param content 被查找的内容
     * @return 指定内容中是否有表达式匹配的内容
     */
    public static boolean contains(Pattern pattern, CharSequence content) {
        if (null == pattern || null == content) {
            return false;
        }
        return pattern.matcher(content).find();
    }

    /**
     * 删除匹配的全部内容
     *
     * @param regex   正则
     * @param content 被匹配的内容
     * @return 删除后剩余的内容
     */
    public static String delAll(String regex, CharSequence content) {
        if (StrUtil.hasBlank(regex, content)) {
            return StrUtil.str(content);
        }
        // Pattern pattern = Pattern.compile(regex, Pattern.DOTALL);
        final Pattern pattern = PatternPool.get(regex, Pattern.DOTALL);
        return delAll(pattern, content);
    }

    /**
     * 删除匹配的全部内容
     *
     * @param pattern 正则
     * @param content 被匹配的内容
     * @return 删除后剩余的内容
     */
    public static String delAll(Pattern pattern, CharSequence content) {
        if (null == pattern || StrUtil.isBlank(content)) {
            return StrUtil.str(content);
        }
        return pattern.matcher(content).replaceAll(StrUtil.EMPTY);
    }
}
