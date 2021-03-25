package com.young.core.util;

import java.util.Arrays;

/**
 * @ProjectName: yoTool
 * @Package: com.young.core.util
 * @ClassName: BasicTypeArrayUtil
 * @Description: 基本数据类型数组工具类
 * @Author: Young
 * @CreateDate: 2021/2/5 20:47
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/2/5 20:47
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class BasicTypeArrayUtil {
    /**
     * 数组访问越界或异常时，返回-1
     */
    public static final int INDEX_OVER = -1;

    /*
     isEmpty Method for basic data types
     */

    /**
     * 数组是否为空
     *
     * @param array 数组
     * @return 是否为空
     */
    public static boolean isEmpty(int[] array) {
        return array == null || array.length == 0;
    }

    /**
     * 数组是否为空
     *
     * @param array 数组
     * @return 是否为空
     */
    public static boolean isEmpty(short[] array) {
        return array == null || array.length == 0;
    }

    /**
     * 数组是否为空
     *
     * @param array 数组
     * @return 是否为空
     */
    public static boolean isEmpty(long[] array) {
        return array == null || array.length == 0;
    }

    /**
     * 数组是否为空
     *
     * @param array 数组
     * @return 是否为空
     */
    public static boolean isEmpty(float[] array) {
        return array == null || array.length == 0;
    }

    /**
     * 数组是否为空
     *
     * @param array 数组
     * @return 是否为空
     */
    public static boolean isEmpty(double[] array) {
        return array == null || array.length == 0;
    }

    /**
     * 数组是否为空
     *
     * @param array 数组
     * @return 是否为空
     */
    public static boolean isEmpty(byte[] array) {
        return array == null || array.length == 0;
    }

    /**
     * 数组是否为空
     *
     * @param array 数组
     * @return 是否为空
     */
    public static boolean isEmpty(char[] array) {
        return array == null || array.length == 0;
    }

    /**
     * 数组是否为空
     *
     * @param array 数组
     * @return 是否为空
     */
    public static boolean isEmpty(boolean[] array) {
        return array == null || array.length == 0;
    }

    /*
     isNotEmpty Method for basic data types
     */

    /**
     * 数组是否为非空
     *
     * @param array 数组
     * @return 是否为非空
     */
    public static boolean isNotEmpty(int[] array) {
        return !isEmpty(array);
    }

    /**
     * 数组是否为非空
     *
     * @param array 数组
     * @return 是否为非空
     */
    public static boolean isNotEmpty(short[] array) {
        return !isEmpty(array);
    }

    /**
     * 数组是否为非空
     *
     * @param array 数组
     * @return 是否为非空
     */
    public static boolean isNotEmpty(long[] array) {
        return !isEmpty(array);
    }

    /**
     * 数组是否为非空
     *
     * @param array 数组
     * @return 是否为非空
     */
    public static boolean isNotEmpty(float[] array) {
        return !isEmpty(array);
    }

    /**
     * 数组是否为非空
     *
     * @param array 数组
     * @return 是否为非空
     */
    public static boolean isNotEmpty(double[] array) {
        return !isEmpty(array);
    }

    /**
     * 数组是否为非空
     *
     * @param array 数组
     * @return 是否为非空
     */
    public static boolean isNotEmpty(byte[] array) {
        return !isEmpty(array);
    }

    /**
     * 数组是否为非空
     *
     * @param array 数组
     * @return 是否为非空
     */
    public static boolean isNotEmpty(char[] array) {
        return !isEmpty(array);
    }

    /**
     * 数组是否为非空
     *
     * @param array 数组
     * @return 是否为非空
     */
    public static boolean isNotEmpty(boolean[] array) {
        return !isEmpty(array);
    }

    /*
     resize Method
     拷贝源数组至给定长度新数组中
     源数组长度不足则填充0，过长则保留前N位
     */

    /**
     * copy Array to newArray
     *
     * @param array   整型数组
     * @param newSize 新数组长
     * @return 新数组
     */
    public static int[] resize(int[] array, int newSize) {
        if (newSize < 0) {
            return array;
        }
        final int[] newArray = new int[newSize];
        if (newSize > 0 && isNotEmpty(array)) {
            System.arraycopy(array, 0, newArray, 0, Math.min(array.length, newSize));
        }
        return newArray;
    }

    /**
     * copy Array to newArray
     *
     * @param array   短整型数组
     * @param newSize 新数组长
     * @return 新数组
     */
    public static short[] resize(short[] array, int newSize) {
        if (newSize < 0) {
            return array;
        }
        final short[] newArray = new short[newSize];
        if (newSize > 0 && isNotEmpty(array)) {
            System.arraycopy(array, 0, newArray, 0, Math.min(array.length, newSize));
        }
        return newArray;
    }

    /**
     * copy Array to newArray
     *
     * @param array   长整型数组
     * @param newSize 新数组长
     * @return 新数组
     */
    public static long[] resize(long[] array, int newSize) {
        if (newSize < 0) {
            return array;
        }
        final long[] newArray = new long[newSize];
        if (newSize > 0 && isNotEmpty(array)) {
            System.arraycopy(array, 0, newArray, 0, Math.min(array.length, newSize));
        }
        return newArray;
    }

    /**
     * copy Array to newArray
     *
     * @param array   单精度实数型数组
     * @param newSize 新数组长
     * @return 新数组
     */
    public static float[] resize(float[] array, int newSize) {
        if (newSize < 0) {
            return array;
        }
        final float[] newArray = new float[newSize];
        if (newSize > 0 && isNotEmpty(array)) {
            System.arraycopy(array, 0, newArray, 0, Math.min(array.length, newSize));
        }
        return newArray;
    }

    /**
     * copy Array to newArray
     *
     * @param array   双精度实数型数组
     * @param newSize 新数组长
     * @return 新数组
     */
    public static double[] resize(double[] array, int newSize) {
        if (newSize < 0) {
            return array;
        }
        final double[] newArray = new double[newSize];
        if (newSize > 0 && isNotEmpty(array)) {
            System.arraycopy(array, 0, newArray, 0, Math.min(array.length, newSize));
        }
        return newArray;
    }

    /**
     * copy Array to newArray
     *
     * @param array   byte数组
     * @param newSize 新数组长
     * @return 新数组
     */
    public static byte[] resize(byte[] array, int newSize) {
        if (newSize < 0) {
            return array;
        }
        final byte[] newArray = new byte[newSize];
        if (newSize > 0 && isNotEmpty(array)) {
            System.arraycopy(array, 0, newArray, 0, Math.min(array.length, newSize));
        }
        return newArray;
    }

    /**
     * copy Array to newArray
     *
     * @param array   字符型数组
     * @param newSize 新数组长
     * @return 新数组
     */
    public static char[] resize(char[] array, int newSize) {
        if (newSize < 0) {
            return array;
        }
        final char[] newArray = new char[newSize];
        if (newSize > 0 && isNotEmpty(array)) {
            System.arraycopy(array, 0, newArray, 0, Math.min(array.length, newSize));
        }
        return newArray;
    }

    /**
     * copy Array to newArray
     *
     * @param array   布尔型数组
     * @param newSize 新数组长
     * @return 新数组
     */
    public static boolean[] resize(boolean[] array, int newSize) {
        if (newSize < 0) {
            return array;
        }
        final boolean[] newArray = new boolean[newSize];
        if (newSize > 0 && isNotEmpty(array)) {
            System.arraycopy(array, 0, newArray, 0, Math.min(array.length, newSize));
        }
        return newArray;
    }

    /*
     addAll Method
     支持多数组按参数序列合并，跳过空数组
     */


    /**
     * 多数组合并
     *
     * @param arrays 多数组
     * @return 合并后新数组
     */
    public static int[] addAll(int[]... arrays) {
        if (arrays.length == 1) {
            return arrays[0];
        }
        int len = 0;
        for (int[] array : arrays) {
            if (array != null) {
                len += array.length;
            }
        }
        final int[] result = new int[len];
        len = 0;
        for (int[] array : arrays) {
            if (array != null) {
                System.arraycopy(array, 0, result, len, array.length);
                len += array.length;
            }
        }
        return result;
    }

    /**
     * 多数组合并
     *
     * @param arrays 多数组
     * @return 合并后新数组
     */
    public static short[] addAll(short[]... arrays) {
        if (arrays.length == 1) {
            return arrays[0];
        }
        int len = 0;
        for (short[] array : arrays) {
            if (array != null) {
                len += array.length;
            }
        }
        final short[] result = new short[len];
        len = 0;
        for (short[] array : arrays) {
            if (array != null) {
                System.arraycopy(array, 0, result, len, array.length);
                len += array.length;
            }
        }
        return result;
    }

    /**
     * 多数组合并
     *
     * @param arrays 多数组
     * @return 合并后新数组
     */
    public static long[] addAll(long[]... arrays) {
        if (arrays.length == 1) {
            return arrays[0];
        }
        int len = 0;
        for (long[] array : arrays) {
            if (array != null) {
                len += array.length;
            }
        }
        final long[] result = new long[len];
        len = 0;
        for (long[] array : arrays) {
            if (array != null) {
                System.arraycopy(array, 0, result, len, array.length);
                len += array.length;
            }
        }
        return result;
    }

    /**
     * 多数组合并
     *
     * @param arrays 多数组
     * @return 合并后新数组
     */
    public static float[] addAll(float[]... arrays) {
        if (arrays.length == 1) {
            return arrays[0];
        }
        int len = 0;
        for (float[] array : arrays) {
            if (array != null) {
                len += array.length;
            }
        }
        final float[] result = new float[len];
        len = 0;
        for (float[] array : arrays) {
            if (array != null) {
                System.arraycopy(array, 0, result, len, array.length);
                len += array.length;
            }
        }
        return result;
    }

    /**
     * 多数组合并
     *
     * @param arrays 多数组
     * @return 合并后新数组
     */
    public static double[] addAll(double[]... arrays) {
        if (arrays.length == 1) {
            return arrays[0];
        }
        int len = 0;
        for (double[] array : arrays) {
            if (array != null) {
                len += array.length;
            }
        }
        final double[] result = new double[len];
        len = 0;
        for (double[] array : arrays) {
            if (array != null) {
                System.arraycopy(array, 0, result, len, array.length);
                len += array.length;
            }
        }
        return result;
    }

    /**
     * 多数组合并
     *
     * @param arrays 多数组
     * @return 合并后新数组
     */
    public static byte[] addAll(byte[]... arrays) {
        if (arrays.length == 1) {
            return arrays[0];
        }
        int len = 0;
        for (byte[] array : arrays) {
            if (array != null) {
                len += array.length;
            }
        }
        final byte[] result = new byte[len];
        len = 0;
        for (byte[] array : arrays) {
            if (array != null) {
                System.arraycopy(array, 0, result, len, array.length);
                len += array.length;
            }
        }
        return result;
    }

    /**
     * 多数组合并
     *
     * @param arrays 多数组
     * @return 合并后新数组
     */
    public static char[] addAll(char[]... arrays) {
        if (arrays.length == 1) {
            return arrays[0];
        }
        int len = 0;
        for (char[] array : arrays) {
            if (array != null) {
                len += array.length;
            }
        }
        final char[] result = new char[len];
        len = 0;
        for (char[] array : arrays) {
            if (array != null) {
                System.arraycopy(array, 0, result, len, array.length);
                len += array.length;
            }
        }
        return result;
    }

    /**
     * 多数组合并
     *
     * @param arrays 多数组
     * @return 合并后新数组
     */
    public static boolean[] addAll(boolean[]... arrays) {
        if (arrays.length == 1) {
            return arrays[0];
        }
        int len = 0;
        for (boolean[] array : arrays) {
            if (array != null) {
                len += array.length;
            }
        }
        final boolean[] result = new boolean[len];
        len = 0;
        for (boolean[] array : arrays) {
            if (array != null) {
                System.arraycopy(array, 0, result, len, array.length);
                len += array.length;
            }
        }
        return result;
    }

    /*
     range Method for int
     */

    /**
     * 返回以0为开始，end为结束的左闭右开区间
     *
     * @param end 区间右边界
     * @return [0, end)
     */
    public static int[] range(int end) {
        return range(0, end, 1);
    }

    /**
     * 返回以start为开始，end为结束的左闭右开区间
     *
     * @param start 区间左边界
     * @param end   区间右边界
     * @return [start, end)
     */
    public static int[] range(int start, int end) {
        return range(start, end, 1);
    }

    /**
     * 返回以start为开始，end为结束的左闭右开区间
     *
     * @param start 区间左边界
     * @param end   区间右边界
     * @param step  步长
     * @return [start, end)
     */
    public static int[] range(int start, int end, int step) {
        if (start > end) {
            int temp = start;
            start = end;
            end = temp;
        }
        if (step <= 0) {
            step = 1;
        }
        int deviation = end - start;
        int len = deviation / step;
        if (deviation % step != 0) {
            len += 1;
        }
        int[] range = new int[len];
        for (int i = 0; i < len; i++) {
            range[i] = start;
            start += step;
        }
        return range;
    }

    /*
     split Method
     */

    /**
     * 根据给定长度等分原始数组（不保证数组长度对齐）
     *
     * @param array 原始数组
     * @param len   给定长度
     * @return 切割后二维数组
     */
    public static int[][] split(int[] array, int len) {
        int x = array.length / len;
        int y = array.length % len;
        int z = 0;
        if (y != 0) {
            z = 1;
        }
        int[][] arrays = new int[x + z][];
        int[] arr;
        for (int i = 0; i < x + z; i++) {
            arr = new int[len];
            if (i == x + z - 1 && y != 0) {
                System.arraycopy(array, i * len, arr, 0, y);
            } else {
                System.arraycopy(array, i * len, arr, 0, len);
            }
            arrays[i] = arr;
        }
        return arrays;
    }

    /**
     * 根据给定长度等分原始数组（不保证数组长度对齐）
     *
     * @param array 原始数组
     * @param len   给定长度
     * @return 切割后二维数组
     */
    public static short[][] split(short[] array, int len) {
        int x = array.length / len;
        int y = array.length % len;
        int z = 0;
        if (y != 0) {
            z = 1;
        }
        short[][] arrays = new short[x + z][];
        short[] arr;
        for (int i = 0; i < x + z; i++) {
            arr = new short[len];
            if (i == x + z - 1 && y != 0) {
                System.arraycopy(array, i * len, arr, 0, y);
            } else {
                System.arraycopy(array, i * len, arr, 0, len);
            }
            arrays[i] = arr;
        }
        return arrays;
    }

    /**
     * 根据给定长度等分原始数组（不保证数组长度对齐）
     *
     * @param array 原始数组
     * @param len   给定长度
     * @return 切割后二维数组
     */
    public static long[][] split(long[] array, int len) {
        int x = array.length / len;
        int y = array.length % len;
        int z = 0;
        if (y != 0) {
            z = 1;
        }
        long[][] arrays = new long[x + z][];
        long[] arr;
        for (int i = 0; i < x + z; i++) {
            arr = new long[len];
            if (i == x + z - 1 && y != 0) {
                System.arraycopy(array, i * len, arr, 0, y);
            } else {
                System.arraycopy(array, i * len, arr, 0, len);
            }
            arrays[i] = arr;
        }
        return arrays;
    }

    /**
     * 根据给定长度等分原始数组（不保证数组长度对齐）
     *
     * @param array 原始数组
     * @param len   给定长度
     * @return 切割后二维数组
     */
    public static float[][] split(float[] array, int len) {
        int x = array.length / len;
        int y = array.length % len;
        int z = 0;
        if (y != 0) {
            z = 1;
        }
        float[][] arrays = new float[x + z][];
        float[] arr;
        for (int i = 0; i < x + z; i++) {
            arr = new float[len];
            if (i == x + z - 1 && y != 0) {
                System.arraycopy(array, i * len, arr, 0, y);
            } else {
                System.arraycopy(array, i * len, arr, 0, len);
            }
            arrays[i] = arr;
        }
        return arrays;
    }

    /**
     * 根据给定长度等分原始数组（不保证数组长度对齐）
     *
     * @param array 原始数组
     * @param len   给定长度
     * @return 切割后二维数组
     */
    public static double[][] split(double[] array, int len) {
        int x = array.length / len;
        int y = array.length % len;
        int z = 0;
        if (y != 0) {
            z = 1;
        }
        double[][] arrays = new double[x + z][];
        double[] arr;
        for (int i = 0; i < x + z; i++) {
            arr = new double[len];
            if (i == x + z - 1 && y != 0) {
                System.arraycopy(array, i * len, arr, 0, y);
            } else {
                System.arraycopy(array, i * len, arr, 0, len);
            }
            arrays[i] = arr;
        }
        return arrays;
    }

    /**
     * 根据给定长度等分原始数组（不保证数组长度对齐）
     *
     * @param array 原始数组
     * @param len   给定长度
     * @return 切割后二维数组
     */
    public static byte[][] split(byte[] array, int len) {
        int x = array.length / len;
        int y = array.length % len;
        int z = 0;
        if (y != 0) {
            z = 1;
        }
        byte[][] arrays = new byte[x + z][];
        byte[] arr;
        for (int i = 0; i < x + z; i++) {
            arr = new byte[len];
            if (i == x + z - 1 && y != 0) {
                System.arraycopy(array, i * len, arr, 0, y);
            } else {
                System.arraycopy(array, i * len, arr, 0, len);
            }
            arrays[i] = arr;
        }
        return arrays;
    }

    /**
     * 根据给定长度等分原始数组（不保证数组长度对齐）
     *
     * @param array 原始数组
     * @param len   给定长度
     * @return 切割后二维数组
     */
    public static char[][] split(char[] array, int len) {
        int x = array.length / len;
        int y = array.length % len;
        int z = 0;
        if (y != 0) {
            z = 1;
        }
        char[][] arrays = new char[x + z][];
        char[] arr;
        for (int i = 0; i < x + z; i++) {
            arr = new char[len];
            if (i == x + z - 1 && y != 0) {
                System.arraycopy(array, i * len, arr, 0, y);
            } else {
                System.arraycopy(array, i * len, arr, 0, len);
            }
            arrays[i] = arr;
        }
        return arrays;
    }

    /**
     * 根据给定长度等分原始数组（不保证数组长度对齐）
     *
     * @param array 原始数组
     * @param len   给定长度
     * @return 切割后二维数组
     */
    public static boolean[][] split(boolean[] array, int len) {
        int x = array.length / len;
        int y = array.length % len;
        int z = 0;
        if (y != 0) {
            z = 1;
        }
        boolean[][] arrays = new boolean[x + z][];
        boolean[] arr;
        for (int i = 0; i < x + z; i++) {
            arr = new boolean[len];
            if (i == x + z - 1 && y != 0) {
                System.arraycopy(array, i * len, arr, 0, y);
            } else {
                System.arraycopy(array, i * len, arr, 0, len);
            }
            arrays[i] = arr;
        }
        return arrays;
    }

    /*
     indexOf Method
     返回首次出现指定元素位置
     */

    /**
     * 返回指定元素在目标数组中首次出现位置
     * 无目标元素返回{@link #INDEX_OVER}
     *
     * @param array 目标数组
     * @param value 指定元素
     * @return 指定元素在目标数组中首次出现位置, 无目标元素返回{@link #INDEX_OVER}
     */
    public static int indexOf(int[] array, int value) {
        if (isNotEmpty(array)) {
            for (int i = 0; i < array.length; i++) {
                if (value == array[i]) {
                    return i;
                }
            }
        }
        return INDEX_OVER;
    }

    /**
     * 返回指定元素在目标数组中首次出现位置
     * 无目标元素返回{@link #INDEX_OVER}
     *
     * @param array 目标数组
     * @param value 指定元素
     * @return 指定元素在目标数组中首次出现位置, 无目标元素返回{@link #INDEX_OVER}
     */
    public static int indexOf(short[] array, short value) {
        if (isNotEmpty(array)) {
            for (int i = 0; i < array.length; i++) {
                if (value == array[i]) {
                    return i;
                }
            }
        }
        return INDEX_OVER;
    }

    /**
     * 返回指定元素在目标数组中首次出现位置
     * 无目标元素返回{@link #INDEX_OVER}
     *
     * @param array 目标数组
     * @param value 指定元素
     * @return 指定元素在目标数组中首次出现位置, 无目标元素返回{@link #INDEX_OVER}
     */
    public static int indexOf(long[] array, long value) {
        if (isNotEmpty(array)) {
            for (int i = 0; i < array.length; i++) {
                if (value == array[i]) {
                    return i;
                }
            }
        }
        return INDEX_OVER;
    }

    /**
     * 返回指定元素在目标数组中首次出现位置
     * 无目标元素返回{@link #INDEX_OVER}
     *
     * @param array 目标数组
     * @param value 指定元素
     * @return 指定元素在目标数组中首次出现位置, 无目标元素返回{@link #INDEX_OVER}
     */
    public static int indexOf(float[] array, float value) {
        if (isNotEmpty(array)) {
            for (int i = 0; i < array.length; i++) {
                if (value == array[i]) {
                    return i;
                }
            }
        }
        return INDEX_OVER;
    }

    /**
     * 返回指定元素在目标数组中首次出现位置
     * 无目标元素返回{@link #INDEX_OVER}
     *
     * @param array 目标数组
     * @param value 指定元素
     * @return 指定元素在目标数组中首次出现位置, 无目标元素返回{@link #INDEX_OVER}
     */
    public static int indexOf(double[] array, double value) {
        if (isNotEmpty(array)) {
            for (int i = 0; i < array.length; i++) {
                if (value == array[i]) {
                    return i;
                }
            }
        }
        return INDEX_OVER;
    }

    /**
     * 返回指定元素在目标数组中首次出现位置
     * 无目标元素返回{@link #INDEX_OVER}
     *
     * @param array 目标数组
     * @param value 指定元素
     * @return 指定元素在目标数组中首次出现位置, 无目标元素返回{@link #INDEX_OVER}
     */
    public static int indexOf(byte[] array, byte value) {
        if (isNotEmpty(array)) {
            for (int i = 0; i < array.length; i++) {
                if (value == array[i]) {
                    return i;
                }
            }
        }
        return INDEX_OVER;
    }

    /**
     * 返回指定元素在目标数组中首次出现位置
     * 无目标元素返回{@link #INDEX_OVER}
     *
     * @param array 目标数组
     * @param value 指定元素
     * @return 指定元素在目标数组中首次出现位置, 无目标元素返回{@link #INDEX_OVER}
     */
    public static int indexOf(char[] array, char value) {
        if (isNotEmpty(array)) {
            for (int i = 0; i < array.length; i++) {
                if (value == array[i]) {
                    return i;
                }
            }
        }
        return INDEX_OVER;
    }

    /**
     * 返回指定元素在目标数组中首次出现位置
     * 无目标元素返回{@link #INDEX_OVER}
     *
     * @param array 目标数组
     * @param value 指定元素
     * @return 指定元素在目标数组中首次出现位置, 无目标元素返回{@link #INDEX_OVER}
     */
    public static int indexOf(boolean[] array, boolean value) {
        if (isNotEmpty(array)) {
            for (int i = 0; i < array.length; i++) {
                if (value == array[i]) {
                    return i;
                }
            }
        }
        return INDEX_OVER;
    }

    /*
     lastIndexOf Method
     返回指定元素在目标数组中最后出现的位置
     */

    /**
     * 返回指定元素在目标数组中最后出现位置
     * 无目标元素返回{@link #INDEX_OVER}
     *
     * @param array 目标数组
     * @param value 指定元素
     * @return 指定元素在目标数组中最后出现位置, 无目标元素返回{@link #INDEX_OVER}
     */
    public static int lastIndexOf(int[] array, int value) {
        if (isNotEmpty(array)) {
            for (int i = array.length - 1; i >= 0; i--) {
                if (value == array[i]) {
                    return i;
                }
            }
        }
        return INDEX_OVER;
    }

    /**
     * 返回指定元素在目标数组中最后出现位置
     * 无目标元素返回{@link #INDEX_OVER}
     *
     * @param array 目标数组
     * @param value 指定元素
     * @return 指定元素在目标数组中最后出现位置, 无目标元素返回{@link #INDEX_OVER}
     */
    public static int lastIndexOf(short[] array, short value) {
        if (isNotEmpty(array)) {
            for (int i = array.length - 1; i >= 0; i--) {
                if (value == array[i]) {
                    return i;
                }
            }
        }
        return INDEX_OVER;
    }

    /**
     * 返回指定元素在目标数组中最后出现位置
     * 无目标元素返回{@link #INDEX_OVER}
     *
     * @param array 目标数组
     * @param value 指定元素
     * @return 指定元素在目标数组中最后出现位置, 无目标元素返回{@link #INDEX_OVER}
     */
    public static int lastIndexOf(long[] array, long value) {
        if (isNotEmpty(array)) {
            for (int i = array.length - 1; i >= 0; i--) {
                if (value == array[i]) {
                    return i;
                }
            }
        }
        return INDEX_OVER;
    }

    /**
     * 返回指定元素在目标数组中最后出现位置
     * 无目标元素返回{@link #INDEX_OVER}
     *
     * @param array 目标数组
     * @param value 指定元素
     * @return 指定元素在目标数组中最后出现位置, 无目标元素返回{@link #INDEX_OVER}
     */
    public static int lastIndexOf(float[] array, float value) {
        if (isNotEmpty(array)) {
            for (int i = array.length - 1; i >= 0; i--) {
                if (value == array[i]) {
                    return i;
                }
            }
        }
        return INDEX_OVER;
    }

    /**
     * 返回指定元素在目标数组中最后出现位置
     * 无目标元素返回{@link #INDEX_OVER}
     *
     * @param array 目标数组
     * @param value 指定元素
     * @return 指定元素在目标数组中最后出现位置, 无目标元素返回{@link #INDEX_OVER}
     */
    public static int lastIndexOf(double[] array, double value) {
        if (isNotEmpty(array)) {
            for (int i = array.length - 1; i >= 0; i--) {
                if (value == array[i]) {
                    return i;
                }
            }
        }
        return INDEX_OVER;
    }

    /**
     * 返回指定元素在目标数组中最后出现位置
     * 无目标元素返回{@link #INDEX_OVER}
     *
     * @param array 目标数组
     * @param value 指定元素
     * @return 指定元素在目标数组中最后出现位置, 无目标元素返回{@link #INDEX_OVER}
     */
    public static int lastIndexOf(byte[] array, byte value) {
        if (isNotEmpty(array)) {
            for (int i = array.length - 1; i >= 0; i--) {
                if (value == array[i]) {
                    return i;
                }
            }
        }
        return INDEX_OVER;
    }

    /**
     * 返回指定元素在目标数组中最后出现位置
     * 无目标元素返回{@link #INDEX_OVER}
     *
     * @param array 目标数组
     * @param value 指定元素
     * @return 指定元素在目标数组中最后出现位置, 无目标元素返回{@link #INDEX_OVER}
     */
    public static int lastIndexOf(char[] array, char value) {
        if (isNotEmpty(array)) {
            for (int i = array.length - 1; i >= 0; i--) {
                if (value == array[i]) {
                    return i;
                }
            }
        }
        return INDEX_OVER;
    }

    /**
     * 返回指定元素在目标数组中最后出现位置
     * 无目标元素返回{@link #INDEX_OVER}
     *
     * @param array 目标数组
     * @param value 指定元素
     * @return 指定元素在目标数组中最后出现位置, 无目标元素返回{@link #INDEX_OVER}
     */
    public static int lastIndexOf(boolean[] array, boolean value) {
        if (isNotEmpty(array)) {
            for (int i = array.length - 1; i >= 0; i--) {
                if (value == array[i]) {
                    return i;
                }
            }
        }
        return INDEX_OVER;
    }

    /*
     contains Method
     检查是否包含指定元素
     */

    /**
     * 检查数组中是否包含指定元素
     *
     * @param array 目标数组
     * @param value 指定元素
     * @return 是否包含
     */
    public static boolean contains(int[] array, int value) {
        return indexOf(array, value) > INDEX_OVER;
    }

    /**
     * 检查数组中是否包含指定元素
     *
     * @param array 目标数组
     * @param value 指定元素
     * @return 是否包含
     */
    public static boolean contains(short[] array, short value) {
        return indexOf(array, value) > INDEX_OVER;
    }

    /**
     * 检查数组中是否包含指定元素
     *
     * @param array 目标数组
     * @param value 指定元素
     * @return 是否包含
     */
    public static boolean contains(long[] array, long value) {
        return indexOf(array, value) > INDEX_OVER;
    }

    /**
     * 检查数组中是否包含指定元素
     *
     * @param array 目标数组
     * @param value 指定元素
     * @return 是否包含
     */
    public static boolean contains(float[] array, float value) {
        return indexOf(array, value) > INDEX_OVER;
    }

    /**
     * 检查数组中是否包含指定元素
     *
     * @param array 目标数组
     * @param value 指定元素
     * @return 是否包含
     */
    public static boolean contains(double[] array, double value) {
        return indexOf(array, value) > INDEX_OVER;
    }

    /**
     * 检查数组中是否包含指定元素
     *
     * @param array 目标数组
     * @param value 指定元素
     * @return 是否包含
     */
    public static boolean contains(byte[] array, byte value) {
        return indexOf(array, value) > INDEX_OVER;
    }

    /**
     * 检查数组中是否包含指定元素
     *
     * @param array 目标数组
     * @param value 指定元素
     * @return 是否包含
     */
    public static boolean contains(char[] array, char value) {
        return indexOf(array, value) > INDEX_OVER;
    }

    /**
     * 检查数组中是否包含指定元素
     *
     * @param array 目标数组
     * @param value 指定元素
     * @return 是否包含
     */
    public static boolean contains(boolean[] array, boolean value) {
        return indexOf(array, value) > INDEX_OVER;
    }

    /*
     sub Method
     提取子数组
     */

    /**
     * 提取子数组
     *
     * @param array 原始数组
     * @param start 起始下标
     * @param end   结束下标+1
     * @return 子数组
     */
    public static int[] sub(int[] array, int start, int end) {
        if (isEmpty(array)) {
            return array;
        }
        int len = array.length;
        if (start < 0) {
            start += len;
        }
        if (end < 0) {
            end += len;
        }
        if (start == len) {
            return new int[0];
        }
        if (start > end) {
            int temp = start;
            start = end;
            end = temp;
        }
        if (end > len) {
            if (start >= len) {
                return new int[0];
            }
            end = len;
        }
        return Arrays.copyOfRange(array, start, end);
    }

    /**
     * 提取子数组
     *
     * @param array 原始数组
     * @param start 起始下标
     * @param end   结束下标+1
     * @return 子数组
     */
    public static short[] sub(short[] array, int start, int end) {
        if (isEmpty(array)) {
            return array;
        }
        int len = array.length;
        if (start < 0) {
            start += len;
        }
        if (end < 0) {
            end += len;
        }
        if (start == len) {
            return new short[0];
        }
        if (start > end) {
            int temp = start;
            start = end;
            end = temp;
        }
        if (end > len) {
            if (start >= len) {
                return new short[0];
            }
            end = len;
        }
        return Arrays.copyOfRange(array, start, end);
    }

    /**
     * 提取子数组
     *
     * @param array 原始数组
     * @param start 起始下标
     * @param end   结束下标+1
     * @return 子数组
     */
    public static long[] sub(long[] array, int start, int end) {
        if (isEmpty(array)) {
            return array;
        }
        int len = array.length;
        if (start < 0) {
            start += len;
        }
        if (end < 0) {
            end += len;
        }
        if (start == len) {
            return new long[0];
        }
        if (start > end) {
            int temp = start;
            start = end;
            end = temp;
        }
        if (end > len) {
            if (start >= len) {
                return new long[0];
            }
            end = len;
        }
        return Arrays.copyOfRange(array, start, end);
    }

    /**
     * 提取子数组
     *
     * @param array 原始数组
     * @param start 起始下标
     * @param end   结束下标+1
     * @return 子数组
     */
    public static float[] sub(float[] array, int start, int end) {
        if (isEmpty(array)) {
            return array;
        }
        int len = array.length;
        if (start < 0) {
            start += len;
        }
        if (end < 0) {
            end += len;
        }
        if (start == len) {
            return new float[0];
        }
        if (start > end) {
            int temp = start;
            start = end;
            end = temp;
        }
        if (end > len) {
            if (start >= len) {
                return new float[0];
            }
            end = len;
        }
        return Arrays.copyOfRange(array, start, end);
    }

    /**
     * 提取子数组
     *
     * @param array 原始数组
     * @param start 起始下标
     * @param end   结束下标+1
     * @return 子数组
     */
    public static double[] sub(double[] array, int start, int end) {
        if (isEmpty(array)) {
            return array;
        }
        int len = array.length;
        if (start < 0) {
            start += len;
        }
        if (end < 0) {
            end += len;
        }
        if (start == len) {
            return new double[0];
        }
        if (start > end) {
            int temp = start;
            start = end;
            end = temp;
        }
        if (end > len) {
            if (start >= len) {
                return new double[0];
            }
            end = len;
        }
        return Arrays.copyOfRange(array, start, end);
    }

    /**
     * 提取子数组
     *
     * @param array 原始数组
     * @param start 起始下标
     * @param end   结束下标+1
     * @return 子数组
     */
    public static byte[] sub(byte[] array, int start, int end) {
        if (isEmpty(array)) {
            return array;
        }
        int len = array.length;
        if (start < 0) {
            start += len;
        }
        if (end < 0) {
            end += len;
        }
        if (start == len) {
            return new byte[0];
        }
        if (start > end) {
            int temp = start;
            start = end;
            end = temp;
        }
        if (end > len) {
            if (start >= len) {
                return new byte[0];
            }
            end = len;
        }
        return Arrays.copyOfRange(array, start, end);
    }

    /**
     * 提取子数组
     *
     * @param array 原始数组
     * @param start 起始下标
     * @param end   结束下标+1
     * @return 子数组
     */
    public static char[] sub(char[] array, int start, int end) {
        if (isEmpty(array)) {
            return array;
        }
        int len = array.length;
        if (start < 0) {
            start += len;
        }
        if (end < 0) {
            end += len;
        }
        if (start == len) {
            return new char[0];
        }
        if (start > end) {
            int temp = start;
            start = end;
            end = temp;
        }
        if (end > len) {
            if (start >= len) {
                return new char[0];
            }
            end = len;
        }
        return Arrays.copyOfRange(array, start, end);
    }

    /**
     * 提取子数组
     *
     * @param array 原始数组
     * @param start 起始下标
     * @param end   结束下标+1
     * @return 子数组
     */
    public static boolean[] sub(boolean[] array, int start, int end) {
        if (isEmpty(array)) {
            return array;
        }
        int len = array.length;
        if (start < 0) {
            start += len;
        }
        if (end < 0) {
            end += len;
        }
        if (start == len) {
            return new boolean[0];
        }
        if (start > end) {
            int temp = start;
            start = end;
            end = temp;
        }
        if (end > len) {
            if (start >= len) {
                return new boolean[0];
            }
            end = len;
        }
        return Arrays.copyOfRange(array, start, end);
    }

    /*
     swap Method
     交换目标数组中的两个指定元素
     */

    /**
     * 交换目标数组中的两个指定元素
     *
     * @param array  目标数组
     * @param index1 指定元素位置1
     * @param index2 指定元素位置2
     * @return 交换后数组（等价于参数array）
     */
    public static int[] swap(int[] array, int index1, int index2) {
        if (isEmpty(array)) {
            return array;
        }
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
        return array;
    }

    /**
     * 交换目标数组中的两个指定元素
     *
     * @param array  目标数组
     * @param index1 指定元素位置1
     * @param index2 指定元素位置2
     * @return 交换后数组（等价于参数array）
     */
    public static short[] swap(short[] array, int index1, int index2) {
        if (isEmpty(array)) {
            return array;
        }
        short temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
        return array;
    }

    /**
     * 交换目标数组中的两个指定元素
     *
     * @param array  目标数组
     * @param index1 指定元素位置1
     * @param index2 指定元素位置2
     * @return 交换后数组（等价于参数array）
     */
    public static long[] swap(long[] array, int index1, int index2) {
        if (isEmpty(array)) {
            return array;
        }
        long temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
        return array;
    }

    /**
     * 交换目标数组中的两个指定元素
     *
     * @param array  目标数组
     * @param index1 指定元素位置1
     * @param index2 指定元素位置2
     * @return 交换后数组（等价于参数array）
     */
    public static float[] swap(float[] array, int index1, int index2) {
        if (isEmpty(array)) {
            return array;
        }
        float temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
        return array;
    }

    /**
     * 交换目标数组中的两个指定元素
     *
     * @param array  目标数组
     * @param index1 指定元素位置1
     * @param index2 指定元素位置2
     * @return 交换后数组（等价于参数array）
     */
    public static double[] swap(double[] array, int index1, int index2) {
        if (isEmpty(array)) {
            return array;
        }
        double temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
        return array;
    }

    /**
     * 交换目标数组中的两个指定元素
     *
     * @param array  目标数组
     * @param index1 指定元素位置1
     * @param index2 指定元素位置2
     * @return 交换后数组（等价于参数array）
     */
    public static byte[] swap(byte[] array, int index1, int index2) {
        if (isEmpty(array)) {
            return array;
        }
        byte temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
        return array;
    }

    /**
     * 交换目标数组中的两个指定元素
     *
     * @param array  目标数组
     * @param index1 指定元素位置1
     * @param index2 指定元素位置2
     * @return 交换后数组（等价于参数array）
     */
    public static char[] swap(char[] array, int index1, int index2) {
        if (isEmpty(array)) {
            return array;
        }
        char temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
        return array;
    }

    /**
     * 交换目标数组中的两个指定元素
     *
     * @param array  目标数组
     * @param index1 指定元素位置1
     * @param index2 指定元素位置2
     * @return 交换后数组（等价于参数array）
     */
    public static boolean[] swap(boolean[] array, int index1, int index2) {
        if (isEmpty(array)) {
            return array;
        }
        boolean temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
        return array;
    }

    /*
     reverse Method(array, start, end)}
     反转数组
     */

    /**
     * 反转数组
     *
     * @param array 原始数组，即结果数组
     * @param start 开始位置
     * @param end   结束位置，不包括
     * @return 反转后数组
     */
    public static int[] reverse(int[] array, int start, int end) {
        if (isEmpty(array)) {
            return array;
        }
        int i = Math.max(start, 0);
        int j = Math.min(array.length, end) - 1;
        while (j > i) {
            swap(array, i, j);
            j--;
            i++;
        }
        return array;
    }

    /**
     * 反转数组
     *
     * @param array 原始数组，即结果数组
     * @param start 开始位置
     * @param end   结束位置，不包括
     * @return 反转后数组
     */
    public static short[] reverse(short[] array, int start, int end) {
        if (isEmpty(array)) {
            return array;
        }
        int i = Math.max(start, 0);
        int j = Math.min(array.length, end) - 1;
        while (j > i) {
            swap(array, i, j);
            j--;
            i++;
        }
        return array;
    }

    /**
     * 反转数组
     *
     * @param array 原始数组，即结果数组
     * @param start 开始位置
     * @param end   结束位置，不包括
     * @return 反转后数组
     */
    public static long[] reverse(long[] array, int start, int end) {
        if (isEmpty(array)) {
            return array;
        }
        int i = Math.max(start, 0);
        int j = Math.min(array.length, end) - 1;
        while (j > i) {
            swap(array, i, j);
            j--;
            i++;
        }
        return array;
    }

    /**
     * 反转数组
     *
     * @param array 原始数组，即结果数组
     * @param start 开始位置
     * @param end   结束位置，不包括
     * @return 反转后数组
     */
    public static float[] reverse(float[] array, int start, int end) {
        if (isEmpty(array)) {
            return array;
        }
        int i = Math.max(start, 0);
        int j = Math.min(array.length, end) - 1;
        while (j > i) {
            swap(array, i, j);
            j--;
            i++;
        }
        return array;
    }

    /**
     * 反转数组
     *
     * @param array 原始数组，即结果数组
     * @param start 开始位置
     * @param end   结束位置，不包括
     * @return 反转后数组
     */
    public static double[] reverse(double[] array, int start, int end) {
        if (isEmpty(array)) {
            return array;
        }
        int i = Math.max(start, 0);
        int j = Math.min(array.length, end) - 1;
        while (j > i) {
            swap(array, i, j);
            j--;
            i++;
        }
        return array;
    }

    /**
     * 反转数组
     *
     * @param array 原始数组，即结果数组
     * @param start 开始位置
     * @param end   结束位置，不包括
     * @return 反转后数组
     */
    public static byte[] reverse(byte[] array, int start, int end) {
        if (isEmpty(array)) {
            return array;
        }
        int i = Math.max(start, 0);
        int j = Math.min(array.length, end) - 1;
        while (j > i) {
            swap(array, i, j);
            j--;
            i++;
        }
        return array;
    }

    /**
     * 反转数组
     *
     * @param array 原始数组，即结果数组
     * @param start 开始位置
     * @param end   结束位置，不包括
     * @return 反转后数组
     */
    public static char[] reverse(char[] array, int start, int end) {
        if (isEmpty(array)) {
            return array;
        }
        int i = Math.max(start, 0);
        int j = Math.min(array.length, end) - 1;
        while (j > i) {
            swap(array, i, j);
            j--;
            i++;
        }
        return array;
    }

    /**
     * 反转数组
     *
     * @param array 原始数组，即结果数组
     * @param start 开始位置
     * @param end   结束位置，不包括
     * @return 反转后数组
     */
    public static boolean[] reverse(boolean[] array, int start, int end) {
        if (isEmpty(array)) {
            return array;
        }
        int i = Math.max(start, 0);
        int j = Math.min(array.length, end) - 1;
        while (j > i) {
            swap(array, i, j);
            j--;
            i++;
        }
        return array;
    }

    /*
     reverse Method(array)
     反转数组
     */

    /**
     * 反转数组
     *
     * @param array 原始数组
     * @return 反转后数组
     */
    public static int[] reverse(int[] array) {
        return reverse(array, 0, array.length);
    }

    /**
     * 反转数组
     *
     * @param array 原始数组
     * @return 反转后数组
     */
    public static short[] reverse(short[] array) {
        return reverse(array, 0, array.length);
    }

    /**
     * 反转数组
     *
     * @param array 原始数组
     * @return 反转后数组
     */
    public static long[] reverse(long[] array) {
        return reverse(array, 0, array.length);
    }

    /**
     * 反转数组
     *
     * @param array 原始数组
     * @return 反转后数组
     */
    public static float[] reverse(float[] array) {
        return reverse(array, 0, array.length);
    }

    /**
     * 反转数组
     *
     * @param array 原始数组
     * @return 反转后数组
     */
    public static double[] reverse(double[] array) {
        return reverse(array, 0, array.length);
    }

    /**
     * 反转数组
     *
     * @param array 原始数组
     * @return 反转后数组
     */
    public static byte[] reverse(byte[] array) {
        return reverse(array, 0, array.length);
    }

    /**
     * 反转数组
     *
     * @param array 原始数组
     * @return 反转后数组
     */
    public static char[] reverse(char[] array) {
        return reverse(array, 0, array.length);
    }

    /**
     * 反转数组
     *
     * @param array 原始数组
     * @return 反转后数组
     */
    public static boolean[] reverse(boolean[] array) {
        return reverse(array, 0, array.length);
    }

    /*
    min Method(array)
    取最小值
     */

    /**
     * 取最小值
     *
     * @param array 数字数组
     * @return 最小值
     */
    public static int min(int[] array) {
        if (isEmpty(array)) {
            throw new IllegalArgumentException("Number array must not empty!");
        }
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }
        return min;
    }

    /**
     * 取最小值
     *
     * @param array 数字数组
     * @return 最小值
     */
    public static short min(short[] array) {
        if (isEmpty(array)) {
            throw new IllegalArgumentException("Number array must not empty!");
        }
        short min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }
        return min;
    }

    /**
     * 取最小值
     *
     * @param array 数字数组
     * @return 最小值
     */
    public static long min(long[] array) {
        if (isEmpty(array)) {
            throw new IllegalArgumentException("Number array must not empty!");
        }
        long min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }
        return min;
    }

    /**
     * 取最小值
     *
     * @param array 数字数组
     * @return 最小值
     */
    public static float min(float[] array) {
        if (isEmpty(array)) {
            throw new IllegalArgumentException("Number array must not empty!");
        }
        float min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }
        return min;
    }

    /**
     * 取最小值
     *
     * @param array 数字数组
     * @return 最小值
     */
    public static double min(double[] array) {
        if (isEmpty(array)) {
            throw new IllegalArgumentException("Number array must not empty!");
        }
        double min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }
        return min;
    }

    /**
     * 取最小值
     *
     * @param array 数字数组
     * @return 最小值
     */
    public static byte min(byte[] array) {
        if (isEmpty(array)) {
            throw new IllegalArgumentException("Number array must not empty!");
        }
        byte min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }
        return min;
    }

    /**
     * 取最小值
     *
     * @param array 数字数组
     * @return 最小值
     */
    public static char min(char[] array) {
        if (isEmpty(array)) {
            throw new IllegalArgumentException("Number array must not empty!");
        }
        char min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }
        return min;
    }

    /*
    max Method(array)
    取最大值
     */

    /**
     * 取最大值
     *
     * @param array 数字数组
     * @return 最大值
     */
    public static int max(int[] array) {
        if (isEmpty(array)) {
            throw new IllegalArgumentException("Number array must not empty!");
        }
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        return max;
    }

    /**
     * 取最大值
     *
     * @param array 数字数组
     * @return 最大值
     */
    public static short max(short[] array) {
        if (isEmpty(array)) {
            throw new IllegalArgumentException("Number array must not empty!");
        }
        short max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        return max;
    }

    /**
     * 取最大值
     *
     * @param array 数字数组
     * @return 最大值
     */
    public static long max(long[] array) {
        if (isEmpty(array)) {
            throw new IllegalArgumentException("Number array must not empty!");
        }
        long max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        return max;
    }

    /**
     * 取最大值
     *
     * @param array 数字数组
     * @return 最大值
     */
    public static float max(float[] array) {
        if (isEmpty(array)) {
            throw new IllegalArgumentException("Number array must not empty!");
        }
        float max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        return max;
    }

    /**
     * 取最大值
     *
     * @param array 数字数组
     * @return 最大值
     */
    public static double max(double[] array) {
        if (isEmpty(array)) {
            throw new IllegalArgumentException("Number array must not empty!");
        }
        double max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        return max;
    }

    /**
     * 取最大值
     *
     * @param array 数字数组
     * @return 最大值
     */
    public static byte max(byte[] array) {
        if (isEmpty(array)) {
            throw new IllegalArgumentException("Number array must not empty!");
        }
        byte max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        return max;
    }

    /**
     * 取最大值
     *
     * @param array 数字数组
     * @return 最大值
     */
    public static char max(char[] array) {
        if (isEmpty(array)) {
            throw new IllegalArgumentException("Number array must not empty!");
        }
        char max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        return max;
    }

    /*
    isSortedASC Method(array)
    检查数组是否升序
    空数组返回false
     */

    /**
     * 检查数组是否满足升序条件
     *
     * @param array 被检查数组
     * @return 是否升序，空数组返回false
     */
    public static boolean isSortedASC(int[] array) {
        if (isEmpty(array)) {
            return false;
        }
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 检查数组是否满足升序条件
     *
     * @param array 被检查数组
     * @return 是否升序，空数组返回false
     */
    public static boolean isSortedASC(short[] array) {
        if (isEmpty(array)) {
            return false;
        }
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 检查数组是否满足升序条件
     *
     * @param array 被检查数组
     * @return 是否升序，空数组返回false
     */
    public static boolean isSortedASC(long[] array) {
        if (isEmpty(array)) {
            return false;
        }
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 检查数组是否满足升序条件
     *
     * @param array 被检查数组
     * @return 是否升序，空数组返回false
     */
    public static boolean isSortedASC(float[] array) {
        if (isEmpty(array)) {
            return false;
        }
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 检查数组是否满足升序条件
     *
     * @param array 被检查数组
     * @return 是否升序，空数组返回false
     */
    public static boolean isSortedASC(double[] array) {
        if (isEmpty(array)) {
            return false;
        }
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 检查数组是否满足升序条件
     *
     * @param array 被检查数组
     * @return 是否升序，空数组返回false
     */
    public static boolean isSortedASC(byte[] array) {
        if (isEmpty(array)) {
            return false;
        }
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 检查数组是否满足升序条件
     *
     * @param array 被检查数组
     * @return 是否升序，空数组返回false
     */
    public static boolean isSortedASC(char[] array) {
        if (isEmpty(array)) {
            return false;
        }
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    /*
    isSortedDESC Method
    检查数组是否满足降序条件
    空数组返回false
     */

    /**
     * 检查数组是否满足降序条件
     *
     * @param array 被检查数组
     * @return 是否降序，空数组返回false
     */
    public static boolean isSortedDESC(int[] array) {
        if (isEmpty(array)) {
            return false;
        }
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] < array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 检查数组是否满足降序条件
     *
     * @param array 被检查数组
     * @return 是否降序，空数组返回false
     */
    public static boolean isSortedDESC(short[] array) {
        if (isEmpty(array)) {
            return false;
        }
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] < array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 检查数组是否满足降序条件
     *
     * @param array 被检查数组
     * @return 是否降序，空数组返回false
     */
    public static boolean isSortedDESC(long[] array) {
        if (isEmpty(array)) {
            return false;
        }
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] < array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 检查数组是否满足降序条件
     *
     * @param array 被检查数组
     * @return 是否降序，空数组返回false
     */
    public static boolean isSortedDESC(float[] array) {
        if (isEmpty(array)) {
            return false;
        }
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] < array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 检查数组是否满足降序条件
     *
     * @param array 被检查数组
     * @return 是否降序，空数组返回false
     */
    public static boolean isSortedDESC(double[] array) {
        if (isEmpty(array)) {
            return false;
        }
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] < array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 检查数组是否满足降序条件
     *
     * @param array 被检查数组
     * @return 是否降序，空数组返回false
     */
    public static boolean isSortedDESC(byte[] array) {
        if (isEmpty(array)) {
            return false;
        }
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] < array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 检查数组是否满足降序条件
     *
     * @param array 被检查数组
     * @return 是否降序，空数组返回false
     */
    public static boolean isSortedDESC(char[] array) {
        if (isEmpty(array)) {
            return false;
        }
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] < array[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
