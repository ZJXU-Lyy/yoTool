package com.young.core.io;

import com.young.core.io.file.FileNameUtil;
import com.young.core.io.file.PathUtil;
import com.young.core.util.URLUtil;

import java.io.File;

/**
 * @ProjectName: yoTool
 * @Package: com.young.core.io
 * @ClassName: FileUtil
 * @Description: 作用描述
 * @Author: Young
 * @CreateDate: 2021/3/26 4:31
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/3/26 4:31
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class FileUtil extends PathUtil {

    /**
     * Class文件扩展名
     */
    public static final String CLASS_EXT = FileNameUtil.EXT_CLASS;

    /**
     * Jar文件扩展名
     */
    public static final String JAR_FILE_EXT = FileNameUtil.EXT_JAR;

    /**
     * 在Jar中的路径jar的扩展名形式
     */
    public static final String JAR_PATH_EXT = ".jar!";

    /**
     * 当Path为文件形式时, path会加入一个表示文件的前缀
     */
    public static final String PATH_FILE_PRE = URLUtil.FILE_URL_PREFIX;

    /**
     * 是否为Windows环境
     *
     * @return 是否为Windows环境
     * @since 3.0.9
     */
    public static boolean isWindows() {
        return FileNameUtil.WINDOWS_SEPARATOR == File.separatorChar;
    }

}
