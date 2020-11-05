package com.transample.demo.common;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import org.springframework.http.HttpStatus;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>响应结果包装类</p>
 *
 */
public class ResponseResult  {

    /**
     * 响应结果状态码
     */
    private  Integer status;

    /**
     * 响应结果消息
     */
    private  String message;

    /**
     * 响应结果对应的（包含）的数据，空的话不反序列话
     */
    @JsonInclude(value = Include.NON_NULL)
    private  Object data;

    public List<String> getIndexes() {
        return indexes;
    }

    public void setIndexes(List<String> indexes) {
        this.indexes = indexes;
    }

    @JsonInclude(value = Include.NON_NULL)
    private List<String> indexes;
    /**
     * 响应时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private  Date timeStamp = new Date();

    public ResponseResult() {
        this.status = null;
        this.message = null;
        this.data = null;
    }

    public ResponseResult(Integer status, String message) {
        this.status = status;
        this.message = message;
        this.data = null;
    }

    public ResponseResult(Integer status ,String message,Object data){
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public ResponseResult(ResultCode resultCode, String message){
        this.status = resultCode.getCode();
        this.message = message;
    }
    public ResponseResult(Integer status , String message, Object data, List<String> indexes){
        this.status = status;
        this.message = message;
        this.data = data;
        this.indexes = indexes;
    }

    /**
     * 默认成功返回的实例
     * @param data
     */
    private ResponseResult(Object data){
        this.status = ResultCode.OK.getCode();
        this.message = ResultCode.OK.getName();
        this.data = data;
    }
    /**
     * 成功返回结果与指标的实例
     * @param data
     */
    private ResponseResult(Object data,List<String> indexes){
        this.status = ResultCode.OK.getCode();
        this.message = ResultCode.OK.getName();
        this.data = data;
        this.indexes = indexes;
    }

    private ResponseResult(ResultCode code){
        this.status = code.getCode();
        this.message = code.getName();
        this.data = null;
    }

    public Integer getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public Object getData() {
        return data;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public static ResponseResult ok(Object data){
        return new ResponseResult(data);
    }
    public static ResponseResult ok(Object data,List<String> indexes){
        return new ResponseResult(data,indexes);
    }
    public static ResponseResult fail(ResultCode code){
        return new ResponseResult(code);
    }

    public static ResponseResult fail(String message){
        return new ResponseResult(HttpStatus.BAD_REQUEST.value(),"失败",message);
    }


}
