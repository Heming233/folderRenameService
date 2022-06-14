package com.folderRename.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
/**
 * 响应体实体，统一返回格式
 *
 * @author Heming233
 * @version v1.0
 */
public class ResponseData {
    private Integer code;//响应状态码
    private String msg;//响应信息
    private String error;//异常信息
    private Object object;//响应数据
}
