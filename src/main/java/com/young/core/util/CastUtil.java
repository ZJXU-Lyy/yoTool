package com.young.core.util;

/**
 * @ProjectName: yoTool
 * @Package: com.young.core.util
 * @ClassName: CastUtil
 * @Description: 类型转换工具类
 * @Author: Young
 * @CreateDate: 2021/2/5 18:44
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/2/5 18:44
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class CastUtil {

    /**
     * String转换int
     *
     * @param str 源字符串
     * @return 目标值 异常时返回0
     */
    public static int castInt(String str) {
        int value = 0;
        if (StringUtil.isNotEmpty(str)) {
            try {
                value = Integer.parseInt(str);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return value;
    }

    /**
     * String转换long
     *
     * @param str 源字符串
     * @return 目标值 异常时返回0
     */
    public static long castLong(String str) {
        long value = 0;
        if (StringUtil.isNotEmpty(str)) {
            try {
                value = Long.parseLong(str);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return value;
    }

    /**
     * String转换float
     *
     * @param str 源字符串
     * @return 目标值 异常时返回0
     */
    public static float castFloat(String str) {
        float value = 0;
        if (StringUtil.isNotEmpty(str)) {
            try {
                value = Float.parseFloat(str);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return value;
    }

    /**
     * String转换double
     *
     * @param str 源字符串
     * @return 目标值 异常时返回0
     */
    public static double castDouble(String str) {
        double value = 0;
        if (StringUtil.isNotEmpty(str)) {
            try {
                value = Double.parseDouble(str);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return value;
    }

    /**
     * String转换boolean
     *
     * @param str 源字符串
     * @return 目标值 异常时返回false;
     */
    public static boolean castBoolean(String str) {
        boolean value = false;
        if (StringUtil.isNotEmpty(str)) {
            try {
                value = Boolean.parseBoolean(str);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return value;
    }
}
