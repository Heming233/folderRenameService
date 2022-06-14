package com.folderRename.service.impl;

import com.folderRename.mapper.fileMapper;
import com.folderRename.service.fileRenameService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author Heming233
 * @version v1.0
 */

@Service
public class fileRenameServiceImpl implements fileRenameService {

    @Resource
    fileMapper fileMapper;

    @Override
    public String renameOperation(List<File> fileList , List<String> nameList){
        try{
            Iterator<String> iter = nameList.iterator();
            String filePath=null;
            boolean result=true;
            for(File file : fileList){
                filePath = file.getAbsolutePath();
                result=file.renameTo(new File(filePath+iter.next()));
            }
            if(result){
                return "200";
            }
            else{
                return "400";
            }
        }
        catch (Exception e){
            e.printStackTrace();
            return "400";
        }
    }
}
