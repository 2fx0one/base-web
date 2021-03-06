package com.tfx0one.common.utils;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Auth 2fx0one
 * 2019/3/26 16:23
 */
@Data
@ApiModel("返回结果模型 包装IPage对象")
public class Pagination<T> {
    private List<T> list;// 当前页数据
    //总记录数
    @ApiModelProperty(value = "总记录数", position = 1)
    protected Long total;

    @ApiModelProperty(value = "总页数", position = 3)
    private Long pages;

    @ApiModelProperty(value = "当前是第几页", position = 5)
    private Long current;

    @ApiModelProperty(value = "当前页记录的条数", position = 7)
    private Long size;

    public static <T> Pagination<T> create(IPage<T> page) {
        return new Pagination<>(page);
    }

    private Pagination(IPage<T> page) {
        this.total = page.getTotal();
        this.list = page.getRecords();
        this.pages = page.getPages();
        this.size = page.getSize();
        this.current = page.getCurrent();
    }
}
