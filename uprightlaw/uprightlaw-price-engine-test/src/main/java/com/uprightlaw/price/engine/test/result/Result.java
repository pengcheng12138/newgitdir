package com.uprightlaw.price.engine.test.result;

import java.io.Serializable;

/**
 * @Description
 * @Author rayyin
 * @Created 17/03/09
 * @Version 1.0
 */
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 1385455802067879550L;

    int code;
    String msg;
    T data;

    public Result(int code, String msg) {
        this.setCode(code);
        this.setMsg(msg);
    }
    
    public Result(){
    	
    }

    public int getCode() {
      return code;
    }

    public void setCode(int code) {
      this.code = code;
    }

    public String getMsg() {
      return msg;
    }

    public void setMsg(String msg) {
      this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "data=" + data +
                ", errCode=" + code +
                ", errMsg='" + msg + '\'' +
                '}';
    }
}
