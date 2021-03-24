package core.util;

/**
 * @ProjectName: yoTool
 * @Package: core.util
 * @ClassName: CharUtil
 * @Description: 作用描述
 * @Author: Young
 * @CreateDate: 2021/3/24 23:12
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/3/24 23:12
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class CharUtil {
    /**
     * 字符常量：空格符 {@code ' '}
     */
    public static final char SPACE = ' ';

    /**
     * 字符常量：制表符 {@code '\t'}
     */
    public static final char TAB = '	';

    /**
     * 字符常量：点 {@code '.'}
     */
    public static final char DOT = '.';

    /**
     * 字符常量：斜杠 {@code '/'}
     */
    public static final char SLASH = '/';

    /**
     * 字符常量：反斜杠 {@code '\\'}
     */
    public static final char BACKSLASH = '\\';

    /**
     * 字符常量：回车符 {@code '\r'}
     */
    public static final char CR = '\r';

    /**
     * 字符常量：换行符 {@code '\n'}
     */
    public static final char LF = '\n';

    /**
     * 字符常量：减号（连接符） {@code '-'}
     */
    public static final char DASHED = '-';

    /**
     * 字符常量：下划线 {@code '_'}
     */
    public static final char UNDERLINE = '_';

    /**
     * 字符常量：逗号 {@code ','}
     */
    public static final char COMMA = ',';

    /**
     * 字符常量：花括号（左） <code>'{'</code>
     */
    public static final char DELIM_START = '{';

    /**
     * 字符常量：花括号（右） <code>'}'</code>
     */
    public static final char DELIM_END = '}';

    /**
     * 字符常量：中括号（左） {@code '['}
     */
    public static final char BRACKET_START = '[';

    /**
     * 字符常量：中括号（右） {@code ']'}
     */
    public static final char BRACKET_END = ']';

    /**
     * 字符常量：双引号 {@code '"'}
     */
    public static final char DOUBLE_QUOTES = '"';

    /**
     * 字符常量：单引号 {@code '\''}
     */
    public static final char SINGLE_QUOTE = '\'';

    /**
     * 字符常量：与 {@code '&'}
     */
    public static final char AMP = '&';

    /**
     * 字符常量：冒号 {@code ':'}
     */
    public static final char COLON = ':';

    /**
     * 字符常量：艾特 {@code '@'}
     */
    public static final char AT = '@';

    /**
     * 是否为ASCII字符，ASCII字符位于0~127之间
     *
     * @param ch 被检查字符
     * @return 是否为ASCII字符
     */
    public static boolean isAscii(char ch) {
        return ch < 128;
    }

    /**
     * 是否为可输出即可见ASCII字符，可见ASCII字符位于32~126之间
     *
     * @param ch 被检查字符
     * @return 是否为可见ASCII字符
     */
    public static boolean isAsciiPrintable(char ch) {
        return ch >= 32 && ch < 127;
    }

    /**
     * 是否为ASCII控制符（特殊标记符/不可见符号），位于0~31和127
     *
     * @param ch 被检查字符
     * @return 是否为ASCII控制符
     */
    public static boolean isAsciiControl(final char ch) {
        return ch < 32 || ch == 127;
    }

    /**
     * 判断是否为字母（包括大写字母和小写字母）
     *
     * @param ch 被检查字符
     * @return 是否为字母
     */
    public static boolean isLetter(char ch) {
        return isLetterUpper(ch) || isLetterLower(ch);
    }

    /**
     * 判断是否为大写字母，大写字母包括A~Z
     *
     * @param ch 被检查字符
     * @return 是否为大写字母
     */
    public static boolean isLetterUpper(final char ch) {
        return ch >= 'A' && ch <= 'Z';
    }

    /**
     * 判断是否为小写字母，小写字母包括a~z
     *
     * @param ch 被检查字符
     * @return 是否为小写字母
     */
    public static boolean isLetterLower(final char ch) {
        return ch >= 'a' && ch <= 'z';
    }

    /**
     * 判断是否为标准十进制数字字符，包括0~9
     *
     * @param ch 被检查字符
     * @return 是否为标准十进制数字字符
     */
    public static boolean isNumber(char ch) {
        return ch >= '0' && ch <= '9';
    }

    /**
     * 判断是否为十六进制数字字符，包括0~9、a~f、A~F
     *
     * @param ch 被检查字符
     * @return 是否为十六进制数字字符
     */
    public static boolean isHexNumber(char ch) {
        return isNumber(ch) || (ch >= 'a' && ch <= 'f') || (ch >= 'A' && ch <= 'F');
    }

    /**
     * 是否为字母或数字，包括A~Z、a~z、0~9
     *
     * @param ch 被检查字符
     * @return 是否为字母或数字
     */
    public static boolean isLetterOrNumber(final char ch) {
        return isLetter(ch) || isNumber(ch);
    }

    /**
     * 检查目标类是否为char及其包装类
     *
     * @param clz 目标类
     * @return 是否为char及其包装类
     */
    public static boolean isCharClass(Class<?> clz) {
        return clz == Character.class || clz == char.class;
    }

    /**
     * 判断是否为空白符，空白符包括空格、制表符、全角空格和不间断空格
     *
     * @param ch 被检查字符
     * @return 是否为空白符
     */
    public static boolean isBlankChar(int ch) {
        return Character.isWhitespace(ch)
                || Character.isSpaceChar(ch)
                || ch == '\ufeff'
                || ch == '\u202a';
    }

    /**
     * 判断是否为emoji表情符
     *
     * @param ch 被检查字符
     * @return 是否为emoji表情符
     */
    public static boolean isEmoji(char ch) {
        return !(ch == 0x0 || ch == 0x9 || ch == 0xA || ch == 0xD
                || ch >= 0x20 && ch <= 0xD7FF || ch >= 0xE000 && ch <= 0xFFFD);
    }

    /**
     * 判断是否为Windows或者Linux（Unix）文件分隔符
     * Windows平台下分隔符为\，Linux（Unix）为/
     *
     * @param ch 被检查字符
     * @return 是否为Windows或者Linux（Unix）文件分隔符
     */
    public static boolean isFileSeparator(char ch) {
        return SLASH == ch || BACKSLASH == ch;
    }

    /**
     * 比较两个字符是否相同
     *
     * @param ch1        字符1
     * @param ch2        字符2
     * @param ignoreCase 是否忽略大小写
     * @return 是否相同
     */
    public static boolean equals(char ch1, char ch2, boolean ignoreCase) {
        if (ignoreCase) {
            return Character.toLowerCase(ch1) == Character.toLowerCase(ch2);
        }
        return ch1 == ch2;
    }

    /**
     * 获取字符类型
     *
     * @param ch 被检查字符
     * @return 字符类型
     */
    public static int getType(int ch) {
        return Character.getType(ch);
    }

    /**
     * 获取给定字符的16进制数值
     *
     * @param ch 字符
     * @return 16进制字符
     */
    public static int digit16(int ch) {
        return Character.digit(ch, 16);
    }
}
