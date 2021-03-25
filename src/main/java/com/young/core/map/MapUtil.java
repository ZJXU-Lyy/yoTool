package com.young.core.map;

import java.util.Map;

/**
 * @ProjectName: yoTool
 * @Package: com.young.core.map
 * @ClassName: MapUtil
 * @Description: Map相关工具类
 * @Author: Young
 * @CreateDate: 2021/3/26 3:36
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/3/26 3:36
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class MapUtil {

    /**
     * 默认初始大小
     */
    public static final int DEFAULT_INITIAL_CAPACITY = 16;
    /**
     * 默认增长因子，当Map的size达到 容量*增长因子时，开始扩充Map
     */
    public static final float DEFAULT_LOAD_FACTOR = 0.75f;

    /**
     * Map是否为空
     *
     * @param map 集合
     * @return 是否为空
     */
    public static boolean isEmpty(Map<?, ?> map) {
        return null == map || map.isEmpty();
    }

    /**
     * Map是否为非空
     *
     * @param map 集合
     * @return 是否为非空
     */
    public static boolean isNotEmpty(Map<?, ?> map) {
        return null != map && !map.isEmpty();
    }
}
