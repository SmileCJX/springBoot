package com.caijx.exception;

/**
 * Created by Administrator on 2017/9/5/005.
 */

import com.caijx.enums.ResultEnum;

/**
 * Spring抛出Exception是不会进行事务回滚的
 */
public class GirlException extends RuntimeException {

    private Integer code;

    public GirlException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
