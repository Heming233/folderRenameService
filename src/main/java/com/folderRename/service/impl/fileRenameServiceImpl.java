package com.folderRename.service.impl;

import com.folderRename.mapper.fileMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Heming233
 * @version v1.0
 */

@Service
public class fileRenameServiceImpl {

    @Resource
    fileMapper fileMapper;
}
