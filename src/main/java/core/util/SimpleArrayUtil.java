package core.util;

/**
 * @ProjectName: yoTool
 * @Package: core.util
 * @ClassName: SimpleArrayUtil
 * @Description: 数组操作简单工具类
 * @Author: Young
 * @CreateDate: 2021/2/5 20:47
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/2/5 20:47
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class SimpleArrayUtil {
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
        if (newSize < 0)
            return array;
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
        if (newSize < 0)
            return array;
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
        if (newSize < 0)
            return array;
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
        if (newSize < 0)
            return array;
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
        if (newSize < 0)
            return array;
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
        if (newSize < 0)
            return array;
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
        if (newSize < 0)
            return array;
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
        if (newSize < 0)
            return array;
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
        if (arrays.length == 1)
            return arrays[0];
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
}
