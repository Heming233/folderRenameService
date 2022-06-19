package com.folderRename.controller;

import com.folderRename.entity.ResponseData;
import com.folderRename.entity.fileEntity;
import com.folderRename.service.fileRenameService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.io.File;
import java.util.List;
import java.util.Map;


/**
 * @author Heming233
 * @version v1.0
 */

@Controller
@RequestMapping("/fileRename")
public class fileRenameController {
    @Resource
    fileRenameService fileRenameService;

    /**
     * 接收新文件名列表和旧文件列表
     * @return
     */
    @PostMapping("/rename")//RequestBody最多只能有一个
    public ResponseData fileRename(@RequestParam List<String> pathList , @RequestParam List<String> nameList){
        try{
            String returnMsg = fileRenameService.renameOperation(pathList,nameList);
            if(returnMsg.equals("200")){
                return new ResponseData(){{
                    setCode(200);
                    setMsg("success");
                }};
            }
            else if(returnMsg.equals("550")){
                return new ResponseData(){{
                    setCode(550);
                    setMsg("fail");
                    setError("文件不存在");
                }};
            }
            else if(returnMsg.equals("500")){
                return new ResponseData(){{
                    setCode(500);
                    setMsg("fail");
                    setError("服务器错误");
                }};
            }
            else{
                return new ResponseData(){{
                    setCode(400);
                    setMsg("fail");
                    setError("重命名失败");
                }};
            }
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseData(){{
                setCode(500);
                setMsg("fail");
                setError("系统错误");
            }};
        }
    }


}
