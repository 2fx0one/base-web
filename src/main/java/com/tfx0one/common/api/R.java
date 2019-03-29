package com.tfx0one.common.api;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.experimental.Accessors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.Serializable;

/**
 * Created by 2fx0one on 2018/6/30.
 */
@Data
@ApiModel("返回结果模型")
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class R<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final Logger log = LoggerFactory.getLogger(R.class);

    private R() {
    }

    //公共方法
    private static <T> ResponseEntity<T> commonFunc(int status, T data) {
        log.info("===ResponseEntity=== status:" + status + "  data:" + data);
        return ResponseEntity.status(status).body(data);
    }

//    private static Integer SUCCESS_CODE = 20000;
//    private static Integer ERROR_CODE = 50000;
//    public static Integer ERROR_CODE_TOKEN_INVALID = 50008; //非法的token
//
//    public static Integer ERROR_CODE_USER_NOT_EXIST = 50001; //用户不存在
//    public static Integer ERROR_CODE_USER_PASSWORD = 50002; //账号或密码错误


    public static <T> ResponseEntity<T> ok(T data) {
        return commonFunc(HttpStatus.OK.value(), data);
    }

    //如果直接传 分页对象 特殊处理 需要把数据提取放到R对象的格式中
    public static <T> ResponseEntity<Pagination<T>> ok(IPage<T> page) {
        return commonFunc(HttpStatus.OK.value(), new Pagination<>(page));
    }

    public static <T> ResponseEntity<T> status(int status, T data) {
        return commonFunc(status, data);
    }


}
