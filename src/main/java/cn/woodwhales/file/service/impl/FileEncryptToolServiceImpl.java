package cn.woodwhales.file.service.impl;

import cn.woodwhales.common.file.FileEncryptTool;
import cn.woodwhales.file.service.FileEncryptToolService;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

/**
 * @author woodwhales on 2021-10-06 23:20
 */
@Service
public class FileEncryptToolServiceImpl implements FileEncryptToolService {

    @Override
    public boolean decode(List<File> files) {
        files.stream().forEach(file -> FileEncryptTool.decodeFile(file.getAbsolutePath()));
        return true;
    }

    @Override
    public boolean encode(List<File> files) {
        files.stream().forEach(file -> FileEncryptTool.encodeFileToPng(file.getAbsolutePath()));
        return true;
    }
}
