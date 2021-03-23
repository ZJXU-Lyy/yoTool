package core.util;

import java.util.HashSet;
import java.util.Set;

/**
 * @ProjectName: yoTool
 * @Package: core.util
 * @ClassName: BooleanUtil
 * @Description: 作用描述
 * @Author: Young
 * @CreateDate: 2021/3/23 12:45
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/3/23 12:45
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class BooleanUtil {
    private static final Set<String> TRUE_SET = new HashSet<>();

    static {
        TRUE_SET.add("true");
        TRUE_SET.add("yes");
        TRUE_SET.add("y");
        TRUE_SET.add("t");
        TRUE_SET.add("ok");
        TRUE_SET.add("1");
        TRUE_SET.add("on");
        TRUE_SET.add("是");
        TRUE_SET.add("对");
        TRUE_SET.add("真");
        TRUE_SET.add("對");
        TRUE_SET.add("√");
    }

    /**
     * 取相反值
     *
     * @param bool Boolean值
     * @return 对应反值
     */
    public static Boolean negate(Boolean bool) {
        if (bool == null) {
            return null;
        }
        return bool ? Boolean.FALSE : Boolean.TRUE;
    }
}
