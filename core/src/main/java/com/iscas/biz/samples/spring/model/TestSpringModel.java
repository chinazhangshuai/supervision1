package com.iscas.biz.samples.spring.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 *
 * @author zhuquanwen
 * @vesion 1.0
 * @date 2021/1/7 10:14
 * @since jdk1.8
 */
@ApiModel("测试spring-model")
@Data
public class TestSpringModel {
    @ApiModelProperty("名字")
    private String name;
    @ApiModelProperty("年龄")
    private Integer age;
    @ApiModelProperty("电话")
    private String tel;
}
