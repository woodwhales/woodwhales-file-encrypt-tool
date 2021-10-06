package cn.woodwhales.file.service;

import java.io.File;
import java.util.List;

/**
 * @author woodwhales on 2021-10-06 23:20
 */
public interface FileEncryptToolService {

    /**
     * 解密文件
     * @param files 要解密的文件集合
     * @return 解密是否成功
     */
    boolean decode(List<File> files);

    /**
     * 加密文件
     * @param files 要加密的文件集合
     * @return 加密是否成功
     */
    boolean encode(List<File> files);
}
