package com.xby.VO;

import lombok.Data;

import java.io.Serializable;

/**
 * @author :xby
 * @date :2019/1/23 15:50
 * @description :http请求返回最外层对象
 */
@Data
public class ResultVO<T> implements Serializable {

    private static final long serialVersionUID = 7115059143718562604L;

    /** 错误码 */
    private Integer code;
    /** 提示信息 */
    private String msg;
    /** 具体内容 */
    private T data;
}
