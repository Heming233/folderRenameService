package com.folderRename.service;

import java.io.File;
import java.util.List;

/**
 * @author Heming233
 * @version v1.0
 */

public interface fileRenameService {

    /**
     * 重命名操作接口
     */
    String renameOperation(List<File> fileList , List<String> nameList);
}
